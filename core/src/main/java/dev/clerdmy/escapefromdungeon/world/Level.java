package dev.clerdmy.escapefromdungeon.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clerdmy.escapefromdungeon.utils.Constants;
import dev.clerdmy.escapefromdungeon.utils.Tile;

public class Level {
    private Tile[][] tiles;
    private static final int SIZE = 32;

    public Level() {
        tiles = new Tile[SIZE][SIZE];
    }

    public void fillWithFloor(Texture floorTexture) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                tiles[x][y] = new Tile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, floorTexture);
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (tiles[x][y] != null) {
                    tiles[x][y].render(batch);
                }
            }
        }
    }
}
