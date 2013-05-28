package asgn2GUI;

import java.util.ArrayList;
import javax.swing.*;

import asgn2GUI.TrainModel.CarriageTypes;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;



/**
 * @note this GUI is created WITHOUT additional GUI builder
 * 
 * @author Lalu Fahany Yazikri
 * @author Yudo Dwi Hanggodo Patriabekti
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
	
	
	//private ArrayList<CarriageImage> listImage;
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private String newline = "\n";
	
	/**
	 * Nullable constructor. 
	 * */
	public TrainGUI(){
		super("Train Simulation");
		super.setDefaultLookAndFeelDecorated(true);
		
		initComponents();
	}

	
	/*GUI SETTING*/
	
	/**
	 * Setting width and height of this frame, Initiate GridBagConstraints for managing layout 
	 * and an array list for store carriage images.
	 *  
	 * Call other functions to initiate components. 
	 * */
	private void initComponents() {
		
		setSize(WIDTH, HEIGHT);
		
		c = new GridBagConstraints();
		
		//listImage =  new ArrayList<CarriageImage>(); //for store the images of carriages
		
		settingLayout();
		
		settingTextArea();
		
		settingButton();
	}

	/**
	 * Method for setting buttons in this GUI
	 * */
	private void settingButton() {
		
		Dimension defaultDim = new Dimension(200, 40);
		
		/*Create Button*/
		btnAddCarriage = createButton("Add A Carriage", defaultDim);
		
		btnRemoveCarriage = createButton("Remove Carriage",defaultDim);
		btnRemoveCarriage.setEnabled(false);
		
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
	 * Method for setting scrollpanes and text area in this GUI
	 * */
	private void settingTextArea() {
		
		//Driver
		displayDriverInfo = createTextArea();
		JScrollPane scrlDriver = createScrollPane(new Dimension(450, 200), true, displayDriverInfo);
		pnlDriverInfo.add(scrlDriver);
		
		//Conductor
		displayConductorInfo = createTextArea();
		JScrollPane scrlConductor = createScrollPane(new Dimension(450, 200), true, 
				displayConductorInfo);
		pnlConductorInfo.add(scrlConductor);
	
		//InfoGraph
		JLabel lblImages = new JLabel("Info Graphic");
		pnlImgTitle.add(lblImages );
		
		JScrollPane scrlImages = createScrollPane(new Dimension(950, 150), false, pnlShowImage);
		
		pnlImages.add(scrlImages, BorderLayout.CENTER);
	}
	
	
	/**
	 * Method for setting layout/panel in this GUI 
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
		pnlShowImage = createPanel(Color.white); //add into scrollpane of image
		
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

	
	/**
	 * Return a component type JScrollPane
	 * 
	 * @param Dimension dimension : the dimension of this scrollpane
	 * @param boolean isVertical : true if the scrollpane is set in vertical scroll bar,
	 * 								false if the scrollpane is set in horizontal scroll bar
	 * @param Component component: component inside the scroll pane
	 * 
	 * @return JScrollPane
	 * */
	private JScrollPane createScrollPane(Dimension dimension, boolean isVertical, 
			Component component){
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
	
	
	/**
	 * Return a compoent type JTextArea
	 * 
	 * @return JTextArea
	 * */
	private JTextArea createTextArea(){
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		return textArea;
	}

	
	/**
	 * 
	 * @param Color background: the background color of JPanel 
	 *
	 * @return JPanel
	 * */
	private JPanel createPanel(Color background){
		JPanel panel = new JPanel();
		panel.setBackground(background);
		return panel;
	}
	
	
	/**
	 * @param String buttonName: a string that is displayed in the button
	 * @param Dimension dimension: the size of the button
	 * 
	 * @return JButton
	 * */
	private JButton createButton(String buttonName, Dimension dimension){
		JButton newButton = new JButton(buttonName);
		newButton.setVisible(true);
		newButton.setPreferredSize(dimension);
		return newButton;
	}

	
	/**
	 * Add buttons with ActionListener
	 * 
	 *  @param ActionListener
	 * */
	protected void addActionListener(ActionListener listener){
		this.btnAddCarriage.addActionListener(listener);
		this.btnBoard.addActionListener(listener);
		this.btnRemoveCarriage.addActionListener(listener);
		this.btnReset.addActionListener(listener);
		
	}
	/*END GUI SETTING*/
	
	
	
	/*ACCESSOR*/
	
	/**
	 * Accessor of the button for adding carriages 
	 * 
	 * @return JButton btnAddCarriage
	 * */
	protected JButton getAddCarriageBtn(){
		return this.btnAddCarriage;
	}
	
	
	/**
	 * Accessor of the button for remove carriages 
	 * 
	 * @return JButton btnRemoveCarriage
	 * */
	protected JButton getRemoveCarBtn(){
		return this.btnRemoveCarriage;
	}

	
	/**
	 * Accessor of the button for boarding passengers 
	 * 
	 * @return JButton btnBoard
	 * */
	protected JButton getBoardBtn(){
		return this.btnBoard;
	}
	
	
	/**
	 * Accessor of the textarea for displaying driver info
	 * 
	 * @return JTextArea displayDriverInfo
	 * */
	protected JTextArea getDriverDisplay(){
		return this.displayDriverInfo;
	}
	
	
	/**
	 * Accessor of the textarea for displaying conductor info
	 * 
	 * @return JTextArea displayConductorInfo
	 * */
	protected JTextArea getConductorDisplay(){
		return this.displayConductorInfo;
	}
	
	
	/**
	 * Accessor of the textarea for reset game
	 * 
	 * @return JTextArea btnReset
	 * */
	protected JButton getResetBtn() {
		return btnReset;
	}
	
	/*END ACCESSOR*/
	
	
	/*MUTATOR*/
	protected void setBoardbtnEnable(boolean isEnable){
		btnBoard.setEnabled(isEnable);
	}
	
	protected void setRemoveCrgBtnEnable(boolean isEnable){
		btnRemoveCarriage.setEnabled(isEnable);
	}
	/*END MUTATOR*/
	
	
	
	/*DISPLAYED INFO */
	
	
	/**
	 * update the driver textarea
	 * 
	 * @param String message : message for displayed
	 * @param JTextArea display : the name of textarea when the info will be displayed
	 * */
	protected void updateInfo(String message, JTextArea display, Color color){
		display.append(message + newline);
		display.setForeground(color);
		display.update(display.getGraphics());
		display.setCaretPosition(display.getDocument().getLength());
	}
	
	
	/**
	 * show the error message in dialog box
	 * 
	 * @param String errorMsg : error message that will be displayed
	 * */
	protected void showErrorMessage(String errorMsg){
		JOptionPane.showConfirmDialog(null, errorMsg, "Setting Locomotive",
				JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
	}
	/*END DISPLAYED INFO*/
	
	
	
	/*CARRIAGE IMAGES*/
	
	protected void updateImage(ArrayList<CarriageImage> imagesList){
		removeAllImages();
		addCarriageImages(imagesList);
	}
	
	protected void removeAllImages(){
		pnlShowImage.removeAll();
		pnlShowImage.repaint();
		pnlShowImage.revalidate();
	}
	
	
	
	
	/**
	 * Method for add an image in the Info Graphic
	 * 
	 * @param String name: a string that is displayed in the image. Taken from object's tostring
	 * @param TrainModel.CarriageTypes type: the type of carriages which is defined in 
	 * CarriageTypes enum in TrainModel class
	 */
	
	protected void addCarriageImages(ArrayList<CarriageImage> imagesList){
		
		for(int i = 0; i < imagesList.size(); i++){
			pnlShowImage.add(imagesList.get(i));
		}
		
		pnlShowImage.repaint();
		pnlShowImage.revalidate();
	}
	/*END CARRIAGE IMAGE*/
	
	
	/*USER'S INPUT*/
	
	/**
	 * Take the user's input to add passengers when boarding
	 * 
	 * @return Integer : the number of passengers that will be add in the train
	 * */
	protected Integer addPassengers(){
		JTextField txtPassengers = new JTextField();
		
		Object[] message = {
				"Passenger boarding :", txtPassengers,	
			};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Passenger boarding", 
				JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtPassengers)) {
		    
			Integer addPassengers = Integer.parseInt(txtPassengers.getText());
		    return addPassengers;
		
		} 
		else {
		    return null;
		}	
	}
	
	
	
	/**
	 * Taken the user's input when add locomotive in the train
	 * 
	 * @param String[] engineType: a string array contains the engine types 
	 * @param String[] enginePower: a string array contains the engine power
	 * 
	 * @return Object[]: a object array that contain the type of engine, the power type of engine,
	 *  the weight of engine
	 * */
	protected Object[] settingLocomotive(String[] engineType, String[] enginePower){
		JTextField txtGrossWeight = new JTextField();
		
		//set up combo boxes and textfield
		JComboBox<Object> cmbEngineType = new JComboBox<Object>(engineType);
		JComboBox<Object> cmbEnginePower = new JComboBox<Object>(enginePower);
		cmbEngineType.setSelectedIndex(-1);
		cmbEnginePower.setSelectedIndex(-1);
		Object[] message = {
			"Gross weight (Tonnes):", txtGrossWeight,	
		    "Engine Types:", cmbEngineType,
		    "Engine Power:", cmbEnginePower
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Locomotive", 
				JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION && isComboInputValid(cmbEngineType) && 
				isComboInputValid(cmbEnginePower) && isIntegerInputValid(txtGrossWeight)) {
		    Object[] locoParams = new Object[3]; //(1)gross weight, (2)engineType, (3)enginepower 
		    
		    //set data
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
	 * 
	 * @return boolean
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
	 * @return String: One of carriages choosen by users, Otherwise null
	 * */
	protected String chooseCar(String[] carToChoose){
		
		//setting combobox
		JComboBox<Object> carTypes = new JComboBox<Object>(carToChoose);
		
		Object[] message = {
		    "Carriage Types:", carTypes
		};
		carTypes.setSelectedIndex(-1);

		//show form dgialof
		int option = JOptionPane.showConfirmDialog(null, message, "Choose Carriage",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION && carTypes.getSelectedIndex()!=-1) {
		    
			return (String) carTypes.getSelectedItem();
		} 
		    return null;
	}

	
	/**
	 * Return an Integer array that contains parameters for create a passenger car
	 * 
	 * @return Integer[] parameters that choosen by users, otherwise null
	 * */
	protected Integer[] settingPassengerCar() {
		
		JTextField txtGrossWeight = new JTextField();
		JTextField txtNumOfSeats = new JTextField();
		
		Object[] message = {
			"Gross weight (Tonnes):", txtGrossWeight,	
		    "Number of Seats:", txtNumOfSeats
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Setting Passenger Car", 
				JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtGrossWeight) 
				&& isIntegerInputValid(txtNumOfSeats)) {
		   
			Integer[] passCarParams = new Integer[2]; //(1)gross weight, (2)number of seats
			
			//set data
		    passCarParams[0] = Integer.parseInt(txtGrossWeight.getText());
		    passCarParams[1] = Integer.parseInt(txtNumOfSeats.getText());

		    return passCarParams;
		} else {
		    return null;
		}	
	}
	
	
	/**
	 * Return an Integer array that contains parameters for create a freight car
	 * 
	 * @return Object[] parameters that choosen by users. Otherwise null.
	 * */
	protected Object[] settingFreightCar(String[] goodsType) {
		
		//create dialog
		JTextField txtGrossWeight = new JTextField();
		JComboBox<Object> cbGoodsType = new JComboBox<Object>(goodsType);
		cbGoodsType.setSelectedIndex(-1);
		
		Object[] message = {
			"Gross weight (Tonnes):", txtGrossWeight,	
		    "GoodsType:", cbGoodsType
		};

		//pop up
		int option = JOptionPane.showConfirmDialog(null, message, "Setting Passenger Car", 
				JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION && isIntegerInputValid(txtGrossWeight) && 
				isComboInputValid(cbGoodsType)) {
		    
			//catch the user's inputs
			Object[] freightCarParams = new Object[2]; //(1)gross weight, (2)goodsType
			freightCarParams[0] = Integer.parseInt(txtGrossWeight.getText());
		    freightCarParams[1] = cbGoodsType.getSelectedItem().toString();

		    return freightCarParams;
		} else {
		    return null;
		}	
	}
	/*END USER'S INPUT*/


	/*RESET GAME*/
	
	/**
	 * Call another method to clean up the current states in this GUI
	 * */
	protected void resetGame(){
		//clean up driver display
		cleanDisplay(this.displayDriverInfo);
		
		//clean up conductor display
		cleanDisplay(this.displayConductorInfo);
		
		//clean up train images
		removeAllImages();
	}

	
	

	/**
	 * Clean up display
	 * */
	private void cleanDisplay(JTextArea textArea) {
		textArea.setText("");
	}
	/*END RESET GAME*/

}/*END TRAIN GUI CLASS*/


/**
 * 
 * This class has a usage for create the train image
 * 
 * @author Lalu Fahany Yazikri
 */
class CarriageImage extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	private String carriageName;
	
	private Color carriageColor;
	
	
	/**
	 * Constructor taken two arguments. Set the carriage name that will be represented from 
	 * the color of image and the string of carriage that will be displayed in the image
	 * 
	 * @param carriageName - the string that will display in the carriage image
	 * @param carriageType - the carriage type based on the type defined in TrainModel.CarriageTypes enum 
	 * */
	public CarriageImage(String carriageName, TrainModel.CarriageTypes carriageType){
		setCarriageName(carriageName);
		setColor(carriageType);
	}

	/**
	 * Mutator for the string which display in the image
	 * @param carriageName - the string that will display in the carriage image
	 */
	public void setCarriageName(String carriageName){
		this.carriageName = carriageName;
	}
	
	/**
	 * set up the color of the carriage image based on carriage type
	 * 
	 * @param carriageType -  the carriage type based on the type defined in TrainModel.CarriageTypes enum 
	 * */
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

    
    /**
     * 
     * @return the dimensions of carriage image
     * */
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(170, 80);
    }
	
	
	/**
	 * Override paint method in JPanel
	 * 
	 * @param Graphics g
	 * */
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
        g.setColor(Color.white);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("1", g);
        g.drawString(carriageName, (int)b.width/5,
                          (int) (b.y + b.height/2 + rect.getHeight()/2));
    	
    }	
    
}
