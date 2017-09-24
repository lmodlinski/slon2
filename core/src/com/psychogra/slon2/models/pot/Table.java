package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Table extends GameObject
{
	protected ArrayList<Ingredient> ingredients;

	public Table(
			String id,
			String name,
			GraphicAsset image,
			Vector2 position,
			ArrayList<Ingredient> ingredients)
	{
		super(id, name, image, position);

		this.ingredients = ingredients;
	}

	@Override
	public void render(SpriteBatch batch)
	{
		super.render(batch);

		for (Ingredient ingredient : this.getIngredients()) {
			ingredient.render(batch);
		}
	}

	public void drop(Ingredient ingredient)
	{
		this.getIngredients().remove(ingredient);
	}

	public ArrayList<Ingredient> getIngredients()
	{
		return ingredients;
	}
}
