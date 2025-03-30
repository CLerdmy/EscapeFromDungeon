package dev.clerdmy.escapefromdungeon;

/*
* libGDX
*/

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
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
