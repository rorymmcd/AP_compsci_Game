import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

	private boolean keys[];

	public KeyboardListener() {
		keys = new boolean[12];
	}

	public boolean getKey(int k) {
		if(k==5){
			boolean t = keys[k];
			keys[k]=false;
			return t;
		}
		if(k==4){
			boolean t = keys[k];
			keys[k]=false;
			return t;
		}
		return keys[k];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
			// System.out.println("0");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			keys[5] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_1){
			keys[6] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_2){
			keys[7] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_3){
			keys[8] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_4){
			keys[9] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_5){
			keys[10] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_6){
			keys[11] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
			// System.out.println("1");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			keys[5] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_1){
			keys[6] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_2){
			keys[7] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_3){
			keys[8] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_4){
			keys[9] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_5){
			keys[10] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_6){
			keys[11] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
