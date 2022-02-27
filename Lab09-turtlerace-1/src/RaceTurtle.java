import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class RaceTurtle extends Turtle {
	private int nbr;

	public RaceTurtle(SimpleWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
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
