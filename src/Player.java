import java.awt.Image;


public class Player extends Entity {

	Image[] sheets;
	int dir; //0-left 1-idle 2-right
	boolean[] keys;
	
	public Player(Image i,Image l,Image r, int x, int y){
		super(i,x,y,32,32,16,7);
		sheets = new Image[]{l,i,r};
		dir = 1;
		
	}
	
	void setKey(int k,boolean v){
		keys[k]=v;
	}
	
}
