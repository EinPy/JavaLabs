import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private double x;
	private double y;
	private boolean pDown = false;
	private int deg = 90;
	private int width, height;
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.width = this.w.getWidth();
		this.height = this.w.getHeight();
	}

	/** Sänker pennan. */
	public void penDown() {
		pDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		pDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int) Math.round(x), (int) Math.round(y));
		double newX = x + (n*Math.cos(Math.toRadians(deg)));
		double newY = y	 - (n*Math.sin(Math.toRadians(deg))); // This negative sign messed with me for a long time
		int nX = (int) Math.round(newX);
		int nY = (int) Math.round(newY);
		if (pDown) {
			if (nX < 0) {
				nX = 0;
			}
			if (nX > width) {
				nX = (int) this.x;
			}
			if (nY < 0) {
				nY = 0;
			}
			if (nY > height) {
				nY = (int) this.y;
			}
			w.lineTo(nX,nY);
		}
		x = newX;
		y = newY;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		deg += beta;
		if (deg > 360) {
			deg = deg%360;
		}
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		deg = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return deg;
	}
}
