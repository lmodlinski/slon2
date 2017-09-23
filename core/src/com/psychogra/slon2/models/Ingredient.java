package com.psychogra.slon2.models;

import com.psychogra.slon2.BundleManagement.GraphicAssetDTO;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Ingredient extends GameObject
{
	private GraphicAssetDTO inGameImage;

	private GraphicAssetDTO droppedImage;

	private String droppingSound;

	private String draggingSound;

	public Ingredient(String id, String name, GraphicAssetDTO image, String positionGroup, GraphicAssetDTO inGameImage, GraphicAssetDTO droppedImage, String droppingSound, String draggingSound)
	{
		super(id, name, image, positionGroup);
		this.inGameImage = inGameImage;
		this.droppedImage = droppedImage;
		this.droppingSound = droppingSound;
		this.draggingSound = draggingSound;
	}

	public GraphicAssetDTO getInGameImage()
	{
		return inGameImage;
	}

	public GraphicAssetDTO getDroppedImage()
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
