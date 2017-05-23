import java.awt.Image;

public class Item {
	public Image icon;
	
	public Item(Image i){
		icon = i;
	}
	
	public void onUse(Tablet t){
		
	}
	
	public void onGet(Tablet t){
		
	}
	
	public boolean isDead(){
		return false;
	}
}
