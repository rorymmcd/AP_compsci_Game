import java.awt.Image;


public class Explosion extends Entity {
	public static Image spritesheet;
	private boolean hurtPlayer;
	private int life, strength;
	
	public Explosion(int x, int y, boolean hurtP, int s){
		super(spritesheet,x,y,96,96,48,1);
		hurtPlayer = hurtP;
		life = 50;
		strength = s;
	}
	
	public void move(Tablet t){
		life--;
	}
	
	public boolean isDead(){
		return life <= 0;
	}
	
	public void onCollide(Entity e, Tablet tablet){
		if(e instanceof Zombie){
			Zombie z = (Zombie) e;
			z.damage(strength);
		}
		if(e instanceof Player && hurtPlayer){
			Player p = (Player) e;
			p.damage(strength);
		}
	}
}
