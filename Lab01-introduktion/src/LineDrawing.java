import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		int width = 500, height = 500;
		int clicks = 0;
		SimpleWindow w = new SimpleWindow(width, height, "LineDrawing");
		w.setLineWidth(3);

		while (true) {
			// vänta tills användaren klickar på en musknapp
			// rita en linje till den punkt där användaren klickade
			w.waitForEvent();
			int t = w.getEventType(); // mouseclick is associated with 1
			if (t == 1) {
				int x = w.getClickedX(), y = w.getClickedY();
				if (clicks == 0) {
					w.moveTo(x, y);
				} else {
					w.lineTo(x, y);
				}
				clicks++;
			} else if (t == 2) {
				String press = Character.toString(w.getKey());
				String word = "";
				System.out.println(press);
				while (!press.equals("\n")) {// writes after enter is pressed
					word += press;
					w.waitForEvent();
					press = Character.toString(w.getKey());
					System.out.println(word + " press:" + press); // debug output
				}
				System.out.println("no longer writing");
				w.writeText(word); // havent solved issue of writing words on top of each others
			}
		}
	}
}
