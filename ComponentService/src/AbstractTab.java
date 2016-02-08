import java.awt.Color;
import java.awt.Font;

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
}
