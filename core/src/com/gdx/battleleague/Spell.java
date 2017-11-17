package com.gdx.battleleague;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Spell {
    private double cooldownTime_;
    private int damage_;
    private Sprite spellSprite_;

    public double getCooldownTime() {
        return cooldownTime_;
    }

    public int getDamage() {
        return damage_;
    }

    public void setCooldownTime(double cooldownTime) {
        cooldownTime_ = cooldownTime;
    }

    public void setDamage(int damage) {
        damage_ = damage;
    }

    public void setSpellSprite(Sprite sprite) {

    }

}
