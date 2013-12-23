import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopRunner {
	public static void main(String[] args) {
		new LwjglApplication(new Engine(), "Кузьма Ворс", Engine.WINDOW_WIDTH, Engine.WINDOW_HEIGHT, false);
	}
}
