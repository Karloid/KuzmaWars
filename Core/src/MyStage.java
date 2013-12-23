import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyStage implements InputProcessor {
    public final MyWorld world;

    public MyStage(int windowWidth, int windowHeight, boolean b, SpriteBatch batch) {
        //    super(windowWidth, windowHeight, b, batch);
        System.out.println("create stage");
        world = new MyWorld();

    }

    @Override
    public boolean keyDown(int i) {
        Player player = world.getPlayer();
        //  System.out.println( i );
        if (i == 32)
            //    player.getVelocity().x = Player.SPEED;
            player.moveRight();


        if (i == 29)
         //   player.getVelocity().x = -Player.SPEED;
            player.moveLeft();

        if (i == 62)
            player.jump();
        //System.out.println(player.getVelocity() + " velocity");
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean keyUp(int i) {
        world.getPlayer().resetVelocity();
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean keyTyped(char c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean touchDown(int i, int i2, int i3, int i4) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean touchUp(int i, int i2, int i3, int i4) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean touchDragged(int i, int i2, int i3) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean touchMoved(int i, int i2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean scrolled(int i) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
