package asgn2GUI;


import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TrainGUI extends JFrame implements Observer {

	public static final int WIDTH = 1000;
	
	public static final int HEIGHT = 600;
	
	//panel
	private JPanel pnlImages;
	
	private JPanel pnlDriver;
	private JPanel pnlDriverInfo;
	private JPanel pnlDriverButton;
	
	private JPanel pnlConductor;
	private JPanel pnlConductorInfo;
	private JPanel pnlConductorButton;
	
	private JPanel pnlConductorBtnOne;
	private JPanel pnlConductorBtnTwo;
	private JPanel pnlConductorBtnThree;
	
	//textarea
	private JTextArea displayDriverInfo;
	private JTextArea displayConductorInfo;
	
	//label
	private JLabel lblDriverPnl;
	private JLabel lblConductorPnl;
	
	private JLabel lblPassenger;
	private JLabel lblNumSeats;
	
	//info
	private String driverInfo;
	private String conductorInfo;
	
	//buttons
	private JButton btnAddCarriage;
	private JButton btnRemoveCarriage;
	private JButton btnBoard;
	private JButton btnReset;
	
	//TextField
	private JTextField txtNumPassengers;
	private JTextField txtNumOfSeats;

	private GridLayout lytConductorBtn;
	
	public TrainGUI(){
		super("Train Simulation");
		super.setDefaultLookAndFeelDecorated(true);
		initComponents();
	}


	private void initComponents() {
		
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		settingLayout();
		
		settingTextArea();
		
		settingButton();
		
	}

		
	private void settingButton() {
		this.btnAddCarriage = new JButton("Add A Carriage");
		btnAddCarriage.setPreferredSize(new Dimension(400, 30));
		this.btnRemoveCarriage = new JButton("Remove A Carriage");
		btnRemoveCarriage.setPreferredSize(new Dimension(400, 30));
		this.pnlDriverButton.add(btnAddCarriage, BorderLayout.PAGE_START);
		this.pnlDriverButton.add(btnRemoveCarriage, BorderLayout.PAGE_END);
		
		this.lblPassenger = new JLabel("Passenger   ");
		this.btnBoard = new JButton("Board");
		btnBoard.setPreferredSize(new Dimension(100, 30));
		
		
		this.txtNumPassengers = new JTextField();
		this.txtNumPassengers.setPreferredSize(new Dimension(20, 30));
		this.pnlConductorBtnOne.setLayout(new BorderLayout());
		this.pnlConductorBtnOne.add(lblPassenger, BorderLayout.WEST);
		this.pnlConductorBtnOne.add(txtNumPassengers, BorderLayout.CENTER);
		this.lblNumSeats = new JLabel("Number of Seats   ");
		this.txtNumOfSeats = new JTextField();
		this.pnlConductorBtnTwo.setLayout(new BorderLayout());
		this.pnlConductorBtnTwo.add(lblNumSeats, BorderLayout.WEST);
		this.pnlConductorBtnTwo.add(txtNumOfSeats, BorderLayout.CENTER);
		
		this.pnlConductorBtnThree.setLayout(new BorderLayout());
		this.pnlConductorBtnThree.add(btnBoard, BorderLayout.NORTH);
		
		btnReset = new JButton("Reset");
		btnReset.setPreferredSize(new Dimension(100, 30));
		this.pnlConductorBtnThree.add(btnReset, BorderLayout.SOUTH);
	}


	private void settingTextArea() {
		driverInfo = "";
		
		lblDriverPnl = new JLabel("Driver");
		lblDriverPnl.setFont(new Font("Arial", Font.BOLD, 16));
		pnlDriverInfo.add(lblDriverPnl, BorderLayout.LINE_START);
		
		
		displayDriverInfo = new JTextArea(driverInfo);
		displayDriverInfo.setEditable(false);
		displayDriverInfo.setPreferredSize(new Dimension(480, 200));
		pnlDriverInfo.add(new JScrollPane(displayDriverInfo), BorderLayout.LINE_END);
		
		
		conductorInfo = "";
		
		lblConductorPnl = new JLabel("Conductor");
		lblConductorPnl.setFont(new Font("Arial", Font.BOLD, 16));
		pnlConductorInfo.add(lblConductorPnl, BorderLayout.PAGE_START);
		
		displayConductorInfo = new JTextArea(conductorInfo);
		displayConductorInfo.setEditable(false);
		displayConductorInfo.setPreferredSize(new Dimension(450, 200));
		pnlConductorInfo.add(new JScrollPane(displayConductorInfo), BorderLayout.CENTER);
	}


	private void settingLayout() {
		pnlImages = new JPanel();
		pnlImages.setBackground(Color.blue);
		pnlImages.setPreferredSize(new Dimension(500, 150));
		getContentPane().add(pnlImages, BorderLayout.PAGE_START);
		
		pnlDriver = new JPanel();
		pnlDriver.setBackground(Color.yellow);
		pnlDriver.setPreferredSize(new Dimension(500, 450));
		getContentPane().add(pnlDriver, BorderLayout.LINE_START);
		
		pnlDriverInfo = new JPanel();
		pnlDriverInfo.setBackground(Color.darkGray);
		pnlDriverInfo.setPreferredSize(new Dimension(500, 250));
		pnlDriver.add(pnlDriverInfo, BorderLayout.PAGE_START);
		
		pnlDriverButton = new JPanel();
		pnlDriverButton.setBackground(Color.LIGHT_GRAY);
		pnlDriverButton.setPreferredSize(new Dimension(500, 200));
		pnlDriver.add(pnlDriverButton, BorderLayout.PAGE_END);
		
		pnlConductor = new JPanel();
		pnlConductor.setBackground(Color.CYAN);
		pnlConductor.setPreferredSize(new Dimension(500, 450));
		getContentPane().add(pnlConductor, BorderLayout.LINE_END);
		
		pnlConductorInfo = new JPanel();
		pnlConductorInfo.setBackground(Color.YELLOW);
		pnlConductorInfo.setPreferredSize(new Dimension(500, 250));
		pnlConductor.add(pnlConductorInfo, BorderLayout.PAGE_START);
		
		pnlConductorButton = new JPanel();
		pnlConductorButton.setBackground(Color.green);
		pnlConductorButton.setPreferredSize(new Dimension(500, 200));
		pnlConductor.add(pnlConductorButton, BorderLayout.PAGE_END);
		
		
		this.pnlConductorBtnOne = new JPanel();
		pnlConductorBtnOne.setPreferredSize(new Dimension(200, 30));
		this.pnlConductorBtnTwo = new JPanel();
		pnlConductorBtnTwo.setPreferredSize(new Dimension(200, 30));
		this.pnlConductorBtnThree = new JPanel();
		pnlConductorBtnThree.setPreferredSize(new Dimension(150, 100));
		
		pnlConductorButton.add(pnlConductorBtnOne);
		pnlConductorButton.add(pnlConductorBtnTwo);
		pnlConductorButton.add(pnlConductorBtnThree);
		
		//lytConductorBtn = new GridLayout(3,3);
		//pnlConductorButton.setLayout(lytConductorBtn);
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
