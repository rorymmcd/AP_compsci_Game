import java.awt.Graphics;
import java.awt.Image;


public class SpriteSheet {
	Image sheet;
	int sWidth, sHeight;//width and height of sheet
	int fWidth, fHeight;//width and height of each frame
	public SpriteSheet(Image i, int w, int h, int fw, int fh){
		sheet = i;
		sWidth = w;
		sHeight = h;
		fHeight = fh;
		fWidth = fw;
	}
	
	public void drawFrame(Graphics g, int x, int y, int frameX, int frameY){
		g.drawImage(sheet,x,y,x+fWidth,y+fHeight,frameX*fWidth,frameY*fHeight);
	}
}
