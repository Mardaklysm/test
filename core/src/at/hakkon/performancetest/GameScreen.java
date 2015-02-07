package at.hakkon.performancetest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {

	private int DEFINED_HEIGHT = 1080;
	private int DEFINED_WIDTH = 1920;

	private boolean initialized = false;
	private World world;

	private OrthographicCamera camera;
	private FitViewport viewport;

	private SpriteBatch batch;

	private Skin skin;
	private Stage stage;

	private Label labelFPS;
	private Table table;

	private int lowestFPS;

	@Override
	public void show() {
		if (!initialized) {
			world = new World(new Vector2(0, 0), true);
			stage = new Stage();

			camera = new OrthographicCamera(DEFINED_WIDTH, DEFINED_HEIGHT);
			viewport = new FitViewport(DEFINED_WIDTH, DEFINED_HEIGHT, camera);

			viewport.apply();

			camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
			batch = new SpriteBatch();

			initialized = true;

			createUI();
		}

	}

	private void createUI() {
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		table = new Table();
		labelFPS = new Label("FPS: --", skin, "default");
		table.left().top().add(labelFPS).pad(10);

		table.setFillParent(true);
		
		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		clearScreen();

		setCameraPosition();

		// Advance physics calculations
		world.step(1f / 60f, 6, 2);

		batch.begin();

		// drawBackground();

		batch.setProjectionMatrix(camera.combined);

		updateUI();

		batch.end();

		stage.act();
		stage.draw();

	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 200, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	private void updateUI() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = PerformanceTest.FONT_SIZE_0;

		int fps = Gdx.graphics.getFramesPerSecond();
		lowestFPS = fps;

		labelFPS.setStyle(labelStyle);
		labelFPS.setText("FPS: " + fps + " (" + lowestFPS + ")");
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	private void setCameraPosition() {
		camera.position.y = 0;
		camera.position.x = 0;
		camera.update();

	}

}
