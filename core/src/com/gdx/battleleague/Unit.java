package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Unit {
    protected int health_;
    protected int damage_;
    protected int moveRange_;
    protected int attackRange_;
    protected Texture unitTexture_;
    protected Sprite unitSprite_;

    public int getHealth() {
        return health_;
    }

    public int getDamage() {
        return damage_;
    }

    public int getMoveRange() {
        return moveRange_;
    }

    public int getAttackRange() {
        return attackRange_;
    }

    public Texture getUnitTexture_() {
        return unitTexture_;
    }

    public Sprite getSprite_() {
        return unitSprite_;
    }

    public void setHealth(int value) {
        health_ = value;
    }

    public void setDamage(int value) {
        damage_ = value;
    }

    public void setMoveRange(int value) {
        damage_ = value;
    }

    public void setAttackRange(int value) {
        attackRange_ = value;
    }

    public void setUnitTexture(Texture texture) {unitTexture_=texture;}

    public void setSprite(Sprite sprite) {unitSprite_=sprite;}

    public void show() {
        System.out.println("Damage: " + damage_ + "\n" + "Health :" + health_ + "\n" + "Move range: " + moveRange_ + "\n" + "Attack range: " + attackRange_ + "\n");
    }

    //move - перемещение по карте
    protected void move(Cell currentCell, Cell destinationCell) {
        if (currentCell.calcDistance(destinationCell) <= moveRange_ && destinationCell.isEmpty()) {
            destinationCell.setUnit(currentCell.getUnit());
            currentCell.clear();
        }
    }

    //удар противника
    protected void attack(Cell currentCell, Cell destinationCell) {
        if (currentCell.calcDistance(destinationCell) <= attackRange_ && !destinationCell.isEmpty()) //если хватает дальности атаки и клетка занята -атакуем
            destinationCell.getUnit().setHealth(destinationCell.getUnit().getHealth() - currentCell.getUnit().getDamage());
        if (destinationCell.getUnit().getHealth() <= 0) //если атакуемый герой умер чистим клетку
            destinationCell.clear();
        if (destinationCell.getUnit() instanceof Warrior) //если в клетке куда атаковал стоит вар,то он атакует в ответ
            currentCell.getUnit().setHealth(currentCell.getUnit().getHealth() - destinationCell.getUnit().getDamage());
        if (currentCell.getUnit().getHealth() <= 0) //если атаковавший умер чистим клетку
            currentCell.clear();
    }

    //функция хода
    public void makeTurn(Cell currentCell,Cell destinationCell) {}
}
