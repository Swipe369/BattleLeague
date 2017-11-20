package com.gdx.battleleague;

public class Assasin extends Unit {
    public Assasin() {
        health_ = 5;
        damage_ = 15;
        moveRange_ = 3;
        attackRange_ = 1;
    }
    @Override
    public void makeTurn(Cell currentCell,Cell destinationCell)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
        {
            Cell moveTo=new Cell(destinationCell.getX(),destinationCell.getY()-1);

            move(currentCell,moveTo);
            attack(currentCell,destinationCell);
            move(moveTo,currentCell);
        }
    }
}
