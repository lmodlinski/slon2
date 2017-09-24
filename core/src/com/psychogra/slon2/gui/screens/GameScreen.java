package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.psychogra.slon2.SlonTemplates;
import com.psychogra.slon2.config;
import com.psychogra.slon2.models.game.Game;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class GameScreen implements Screen
{
	private SpriteBatch batch;

	private Stage stage;
	private InputMultiplexer stage_multiplexer;

	private Game game;

	public GameScreen()
	{
		this.batch = new SpriteBatch();
		this.stage = new Stage(new ScreenViewport());

		config.setSize(
				this.stage.getWidth(),
				this.stage.getHeight()
		);

//		BundleDTO bundle = BundleManager.deserializeBundle("bundle");
//		this.game = (new GameFactory(bundle)).getGame(bundle.games[0]);

		this.game = (new SlonTemplates()).getPopeGame();
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

		this.game.render(this.batch);

		this.batch.end();

		this.stage.act();
		this.stage.draw();
	}

	private void checkResult()
	{
		switch (this.game.getResult()) {
			case SUCCESS:
				Gdx.app.exit();
				break;
			case IN_PROGRESS:
				break;
			case FAILURE:
				Gdx.app.exit();
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
		this.stage.dispose();
	}


}
