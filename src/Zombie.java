import java.awt.Graphics;
import java.awt.Image;


public class Zombie extends Entity {
	
	private Image[] sheets;
	private int dir,health;
	private final int maxHealth = 5;
	
	public Zombie(Image l, Image u, Image r, Image d, int x, int y){
		super(l,x,y,32,32,16,0);
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
		int n = (int) (Math.random()*200);
		if(n<4)dir=n;
		if(dir==0)x--;
		else if(dir==1)y--;
		else if(dir==2)x++;
		else if(dir==3)y++;
		//System.out.println(dir);
		super.move(t);
			
	}
	
	public void onCollide(Entity e){
		if(e instanceof Player){
			Player p = (Player) e;
			p.damage(5);
			dir=(int)Math.random()*4;
		}
	}
}
