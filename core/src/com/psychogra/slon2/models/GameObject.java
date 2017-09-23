package com.psychogra.slon2.models;

import com.psychogra.slon2.BundleManagement.GraphicAsset;

/**
 * Created by lmodlinski on 23/09/2017.
 */
public abstract class GameObject
{
	private String id;

	private String name;

	private GraphicAsset image;

	private String positionGroup;

	public GameObject(String id, String name, GraphicAsset image, String positionGroup)
	{
		this.id = id;
		this.name = name;
		this.image = image;
		this.positionGroup = positionGroup;
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

	public String getPositionGroup()
	{
		return positionGroup;
	}
}
