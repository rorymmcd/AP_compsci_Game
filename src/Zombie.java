import java.awt.Graphics;
import java.awt.Image;


public class Zombie extends Entity {
	
	private Image[] sheets;
	private int dir,health,maxHealth;
	
	public Zombie(Image l, Image u, Image r, Image d, int x, int y){
		super(l,x,y,32,32,16,6);
		sheets = new Image[] {l,u,r,d};
		dir = 1;
		//0-left 1-up 2-right 3-down
		health = maxHealth;
	}
	
	public void draw(Graphics g, Tablet tablet){
		draw(g,sheets[dir],tablet);
	}
	
	public boolean isDead(){
		return health <= 0;
	}
	
	public void move(Tablet t){
		
	}
}
