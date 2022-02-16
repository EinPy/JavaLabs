import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle t;

	
	public MazeWalker (Turtle t) {
		this.t = t;
		this.t.penDown();
	}
	public void walk (Maze maze) {
		int x = maze.getXEntry();
		int y = maze.getYEntry();
		t.jumpTo(x,y);
		while(!maze.atExit(t.getX(),t.getY())) {
			if (!maze.wallAtLeft(t.getDirection(),t.getX(),t.getY())){
				t.left(90);
				t.forward(1);
				
			}else if (!maze.wallInFront(t.getDirection(),t.getX(),t.getY())){
				t.forward(1);
				
			}else if (!maze.wallInFront(t.getDirection()-90, t.getX(),t.getY())) {
				t.left(-90);
				t.forward(1);
				
			}else {
				t.left(180);
				t.forward(1);
			}
//			SimpleWindow.delay(3);
		}
		System.out.println("REACHED GOAL");
	}
}