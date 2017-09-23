package com.psychogra.slon2.BundleManagement;

import java.util.Map;

public class BundleDTO {

    public String name;

    public Map<String, GraphicAsset> graphicAssetMap;
    public Map<String, AudioAsset> audioAssetMap;

    public GameDTO[] games;
}
