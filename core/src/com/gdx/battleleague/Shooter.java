package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Shooter extends Unit {
    public Shooter() {
        health_ = 5;
        damage_ = 12;
        moveRange_ = 1;
        attackRange_ = 4;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,Constants.UNIT_SPRITE_WIDTH,Constants.UNIT_SPRITE_HEIGHT);
    }
    @Override
    public void makeTurn(Cell currentCell,Cell destinationCell,Cell[][] map)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
            attack(currentCell,destinationCell);
    }
    @Override
    public void update(float dt, int x, int y)
    {
        //attackAnimation.update(dt);
    }
}
