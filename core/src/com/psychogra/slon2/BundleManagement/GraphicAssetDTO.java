package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.graphics.Texture;

public class GraphicAssetDTO {

    private String id;
    private Texture texture;

    public GraphicAssetDTO(String id, Texture texture) {
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
