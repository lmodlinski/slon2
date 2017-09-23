package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GraphicAsset {

    private String id;
    private Texture texture;
    private Vector2 normalizedSize;

    public GraphicAsset(String id, Texture texture, Vector2 normalizedSize) {
        this.id = id;
        this.texture = texture;
        this.normalizedSize = normalizedSize;
    }

    public String getId() {
        return id;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getNormalizedSize(){
        return normalizedSize;
    }
}
