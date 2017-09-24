package com.psychogra.slon2.models.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.psychogra.slon2.BundleManagement.AudioAsset;
import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.config;
import com.psychogra.slon2.models.PotGameInputAdapter;
import com.psychogra.slon2.models.interfaces.CollisionInterface;
import com.psychogra.slon2.models.pot.Dish;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;
import com.psychogra.slon2.models.pot.Table;
import com.psychogra.slon2.models.pot.Clock;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class PotGame extends Game
{
	protected Dish dish;

	protected Pot pot;

	protected ArrayList<Ingredient> progress;

	public PotGame(GraphicAsset background,
				   AudioAsset music,
				   Dish dish,
				   Pot pot)
	{
		super(background, music);

		this.dish = dish;
		this.pot = pot;
	}

	public PotGame(GraphicAsset background,
				   AudioAsset music,
				   Dish dish,
				   Pot pot, Clock clock)
	{
		super(background, music, clock);

		this.dish = dish;
		this.pot = pot;
	}


	@Override
	public InputProcessor getProcessor()
	{
		return new PotGameInputAdapter(this);
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
	public void render(SpriteBatch batch, float dt)
	{
		super.render(batch, dt);

		Dish dish = this.getDish();
		Table table = dish.getTable();

		GraphicAsset image = table.getImage();

		if (image != null) {
			batch.draw(
					image.getTexture(),
					0,
					0,
					config.width,
					config.height
			);
		}

		this.pot.render(batch, dt);

		this.renderTableIngredients(batch, dt);

		Recipe recipe = dish.getRecipe();
		batch.draw(
				recipe.getImage().getTexture(),
				recipe.getPosition().x,
				recipe.getPosition().y
		);

		this.renderRecipeIngredients(batch);
		this.renderResult(batch);

		if (this.hasClock() && this.getClock().ticking()) {
			this.renderClock(batch);
		}
	}

	private void renderTableIngredients(SpriteBatch batch, float dt)
	{
		for (Ingredient ingredient : this.getDish().getTable().getIngredients()) {
			ingredient.render(batch, dt);
		}
	}

	private void renderRecipeIngredients(SpriteBatch batch)
	{
		for (Ingredient ingredient : this.getDish().getRecipe().getIngredients()) {
			if (-1 == this.getProgress().indexOf(ingredient)) {
				batch.draw(
						ingredient.getImage().getTexture(),
						ingredient.getCenteredPosition().x,
						ingredient.getCenteredPosition().y
				);
			}
		}
	}

	private void renderResult(SpriteBatch batch)
	{
		if (this.getResult() == Result.SUCCESS) {
			batch.draw(
					this.getDish().getImage().getTexture(),
					this.getDish().getCenteredPosition().x,
					this.getDish().getCenteredPosition().y
			);
		}
	}

	private void renderClock(SpriteBatch batch)
	{
		batch.draw(
				this.getClock().getImage().getTexture(),
				this.getClock().getPosition().x,
				this.getClock().getPosition().y
		);
	}

	public boolean drop(Ingredient ingredient)
	{
		if (ingredient.collisionWith(this.getPot()) && (!this.hasClock() || !this.getClock().ticking())) {
			ArrayList<Ingredient> copy = new ArrayList<Ingredient>(this.getProgress());
			copy.add(ingredient);

			if (this.getDish().getRecipe().isValid(copy)) {
				this.getProgress().add(ingredient);
				this.getDish().getTable().drop(ingredient);

				if (this.hasClock() && 0 < ingredient.getTime()) {
					this.getClock().measure(ingredient.getTime());
				}

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

	public void exit()
	{
		this.result = Result.EXITING;
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
