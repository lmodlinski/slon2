package com.psychogra.slon2.BundleManagement;

/**
 * Created by juna8001 on 23.09.2017.
 */

public class GraphicAssetDTO {

    private string id;
    private Texture texture;

    public GraphicAssetDTO(string id, Texture texture) {
        this.id = id;
        this.texture = texture;
    }

    public string getId() {
        return id;
    }

    public Texture getTexture() {
        return texture;
    }
}
