package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.medved.game.MyGame;


//Режим паузы
public class Pause_mode {
    private Sprite play;                //спрайт кнопки play
    private Sprite quit;                //спрайт кнопки выхода
    private Texture texturePause;
    private Texture textureExit;

    public Pause_mode() {
        texturePause = new Texture("play_button.png");
        textureExit = new Texture("exit_button.png");
        play = new Sprite(new TextureRegion(texturePause));//, Gdx.graphics.getWidth() / 2 - texturePause.getWidth() / 2, Gdx.graphics.getHeight() - texturePause.getHeight() / 2));
        quit = new Sprite(new TextureRegion(textureExit));//, Gdx.graphics.getWidth() - textureExit.getWidth(), Gdx.graphics.getHeight() - textureExit.getHeight()));

        //  play.setSize(MyGame.WIDTH / 10, MyGame.WIDTH / 10);
        // quit.setSize(MyGame.WIDTH / 10, MyGame.WIDTH / 10);

        play.setPosition(Gdx.graphics.getWidth() / 2 - texturePause.getWidth() / 2, Gdx.graphics.getHeight() - texturePause.getHeight() / 2);
        quit.setPosition(Gdx.graphics.getWidth() - textureExit.getWidth(), Gdx.graphics.getHeight() - textureExit.getHeight());
    }

    //Движение значков из потустороннего мира
    //и обратно
    //Begin - значки становятся на свои места
    //Иначе уползают за границы экрана
    public void update(float dt, boolean begin) {
        /*if (begin) {
            play.setX(play.getX() + (MyGame.WIDTH / 5 - play.getX()) * CONST_SPEED * dt);
            quit.setX(quit.getX() - (quit.getX() - MyGame.WIDTH * 0.6f) * CONST_SPEED * dt);
        } else {
            if (music.getY() > MyGame.HEIGHT + MyGame.WIDTH / 5) {
                play.setX(0 - play.getWidth());
                quit.setX(MyGame.WIDTH);
                music.setY(MyGame.HEIGHT);
            }
            play.setX(play.getX() - (MyGame.WIDTH / 5 - play.getX()) * CONST_SPEED * dt - 1);
            quit.setX(quit.getX() + (quit.getX() - MyGame.WIDTH * 0.6f) * CONST_SPEED * dt + 1);
            music.setY(music.getY() + (music.getY() - quit.getY()) * CONST_SPEED * dt + 1);
        }
*/
    }

    //Значки пришли на свои места,
    //а значит можно нажимать на них
    /*public boolean is_stable() {
        return MyGame.WIDTH / 5 - play.getX() < 5;
    }

    //Значки уползли куда подальше,
    //а значит можно продолжать игру или выйти в меню
    public boolean is_end() {
        return music.getY() > MyGame.HEIGHT + MyGame.WIDTH / 5;
    }
*/

    //Нажатие на одну из кнопок, возвращение
    //результата в текстовом виде
    public String is_touch(float x, float y) {
        if ((x > play.getX()) && (x < play.getX() + play.getWidth()) &&
                y < (play.getY() + play.getHeight()) && y > (play.getY()))
            return "play";
        else if ((x > quit.getX()) && (x < quit.getX() + quit.getWidth()) &&
                y < (quit.getY() + quit.getHeight()) && y > (quit.getY()))
            return "quit";
        else return "NaN";
    }

    //Прорисовка значков
    public void render(SpriteBatch sb) {
        play.draw(sb);
        quit.draw(sb);
    }

}
