package pkg1st_game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Demo_Arriving extends JFrame {
	private Game_Loop_Arriving gameLoop;
	
	public Demo_Arriving() {
		this.setSize(1000, 1000);
	
                this.setVisible(true);
		gameLoop = new Game_Loop_Arriving(true, this);
		new Thread(gameLoop).start();
	}
	
	public static void main(String[] args) {
		 Demo_Arriving demo = new Demo_Arriving();
	}
	
	
}
