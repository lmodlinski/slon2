package com.psychogra.slon2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Clock;
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
	public SlonTemplates()
	{
	}

	public Game getPopeGame()
	{
		GraphicAsset stol = this.getAsset("stol", "pope_bundle/table.png");
		GraphicAsset recipe = this.getAsset("przepis", "badlogic.jpg");
		GraphicAsset clock = this.getAsset("zegarek", "badlogic.jpg");
		GraphicAsset ingredient = this.getAsset("skladnik", "pope_bundle/cream.PNG");
		GraphicAsset piernik = this.getAsset("skladnik", "pope_bundle/piernik.png");
		GraphicAsset pot = this.getAsset("gar", "pope_bundle/pope.PNG");
		GraphicAsset result = this.getAsset("result", "pope_bundle/recipe_bg.jpg");

		AudioAsset sound = this.getSound("sound", "pope_bundle/beep.wav");

		ArrayList<Ingredient> recipeList = new ArrayList<Ingredient>();
		recipeList.add(this.getIngredient("kremowka_1", new Vector2(600, 900), ingredient, sound, 3.0f, 50.0f));
		recipeList.add(this.getIngredient("kremowka_2", new Vector2(1000, 900), ingredient, sound, 3.0f, 50.0f));
		recipeList.add(this.getIngredient("kremowka_3", new Vector2(1400, 900), ingredient, sound, 3.0f, 50.0f));

		ArrayList<Ingredient> tableList = new ArrayList<Ingredient>();
		tableList.add(this.getIngredient("kremowka_1", new Vector2(600, 200), ingredient, sound, 3.0f, 50.0f));
		tableList.add(this.getIngredient("kremowka_2", new Vector2(1000, 200), ingredient, sound, 3.0f, 50.0f));
		tableList.add(this.getIngredient("kremowka_3", new Vector2(1400, 200), ingredient, sound, 3.0f, 50.0f));
		tableList.add(this.getIngredient("piernik_1", new Vector2(1700, 200), piernik, sound, 0.0f, 50.0f));
		tableList.add(this.getIngredient("piernik_2", new Vector2(300, 200), piernik, sound, 0.0f, 50.0f));


		return new PotGame(ingredient, sound,
				new Dish("pope_dish", "pope_dish", result, new Vector2(1000, 650),
						new Recipe("pope_recipe", "pope_recipe", recipe, new Vector2(100, 100), recipeList, this.getSequenceRules()),
						new Table("pope_table", "pope_table", stol, new Vector2(0, 0), tableList)),
				new Pot("pope_pot", "pope_pot", pot, new Vector2(1000, 600), null, sound, 10.0f),
				new Clock("pope_timer", "pope_timer", clock, new Vector2(1000, 600))
		);
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

	public Ingredient getIngredient(String id, Vector2 position, GraphicAsset image, AudioAsset audio, float time, float radius)
	{
		return new Ingredient(id, id, image, position, image, image, audio, audio, time, radius);
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
