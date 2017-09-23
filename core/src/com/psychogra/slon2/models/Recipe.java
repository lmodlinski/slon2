package com.psychogra.slon2.models;

import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.rules.Rule;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Recipe extends GameObject
{
	protected GraphicAsset resultImage;

	protected ArrayList<Ingredient> ingredients;

	protected ArrayList<Rule> rules;

	public Recipe(String id, String name, GraphicAsset image, String positionGroup, GraphicAsset resultImage, ArrayList<Ingredient> ingredients, ArrayList<Rule> rules)
	{
		super(id, name, image, positionGroup);
		this.resultImage = resultImage;
		this.ingredients = ingredients;
		this.rules = rules;
	}

	public GraphicAsset getResultImage()
	{
		return resultImage;
	}

	public ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}

	public ArrayList<Rule> getRules()
	{
		return rules;
	}
}
