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
		entitys.add(new Zombie(ib,ib,ib,ib,50,50));
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {

		window.setColor(Color.BLACK);
		window.fillRect(0, 0, AP_compsci_Game.WIDTH, AP_compsci_Game.HEIGHT);

		if (gameMode == 0) {
			for (int i = 0; i < entitys.size(); i++) {
				Entity e = entitys.get(i);
				e.move(this);
				e.draw(window, this);
				if (e.isDead()) {
					e.onDeath(this);
					entitys.remove(i);
					i--;
				}
			}
			for(Entity e : entitys){
				for(Entity r : entitys){
					if(e.colliding(r)){
						e.onCollide(r,this);
						System.out.println("COLLITION");
					}
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
			window.setColor( Color.WHITE );
	        window.setFont(new Font("TAHOMA",Font.BOLD,18));
	        window.drawString("GAME OVER", 20,20);
		}

		//System.out.println(player.x + " " + player.y);
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
