package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.audio.Sound;

public class AudioAsset {

    private String id;
    private Sound sound;

    public AudioAsset(String id, Sound sound) {
        this.id = id;
        this.sound = sound;
    }

    public String getId() {
        return id;
    }

    public Sound getSound() {
        return sound;
    }
}
