import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Tablet extends JPanel implements Runnable {

	ArrayList<Entity> entitys;
	KeyboardListener listen;
	
	public Tablet(){
		listen = new KeyboardListener();
		this.addKeyListener(listen);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Toolkit tk = Toolkit.getDefaultToolkit();
        Image ia = tk.getImage(getClass().getResource("gobby_idleL_strip8.png"));
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}

}
