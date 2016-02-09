import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewOrderTab extends AbstractTab{

	private JPanel newOrderPanel;

	private JButton newOrderBackBtn;
	private JButton submitNewOrderBtn;
	private JButton clearOrderBtn;
	private JButton pickDateBtn;

	private JLabel newOrderLabel;
	private JLabel componentTypeLabel;
	private JLabel componentModelLabel;
	private JLabel chooseClientLabel;
	private JLabel chooseTechnicianLabel;
	private JLabel entryDateLabel;
	private JLabel requiredLabel;

	private ObservingTextField entryDatetxtField;

	private JTextField componentTypeTxtField;
	private JTextField componentModelTxtField;

	private JComboBox<String> clientsComboBox;
	private JComboBox<String> techniciansComboBox;

	//Constructor
	public NewOrderTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one
		initializeUI(parent, databaseConnection);		

	}

	//UI initialization 
	@Override
	void initializeUI(JPanel parent, MySQLConnect databaseConnection) {
		//Creating 'Add New Client' panel
		newOrderPanel = new JPanel();
		designPanel(newOrderPanel,0, 0, 614, 344);

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
				SystemColor.textHighlight, Color.WHITE, 394, 301, 73, 23);
		addPickButtonAction();

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

	}

	private void addPickButtonAction() {
		// TODO Auto-generated method stub

	}

	private void addClearButtonAction() {
		// TODO Auto-generated method stub

	}

	private void addSubmitButtonAction(JPanel parent, MySQLConnect databaseConnection) {
		// TODO Auto-generated method stub

	}

	@Override
	void addComponentsToPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	void addBackButtonAction(JPanel parentPanel) {
		// TODO Auto-generated method stub

	}

}
