package com.gdx.battleleague;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Unit {
    protected String name_;
    protected int health_;
    protected int damage_;
    protected int moveRange_;
    protected int attackRange_;
    protected Sprite sprite_;

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

    public void show() {
        System.out.println("Name: " + name_ + "\n" + "Damage: " + damage_ + "\n" + "Health :" + health_ + "\n" + "Move range: " + moveRange_ + "\n" + "Attack range: " + attackRange_ + "\n");
    }

    public void move() {

    }
}
