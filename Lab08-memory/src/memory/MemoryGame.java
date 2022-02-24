package memory;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String back = "back.jpg";
		
		// Fyll i egen kod här
		int size = 4;
		var board = new MemoryBoard(size, back, frontFileNames);
		var window = new MemoryWindow(board);
		window.drawBoard();
		boolean playing = true;
		
		int moves = 0;
		int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
		while(playing) {
			boolean found = false;
			while (! found) {
				window.waitForMouseClick();
				r1 = window.getMouseRow();
				c1 = window.getMouseCol();
				if (! board.frontUp(r1,c1)) {
					board.turnCard(r1,c1);
					window.drawCard(r1,c1);
					found = true;
				}
			}
			found = false;
			while (! found) {
				window.waitForMouseClick();
				r2 = window.getMouseRow();
				c2 = window.getMouseCol();
				if (! board.frontUp(r2,c2)) {
					board.turnCard(r2,c2);
					window.drawCard(r2,c2);
					found = true;
				}
			}
			
			moves ++;
			if (board.same(r1, c1, r2, c2)) {
				if (board.hasWon()) {
					System.out.print("CONGRATULATIONS, you won in" + moves + "moves");
				}
			}else {
				SimpleWindow.delay(1000);
				board.turnCard(r1,c1);
				board.turnCard(r2,c2);
				window.drawBoard();
			}
		}
		
		
	}
	/*
	private int[] newCard(MemoryWindow window, MemoryBoard board) {
		int r = 0, c = 0;
		boolean found = false;
		while (! found) {
			window.waitForMouseClick();
			r = window.getMouseRow();
			c = window.getMouseCol();
			if (! board.frontUp(r,c)) {
				board.turnCard(r,c);
				window.drawCard(r,c);
				found = true;
			}
		}
		return {r, c};
	}
	*/
}
