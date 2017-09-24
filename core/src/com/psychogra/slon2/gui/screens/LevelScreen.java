package com.psychogra.slon2.gui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.SlonMain;
import com.psychogra.slon2.SlonTemplates;
import com.psychogra.slon2.models.rules.EqualityRule;
import com.psychogra.slon2.models.rules.SequenceRule;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class LevelScreen implements Screen
{
		private Stage stage;

		private VerticalGroup group;

		private HorizontalGroup horizontalGroup1,horizontalGroup2;

		private ImageButton level1,level2,level3,level4,level5,level6;
		private ImageButton start;
		private ImageButton next;

		private GraphicAsset background;

		public LevelScreen(SlonMain main)
		{
			SlonTemplates templates = new SlonTemplates();

			GraphicAsset background = templates.getAsset("main_screen_background", "gui/Ekran_wyboru_poziomu.png");
			GraphicAsset level1Asset = templates.getAsset("main_screen_start_button", "gui/Aktywny_poziom2.png");
			GraphicAsset level2Asset = templates.getAsset("main_screen_start_button", "gui/Aktywny_poziom.png");
			GraphicAsset otherLevelsAsset = templates.getAsset("main_screen_start_button", "gui/Nieaktywny_poziom.png");

			//this.start = new ImageButton(new TextureRegionDrawable(new TextureRegion(start_button.getTexture())));
			//this.start.addListener(new MainScreenInputListener(main));

			//this.next = new ImageButton(new TextureRegionDrawable(new TextureRegion(play_button.getTexture())));

            //Image napis = new Image(new TextureRegionDrawable(new TextureRegion(napisAsset.getTexture())));
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

            //this.group.addActor(napis);
            //this.group.padRight(80.0f);
            //this.group.padTop(40.0f);
            this.group.setFillParent(true);
            this.group.align(Align.right);
            this.horizontalGroup1 = new HorizontalGroup();
            this.horizontalGroup1.addActor(this.level1);
            this.horizontalGroup1.addActor(this.level2);
            this.horizontalGroup1.addActor(this.level3);
            float padding = 60.0f;
            this.group.addActor(this.horizontalGroup1);
            this.horizontalGroup1.space(padding);
            this.horizontalGroup1.padRight(60.0f);
            this.horizontalGroup1.padTop(100.0f);
/*
			this.horizontalGroup2 = new HorizontalGroup();
            this.horizontalGroup2.addActor(this.level4);
            this.horizontalGroup2.addActor(this.level5);
            this.horizontalGroup2.addActor(this.level6);

            this.group.addActor(this.horizontalGroup2);
            this.horizontalGroup2.space(padding);
            this.horizontalGroup2.padRight(250.0f);
            */
            this.group.space(padding);
            //this.group.padLeft(100.0f);


			//this.group.addActor(this.start);
			//this.group.addActor(this.next);


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
                if(event.getListenerActor().equals(level1)) {
                    this.main.setScreen(new GameScreen(this.main,new EqualityRule()));
                }else if(event.getListenerActor().equals(level2)) {
                    this.main.setScreen(new GameScreen(this.main,new SequenceRule()));
                }else {

                }
            }


		}
}
