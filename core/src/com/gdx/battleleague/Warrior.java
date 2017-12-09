package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Warrior extends Unit {
    public Warrior() {
        health_ = 156;
        damage_ = 5;
        moveRange_ = 3;
        attackRange_ = 1;
        unitTexture_ = new Texture("Unit.png");
        unitSprite_ = new Sprite(unitTexture_, 0, 0, Constants.UNIT_SPRITE_WIDTH, Constants.UNIT_SPRITE_HEIGHT);
        healthTexture_ = new Texture("health.png");
        healthSprite_ = new Sprite(healthTexture_, 0, 0, 30, 30);
        damageTexture_ = new Texture("damage.png");
        damageSprite_ = new Sprite(damageTexture_, 0, 0, 30, 30);
        textureRegions = new TextureRegion(unitTexture_, unitTexture_.getWidth() / 10, 0, unitTexture_.getWidth() / 4, unitTexture_.getHeight() / 6);
        moveAnimation = new Animation(textureRegions, 5, 1);
        textureRegions = new TextureRegion(unitTexture_, 0, unitTexture_.getHeight() - Constants.UNIT_SPRITE_HEIGHT * 2, unitTexture_.getWidth() / 4, unitTexture_.getHeight() / 6);
        attackAnimation = new Animation(textureRegions, 5, 1);
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"), Gdx.files.internal("myfont.png"), false);
    }

    /* public TextureRegion getWarrior() {

         return attackAnimation.getKeyFrame(1);
     }*/
    @Override
    public void makeTurn(final Cell currentCell, final Cell destinationCell, final Cell[][] map) {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
            attack(currentCell, destinationCell);
    }

    @Override
    public void render(SpriteBatch batch, int x, int y) {
        unitSprite_.setRegion(moveAnimation.getFrame());
        unitSprite_.draw(batch);
        unitSprite_.setPosition(x, y);
        healthSprite_.draw(batch);
        healthSprite_.setSize(25, 25);
        healthSprite_.setPosition(x, y + Constants.CELL_SIZE - 25);
        font.draw(batch, "" + health_, x + 25, y + Constants.CELL_SIZE - 5);
        damageSprite_.draw(batch);
        damageSprite_.setSize(25, 25);
        damageSprite_.setPosition(x + 40, y + Constants.CELL_SIZE - 25);
        font.draw(batch, "" + damage_, x + 65, y + Constants.CELL_SIZE - 5);


    }


    @Override
    public void update(float dt) {
        moveAnimation.update(dt);
    }
}
