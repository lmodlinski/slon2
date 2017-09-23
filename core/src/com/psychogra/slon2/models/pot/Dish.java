package com.psychogra.slon2.models.pot;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.GameObject;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class Dish extends GameObject
{
	protected Recipe recipe;

	protected Table table;

	public Dish(String id, String name, GraphicAsset image, Vector2 positionGroup, Recipe recipe, Table table)
	{
		super(id, name, image, positionGroup);

		this.recipe = recipe;
		this.table = table;
	}

	@Override
	public void render(SpriteBatch batch)
	{
		this.table.render(batch);
		this.recipe.render(batch);
	}

	public Recipe getRecipe()
	{
		return recipe;
	}

	public Table getTable()
	{
		return table;
	}
}
