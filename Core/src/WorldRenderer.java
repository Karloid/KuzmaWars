import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldRenderer {
    Box2DDebugRenderer renderer;
    //private SpriteBatch spriteBatch;
    MyWorld world;
    public OrthographicCamera cam;

    private SpriteBatch spriteBatch;
    Texture texture;
    public Map<BlockType, TextureRegion> textureRegions;// = new HashMap<String, TextureRegion>();

    public WorldRenderer(MyWorld world, OrthographicCamera cam) {
        renderer = new Box2DDebugRenderer();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        this.world = world;
        //spriteBatch = new SpriteBatch();
        //this.cam = new OrthographicCamera(30, 30);
        //setCamera(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);
        spriteBatch = new SpriteBatch();
        textureRegions = new HashMap<BlockType, TextureRegion>();
        loadTextures();
        this.cam = cam;
        setCamera(cam.viewportWidth / 2f, cam.viewportWidth / 2f);

    }


    private void loadTextures() {

        texture = new Texture(Gdx.files.internal("res/atlas.png"));
        TextureRegion tmpLeftRight[][] = TextureRegion.split(texture, texture.getWidth() / 2, texture.getHeight() / 2);
        TextureRegion left2[][] = tmpLeftRight[0][0].split(tmpLeftRight[0][0].getRegionWidth() / 2, tmpLeftRight[0][0].getRegionHeight());
        TextureRegion left[][] = left2[0][0].split(left2[0][0].getRegionWidth() / 4, left2[0][0].getRegionHeight() / 8);

        textureRegions.put(BlockType.PLAYER, left[0][0]);
        textureRegions.put(BlockType.BRICK1, left[0][1]);
        textureRegions.put(BlockType.BRICK2, left[1][0]);
        textureRegions.put(BlockType.BRICK3, left[1][1]);


        // textureRegions.put("navigation-arrows", tmpLeftRight[0][1]);

        //  TextureRegion rightbot[][] = tmpLeftRight[1][1].split(tmpLeftRight[1][1].getRegionWidth() / 2, tmpLeftRight[1][1].getRegionHeight() / 2);

        //  textureRegions.put("khob", rightbot[0][1]);

    }


    public void setCamera(float x, float y) {
        this.cam.position.set(x, y, 0);

        this.cam.update();
    }

    public void dispose() {

        //   world.dispose();
    }

    BitmapFont font;


    public void render(float delta) {
        //  System.out.println(cam.position);
        world.getPlayer().update(delta);
        updateCamera();
        spriteBatch.begin();

        //  font.setColor(Color.WHITE);
        drawBlocks();
        //    drawPlatforms();
        drawPlayer();
        font.drawMultiLine(spriteBatch,
                "friction: " + world.getPlayer().getFriction() + "\ngrounded: " +
                        "\nvelocityX:" + world.getPlayer().box.getLinearVelocity().x + "\nvelocityY:" + world.getPlayer().box.getLinearVelocity().y,
                400, 400);
        spriteBatch.end();
        cam.update();
        //   renderer.render(world.getWorld(), cam.combined);
        world.getWorld().step(delta, 1, 1);
        world.getWorld().step(delta, 1, 1);
        world.getWorld().step(delta, 1, 1);
        world.getWorld().step(delta, 1, 1);
        world.getWorld().step(delta, 1, 1);
        world.getWorld().step(delta, 1, 1);
        //   world.getWorld().step(delta, 1, 1);
        //   world.getWorld().step(delta, 1, 1);
        //  world.getWorld().step(delta, 1, 1);
    }

    private void updateCamera() {
        cam.position.x = world.getPlayer().getBody().getPosition().x;// - Engine.WINDOW_WIDTH / 16;
        cam.position.y = world.getPlayer().getBody().getPosition().y;// + Engine.WINDOW_HEIGHT ;


    }


    private void drawPlatforms() {
       /* for (MovingPlatform platform : world.getPlatforms()) {
            spriteBatch.draw(textureRegions.get("brick2"), (platform.getBody().getPosition().x - platform.width / 2) * ppuX,
                    (platform.getBody().getPosition().y - platform.height / 2) * ppuY, platform.width * ppuX, platform.height * ppuY);

        }   */
    }

    private void drawBlocks() {
        for (Iterator<Body> iter = world.getWorld().getBodies(); iter.hasNext(); ) {
            Body body = iter.next();
            if (body != null && body.getFixtureList().get(0).getUserData() != null && body.getFixtureList().get(0).getUserData() != "player")
                spriteBatch.draw(textureRegions.get(body.getFixtureList().get(0).getUserData()), body.getPosition().x + cam.viewportWidth / 2 - cam.position.x - Player.SIZE / 2,
                        (body.getPosition().y) + cam.viewportHeight / 2 - cam.position.y - Player.SIZE / 2, Player.SIZE, Player.SIZE);
        }


    }


    private void drawPlayer() {

        //    System.out.println("draw plaer: " + (world.getPlayer().getPosition().x - Player.SIZE / 2) + ' ' + (world.getPlayer().getPosition().y - Player.SIZE / 2));

        spriteBatch.draw(textureRegions.get(BlockType.PLAYER), (cam.viewportWidth / 2 - (Player.SIZE * 2 - Player.SIZE / 4) / 2),
                cam.viewportHeight / 2 - (Player.SIZE * 2 - Player.SIZE / 4) / 2,
                Player.SIZE * 2 - Player.SIZE / 4, Player.SIZE * 2 - Player.SIZE / 4);

    }
}
