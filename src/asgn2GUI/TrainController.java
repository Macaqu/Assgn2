package asgn2GUI;

import java.awt.*;
import java.awt.event.*;

public class TrainController {

	private TrainModel model;
	
	private TrainGUI view;
	
	private ActionListener listener;
	
	public TrainController(TrainModel model, TrainGUI gui) {
		this.model = model;
		this.view = gui;
		//gui.addActionListener(new TrainListener());
		
	}
	
	private class TrainListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
