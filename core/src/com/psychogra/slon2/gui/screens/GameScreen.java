package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.psychogra.slon2.BundleManagement.BundleDTO;
import com.psychogra.slon2.BundleManagement.BundleManager;
import com.psychogra.slon2.SlonMain;
import com.psychogra.slon2.config;
import com.psychogra.slon2.models.factory.GameFactory;
import com.psychogra.slon2.models.game.Game;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.rules.EqualityRule;
import com.psychogra.slon2.models.rules.Rule;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class GameScreen implements Screen
{
	private SlonMain main;
	private SpriteBatch batch;

	private Stage stage;
	private InputMultiplexer stage_multiplexer;

	private Game game;

	public GameScreen(SlonMain main, Rule rule, int index)
	{
		this.main = main;

		this.batch = new SpriteBatch();
		this.stage = new Stage(new ScreenViewport());

		config.setSize(
				this.stage.getWidth(),
				this.stage.getHeight()
		);

		BundleDTO bundle = BundleManager.deserializeBundle("bundle");
		this.game = (new GameFactory(bundle)).getGame(bundle.games[index]);
		((PotGame) this.game).getDish().getRecipe().getRules().add(rule);

		//this.game = (new SlonTemplates()).getPopeGame();
		this.game.run();

		this.stage_multiplexer = new InputMultiplexer();
		this.stage_multiplexer.addProcessor(this.stage);
		this.stage_multiplexer.addProcessor(this.game.getProcessor());
	}

	@Override
	public void show()
	{
		Gdx.input.setInputProcessor(this.stage_multiplexer);
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.checkResult();

		this.batch.begin();

		this.game.render(this.batch, delta);

		this.batch.end();

		this.stage.act();
		this.stage.draw();
	}

	private void checkResult()
	{
		switch (this.game.getResult()) {
			case EXITING:
				this.main.setScreen(new LevelScreen(this.main));
				break;
			case SUCCESS:
			case FAILURE:
			case IN_PROGRESS:
				break;
		}
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{
		this.batch.dispose();
		this.stage.dispose();
	}


}
