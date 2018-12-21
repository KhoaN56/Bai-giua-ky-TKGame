package pkg1st_game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo_Seek extends JFrame {
	private Game_Loop_Seek gameLoop;
	
	public Demo_Seek() {
		this.setSize(600, 600);
	
                this.setVisible(true);
		gameLoop = new Game_Loop_Seek(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		 Demo_Seek demo = new Demo_Seek();
	}
	
	
}
