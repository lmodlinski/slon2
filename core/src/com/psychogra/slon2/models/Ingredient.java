package com.psychogra.slon2.models;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Ingredient extends GameObject
{
	private String inGameImage;

	private String droppedImage;

	private String droppingSound;

	private String draggingSound;

	public Ingredient(String id, String name, String image, String positionGroup, String inGameImage, String droppedImage, String droppingSound, String draggingSound)
	{
		super(id, name, image, positionGroup);

		this.inGameImage = inGameImage;
		this.droppedImage = droppedImage;
		this.droppingSound = droppingSound;
		this.draggingSound = draggingSound;
	}

	public String getInGameImage()
	{
		return inGameImage;
	}

	public String getDroppedImage()
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
