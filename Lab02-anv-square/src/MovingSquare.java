import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class MovingSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		int x = 250, y = 250, side = 100;
		Square sq = new Square(x, y, side);
		sq.draw(w);
		boolean running = true;
		while (running) {
			w.waitForMouseClick();
			sq.erase(w);
			int newX = w.getClickedX(), newY = w.getClickedY();
			int dx = newX - x;
			int dy = newY - y;
			sq.move(dx, dy);
			sq.draw(w);
			x = newX;
			y = newY;
		}
	}
}
