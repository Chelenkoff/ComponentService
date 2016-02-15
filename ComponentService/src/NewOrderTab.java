import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewOrderTab extends AbstractTab{

	private JPanel newOrderPanel;

	private JButton newOrderBackBtn;
	private JButton submitNewOrderBtn;
	private JButton clearOrderBtn;
	private JButton pickDateBtn;

	private JLabel newOrderBackgroundLabel;
	private JLabel newOrderLabel;
	private JLabel componentTypeLabel;
	private JLabel componentModelLabel;
	private JLabel chooseClientLabel;
	private JLabel chooseTechnicianLabel;
	private JLabel entryDateLabel;
	private JLabel requiredLabel;

	private JTextField componentTypeTxtField;
	private JTextField componentModelTxtField;

	private ObservingTextField entryDateObsTxtField;

	private JComboBox<String> clientsComboBox;
	private JComboBox<String> techniciansComboBox;

	//Constructor
	public NewOrderTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one

		//Connecting to database
		try {
			databaseConnection.allClients();
			databaseConnection.allTechnicians();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot conet");
//			e.printStackTrace();
		}

		initializeUI(parent, databaseConnection);	


	}

	//UI initialization 
	@Override
	void initializeUI(JPanel parent, MySQLConnect databaseConnection) {
		//Creating 'New Order' panel
		newOrderPanel = new JPanel();
		designPanel(newOrderPanel,0, 0, 614, 344);

		//Buttons
		//'Submit' Button
		submitNewOrderBtn = new JButton("Submit");
		designStandartButton(submitNewOrderBtn, new Font("Tahoma", Font.BOLD, 16),
				SystemColor.textHighlight, Color.WHITE, 507, 231, 97, 70);
		addSubmitButtonAction(parent, databaseConnection);

		//'Clear' Button
		clearOrderBtn = new JButton("Clear");
		designStandartButton(clearOrderBtn, new Font("Tahoma", Font.PLAIN, 16),
				Color.RED, Color.WHITE, 507, 197, 97, 23);
		addClearButtonAction();

		//'Pick date' Button
		pickDateBtn = new JButton("Pick ...");
		designStandartButton(pickDateBtn, new Font("Tahoma", Font.PLAIN, 16),
				SystemColor.textHighlight, Color.WHITE, 394, 301, 85, 23);
		addPickDateButtonAction();

		//'Back' Button
		//BackButton design settings
		newOrderBackBtn = new JButton("");
		designRolloverButton(newOrderBackBtn, this.getClass().getResource("/back_blackwhite.png"),
				this.getClass().getResource("/back_colored.png"), 0, 294, 50, 50);
		addBackButtonAction(parent);

		//Labels
		//'New Order' main label
		newOrderLabel = new JLabel("New Order");
		designLabel(newOrderLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 11, 300, 50);

		//'Component type' label
		componentTypeLabel = new JLabel("Component type:");
		designLabel(componentTypeLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 10, 72, 156, 50);

		//'Component model' label
		componentModelLabel = new JLabel("Component model:");
		designLabel(componentModelLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 304, 72, 163, 50);

		//'Choose client' label
		chooseClientLabel = new JLabel("Choose client");
		designLabel(chooseClientLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 250, 122, 126, 40);

		//'Choose technician' label
		chooseTechnicianLabel = new JLabel("Choose technician");
		designLabel(chooseTechnicianLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 238, 197, 156, 40);

		//'Entry date' label
		entryDateLabel = new JLabel("Entry date");
		designLabel(entryDateLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 161, 293, 95, 40);

		//'*' required symbol label
		requiredLabel = new JLabel("(*)required");
		designLabel(requiredLabel, Color.RED,new Font("Tahoma", Font.ITALIC, 15), 522, 318, 81, 26);

		//Textfields
		//'Component type' txtField
		componentTypeTxtField = new JTextField();
		designTextfield(componentTypeTxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 15),
				Color.WHITE, 168, 84, 126, 27, 10);

		//'Component model' txtField
		componentModelTxtField = new JTextField();
		designTextfield(componentModelTxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 15),
				Color.WHITE, 478, 84, 126, 27, 10);

		//'Entry date' observing txtField
		entryDateObsTxtField = new ObservingTextField();
		designTextfield(entryDateObsTxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 258, 300, 126, 27, 10);
		entryDateObsTxtField.setEditable(false);
		setDefaultDate();

		//Combo Boxes
		//Clients combo box
		clientsComboBox = new JComboBox<String>();
		clientsComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientsComboBox.setForeground(Color.WHITE);
		clientsComboBox.setBackground(SystemColor.textHighlight);
		clientsComboBox.setBounds(122, 161, 375, 33);

		//Technicians combo box
		techniciansComboBox = new JComboBox<String>();
		techniciansComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		techniciansComboBox.setForeground(Color.WHITE);
		techniciansComboBox.setBackground(SystemColor.textHighlight);
		techniciansComboBox.setBounds(122, 238, 375, 33);

		//Comboboxes initialization
		initializeComboBoxes(parent,databaseConnection);

		//NewOrder panel Background
		newOrderBackgroundLabel = new JLabel("");
		designPanelBackground(newOrderBackgroundLabel,this.getClass().getResource("/office_backgrond.png"),
				0,0,614,344);

		//Adding components to 'New Technician' panel
		addComponentsToPanel();

	}

	//Panel Getter
	public JPanel getNewOrderPanel(){
		return newOrderPanel;
	}

	//Adding components to main panel 
	@Override
	void addComponentsToPanel() {

		newOrderPanel.add(submitNewOrderBtn);
		newOrderPanel.add(clearOrderBtn);
		newOrderPanel.add(pickDateBtn);
		newOrderPanel.add(newOrderBackBtn);

		newOrderPanel.add(newOrderLabel);
		newOrderPanel.add(componentTypeLabel);
		newOrderPanel.add(componentModelLabel);
		newOrderPanel.add(chooseClientLabel);
		newOrderPanel.add(chooseTechnicianLabel);
		newOrderPanel.add(entryDateLabel);
		newOrderPanel.add(requiredLabel);

		newOrderPanel.add(componentTypeTxtField);
		newOrderPanel.add(componentModelTxtField);

		newOrderPanel.add(entryDateObsTxtField);

		newOrderPanel.add(clientsComboBox);
		newOrderPanel.add(techniciansComboBox);

		newOrderPanel.add(newOrderBackgroundLabel);
	}

	//'Clear' Button action
	private void addClearButtonAction() {
		clearOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				componentTypeTxtField.setText("");
				componentModelTxtField.setText("");
			}
		});

	}

	private void addPickDateButtonAction() {
		pickDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(entryDateObsTxtField,locale);
				Date selectedDate = dp.parseDate(entryDateObsTxtField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(entryDateObsTxtField);
			}
		});

	}


	//'Submit' button action
	private void addSubmitButtonAction(final JPanel parent, final MySQLConnect databaseConnection) {
		submitNewOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String technicianId = new String();
					String clientId = new String();

					clientId = (String)clientsComboBox.getSelectedItem();
					clientId = clientId.substring(clientId.indexOf(":")+1,clientId.indexOf(" "));
					
					technicianId = (String)techniciansComboBox.getSelectedItem();
					technicianId = technicianId.substring(technicianId.indexOf(":")+1, technicianId.indexOf(" "));

					databaseConnection.createOrder(componentTypeTxtField.getText(), componentModelTxtField.getText(),
							clientId, technicianId,entryDateObsTxtField.getText());
					
					JOptionPane.showMessageDialog(parent,
						    databaseConnection.newOrderResult(),
						    "Warning",
						    JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(parent,
							"Not connected to a database",
							"Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}


	//'Back' Button action
	@Override
	void addBackButtonAction(final JPanel parentPanel) {
		newOrderBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.setVisible(true);
				newOrderPanel.setVisible(false);

			}
		});

	}

	//Setting default date at entryDateObsTxtField
	void setDefaultDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //2014-08-06
		Date date = new Date();
		entryDateObsTxtField.setText(dateFormat.format(date));
	}

	//Local timezone detection
	private Locale getLocale(String loc){
		if(loc != null && loc.length() > 0){
			return new Locale(loc);
		}
		else return Locale.US;
	}

	//Default ComboBox initialization
	private void initializeComboBoxes(final JPanel parent,final MySQLConnect databaseConnection){

		try {
			databaseConnection.allClients();
			databaseConnection.allTechnicians();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(parent,
					"Not connected to a database",
					"Error",
					JOptionPane.INFORMATION_MESSAGE);
//			e.printStackTrace();
		}

		clientsComboBox.removeAllItems();
		techniciansComboBox.removeAllItems();

		for(String str : databaseConnection.clientInfo()){
			clientsComboBox.addItem(str);
		}
		for(String str : databaseConnection.techniciansInfo()){
			techniciansComboBox.addItem(str);
		}


	}

}
