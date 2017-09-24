package com.psychogra.slon2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.psychogra.slon2.models.game.Game;

public class SlonMain extends ApplicationAdapter
{
	SpriteBatch batch;

	Game currentGame;

	@Override
	public void create()
	{
		config.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.batch = new SpriteBatch();
		this.currentGame = (new SlonTemplates()).getPopeGame();
		this.currentGame.run();
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.checkResult();

		this.batch.begin();
		this.currentGame.render(batch);
		this.batch.end();
	}

	private void checkResult()
	{
		switch (this.currentGame.getResult()) {
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
	public void dispose()
	{
		this.batch.dispose();
	}
}
