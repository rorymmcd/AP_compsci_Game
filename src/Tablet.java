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
	public int gameMode;// 0-playing 1-paused 2-over
	private int time;

	public Tablet() {
		timer = new Timer(100, new ActionListener() {
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
		Sword_entity.sprite_sheet = tk.getImage(getClass().getResource("Swords.png"));
		Sword_item.sword_icon = tk.getImage(getClass().getResource("Sword_icon.png"));
		Player.l = tk.getImage(getClass().getResource("Player_left.png"));
		Player.u = tk.getImage(getClass().getResource("Player_back.png"));
		Player.r = tk.getImage(getClass().getResource("Player_right.png"));
		Player.d = tk.getImage(getClass().getResource("Player_forward.png"));
		Zombie.l = tk.getImage(getClass().getResource("gobby_moveL_strip6.png"));
		Zombie.u = tk.getImage(getClass().getResource("gobby_moveL_strip6.png"));
		Zombie.r = tk.getImage(getClass().getResource("gobby_moveL_strip6.png"));
		Zombie.d = tk.getImage(getClass().getResource("gobby_moveL_strip6.png"));
		HealthPot.HealthPot_icon = tk.getImage(getClass().getResource("Potion_icon.png"));
		
		player = new Player(400, 300);
		entitys = new ArrayList<Entity>();
		entitys.add(player);
		entitys.add(new ItemEntity((int)(Math.random()*600)+100, (int)(Math.random()*400)+100,new Sword_item()));
		//player.addItem(new Sword_item(), this);
		player.addItem(new HealthPot(), this);
		player.addItem(new HealthPot(), this);
		for(int i = 0; i < 10; i++)entitys.add(new Zombie((int)(Math.random()*600)+100, (int)(Math.random()*400)+100));
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {

		window.setColor(new Color(50,100,50));
		window.fillRect(0, 0, AP_compsci_Game.WIDTH, AP_compsci_Game.HEIGHT);

		if (gameMode == 0) {
			time++;
			
			int rand = (int)(Math.random()*10000);
			if(rand<10)
				entitys.add(new Zombie((int)(Math.random()*600)+100, (int)(Math.random()*400)+100));
			else if(rand<12)
				entitys.add(new ItemEntity((int)(Math.random()*600)+100, (int)(Math.random()*400)+100,new HealthPot()));
			
			//move and draw
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
			//handle collitions
			for (int i = 0; i < entitys.size(); i++) {
				Entity e = entitys.get(i);
				for (int j = i + 1; j < entitys.size(); j++) {
					Entity r = entitys.get(j);
					if (e.colliding(r)) {
						e.onCollide(r, this);
						r.onCollide(e, this);
						//System.out.println("COLLITION");
					}
				}
			}
			//draw gui
			window.setColor(Color.WHITE);
			window.drawLine(AP_compsci_Game.WIDTH-200, 0, AP_compsci_Game.WIDTH-200, AP_compsci_Game.HEIGHT);
			window.setFont(new Font("TAHOMA", Font.BOLD, 18));
			window.drawString("PLAYER HEALTH", AP_compsci_Game.WIDTH-190, 20);
			window.drawString(player.getHealth()+"/25", AP_compsci_Game.WIDTH-190, 40);
			window.drawString("TIME", AP_compsci_Game.WIDTH-190, 62);
			window.drawString(time+"", AP_compsci_Game.WIDTH-190, 84);
			//draw items
			for(int i = 0; i < player.inventory.size(); i++){
				window.drawImage(player.inventory.get(i).icon,(AP_compsci_Game.WIDTH-190)+(40*(i%2)),114+(40*(i/2)),this);
			}
			window.setColor(Color.BLUE);
			window.drawRect((AP_compsci_Game.WIDTH-190)+(40*(player.selectedItem%2)), 114+(40*(player.selectedItem/2)), 32, 32);
			
			if (player.isDead())
				gameMode = 2;
			if (listen.getKey(5))
				gameMode = 1;
		}

		else if (gameMode == 1) {
			window.setColor(Color.WHITE);
			window.setFont(new Font("TAHOMA", Font.BOLD, 18));
			window.drawString("PAUSED", 20, 20);
			if (listen.getKey(5))
				gameMode = 0;
		}

		else if (gameMode == 2) {
			window.setColor(Color.WHITE);
			window.setFont(new Font("TAHOMA", Font.BOLD, 18));
			window.drawString("GAME OVER", 20, 20);
			window.drawString("TIME: "+time, 20,42);
		}

		// System.out.println(player.x + " " + player.y);
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
