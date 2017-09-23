package com.psychogra.slon2.models.game;

import com.psychogra.slon2.BundleManagement.GraphicAsset;

/**
 * Created by lmodlinski on 23/09/2017.
 */

abstract public class Game
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

