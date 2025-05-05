package dev.clerdmy.escapefromdungeon.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clerdmy.escapefromdungeon.utils.Constants;

public class Player {

    private static final Player instance = new Player();
    private final Texture texture;
    private int x;
    private int y;

    private Player() {
        this.texture = new Texture("player.png");
        this.x = 0;
        this.y = 0;
    }

    public static Player getInstance() {
        return instance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

    public void dispose() {
        texture.dispose();
    }

}
