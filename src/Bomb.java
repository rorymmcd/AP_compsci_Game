import java.awt.Image;


public class Bomb extends Item {
	public static Image Bomb_icon;
	private boolean used;
	
	public Bomb(){
		super(Bomb_icon);
		used = false;
	}
	
	public void onUse(Tablet t, Player p){
		t.entitys.add(new Explosion(p.x,p.y,false,5));
		used = true;
	}
	
	public boolean isDead(){
		return used;
	}
}
