import java.awt.Image;


public class Sword_item extends Item {
	
	public static Image sword_icon;
	
	public Sword_item(){
		super(sword_icon);
	}
	
	public void onUse(Tablet t, Player p){
		t.entitys.add(new Sword_entity(p.x,p.y,p));
	}
	
}
