import java.awt.Image;


public class Player extends Entity {

	private Image[] sheets;
	private int dir; //0-left 1-idle 2-right
	private boolean[] keys;
	
	public Player(Image i,Image l,Image r, int x, int y){
		super(i,x,y,32,32,16,7);
		sheets = new Image[]{l,i,r};
		keys = new boolean[4];
		dir = 1;
		
	}
	
	void setKey(int k,boolean v){
		keys[k]=v;
	}
	
	public void move(){
		if(keys[0])x--;
		if(keys[1])x++;
		if(keys[2])y--;
		if(keys[3])y++;
	}
	
}
