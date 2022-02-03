import se.lth.cs.pt.window.SimpleWindow;
public class Mole {
	Graphics g = new Graphics(30, 50, 10);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0,0,30,50, Colors.SKY);
		g.rectangle(0,15,30,50, Colors.SOIL);
	}
	
	public void dig() {
		int x = g.getWidth() / 2; // För att börja på mitten
		int y = g.getHeight() / 2;
		while (true) {
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			g.block(x, y, Colors.TUNNEL);
			if (key == 'w') {
				y -= 1;
			}
			else if (key == 'a') {
				x -= 1;
			}
			else if (key == 's') {
				y += 1;
			}
			else if (key == 'd' ){
				x += 1;
			}
		}
	}
}




