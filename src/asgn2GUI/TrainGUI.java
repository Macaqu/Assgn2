package asgn2GUI;


import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TrainGUI extends JFrame implements Observer {

	/**
	 * author : Lalu Fahany Yazikri
	 */
	private static final long serialVersionUID = -5269332274129183251L;

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


	//buttons
	private JButton btnAddCarriage;
	private JButton btnRemoveCarriage;
	private JButton btnBoard;
	private JButton btnReset;
	
	//TextField
	private JTextField txtNumPassengers;
	private JTextField txtNumOfSeats;

	
	
	public TrainGUI(){
		super("Train Simulation");
		super.setDefaultLookAndFeelDecorated(true);
		initComponents();
	}

	public JButton getAddCarriageBtn(){
		return this.btnAddCarriage;
	}
	
	public JButton getRemoveCarBtn(){
		return this.btnRemoveCarriage;
	}

	public JButton getBoardBtn(){
		return this.btnBoard;
	}
	
	private void initComponents() {
		
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		
		settingLayout();
		
		settingTextArea();
		
		settingButton();
		
		
	}

	private String newline = "\n";
	
	/**
	 * 
	 * */
	public void updateDriverInfo(String message){
		this.displayDriverInfo.append(message + newline);
		displayDriverInfo.update(displayDriverInfo.getGraphics());
		//displayDriverInfo.setCaretPosition(displayDriverInfo.getDocument().getLength());
	}
	
	/**
	 * 
	 * */
	public void updateConductorInfo(String message){
		this.displayConductorInfo.append(message + newline);
		displayConductorInfo.update(displayConductorInfo.getGraphics());
		displayConductorInfo.setCaretPosition(displayConductorInfo.getDocument().getLength());
	}

	
	
	/**
	 * 
	 * */
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
		btnBoard.setEnabled(false);
		
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

	/**
	 * 
	 * */
	private void settingTextArea() {
		
		lblDriverPnl = new JLabel("Driver");
		lblDriverPnl.setFont(new Font("Arial", Font.BOLD, 16));
		pnlDriverInfo.add(lblDriverPnl, BorderLayout.LINE_START);
		
		
		displayDriverInfo = new JTextArea();
		displayDriverInfo.setEditable(false);
		displayDriverInfo.setLineWrap(true);
		
		JScrollPane scrlDriver = new JScrollPane(displayDriverInfo);
		scrlDriver.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrlDriver.setPreferredSize(new Dimension(450, 200));
		pnlDriverInfo.add(scrlDriver, BorderLayout.LINE_END);
		
		
		lblConductorPnl = new JLabel("Conductor");
		lblConductorPnl.setFont(new Font("Arial", Font.BOLD, 16));
		pnlConductorInfo.add(lblConductorPnl, BorderLayout.LINE_START);
		
		displayConductorInfo = new JTextArea();
		displayConductorInfo.setEditable(false);
		
		JScrollPane scrlConductor = new JScrollPane(displayConductorInfo);
		scrlConductor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrlConductor.setPreferredSize(new Dimension(450, 200));
		pnlConductorInfo.add(scrlConductor, BorderLayout.LINE_END);
	}

	/**
	 * 
	 * */
	private void settingLayout() {
		pnlImages = new JPanel();
		pnlImages.setBackground(Color.blue);
		pnlImages.setPreferredSize(new Dimension(500, 150));
		getContentPane().add(new JScrollPane(pnlImages), BorderLayout.PAGE_START);
		
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

	/**
	 * 
	 * */
	public void addActionListener(ActionListener listener){
		this.btnAddCarriage.addActionListener(listener);
		this.btnBoard.addActionListener(listener);
		this.btnRemoveCarriage.addActionListener(listener);
		this.btnReset.addActionListener(listener);
		
	}
	
	/**
	 * 
	 * */
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	/**
	 * 
	 * */
	protected void showErrorMessage(String errorMsg){
		JOptionPane.showConfirmDialog(null, errorMsg, "Setting Locomotive", JOptionPane.CLOSED_OPTION);
		
	}
	
	protected void setNumOnBoard(Integer psgOnBoard){
		this.txtNumPassengers.setText(psgOnBoard.toString());
	}
	
	protected Integer addPassengers(){
		JTextField txtPassengers = new JTextField();
		
		Object[] message = {
				"Passenger boarding :", txtPassengers,	
			};
		int option = JOptionPane.showConfirmDialog(null, message, "Passenger boarding", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtPassengers)) {
		    Integer addPassengers = Integer.parseInt(txtPassengers.getText());
		    return addPassengers;
		} else {
		    return null;
		}	
		
	}
	
	protected void setBoardbtnEnable(boolean isEnable){
		btnBoard.setEnabled(isEnable);
	}
	
	/**
	 * 
	 * */
	protected Object[] settingLocomotive(String[] engineType, String[] enginePower){
		JTextField txtGrossWeight = new JTextField();
		
		JComboBox<Object> cmbEngineType = new JComboBox<Object>(engineType);
		JComboBox<Object> cmbEnginePower = new JComboBox<Object>(enginePower);
		cmbEngineType.setSelectedIndex(-1);
		cmbEnginePower.setSelectedIndex(-1);
		Object[] message = {
			"Gross weight :", txtGrossWeight,	
		    "Engine Types:", cmbEngineType,
		    "Engine Power:", cmbEnginePower
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Locomotive", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && isComboInputValid(cmbEngineType) && 
				isComboInputValid(cmbEnginePower) && isIntegerInputValid(txtGrossWeight)) {
		    Object[] locoParams = new Object[3]; //(1)gross weight, (2)engineType, (3)enginepower 
		    
		    locoParams[0] = Integer.parseInt(txtGrossWeight.getText());
		    locoParams[1] = cmbEngineType.getSelectedItem().toString();
		    locoParams[2] = cmbEnginePower.getSelectedItem().toString();
		    return locoParams;
		} else {
		    return null;
		}	

	} 
	
	
	private boolean isComboInputValid(@SuppressWarnings("rawtypes") JComboBox combo){
		return combo.getSelectedIndex() != -1;
	}
	
	private boolean isIntegerInputValid(JTextField txtField){
		try  
	     {  
			Integer.parseInt(txtField.getText());  
	          
	      } catch(NumberFormatException nfe)  
	      {  
	          return false;  
	      }
		return true;
	}
	
	/**
	 * 
	 * */
	protected String chooseCar(String[] carToChoose){
		JComboBox<Object> carTypes = new JComboBox<Object>(carToChoose);
		
		Object[] message = {
		    "Carriage Types:", carTypes
		};
		carTypes.setSelectedIndex(-1);

		int option = JOptionPane.showConfirmDialog(null, message, "Choose Carriage", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && carTypes.getSelectedIndex()!=-1) {
		    
			return (String) carTypes.getSelectedItem();
		} 
		    return null;
			
	}

	public Integer[] settingPassengerCar() {
		
		JTextField txtGrossWeight = new JTextField();
		JTextField txtNumOfSeats = new JTextField();
		
		Object[] message = {
			"Gross weight :", txtGrossWeight,	
		    "Number of Seats:", txtNumOfSeats
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Passenger Car", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtGrossWeight) && isIntegerInputValid(txtNumOfSeats)) {
		    Integer[] passCarParams = new Integer[2]; //(1)gross weight, (2)engineType, (3)enginepower 

		    passCarParams[0] = Integer.parseInt(txtGrossWeight.getText());
		    passCarParams[1] = Integer.parseInt(txtNumOfSeats.getText());

		    return passCarParams;
		} else {
		    return null;
		}	

	}
	
	
	public Object[] settingFreightCar(String[] goodsType) {
		
		JTextField txtGrossWeight = new JTextField();
		
		JComboBox<Object> cbGoodsType = new JComboBox<Object>(goodsType);
		cbGoodsType.setSelectedIndex(-1);
		
		Object[] message = {
			"Gross weight :", txtGrossWeight,	
		    "GoodsType:", cbGoodsType
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Passenger Car", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtGrossWeight) && isComboInputValid(cbGoodsType)) {
		    Object[] freightCarParams = new Object[2]; //(1)gross weight, (2)engineType, (3)enginepower 

		    freightCarParams[0] = Integer.parseInt(txtGrossWeight.getText());
		    freightCarParams[1] = cbGoodsType.getSelectedItem().toString();

		    return freightCarParams;
		} else {
		    return null;
		}	

	
	}
	
	public void setTxtNumOfSeats(Integer numOfSeats){
		this.txtNumOfSeats.setText(numOfSeats.toString());
	}
	
}
