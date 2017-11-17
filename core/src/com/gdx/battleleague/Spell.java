package com.gdx.battleleague;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Spell {
    private int cooldownTime_;
    private int damage_;
    private Texture spellTexture_;

    public int getCooldownTime() {
        return cooldownTime_;
    }

    public int getDamage() {
        return damage_;
    }

    public void setCooldownTime(int cooldownTime) {
        cooldownTime_ = cooldownTime;
    }

    public void setDamage(int damage) {
        damage_ = damage;
    }

    public void setSpellTexture(Texture texture) {

    }

}
