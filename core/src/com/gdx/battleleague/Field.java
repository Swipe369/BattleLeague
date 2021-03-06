package com.gdx.battleleague;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Field {
    static private Cell[][] cell_arr;
    private Cell checkedCell_;
    private int width_;
    private int height_;

    public Field() {
        width_=Constants.FIELD_WIDTH;
        height_=Constants.FIELD_HEIGHT;
        cell_arr = new Cell[width_][height_];
        for (int i = 0; i < width_; i++)
            for (int j = 0; j < height_; j++)
                cell_arr[i][j] = new Cell(i, j);
        checkedCell_ = null;
    }

    public Cell[][] getField() {
        return cell_arr;
    }

    public int getHeight() {
        return height_;
    }

    public int getWidth() {
        return width_;
    }

    //возвращает 1 если клетка достижима,0 если не достижима
    public boolean isReachable() {
        /* вызываем метод класса Cell для расчета расстояния до выбранной клетки*/
        return true;
    }

    public boolean isMoving() {
        if (getCheckedCell() != null)
            return true;
        else
            return false;
    }

    public Cell getCheckedCell() {
        return checkedCell_;
    }

    public void setCheckedCell(Cell cell) {
        checkedCell_ = cell;
    }

    public void clearCheckedCell() {
        checkedCell_ = null;
    }

    public void showMoveRange() {
        for (int i = InputHandler.calcX(); i <= InputHandler.calcX() + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && i <= width_; i++)
            for (int j = InputHandler.calcY(); j <= InputHandler.calcY() + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && j <= height_; j++) {
                if (cell_arr[i][j].isEmpty() && ((i + j) <= InputHandler.calcX() + InputHandler.calcY() + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange())) {
                    cell_arr[i][j].setCellSprite(new Sprite(new Texture("Клетка1.png")));
                }
            }
        for (int i = InputHandler.calcX(); i >= InputHandler.calcX() - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && i >= 0; i--)
            for (int j = InputHandler.calcY(); j >= InputHandler.calcY() - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && j >= 0; j--) {
                if (cell_arr[i][j].isEmpty() && ((i + j) >= (InputHandler.calcX() + InputHandler.calcY()) - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange())) {
                    cell_arr[i][j].setCellSprite(new Sprite(new Texture("Клетка1.png")));
                }
            }
        for (int i = InputHandler.calcX(); i <= InputHandler.calcX() + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && i <= width_; i++)
            for (int j = InputHandler.calcY(); j >= InputHandler.calcY() - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && j >= 0; j--) {
                if (cell_arr[i][j].isEmpty() && ((i + j ) <= (InputHandler.calcX() + InputHandler.calcY()) + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange())) {
                    cell_arr[i][j].setCellSprite(new Sprite(new Texture("Клетка1.png")));
                }
            }
        for (int i = InputHandler.calcX(); i >= InputHandler.calcX() - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && i >= 0; i--)
            for (int j = InputHandler.calcY(); j <= InputHandler.calcY() + cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange() && j <= height_; j++) {
                if (cell_arr[i][j].isEmpty() && ((-i + j) >= (InputHandler.calcX() + InputHandler.calcY()) - cell_arr[InputHandler.calcX()][InputHandler.calcY()].getUnit().getMoveRange())) {
                    cell_arr[i][j].setCellSprite(new Sprite(new Texture("Клетка1.png")));
                }
            }
    }

    public void cancelMove() {
        if (isMoving()) {
            getCheckedCell().setCellSprite(new Sprite(new Texture("Клетка.png")));
            clearCheckedCell();
            for (int i = 0; i < width_; i++)
                for (int j = 0; j < height_; j++)
                    cell_arr[i][j].setCellSprite(new Sprite(new Texture("Клетка.png")));
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < width_; i++)
            for (int j = 0; j < height_; j++) {
                batch.draw(cell_arr[i][j].getCellSprite(), Constants.LOWER_LEFT_FIELD_CORNER_X + cell_arr[i][j].getX() * Constants.CELL_SIZE, Constants.LOWER_LEFT_FIELD_CORNER_Y + cell_arr[i][j].getY() * Constants.CELL_SIZE);
                if (!cell_arr[i][j].isEmpty()) {
                    cell_arr[i][j].getUnit().render(batch, Constants.LOWER_LEFT_FIELD_CORNER_X + cell_arr[i][j].getX() * Constants.CELL_SIZE, Constants.LOWER_LEFT_FIELD_CORNER_Y + cell_arr[i][j].getY() * Constants.CELL_SIZE);
                    if (isMoving())
                        checkedCell_.getUnit().update(0.025f);
                }
            }
    }

    public void update() {
        if (InputHandler.isClicked()&&InputHandler.calcX()>=0&&InputHandler.calcY()>=0&&InputHandler.calcX()<=Constants.FIELD_WIDTH-1&&InputHandler.calcY()<=Constants.FIELD_HEIGHT-1) {

            if (!isMoving()) {
                if (!(cell_arr[InputHandler.calcX()][InputHandler.calcY()].isEmpty())) {
                    setCheckedCell(cell_arr[InputHandler.calcX()][InputHandler.calcY()]);
                   // showMoveRange();
                    cell_arr[InputHandler.calcX()][InputHandler.calcY()].setCellSprite(new Sprite(new Texture("Клетка1.png")));
                }
            }
            else if (isMoving()) {
                    if (getCheckedCell()==cell_arr[InputHandler.calcX()][InputHandler.calcY()])
                        cancelMove();
                    else {
                        getCheckedCell().getUnit().makeTurn(cell_arr[getCheckedCell().getX()][getCheckedCell().getY()], cell_arr[InputHandler.calcX()][InputHandler.calcY()],cell_arr);
                        cancelMove();
                    }
                }
        }
    }
}
