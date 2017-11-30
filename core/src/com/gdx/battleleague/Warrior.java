package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Warrior extends Unit {
    public Warrior() {
        health_ = 15;
        damage_ = 5;
        moveRange_ = 3;
        attackRange_ = 1;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,Constants.UNIT_SPRITE_WIDTH,Constants.UNIT_SPRITE_HEIGHT);
        TextureRegion tmp[][]= TextureRegion.split(unitTexture_,unitTexture_.getWidth()/Constants.UNIT_TEXTURE_COLS,unitTexture_.getHeight()/Constants.UNIT_TEXTURE_ROWS);
        /*textureRegions=new TextureRegion[Constants.UNIT_TEXTURE_COLS*Constants.UNIT_TEXTURE_ROWS];
        int index =0;
        for(int i=0;i<Constants.UNIT_TEXTURE_ROWS;i++)
            for(int j=0;j<Constants.UNIT_TEXTURE_COLS;j++)
                textureRegions[index++]=tmp[i][j];
                */
        textureRegions = new TextureRegion(unitTexture_, unitTexture_.getWidth()/10,0, unitTexture_.getWidth()/4, unitTexture_.getHeight()/6);
        attackAnimation=new Animation(textureRegions,5,1);
    }

   /* public TextureRegion getWarrior() {

        return attackAnimation.getKeyFrame(1);
    }*/
    @Override
    public void makeTurn(Cell currentCell,Cell destinationCell,Cell[][] map)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
            attack(currentCell,destinationCell);
    }

    @Override
    public void render(SpriteBatch batch,int x,int y)
    {
        unitSprite_.setRegion(attackAnimation.getFrame());
        unitSprite_.draw(batch);
        unitSprite_.setPosition(x,y);
    }

    @Override
    public void update(float dt , int x, int y)
    {
        attackAnimation.update(dt);
    }
}
