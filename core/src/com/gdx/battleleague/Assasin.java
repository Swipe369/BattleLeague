package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assasin extends Unit {
    public Assasin() {
        health_ = 6;
        damage_ = 15;
        moveRange_ = 3;
        attackRange_ = 1;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,Constants.UNIT_SPRITE_WIDTH,Constants.UNIT_SPRITE_HEIGHT);
    }
    @Override
    public void makeTurn(Cell currentCell,Cell destinationCell,Cell[][] map)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
        {
            move(currentCell,map[destinationCell.getX()-1][destinationCell.getY()]);
            attack(currentCell,destinationCell);
            move(map[x_][y_],currentCell);
        }
    }
    @Override
    public void update(float dt, int x, int y)
    {
       // attackAnimation.update(dt);
    }
}
