package com.psychogra.slon2;
import java.util.*;
import com.psychogra.slon2.models.GameObject;

/**
 * Created by Marcel on 2017-09-23.
 */
interface  Listener{
    void onGameObjectDrop(GameObject obj);
}

public class Container extends GameObject {

    private String inGameImage;
    private String[] cookingImages;
    private String bulgingSoundFX;

    private List<Listener> listenerList = new ArrayList<Listener>();

    public void addListener(Listener toAdd) {
        listenerList.add(toAdd);
    }

    public void onObjectDrop(GameObject obj) {
        for (Listener listener : listenerList)
            listener.onGameObjectDrop(obj);
    }
    public Container(String id, String name, String image, String positionGroup, String[] CookingImages, String InGameImage, String BulgingSoundFX){
        super(id, name, image, positionGroup);
        this.cookingImages = CookingImages
        this.inGameImage = InGameImage;
        this.cookingImages = CookingImages;
        this.bulgingSoundFX = BulgingSoundFX;
    }

    public String getInGameImage()
    {
        return inGameImage;
    }
    public String[] getCookingImage()
    {
        return cookingImages;
    }
    public String getBulgingSoundFX()
    {
        return bulgingSoundFX;
    }

}
