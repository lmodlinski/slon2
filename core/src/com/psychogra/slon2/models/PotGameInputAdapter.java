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
		switch (this.game.getResult()) {
			case EXITING:
			case SUCCESS:
			case FAILURE:
				this.game.exit();
				break;
			case IN_PROGRESS:
				if (!this.game.hasClock() || !this.game.getClock().ticking()) {
					this.drag = new Drag(100.0f, new Vector2(x, config.height - y));
					Ingredient held = this.game.closest(this.drag);

					if (held != null) {
						this.drag.setPosition(held.getPosition());
						this.drag.setGameObject(held);
					}
					break;
				}
		}

		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button)
	{
		if (this.drag.getGameObject() != null) {
			if (!this.game.drop(this.drag.getGameObject())) {
				this.drag.setRelease(new Vector2(x, config.height - y));
				this.drag.getGameObject().setTarget(this.drag);

			} else if (null != this.game.getPot().getBulgingSoundFX()) {
				this.game.getPot().getBulgingSoundFX().getSound().play(1.0f);
			}

			this.drag.releaseGameObject();
		}

		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer)
	{
		if (this.drag.getGameObject() != null) {
			GameObject object = this.drag.getGameObject();

			object.setPosition(new Vector2(x, config.height - y));
		}

		return true;
	}
}
