package com.psychogra.slon2.models;

import com.psychogra.slon2.BundleManagement.GraphicAssetDTO;
import com.psychogra.slon2.models.rules.Rule;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Recipe extends GameObject
{
	protected GraphicAssetDTO resultImage;

	protected ArrayList<Ingredient> ingredients;

	protected ArrayList<Rule> rules;

	public Recipe(String id, String name, GraphicAssetDTO image, String positionGroup, GraphicAssetDTO resultImage, ArrayList<Ingredient> ingredients, ArrayList<Rule> rules)
	{
		super(id, name, image, positionGroup);
		this.resultImage = resultImage;
		this.ingredients = ingredients;
		this.rules = rules;
	}

	public GraphicAssetDTO getResultImage()
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
