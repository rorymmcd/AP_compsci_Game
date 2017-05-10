import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

//main class file
public class AP_compsci_Game extends JFrame{
	
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	public AP_compsci_Game(){
		super("GAME");
		
		setSize(WIDTH, HEIGHT);
		setBackground(Color.BLACK);

		//Tablet tb = new Tablet(this);
		//((Component)tb).setFocusable(true);

      //getContentPane().add( tb );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
