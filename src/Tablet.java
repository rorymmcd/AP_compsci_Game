import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Tablet extends JPanel implements Runnable {

	ArrayList<Entity> entitys;
	KeyboardListener listen;
	Player player;
	
	public Tablet(){
		listen = new KeyboardListener();
		this.addKeyListener(listen);
		Toolkit tk = Toolkit.getDefaultToolkit();
        Image ia = tk.getImage(getClass().getResource("gobby_idleL_strip8.png"));
        player = new Player(ia,ia,ia,400,300);
        entitys = new ArrayList<Entity>();
        entitys.add(player);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		player.setKey(0, listen.getKey(0));
		player.setKey(1, listen.getKey(1));
		player.setKey(2, listen.getKey(2));
		player.setKey(3, listen.getKey(3));
		for(Entity e : entitys){
			e.move();
			e.draw(window,this);
		}
		//player.move();
		//player.draw(window, this);
		System.out.println(listen.getKey(0)+" "+listen.getKey(1));
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
