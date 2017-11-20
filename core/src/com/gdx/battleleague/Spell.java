package com.gdx.battleleague;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Spell {
    private int cooldownTime_;
    private int currentCooldownTime_;
    private int damage_;
    private Texture spellTexture_;

    public Spell() {
        cooldownTime_=3;
        currentCooldownTime_=cooldownTime_;
        damage_=10;
    }
    public int getCooldownTime() {
        return cooldownTime_;
    }

    public int getCurrentCooldownTime() {return currentCooldownTime_;}

    public int getDamage() {
        return damage_;
    }

    public Texture getSpellTexture_() {
        return spellTexture_;
    }

    public boolean isReady() {
        return (currentCooldownTime_==0);
    }

    public void setCooldownTime(int cooldownTime) {
        cooldownTime_ = cooldownTime;
    }

    public void setCurrentCooldownTime_(int currentCooldownTime) {currentCooldownTime_=currentCooldownTime;}

    public void setDamage(int damage) {
        damage_ = damage;
    }

    public void setSpellTexture(Texture texture) {
        spellTexture_=texture;
    }

}
