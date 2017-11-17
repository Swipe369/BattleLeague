package com.gdx.battleleague.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.gdx.battleleague.*;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Drop";
        config.width = 1920;
        config.height = 1080;
        config.fullscreen = true;
        Unit mage = new Mage();
        mage.show();
        Sprite sprite = new Sprite();
        new LwjglApplication(new MyGame(), config);
    }
}
