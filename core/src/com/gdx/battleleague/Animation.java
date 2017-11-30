package com.gdx.battleleague;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;    //Массив кадров
    private float currentFrameTime;         //Текущее время кадра
    private float maxFrameTime;             //Время кадра
    private int frameCount;                 //Количество кадров
    private int frame;                      //Текущий кадр

    //На конструктор подаётся регион текстур, количество кадров, время цикла
    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();

        //Разделяем текстуру на ригионы и добавляем в массив
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++)
            frames.add(new TextureRegion(region, i*frameWidth, 0, frameWidth, region.getRegionHeight()));

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){
        //Если текущее время кадра больше максимального времени кадра, то он сменяется
        currentFrameTime +=dt;
        if (currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if (frame>=frameCount){
            frame=0;
        }
    }

    //Возвращает текущий кадр
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}