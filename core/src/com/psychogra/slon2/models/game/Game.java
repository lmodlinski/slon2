package com.psychogra.slon2.models.game;

import com.psychogra.slon2.BundleManagement.GraphicAsset;

/**
 * Created by lmodlinski on 23/09/2017.
 */

abstract public class Game
{
	protected GraphicAsset background;

	protected String music;

	public abstract void run();
}
