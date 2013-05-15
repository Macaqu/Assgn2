package asgn2GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TrainFrame extends JFrame{
	// Display constants
	protected static final int WIDTH = 600;
	protected static final int HEIGHT = 500;
	protected static final Dimension PREFSIZE = new Dimension(WIDTH, HEIGHT);

	public TrainFrame(){
		setTitle("Train Application");
		setSize(PREFSIZE);
		
		this.getContentPane().add(new GamePanel());
		repaint();
	}
		
}
