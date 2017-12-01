package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;

public class Cell {
    private int x_;                 // Номер клетки на поле по X
    private int y_;                 // Номер клетки на поле по Y
    private Unit unit_;             // Герой, который на данный момент стоит в этой клетке
    private boolean emptyStatus_;   // Наличие героя в клетке
    private Texture cellTexture_;   // Текстура клетки
    private Sprite cellSprite_;     // Спрайт клетки

    public Cell() {
        x_ = 0;
        y_ = 0;
        emptyStatus_ = true;
        cellSprite_ = new Sprite(new Texture("Клетка.png"));
    }

    public Cell(int x, int y) {
        x_ = x;
        y_ = y;
        emptyStatus_ = true;
        cellSprite_ = new Sprite(new Texture("Клетка.png"));
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
        if (unit != null) {
            unit_ = unit;
            emptyStatus_ = false;
            unit_.setX(x_);
            unit_.setY(y_);
        }
    }

    public Sprite getCellSprite() {
        return cellSprite_;
    }


    public void setCellSprite(Sprite cellSprite) {
        cellSprite_ = cellSprite;
    }

    public Texture getCellTexture() {
        return cellTexture_;
    }

    public void setCellTexture(Texture texture) {
        cellTexture_ = texture;
    }

    //Возвращает расстояние до передаваемой клетки, включая её
    public int calcDistance(Cell cell) {
        return Math.abs(cell.getX() - x_) + Math.abs(cell.getY() - y_);
    }

    public void clear() {
        unit_ = null;
        emptyStatus_ = true;
    }

    public void render(SpriteBatch batch) {
        cellTexture_ = new Texture("Клетка.png");
        cellSprite_ = new Sprite(cellTexture_);
        cellSprite_.setPosition(Constants.LOWER_LEFT_FIELD_CORNER_X + x_ * Constants.CELL_SIZE, Constants.LOWER_LEFT_FIELD_CORNER_Y + y_ * Constants.CELL_SIZE);

        batch.draw(cellTexture_,Constants.LOWER_LEFT_FIELD_CORNER_X + x_ * Constants.CELL_SIZE, Constants.LOWER_LEFT_FIELD_CORNER_Y + y_ * Constants.CELL_SIZE);
    }

    public void update() {

    }
}
