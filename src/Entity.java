import java.awt.Graphics;
import java.awt.Image;


public class Entity {
	public int x,y;
	private Image spritesheet;
	private int frame,maxFrame,w,h,r;
	
	public Entity(Image i, int sx, int sy,int sw,int sh,int sr,int smaxFrame){
		spritesheet = i;
		x = sx;
		y = sy;
		w = sw;
		h = sh;
		r = sr;
		maxFrame = smaxFrame;
	}
	
	public boolean colliding(Entity e){
		//return ((int)Math.sqrt(Math.pow(x-e.x, 2)+Math.pow(y-e.y,2))<r+e.r);
		return Math.abs(x-e.x)<r+e.r && Math.abs(y-e.y)<r+e.r;
	}
	
	public void draw(Graphics g, Tablet tablet){
		int hw = w/2;
		int hh = h/2;
		g.drawImage(spritesheet, x-hw, y-hh, x+hw, y+hh,frame*w,0,(frame+1)*w,h,tablet);
	}
	
	public void draw(Graphics g, Image i, Tablet tablet){
		int hw = w/2;
		int hh = h/2;
		g.drawImage(i, x-hw, y-hh, x+hw, y+hh,frame*w,0,(frame+1)*w,h,tablet);
	}
	
	public void incFrame(){
		frame++;
		if(frame>maxFrame)frame=0;
	}
	
	public void move(Tablet t){
		if(x<0+r)x=0+r;
		if(y<0+r)y=0+r;
		if(x>AP_compsci_Game.WIDTH-200-r)x=AP_compsci_Game.WIDTH-200-r;
		if(y>AP_compsci_Game.HEIGHT-50-r)y=AP_compsci_Game.HEIGHT-50-r;
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public void onDeath(Tablet tablet) {
		// TODO Auto-generated method stub
		
	}

	public void onCollide(Entity r2, Tablet tablet) {
		// TODO Auto-generated method stub
		
	}
}
