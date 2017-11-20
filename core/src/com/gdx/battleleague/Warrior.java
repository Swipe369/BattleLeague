package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Warrior extends Unit {
    public Warrior() {
        health_ = 15;
        damage_ = 5;
        moveRange_ = 3;
        attackRange_ = 1;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,Constants.UNIT_SPRITE_SIZE,Constants.UNIT_SPRITE_SIZE);
    }

    @Override
    public void makeTurn(Cell currentCell,Cell destinationCell)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
            attack(currentCell,destinationCell);
    }
}
