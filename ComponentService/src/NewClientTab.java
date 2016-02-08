import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewClientTab extends AbstractTab{

	private JPanel newClientPanel;

	private JButton newClientBackBtn;
	private JButton submitNewClientBtn;
	private JButton clearClientBtn;

	private JLabel newClientBackgroundLabel;
	private JLabel addNewClientLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel telLabel;
	private JLabel requiredLabel;

	private JTextField clientFirstNametxtField;
	private JTextField clientLastNametxtField;
	private JTextField clientTelNumtxtField;

	//Constructor
	public NewClientTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one
		initializeUI(parent, databaseConnection);		

	}

	//UI initialization 
	@Override
	void initializeUI(JPanel parent, MySQLConnect databaseConnection) {
		//Creating 'Add New Client' panel
		newClientPanel = new JPanel();
		designPanel(newClientPanel,0, 0, 614, 344);

		//'Submit' Button
		submitNewClientBtn = new JButton("Submit");
		designStandartButton(submitNewClientBtn, new Font("Tahoma", Font.BOLD, 16),
				SystemColor.textHighlight, Color.WHITE, 484, 123, 91, 75);
		addSubmitButtonAction(parent, databaseConnection);

		//'Clear' Button
		clearClientBtn = new JButton("Clear");
		designStandartButton(clearClientBtn, new Font("Tahoma", Font.PLAIN, 16),
				Color.RED, Color.WHITE, 484, 89, 91, 23);
		addClearButtonAction();

		//'Back' Button
		//BackButton design settings
		newClientBackBtn = new JButton("");
		designRolloverButton(newClientBackBtn, this.getClass().getResource("/back_blackwhite.png"),
				this.getClass().getResource("/back_colored.png"), 0, 294, 50, 50);
		addBackButtonAction(parent);

		//Labels
		//'Add New Client' main label
		addNewClientLabel = new JLabel("Add New Client");
		designLabel(addNewClientLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 11, 300, 50);

		//'First Name' label
		firstNameLabel = new JLabel("First name:");
		designLabel(firstNameLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 133, 72, 137, 50);


		//'Last Name' label
		lastNameLabel = new JLabel("Last name:");
		designLabel(lastNameLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 133, 133, 137, 50);

		//'Tel Num' label
		telLabel = new JLabel("Tel:");
		designLabel(telLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 161, 219, 41, 50);

		//'*' required symbol label
		requiredLabel = new JLabel("(*)required");
		designLabel(requiredLabel, Color.RED,new Font("Tahoma", Font.ITALIC, 15), 522, 318, 81, 26);

		//Textfields

		//'First Name' txtField
		clientFirstNametxtField = new JTextField();
		designTextfield(clientFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 76, 153, 46, 10);

		//'Last Name' txtField
		clientLastNametxtField = new JTextField();
		designTextfield(clientLastNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 137, 153, 46, 10);

		//'Tel Num' txtField
		clientTelNumtxtField = new JTextField();
		designTextfield(clientTelNumtxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 212, 219, 186, 46, 10);
		
		//NewClient panel Background
		newClientBackgroundLabel = new JLabel("");
		designPanelBackground(newClientBackgroundLabel,this.getClass().getResource("/office_backgrond.png"),
				0,0,614,344);

		//Adding components to 'New Technician' panel
		addComponentsToPanel();

	}

	//Panel Getter
	public JPanel getNewClientPanel(){
		return newClientPanel;
	}
	
	//Adding components to main panel 
		@Override
		void addComponentsToPanel() {
			newClientPanel.add(submitNewClientBtn);
			newClientPanel.add(clearClientBtn);
			newClientPanel.add(newClientBackBtn);

			newClientPanel.add(addNewClientLabel);
			newClientPanel.add(firstNameLabel);
			newClientPanel.add(lastNameLabel);
			newClientPanel.add(telLabel);
			newClientPanel.add(requiredLabel);

			newClientPanel.add(clientFirstNametxtField);
			newClientPanel.add(clientLastNametxtField);
			newClientPanel.add(clientTelNumtxtField);
			
			newClientPanel.add(newClientBackgroundLabel);

		}

	private void addClearButtonAction() {
		// TODO Auto-generated method stub

	}

	private void addSubmitButtonAction(JPanel parent, MySQLConnect databaseConnection) {
		// TODO Auto-generated method stub

	}

	

	//'Back' Button action
	@Override
	void addBackButtonAction(final JPanel parentPanel) {
		newClientBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.setVisible(true);
				newClientPanel.setVisible(false);
			}
		});

	}

}
