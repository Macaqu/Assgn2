package asgn2GUI;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import asgn2GUI.TrainModel.CarriageTypes;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;



/**
 * @author Lalu Fahany Yazikri
 */
public class TrainGUI extends JFrame{

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
	private JPanel pnlReset;
	private JPanel pnlShowImage;
	private JPanel pnlImgTitle;
	
	
	//textarea
	private JTextArea displayDriverInfo;
	private JTextArea displayConductorInfo;
	
	//buttons
	private JButton btnAddCarriage;
	private JButton btnRemoveCarriage;
	private JButton btnBoard;
	private JButton btnReset;
	
	//TextField
	private JTextField txtNumPassengers;
	
	private ArrayList<CarriageImage> listImage;
	
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private String newline = "\n";
	
	public TrainGUI(){
		super("Train Simulation");
		super.setDefaultLookAndFeelDecorated(true);
		c = new GridBagConstraints();
		listImage =  new ArrayList<CarriageImage>();
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
		
		settingLayout();
		
		settingTextArea();
		
		settingButton();
	}

	
	
	/**
	 * 
	 * */
	public void updateDriverInfo(String message){
		this.displayDriverInfo.append(message + newline);
		displayDriverInfo.update(displayDriverInfo.getGraphics());
		displayDriverInfo.setCaretPosition(displayDriverInfo.getDocument().getLength());
	}
	
	/**
	 * 
	 * */
	public void updateConductorInfo(String message){
		this.displayConductorInfo.append(message + newline);
		displayConductorInfo.update(displayConductorInfo.getGraphics());
		displayConductorInfo.setCaretPosition(displayConductorInfo.getDocument()
				.getLength());
	}
	
	
	
	/**
	 * 
	 * */
	private void settingButton() {
		
		Dimension defaultDim = new Dimension(200, 40);
		
		/*Create Button*/
		btnAddCarriage = createButton("Add A Carriage", defaultDim);
		
		btnRemoveCarriage = createButton("Remove Carriage",defaultDim);
		
		btnBoard = createButton("Board", defaultDim);
		btnBoard.setEnabled(false);
		
		btnReset = createButton("Reset", defaultDim);
		
		/*Set button into layout*/	
		pnlDriverButton.add(btnAddCarriage);
		pnlDriverButton.add(btnRemoveCarriage);
		pnlConductorButton.add(btnBoard);
		pnlReset.add(btnReset);
	}

