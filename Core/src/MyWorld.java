import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;
import java.util.List;

public class MyWorld {
    static final int LEVEL_SIZE = 5;
    private Player player;
    private World world;
    private BlockType[][] level;

    public MyWorld() {
        setWorld(new World(new Vector2(0, -10f), true));
        getWorld().setContactListener(new MyContactListener(getWorld()));

        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        Body boxP = getWorld().createBody(def);
        player = new Player(boxP, this);


        getPlayer().getBody().setTransform(0, 400, 0);
        getPlayer().getBody().setFixedRotation(true);

        level = LevelManager.loadLevel("level_01");
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < LEVEL_SIZE; y++) {
                if (level[x][y] == BlockType.NONE) {
                    continue;
                }
                Body boxGround = createBox(BodyDef.BodyType.StaticBody, Player.SIZE / 2, Player.SIZE / 2, 2);
                boxGround.setTransform(x * Player.SIZE, y * Player.SIZE, 0);
                boxGround.getFixtureList().get(0).setUserData(level[x][y]);
            }
        }
    }


    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Player getPlayer() {
        return player;
    }

    private Body createBox(BodyDef.BodyType type, float width, float height, float density) {
        BodyDef def = new BodyDef();
        def.type = type;
        Body box = world.createBody(def);

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);

        box.createFixture(poly, density);
        poly.dispose();

        return box;
    }


    boolean isPlayerGrounded() {
        //    world.groundedPlatform = null;
        List<Contact> contactList = world.getContactList();
        //  System.out.println(contactList.size());
        for (Contact contact : contactList) {
            try {
                if (contact.getFixtureA().getUserData().equals("player") ||
                        contact.getFixtureB().getUserData().equals("player")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
