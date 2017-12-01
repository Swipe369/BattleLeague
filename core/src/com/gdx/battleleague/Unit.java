package com.gdx.battleleague;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public abstract class Unit {
    protected int x_;
    protected int y_;
    protected int health_;
    protected int damage_;
    protected int moveRange_;
    protected int attackRange_;
    protected Texture unitTexture_;
    protected Sprite unitSprite_;
    protected BitmapFont font;
    protected TextureRegion textureRegions;
    protected Texture healthTexture_;
    protected Sprite healthSprite_;
    protected Texture damageTexture_;
    protected Sprite damageSprite_;
    protected Animation moveAnimation;
    protected Animation attackAnimation;


    public int getX() {
        return x_;
    }

    public int getY() {
        return y_;
    }

    public int getHealth() {
        return health_;
    }

    public int getDamage() {
        return damage_;
    }

    public int getMoveRange() {
        return moveRange_;
    }

    public int getAttackRange() {
        return attackRange_;
    }

    public Texture getUnitTexture() {
        return unitTexture_;
    }

    public Sprite getUnitSprite() {
        return unitSprite_;
    }

    public void setX(int x) {
        x_=x;
    }

    public void setY(int y) {
        y_=y;
    }

    public void setHealth(int value) {
        health_ = value;
    }

    public void setDamage(int value) {
        damage_ = value;
    }

    public void setMoveRange(int value) {
        damage_ = value;
    }

    public void setAttackRange(int value) {
        attackRange_ = value;
    }

    public void setUnitTexture(Texture texture) {unitTexture_=texture;}

    public void setUnitSprite(Sprite sprite) {unitSprite_=sprite;}

    //move - перемещение по карте
    protected void move(Cell currentCell, Cell destinationCell) {
        if (currentCell.calcDistance(destinationCell) <= moveRange_ && destinationCell.isEmpty()&&destinationCell.getX()>=0&&destinationCell.getY()>=0) {
            destinationCell.setUnit(currentCell.getUnit());
            currentCell.clear();
        }
    }

    //удар противника
    protected void attack(Cell currentCell, Cell destinationCell) {

            if (currentCell.calcDistance(destinationCell) <= attackRange_) //если хватает дальности атаки и клетка занята -атакуем
                destinationCell.getUnit().setHealth(destinationCell.getUnit().getHealth() - currentCell.getUnit().getDamage());
            if (destinationCell.getUnit().getHealth() <= 0) //если атакуемый герой умер чистим клетку
                destinationCell.clear();
            if (destinationCell.getUnit() instanceof Warrior && !(currentCell.getUnit() instanceof Assasin) && destinationCell.calcDistance(currentCell) <= destinationCell.getUnit().getAttackRange()) //если в клетке куда атаковал стоит вар,то он атакует в ответ
            {
                currentCell.getUnit().setHealth(currentCell.getUnit().getHealth() - destinationCell.getUnit().getDamage());
                if (currentCell.getUnit().getHealth() <= 0) //если атаковавший умер чистим клетку
                    currentCell.clear();
            }
        }

    //функция хода
    public void makeTurn(final Cell currentCell,final Cell destinationCell,final Cell[][] map) {}

    public void render(SpriteBatch batch,int x,int y) {
      //  batch.draw(new Texture("Unit.png",Constants.LOWER_LEFT_FIELD_CORNER_X,Constants.LOWER_LEFT_FIELD_CORNER_Y,0,0,74,74)
      /*  unitTexture_=new Texture("Unit.png");
        unitSprite_=new Sprite(unitTexture_,0,0,74,74);
        unitSprite_.setPosition(map);*/
      //unitSprite_.draw(batch);
    }
    public abstract void update(float dt) ;
}
