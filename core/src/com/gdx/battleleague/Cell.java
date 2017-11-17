package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cell {
    private int x_;                 // Номер клетки на поле по X
    private int y_;                 // Номер клетки на поле по Y
    private Unit unit_;             // Герой, который на данный момент стоит в этой клетке
    private boolean emptyStatus_;   // Наличие героя в клетке
    private Texture cellTexture_;   // Текстура клетки
    private Sprite cellSprite_;     // Спрайт клетки

    public Cell() {
        cellTexture_ = new Texture("Клетка.png");
        cellSprite_ = new Sprite(cellTexture_);
        x_ = 0;
        y_ = 0;
        emptyStatus_ = true;
    }

    public Cell(int x, int y) {
        x_ = x;
        y_ = y;

        cellSprite_.setPosition(Constants.UPPER_LEFT_FIELD_CORNER_X + x_ * Constants.CELL_SIZE, Constants.UPPER_LEFT_FIELD_CORNER_Y + y_ * Constants.CELL_SIZE)
    }

    public int getX() {
        return x_;
    }

    public int getY() {
        return y_;
    }

    public void setX_(int x) {
        x_ = x;
    }

    public void setY(int y) {
        y_ = y;
    }

    public boolean isEmpty() {
        return emptyStatus_;
    }

    public void setEmptyStatus(boolean status) {
        emptyStatus_ = status;
    }

    public Unit getUnit() {
        return unit_;
    }

    public void setUnit(Unit unit) {
        unit_ = unit;
    }

    public Sprite getCellSprite() {
        return cellSprite_;
    }


    public void setCellSprite(Sprite cellSprite_) {
        cellSprite_ = cellSprite;
    }

    //Возвращает расстояние до передаваемой клетки, включая её
    public int calcDistance(Cell cell) {
        return abs(cell.getX() - x_) + abs(cell.getY() - y_);
    }


    public void render() {
        Gd
    }

    public void update() {

    }
}
