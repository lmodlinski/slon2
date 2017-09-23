package com.psychogra.slon2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
import com.psychogra.slon2.models.rules.EqualityRule;
import com.psychogra.slon2.models.rules.Rule;

import java.util.ArrayList;

public class SlonMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Ingredient Obj;
    PotGame gra;
	@Override
	public void create () {



        config.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        GraphicAsset stol = new GraphicAsset("objekt",new Texture("badlogic.jpg"));
        GraphicAsset ingredient = new GraphicAsset("objekt",new Texture("ingredient.PNG"));
        GraphicAsset pot = new GraphicAsset("pot",new Texture("pot.PNG"));

		batch = new SpriteBatch();
        //Obj = new Ingredient("id","salata",ingredient,new Vector2(10,10),ingredient,ingredient,"droping","draging",50f);
        ArrayList<Ingredient> list = new ArrayList<Ingredient>();
        list.add(new Ingredient("id","salata",ingredient,new Vector2(100,10),ingredient,ingredient,"droping","draging",50f));
        list.add(new Ingredient("id2","salata1",ingredient,new Vector2(10,100),ingredient,ingredient,"droping","draging",50f));
        list.add(new Ingredient("id3","salata2",ingredient,new Vector2(10,10),ingredient,ingredient,"droping","draging",50f));
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(new EqualityRule());
        gra = new PotGame(ingredient,"asdasd",
                new Dish("id","name",ingredient,new Vector2(0,0),
                        new Recipe("id","name",stol,new Vector2(100,100),list, rules),
                        new Table("id","name",stol,new Vector2(200,200),list)),
                new Pot("id","name",pot,new Vector2( config.width*0.5f , config.height*0.5f ),null,"bulging",3.7f));
        gra.run();

	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		gra.render(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}


}
