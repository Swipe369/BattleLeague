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
import com.sun.deploy.util.Waiter;


public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    private BitmapFont font;
    private Field map;
    private Warrior warrior;
    private Warrior warrior1;
    private Shooter shooter;

    @Override
    public void create() {
        batch = new SpriteBatch();
        map=new Field();
        font=new BitmapFont();
        warrior=new Warrior();
        warrior1=new Warrior();
        shooter = new Shooter();
        map.getField()[0][0].setUnit(warrior);
        map.getField()[4][4].setUnit(warrior1);

    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        map.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void update() {
        map.update();
    }
}
