package com.gdx.battleleague;

public class Shooter extends Unit {
    public Shooter() {
        health_ = 5;
        damage_ = 12;
        moveRange_ = 1;
        attackRange_ = 4;
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
