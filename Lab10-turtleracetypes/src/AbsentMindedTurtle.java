import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class AbsentMindedTurtle extends RaceTurtle{
	private String type;
	private int confused;
	Random rand = new Random();
	
	public AbsentMindedTurtle(SimpleWindow w, int nbr, String type) {
		super(w, nbr);
		this.type = type;
		this.confused = rand.nextInt(101);
	}
	
	public void raceStep(){
		int degree = rand.nextInt(101);
		if (confused < degree) {
			super.raceStep();
		}
	}
	
	public String toString() {
		return " Nummer " + nbr + " - " + type + " (" + confused + "% Frånvarande)";
	}
}
