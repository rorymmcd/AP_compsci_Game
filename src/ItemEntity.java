
public class ItemEntity extends Entity {
	private Item item;
	private boolean dead;
	
	public ItemEntity(int sx, int sy, Item si){
		super(si.icon,sx,sy,32,32,16,0);
		item=si;
		dead = false;
	}
	
	public void onCollide(Entity e, Tablet tablet){
		if(e instanceof Player){
			Player p = (Player) e;
			p.addItem(item, tablet);
			dead = true;
		}
	}
	
	public boolean isDead(){
		return dead;
	}
}
