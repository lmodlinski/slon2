package com.psychogra.slon2.models.factory;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.BundleDTO;
import com.psychogra.slon2.BundleManagement.GameDTO;
import com.psychogra.slon2.BundleManagement.GameObjectDTO;
import com.psychogra.slon2.BundleManagement.PotGameDTO;
import com.psychogra.slon2.BundleManagement.SceneDTO;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class GameFactory
{
	public Game createGame(GameDTO dto)
	{
		if (dto instanceof PotGameDTO) {
			return this.createPotGame((PotGameDTO) dto);
		} else {
			return null;
		}
	}

	public PotGame createPotGame(PotGameDTO dto)
	{
		List<GameObject> recipeIngredients = new ArrayList<GameObject>();
		Iterator<String> recipeIngredientsKeysIterator = dto.scene.gameObjects.keySet().iterator();

		while (recipeIngredientsKeysIterator.hasNext()) {
			recipeIngredients.add(this.createIngredient(dto));
		}

		PotGame game = new PotGame(
				dto.background,
				dto.name,
				new Dish(
						"default_fish",
						"default_dish_name",
						dto.background,
						this.createRandomPosition(),
						new Recipe(
								"default_recipe",
								"default_recipe_name",
								dto.background,
								this.createRandomPosition(),

								)
				)
		);
	}

	public Ingredient createIngredient(BundleDTO superContext, SceneDTO context, GameObjectDTO dto)
	{
		if ("Ingredient".equals(dto.type)) {
			return new Ingredient(dto.id, dto.name, dto.image, this.createRandomPosition(),
					superContext.graphicAssetMap.get("zwloki"),
					superContext.graphicAssetMap.get("zwloki"),
					"default_sound",
					"default_sound",
					100.0f
			);
		} else {

		}
	}

	public Vector2 createRandomPosition()
	{
		return new Vector2(
				(int) (Math.random() * 150),
				(int) (Math.random() * 150)
		);
	}
}
