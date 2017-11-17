package com.gdx.battleleague;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;


public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    private BitmapFont font;
    private float x = 0;
    private float y = 0;
    private float dx = 5;
    private float dy = 5;
    private boolean xUp = true;
    private boolean yUp = true;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("grot1-1.png");
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int imgX = img.getWidth();
        int imgY = img.getHeight();
        int maxX = Gdx.graphics.getWidth();
        int maxY = Gdx.graphics.getHeight();
        batch.begin();
        batch.draw(img, x, y);


        if (x >= maxX - imgX) xUp = false;
        if (x <= 0) xUp = true;
        if (y >= maxY - imgY) yUp = false;
        if (y <= 0) yUp = true;

        if (xUp)
            x += dx;
        else
            x -= dx;

        if (yUp)
            y += dy;
        else
            y -= dy;

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
