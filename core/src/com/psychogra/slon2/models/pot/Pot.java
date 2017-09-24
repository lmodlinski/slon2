package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.interfaces.CollisionInterface;

import java.util.*;

/**
 * Created by Marcel on 2017-09-23.
 */
interface PotListener
{
	void onGameObjectDrop(GameObject obj);
}

public class Pot extends GameObject implements CollisionInterface
{
	private GraphicAsset cookingImages;
	private AudioAsset bulgingSoundFX;
	private float radius;

	private List<PotListener> listenerList = new ArrayList<PotListener>();

	public void addListener(PotListener toAdd)
	{
		listenerList.add(toAdd);
	}

	public void onObjectDrop(GameObject obj)
	{
		for (PotListener listener : listenerList) {
			listener.onGameObjectDrop(obj);
		}
	}

	public Pot(String id,
			   String name,
			   GraphicAsset image,
			   Vector2 positionGroup,
			   GraphicAsset cookingImage,
			   AudioAsset bulgingSoundFX,
			   float radius)
	{
		super(id, name, image, positionGroup);
		this.cookingImages = cookingImage;
		this.bulgingSoundFX = bulgingSoundFX;
		this.radius = radius;
		this.listenerList = new ArrayList<PotListener>();
	}

	public GraphicAsset getCookingImage()
	{
		return cookingImages;
	}

	public AudioAsset getBulgingSoundFX()
	{
		return bulgingSoundFX;
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
