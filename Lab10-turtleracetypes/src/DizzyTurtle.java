import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class DizzyTurtle extends RaceTurtle{
	private String type;
	private int drunk;
	Random rand = new Random();
	
	
	public DizzyTurtle(SimpleWindow w, int nbr, String type) {
		super(w, nbr);
		this.type = type;
		this.drunk = rand.nextInt(5)+1;
	}
	
	public void raceStep(){
		int turn = (rand.nextInt(5) - 2) * drunk;
		left(turn);
		super.raceStep();
	}
	
	public String toString() {
		return " Nummer " + nbr + " - " + type + " (Yrsel: " + drunk + ")";
	}

}
