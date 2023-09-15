package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	private JFrame jframe;







	public GameWindow(GamePanel gamePanel){
	jframe = new JFrame();
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.setLocationRelativeTo(null);
	jframe.setResizable(false);
	jframe.add(gamePanel);
	jframe.pack();
	jframe.setVisible(true);
}
 }
