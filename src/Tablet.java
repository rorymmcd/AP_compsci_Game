import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Tablet extends JPanel implements Runnable {

	ArrayList<Entity> entitys;
	KeyboardListener listen;
	Player player;
	Timer timer;
	public int gameMode;//0-playing 1-paused 2-over

	public Tablet() {
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Entity en : entitys) {
					en.incFrame();
				}
			}
		});
		timer.start();

		gameMode = 0;
		listen = new KeyboardListener();
		this.addKeyListener(listen);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image ia = tk
				.getImage(getClass().getResource("gobby_idleL_strip8.png"));
		Image ib = tk
				.getImage(getClass().getResource("gobby_moveL_strip6.png"));
		Image ic = tk
				.getImage(getClass().getResource("gobby_moveR_strip6.png"));
		player = new Player(ia, ib, ic, 400, 300);
		entitys = new ArrayList<Entity>();
		entitys.add(player);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		player.setKey(0, listen.getKey(0));
		player.setKey(1, listen.getKey(1));
		player.setKey(2, listen.getKey(2));
		player.setKey(3, listen.getKey(3));

		window.setColor(Color.BLACK);
		window.fillRect(0, 0, AP_compsci_Game.WIDTH, AP_compsci_Game.HEIGHT);

		if (gameMode == 0) {
			for (int i = 0; i < entitys.size(); i++) {
				Entity e = entitys.get(i);
				e.move();
				e.draw(window, this);
				if (e.isDead()) {
					entitys.remove(i);
					i--;
				}
			}
			if(player.isDead())gameMode = 2;
			if(listen.getKey(5))gameMode = 1;
		}
		
		else if(gameMode == 1){
			window.setColor( Color.WHITE );
	        window.setFont(new Font("TAHOMA",Font.BOLD,18));
	        window.drawString("PAUSED", 20,20);
	        if(listen.getKey(5))gameMode = 0;
		}
		
		else if(gameMode == 2){
			
		}

		System.out.println(player.x + " " + player.y);
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
