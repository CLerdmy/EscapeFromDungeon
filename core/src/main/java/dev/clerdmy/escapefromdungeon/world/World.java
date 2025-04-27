package dev.clerdmy.escapefromdungeon.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
    private Level[][] levels;
    private static final int SIZE = 10;
    private int currentLevelX, currentLevelY;
    private Texture floorTexture;

    public World() {
        levels = new Level[SIZE][SIZE];
        floorTexture = new Texture("blue.png");

        currentLevelX = SIZE / 2;
        currentLevelY = SIZE / 2;
        levels[currentLevelX][currentLevelY] = new Level();
        levels[currentLevelX][currentLevelY].fillWithFloor(floorTexture);
    }

    public void render(SpriteBatch batch) {
        Level currentLevel = levels[currentLevelX][currentLevelY];
        if (currentLevel != null) {
            currentLevel.render(batch);
        }
    }

    public Level getCurrentLevel() {
        return levels[currentLevelX][currentLevelY];
    }
}
