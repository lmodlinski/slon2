package com.psychogra.slon2.models.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class PotGame extends Game
{
	protected Dish dish;

	protected Pot pot;

	protected ArrayList<Ingredient> progress;

	public PotGame(GraphicAsset background, String music, Dish dish, Pot pot)
	{
		super(background, music);

		this.dish = dish;
		this.pot = pot;
	}

	@Override
	public void run()
	{
		this.progress = new ArrayList<Ingredient>();
	}

	@Override
	public void invalidate()
	{
		if (this.getDish().getRecipe().isFulfilled(this.getProgress())) {
			this.result = Result.SUCCESS;
		}
	}

	@Override
	public void render(SpriteBatch batch)
	{
		super.render(batch);

		this.dish.render(batch);
		this.pot.render(batch);
	}

	public boolean drop(Ingredient ingredient)
	{
		ArrayList<Ingredient> copy = new ArrayList<Ingredient>(this.getProgress());
		copy.add(ingredient);

		if (this.getDish().getRecipe().isValid(copy)) {
			this.getProgress().add(ingredient);
			this.invalidate();

			return true;
		}

		return false;
	}

	public Ingredient closest(CollisionInterface drag)
	{
		Ingredient closest = null;

		for (Ingredient ingredient : this.getDish().getTable().getIngredients()) {
			if (drag.collisionWith(ingredient)) {
				if (null != closest && drag.getPosition().dst(ingredient.getPosition()) < closest.getPosition().dst(ingredient.getPosition())) {
					continue;
				}

				closest = ingredient;
			}
		}

		return closest;
	}

	public Dish getDish()
	{
		return dish;
	}

	public Pot getPot()
	{
		return pot;
	}

	public ArrayList<Ingredient> getProgress()
	{
		return progress;
	}
}
