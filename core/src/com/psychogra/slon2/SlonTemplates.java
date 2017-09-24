package com.psychogra.slon2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
import com.psychogra.slon2.models.rules.EqualityRule;
import com.psychogra.slon2.models.rules.Rule;
import com.psychogra.slon2.models.rules.SequenceRule;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class SlonTemplates
{
	public Game getPopeGame()
	{
		GraphicAsset stol = this.getAsset("stol", "pope_bundle/table.png");
		GraphicAsset recipe = this.getAsset("przepis", "badlogic.jpg");
		GraphicAsset ingredient = this.getAsset("skladnik", "pope_bundle/cream.PNG");
		GraphicAsset pot = this.getAsset("gar", "pope_bundle/pope.PNG");
		GraphicAsset result = this.getAsset("result", "pope_bundle/recipe_bg.jpg");

		AudioAsset sound = this.getSound("sound", "pope_bundle/sound.mp3");

		ArrayList<Ingredient> recipeList = new ArrayList<Ingredient>();
		recipeList.add(this.getIngredient("kremowka_1", new Vector2(1500, 1200), ingredient, sound, 50.0f));
		recipeList.add(this.getIngredient("kremowka_2", new Vector2(1200, 1200), ingredient, sound, 50.0f));
		recipeList.add(this.getIngredient("kremowka_3", new Vector2(900, 1200), ingredient, sound, 50.0f));

		ArrayList<Ingredient> tableList = new ArrayList<Ingredient>();
		tableList.add(this.getIngredient("kremowka_1", new Vector2(1500, 100), ingredient, sound, 50.0f));
		tableList.add(this.getIngredient("kremowka_2", new Vector2(1200, 100), ingredient, sound, 50.0f));
		tableList.add(this.getIngredient("kremowka_3", new Vector2(900, 100), ingredient, sound, 50.0f));


		return new PotGame(ingredient, sound,
				new Dish("pope_dish", "pope_dish", result, config.getCenter(),
						new Recipe("pope_recipe", "pope_recipe", recipe, new Vector2(100, 100), recipeList, this.getEqualityRules()),
						new Table("pope_table", "pope_table", stol, new Vector2(200, 200), tableList)),
				new Pot("pope_pot", "pope_pot", pot, config.getCenter(), null, sound, 10.0f));
	}

	public ArrayList<Rule> getSequenceRules()
	{
		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(new SequenceRule());

		return rules;
	}

	public ArrayList<Rule> getEqualityRules()
	{
		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(new EqualityRule());

		return rules;
	}

	public Ingredient getIngredient(String id, Vector2 position, GraphicAsset image, AudioAsset audio, float radius)
	{
		return new Ingredient(id, id, image, position, image, image, audio, audio, radius);
	}

	public GraphicAsset getAsset(String id, String path)
	{
		return new GraphicAsset(id, new Texture(path));
	}

	public AudioAsset getSound(String id, String path)
	{
		return new AudioAsset(id, Gdx.audio.newSound(Gdx.files.internal(path)));
	}
}
