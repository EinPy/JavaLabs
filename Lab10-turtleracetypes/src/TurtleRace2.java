import java.util.ArrayList;
import java.util.Random;

public class TurtleRace2 {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> turds = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> order = new ArrayList<RaceTurtle>();
		Random rand = new Random();
		String[] lables = {"MoleTurtle", "AbsentMindedTurtle", "DizzyTurtle"};
		
		for (int id = 1; id <= 8; id++) {
			int type = rand.nextInt(3);
			switch (type){
			case 0:
				turds.add(new MoleTurtle(w,id,lables[type]));
				break;
			case 1:
				turds.add(new AbsentMindedTurtle(w,id,lables[type]));
				break;
			case 2:
				turds.add(new DizzyTurtle(w,id,lables[type]));
				break;
			}
			
		}
		for(RaceTurtle t : turds) {
			System.out.println(t);
		}
		System.out.println("\n\n");
		
		while (turds.size()>5) {
			//favous turtles with low startnumbers as they automatically win
			//if multiple turtles hav traversed the same number of steps
			for (int i = 0; i < turds.size(); i++) {
				if (turds.get(i).getX() < RaceWindow.X_END_POS) {
					turds.get(i).raceStep();
				}else {
					order.add(turds.get(i));
					turds.remove(i);
				}
			}
			RaceWindow.delay(10);
		}
		scores(order);
	}
	
	private static void scores(ArrayList<RaceTurtle> order) {
		for (int p = 0; p <= 2; p++) {
			System.out.printf("På plats %d: ", p+1);
			System.out.println(order.get(p));
		}
	}
}
