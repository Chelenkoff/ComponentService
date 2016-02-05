import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

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
		//'Submit' action
		submitNewTechnicianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					databaseConnection.addTechnician(technicianFirstNametxtField.getText(), technicianMiddleNametxtField.getText(),
							technicianLastNametxtField.getText(), technicianTelNumtxtField.getText(), technicianEmailtxtField.getText());

					JOptionPane.showMessageDialog(parent,
							databaseConnection.technicianResult(),
							"Warning",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		newTechnicianPanel.add(submitNewTechnicianBtn);

		//'Clear' Button
		clearTechnicianBtn = new JButton("Clear");
		clearTechnicianBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearTechnicianBtn.setBackground(Color.RED);
		clearTechnicianBtn.setForeground(Color.WHITE);
		clearTechnicianBtn.setBounds(484, 89, 91, 23);
		clearTechnicianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				technicianFirstNametxtField.setText("");
				technicianMiddleNametxtField.setText("");
				technicianLastNametxtField.setText("");
				technicianEmailtxtField.setText("");
				technicianTelNumtxtField.setText("");
			}
		});
		newTechnicianPanel.add(clearTechnicianBtn);

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
		newTechnicianPanel.add(newTechnicianBackBtn);

		//Labels
		//'Hire Technician' main label
		hireTechLabel = new JLabel("Hire a technician");
		designLabel(hireTechLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 11, 300, 50);
		newTechnicianPanel.add(hireTechLabel);


		//'First Name' label
		firstNamelabel = new JLabel("First name:");
		designLabel(firstNamelabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 130, 72, 140, 50);
		newTechnicianPanel.add(firstNamelabel);

		//'Middle Name' label
		middleNameLabel = new JLabel("Middle name:");
		designLabel(middleNameLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 133, 133, 137, 50);
		newTechnicianPanel.add(middleNameLabel);

		//'Last Name' label
		lastNameLabel = new JLabel("Last name:");
		designLabel(lastNameLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 130, 194, 137, 50);
		newTechnicianPanel.add(lastNameLabel);

		//'Email' label
		emailLabel = new JLabel("Email:");
		designLabel(emailLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 20), 84, 269, 68, 50);
		newTechnicianPanel.add(emailLabel);

		//'Tel Num' label
		telNumLabel = new JLabel("Tel:");
		designLabel(telNumLabel, Color.RED,new Font("Tahoma", Font.BOLD, 20), 354, 269, 68, 50);
		newTechnicianPanel.add(telNumLabel);

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
		newTechnicianPanel.add(technicianFirstNametxtField);

		//'Middle Name' txtField
		technicianMiddleNametxtField = new JTextField();
		designTextfield(technicianFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 137, 153, 46, 10);
		newTechnicianPanel.add(technicianMiddleNametxtField);

		//'Last Name' txtField
		technicianLastNametxtField = new JTextField();
		designTextfield(technicianFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 280, 198, 153, 46, 10);
		newTechnicianPanel.add(technicianLastNametxtField);

		//'Email' txtField
		technicianEmailtxtField = new JTextField();
		designTextfield(technicianFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 157, 273, 187, 46, 10);
		newTechnicianPanel.add(technicianEmailtxtField);

		//'Tel Num' txtField
		technicianTelNumtxtField = new JTextField();
		designTextfield(technicianFirstNametxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 17),
				Color.WHITE, 403, 273, 200, 46, 10);
		newTechnicianPanel.add(technicianTelNumtxtField);

		//NewTechnician Background
		newTechnicianBackground = new ImageIcon(this.getClass().getResource("/office_backgrond.png")).getImage();
		newTechnicianBackgroundLabel = new JLabel("");
		newTechnicianBackgroundLabel.setBounds(0, 0, 614, 344);
		newTechnicianBackgroundLabel.setIcon(new ImageIcon(newTechnicianBackground));
		newTechnicianPanel.add(newTechnicianBackgroundLabel);

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

}
