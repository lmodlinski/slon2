package com.psychogra.slon2.models;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.config;
import com.psychogra.slon2.gui.Drag;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Ingredient;

/**
 * Created by Marcel on 2017-09-23.
 */

public class PotGameInputAdapter extends InputAdapter
{
	private PotGame game;
	private Drag drag;

	public PotGameInputAdapter(PotGame game)
	{
		this.game = game;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		drag = new Drag(100.0f, new Vector2(x, config.height - y));
		Ingredient held = this.game.closest(drag);
		if (held != null) {
			drag.setGameObject(held);

		}
		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button)
	{
		if (drag.getGameObject() != null) {
			boolean droppedIt = this.game.drop(drag.getGameObject());
			if (!droppedIt) {
				drag.getGameObject().setPosition(drag.getPosition());
			}
			drag.releaseGameObject();

		}
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer)
	{

		if (drag.getGameObject() != null) {
			GameObject object = drag.getGameObject();
			object.setPosition(new Vector2(x, config.height - y));
		}
		return true;
	}
}
