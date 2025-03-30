package dev.clerdmy.escapefromdungeon.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
    private int x, y;
    private Texture texture;

    public Tile(int x, int y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}
