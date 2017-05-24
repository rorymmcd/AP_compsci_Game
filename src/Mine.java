import java.awt.Image;


public class Mine extends Entity {
	public static Image spritesheet;
	private boolean dead;
	
	public Mine(int x, int y){
		super(spritesheet,x,y,32,32,16,0);
	}
	
	public void onCollide(Entity e, Tablet tablet){
		if(e instanceof Player){
			tablet.entitys.add(new Explosion(x,y,true,5));
			dead = true;
		}
		if(e instanceof Explosion){
			tablet.entitys.add(new Explosion(x,y,false,5));
			dead = true;
		}
	}
	
	public boolean isDead(){
		return dead;
	}
}
