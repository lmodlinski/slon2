package com.psychogra.slon2.models.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.interfaces.RenderableInterface;

/**
 * Created by lmodlinski on 23/09/2017.
 */

abstract public class Game implements RenderableInterface
{
	protected GraphicAsset background;

	protected String music;

	protected Result result;

	public Game(GraphicAsset background, String music)
	{
		this.background = background;
		this.music = music;

		this.result = Result.IN_PROGRESS;
	}

	public abstract void run();

	public abstract void invalidate();

	@Override
	public void render(SpriteBatch batch)
	{
		batch.draw(this.getBackground().getTexture(), 0, 0);
	}

	public GraphicAsset getBackground()
	{
		return background;
	}

	public String getMusic()
	{
		return music;
	}

	public Result getResult()
	{
		return result;
	}

	public enum Result
	{
		SUCCESS, IN_PROGRESS, FAILURE
	}
}

