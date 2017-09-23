package com.psychogra.slon2.models.game;

import com.psychogra.slon2.BundleManagement.GraphicAsset;
import com.psychogra.slon2.models.pot.Ingredient;
import com.psychogra.slon2.models.pot.Pot;
import com.psychogra.slon2.models.pot.Recipe;

import java.util.ArrayList;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class PotGame extends Game
{
	protected Recipe recipe;

	protected Pot pot;

	protected ArrayList<Ingredient> progress;

	public PotGame(GraphicAsset background, String music, Recipe recipe, Pot pot)
	{
		super(background, music);

		this.recipe = recipe;
		this.pot = pot;
	}

	@Override
	public void run()
	{
		this.progress = new ArrayList<Ingredient>();
	}

	public Recipe getRecipe()
	{
		return recipe;
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
