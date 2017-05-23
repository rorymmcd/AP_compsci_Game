import java.awt.Image;


public class Sword_entity extends Entity {
	public static Image sprite_sheet;
	private Entity t;
	private int life;
	
	public Sword_entity(int x, int y, Entity tied){
		super(sprite_sheet,x,y,64,64,32,3);
		life = 100;
	}
	
	public void move(Tablet t){
		x=t.getY();
		y=t.getY();
		life--;
	}
	
	public boolean isDead(){
		return life <= 0;
	}
	
	public void onCollide(Entity e, Tablet t){
		if(e instanceof Zombie){
			Zombie z = (Zombie) e;
			z.damage(5);
		}
	}
}
