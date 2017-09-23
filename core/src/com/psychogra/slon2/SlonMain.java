package com.psychogra.slon2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
import com.psychogra.slon2.models.rules.Rule;
import com.psychogra.slon2.models.rules.SequenceRule;

import java.util.ArrayList;

public class SlonMain extends ApplicationAdapter
{
	SpriteBatch batch;
	PotGame gra;

	@Override
	public void create()
	{
		config.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		GraphicAsset stol = new GraphicAsset("objekt", new Texture("badlogic.jpg"));
		GraphicAsset ingredient = new GraphicAsset("objekt", new Texture("ingredient.PNG"));
		GraphicAsset pot = new GraphicAsset("pot", new Texture("pot.PNG"));

		batch = new SpriteBatch();
		ArrayList<Ingredient> recipeList = new ArrayList<Ingredient>();
		recipeList.add(new Ingredient("id", "salata", ingredient, new Vector2(1500, 1200), ingredient, ingredient, "droping", "draging", 50f));
		recipeList.add(new Ingredient("id2", "salata1", ingredient, new Vector2(1200, 1200), ingredient, ingredient, "droping", "draging", 50f));
		recipeList.add(new Ingredient("id3", "salata2", ingredient, new Vector2(900, 1200), ingredient, ingredient, "droping", "draging", 50f));

		ArrayList<Ingredient> tableList = new ArrayList<Ingredient>();
		tableList.add(new Ingredient("id", "salata", ingredient, new Vector2(1500, 100), ingredient, ingredient, "droping", "draging", 50f));
		tableList.add(new Ingredient("id2", "salata1", ingredient, new Vector2(1200, 100), ingredient, ingredient, "droping", "draging", 50f));
		tableList.add(new Ingredient("id3", "salata2", ingredient, new Vector2(900, 100), ingredient, ingredient, "droping", "draging", 50f));


		ArrayList<Rule> rules = new ArrayList<Rule>();
		rules.add(new SequenceRule());

		gra = new PotGame(ingredient, "asdasd",
				new Dish("id", "name", stol, new Vector2(config.width * 0.5f, config.height * 0.5f),
						new Recipe("id", "name", stol, new Vector2(100, 100), recipeList, rules),
						new Table("id", "name", stol, new Vector2(200, 200), tableList)),
				new Pot("id", "name", pot, new Vector2(config.width * 0.5f, config.height * 0.5f), null, "bulging", 3.7f));
		gra.run();

	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (this.gra.getResult() == Game.Result.SUCCESS || this.gra.getResult() == Game.Result.FAILURE) {
			Gdx.app.exit();
		}

		batch.begin();
		gra.render(batch);
		batch.end();
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
