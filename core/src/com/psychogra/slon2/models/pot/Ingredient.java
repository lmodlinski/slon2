package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.interfaces.CollisionInterface;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Ingredient extends GameObject implements CollisionInterface
{
	private GraphicAsset inGameImage;

	private GraphicAsset droppedImage;

	private String droppingSound;

	private String draggingSound;

	private float radius;

	public Ingredient(String id, String name, GraphicAsset image, Vector2 positionGroup, GraphicAsset inGameImage, GraphicAsset droppedImage, String droppingSound, String draggingSound, float radius)
	{
		super(id, name, image, positionGroup);
		this.inGameImage = inGameImage;
		this.droppedImage = droppedImage;
		this.droppingSound = droppingSound;
		this.draggingSound = draggingSound;
		this.radius = radius;
	}

	public GraphicAsset getInGameImage()
	{
		return inGameImage;
	}

	public GraphicAsset getDroppedImage()
	{
		return droppedImage;
	}

	public String getDroppingSound()
	{
		return droppingSound;
	}

	public String getDraggingSound()
	{
		return draggingSound;
	}

	public float getRadius()
	{
		return radius;
	}

	@Override
	public boolean collisionWith(CollisionInterface collidable)
	{
		return this.getPosition().dst(collidable.getPosition()) <= this.getRadius() + collidable.getRadius();
	}
}
