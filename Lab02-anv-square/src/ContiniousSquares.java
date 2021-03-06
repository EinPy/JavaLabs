import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class ContiniousSquares {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(1080, 720, "DrawSquare");
		int x = 10, y = 10, side = 100;
		Square sq = new Square(x, y, side);
		sq.draw(w);
		boolean running = true;
		while (running) {
			w.waitForMouseClick();
			double newX = w.getClickedX(), newY = w.getClickedY();
			double dx = newX - x;
			double dy = newY - y;
			int stepX = (int) Math.round(dx / 10), stepY = (int) Math.round(dy / 10);
			for (int i = 0; i <= 10; i++) {
				sq.move(stepX, stepY);
				sq.draw(w);
			}
			x = (int) newX;
			y = (int) newY;
		}

	}

}
