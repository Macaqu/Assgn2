package asgn2GUI;

import javax.swing.JFrame;

/**
 * the main entry of Train Simulation
 * 
 * @author Yudo Dwi Hanggodo Patriabekti
 */
public class TrainSimulation {

	public static void main(String[] args) {
		
		TrainModel model = new TrainModel();
		
		TrainGUI gui = new TrainGUI();
		
		@SuppressWarnings("unused")
		TrainController controller = new TrainController(model, gui);
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}

}
