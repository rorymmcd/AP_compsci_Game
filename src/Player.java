import java.awt.Graphics;
import java.awt.Image;

public class Player extends Entity {

	private Image[] sheets;
	private int dir; // 0-left 1-idle 2-right
	private int health;
	private final int maxHealth = 25;
	private int dmgCountdown;

	public Player(Image i, Image l, Image r, int x, int y) {
		super(i, x, y, 32, 32, 16, 5);
		sheets = new Image[] { l, i, r };
		dir = 1;
		health = maxHealth;
		dmgCountdown = 0;
	}

	public int getHealth(){
		return health;
	}

	public void draw(Graphics g, Tablet tablet) {
		draw(g, sheets[dir], tablet);
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
		if (dmgCountdown > 0)
			dmgCountdown--;
		super.move(tablet);
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void onDeath(Tablet tablet) {
		tablet.gameMode = 2;
	}

	public void damage(int i) {
		if (dmgCountdown == 0) {
			health -= i;
			dmgCountdown = 200;
		}
	}

	public void onCollide(Entity e, Tablet t) {

	}

}
