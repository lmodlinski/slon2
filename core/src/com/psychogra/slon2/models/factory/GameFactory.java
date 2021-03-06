package com.psychogra.slon2.models.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.BundleDTO;
import com.psychogra.slon2.BundleManagement.DishDTO;
import com.psychogra.slon2.BundleManagement.GameDTO;
import com.psychogra.slon2.BundleManagement.GameObjectDTO;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.BundleManagement.PositionDTO;
import com.psychogra.slon2.BundleManagement.PotGameDTO;
import com.psychogra.slon2.BundleManagement.SceneDTO;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Clock;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
import com.psychogra.slon2.models.rules.Rule;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class GameFactory
{
	private BundleDTO bundle;

	public GameFactory(BundleDTO bundle){
		this.bundle = bundle;
	}

	public Game getGame(GameDTO gameDTO){

		Game game = null;

		if(gameDTO instanceof PotGameDTO){
			game = getPotGame((PotGameDTO) gameDTO);
		}

		if(game != null){
			/* DONE */
		}

		return game;
	}

	private PotGame getPotGame(PotGameDTO dto){
		GraphicAsset clock = new GraphicAsset("clock", new Texture("bundle/Czekajka.png"));

		return new PotGame(
				dto.background,
				dto.audio,
				getDish(dto.dishes.get(0), dto.scene),
				getPot(dto.scene.gameObjects.get(dto.potId), dto.scene),
				new Clock("pope_timer", "pope_timer", clock, new Vector2(0, 0))
		);
	}
	private Dish getDish(DishDTO dto, SceneDTO scene){

		GameObjectDTO go = scene.gameObjects.get(dto.id);
		return new Dish(
				dto.id,
				go.name,
				go.image,
				getPosition(go.positionGroup, scene),
				getRecipe(dto, scene),
				getTable(dto, scene)
		);
	}
	private Recipe getRecipe(DishDTO dto, SceneDTO scene){
		ArrayList<Vector2> positions = new ArrayList<Vector2>(dto.recipePositions);
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		for(String id: dto.recip){
			ingredients.add(getRecipeIngredient(scene.gameObjects.get(id), positions));
		}
		GameObjectDTO recipeDTO = scene.gameObjects.get(dto.recipId);
		return new Recipe(
				recipeDTO.id,
				recipeDTO.name,
				recipeDTO.image,
				getPosition(recipeDTO.positionGroup, scene),
				ingredients,
				new ArrayList<Rule>()
		);
	}

	private Ingredient getRecipeIngredient(GameObjectDTO go, ArrayList<Vector2> allowedPossitions){
		Ingredient ingredient = new Ingredient(
				go.id,
				go.name,
				go.image,
				getPosition(allowedPossitions),
				getGraphicAsset(go.extraAttributes.get("inGameImage")),
				getGraphicAsset(go.extraAttributes.get("droppedImage")),
				getSoundAsset(go.extraAttributes.get("droppingSound")),
				getSoundAsset(go.extraAttributes.get("draggingSound")),
				-1000000
		);
		return ingredient;
	}

	private Table getTable(DishDTO dto, SceneDTO scene){
		ArrayList<PositionDTO> allowedPositions = new ArrayList<PositionDTO>(Arrays.asList(scene.positions));
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		for(String id: dto.table){
			ingredients.add(getIngredient(scene.gameObjects.get(id), allowedPositions));
		}
		GameObjectDTO tableDTO = scene.gameObjects.get(dto.tableId);
		return new Table(
				tableDTO.id,
				tableDTO.name,
				tableDTO.image,
				getPosition(tableDTO.positionGroup, allowedPositions),
				ingredients
		);
	}

	private Ingredient getIngredient(GameObjectDTO go, ArrayList<PositionDTO> allowedPossitions){

		Ingredient ingredient = new Ingredient(
				go.id,
				go.name,
				go.image,
				getPosition(go.positionGroup, allowedPossitions),
				getGraphicAsset(go.extraAttributes.get("inGameImage")),
				getGraphicAsset(go.extraAttributes.get("droppedImage")),
				getSoundAsset(go.extraAttributes.get("droppingSound")),
				getSoundAsset(go.extraAttributes.get("draggingSound")),
				Float.parseFloat(go.extraAttributes.get("time")),
				Float.parseFloat(go.extraAttributes.get("radius"))
		);
		return ingredient;
	}

	private Pot getPot(GameObjectDTO go, SceneDTO scene){

		Pot pot = new Pot(
				go.id,
				go.name,
				go.image,
				getPosition(go.positionGroup, scene),
				getGraphicAsset(go.extraAttributes.get("cookigImage")),
				getSoundAsset(go.extraAttributes.get("bulgingSoundFX")),
				Float.parseFloat(go.extraAttributes.get("radius"))
		);
		return pot;
	}

	private GraphicAsset getGraphicAsset(String id){
		return bundle.graphicAssetMap.get(id);
	}
	private AudioAsset getSoundAsset(String id){
		return bundle.audioAssetMap.get(id);
	}
	private Vector2 getPosition(String tag, ArrayList<PositionDTO> positions){

		int len = positions.size();
		for(int i = 0; i < len; i++){
			if(tag.equals(positions.get(i).tag)){
				return positions.remove(i).position;
			}
		}
		Gdx.app.log("Factory_array", "No more positions of: " + tag);
		return null;
	}

	private Vector2 getPosition(ArrayList<Vector2> positions){

		return positions.remove(0);
	}

	private  Vector2 getPosition(String tag, SceneDTO scene){
		for(PositionDTO pos: scene.positions){
			if(pos.tag.equals(tag))
				return pos.position;
		}
		Gdx.app.log("Factory_scene", "No more positions of: " + tag);
		return null;
	}
}
