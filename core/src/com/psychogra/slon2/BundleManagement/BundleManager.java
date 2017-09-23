package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.XmlReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BundleManager {

    private String path;
    private BundleDTO bundle;

    private BundleManager(String path){
        this.path = path;
    }

    public static void main(String[] args) throws Exception{

        deserializeBundle("bundle");
    }

    public static BundleDTO deserializeBundle(String path){

        try {
            InputStream stream = new FileInputStream(path + "/model.xml");
            deserializeBundle(path, stream);
            stream.close();
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

        return bundle;
    }

    private HashMap<String, GraphicAsset> getGraphicAssets(XmlReader.Element element){

        HashMap<String, GraphicAsset> map = new HashMap<String, GraphicAsset>();
        for(int i = 0; i < element.getChildCount(); i++){
            XmlReader.Element asset = element.getChild(i);
            String id = asset.getAttribute("id");
            Texture texture = new Texture(Gdx.files.getFileHandle(path + "/" + asset.getAttribute("path"), Files.FileType.External));
            map.put(id, new GraphicAsset(id, texture));
        }
        return map;
    }

    private HashMap<String, AudioAsset> getAudioAssets(XmlReader.Element element){

        HashMap<String, AudioAsset> map = new HashMap<String, AudioAsset>();
        for(int i = 0; i < element.getChildCount(); i++){
            XmlReader.Element asset = element.getChild(i);
            String id = asset.getAttribute("id");
            Sound sound = Gdx.audio.newSound(Gdx.files.getFileHandle(path + "/" + asset.getAttribute("path"), Files.FileType.External));
            map.put(id, new AudioAsset(id, sound));
        }
        return map;
    }

    private GameDTO[] getGames(XmlReader.Element element){

        int len = element.getChildCount();
        GameDTO[] games = new GameDTO[len];

        for(int i = 0; i < len; i++){
            XmlReader.Element game = element.getChild(i);
            String type = game.getAttribute("type");

            if(type.equals("PotGame"))
                games[i] = getPotGame(game);
            else{
                Gdx.app.log("BundleManager", "Nie ma gry: " + type);
                break;
            }
            GameDTO g = games[i];
            g.name = game.getAttribute("name");
            g.background = bundle.graphicAssetMap.get(game.getAttribute("background"));
            g.audio = bundle.audioAssetMap.get(game.getAttribute("audio"));
        }
        return games;
    }

    private PotGameDTO getPotGame(XmlReader.Element element){
        PotGameDTO game = new PotGameDTO();
        return game;
    }
}
