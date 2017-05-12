import javax.swing.JPanel;


public class Tablet extends JPanel implements Runnable{
	
	Entity[] entitys;
	
	@Override
	public void run() {
		try
        {
            while(true)
            {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }catch(Exception e)
        {
        }
	}

}
