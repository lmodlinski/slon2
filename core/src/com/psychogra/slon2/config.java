package com.psychogra.slon2;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Marcel on 2017-09-23.
 */

public class config
{
	public static float width;
	public static float height;

	public static void setSize(float newWidth, float newHeight)
	{
		width = newWidth;
		height = newHeight;
	}

	public static Vector2 getCenter()
	{
		return new Vector2(width * 0.5f, height * 0.5f);
	}

}
