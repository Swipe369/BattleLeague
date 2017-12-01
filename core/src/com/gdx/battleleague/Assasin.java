package com.gdx.battleleague;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;

import javax.swing.*;

public class Assasin extends Unit {
    public Assasin() {
        health_ = 6;
        damage_ = 15;
        moveRange_ = 3;
        attackRange_ = 1;
        unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,Constants.UNIT_SPRITE_WIDTH,Constants.UNIT_SPRITE_HEIGHT);
        healthTexture_=new Texture("health.png");
        healthSprite_=new Sprite(healthTexture_,0,0,30,30);
        damageTexture_=new Texture("damage.png");
        damageSprite_=new Sprite(damageTexture_,0,0,30,30);
        textureRegions = new TextureRegion(unitTexture_, unitTexture_.getWidth()/10,0, unitTexture_.getWidth()/4, unitTexture_.getHeight()/6);
        moveAnimation=new Animation(textureRegions,5,1);
        textureRegions=new TextureRegion(unitTexture_,0,unitTexture_.getHeight()-Constants.UNIT_SPRITE_HEIGHT*2,unitTexture_.getWidth()/4,unitTexture_.getHeight()/6);
        attackAnimation=new Animation(textureRegions,5,1);
        font=new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false);
    }
    @Override
    public void makeTurn(final Cell currentCell,final Cell destinationCell,final Cell[][] map)
    {
        if (destinationCell.isEmpty())
            move(currentCell, destinationCell);
        else
        {
            Timer timer=new Timer();
            timer.scheduleTask(new Timer.Task() {
                                   @Override
                                   public void run() {
                                       if(InputHandler.calcXpx()<=destinationCell.getX()*Constants.CELL_SIZE+50)
                                       {
                                           if (InputHandler.calcXpx() % Constants.CELL_SIZE + InputHandler.calcYpx() % Constants.CELL_SIZE <= Constants.CELL_SIZE)
                                               if ((InputHandler.calcXpx() % Constants.CELL_SIZE <= InputHandler.calcYpx() % Constants.CELL_SIZE))
                                                   move(currentCell, map[destinationCell.getX() - 1][destinationCell.getY()]);
                                       }
                                       else if (InputHandler.calcXpx() > destinationCell.getX() * Constants.CELL_SIZE +50)
                                       {
                                           if ((InputHandler.calcXpx() % Constants.CELL_SIZE >= InputHandler.calcYpx() % Constants.CELL_SIZE))
                                               if (InputHandler.calcXpx() % Constants.CELL_SIZE + InputHandler.calcYpx() % Constants.CELL_SIZE >= Constants.CELL_SIZE)
                                                   move(currentCell, map[destinationCell.getX() + 1][destinationCell.getY()]);
                                       }
                                       else if (InputHandler.calcYpx()>destinationCell.getY()*Constants.CELL_SIZE+50)
                                       {
                                           if (InputHandler.calcXpx() % Constants.CELL_SIZE + InputHandler.calcYpx() % Constants.CELL_SIZE > Constants.CELL_SIZE)
                                               if ((InputHandler.calcXpx() % Constants.CELL_SIZE > InputHandler.calcYpx() % Constants.CELL_SIZE))
                                           move(currentCell, map[destinationCell.getX()][destinationCell.getY() + 1]);
                                       }
                                       else if (InputHandler.calcYpx()<destinationCell.getY()*Constants.CELL_SIZE+50)
                                       {
                                           move(currentCell, map[destinationCell.getX()][destinationCell.getY() - 1]);
                                       }

                                   }
                               },0);

            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    attack(map[x_][y_], destinationCell);
                }
            },0.5f);

            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    move(map[x_][y_],currentCell);
                }
            },1);
            timer.start();
        }
    }

    @Override
    public void render(SpriteBatch batch, int x, int y)
    {
        unitSprite_.setRegion(moveAnimation.getFrame());
        unitSprite_.draw(batch);
        unitSprite_.setPosition(x, y);
        healthSprite_.draw(batch);
        healthSprite_.setSize(25,25);
        healthSprite_.setPosition(x,y+Constants.CELL_SIZE-25);
        font.draw(batch,""+health_,x+25,y+Constants.CELL_SIZE-5);
        damageSprite_.draw(batch);
        damageSprite_.setSize(25,25);
        damageSprite_.setPosition(x+40,y+Constants.CELL_SIZE-25);
        font.draw(batch,""+damage_,x+65,y+Constants.CELL_SIZE-5);

    }

    @Override
    public void update(float dt)
    {
        moveAnimation.update(dt);
    }
}
