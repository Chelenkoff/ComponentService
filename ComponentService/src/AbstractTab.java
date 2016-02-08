import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstractTab {

	//UI initialization 
	abstract void initializeUI(final JPanel parent, final MySQLConnect databaseConnection);

	//Adding components to panel
	abstract void addComponentsToPanel();

	//Adding 'Back' button functionality
	abstract void addBackButtonAction(final JPanel parentPanel);

	//Label design 
	void designLabel(JLabel label, Color foregroundColor, Font font, int x , int y, int width, int height){
		label.setForeground(foregroundColor);
		label.setFont(font);
		label.setBounds(x, y, width, height);
	}

	//Textfield design 
	void designTextfield(JTextField txtField, Color backgroundColor, int horizontalAlign, Font font, Color foregroundColor,
			int x, int y, int width, int height, int numOfCols){
		txtField.setBackground(backgroundColor);
		txtField.setHorizontalAlignment(horizontalAlign);
		txtField.setFont(font);
		txtField.setForeground(foregroundColor);
		txtField.setBounds(x, y, width, height);
		txtField.setColumns(numOfCols);
	}
	
	//Standart button design 
	void designStandartButton(JButton button, Font font, Color backgroundColor, Color foregroundColor, int x, int y, int width, int height){
		button.setFont(font);
		button.setBackground(backgroundColor);
		button.setForeground(foregroundColor);
		button.setBounds(x, y, width, height);
	}
	
	//Rollover button design
	void designRolloverButton(JButton rolloverButton, URL defaultImgUrl, URL rolloverImgUrl, int x, int y, int width, int height){
		rolloverButton.setContentAreaFilled(false);
		rolloverButton.setBorderPainted(false);
		rolloverButton.setRolloverEnabled(true);
		rolloverButton.setBounds(x, y, width, height);
		rolloverButton.setIcon(new ImageIcon(defaultImgUrl));
		rolloverButton.setRolloverIcon(new ImageIcon(rolloverImgUrl));
	}
	
	//Panel design
	void designPanel(JPanel panel, int x, int y, int width, int height){
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		panel.setVisible(true);
	}
	
	//Panel background settings
	void designPanelBackground(JLabel panelBackgroundLabel,URL backgroundImgURL, int x, int y, int width, int height){
		ImageIcon newTechnicianBackground = new ImageIcon(backgroundImgURL);
		panelBackgroundLabel.setBounds(x, y, width, height);
		panelBackgroundLabel.setIcon(newTechnicianBackground);
	}
}
