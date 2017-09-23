package com.psychogra.slon2.gui;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.pot.Ingredient;

/**
 * Created by Marcel on 2017-09-23.
 */

public class Drag implements CollisionInterface
{
	private float radius;
	private Vector2 position;
	private Ingredient object;

	public Drag(float radius, Vector2 position)
	{
		this.radius = radius;
		this.position = position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	public void releaseGameObject(){
		this.object = null;
	}
	public Ingredient getGameObject(){
		return this.object;
	}

	public void setGameObject(Ingredient obj)
	{
		this.object = obj;
	}

	@Override
	public float getRadius()
	{
		return this.radius;
	}

	@Override
	public Vector2 getPosition()
	{
		return this.position;
	}

	@Override
	public boolean collisionWith(CollisionInterface collidable)
	{
		return this.getPosition().dst(collidable.getPosition()) <= this.getRadius() + collidable.getRadius();
	}
}
