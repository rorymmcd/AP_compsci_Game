import java.awt.Graphics;
import java.awt.Image;

public class Player extends Entity {

	private Image[] sheets;
	private int dir; // 0-left 1-idle 2-right
	private boolean[] keys;
	private int health;
	private final int maxHealth = 25;

	public Player(Image i, Image l, Image r, int x, int y) {
		super(i, x, y, 32, 32, 16, 5);
		sheets = new Image[] { l, i, r };
		keys = new boolean[4];
		dir = 1;
		health = maxHealth;

	}

	void setKey(int k, boolean v) {
		keys[k] = v;
	}
	
	public void draw(Graphics g, Tablet tablet){
		draw(g,sheets[dir],tablet);
	}

	public void move(Tablet tablet) {
		if (tablet.listen.getKey(0)) {
			x--;
			dir = 0;
		} else if (tablet.listen.getKey(1)) {
			x++;
			dir = 2;
		} else {
			if (tablet.listen.getKey(2))
				y--;

			else if (tablet.listen.getKey(3))
				y++;
			dir = 1;
		}
		super.move(tablet);
	}
	
	public boolean isDead(){
		return health <= 0;
	}
	
	public void onDeath(Tablet tablet){
		tablet.gameMode = 2;
	}
	
	public void damage(int i){
		health -= i;
	}

}
