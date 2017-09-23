package com.psychogra.slon2.models.interfaces;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public interface CollisionInterface
{
	public float getRadius();

	public Vector2 getPosition();

	public boolean collisionWith(CollisionInterface collidable);
}
