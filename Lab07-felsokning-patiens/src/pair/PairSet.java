package pair;
import java.util.Random;
import java.util.Vector;

public class PairSet {
	private int n;
	//unsure if allowed to use vector, 
	//however data type requirements were not specifically articulated
	private Vector<Pair> pairs;
	private static Random rand = new Random();

	/** Skapar en mängd av alla talpar (a,b) sådana att
        0 <= a < rows  och  0 <= b < cols */
	public PairSet(int rows, int cols) {
		n = rows * cols;
		pairs = new Vector<Pair>(n);
		int ind = 0;
		for (int suit = 0; suit < rows; suit++) {
			for (int val = 0; val < cols; val++) {
				pairs.add(ind, new Pair(suit, val));
				ind += 1;
			}
		}
//		System.out.println(pairs.toString());
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		return ! pairs.isEmpty();
		// or return n == 0;
	}

	/** Hämtar ett slumpmässigt valt talpar ur mängden. Mängden
	 	blir ett element mindre. Om mängden är tom returneras null. */
	public Pair pick() {
		if (! more()) {
			return null;
		}
		int r = rand.nextInt(n);
		Pair p = pairs.get(r);
		pairs.remove(r);
		n-= 1;
		return p;
	}
}
