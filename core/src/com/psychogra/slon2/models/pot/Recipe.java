package com.psychogra.slon2.models.pot;

import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.rules.Rule;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Recipe extends GameObject
{
	protected ArrayList<Ingredient> ingredients;

	protected ArrayList<Rule> rules;

	public Recipe(String id, String name, GraphicAsset image, String positionGroup, ArrayList<Ingredient> ingredients, ArrayList<Rule> rules)
	{
		super(id, name, image, positionGroup);

		this.ingredients = ingredients;
		this.rules = rules;
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
