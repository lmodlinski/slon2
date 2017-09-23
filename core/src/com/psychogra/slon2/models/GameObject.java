package com.psychogra.slon2.models;

public abstract class GameObject
{
	private String id;

	private String name;

	private String image;

	private String positionGroup;

	public GameObject(String id, String name, String image, String positionGroup)
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

	public String getImage()
	{
		return image;
	}

	public String getPositionGroup()
	{
		return positionGroup;
	}
}
