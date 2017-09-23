package com.psychogra.slon2.models;
import com.psychogra.slon2.BundleManagement.GraphicAsset;

import java.awt.Graphics;
import java.util.*;

/**
 * Created by Marcel on 2017-09-23.
 */
interface  Listener{
    void onGameObjectDrop(GameObject obj);
}

public class Container extends GameObject {

    private GraphicAsset inGameImage;
    private GraphicAsset cookingImages;
    private String bulgingSoundFX;

    private List<Listener> listenerList = new ArrayList<Listener>();

    public void addListener(Listener toAdd) {
        listenerList.add(toAdd);
    }

    public void onObjectDrop(GameObject obj) {
        for (Listener listener : listenerList)
            listener.onGameObjectDrop(obj);
    }
    public Container(String id, String name, GraphicAsset image, String positionGroup, GraphicAsset CookingImages, GraphicAsset InGameImage, String BulgingSoundFX){
        super(id, name, image, positionGroup);
        this.cookingImages = CookingImages;
        this.inGameImage = InGameImage;
        this.cookingImages = CookingImages;
        this.bulgingSoundFX = BulgingSoundFX;
    }

    public String getInGameImage()
    {
        return inGameImage;
    }
    public GraphicAsset getCookingImage()
    {
        return cookingImages;
    }
    public GraphicAsset getBulgingSoundFX()
    {
        return bulgingSoundFX;
    }

}
