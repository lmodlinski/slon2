package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.SlonMain;
import com.psychogra.slon2.SlonTemplates;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class MainScreen implements Screen
{
	private SlonMain main;
	private Stage stage;

	private GraphicAsset background;

	public MainScreen(SlonMain main)
	{
		GraphicAsset background = (new SlonTemplates()).getAsset("main_screen_background", "gui/main_screen_background.png");

		this.main = main;
		this.background = background;

		this.stage = new Stage(new ScreenViewport());
		this.stage.addListener(new MainScreenInputListener(main));
	}

	@Override
	public void show()
	{
		Gdx.input.setInputProcessor(this.stage);
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.stage.act(delta);
		this.stage.getBatch().begin();
		this.stage.getBatch().draw(this.background.getTexture(), 0, 0, this.stage.getWidth(), this.stage.getHeight());
		this.stage.getBatch().end();
		this.stage.draw();
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

	private class MainScreenInputListener extends InputListener
	{
		private SlonMain main;

		public MainScreenInputListener(SlonMain main)
		{
			this.main = main;
		}

		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		{
			return true;
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button)
		{
			this.main.setScreen(new LevelScreen(MainScreen.this.main));
		}
	}
}
