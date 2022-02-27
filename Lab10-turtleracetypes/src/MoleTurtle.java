import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class MoleTurtle extends RaceTurtle{
	private String type;
	Random rand = new Random();

	public MoleTurtle(SimpleWindow w, int nbr, String type) {
		super(w, nbr);
		this.type = type;
	}
	
	public void raceStep(){
		int down = rand.nextInt(2);
		if (down == 1) {
			penUp();
		}else {
			penDown();
		}
		super.raceStep();
	}
	
	public String toString() {
		return " Nummer " + nbr + " - " + type;
	}
}
