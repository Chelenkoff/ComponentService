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
	
	private JLabel newTechnicianBackgroundLabel;
	

	private Image backRolloverBtn;
	private Image officeBackground;
	
	private JButton newTechnicianBackBtn;
	private JButton clearTechnicianBtn;
	
	private JTextField technicianFirstNametxtField;
	private JTextField technicianMiddleNametxtField;
	private JTextField technicianLastNametxtField;
	private JTextField technicianEmailtxtField;
	private JTextField technicianTelNumtxtField;

	private JLabel emailLabel;
	private JLabel telNumLabel;
	private JLabel officeBackgroundLabel;
	
	private Image backBtn;
	//Constructor
	public NewTechnicianTab(final JPanel parent, final MySQLConnect databaseConnection){
		parent.setVisible(false);
		backBtn = new ImageIcon(this.getClass().getResource("/back_blackwhite.png")).getImage();
		backRolloverBtn = new ImageIcon(this.getClass().getResource("/back_colored.png")).getImage();
		
		officeBackground = new ImageIcon(this.getClass().getResource("/office_backgrond.png")).getImage();
		//Office Background
				officeBackgroundLabel = new JLabel("");
				officeBackgroundLabel.setBounds(0, 0, 614, 344);
				officeBackgroundLabel.setIcon(new ImageIcon(officeBackground));
				
		//Creating 'New Technician' panel
		newTechnicianPanel = new JPanel();
		newTechnicianPanel.setBounds(0, 0, 614, 344);
//		frame.getContentPane().add(newTechnicianPanel);
		newTechnicianPanel.setLayout(null);
		newTechnicianPanel.setVisible(true);
		
		
		newTechnicianBackBtn = new JButton("");
		newTechnicianBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				newTechnicianPanel.setVisible(false);
//				officePanel.setVisible(true);
				
				
			}
		});
		
		
		newTechnicianBackBtn.setBounds(0, 294, 50, 50);
		newTechnicianBackBtn.setContentAreaFilled(false);
		newTechnicianBackBtn.setBorderPainted(false);
		newTechnicianBackBtn.setRolloverEnabled(true);
		newTechnicianBackBtn.setIcon(new ImageIcon(backBtn));
		newTechnicianBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
		newTechnicianPanel.add(newTechnicianBackBtn);
		
				
				//Add Technician Components
				JLabel hireTechLabel = new JLabel("Hire a technician");
				hireTechLabel.setForeground(SystemColor.textHighlight);
				hireTechLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
				hireTechLabel.setBounds(10, 11, 300, 50);
				newTechnicianPanel.add(hireTechLabel);
				
				JButton submitNewTechnicianBtn = new JButton("Submit");
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
				submitNewTechnicianBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
				submitNewTechnicianBtn.setForeground(Color.WHITE);
				submitNewTechnicianBtn.setBackground(SystemColor.textHighlight);
				submitNewTechnicianBtn.setBounds(484, 123, 91, 75);
				newTechnicianPanel.add(submitNewTechnicianBtn);
				
				JLabel firstNamelabel = new JLabel("First name:");
				firstNamelabel.setForeground(Color.RED);
				firstNamelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				firstNamelabel.setBounds(130, 72, 140, 50);
				newTechnicianPanel.add(firstNamelabel);
				
				JLabel middleNameLabel = new JLabel("Middle name:");
				middleNameLabel.setForeground(SystemColor.textHighlight);
				middleNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				middleNameLabel.setBounds(133, 133, 137, 50);
				newTechnicianPanel.add(middleNameLabel);
				
				JLabel lastNameLabel = new JLabel("Last name:");
				lastNameLabel.setForeground(Color.RED);
				lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lastNameLabel.setBounds(130, 194, 137, 50);
				newTechnicianPanel.add(lastNameLabel);
				
				technicianFirstNametxtField = new JTextField();
				technicianFirstNametxtField.setBackground(SystemColor.textHighlight);
				technicianFirstNametxtField.setHorizontalAlignment(SwingConstants.CENTER);
				technicianFirstNametxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				technicianFirstNametxtField.setForeground(Color.WHITE);
				technicianFirstNametxtField.setBounds(280, 76, 153, 46);
				newTechnicianPanel.add(technicianFirstNametxtField);
				technicianFirstNametxtField.setColumns(10);
				
				technicianMiddleNametxtField = new JTextField();
				technicianMiddleNametxtField.setHorizontalAlignment(SwingConstants.CENTER);
				technicianMiddleNametxtField.setForeground(Color.WHITE);
				technicianMiddleNametxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				technicianMiddleNametxtField.setColumns(10);
				technicianMiddleNametxtField.setBackground(SystemColor.textHighlight);
				technicianMiddleNametxtField.setBounds(280, 137, 153, 46);
				newTechnicianPanel.add(technicianMiddleNametxtField);
				
				technicianLastNametxtField = new JTextField();
				technicianLastNametxtField.setHorizontalAlignment(SwingConstants.CENTER);
				technicianLastNametxtField.setForeground(Color.WHITE);
				technicianLastNametxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				technicianLastNametxtField.setColumns(10);
				technicianLastNametxtField.setBackground(SystemColor.textHighlight);
				technicianLastNametxtField.setBounds(280, 198, 153, 46);
				newTechnicianPanel.add(technicianLastNametxtField);
				
				emailLabel = new JLabel("Email:");
				emailLabel.setForeground(SystemColor.textHighlight);
				emailLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				emailLabel.setBounds(84, 269, 68, 50);
				newTechnicianPanel.add(emailLabel);
				
				technicianEmailtxtField = new JTextField();
				technicianEmailtxtField.setHorizontalAlignment(SwingConstants.CENTER);
				technicianEmailtxtField.setForeground(Color.WHITE);
				technicianEmailtxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				technicianEmailtxtField.setColumns(10);
				technicianEmailtxtField.setBackground(SystemColor.textHighlight);
				technicianEmailtxtField.setBounds(157, 273, 187, 46);
				newTechnicianPanel.add(technicianEmailtxtField);
				
				telNumLabel = new JLabel("Tel:");
				telNumLabel.setForeground(Color.RED);
				telNumLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				telNumLabel.setBounds(354, 269, 68, 50);
				newTechnicianPanel.add(telNumLabel);
				
				technicianTelNumtxtField = new JTextField();
				technicianTelNumtxtField.setHorizontalAlignment(SwingConstants.CENTER);
				technicianTelNumtxtField.setForeground(Color.WHITE);
				technicianTelNumtxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
				technicianTelNumtxtField.setColumns(10);
				technicianTelNumtxtField.setBackground(SystemColor.textHighlight);
				technicianTelNumtxtField.setBounds(403, 273, 200, 46);
				newTechnicianPanel.add(technicianTelNumtxtField);
				
				JLabel requiredTechLbl = new JLabel("(*)required");
				requiredTechLbl.setForeground(Color.RED);
				requiredTechLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
				requiredTechLbl.setBounds(522, 318, 81, 26);
				newTechnicianPanel.add(requiredTechLbl);
					
					//Clear Technician Button
				clearTechnicianBtn = new JButton("Clear");
				clearTechnicianBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						technicianFirstNametxtField.setText("");
						technicianMiddleNametxtField.setText("");
						technicianLastNametxtField.setText("");
						technicianEmailtxtField.setText("");
						technicianTelNumtxtField.setText("");
					}
				});
				clearTechnicianBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				clearTechnicianBtn.setBackground(Color.RED);
				clearTechnicianBtn.setForeground(Color.WHITE);
				clearTechnicianBtn.setBounds(484, 89, 91, 23);
				newTechnicianPanel.add(clearTechnicianBtn);
					//NewTechnician Background
				newTechnicianBackgroundLabel = new JLabel("");
				newTechnicianBackgroundLabel.setBounds(0, 0, 614, 344);
				newTechnicianPanel.add(newTechnicianBackgroundLabel);
				newTechnicianBackgroundLabel.setIcon(new ImageIcon(officeBackground));
		
	}
	
	//Getters
	JPanel getNewTechnicianPanel(){
		return newTechnicianPanel;
	}
	
}
