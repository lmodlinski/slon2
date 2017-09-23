package com.psychogra.slon2.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.interfaces.RenderableInterface;

/**
 * Created by lmodlinski on 23/09/2017.
 */
public class GameObject implements RenderableInterface
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

	@Override
	public void render(SpriteBatch batch)
	{
		batch.draw(this.getImage().getTexture(), this.getPosition().x, this.getPosition().y);
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
