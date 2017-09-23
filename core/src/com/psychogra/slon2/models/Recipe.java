package com.psychogra.slon2.models;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Recipe extends GameObject
{
	protected String resultImage;

	protected ArrayList<Ingredient> ingredients;

	protected ArrayList<Rule> rules;

	public Recipe(String id, String name, String image, String positionGroup, String resultImage, ArrayList<Ingredient> ingredients, ArrayList<Rule> rules)
	{
		super(id, name, image, positionGroup);

		this.resultImage = resultImage;
		this.ingredients = ingredients;
		this.rules = rules;
	}

	public String getResultImage()
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
