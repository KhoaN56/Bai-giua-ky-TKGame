package pkg1st_game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game_Loop_Seek implements Runnable{
	private boolean isRunning;
	private Demo_Seek demo;
	private List<Character> characters;
        private Character target;
	private List<KinematicSeek> kinematicSeek;
        
	public Game_Loop_Seek(boolean isRunning, Demo_Seek demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		
		Character c1 = new Character(new Vector2D(600, 400), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(150, 300), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
                target= new Character(new Vector2D (100,100),80,new Vector2D(0,0),0,Color.BLACK);
		this.characters = new ArrayList<Character>();
		this.kinematicSeek = new ArrayList<KinematicSeek>();
		
		this.characters.add(c1);
		this.characters.add(c2);
		for (Character c: this.characters) {
			//this.kinematicWandering = new KinematicWandering(c, 5, 1);
			this.kinematicSeek.add(new KinematicSeek(c,target , 2));
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo_Seek getDemo() {
		return demo;
	}

	public void setDemo(Demo_Seek demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		/*for (int i=0; i<20; i++) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
			int x, y;
			x = 100 + i*10;
			y = 100 + i*10;
			demo.getGraphics().drawOval(x, y, 50, 50);
			demo.getGraphics().drawLine(x, y, x + 25, y + 25);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		while (true) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
                        this.target.render(this.demo.getGraphics());
			for (Character c: this.characters) {
				c.update(this.kinematicSeek.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.demo.getGraphics());
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
