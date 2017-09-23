package com.psychogra.slon2.gui;

import com.badlogic.gdx.math.Vector2;
import com.psychogra.slon2.models.GameObject;
import com.psychogra.slon2.models.interfaces.CollisionInterface;

/**
 * Created by Marcel on 2017-09-23.
 */

public class Drag implements CollisionInterface {
    private float radius;
    private Vector2 position;
    private GameObject object;
    public Drag(float radius, Vector2 position) {
        this.radius = radius;
        this.position = position;
    }

    public void setGameObject(GameObject obj){
        object = obj;
    }

    @Override
    public float getRadius() {
        return 0;
    }

    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public boolean collisionWith(CollisionInterface collidable) {
        return false;
    }
}
