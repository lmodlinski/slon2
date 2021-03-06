package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
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

	public Recipe(String id,
				  String name,
				  GraphicAsset image,
				  Vector2 positionGroup,
				  ArrayList<Ingredient> ingredients,
				  ArrayList<Rule> rules)
	{
		super(id, name, image, positionGroup);

		this.ingredients = ingredients;
		this.rules = rules;
	}

	@Override
	public void render(SpriteBatch batch, float dt)
	{
		super.render(batch, dt);

		for (Ingredient ingredient : this.ingredients) {
			ingredient.render(batch, dt);
		}
	}

	public boolean isValid(ArrayList<Ingredient> progress)
	{
		for (Rule rule : this.getRules()) {
			if (!rule.isValid(this.getIngredients(), progress)) {
				return false;
			}
		}

		return true;
	}

	public boolean isFulfilled(ArrayList<Ingredient> progress)
	{
		for (Rule rule : this.getRules()) {
			if (!rule.isFulfilled(this.getIngredients(), progress)) {
				return false;
			}
		}

		return true;
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
