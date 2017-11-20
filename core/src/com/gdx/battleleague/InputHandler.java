package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Input.Keys.*;

public class InputHandler {
    public static boolean isClicked() {
        return Gdx.input.justTouched();
    }

    public static boolean isClickedA() {
        return Gdx.input.isKeyPressed(A);
    }
    public static boolean isPressed() {
        return Gdx.input.isTouched();
    }
    public static Vector2 getMousePosition() {
        return new Vector2(Gdx.input.getX(),Gdx.input.getY());
    }

    public static int calcX() {return (int)((InputHandler.getMousePosition().x-Constants.LOWER_LEFT_FIELD_CORNER_X)/Constants.CELL_SIZE);}
    public static int calcY() {return (int)(Gdx.graphics.getHeight()-InputHandler.getMousePosition().y-Constants.LOWER_LEFT_FIELD_CORNER_Y)/Constants.CELL_SIZE;}
}
