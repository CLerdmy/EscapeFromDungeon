package dev.clerdmy.escapefromdungeon;

/*
* libGDX
*/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.clerdmy.escapefromdungeon.screens.GameScreen;
import dev.clerdmy.escapefromdungeon.world.World;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */

public class Main extends Game {

    public SpriteBatch batch;
    public World world;

    @Override
    public void create() {
        batch = new SpriteBatch();
        world = new World();
        setScreen(new GameScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
