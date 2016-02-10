import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

	private JTextField diagnosticResultsTxtField;

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

	}

	private void addShowButtonAction(JPanel parent, MySQLConnect databaseConnection) {
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
