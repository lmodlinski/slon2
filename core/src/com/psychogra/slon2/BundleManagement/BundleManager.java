package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.XmlReader;
import com.psychogra.slon2.models.pot.Dish;
import com.sun.org.apache.xpath.internal.functions.Function;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BundleManager {

    private String path;
    private BundleDTO bundle;

    private BundleManager(String path){
        this.path = path;
    }

    public static BundleDTO deserializeBundle(String path){

        try {
            Gdx.app.log("BundleManager", "Run this shit.");
            InputStream stream = Gdx.files.internal(path + "/model.xml").read();
            BundleDTO bundle = deserializeBundle(path, stream);
            stream.close();
            return bundle;
        } catch (FileNotFoundException exception){
            Gdx.app.log("BundleManager", "File not found.");
        } catch (IOException exception){
            Gdx.app.log("BundleManager", "Some fucking error.");
        }
        return null;
    }

    private static BundleDTO deserializeBundle(String path, InputStream data) throws IOException{

        XmlReader reader = new XmlReader();
        XmlReader.Element element = reader.parse(data);
        return new BundleManager(path).getBundle(element);
    }

    private BundleDTO getBundle(XmlReader.Element element){

        bundle = new BundleDTO();
        bundle.name = element.get("name");

        bundle.graphicAssetMap = getGraphicAssets(element.getChildByName("graphicAssets"));
        bundle.audioAssetMap = getAudioAssets(element.getChildByName("audioAssets"));

        bundle.games = getGames(element.getChildByName("games"));

        return bundle;
    }

    private HashMap<String, GraphicAsset> getGraphicAssets(XmlReader.Element element){

        HashMap<String, GraphicAsset> map = new HashMap<String, GraphicAsset>();
        for(int i = 0; i < element.getChildCount(); i++){
            XmlReader.Element asset = element.getChild(i);
            String id = asset.get("id");
            Texture texture = new Texture(Gdx.files.getFileHandle(path + "/" + asset.get("path"), Files.FileType.Internal));
            float x = Float.parseFloat(asset.get("x"));
            float y = Float.parseFloat(asset.get("y"));
            map.put(id, new GraphicAsset(id, texture, new Vector2(x, y)));
        }
        return map;
    }

    private HashMap<String, AudioAsset> getAudioAssets(XmlReader.Element element){

        HashMap<String, AudioAsset> map = new HashMap<String, AudioAsset>();
        for(int i = 0; i < element.getChildCount(); i++){
            XmlReader.Element asset = element.getChild(i);
            String id = asset.get("id");
            Sound sound = Gdx.audio.newSound(Gdx.files.getFileHandle(path + "/" + asset.get("path"), Files.FileType.Internal));
            map.put(id, new AudioAsset(id, sound));
        }
        return map;
    }

    private GameDTO[] getGames(XmlReader.Element element){

        int len = element.getChildCount();
        GameDTO[] games = new GameDTO[len];

        for(int i = 0; i < len; i++){
            XmlReader.Element game = element.getChild(i);
            String type = game.get("type");

            if(type.equals("PotGame"))
                games[i] = getPotGame(game);
            else{
                Gdx.app.log("BundleManager", "Nie ma gry: " + type);
                break;
            }
            GameDTO g = games[i];
            g.name = game.get("name");
            g.background = bundle.graphicAssetMap.get(game.get("background"));
            g.audio = bundle.audioAssetMap.get(game.get("audio"));
            g.scene = getScene(game.getChildByName("scene"));
        }
        return games;
    }

    private PotGameDTO getPotGame(XmlReader.Element element){
        PotGameDTO game = new PotGameDTO();
        ArrayList<DishDTO> dishes =  getArrayList(element.getChildByName("dishes"), new IConverter<DishDTO>() {
            @Override
            public DishDTO convert(XmlReader.Element element) {
                DishDTO dish = new DishDTO();
                dish.id = element.get("id");
                dish.recipId = element.get("recipId");
                dish.tableId = element.get("tableId");
                dish.recipePositions = getArrayList(
                        element.getChildByName("recipePositions"),
                        new IConverter<Vector2>() {
                    @Override
                    public Vector2 convert(XmlReader.Element element) {
                        float x = Float.parseFloat(element.get("x"));
                        float y = Float.parseFloat(element.get("y"));
                        return new Vector2(x, y);
                    }
                });
                dish.recip = getArrayList(
                        element.getChildByName("recip"),
                        new IConverter<String>() {
                            @Override
                            public String convert(XmlReader.Element element) {
                                return element.getText();
                            }
                        }
                );
                dish.table = getArrayList(
                        element.getChildByName("table"),
                        new IConverter<String>() {
                            @Override
                            public String convert(XmlReader.Element element) {
                                return element.getText();
                            }
                        }
                );
                return dish;
            }
        });
        game.dishes = dishes;
        game.potId = element.get("potId");
        return game;
    }

    private SceneDTO getScene(XmlReader.Element element){
        SceneDTO scene = new SceneDTO();
        scene.id = element.get("id");

        scene.positions = getPositions(element.getChildByName("positions"));
        scene.gameObjects = getGameObjects(element.getChildByName("gameObjects"));

        return scene;
    }

    private PositionDTO[] getPositions(XmlReader.Element element){
        int len = element.getChildCount();
        PositionDTO[] positions = new PositionDTO[len];
        for(int i = 0; i < len; i++){
            XmlReader.Element pos = element.getChild(i);
            PositionDTO position = new PositionDTO();
            position.tag = pos.get("tag");
            float x = Float.parseFloat(pos.get("x"));
            float y = Float.parseFloat(pos.get("y"));
            position.position = new Vector2(x, y);
            positions[i] = position;
        }
        return positions;
    }

    private Map<String, GameObjectDTO> getGameObjects(XmlReader.Element element){
        Map<String, GameObjectDTO> objects = new HashMap<String, GameObjectDTO>();
        for(int i = 0; i < element.getChildCount(); i++){
            GameObjectDTO gameObject = getGameObject(element.getChild(i));
            objects.put(gameObject.id, gameObject);
        }
        return objects;
    }

    private GameObjectDTO getGameObject(XmlReader.Element element){
        GameObjectDTO gameObject = new GameObjectDTO();
        gameObject.id = element.get("id");
        gameObject.name = element.get("name");
        gameObject.type = element.get("type");
        gameObject.image = bundle.graphicAssetMap.get(element.get("image"));
        gameObject.positionGroup = element.get("positionGroup");
        Map<String, String> attributes = new HashMap<String, String>();
        XmlReader.Element extras = element.getChildByName("extraAttributes");
        for(int i = 0; i < extras.getChildCount(); i++){
            XmlReader.Element pair = extras.getChild(i);
            attributes.put(pair.get("key"), pair.get("value"));
        }
        gameObject.extraAttributes = attributes;
        return gameObject;
    }

    private <T> ArrayList<T> getArrayList(XmlReader.Element element, IConverter<T> converter){
        int len = element.getChildCount();
        ArrayList<T> list = new ArrayList<T>(len);

        for(int i = 0; i < len; i++){
            list.add(converter.convert(element.getChild(i)));
        }
        return list;
    }
}
