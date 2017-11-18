package com.gdx.battleleague;

public class Mage extends Unit {
    private Spell spell_;

    public Mage() {
        health_ = 10;
        damage_ = 5;
        attackRange_ = 3;
        moveRange_ = 1;
    }

    @Override
    public void makeTurn(Cell currentCell, Cell destinationCell) {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else 

    }
}