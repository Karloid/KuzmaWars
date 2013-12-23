
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Engine implements ApplicationListener {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final short TILE_SIZE = 64;
    private SpriteBatch batch;
    private MyStage stage;
    public OrthographicCamera cam;
    public static BitmapFont font;
    private WorldRenderer renderer;
    private long lastRender;

    @Override
    public void create() {
        //   loadFont();
        lastRender = System.currentTimeMillis();
        System.out.println("try create Stage...");
        this.cam = new OrthographicCamera(WINDOW_WIDTH, WINDOW_HEIGHT);
        batch = new SpriteBatch();
        stage = new MyStage(WINDOW_WIDTH, WINDOW_HEIGHT, false, batch);
        renderer = new WorldRenderer(stage.world, cam);
        Gdx.input.setInputProcessor(stage);
    }

    private void loadFont() {
        font = new BitmapFont(Gdx.files.internal("batyushka/res/rotorBoyShadow.fnt"),
                Gdx.files.internal("batyushka/res/rotorBoyShadow.png"), false);
        font.setColor(Color.WHITE);
        font.scale(1f);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        long delta = System.currentTimeMillis() - lastRender;
        // System.out.println(delta);
        GL10 gl = Gdx.graphics.getGL10();
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        //gl.
        renderer.render(1f / 60f);
        lastRender = System.currentTimeMillis();
        //	stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        /**
         * Когда мы меняем размеры экрана, мы меняем и размеры области просмотра нашего Stage
         */
        //	stage.setViewport(width, height, true);
    }

    @Override
    public void resume() {
    }

}
