import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player {
    final static float MAX_VELOCITY = 3f;
    public final static float SPEED = 40;
    public final static float SIZE = 32;
    public static final float GROUND_FRICTION = 1.6f;
    private static final float MAX_SPEED = 30;
    private final MyWorld context;

    public Fixture playerPhysicsFixture;
    public Fixture playerSensorFixture;
    Body box;
    private boolean moveRight;
    private boolean moveLeft;
    private boolean grounded;

    public Player(Body box, MyWorld myWorld) {
        this.box = box;
        this.context = myWorld;
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(SIZE - SIZE / 4, SIZE - SIZE / 4);
        playerPhysicsFixture = box.createFixture(poly, 0);
        playerPhysicsFixture.setUserData("player");
        poly.dispose();

        CircleShape circle = new CircleShape();
        circle.setRadius(SIZE - SIZE / 4);
        circle.setPosition(new Vector2(0, 0));
        playerSensorFixture = box.createFixture(circle, 0);

        //setFriction(200F);
        circle.dispose();

        box.setBullet(true);
        setFriction(GROUND_FRICTION);

        MassData data = new MassData();
        data.mass = 1f;
        box.setMassData(data);
        box.setGravityScale(1f);

    }

    public float getFriction() {
        return playerSensorFixture.getFriction();
    }

    public Body getBody() {
        return box;
    }

    public void setFriction(float f) {
        playerSensorFixture.setFriction(f);
        playerPhysicsFixture.setFriction(f);
    }

    public Vector2 getPosition() {
        return box.getPosition();
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    Vector2 velocity = new Vector2();

    public void update(float delta) {
        grounded = context.isPlayerGrounded();
        if (!grounded) {
            setFriction(0);
        } else {
            setFriction(GROUND_FRICTION);
        }

        if (grounded && isJump) {
            box.applyLinearImpulse(0, 60f, box.getPosition().x, box.getPosition().y);
            // box.applyForceToCenter(1000, 1000);

            isJump = false;
        }
        if (moveRight && box.getLinearVelocity().x < MAX_SPEED) {
            box.applyLinearImpulse(2f, 0, box.getPosition().x, box.getPosition().y);
            //    moveRight = false;
        }
        if (moveLeft && box.getLinearVelocity().x > -MAX_SPEED) {
            box.applyLinearImpulse(-2f, 0, box.getPosition().x, box.getPosition().y);
            //    moveRight = false;
        }
        if (box.getLinearVelocity().x > MAX_SPEED) {
            box.getLinearVelocity().x = MAX_SPEED;
        } else if (box.getLinearVelocity().x < -MAX_SPEED) {
            box.getLinearVelocity().x = -MAX_SPEED;
        }
      /*  if (box.getLinearVelocity().y == 0) {
            box.applyLinearImpulse(0, -0.5f, box.getPosition().x, box.getPosition().y);
        }   */
    }

    boolean isJump = false;

    public void jump() {
        isJump = true;
    }

    public void resetVelocity() {
        getVelocity().x = 0;
        moveRight = false;
        moveLeft = false;
        //   getVelocity().y = 0;
    }

    public void moveRight() {
        moveRight = true;

    }

    public void moveLeft() {
        moveLeft = true;

    }
}
