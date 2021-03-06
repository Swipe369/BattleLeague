package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {
    public static boolean isClicked() {
        return Gdx.input.justTouched();
    }
    public static boolean isClickedA() {
        return Gdx.input.isKeyPressed(ANY_KEY);
    }
    public static boolean isPressed() {
        return Gdx.input.isTouched();
    }
    public static Vector2 getMousePosition() {
        return new Vector2(Gdx.input.getX(),Gdx.input.getY());
    }

    public static int calcX() {
        if((InputHandler.getMousePosition().x-Constants.LOWER_LEFT_FIELD_CORNER_X)/Constants.CELL_SIZE>0)
            return (int)((InputHandler.getMousePosition().x-Constants.LOWER_LEFT_FIELD_CORNER_X)/Constants.CELL_SIZE);
        else
            return -1;
    }
    public static int calcY() {
        if((Gdx.graphics.getHeight()-InputHandler.getMousePosition().y-Constants.LOWER_LEFT_FIELD_CORNER_Y)/Constants.CELL_SIZE>0)
            return (int)(Gdx.graphics.getHeight()-InputHandler.getMousePosition().y-Constants.LOWER_LEFT_FIELD_CORNER_Y)/Constants.CELL_SIZE;
        else
            return -1;
    }
    public static int calcXpx() {return (int)((InputHandler.getMousePosition().x-Constants.LOWER_LEFT_FIELD_CORNER_X));}
    public static int calcYpx() {return (int)(Gdx.graphics.getHeight()-InputHandler.getMousePosition().y-Constants.LOWER_LEFT_FIELD_CORNER_Y);}
}
