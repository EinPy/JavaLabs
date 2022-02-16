import java.util.Scanner;
import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.maze.Maze;


public class Driver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mazeNum = s.nextInt();
		SimpleWindow w = new SimpleWindow(600, 600, "MazeMachine");
		Turtle t = new Turtle(w, 300, 300);
		Maze maze = new Maze(mazeNum);
		MazeWalker walker = new MazeWalker(t);
		walker.walk(maze);
		
	}

}
