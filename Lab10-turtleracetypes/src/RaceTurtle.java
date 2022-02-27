import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class RaceTurtle extends Turtle {
	protected int nbr;
	private int x, y;

	public RaceTurtle(SimpleWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		this.x = RaceWindow.getStartXPos(nbr);
		this.y = RaceWindow.getStartYPos(nbr);
		left(-90);
		penDown();
	}
	
	public void raceStep(){
		Random rand = new Random();
		int steps = rand.nextInt(7);
		forward(steps);
	}
	
	public String toString() {
		return " Nummer " + nbr + "\n";
	}
}
