package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.SlonMain;
import com.psychogra.slon2.SlonTemplates;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class MainScreen implements Screen
{
	private Stage stage;
	private SlonMain slonMain;
	private VerticalGroup group;

	private ImageButton start;
	private ImageButton next;

	private GraphicAsset background;

	public MainScreen(SlonMain main)
	{
		this.slonMain = main;
		SlonTemplates templates = new SlonTemplates();

		GraphicAsset start_button = templates.getAsset("main_screen_start_button", "gui/main_screen_start_button.png");
		GraphicAsset play_button = templates.getAsset("main_screen_start_button", "gui/main_screen_play_button.png");
		GraphicAsset background = templates.getAsset("main_screen_background", "gui/main_screen_background.jpg");

		this.start = new ImageButton(new TextureRegionDrawable(new TextureRegion(start_button.getTexture())));
		this.start.addListener(new MainScreenInputListener(main));

		this.next = new ImageButton(new TextureRegionDrawable(new TextureRegion(play_button.getTexture())));

		this.group = new VerticalGroup();
		this.group.setFillParent(true);
		this.group.addActor(this.start);
		this.group.addActor(this.next);
		this.group.align(Align.center);

		this.background = background;

		this.stage = new Stage(new ScreenViewport());
		this.stage.addActor(this.group);
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
			this.main.setScreen(new LevelScreen(slonMain));
		}
	}
}
