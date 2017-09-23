package com.psychogra.slon2.models.pot;

import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Table extends GameObject
{
	protected ArrayList<Ingredient> ingredients;

	public Table(String id, String name, GraphicAsset image, String positionGroup, ArrayList<Ingredient> ingredients)
	{
		super(id, name, image, positionGroup);

		this.ingredients = ingredients;
	}

	public ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}
}
