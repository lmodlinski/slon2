package com.psychogra.slon2.models;

import com.psychogra.slon2.BundleManagement.GraphicAsset;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Ingredient extends GameObject
{
	private GraphicAsset inGameImage;

	private GraphicAsset droppedImage;

	private String droppingSound;

	private String draggingSound;

	public Ingredient(String id, String name, GraphicAsset image, String positionGroup, GraphicAsset inGameImage, GraphicAsset droppedImage, String droppingSound, String draggingSound)
	{
		super(id, name, image, positionGroup);
		this.inGameImage = inGameImage;
		this.droppedImage = droppedImage;
		this.droppingSound = droppingSound;
		this.draggingSound = draggingSound;
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
}
