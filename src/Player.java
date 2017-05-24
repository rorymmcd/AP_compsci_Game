import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Player extends Entity {

	public static Image u, d, l, r;

	private Image[] sheets;
	private int dir; // 0-left 1-up 2-right 3-down
	private int health;
	private final int maxHealth = 25;
	private int dmgCountdown;
	public ArrayList<Item> inventory;
	private final int invMaxSize = 6;
	public int selectedItem;

	public Player(int x, int y) {
		super(d, x, y, 32, 32, 16, 1);
		sheets = new Image[] { l, u, r, d };
		dir = 1;
		health = maxHealth;
		dmgCountdown = 0;
		inventory = new ArrayList<Item>();
	}

	public void addItem(Item i, Tablet t) {
		if (inventory.size() < invMaxSize) {
			inventory.add(i);
		}
		i.onGet(t);
	}

	public int getHealth() {
		return health;
	}

	public void addHealth(int h) {
		health += h;
		if (health > maxHealth)
			health = maxHealth;
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
		} else if (tablet.listen.getKey(2)) {
			y--;
			dir = 1;
		} else if (tablet.listen.getKey(3)) {
			y++;
			dir = 3;
		}
		
		if (tablet.listen.getKey(6))
			selectedItem = 0;
		else if (tablet.listen.getKey(7))
			selectedItem = 1;
		else if (tablet.listen.getKey(8))
			selectedItem = 2;
		else if (tablet.listen.getKey(9))
			selectedItem = 3;
		else if (tablet.listen.getKey(10))
			selectedItem = 4;
		else if (tablet.listen.getKey(11))
			selectedItem = 5;

		if (selectedItem >= inventory.size())
			selectedItem = inventory.size() - 1;

		for (int i = 0; i < inventory.size(); i++) {
			Item m = inventory.get(i);
			inventory.get(i).decTimer();
			if (m.isDead()) {
				inventory.remove(i);
				i--;
			}
		}
		if (selectedItem > inventory.size())
			selectedItem = inventory.size();
		if (tablet.listen.getKey(4)) {
			inventory.get(selectedItem).onUse(tablet, this);
			//System.out.println("USE");
		}
		// System.out.println(selectedItem);
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
