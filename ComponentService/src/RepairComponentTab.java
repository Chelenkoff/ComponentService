import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class RepairComponentTab  extends AbstractTab{

	private JPanel repairComponentPanel;

	private JButton backBtn;
	private JButton submitBtn;
	private JButton showBtn;
	private JButton pickReadyDateBtn;

	//Informative labels
	private JLabel backgroundLabel;
	private JLabel mainInfoLabel;
	private JLabel youAreInfoLabel;
	private JLabel componentToRepairInfoLabel;
	private JLabel diagnosticResultsInfoLabel;
	private JLabel statusInfoLabel;
	private JLabel orderPriceInfoLabel;
	private JLabel readyDateInfoLabel;

	//Action labels
	private JLabel orderPriceActLabel;

	private JTextArea diagnosticResultsTxtArea;

	ResultSetTable availablePartsResSetTable;

	private ObservingTextField readyDateActObsTxtField;

	private JComboBox<String> technicianComboBox;
	private JComboBox<String> componentComboBox;
	private JComboBox<String> statusComboBox;

	private JScrollPane diagnosticResultsScrollPane;

	//Constructor
	public RepairComponentTab(final JPanel parent, final MySQLConnect databaseConnection){

		parent.setVisible(false); //Hiding existing panel before initialization of the new one
		initializeUI(parent, databaseConnection);	
	}

	//UI initialization 
	@Override
	void initializeUI(JPanel parent, MySQLConnect databaseConnection) {
		//Creating 'Reprair Component' panel
		repairComponentPanel = new JPanel();
		designPanel(repairComponentPanel,0, 0, 614, 344);

		//Buttons
		//'>' Show button
		showBtn = new JButton(">");
		designStandartButton(showBtn, new Font("Tahoma", Font.PLAIN, 10),
				SystemColor.textHighlight, Color.WHITE, 287, 231, 41, 26);
		addShowButtonAction(parent, databaseConnection);

		//'Submit' button
		submitBtn = new JButton("Submit");
		designStandartButton(submitBtn, new Font("Tahoma", Font.PLAIN, 17),
				SystemColor.textHighlight, Color.WHITE, 460, 268, 144, 42);
		submitBtn.setEnabled(false);
		addShowButtonAction(parent, databaseConnection);

		//'...' Pick ready date button
		pickReadyDateBtn = new JButton(". . .");
		designStandartButton(pickReadyDateBtn, new Font("Tahoma", Font.PLAIN, 17),
				SystemColor.textHighlight, Color.WHITE, 584, 315, 20, 23);
		addPickDateButtonAction(parent, databaseConnection);

		//'Back' Button
		//BackButton design settings
		backBtn = new JButton("");
		designRolloverButton(backBtn, this.getClass().getResource("/back_blackwhite.png"),
				this.getClass().getResource("/back_colored.png"), 0, 294, 50, 50);
		addBackButtonAction(parent);

		//Labels
		//Informative labels
		//'Repair component' main label
		mainInfoLabel = new JLabel("Repair Component");
		designLabel(mainInfoLabel, SystemColor.textHighlight,new Font("Tahoma", Font.BOLD, 30), 10, 0, 335, 50);

		//'You are' info label
		youAreInfoLabel = new JLabel("You are");
		designLabel(youAreInfoLabel, Color.RED,new Font("Tahoma", Font.BOLD, 15), 10, 206, 63, 31);

		//'Component to repair' info label
		componentToRepairInfoLabel = new JLabel("Component to repair");
		designLabel(componentToRepairInfoLabel, Color.RED,new Font("Tahoma", Font.BOLD, 15), 341, 206, 164, 31);

		//'Diagnostic results' info label
		diagnosticResultsInfoLabel = new JLabel("Diagnostic results:");
		designLabel(diagnosticResultsInfoLabel,SystemColor.textHighlight,new Font("Tahoma", Font.PLAIN, 15), 60, 277, 121, 25);

		//'Status' info label
		statusInfoLabel = new JLabel("Status:");
		designLabel(statusInfoLabel,SystemColor.textHighlight,new Font("Tahoma", Font.PLAIN, 15), 45, 315, 50, 25);

		//'Order Price' info label
		orderPriceInfoLabel = new JLabel("Order Price:");
		designLabel(orderPriceInfoLabel,SystemColor.textHighlight,new Font("Tahoma", Font.PLAIN, 15), 216, 315, 86, 25);

		//'Ready date' info label
		readyDateInfoLabel = new JLabel("Ready date:");
		designLabel(readyDateInfoLabel,SystemColor.textHighlight,new Font("Tahoma", Font.PLAIN, 15), 386, 315, 86, 25);

		//Action labels
		//'Order price' Action label
		orderPriceActLabel = new JLabel("");
		designLabel(orderPriceActLabel, Color.RED,new Font("Tahoma", Font.PLAIN, 13), 300, 316, 95, 23);

		//Text area
		//'Diagnostic results' txtArea
		diagnosticResultsTxtArea = new JTextArea();
		designDiagnosticTxtArea(diagnosticResultsTxtArea);
		
		//ScrollPane (scrolling functionality of diagnostic txtArea
		diagnosticResultsScrollPane = new JScrollPane();
		diagnosticResultsScrollPane.setBounds(187, 268, 263, 42);
		diagnosticResultsScrollPane.setViewportView(diagnosticResultsTxtArea);

		//Combo Boxes
		//Technician combo box
		technicianComboBox = new JComboBox<String>();
		technicianComboBox.setForeground(Color.WHITE);
		technicianComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		technicianComboBox.setBackground(SystemColor.textHighlight);
		technicianComboBox.setBounds(10, 231, 263, 25);

		//Components combo box
		componentComboBox = new JComboBox<String>();
		componentComboBox.setForeground(Color.WHITE);
		componentComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		componentComboBox.setBackground(SystemColor.textHighlight);
		componentComboBox.setBounds(341, 231, 263, 25);
		addTasksComboBoxListener(databaseConnection);
		
		//Status combo box
		statusComboBox = new JComboBox<String>();
		statusComboBox.setForeground(Color.WHITE);
		statusComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statusComboBox.setBackground(SystemColor.textHighlight);
		statusComboBox.setBounds(95, 314, 111, 25);
		addTasksComboBoxListener(databaseConnection);
		
		//Observing Text Fields
		//'Ready date' observing txtField
		readyDateActObsTxtField = new ObservingTextField();
		designTextfield(readyDateActObsTxtField, SystemColor.textHighlight,
				SwingConstants.CENTER, new Font("Tahoma", Font.PLAIN, 14),
				Color.WHITE, 474, 314, 104, 27, 10);
		readyDateActObsTxtField.setEditable(false);
		setDefaultDate();
		
		//Comboboxes initialization
		initializeComboBoxes(parent,databaseConnection);

		//Repair Component panel Background
		backgroundLabel = new JLabel("");
		designPanelBackground(backgroundLabel,this.getClass().getResource("/service_background.png"),
				0,0,614,344);

		//Adding components to 'Repair Component' panel
		addComponentsToPanel();
	}
	
	

	//Getter
	public JPanel getRepairComponentPanel(){
		return repairComponentPanel;
	}
	
	//Adding components to panel
	@Override
	void addComponentsToPanel() {
		repairComponentPanel.add(showBtn);
		repairComponentPanel.add(backBtn);
		repairComponentPanel.add(submitBtn);
		repairComponentPanel.add(pickReadyDateBtn);
		
		repairComponentPanel.add(mainInfoLabel);
		repairComponentPanel.add(youAreInfoLabel);
		repairComponentPanel.add(componentToRepairInfoLabel);
		repairComponentPanel.add(diagnosticResultsInfoLabel);
		repairComponentPanel.add(statusInfoLabel);
		repairComponentPanel.add(orderPriceInfoLabel);
		repairComponentPanel.add(readyDateInfoLabel);
		
		repairComponentPanel.add(orderPriceActLabel);
		
		repairComponentPanel.add(diagnosticResultsScrollPane);
							
		repairComponentPanel.add(technicianComboBox);
		repairComponentPanel.add(componentComboBox);
		repairComponentPanel.add(statusComboBox);
		
		repairComponentPanel.add(readyDateActObsTxtField);
		
		repairComponentPanel.add(backgroundLabel);

	}


	//Default ComboBox initialization
	private void initializeComboBoxes(JPanel parent, MySQLConnect databaseConnection) {
		
		technicianComboBox.removeAllItems();
		componentComboBox.removeAllItems();
		statusComboBox.removeAllItems();
		
		try {
			ComponentServiceMain.getDatabaseConnection().allTechnicians();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		for(String str : ComponentServiceMain.getDatabaseConnection().techniciansInfo()){
			technicianComboBox.addItem(str);

		}
		
	}

	//Tasks Combobox 'itemStateChanged' functionality
	private void addTasksComboBoxListener(MySQLConnect databaseConnection) {
		componentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {
					submitBtn.setEnabled(true);
					try {

						ComponentServiceMain.getDatabaseConnection().componentPartsInfo(componentComboBox.getSelectedItem().toString());

						if(ComponentServiceMain.getDatabaseConnection().componentReadyDate() == null){
							readyDateActObsTxtField.setText("Not yet ready");


						}
						else{
							SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
							String date_to_string = dateformatyyyyMMdd.format(ComponentServiceMain.getDatabaseConnection().componentReadyDate());
							readyDateActObsTxtField.setText(date_to_string);
						}

						statusComboBox.setSelectedItem(ComponentServiceMain.getDatabaseConnection().componentStatus());

						if(ComponentServiceMain.getDatabaseConnection().componentOrderPrice() == 0.0){
							orderPriceActLabel.setText("Not yet ready");
						}
						else{
							orderPriceActLabel.setText(Float.toString(ComponentServiceMain.getDatabaseConnection().componentOrderPrice()) + " levs");
						}


						if(ComponentServiceMain.getDatabaseConnection().componentDiagnosticResults() == null){
							diagnosticResultsTxtArea.setText("Not yet repaired");
						}
						else{

							diagnosticResultsTxtArea.setText(ComponentServiceMain.getDatabaseConnection().componentDiagnosticResults());
						}


					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}	

			}
		});
		
	}
	
	// ". . ." Pick date Button functionality
	private void addPickDateButtonAction(JPanel parent, MySQLConnect databaseConnection) {
		pickReadyDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatePicker dp = new DatePicker(readyDateActObsTxtField);
				Date selectedDate = dp.parseDate(readyDateActObsTxtField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(readyDateActObsTxtField);
			}
		});
		
	}

	// ">" Button functionality
	private void addShowButtonAction(JPanel parent, MySQLConnect databaseConnection) {
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				componentComboBox.removeAllItems();
				submitBtn.setEnabled(false);
				if(technicianComboBox.getSelectedItem() != null){
					String record = technicianComboBox.getSelectedItem().toString();

					try {

						ComponentServiceMain.getDatabaseConnection().showTasks(record);


						for(String str : ComponentServiceMain.getDatabaseConnection().componentsInfo()){
							componentComboBox.addItem(str);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				if(componentComboBox.getItemCount() == 0){
					diagnosticResultsTxtArea.setText("");
					statusComboBox.setSelectedItem(null);
					orderPriceActLabel.setText("");
					readyDateActObsTxtField.setText("");
				}
				else{
					statusComboBox.removeAllItems();
					statusComboBox.addItem("Not yet started");
					statusComboBox.addItem("Being repaired...");
					statusComboBox.addItem("Ready");
				}

				//
				try {

					ResultSetTable techsTable  = new ResultSetTable(ComponentServiceMain.getDatabaseConnection().partsInfo());
					techsTable.setBounds(50,100, 340,110);
					techsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					resizeColumnWidth(techsTable);

					repairComponentPanel.add(techsTable);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//

			}

			private void resizeColumnWidth(ResultSetTable techsTable) {
				final TableColumnModel columnModel = techsTable.getColumnModel();
				for (int column = 0; column < techsTable.getColumnCount(); column++) {
					int width = 1; // Min width
					for (int row = 0; row < techsTable.getRowCount(); row++) {
						TableCellRenderer renderer = techsTable.getCellRenderer(row, column);
						Component comp = techsTable.prepareRenderer(renderer, row, column);
						width = Math.max(comp.getPreferredSize().width, width);
					}
					columnModel.getColumn(column).setPreferredWidth(width);
				}
				
			}

		});

	}

	//Back Button functionality
	@Override
	void addBackButtonAction(final JPanel parentPanel) {
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repairComponentPanel.setVisible(false);
				parentPanel.setVisible(true);
			}
		});

	}
	
	//Setting default date at readyDateObsTxtField
	void setDefaultDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //2014-08-06
		Date date = new Date();
		readyDateActObsTxtField.setText(dateFormat.format(date));
	}

	//Designing 'Diagnostic Results' txt area
	private void designDiagnosticTxtArea(JTextArea area){
		area.setForeground(Color.WHITE);
		area.setBackground(SystemColor.textHighlight);
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setEditable(false);
		area.setLineWrap(true);
		area.setBounds(425, 139, 179, 125);
	}

}
