import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyTasksTab extends AbstractTab{

	private JPanel myTasksPanel;

	private JButton backBtn;
	private JButton showBtn;

	//Informative labels
	private JLabel backgroundLabel;
	private JLabel mainInfoLabel;
	private JLabel youAreInfoLabel;
	private JLabel chooseATaskInfoLabel;
	private JLabel orderIdInfoLabel;
	private JLabel clientInfoLabel;
	private JLabel priceInfoLabel;
	private JLabel componentTypeInfoLabel;
	private JLabel clientTelInfoLabel;
	private JLabel statusInfoLabel;
	private JLabel componentModelInfoLabel;
	private JLabel entryDateInfoLabel;
	private JLabel readyDateInfoLabel;
	private JLabel diagnosticResultsInfoLabel;

	//Action labels
	private JLabel orderIdActLabel;
	private JLabel clientActLabel;
	private JLabel priceActLabel;
	private JLabel componentTypeActLabel;
	private JLabel clientTelActLabel;
	private JLabel statusActLabel;
	private JLabel componentModelActLabel;
	private JLabel entryDateActLabel;
	private JLabel readyDateActLabel;

	private JTextArea diagnosticResultsTxtArea;

	private JComboBox<String> technicianComboBox;
	private JComboBox<String> taskComboBox;

	//Constructor
	public MyTasksTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one
		initializeUI(parent, databaseConnection);	
	}

	//UI initialization 
	@Override
	void initializeUI(JPanel parent, MySQLConnect databaseConnection) {
		//Creating 'My Tasks' panel
		myTasksPanel = new JPanel();
		designPanel(myTasksPanel,0, 0, 614, 344);

		//Buttons
		//'>' Show button
		showBtn = new JButton(">");
		designStandartButton(showBtn, new Font("Tahoma", Font.PLAIN, 26),
				SystemColor.textHighlight, Color.WHITE, 278, 94, 53, 40);
		addShowButtonAction(parent, databaseConnection);

		//'Back' Button
		//BackButton design settings
		backBtn = new JButton("");
		designRolloverButton(backBtn, this.getClass().getResource("/back_blackwhite.png"),
				this.getClass().getResource("/back_colored.png"), 0, 294, 50, 50);
		addBackButtonAction(parent);

		//Labels
		//Informative labels
		//'My Tasks' main label
		mainInfoLabel = new JLabel("My Tasks");
		designLabel(mainInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 11, 151, 50);

		//'You are' info label
		youAreInfoLabel = new JLabel("You are");
		designLabel(youAreInfoLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 5, 64, 74, 40);

		//'Choose a task' info label
		chooseATaskInfoLabel = new JLabel("Choose a task");
		designLabel(chooseATaskInfoLabel, Color.RED,new Font("Tahoma", Font.BOLD, 17), 341, 64, 126, 40);

		//'Order ID:' info label
		orderIdInfoLabel = new JLabel("Order ID:");
		designLabel(orderIdInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 10, 130, 60, 40);

		//'Client:' info label
		clientInfoLabel = new JLabel("Client:");
		designLabel(clientInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 240, 130, 55, 40);

		//'Price:' info label
		priceInfoLabel = new JLabel("Price:");
		designLabel(priceInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 15), 447, 130, 50, 40);

		//'Component type:' info label
		componentTypeInfoLabel = new JLabel("Component type:");
		designLabel(componentTypeInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 10, 162, 118, 40);

		//'Client Tel:' info label
		clientTelInfoLabel = new JLabel("Client tel:");
		designLabel(clientTelInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 239, 162, 84, 40);

		//'Status:' info label
		statusInfoLabel = new JLabel("Status:");
		designLabel(statusInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 447, 162, 55, 40);

		//'Component model:' info label
		componentModelInfoLabel = new JLabel("Component model:");
		designLabel(componentModelInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 10, 192, 126, 40);

		//'Entry date:' info label
		entryDateInfoLabel = new JLabel("Entry date:");
		designLabel(entryDateInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 10, 224, 74, 40);

		//'Ready date:' info label
		readyDateInfoLabel = new JLabel("Ready date:");
		designLabel(readyDateInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 13), 10, 256, 84, 40);

		//'Diagnostic results:' info label
		diagnosticResultsInfoLabel = new JLabel("Diagnostic results:");
		designLabel(diagnosticResultsInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 15), 322, 224, 151, 25);

		//Action labels
		//'Order ID:' Action label
		orderIdActLabel = new JLabel("");
		designLabel(orderIdActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 71, 137, 158, 25);

		//'Client:' Action label
		clientActLabel = new JLabel("");
		designLabel(clientActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 288, 139, 168, 25);

		//'Price:' Action label
		priceActLabel = new JLabel("");
		designLabel(priceActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 16), 497, 136, 107, 25);

		//'Component type:' Action label
		componentTypeActLabel = new JLabel("");
		designLabel(componentTypeActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 124, 169, 126, 25);

		//'Client tel:' Action label
		clientTelActLabel = new JLabel("");
		designLabel(clientTelActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 305, 169, 151, 25);

		//'Status:' Action label
		statusActLabel = new JLabel("");
		designLabel(statusActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 16), 496, 169, 108, 25);

		//'Component model:' Action label
		componentModelActLabel = new JLabel("");
		designLabel(componentModelActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 134, 199, 197, 25);

		//'Entry date:' Action label
		entryDateActLabel = new JLabel("");
		designLabel(entryDateActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 85, 231, 133, 25);

		//'Ready date:' Action label
		readyDateActLabel = new JLabel("");
		designLabel(readyDateActLabel, Color.BLACK,new Font("Tahoma", Font.PLAIN, 15), 94, 263, 143, 25);

		//Text area
		//'Diagnostic results' txtArea
		diagnosticResultsTxtArea = new JTextArea();
		designDiagnosticTxtArea(diagnosticResultsTxtArea);

		//Act content default clearance
		clearActContent();

		//Combo Boxes
		//Technician combo box
		technicianComboBox = new JComboBox<String>();
		technicianComboBox.setForeground(Color.WHITE);
		technicianComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		technicianComboBox.setBackground(SystemColor.textHighlight);
		technicianComboBox.setBounds(5, 103, 263, 25);

		//Tasks combo box
		taskComboBox = new JComboBox<String>();
		taskComboBox.setForeground(Color.WHITE);
		taskComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taskComboBox.setBackground(SystemColor.textHighlight);
		taskComboBox.setBounds(341, 103, 263, 25);
		addTasksComboBoxListener(databaseConnection);



		//Comboboxes initialization
		initializeComboBoxes(databaseConnection);

		//My Tasks Background
		backgroundLabel = new JLabel("");
		designPanelBackground(backgroundLabel,this.getClass().getResource("/service_background.png"),
				0,0,614,344);

		//Adding components to 'My Tasks' panel
		addComponentsToPanel();


	}

	//'Tasks' Combo box listener
	private void addTasksComboBoxListener(final MySQLConnect databaseConnection) {
		taskComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    
    				try {
    					databaseConnection.componentInfo(taskComboBox.getSelectedItem().toString());

    					orderIdActLabel.setText(databaseConnection.componentOrderId());
    					componentTypeActLabel.setText(databaseConnection.componentType());
    					componentModelActLabel.setText(databaseConnection.componentModel());
    					entryDateActLabel.setText(databaseConnection.componentEntryDate());
    					if(databaseConnection.componentReadyDate() == null){
    						readyDateActLabel.setText("Not yet ready");
    						
    						
    					}
    					else{
    						SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    						String date_to_string = dateformatyyyyMMdd.format(databaseConnection.componentReadyDate());
    						readyDateActLabel.setText(date_to_string);
    					}
    					clientActLabel.setText(databaseConnection.componentClientFirstName() + " " + databaseConnection.componentClientLastName());
    					clientTelActLabel.setText(databaseConnection.componentClientTelNum());
    					switch (databaseConnection.componentStatus()) {
							case "Not yet started":
								statusActLabel.setForeground(Color.RED);
								break;
							case "Being repaired...":
								statusActLabel.setForeground(Color.ORANGE);
								break;
							case "Ready":
								statusActLabel.setForeground(Color.GREEN);
								break;

							default:
								break;
						}
    					statusActLabel.setText(databaseConnection.componentStatus());
    					if(databaseConnection.componentOrderPrice() == 0.0){
    						priceActLabel.setText("Not yet ready");
    					}
    					else{
    						priceActLabel.setText(Float.toString(databaseConnection.componentOrderPrice()));
    					}


    					if(databaseConnection.componentDiagnosticResults() == null){
    						diagnosticResultsTxtArea.setText("Not yet repaired");
    					}
    					else{
    						diagnosticResultsTxtArea.setText(databaseConnection.componentDiagnosticResults());
    					}
    					
    					
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	
                }

			}
		});
		
	}

	//Panel Getter
	public JPanel getMyTasksPanel(){
		return myTasksPanel;
	}

	//Adding components to main panel 
	@Override
	void addComponentsToPanel() {

		myTasksPanel.add(showBtn);
		myTasksPanel.add(backBtn);

		myTasksPanel.add(mainInfoLabel);
		myTasksPanel.add(youAreInfoLabel);
		myTasksPanel.add(chooseATaskInfoLabel);
		myTasksPanel.add(orderIdInfoLabel);
		myTasksPanel.add(clientInfoLabel);
		myTasksPanel.add(priceInfoLabel);
		myTasksPanel.add(componentTypeInfoLabel);
		myTasksPanel.add(clientTelInfoLabel);
		myTasksPanel.add(statusInfoLabel);
		myTasksPanel.add(componentModelInfoLabel);
		myTasksPanel.add(entryDateInfoLabel);
		myTasksPanel.add(readyDateInfoLabel);
		myTasksPanel.add(diagnosticResultsInfoLabel);

		myTasksPanel.add(orderIdActLabel);
		myTasksPanel.add(clientActLabel);
		myTasksPanel.add(priceActLabel);
		myTasksPanel.add(componentTypeActLabel);
		myTasksPanel.add(clientTelActLabel);
		myTasksPanel.add(statusActLabel);
		myTasksPanel.add(componentModelActLabel);
		myTasksPanel.add(entryDateActLabel);
		myTasksPanel.add(readyDateActLabel);

		myTasksPanel.add(diagnosticResultsTxtArea);

		myTasksPanel.add(technicianComboBox);
		myTasksPanel.add(taskComboBox);

		myTasksPanel.add(backgroundLabel);


	}



	private void addShowButtonAction(JPanel parent, final MySQLConnect databaseConnection) {
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				taskComboBox.removeAllItems();

				if(technicianComboBox.getSelectedItem() != null){
				String record = technicianComboBox.getSelectedItem().toString();

				try {
				databaseConnection.showTasks(record);
				
				for(String str : databaseConnection.componentsInfo()){
					taskComboBox.addItem(str);
				}
					} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				if(taskComboBox.getItemCount() == 0){
					clearActContent();
				}

				}
			}
			
		});

	}


	//'Back' Button action
	@Override
	void addBackButtonAction(final JPanel parentPanel) {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTasksPanel.setVisible(false);
				parentPanel.setVisible(true);


			}
		});

	}
	
	//ACT content clear
	private void clearActContent(){
		orderIdActLabel.setText("");
		componentTypeActLabel.setText("");
		componentModelActLabel.setText("");
		clientTelActLabel.setText("");
		clientActLabel.setText("");
		entryDateActLabel.setText("");
		readyDateActLabel.setText("");
		priceActLabel.setText("");
		statusActLabel.setText("");
		diagnosticResultsTxtArea.setText("");
	}
	//Default ComboBox initialization
	private void initializeComboBoxes(MySQLConnect databaseConnection){
		technicianComboBox.removeAllItems();
		taskComboBox.removeAllItems();

		try {
			databaseConnection.allTechnicians();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		for(String str : databaseConnection.techniciansInfo()){
			technicianComboBox.addItem(str);

		}
	}
	//Designing 'Diagnostic Results' txt area
	private void designDiagnosticTxtArea(JTextArea area){
		area.setForeground(Color.WHITE);
		area.setBackground(SystemColor.textHighlight);
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setEditable(false);
		area.setLineWrap(true);
		area.setBounds(259, 256, 297, 85);
	}

}
