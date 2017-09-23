package com.psychogra.slon2.models;
import com.psychogra.slon2.BundleManagement.GraphicAsset;

import java.awt.Graphics;
import java.util.*;

/**
 * Created by Marcel on 2017-09-23.
 */
interface  PotListener{
    void onGameObjectDrop(GameObject obj);
}

public class Pot extends GameObject {

    private GraphicAsset inGameImage;
    private GraphicAsset cookingImages;
    private String bulgingSoundFX;

    private List<PotListener> listenerList = new ArrayList<PotListener>();

    public void addListener(PotListener toAdd) {
        listenerList.add(toAdd);
    }

    public void onObjectDrop(GameObject obj) {
        for (PotListener listener : listenerList)
            listener.onGameObjectDrop(obj);
    }
    public Pot(String id, String name, GraphicAsset image, String positionGroup, GraphicAsset CookingImages, GraphicAsset InGameImage, String BulgingSoundFX){
        super(id, name, image, positionGroup);
        this.cookingImages = CookingImages;
        this.inGameImage = InGameImage;
        this.cookingImages = CookingImages;
        this.bulgingSoundFX = BulgingSoundFX;
    }

    public GraphicAsset getInGameImage()
    {
        return inGameImage;
    }
    public GraphicAsset getCookingImage()
    {
        return cookingImages;
    }
    public String getBulgingSoundFX()
    {
        return bulgingSoundFX;
    }

}
