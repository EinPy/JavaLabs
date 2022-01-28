import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawThreeSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		int x = 250, y = 250, side = 100;
		Square sq = new Square(x, y, side);
		sq.draw(w);
		sq.move(-side / 2, side / 4);
		sq.draw(w);
		sq.move(side / 4, side / 4);
		sq.draw(w);
	}
}
