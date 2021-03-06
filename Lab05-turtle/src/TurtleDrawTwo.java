import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TurtleDrawTwo {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350,350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		
		int steps = 0;
		while(dist(t1.getX(),t1.getY(),t2.getX(),t2.getY()) > 50) {
			steps = rand.nextInt(1,11);
			t1.forward(steps);
			t1.left(rand.nextInt(-180,181));
			
			steps = rand.nextInt(1,11);
			t2.forward(steps);
			t2.left(rand.nextInt(-180,181));
			
			SimpleWindow.delay(5);
		}
		
	}
 	private static int dist(int x1, int y1, int x2, int y2) {
 		int dist = 0;
 		int xC = x2-x1;
 		int yC = y2 - y1;
 		dist = (int) Math.sqrt(xC * xC + yC * yC);
 		return dist;
 	}
}
