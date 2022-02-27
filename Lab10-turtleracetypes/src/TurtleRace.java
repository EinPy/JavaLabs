import java.util.ArrayList;

public class TurtleRace {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		ArrayList<RaceTurtle> turds = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> order = new ArrayList<RaceTurtle>();
		
		for (int id = 1; id <= 8; id++) {
			turds.add(new RaceTurtle(w,id));
		}
		
		while (turds.size()>0) {
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
