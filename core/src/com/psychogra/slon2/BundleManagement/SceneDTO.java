package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.math.Vector2;
import com.sun.xml.internal.ws.dump.LoggingDumpTube;

import java.util.Map;

public class SceneDTO {

    public String id;
    public PositionDTO[] positions;
    public Map<String, GameObjectDTO> gameObjects;
}
