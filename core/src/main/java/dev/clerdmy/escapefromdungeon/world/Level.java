package dev.clerdmy.escapefromdungeon.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clerdmy.escapefromdungeon.utils.Constants;
import dev.clerdmy.escapefromdungeon.utils.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int[][] matrix;
    private List<Tile> tiles;
    private Texture wallTexture;

    public Level(int[][] matrix) {
        this.matrix = matrix;
        this.tiles = new ArrayList<>();
        this.wallTexture = new Texture("blue.png");
        generateLevel();
    }

    private void generateLevel() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 1) {
                    tiles.add(new Tile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, wallTexture));
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Tile tile : tiles) {
            tile.render(batch);
        }
    }
}
