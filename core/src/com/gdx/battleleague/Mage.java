package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mage extends Unit {
    private Spell spell_;

    public Mage() {
        health_ = 10;
        damage_ = 5;
        moveRange_ = 1;
        attackRange_ = 3;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,74,0,Constants.UNIT_SPRITE_WIDTH,Constants.UNIT_SPRITE_HEIGHT);
    }

    public Spell getSpell() {
        return spell_;
    }

    public void setSpell(Spell spell) {
        spell_=spell;
    }

    public void spellAttack(Cell currentCell,Cell destinationCell) {
        destinationCell.getUnit().setHealth(destinationCell.getUnit().getHealth()-spell_.getDamage());
    }

    @Override
    public void makeTurn(Cell currentCell, Cell destinationCell,Cell[][] map) {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
            if(spell_.isReady())
            {
                spellAttack(currentCell,destinationCell);
                spell_.setCurrentCooldownTime_(spell_.getCooldownTime());
            }
            else
            {
                attack(currentCell,destinationCell);
                spell_.setCurrentCooldownTime_(spell_.getCurrentCooldownTime()-1);
            }
    }
    @Override
    public void update(float dt, int x, int y)
    {
       // attackAnimation.update(dt);
    }
}