import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewTechnicianTab {

	private JPanel newTechnicianPanel;

	private JButton newTechnicianBackBtn;
	private JButton clearTechnicianBtn;
	private JButton submitNewTechnicianBtn;

	private JLabel newTechnicianBackgroundLabel;
	private JLabel hireTechLabel;
	private JLabel firstNamelabel;
	private JLabel middleNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel telNumLabel;
	private JLabel requiredTechLbl;

	private Image backBtn;
	private Image backRolloverBtn;
	private Image newTechnicianBackground;

	private JTextField technicianFirstNametxtField;
	private JTextField technicianMiddleNametxtField;
	private JTextField technicianLastNametxtField;
	private JTextField technicianEmailtxtField;
	private JTextField technicianTelNumtxtField;

	//Constructor
	public NewTechnicianTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one
		initializeUI(parent, databaseConnection);		

	}

	//UI initialization method
	private void initializeUI(final JPanel parent, final MySQLConnect databaseConnection){
		//Creating 'New Technician' panel
		newTechnicianPanel = new JPanel();
		newTechnicianPanel.setBounds(0, 0, 614, 344);
		newTechnicianPanel.setLayout(null);
		newTechnicianPanel.setVisible(true);

		//'Submit' Button
		submitNewTechnicianBtn = new JButton("Submit");
		submitNewTechnicianBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		submitNewTechnicianBtn.setBackground(SystemColor.textHighlight);
		submitNewTechnicianBtn.setForeground(Color.WHITE);
		submitNewTechnicianBtn.setBounds(484, 123, 91, 75);
		addSubmitButtonAction(parent, databaseConnection);


		//'Clear' Button
		clearTechnicianBtn = new JButton("Clear");
		clearTechnicianBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearTechnicianBtn.setBackground(Color.RED);
		clearTechnicianBtn.setForeground(Color.WHITE);
		clearTechnicianBtn.setBounds(484, 89, 91, 23);
		addClearButtonAction();


		//'Back' Button
		//BackButton design settings
		backBtn = new ImageIcon(this.getClass().getResource("/back_blackwhite.png")).getImage();
		backRolloverBtn = new ImageIcon(this.getClass().getResource("/back_colored.png")).getImage();

		newTechnicianBackBtn = new JButton("");
		newTechnicianBackBtn.setBounds(0, 294, 50, 50);
		newTechnicianBackBtn.setContentAreaFilled(false);
		newTechnicianBackBtn.setBorderPainted(false);
		newTechnicianBackBtn.setRolloverEnabled(true);
		newTechnicianBackBtn.setIcon(new ImageIcon(backBtn));
		newTechnicianBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
		newTechnicianBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				newTechnicianPanel.setVisible(false);
			}
		});

		//Labels
		//'Hire Technician' main label
		hireTechLabel = new JLabel("Hire a technician");
		designLabel(hireTechLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 11, 300, 50);

		//'First Name' label
		firstNamelabel = new JLabel("First name:");
		designLabel(firstNamelabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 130, 72, 140, 50);

		//'Middle Name' label
		middleNameLabel = new JLabel("Middle name:");
		designLabel(middleNameLabel,  SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 20), 133, 133, 137, 50);

		//'Last Name' label
		lastNameLabel = new JLabel("Last name:");
		designLabel(lastNameLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 130, 194, 137, 50);

		//'Email' label
		emailLabel = new JLabel("Email:");
		designLabel(emailLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 20), 84, 269, 68, 50);

		//'Tel Num' label
		telNumLabel = new JLabel("Tel:");
		designLabel(telNumLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 354, 269, 68, 50);

		//'*' required symbol label
		requiredTechLbl = new JLabel("(*)required");
		designLabel(requiredTechLbl, Color.RED,new Font("Tahoma", Font.ITALIC, 15), 522, 318, 81, 26);
		newTechnicianPanel.add(requiredTechLbl);

		//Textfields

		//'First Name' txtField
		technicianFirstNametxtField = new JTextField();
		designTextfield(technicianFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 76, 153, 46, 10);

		//'Middle Name' txtField
		technicianMiddleNametxtField = new JTextField();
		designTextfield(technicianMiddleNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 137, 153, 46, 10);

		//'Last Name' txtField
		technicianLastNametxtField = new JTextField();
		designTextfield(technicianLastNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 198, 153, 46, 10);

		//'Email' txtField
		technicianEmailtxtField = new JTextField();
		designTextfield(technicianEmailtxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 157, 273, 187, 46, 10);

		//'Tel Num' txtField
		technicianTelNumtxtField = new JTextField();
		designTextfield(technicianTelNumtxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 403, 273, 200, 46, 10);

		//NewTechnician Background
		newTechnicianBackground = new ImageIcon(this.getClass().getResource("/office_backgrond.png")).getImage();
		newTechnicianBackgroundLabel = new JLabel("");
		newTechnicianBackgroundLabel.setBounds(0, 0, 614, 344);
		newTechnicianBackgroundLabel.setIcon(new ImageIcon(newTechnicianBackground));

		//Adding components to 'New Technician' panel
		addComponentsToPanel();
	}

	//Panel Getter
	public JPanel getNewTechnicianPanel(){
		return newTechnicianPanel;
	}

	//Label design method
	private void designLabel(JLabel label, Color foregroundColor, Font font, int x , int y, int width, int height){
		label.setForeground(foregroundColor);
		label.setFont(font);
		label.setBounds(x, y, width, height);
	}

	//Textfield design method
	private void designTextfield(JTextField txtField, Color backgroundColor, int horizontalAlign, Font font, Color foregroundColor,
			int x, int y, int width, int height, int numOfCols){
		txtField.setBackground(backgroundColor);
		txtField.setHorizontalAlignment(horizontalAlign);
		txtField.setFont(font);
		txtField.setForeground(foregroundColor);
		txtField.setBounds(x, y, width, height);
		txtField.setColumns(numOfCols);
	}

	//Adding components to main panel method
	private void addComponentsToPanel(){
		
		newTechnicianPanel.add(submitNewTechnicianBtn);
		newTechnicianPanel.add(clearTechnicianBtn);
		newTechnicianPanel.add(newTechnicianBackBtn);

		newTechnicianPanel.add(hireTechLabel);
		newTechnicianPanel.add(firstNamelabel);
		newTechnicianPanel.add(middleNameLabel);
		newTechnicianPanel.add(lastNameLabel);
		newTechnicianPanel.add(emailLabel);
		newTechnicianPanel.add(telNumLabel);

		newTechnicianPanel.add(technicianFirstNametxtField);
		newTechnicianPanel.add(technicianMiddleNametxtField);
		newTechnicianPanel.add(technicianLastNametxtField);
		newTechnicianPanel.add(technicianTelNumtxtField);
		newTechnicianPanel.add(technicianEmailtxtField);
		
		newTechnicianPanel.add(newTechnicianBackgroundLabel);
	}
	
	//'Submit' button action
	private void addSubmitButtonAction(final JPanel parent,final MySQLConnect db){
		submitNewTechnicianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					//Email address validation
					if(!(isValidEmailAddress(technicianEmailtxtField.getText())) && !technicianEmailtxtField.getText().equals("")){
						JOptionPane.showMessageDialog(parent,
								"Your email address is incorrect!\nYou can either correct it or leave it blank!",
								"Error",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					db.addTechnician(technicianFirstNametxtField.getText(), technicianMiddleNametxtField.getText(),
							technicianLastNametxtField.getText(), technicianTelNumtxtField.getText(), technicianEmailtxtField.getText());

					JOptionPane.showMessageDialog(parent,
							db.technicianResult(),
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
	
	//'Clear' Button action
	private void addClearButtonAction(){
		clearTechnicianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				technicianFirstNametxtField.setText("");
				technicianMiddleNametxtField.setText("");
				technicianLastNametxtField.setText("");
				technicianEmailtxtField.setText("");
				technicianTelNumtxtField.setText("");
			}
		});
	}
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

}
