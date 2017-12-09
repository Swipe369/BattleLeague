package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.medved.game.MyGame;
import com.medved.game.Sprites.Men;
import com.medved.game.Sprites.Pause_button;
import com.medved.game.Sprites.Pause_mode;
import com.medved.game.Sprites.Power_comet;
import com.medved.game.Sprites.Scenery;
import com.medved.game.Sprites.Score;
import com.medved.game.Sprites.let;


public class PlayState extends State{

    private Pause_button pause;         //Кнопка паузы
    private Pause_mode pause_mode;      //Режим паузы
    private int score = 0;              //количество набранных очков
    private float timeScore = 0;        //счетчик времени для одного очка
    private Music music_begin;
    private Music music;


    private boolean is_pause = false;   //режим паузы
    private boolean is_play = true;     //режим игры
    private boolean is_quit = false;    //режим выхода из игры

    public PlayState(GameStateManager gsm) {
        super(gsm);

        //Инициализируем классы
        pause = new Pause_button();
        pause_mode = new Pause_mode();
        sc = new Score();
        scenery = new Scenery();
        lets = new let();

        music_begin = Gdx.audio.newMusic(Gdx.files.internal("1.mp3"));
        music_begin.setVolume(0.7f);
        if (MyGame.is_music)
            music_begin.play();


        music = Gdx.audio.newMusic(Gdx.files.internal("2.mp3"));
        music.isLooping();
        music.setVolume(0.7f);
        music.pause();

    }

    @Override
    protected void handleInput() {

        if (Gdx.input.justTouched()) {

            if (MyGame.is_music) MyGame.tap.play();
            //Игровой режим
            if (is_play) {
                //Проверка на нажетие кнопки пауза
                //Иначе смена движения ракеты
                if (pause.is_touch(Gdx.input.getX(), Gdx.input.getY())) {
                    is_pause = true;
                    is_play = false;
                } else MyGame.rocket.Tap();
            }
            //Режим паузы
            if (is_pause) {
                //Выесняем результат нажатия
                String result = pause_mode.is_touch(Gdx.input.getX(), Gdx.input.getY());

                //Проверка на нажатие кнопки
                //Если нажата кнопка "play" - то игра продолжается
                //Если нажата кнопка "music" - включение || выключение музыки
                //Если нажата кнопка "quit" - выход в меню
                if (result.equals("play"))
                    is_pause = false;
                else if (result.equals("music")) {
                    MyGame.is_music = !MyGame.is_music;
                    pause_mode.reverse_music();

                    MyGame.save_music(MyGame.is_music);

                } else if (result.equals("quit")) {
                    is_pause = false;
                    is_quit = true;
                    MyGame.bg.start_quit_render();
                }
            }
        }
    }

    @Override
    public void update(float dt) {
        dt *= (MyGame.HEIGHT/1280f);
        if (!MyGame.live_player)
        {
            MyGame.rocket.update(dt,false);
            MyGame.rocket.to_stable(dt);
            if(!MyGame.rocket.is_stable()) {

                music_begin.dispose();
                music.dispose();
                if (MyGame.current_record < score) {
                    MyGame.current_record = score;
                    MyGame.save_score(score);
                }
                MyGame.live_player = true;
                gsm.set(new MenuState(gsm, false));
            }
            return;

        }
        if (!music.isPlaying() && !music_begin.isPlaying() && MyGame.is_music) music.play();
        else if ((music.isPlaying() || music_begin.isPlaying()) && !MyGame.is_music)
        {
            music.stop();
            music_begin.stop();
        }

        if (is_play){
            timeScore += dt;
            if (timeScore > 1) {
                timeScore = 0;
                ++score;
            }
            handleInput();
            MyGame.bg.update(dt);
            MyGame.rocket.update(dt,true);
            scenery.update(dt);
            lets.update(dt);
        }

        else if (is_pause) {
            if (pause_mode.is_stable())
                handleInput();

            MyGame.rocket.update(dt,false);
            pause_mode.update(dt,true);
        }

        else if(!is_quit) {
            if (pause_mode.is_end()) is_play = true;
            pause_mode.update(dt,false);
            MyGame.rocket.update(dt,false);
        }

        else{
            pause_mode.update(dt,false);
            MyGame.rocket.to_stable(dt);
            if (pause_mode.is_end()){
                is_quit = false;
                music_begin.dispose();
                music.dispose();
                if (MyGame.current_record < score){
                    MyGame.current_record = score;
                    MyGame.save_score(score);
                }
                gsm.set(new MenuState(gsm, false));
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        MyGame.bg.render(sb);
        scenery.render(sb);
        lets.render(sb);
        sc.render(sb, score);

        if(is_quit) MyGame.bg.quit_render(sb);
        if (is_play) pause.render(sb);
        else pause_mode.render(sb);


        MyGame.rocket.render(sb);
        sb.end();
    }

    @Override
    public void dispose() {
    }
}
