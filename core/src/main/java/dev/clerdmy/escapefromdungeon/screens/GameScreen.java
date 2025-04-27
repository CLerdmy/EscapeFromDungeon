package dev.clerdmy.escapefromdungeon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.clerdmy.escapefromdungeon.Main;
import dev.clerdmy.escapefromdungeon.entities.Player;
import dev.clerdmy.escapefromdungeon.utils.Constants;
import dev.clerdmy.escapefromdungeon.world.World;

public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Player player;
    private World world;
    private Main game;
    private Viewport viewport;

    private final float VIRTUAL_WIDTH = 800;
    private final float VIRTUAL_HEIGHT = 600;

    public GameScreen(Main game) {
        this.game = game;
        this.batch = game.batch;
        this.world = game.world;
        this.player = new Player(0, 0);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
        viewport.apply();
        camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        world.render(batch);
        player.render(batch);
        batch.end();

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) player.move(0, 2);
        if (Gdx.input.isKeyPressed(Input.Keys.S)) player.move(0, -2);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) player.move(-2, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D)) player.move(2, 0);
        camera.position.set(player.getX(), player.getY(), 0);

        float halfViewportWidth = camera.viewportWidth / 2;
        float halfViewportHeight = camera.viewportHeight / 2;
        float levelWidth = Constants.TILE_SIZE * 32;
        float levelHeight = Constants.TILE_SIZE * 32;

        if (camera.position.x - halfViewportWidth < 0)
            camera.position.x = halfViewportWidth;
        if (camera.position.x + halfViewportWidth > levelWidth)
            camera.position.x = levelWidth - halfViewportWidth;

        if (camera.position.y - halfViewportHeight < 0)
            camera.position.y = halfViewportHeight;
        if (camera.position.y + halfViewportHeight > levelHeight)
            camera.position.y = levelHeight - halfViewportHeight;

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(player.getX(), player.getY(), 0);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
    }
}
