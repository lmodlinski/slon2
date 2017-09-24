package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;

/**
 * Created by lmodlinski on 24/09/2017.
 */

public class Clock extends GameObject
{
	protected boolean ticking;

	public Clock(String id, String name, GraphicAsset image, Vector2 position)
	{
		super(id, name, image, position);

		this.ticking = false;
	}

	public void measure(float time)
	{
		this.ticking = true;

		(new Timer()).scheduleTask(new Timer.Task()
		{
			@Override
			public void run()
			{
				ticking = false;
			}
		}, time);
	}

	public boolean ticking()
	{
		return this.ticking;
	}
}
