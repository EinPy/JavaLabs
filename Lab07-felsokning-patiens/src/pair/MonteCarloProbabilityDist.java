package pair;

public class MonteCarloProbabilityDist {//is there a naming convention for long names?
	private static final int NBR_ITERATIONS = 10000000;//10000000 takes about 10 sek on wrkst
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int pat = 0, not = 0;
		for (int i = 0; i < NBR_ITERATIONS; i++) {
			if (sim()) {
				pat++;
			}else {
				not++;
			}
		}
		System.out.println(pat +" " + not);
		double out = (double) pat/(double) not;
		System.out.println(out);
		System.out.println(Math.abs(out - 0.008165));
		//sample test results with itr as 1e7
		//0.008273387279320464
		//1.0838727932046405E-4
	}
	private static boolean sim() {
		var cardDeck = new PairSet(4, 13);
		int count = 1;
		while (cardDeck.more()) {
			Pair p = cardDeck.pick();
			int rank= p.second();
			switch(count) {
			//Ace is assumed to have a value of 1
			//Since cards values start at 0, every value is subtracted by 1
				case 1:
					if (rank == 0) {
						return false;
					}
					count++;
					break;
				case 2:
					if (rank == 1) {
						return false;
					}
					count++;
					break;
				case 3:
					if (rank == 2) {
						return false;
					}
					count = 1;
					break;
			}
		}
		return true;
	}

}
