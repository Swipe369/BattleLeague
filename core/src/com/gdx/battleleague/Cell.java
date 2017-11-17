package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cell {
    private int x_;
    private int y_;
    private Unit unit;//добавить get set методы
    private boolean emptyStatus_;
    private Texture cellTexture_;
    private Sprite cellSprite_;

    public Cell() {
        cellTexture_ = new Texture("Клетка.png");
        cellSprite_= new Sprite(cellTexture_);
        x_ = 0;
        y_ = 0;
        emptyStatus_ = true;
    }

    public Cell(int x, int y) {
        x_ = x;
        y_ = y;
        cellSprite_.setPosition(Constants.UPPER_LEFT_FIELD_CORNER_X + x_ * Constants.CELL_SIZE, Constants.UPPER_LEFT_FIELD_CORNER_Y + y_ * Constants.CELL_SIZE)
    }

    public int getX_() {
        return x_;
    }

    public int getY_() { return y_; }

    public void setX_(int x) {
        x_ = x;
    }

    public void setY_(int y) {
        y_ = y;
    }

    public boolean isEmpty() {
        return emptyStatus_;
    }

    public void setEmptyStatus(boolean status) {
        emptyStatus_ = status;
    }

    //считает расстояние до выбранной клетки
    public int calcDistance() {}
}
