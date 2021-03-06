import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TurtleDrawSteps {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		int c = 1000;
		int steps = 0;
		while(c > 0) {
			steps = rand.nextInt(1,11);
			if (c-steps >= 0) {
				t.forward(steps);
			}else {
				t.forward(c);
				break;
			}
			t.left(rand.nextInt(-180,181));
			c -= steps;
		}
	}
}
