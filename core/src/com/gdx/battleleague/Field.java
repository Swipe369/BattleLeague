package com.gdx.battleleague;

public class Field {
    static private Cell[][] cell_arr;
    static private final int HEIGHT_=14;
    static private final int WIDTH_=8;

    public Field() {
        for (int i = 0; i < HEIGHT_; i++)
            for (int j = 0; j < WIDTH_; j++)
                cell_arr[i][j] = new Cell(i, j);
    }

    public Cell[][] getField() {
        return cell_arr;
    }

    public int getHeight_() {
        return HEIGHT_;
    }

    public int getWidth_() {
        return WIDTH_;
    }

    //возвращает 1 если клетка достижима,0 если не достижима
    public boolean isReachable() {
        /* вызываем метод класса Cell для расчета расстояния до выбранной клетки*/
    }


}