package com.psychogra.slon2.models;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.config;
import com.psychogra.slon2.gui.Drag;
import com.psychogra.slon2.models.game.PotGame;
import com.psychogra.slon2.models.pot.Ingredient;

/**
 * Created by Marcel on 2017-09-23.
 */

public class PotGameInputProcessor  {

    public void initInputInGame(final PotGame gra){
        Gdx.input.setInputProcessor(new InputAdapter() {
            private Drag drag;

            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                drag = new Drag(100.0f, new Vector2(x, config.height - y));
                Ingredient held = gra.closest(drag);
                if(held != null){
                    drag.setGameObject(held);

                }
                return true;
            }

            @Override
            public boolean touchUp (int x, int y, int pointer, int button) {
                if(drag.getGameObject() != null) {
                    boolean droppedIt = gra.drop(drag.getGameObject());
                    if (!droppedIt) {
                        drag.getGameObject().setPosition(drag.getPosition());
                    }
                    drag.releaseGameObject();

                }
                return true;
            }
            @Override
            public boolean touchDragged (int x, int y, int pointer) {

                if(drag.getGameObject() != null){
                    GameObject object = drag.getGameObject();
                    object.setPosition(new Vector2(x, config.height - y));
                }
                return true;
            }
        });
    }


}
