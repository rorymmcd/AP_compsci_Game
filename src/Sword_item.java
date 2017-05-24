import java.awt.Image;

public class Sword_item extends Item {

	public static Image sword_icon;
	private int timer;

	public Sword_item() {
		super(sword_icon);
	}
	
	public void decTimer(){
		if(timer>0)timer--;
	}

	public void onUse(Tablet t, Player p) {
		if (timer <= 0) {
			t.entitys.add(new Sword_entity(p.x, p.y, p));
			timer=400;
		}
	}

}
