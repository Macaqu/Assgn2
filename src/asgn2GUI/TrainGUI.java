package asgn2GUI;


import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TrainGUI extends JFrame implements Observer {

	public static final int WIDTH = 900;
	
	public static final int HEIGHT = 500;
	
	private JTextArea driverDisplay;
	
	private JTextArea conductorDisplay;
	
	//panel
	private JPanel pnlDriver;
	private JPanel pnlConductor;
	private JLabel lblDriver;
	private JLabel lblConductor;
	private JSplitPane splitPane;
	
	private JButton btnAddCarriage;
	
	private JButton btnRemoveCarriage;
	
	private JButton btnBoard;
	
	public TrainGUI(){
		super("Train Simulation");
		initComponents();
	}


	private void initComponents() {
		
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		//super.setBackground(Color.BLACK);
		
		//set panel
		pnlDriver = new JPanel();
		pnlConductor = new JPanel();
		lblDriver = new JLabel("Driver");
		lblConductor = new JLabel("Conductor");
		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setRightComponent(pnlDriver);
		splitPane.setLeftComponent(pnlConductor);
		splitPane.setResizeWeight(0.5);
		
		splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);
		
		pnlDriver.add(lblDriver);
		pnlConductor.add(lblConductor);
		
		
		
		this.btnAddCarriage = new JButton("Add Carriage");
		btnAddCarriage.setBackground(Color.GRAY);
		this.btnRemoveCarriage = new JButton("Remove");
		btnRemoveCarriage.setBackground(Color.GRAY);
		this.btnBoard = new JButton("Board");
		btnBoard.setBackground(Color.GRAY);
		
	}

	public JButton getAddCarriageButton(){
		return this.btnAddCarriage;
	}
	
	public JButton getRemoveCarriageButton(){
		return this.btnRemoveCarriage;
	}
	
	public JButton getBoardButton(){
		return this.btnBoard;
	}
	
	public void addActionListener(ActionListener listener){
		this.btnAddCarriage.addActionListener(listener);
		this.btnRemoveCarriage.addActionListener(listener);
		this.btnBoard.addActionListener(listener);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
