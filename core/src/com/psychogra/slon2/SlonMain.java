package com.psychogra.slon2;

import com.badlogic.gdx.Game;
import com.psychogra.slon2.gui.screens.LevelScreen;
import com.psychogra.slon2.gui.screens.MainScreen;

public class SlonMain extends Game
{
	@Override
	public void create()
	{
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render()
	{
		super.render();
	}
}
