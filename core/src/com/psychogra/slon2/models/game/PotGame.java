package com.psychogra.slon2.models.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.PotGameInputProcessor;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class PotGame extends Game
{
	protected Dish dish;

	protected Pot pot;

	protected ArrayList<Ingredient> progress;

	private PotGameInputProcessor input;

	public PotGame(GraphicAsset background,
				   AudioAsset music,
				   Dish dish,
				   Pot pot)
	{
		super(background, music);

		this.dish = dish;
		this.pot = pot;

		this.input = new PotGameInputProcessor();
		this.input.initInputInGame(this);
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

		Dish dish = this.getDish();
		Table table = dish.getTable();

		batch.draw(
				table.getImage().getTexture(),
				table.getCenteredPosition().x,
				table.getCenteredPosition().y
		);

		this.pot.render(batch);

		for (Ingredient ingredient : this.getDish().getTable().getIngredients()) {
			batch.draw(
					ingredient.getImage().getTexture(),
					ingredient.getCenteredPosition().x,
					ingredient.getCenteredPosition().y
			);
		}

		Recipe recipe = dish.getRecipe();
		batch.draw(
				recipe.getImage().getTexture(),
				recipe.getCenteredPosition().x,
				recipe.getCenteredPosition().y
		);

		for (Ingredient ingredient : this.getDish().getRecipe().getIngredients()) {
			if (-1 == this.getProgress().indexOf(ingredient)) {
				batch.draw(
						ingredient.getImage().getTexture(),
						ingredient.getCenteredPosition().x,
						ingredient.getCenteredPosition().y
				);
			}
		}

		if (this.getResult() == Result.SUCCESS) {
			batch.draw(
					dish.getImage().getTexture(),
					dish.getCenteredPosition().x,
					dish.getCenteredPosition().y
			);
		}
	}

	public boolean drop(Ingredient ingredient)
	{
		if (ingredient.collisionWith(this.getPot())) {
			ArrayList<Ingredient> copy = new ArrayList<Ingredient>(this.getProgress());
			copy.add(ingredient);

			if (this.getDish().getRecipe().isValid(copy)) {
				this.getProgress().add(ingredient);
				this.getDish().getTable().drop(ingredient);
				this.invalidate();

				return true;
			}
		}

		return false;
	}

	public Ingredient closest(CollisionInterface drag)
	{
		Ingredient closest = null;

		for (Ingredient ingredient : this.getDish().getTable().getIngredients()) {
			if (drag.collisionWith(ingredient)) {
				if (null != closest && drag.getPosition().dst(ingredient.getCenteredPosition()) < closest.getCenteredPosition().dst(ingredient.getCenteredPosition())) {
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
