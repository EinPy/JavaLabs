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
		while(playing) {
			window.waitForMouseClick();
			int r1 = window.getMouseRow();
			int c1 = window.getMouseCol();
			board.turnCard(r1,c1);
			window.drawCard(r1,c1);
			window.waitForMouseClick();
			int r2 = window.getMouseRow();
			int c2 = window.getMouseCol();
			board.turnCard(r2,c2);
			window.drawCard(r2,c2);
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
}
