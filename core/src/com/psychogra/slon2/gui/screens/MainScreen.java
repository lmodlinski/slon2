package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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

	private ImageButton start;
	private ImageButton next;

	private GraphicAsset background;

	public MainScreen(final SlonMain main)
	{
		this.main = main;

		SlonTemplates templates = new SlonTemplates();

		GraphicAsset start_button = templates.getAsset("start_button", "gui/start_button.jpg");

		this.start = new ImageButton(new TextureRegionDrawable(new TextureRegion(start_button.getTexture())));
		this.start.addListener(new InputListener()
		{
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				main.setScreen(new GameScreen());
			}
		});

		this.stage = new Stage(new ScreenViewport());
		this.stage.addActor(this.start);

		this.start.setX((this.stage.getWidth() - this.start.getWidth()) * 0.5f);
		this.start.setY((this.stage.getHeight() - this.start.getHeight()) * 0.5f);
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

		this.stage.act();
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
}
