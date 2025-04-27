package dev.clerdmy.escapefromdungeon.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Player {
    private float x, y;
    private Texture texture;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        this.texture = new Texture("player.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public float getX() { return x; }
    public float getY() { return y; }
}
