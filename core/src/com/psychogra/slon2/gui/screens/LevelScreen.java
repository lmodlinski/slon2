package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
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

public class LevelScreen implements Screen
{
	private Stage stage;

	private VerticalGroup group;

	private HorizontalGroup horizontalGroup1, horizontalGroup2;

	private ImageButton level1, level2, level3, level4, level5, level6;
	private ImageButton start;
	private ImageButton next;

	private GraphicAsset background;

	public LevelScreen(SlonMain main)
	{
		SlonTemplates templates = new SlonTemplates();

		GraphicAsset start_button = templates.getAsset("main_screen_start_button", "gui/main_screen_start_button.png");
		GraphicAsset play_button = templates.getAsset("main_screen_start_button", "gui/main_screen_play_button.png");
		GraphicAsset background = templates.getAsset("main_screen_background", "gui/levels_screen_background.png");

		GraphicAsset level1Asset = templates.getAsset("main_screen_start_button", "gui/main_screen_start_button.png");
		GraphicAsset level2Asset = templates.getAsset("main_screen_start_button", "gui/main_screen_start_button.png");
		GraphicAsset otherLevelsAsset = templates.getAsset("main_screen_start_button", "gui/main_screen_play_button.png");

		//this.start = new ImageButton(new TextureRegionDrawable(new TextureRegion(start_button.getTexture())));
		//this.start.addListener(new MainScreenInputListener(main));

		//this.next = new ImageButton(new TextureRegionDrawable(new TextureRegion(play_button.getTexture())));


		this.level1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(level1Asset.getTexture())));
		this.level1.addListener(new LevelScreenInputListener(main));
		this.level2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(level2Asset.getTexture())));
		this.level2.addListener(new LevelScreenInputListener(main));
		this.level3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(otherLevelsAsset.getTexture())));
		this.level3.addListener(new LevelScreenInputListener(main));
		this.level4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(otherLevelsAsset.getTexture())));
		this.level4.addListener(new LevelScreenInputListener(main));
		this.level5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(otherLevelsAsset.getTexture())));
		this.level5.addListener(new LevelScreenInputListener(main));
		this.level6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(otherLevelsAsset.getTexture())));
		this.level6.addListener(new LevelScreenInputListener(main));

		this.group = new VerticalGroup();

		this.group.setFillParent(true);

		this.horizontalGroup1 = new HorizontalGroup();
		this.horizontalGroup1.addActor(this.level1);
		this.horizontalGroup1.addActor(this.level2);
		this.horizontalGroup1.addActor(this.level3);
		float padding = 100.0f;
		this.group.addActor(this.horizontalGroup1);
		this.horizontalGroup1.space(padding);

		this.horizontalGroup2 = new HorizontalGroup();
		this.horizontalGroup2.addActor(this.level4);
		this.horizontalGroup2.addActor(this.level5);
		this.horizontalGroup2.addActor(this.level6);

		this.group.addActor(this.horizontalGroup2);
		this.horizontalGroup2.space(padding);
		this.group.space(padding);


		//this.group.addActor(this.start);
		//this.group.addActor(this.next);
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

	private class LevelScreenInputListener extends InputListener
	{
		private SlonMain main;

		public LevelScreenInputListener(SlonMain main)
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
			if (event.getListenerActor().equals(level1)) {
				this.main.setScreen(new GameScreen(this.main));
			} else if (event.getListenerActor().equals(level2)) {

			} else {

			}
		}


	}
}
