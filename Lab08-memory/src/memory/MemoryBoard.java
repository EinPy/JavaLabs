package memory;

import java.util.Random;

public class MemoryBoard {
	private int size;
	private MemoryCardImage[][] cards;
	private String backN;
	private String[] frontNms;
	private static Random rand = new Random();
	private boolean[][] facingU;
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		this.cards = new MemoryCardImage[size][size];
		this.backN = backFileName;
		this.frontNms = frontFileNames;
		createCards(backFileName,frontFileNames);
		this.facingU = new boolean[size][size];
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String bfn, String[] ffn) {
		int placed = 0;
		for (int i = 0; i < ffn.length; i++) {
			var img = new MemoryCardImage(ffn[i], bfn);
			while (placed < 2) {
				int r = rand.nextInt(size), c = rand.nextInt(size);
				if (cards[r][c] == null) {
					cards[r][c] = img;
					placed++;
				}
			}
			placed = 0;
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return cards[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if(!facingU[r][c]) {
			facingU[r][c] = true;
		}else {
			facingU[r][c] = false;
		}
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return facingU[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return cards[r1][c1].equals(cards[r2][c2]);
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (! facingU[r][c]) {
					return false;
				}
			}
		}
		return true;
	}	
}
