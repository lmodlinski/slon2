package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.gui.Drag;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.interfaces.RenderableInterface;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Ingredient extends GameObject implements CollisionInterface, RenderableInterface
{
	private GraphicAsset inGameImage;

	private GraphicAsset droppedImage;

	private AudioAsset droppingSound;

	private AudioAsset draggingSound;

	private Drag target;

	private float time;

	private float radius;

	public Ingredient(String id, String name, GraphicAsset image, Vector2 positionGroup, GraphicAsset inGameImage, GraphicAsset droppedImage, AudioAsset droppingSound, AudioAsset draggingSound, float radius)
	{
		this(id, name, image, positionGroup, inGameImage, droppedImage, droppingSound, draggingSound, 0.0f, radius);
	}

	public Ingredient(String id, String name, GraphicAsset image, Vector2 positionGroup, GraphicAsset inGameImage, GraphicAsset droppedImage, AudioAsset droppingSound, AudioAsset draggingSound, float time, float radius)
	{
		super(id, name, image, positionGroup);

		this.target = null;

		this.inGameImage = inGameImage;
		this.droppedImage = droppedImage;
		this.droppingSound = droppingSound;
		this.draggingSound = draggingSound;
		this.radius = radius;
		this.time = time;
	}

	@Override
	public void render(SpriteBatch batch, float dt)
	{
		if (null != this.getTarget()) {
			if (
					10.0f >= Math.abs(this.getPosition().x - this.getTarget().getPosition().x)
							&& 10.0f >= Math.abs(this.getPosition().y - this.getTarget().getPosition().y)
					) {
				this.setPosition(this.getTarget().getPosition());

				this.target = null;
			} else {
				this.setPosition(
						new Vector2(
								this.getPosition().x + (this.getTarget().getPosition().x - this.getTarget().getRelease().x) * dt,
								this.getPosition().y + (this.getTarget().getPosition().y - this.getTarget().getRelease().y) * dt
						)
				);
			}
		}

		super.render(batch, dt);
	}

	public GraphicAsset getInGameImage()
	{
		return inGameImage;
	}

	public GraphicAsset getDroppedImage()
	{
		return droppedImage;
	}

	public AudioAsset getDroppingSound()
	{
		return droppingSound;
	}

	public AudioAsset getDraggingSound()
	{
		return draggingSound;
	}

	public void setTarget(Drag target)
	{
		this.target = target;
	}

	public Drag getTarget()
	{
		return target;
	}

	public float getTime()
	{
		return time;
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
