import java.awt.Graphics;
import java.awt.Image;


public class Zombie extends Entity {
	public static Image l,r,u,d;
	private Image[] sheets;
	private int dir,health;
	private final int maxHealth = 5;
	private int dmgCountdown;
	
	public Zombie(int x, int y){
		super(d,x,y,32,32,16,0);
		sheets = new Image[] {l,u,r,d};
		dir = 1;
		//0-left 1-up 2-right 3-down
		health = maxHealth;
		dmgCountdown = 0;
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
	
	public void onCollide(Entity e, Tablet t){
		if(e instanceof Player){
			Player p = (Player) e;
			p.damage(5);
			dir=(int)Math.random()*4;
			//System.out.println("Player");
		}
	}
	
	public void damage(int i) {
		if (dmgCountdown == 0) {
			health -= i;
			dmgCountdown = 200;
		}
	}
}
