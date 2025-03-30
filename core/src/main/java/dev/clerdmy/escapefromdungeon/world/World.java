package dev.clerdmy.escapefromdungeon.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clerdmy.escapefromdungeon.utils.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Level> levels;
    private int currentLevelIndex;

    public World() {
        levels = new ArrayList<>();
        int[][] defaultMatrix = {
            {1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0}
        };
        levels.add(new Level(defaultMatrix));
        currentLevelIndex = 0;
    }

    public void render(SpriteBatch batch) {
        levels.get(currentLevelIndex).render(batch);
    }
}

