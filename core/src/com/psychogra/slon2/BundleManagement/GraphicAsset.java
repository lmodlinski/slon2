package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.graphics.Texture;

public class GraphicAsset {

    private String id;
    private Texture texture;

    public GraphicAsset(String id, Texture texture) {
        this.id = id;
        this.texture = texture;
    }

    public String getId() {
        return id;
    }

    public Texture getTexture() {
        return texture;
    }
}
