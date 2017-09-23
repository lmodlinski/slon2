package com.psychogra.slon2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
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

        GraphicAsset asset = new GraphicAsset("objekt",new Texture("badlogic.jpg"));
		batch = new SpriteBatch();
        Obj = new Ingredient("id","salata",asset,new Vector2(10,10),asset,asset,"droping","draging",0.5f);
        ArrayList<Ingredient> list = new ArrayList<Ingredient>();
        list.add(Obj);
        list.add(Obj);
        list.add(Obj);

        gra = new PotGame(asset,"asdasd",
                new Dish("id","name",asset,new Vector2(0,0),
                        new Recipe("id","name",asset,new Vector2(100,100),list,new ArrayList<Rule>()),
                        new Table("id","name",asset,new Vector2(200,200),list)),
                new Pot("id","name",asset,new Vector2(200,200),null,"bulging",3.7f));


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
