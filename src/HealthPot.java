import java.awt.Image;


public class HealthPot extends Item {
	public static Image HealthPot_icon;
	private boolean dead;
	
	public HealthPot(){
		super(HealthPot_icon);
	}
	
	public void decTimer(){
		
	}
	
	public boolean isDead(){
		return dead;
	}
	
	public void onUse(Tablet t, Player p){
		p.addHealth(10);
		dead = true;
	}
}