	/**
	 * 
	 * */
	private void settingTextArea() {
		
		//Driver
		displayDriverInfo = createTextArea();
		JScrollPane scrlDriver = createScrollPane(new Dimension(450, 200), true, displayDriverInfo);
		pnlDriverInfo.add(scrlDriver);
		
		//Conductor
		displayConductorInfo = createTextArea();
		JScrollPane scrlConductor = createScrollPane(new Dimension(450, 200), true, displayConductorInfo);
		pnlConductorInfo.add(scrlConductor, BorderLayout.SOUTH);
	
		//InfoGraph
		//pnlImages.setLayout(new BorderLayout());
		JLabel lblImages = new JLabel("Info Graphic");
		pnlImgTitle.add(lblImages );
		
		JScrollPane scrlImages = createScrollPane(new Dimension(950, 150), false, pnlShowImage);
		
		pnlImages.add(scrlImages, BorderLayout.CENTER);
	}
	
	
	private JScrollPane createScrollPane(Dimension dimension, boolean isVertical , Component component){
		JScrollPane scroll =  new JScrollPane(component);
		scroll.setPreferredSize(dimension);
		
		if(isVertical){
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		else{
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		}
		
		return scroll;
	}
	
	
	private JTextArea createTextArea(){
		
		//create textarea
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		return textArea;
	}

	
	/**
	 * 
	 * */
	private void settingLayout() {
		layout = new GridBagLayout();

		c = new GridBagConstraints();
		Color defaultClr = Color.LIGHT_GRAY;
		
		JPanel panel = new JPanel(layout);
		
		/*main panel*/
		pnlImages = createPanel(defaultClr);
		pnlDriver = createPanel(defaultClr);
		pnlConductor = createPanel(defaultClr);
		pnlReset = createPanel(defaultClr);

		/*arrange the panel*/
		pnlImgTitle = createPanel(defaultClr);
	
		c.weightx = 100;
		c.weighty = 100;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.ipady = 0;
		c.ipadx = 10;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(pnlImages, c);
		
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		
		c.anchor = GridBagConstraints.CENTER;
		c.ipady = 15;
		c.ipadx = 30;
		c.gridx = 0;
		c.anchor = GridBagConstraints.WEST;
		panel.add(pnlDriver,c);
		c.anchor= GridBagConstraints.EAST;
		panel.add(pnlConductor,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 100;
		c.gridheight = 1;
		c.ipadx = 0;
		c.anchor = GridBagConstraints.SOUTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(pnlReset, c);
		
		getContentPane().add(panel);
		
		/*sub panel*/
		
		//images panel 
		pnlImages.setLayout(new BorderLayout());
		pnlImages.add(pnlImgTitle, BorderLayout.NORTH);
		pnlShowImage = new JPanel(); //add into scrollpane of image
		
		JPanel pnlFootyImage = createPanel(defaultClr);
		pnlImages.add(pnlFootyImage, BorderLayout.SOUTH);
		
		//driver panel 
		JLabel lblDriver = new JLabel("Driver");
		JPanel pnlLblDriver = createPanel(defaultClr);
		pnlLblDriver.add(lblDriver);
		
		pnlDriverInfo = createPanel(defaultClr);
		pnlDriverButton = createPanel(defaultClr);
		
		pnlDriver.setLayout(new BorderLayout());
		pnlDriver.add(pnlLblDriver, BorderLayout.NORTH);
		pnlDriver.add(pnlDriverInfo, BorderLayout.CENTER);
		pnlDriver.add(pnlDriverButton, BorderLayout.SOUTH);
		
		//conductor Panel
		JLabel lblConductor = new JLabel("Conductor");
		JPanel pnlLblConductor = createPanel(defaultClr);
		pnlLblConductor.add(lblConductor);
		
		
		pnlConductorInfo = createPanel(defaultClr);
		pnlConductorButton = createPanel(defaultClr);
		
		pnlConductor.setLayout(new BorderLayout());
		pnlConductor.add(pnlLblConductor, BorderLayout.NORTH);
		pnlConductor.add(pnlConductorInfo, BorderLayout.CENTER);
		pnlConductor.add(pnlConductorButton, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}

	
	private JPanel createPanel(Color background){
		JPanel panel = new JPanel();
		panel.setBackground(background);
		return panel;
	}
	
	private JButton createButton(String buttonName, Dimension dimension){
		JButton newButton = new JButton(buttonName);
		newButton.setVisible(true);
		newButton.setPreferredSize(dimension);
		return newButton;
	}
	
	protected void removeImage(){
		CarriageImage image = listImage.get(listImage.size()-1);
		listImage.remove(image);
		pnlShowImage.remove(image);
		pnlShowImage.repaint();
		pnlShowImage.revalidate();
	}
	
	
	
	protected void addCarriageImage(String name, TrainModel.CarriageTypes type){
		
		CarriageImage image = new CarriageImage(name, type); 
		
		listImage.add(image);
		pnlShowImage.add(image);
		
		pnlShowImage.repaint();
		pnlShowImage.revalidate();
		
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
	protected void showErrorMessage(String errorMsg){
		JOptionPane.showConfirmDialog(null, errorMsg, "Setting Locomotive",
				JOptionPane.CLOSED_OPTION);
		
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
		
		//setting combo boxes
		JComboBox<Object> cmbEngineType = new JComboBox<Object>(engineType);
		JComboBox<Object> cmbEnginePower = new JComboBox<Object>(enginePower);
		cmbEngineType.setSelectedIndex(-1);
		cmbEnginePower.setSelectedIndex(-1);
		Object[] message = {
			"Gross weight :", txtGrossWeight,	
		    "Engine Types:", cmbEngineType,
		    "Engine Power:", cmbEnginePower
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Locomotive", 
				JOptionPane.OK_CANCEL_OPTION);
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
	
	/**
	 * Return true if user choose one of options in the combo box
	 * 
	 * @param combo: combobox object
	 * @return : boolean
	 * */
	private boolean isComboInputValid(@SuppressWarnings("rawtypes") JComboBox combo){
		return combo.getSelectedIndex() != -1;
	}
	
	
	/**
	 * Return true if the input in a textbox is an integer
	 * */
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
	 * @param String array contains carriage for choosed
	 * 
	 * @return One of carriages choosen by users, Otherwise null
	 * */
	protected String chooseCar(String[] carToChoose){
		
		//setting combobox
		JComboBox<Object> carTypes = new JComboBox<Object>(carToChoose);
		
		Object[] message = {
		    "Carriage Types:", carTypes
		};
		carTypes.setSelectedIndex(-1);

		//show message
		int option = JOptionPane.showConfirmDialog(null, message, "Choose Carriage",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && carTypes.getSelectedIndex()!=-1) {
		    
			return (String) carTypes.getSelectedItem();
		} 
		    return null;
	}

	/**
	 * 
	 * */
	public Integer[] settingPassengerCar() {
		
		JTextField txtGrossWeight = new JTextField();
		JTextField txtNumOfSeats = new JTextField();
		
		Object[] message = {
			"Gross weight :", txtGrossWeight,	
		    "Number of Seats:", txtNumOfSeats
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Passenger Car", 
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtGrossWeight) 
				&& isIntegerInputValid(txtNumOfSeats)) {
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
	


	public JButton getResetBtn() {
		return btnReset;
	}
	
	public void resetGame(){
		//clean up driver display
		cleanDisplay(this.displayDriverInfo);
		
		//clean up conductor display
		cleanDisplay(this.displayConductorInfo);
		
		//clean up train images
		cleanCarriageImg();
	}

	private void cleanCarriageImg() {
		for(int i = 0; i < listImage.size(); i++){
			removeImage();
		}
		
	}

	private void cleanDisplay(JTextArea textArea) {
		textArea.setText("");
	}
	
	
	
}



class CarriageImage extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String carriageName;
	
	Color carriageColor;
	
	
	public CarriageImage(String carriageName, TrainModel.CarriageTypes carriageType){
		this.carriageName = carriageName;
		setColor(carriageType);
	}


    private void setColor(CarriageTypes carriageType) {
		if(carriageType == CarriageTypes.Locomotive){
			carriageColor = Color.BLUE;
		}
		else if(carriageType == CarriageTypes.PassengerCar){
			carriageColor = Color.GREEN;
		}
		else {
			carriageColor = Color.yellow;
		}
	}


	@Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 80);
    }
	
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Rectangle b = new Rectangle();
        Dimension dim = getPreferredSize();
        b.setSize(dim);
        
        Font font = new Font("Arial", Font.BOLD, 12);

        g.setFont(font);
        g.setColor(carriageColor);
        g.fill3DRect(b.x, b.y, b.width, b.height, false);
        g.setColor(Color.black);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("1", g);
        g.drawString(carriageName, (int) (b.x + b.width/2 - rect.getWidth()/2),
                          (int) (b.y + b.height/2 + rect.getHeight()/2));
    	
    }	
    
}
