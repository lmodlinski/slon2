package com.psychogra.slon2.models;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;

/**
 * Created by lmodlinski on 23/09/2017.
 */
public class GameObject
{
	private String id;

	private String name;

	private GraphicAsset image;

	private Vector2 position;

	public GameObject(String id, String name, GraphicAsset image, Vector2 position)
	{
		this.id = id;
		this.name = name;
		this.image = image;
		this.position = position;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public GraphicAsset getImage()
	{
		return image;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public Vector2 getPosition()
	{
		return position;
	}
}
