import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class ComponentService {

	private JFrame frame;
	
	private  JPanel officePanel;
	private  JPanel servicePanel;
	private  JPanel menuPanel;
	private JPanel newOrderPanel;
	private JPanel checkOrderStatusPanel;
	private JPanel myTasksPanel;
	private JPanel repairComponentPanel;
	private JPanel repairDetailsPanel;
	
	private JComboBox<String> clientComboBox;
	private JComboBox<String> techniciansComboBox;
	
	private JComboBox<String> myTasksTechsComboBox;
	private JComboBox<String> myTasksChooseComboBox;
	
	private JComboBox<String> repairCompTechComboBox;
	private JComboBox<String> repairCompToRepairComboBox;
	private JComboBox<String> repairCompStatusComboBox;
	
	private JLabel separatorImageLabel;
	private JLabel logoLabel;
	private JLabel backgroundLabel;
	private JLabel officeBackgroundLabel;
	private JLabel serviceBackgroundLabel;
	private JLabel myTasksBackgroundLabel;
	private JLabel repairComponentBackgroundLabel;
	private JLabel repairDetailsBackgroundLabel;
	private JLabel newOrderBackgroundLabel;
	private JLabel checkStatusBackgroundLabel;
	private JLabel databaseConnectedLabel;
	private JLabel MyTasksOrderIdLbl;
	
	private Image separatorImageIcon;
	private Image backgroundIcon;
	private Image officeIcon;
	private Image appIcon;
	private Image officeRollover;
	private Image serviceIcon;
	private Image serviceRollover;
	private Image logoImageIcon;
	private Image homeBtnIcon;
	private Image homeBtnRollover;
	private Image newOrderBtnIcon;
	private Image newOrderBtnRollover;
	private Image checkStatusBtnIcon;
	private Image checkStatusBtnRollover;
	private Image newClientBtnIcon;
	private Image newClientBtnRollover;
	private Image newTechnicianBtnIcon;
	private Image newTechnicianBtnRollover;
	private Image myTasksBtnIcon;
	private Image myTasksBtnRollover;
	private Image repairComponentBtnIcon;
	private Image repairComponentBtnRollover;
	private Image repairDetailsBtnIcon;
	private Image repairDetailsBtnRollover;
	private Image backBtn;
	private Image backRolloverBtn;
	private Image serviceBackground;
	private Image officeBackground;
	
	private ObservingTextField repairCompReadyTxtField;
	private JButton officeBtn;
	private JButton serviceButton;
	private JButton homeBtn;
	private JButton homeBtnService;
	private JButton newOrderBtn;
	private JButton checkStatusBtn;
	private JButton newClientBtn;
	private JButton newTechnicianBtn;
	private JButton myTasksBtn;
	private JButton repairComponentBtn;
	private JButton repairDetailsBtn;
	private JButton newOrderBackBtn;
	private JButton checkStatusBackBtn;
	private JButton myTasksBackBtn;
	private JButton repairComponentBackBtn;
	private JButton repairDetailsBackBtn;
	private JButton repairCompSubmitBtn;
	
	private JTextArea myTasksDiagnosticTxtField;
	private JTextArea repairCompDiagnosticTextArea;
	
	private static MySQLConnect databaseConnection;
	private static ComponentService window;
	private JLabel newOrderlbl;
	private JLabel componentTypelbl;
	private JTextField componentTypeTxtField;
	private JTextField componentModelTxtField;
	private ObservingTextField newOrderEntryDatetxtField;
	private JButton newOrderSubmitBtn;
	private JButton newOrderClearBtn;
	private JLabel label;
	private JLabel myTasksLogoLbl;
	private JLabel myTasksTechLbl;
	private JLabel repairCompPriceLbl;

	private JLabel componentModelLbl;
	private JLabel myTasksComponentModelLbl;
	private JLabel lblEntryDate;
	private JLabel MyTasksEntryDateLbl;
	private JLabel readyDateLbl;
	private JLabel myTasksReadyDateLbl;
	private JLabel clientLbl;
	private JLabel myTasksClientLbl;
	private JLabel MyTasksStatusLbl;
	private JLabel statusLbl;
	private JLabel priceLbl;
	private JLabel myTasksPriceLbl;
	private JLabel clientTelLbl;
	private JLabel myTasksClientTelLbl;
	private JLabel diagnosticResultsLbl;
	private JLabel MyTasksComponentTypeLbl;
	private JLabel repairComponentLbl;
	private JLabel technicianLbl;
	private JButton repairCompShowBtn;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ComponentService();
					databaseConnection = new MySQLConnect();
					databaseConnection.connectToDatabase();
					window.frame.setVisible(true);
					window.checkDatabaseConnectivity(databaseConnection.hasConnected());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComponentService() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Design
		
			//Main Menu
		frame = new JFrame("Chelenkoff Service");
		frame.setBounds(100, 100, 620, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		appIcon = new ImageIcon(this.getClass().getResource("/app_icon.png")).getImage();
		frame.setIconImage(appIcon);

		
		repairComponentPanel = new JPanel();
		repairComponentPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(repairComponentPanel);
		repairComponentPanel.setLayout(null);
		repairComponentPanel.setVisible(false);
		
		myTasksPanel = new JPanel();
		myTasksPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(myTasksPanel);
		myTasksPanel.setLayout(null);
		myTasksPanel.setVisible(false);
		
		newOrderPanel = new JPanel();
		newOrderPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(newOrderPanel);
		newOrderPanel.setLayout(null);
		newOrderPanel.setVisible(false);
				
		
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);
		menuPanel.setVisible(true);
		
		
		servicePanel = new JPanel();
		servicePanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(servicePanel);
		servicePanel.setLayout(null);
		servicePanel.setVisible(false);
		
		officePanel = new JPanel();
		officePanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(officePanel);
		officePanel.setLayout(null);
		officePanel.setVisible(false);
		

		
		checkOrderStatusPanel = new JPanel();
		checkOrderStatusPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(checkOrderStatusPanel);
		checkOrderStatusPanel.setLayout(null);
		checkOrderStatusPanel.setVisible(false);
		


		
		repairDetailsPanel = new JPanel();
		repairDetailsPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(repairDetailsPanel);
		repairDetailsPanel.setLayout(null);
		repairDetailsPanel.setVisible(false);
		
		//Components
			//Middle separator
		separatorImageLabel = new JLabel("");
		separatorImageLabel.setBounds(265, 64, 90, 250);
		separatorImageIcon = new ImageIcon(this.getClass().getResource("/separator.png")).getImage();
		separatorImageLabel.setIcon(new ImageIcon(separatorImageIcon));
		menuPanel.add(separatorImageLabel);

			//Office button
		officeBtn = new JButton("");
		officeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuPanel.setVisible(false);
				officePanel.setVisible(true);
			}
		});
		officeBtn.setBounds(20, 65, 240, 240);
		officeIcon = new ImageIcon(this.getClass().getResource("/office_blackwhite.png")).getImage();
		officeRollover = new ImageIcon(this.getClass().getResource("/office_colored.png")).getImage();
		officeBtn.setContentAreaFilled(false);
		officeBtn.setBorderPainted(false);
		officeBtn.setRolloverEnabled(true);
		officeBtn.setIcon(new ImageIcon(officeIcon));
		officeBtn.setRolloverIcon(new ImageIcon(officeRollover));
		menuPanel.add(officeBtn);
		
			//Office HOME Button
		homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				officePanel.setVisible(false);
				
			}
		});
		homeBtn.setBounds(0, 294, 50, 50);
		homeBtnIcon = new ImageIcon(this.getClass().getResource("/home_blackwhite.png")).getImage();
		homeBtnRollover = new ImageIcon(this.getClass().getResource("/home_colored.png")).getImage();
		homeBtn.setContentAreaFilled(false);
		homeBtn.setBorderPainted(false);
		homeBtn.setRolloverEnabled(true);
		homeBtn.setIcon(new ImageIcon(homeBtnIcon));
		homeBtn.setRolloverIcon(new ImageIcon(homeBtnRollover));
		officePanel.add(homeBtn);
			//Service HOME Button
		homeBtnService = new JButton("");
		homeBtnService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				servicePanel.setVisible(false);
				
			}
		});
		homeBtnService.setBounds(0, 294, 50, 50);
		homeBtnIcon = new ImageIcon(this.getClass().getResource("/home_blackwhite.png")).getImage();
		homeBtnRollover = new ImageIcon(this.getClass().getResource("/home_colored.png")).getImage();
		homeBtnService.setContentAreaFilled(false);
		homeBtnService.setBorderPainted(false);
		homeBtnService.setRolloverEnabled(true);
		homeBtnService.setIcon(new ImageIcon(homeBtnIcon));
		homeBtnService.setRolloverIcon(new ImageIcon(homeBtnRollover));
		servicePanel.add(homeBtnService);
		
		//Back BTN
		backBtn = new ImageIcon(this.getClass().getResource("/back_blackwhite.png")).getImage();
		backRolloverBtn = new ImageIcon(this.getClass().getResource("/back_colored.png")).getImage();
		
		//NewOrder Back Button
	newOrderBackBtn = new JButton("");
	newOrderBackBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			newOrderPanel.setVisible(false);
			officePanel.setVisible(true);
			
			
		}
	});
	newOrderBackBtn.setBounds(0, 294, 50, 50);
	newOrderBackBtn.setContentAreaFilled(false);
	newOrderBackBtn.setBorderPainted(false);
	newOrderBackBtn.setRolloverEnabled(true);
	newOrderBackBtn.setIcon(new ImageIcon(backBtn));
	newOrderBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
	newOrderPanel.add(newOrderBackBtn);
	
		//CheckStatus Back Button
	checkStatusBackBtn = new JButton("");
	checkStatusBackBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkOrderStatusPanel.setVisible(false);
			officePanel.setVisible(true);
			
			
		}
	});
	checkStatusBackBtn.setBounds(0, 294, 50, 50);
	checkStatusBackBtn.setContentAreaFilled(false);
	checkStatusBackBtn.setBorderPainted(false);
	checkStatusBackBtn.setRolloverEnabled(true);
	checkStatusBackBtn.setIcon(new ImageIcon(backBtn));
	checkStatusBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
	checkOrderStatusPanel.add(checkStatusBackBtn);
	
			
		//My Tasks Back Button
	myTasksBackBtn = new JButton("");
	myTasksBackBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myTasksPanel.setVisible(false);
			servicePanel.setVisible(true);
			
			
		}
	});
	myTasksBackBtn.setBounds(0, 294, 50, 50);
	myTasksBackBtn.setContentAreaFilled(false);
	myTasksBackBtn.setBorderPainted(false);
	myTasksBackBtn.setRolloverEnabled(true);
	myTasksBackBtn.setIcon(new ImageIcon(backBtn));
	myTasksBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
	myTasksPanel.add(myTasksBackBtn);
	
	
	
		//Repair Component Back Button
	repairComponentBackBtn = new JButton("");
	repairComponentBackBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			repairComponentPanel.setVisible(false);
			servicePanel.setVisible(true);
			
		}
	});
	repairComponentBackBtn.setBounds(0, 294, 50, 50);
	repairComponentBackBtn.setContentAreaFilled(false);
	repairComponentBackBtn.setBorderPainted(false);
	repairComponentBackBtn.setRolloverEnabled(true);
	repairComponentBackBtn.setIcon(new ImageIcon(backBtn));
	repairComponentBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
	repairComponentPanel.add(repairComponentBackBtn);
	
	
	
	
		//Repair Details Back Button
	repairDetailsBackBtn = new JButton("");
	repairDetailsBackBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			repairDetailsPanel.setVisible(false);
			servicePanel.setVisible(true);
		}
	});
	repairDetailsBackBtn.setBounds(0, 294, 50, 50);
	repairDetailsBackBtn.setContentAreaFilled(false);
	repairDetailsBackBtn.setBorderPainted(false);
	repairDetailsBackBtn.setRolloverEnabled(true);
	repairDetailsBackBtn.setIcon(new ImageIcon(backBtn));
	repairDetailsBackBtn.setRolloverIcon(new ImageIcon(backRolloverBtn));
	repairDetailsPanel.add(repairDetailsBackBtn);
	
		serviceButton = new JButton("");
		serviceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				servicePanel.setVisible(true);
			}
		});
		serviceButton.setBounds(360, 64, 240, 240);
		serviceIcon = new ImageIcon(this.getClass().getResource("/service_blackwhite.png")).getImage();
		serviceRollover = new ImageIcon(this.getClass().getResource("/service_colored.png")).getImage();
		serviceButton.setContentAreaFilled(false);
		serviceButton.setBorderPainted(false);
		serviceButton.setRolloverEnabled(true);
		serviceButton.setIcon(new ImageIcon(serviceIcon));
		serviceButton.setRolloverIcon(new ImageIcon(serviceRollover));
		menuPanel.add(serviceButton);
		
			//Service LOGO
		logoLabel = new JLabel("");
		logoLabel.setBounds(207, 11, 201, 52);
		logoImageIcon = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logoImageIcon));
		menuPanel.add(logoLabel);
		
			//App Background
		backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 614, 344);
		backgroundIcon = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		
		databaseConnectedLabel = new JLabel("Not connected to database");
		databaseConnectedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		databaseConnectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		databaseConnectedLabel.setForeground(Color.RED);
		databaseConnectedLabel.setBounds(223, 316, 173, 27);
		menuPanel.add(databaseConnectedLabel);
		backgroundLabel.setIcon(new ImageIcon(backgroundIcon));
		menuPanel.add(backgroundLabel);

		
		//New Order BTN
		newOrderBtn = new JButton("");
		newOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newOrderPanel.setVisible(true);
				officePanel.setVisible(false);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //2014-08-06
				Date date = new Date();
				newOrderEntryDatetxtField.setText(dateFormat.format(date));
				
				try {
					databaseConnection.allClients();
					databaseConnection.allTechnicians();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				clientComboBox.removeAllItems();
				techniciansComboBox.removeAllItems();
				
				for(String str : databaseConnection.clientInfo()){
					clientComboBox.addItem(str);
				}
				for(String str : databaseConnection.techniciansInfo()){
					techniciansComboBox.addItem(str);
				}
				
			}
		});
		newOrderBtn.setBounds(0, 11, 190, 40);
		newOrderBtnIcon = new ImageIcon(this.getClass().getResource("/new_order_btn_blackwhite.png")).getImage();
		newOrderBtnRollover = new ImageIcon(this.getClass().getResource("/new_order_btn_colored.png")).getImage();
		newOrderBtn.setContentAreaFilled(false);
		newOrderBtn.setBorderPainted(false);
		newOrderBtn.setRolloverEnabled(true);
		newOrderBtn.setIcon(new ImageIcon(newOrderBtnIcon));
		newOrderBtn.setRolloverIcon(new ImageIcon(newOrderBtnRollover));
		officePanel.add(newOrderBtn);
		
		//CheckStatus BTN
		checkStatusBtn = new JButton("");
		checkStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOrderStatusPanel.setVisible(true);
				officePanel.setVisible(false);
				
				
				
			}
		});
		checkStatusBtn.setBounds(0, 60, 190, 40);
		checkStatusBtnIcon = new ImageIcon(this.getClass().getResource("/check_status_btn_blackwhite.png")).getImage();
		checkStatusBtnRollover = new ImageIcon(this.getClass().getResource("/check_status_btn_colored.png")).getImage();
		checkStatusBtn.setContentAreaFilled(false);
		checkStatusBtn.setBorderPainted(false);
		checkStatusBtn.setRolloverEnabled(true);
		checkStatusBtn.setIcon(new ImageIcon(checkStatusBtnIcon));
		checkStatusBtn.setRolloverIcon(new ImageIcon(checkStatusBtnRollover));
		officePanel.add(checkStatusBtn);
		
		//NewClient BTN
		newClientBtn = new JButton("");
		newClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClientTab newCLientTab = new NewClientTab(officePanel, databaseConnection);
				frame.getContentPane().add(newCLientTab.getNewClientPanel());
			}
		});
		newClientBtn.setBounds(0, 110, 190, 40);
		newClientBtnIcon = new ImageIcon(this.getClass().getResource("/new_client_btn_blackwhite.png")).getImage();
		newClientBtnRollover = new ImageIcon(this.getClass().getResource("/new_client_btn_colored.png")).getImage();
		newClientBtn.setContentAreaFilled(false);
		newClientBtn.setBorderPainted(false);
		newClientBtn.setRolloverEnabled(true);
		newClientBtn.setIcon(new ImageIcon(newClientBtnIcon));
		newClientBtn.setRolloverIcon(new ImageIcon(newClientBtnRollover));
		officePanel.add(newClientBtn);
		
		//NewTechnician BTN
		newTechnicianBtn = new JButton("");
		newTechnicianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 NewTechnicianTab newTechTab = new NewTechnicianTab(officePanel,databaseConnection);
				 frame.getContentPane().add(newTechTab.getNewTechnicianPanel());
			}
		});
		newTechnicianBtn.setBounds(0, 161, 190, 40);
		newTechnicianBtnIcon = new ImageIcon(this.getClass().getResource("/new_technician_btn_blackwhite.png")).getImage();
		newTechnicianBtnRollover = new ImageIcon(this.getClass().getResource("/new_technician_btn_colored.png")).getImage();
		newTechnicianBtn.setContentAreaFilled(false);
		newTechnicianBtn.setBorderPainted(false);
		newTechnicianBtn.setRolloverEnabled(true);
		newTechnicianBtn.setIcon(new ImageIcon(newTechnicianBtnIcon));
		newTechnicianBtn.setRolloverIcon(new ImageIcon(newTechnicianBtnRollover));
		officePanel.add(newTechnicianBtn);
		
		//MyTasks BTN
		myTasksBtn = new JButton("");
		myTasksBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				servicePanel.setVisible(false);
				myTasksPanel.setVisible(true);
				
				MyTasksOrderIdLbl.setText("");
				MyTasksComponentTypeLbl.setText("");
				myTasksComponentModelLbl.setText("");
				myTasksClientTelLbl.setText("");
				myTasksClientLbl.setText("");
				MyTasksEntryDateLbl.setText("");
				myTasksReadyDateLbl.setText("");
				myTasksPriceLbl.setText("");
				MyTasksStatusLbl.setText("");
				myTasksDiagnosticTxtField.setText("");
				
				
				myTasksTechsComboBox.removeAllItems();
				myTasksChooseComboBox.removeAllItems();
				
				try {
					databaseConnection.allTechnicians();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				for(String str : databaseConnection.techniciansInfo()){
					myTasksTechsComboBox.addItem(str);
					
				}

			}
		});
		myTasksBtn.setBounds(0, 11, 190, 40);
		myTasksBtnIcon = new ImageIcon(this.getClass().getResource("/my_tasks_btn_blackwhite.png")).getImage();
		myTasksBtnRollover = new ImageIcon(this.getClass().getResource("/my_tasks_btn_colored.png")).getImage();
		myTasksBtn.setContentAreaFilled(false);
		myTasksBtn.setBorderPainted(false);
		myTasksBtn.setRolloverEnabled(true);
		myTasksBtn.setIcon(new ImageIcon(myTasksBtnIcon));
		myTasksBtn.setRolloverIcon(new ImageIcon(myTasksBtnRollover));
		servicePanel.add(myTasksBtn);
		
		//RepairComponent BTN
		repairComponentBtn = new JButton("");
		repairComponentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicePanel.setVisible(false);
				repairComponentPanel.setVisible(true);
				repairCompSubmitBtn.setEnabled(false);

				
				repairCompTechComboBox.removeAllItems();
				repairCompToRepairComboBox.removeAllItems();
				repairCompStatusComboBox.removeAllItems();
				
				repairCompDiagnosticTextArea.setText("");
				repairCompStatusComboBox.setSelectedItem(null);
				repairCompPriceLbl.setText("");
				repairCompReadyTxtField.setText("");
				
				try {
					databaseConnection.allTechnicians();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				for(String str : databaseConnection.techniciansInfo()){
					repairCompTechComboBox.addItem(str);
					
				}
				
			}
		});
		repairComponentBtn.setBounds(0, 60, 190, 40);
		repairComponentBtnIcon = new ImageIcon(this.getClass().getResource("/repair_component_btn_blackwhite.png")).getImage();
		repairComponentBtnRollover = new ImageIcon(this.getClass().getResource("/repair_component_btn_colored.png")).getImage();
		repairComponentBtn.setContentAreaFilled(false);
		repairComponentBtn.setBorderPainted(false);
		repairComponentBtn.setRolloverEnabled(true);
		repairComponentBtn.setIcon(new ImageIcon(repairComponentBtnIcon));
		repairComponentBtn.setRolloverIcon(new ImageIcon(repairComponentBtnRollover));
		servicePanel.add(repairComponentBtn);
		
		//Repair Details BTN
		repairDetailsBtn = new JButton("");
		repairDetailsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicePanel.setVisible(false);
				repairDetailsPanel.setVisible(true);
			}
		});
		repairDetailsBtn.setBounds(0, 110, 190, 40);
		repairDetailsBtnIcon = new ImageIcon(this.getClass().getResource("/repair_details_btn_blackwhite.png")).getImage();
		repairDetailsBtnRollover = new ImageIcon(this.getClass().getResource("/repair_details_btn_colored.png")).getImage();
		repairDetailsBtn.setContentAreaFilled(false);
		repairDetailsBtn.setBorderPainted(false);
		repairDetailsBtn.setRolloverEnabled(true);
		repairDetailsBtn.setIcon(new ImageIcon(repairDetailsBtnIcon));
		repairDetailsBtn.setRolloverIcon(new ImageIcon(repairDetailsBtnRollover));
		servicePanel.add(repairDetailsBtn);
		
		//Office Background IMG
		officeBackground = new ImageIcon(this.getClass().getResource("/office_backgrond.png")).getImage();
			//Office Background
		officeBackgroundLabel = new JLabel("");
		officeBackgroundLabel.setBounds(0, 0, 614, 344);
		officePanel.add(officeBackgroundLabel);
		officeBackgroundLabel.setIcon(new ImageIcon(officeBackground));
		
		componentTypeTxtField = new JTextField();
		componentTypeTxtField.setToolTipText("");
		componentTypeTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		componentTypeTxtField.setForeground(Color.WHITE);
		componentTypeTxtField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		componentTypeTxtField.setColumns(10);
		componentTypeTxtField.setBackground(SystemColor.textHighlight);
		componentTypeTxtField.setBounds(168, 84, 126, 27);
		newOrderPanel.add(componentTypeTxtField);
		
		componentTypelbl = new JLabel("Component type:");
		componentTypelbl.setForeground(Color.RED);
		componentTypelbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		componentTypelbl.setBounds(10, 72, 156, 50);
		newOrderPanel.add(componentTypelbl);
		
		newOrderlbl = new JLabel("New Order");
		newOrderlbl.setForeground(SystemColor.textHighlight);
		newOrderlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		newOrderlbl.setBounds(10, 11, 300, 50);
		newOrderPanel.add(newOrderlbl);
		
		JLabel componentModellbl = new JLabel("Component model:");
		componentModellbl.setForeground(Color.RED);
		componentModellbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		componentModellbl.setBounds(304, 72, 163, 50);
		newOrderPanel.add(componentModellbl);
		
		
		componentModelTxtField = new JTextField();
		componentModelTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		componentModelTxtField.setForeground(Color.WHITE);
		componentModelTxtField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		componentModelTxtField.setColumns(10);
		componentModelTxtField.setBackground(SystemColor.textHighlight);
		componentModelTxtField.setBounds(478, 84, 126, 27);
		newOrderPanel.add(componentModelTxtField);
		
		JLabel chooseClientLbl = new JLabel("Choose client");
		chooseClientLbl.setForeground(Color.RED);
		chooseClientLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		chooseClientLbl.setBounds(250, 122, 126, 40);
		newOrderPanel.add(chooseClientLbl);
		
		JLabel chooseTechnicLbl = new JLabel("Choose technician");
		chooseTechnicLbl.setForeground(Color.RED);
		chooseTechnicLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		chooseTechnicLbl.setBounds(238, 197, 156, 40);
		newOrderPanel.add(chooseTechnicLbl);
		
		JLabel entryDateLbl = new JLabel("Entry date");
		entryDateLbl.setForeground(Color.RED);
		entryDateLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		entryDateLbl.setBounds(161, 293, 95, 40);
		newOrderPanel.add(entryDateLbl);
		
		label = new JLabel("(*)required");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label.setBounds(522, 318, 81, 26);
		newOrderPanel.add(label);
		
			//New Order clients COMBOBOX
		clientComboBox = new JComboBox<String>();
		clientComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientComboBox.setForeground(Color.WHITE);
		clientComboBox.setBackground(SystemColor.textHighlight);
		clientComboBox.setBounds(122, 161, 375, 33);
		newOrderPanel.add(clientComboBox);
			//New Order technicians COMBOBOX
		techniciansComboBox = new JComboBox<String>();
		techniciansComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		techniciansComboBox.setForeground(Color.WHITE);
		techniciansComboBox.setBackground(SystemColor.textHighlight);
		techniciansComboBox.setBounds(122, 238, 375, 33);
		newOrderPanel.add(techniciansComboBox);
		
		newOrderEntryDatetxtField = new ObservingTextField();
		newOrderEntryDatetxtField.setEditable(false);
		newOrderEntryDatetxtField.setToolTipText("");
		newOrderEntryDatetxtField.setHorizontalAlignment(SwingConstants.CENTER);
		newOrderEntryDatetxtField.setForeground(Color.WHITE);
		newOrderEntryDatetxtField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		newOrderEntryDatetxtField.setColumns(10);
		newOrderEntryDatetxtField.setBackground(SystemColor.textHighlight);
		newOrderEntryDatetxtField.setBounds(258, 300, 126, 27);
		newOrderPanel.add(newOrderEntryDatetxtField);
		
			//New Order Pick Entry Date Btn
		JButton newOrderPickDateBtn = new JButton("Pick...");
		newOrderPickDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(newOrderEntryDatetxtField,locale);
				Date selectedDate = dp.parseDate(newOrderEntryDatetxtField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(newOrderEntryDatetxtField);
			}
		});
		newOrderPickDateBtn.setForeground(Color.WHITE);
		newOrderPickDateBtn.setBackground(SystemColor.textHighlight);
		newOrderPickDateBtn.setBounds(394, 301, 73, 23);
		newOrderPanel.add(newOrderPickDateBtn);
		
		newOrderSubmitBtn = new JButton("Submit");
		newOrderSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String technicianId = new String();
					String clientId = new String();

					clientId = (String)clientComboBox.getSelectedItem();
					clientId = clientId.substring(clientId.indexOf(":")+1,clientId.indexOf(" "));
					
					technicianId = (String)techniciansComboBox.getSelectedItem();
					technicianId = technicianId.substring(technicianId.indexOf(":")+1, technicianId.indexOf(" "));

					databaseConnection.createOrder(componentTypeTxtField.getText(), componentModelTxtField.getText(),
							clientId, technicianId,newOrderEntryDatetxtField.getText());
					
					JOptionPane.showMessageDialog(frame,
						    databaseConnection.newOrderResult(),
						    "Warning",
						    JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		newOrderSubmitBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		newOrderSubmitBtn.setForeground(Color.WHITE);
		newOrderSubmitBtn.setBackground(SystemColor.textHighlight);
		newOrderSubmitBtn.setBounds(507, 231, 97, 70);
		newOrderPanel.add(newOrderSubmitBtn);
		
		newOrderClearBtn = new JButton("Clear");
		newOrderClearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				componentTypeTxtField.setText("");
				componentModelTxtField.setText("");
			}
		});
		newOrderClearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newOrderClearBtn.setForeground(Color.WHITE);
		newOrderClearBtn.setBackground(Color.RED);
		newOrderClearBtn.setBounds(507, 197, 97, 23);
		newOrderPanel.add(newOrderClearBtn);
		
		
			//New Order Background
		newOrderBackgroundLabel = new JLabel("");
		newOrderBackgroundLabel.setBounds(0, 0, 614, 344);
		newOrderPanel.add(newOrderBackgroundLabel);
		newOrderBackgroundLabel.setIcon(new ImageIcon(officeBackground));
			//CheckStatus Background
		checkStatusBackgroundLabel = new JLabel("");
		checkStatusBackgroundLabel.setBounds(0, 0, 614, 344);
		checkOrderStatusPanel.add(checkStatusBackgroundLabel);
		checkStatusBackgroundLabel.setIcon(new ImageIcon(officeBackground));


		
		//Service Background IMG
		serviceBackground = new ImageIcon(this.getClass().getResource("/service_background.png")).getImage();
			//Service Background
		serviceBackgroundLabel = new JLabel("");
		serviceBackgroundLabel.setBounds(0, 0, 614, 344);
		serviceBackgroundLabel.setIcon(new ImageIcon(serviceBackground));
		servicePanel.add(serviceBackgroundLabel);
		
		myTasksLogoLbl = new JLabel("My Tasks");
		myTasksLogoLbl.setBounds(10, 11, 151, 50);
		myTasksPanel.add(myTasksLogoLbl);
		myTasksLogoLbl.setForeground(SystemColor.textHighlight);
		myTasksLogoLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		myTasksTechLbl = new JLabel("You are");
		myTasksTechLbl.setForeground(Color.RED);
		myTasksTechLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		myTasksTechLbl.setBounds(5, 64, 74, 40);
		myTasksPanel.add(myTasksTechLbl);
		
		myTasksChooseComboBox = new JComboBox<String>();
		myTasksChooseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    
    				try {
    					databaseConnection.componentInfo(myTasksChooseComboBox.getSelectedItem().toString());

    					MyTasksOrderIdLbl.setText(databaseConnection.componentOrderId());
    					MyTasksComponentTypeLbl.setText(databaseConnection.componentType());
    					myTasksComponentModelLbl.setText(databaseConnection.componentModel());
    					MyTasksEntryDateLbl.setText(databaseConnection.componentEntryDate());
    					if(databaseConnection.componentReadyDate() == null){
    						myTasksReadyDateLbl.setText("Not yet ready");
    						
    						
    					}
    					else{
    						SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    						String date_to_string = dateformatyyyyMMdd.format(databaseConnection.componentReadyDate());
    						myTasksReadyDateLbl.setText(date_to_string);
    					}
    					myTasksClientLbl.setText(databaseConnection.componentClientFirstName() + " " + databaseConnection.componentClientLastName());
    					myTasksClientTelLbl.setText(databaseConnection.componentClientTelNum());
    					switch (databaseConnection.componentStatus()) {
							case "Not yet started":
								MyTasksStatusLbl.setForeground(Color.RED);
								break;
							case "Being repaired...":
								MyTasksStatusLbl.setForeground(Color.ORANGE);
								break;
							case "Ready":
								MyTasksStatusLbl.setForeground(Color.GREEN);
								break;

							default:
								break;
						}
    					MyTasksStatusLbl.setText(databaseConnection.componentStatus());
    					if(databaseConnection.componentOrderPrice() == 0.0){
    						myTasksPriceLbl.setText("Not yet ready");
    					}
    					else{
    						myTasksPriceLbl.setText(Float.toString(databaseConnection.componentOrderPrice()));
    					}


    					if(databaseConnection.componentDiagnosticResults() == null){
    						myTasksDiagnosticTxtField.setText("Not yet repaired");
    					}
    					else{
    						myTasksDiagnosticTxtField.setText(databaseConnection.componentDiagnosticResults());
    					}
    					
    					
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	
                }

				

			}
		});
		myTasksChooseComboBox.setForeground(Color.WHITE);
		myTasksChooseComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		myTasksChooseComboBox.setBackground(SystemColor.textHighlight);
		myTasksChooseComboBox.setBounds(341, 103, 263, 25);
		myTasksPanel.add(myTasksChooseComboBox);
		
		myTasksTechsComboBox = new JComboBox<String>();
		myTasksTechsComboBox.setForeground(Color.WHITE);
		myTasksTechsComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		myTasksTechsComboBox.setBackground(SystemColor.textHighlight);
		myTasksTechsComboBox.setBounds(5, 103, 263, 25);
		myTasksPanel.add(myTasksTechsComboBox);
		
		repairCompTechComboBox = new JComboBox<String>();
		repairCompTechComboBox.setForeground(Color.WHITE);
		repairCompTechComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		repairCompTechComboBox.setBackground(SystemColor.textHighlight);
		repairCompTechComboBox.setBounds(10, 231, 263, 25);
		repairComponentPanel.add(repairCompTechComboBox);
		

		
		JLabel myTasksYourChooseLbl = new JLabel("Choose a task");
		myTasksYourChooseLbl.setForeground(Color.RED);
		myTasksYourChooseLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		myTasksYourChooseLbl.setBounds(341, 64, 126, 40);
		myTasksPanel.add(myTasksYourChooseLbl);
		
		JLabel OrderIdLbl = new JLabel("Order ID:");
		OrderIdLbl.setForeground(SystemColor.textHighlight);
		OrderIdLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		OrderIdLbl.setBounds(10, 130, 60, 40);
		myTasksPanel.add(OrderIdLbl);
		
		MyTasksOrderIdLbl = new JLabel("");
		MyTasksOrderIdLbl.setForeground(Color.BLACK);
		MyTasksOrderIdLbl.setBackground(SystemColor.textHighlight);
		MyTasksOrderIdLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MyTasksOrderIdLbl.setBounds(71, 137, 158, 25);
		myTasksPanel.add(MyTasksOrderIdLbl);
		
		JLabel componentTypeLbl = new JLabel("Component type:");
		componentTypeLbl.setForeground(SystemColor.textHighlight);
		componentTypeLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		componentTypeLbl.setBounds(10, 162, 118, 40);
		myTasksPanel.add(componentTypeLbl);
		
		MyTasksComponentTypeLbl = new JLabel("");
		MyTasksComponentTypeLbl.setForeground(Color.BLACK);
		MyTasksComponentTypeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MyTasksComponentTypeLbl.setBackground(SystemColor.textHighlight);
		MyTasksComponentTypeLbl.setBounds(124, 169, 126, 25);
		myTasksPanel.add(MyTasksComponentTypeLbl);
		
		componentModelLbl = new JLabel("Component model:");
		componentModelLbl.setForeground(SystemColor.textHighlight);
		componentModelLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		componentModelLbl.setBounds(10, 192, 126, 40);
		myTasksPanel.add(componentModelLbl);
		
		myTasksComponentModelLbl = new JLabel("");
		myTasksComponentModelLbl.setForeground(Color.BLACK);
		myTasksComponentModelLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		myTasksComponentModelLbl.setBackground(SystemColor.textHighlight);
		myTasksComponentModelLbl.setBounds(134, 199, 197, 25);
		myTasksPanel.add(myTasksComponentModelLbl);
		
		lblEntryDate = new JLabel("Entry date:");
		lblEntryDate.setForeground(SystemColor.textHighlight);
		lblEntryDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntryDate.setBounds(10, 224, 74, 40);
		myTasksPanel.add(lblEntryDate);
		
		MyTasksEntryDateLbl = new JLabel("");
		MyTasksEntryDateLbl.setForeground(Color.BLACK);
		MyTasksEntryDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MyTasksEntryDateLbl.setBackground(SystemColor.textHighlight);
		MyTasksEntryDateLbl.setBounds(85, 231, 133, 25);
		myTasksPanel.add(MyTasksEntryDateLbl);
		
		readyDateLbl = new JLabel("Ready date:");
		readyDateLbl.setForeground(SystemColor.textHighlight);
		readyDateLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		readyDateLbl.setBounds(10, 256, 84, 40);
		myTasksPanel.add(readyDateLbl);
		
		myTasksReadyDateLbl = new JLabel("");
		myTasksReadyDateLbl.setForeground(Color.BLACK);
		myTasksReadyDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		myTasksReadyDateLbl.setBackground(SystemColor.textHighlight);
		myTasksReadyDateLbl.setBounds(94, 263, 143, 25);
		myTasksPanel.add(myTasksReadyDateLbl);
		
		clientLbl = new JLabel("Client:");
		clientLbl.setForeground(SystemColor.textHighlight);
		clientLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientLbl.setBounds(240, 130, 55, 40);
		myTasksPanel.add(clientLbl);
		
		myTasksClientLbl = new JLabel("");
		myTasksClientLbl.setForeground(Color.BLACK);
		myTasksClientLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		myTasksClientLbl.setBackground(SystemColor.textHighlight);
		myTasksClientLbl.setBounds(288, 139, 168, 25);
		myTasksPanel.add(myTasksClientLbl);
		
		MyTasksStatusLbl = new JLabel("");
		MyTasksStatusLbl.setForeground(Color.BLACK);
		MyTasksStatusLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MyTasksStatusLbl.setBackground(SystemColor.textHighlight);
		MyTasksStatusLbl.setBounds(496, 169, 108, 25);
		myTasksPanel.add(MyTasksStatusLbl);
		
		statusLbl = new JLabel("Status:");
		statusLbl.setForeground(SystemColor.textHighlight);
		statusLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		statusLbl.setBounds(447, 162, 55, 40);
		myTasksPanel.add(statusLbl);
		
		priceLbl = new JLabel("Price:");
		priceLbl.setForeground(SystemColor.textHighlight);
		priceLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		priceLbl.setBounds(447, 130, 50, 40);
		myTasksPanel.add(priceLbl);
		
		myTasksPriceLbl = new JLabel("");
		myTasksPriceLbl.setForeground(Color.BLACK);
		myTasksPriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		myTasksPriceLbl.setBackground(SystemColor.textHighlight);
		myTasksPriceLbl.setBounds(497, 136, 107, 25);
		myTasksPanel.add(myTasksPriceLbl);
		
		clientTelLbl = new JLabel("Client Tel:");
		clientTelLbl.setForeground(SystemColor.textHighlight);
		clientTelLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		clientTelLbl.setBounds(239, 162, 84, 40);
		myTasksPanel.add(clientTelLbl);
		
		myTasksClientTelLbl = new JLabel("");
		myTasksClientTelLbl.setForeground(Color.BLACK);
		myTasksClientTelLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		myTasksClientTelLbl.setBackground(SystemColor.textHighlight);
		myTasksClientTelLbl.setBounds(305, 169, 151, 25);
		myTasksPanel.add(myTasksClientTelLbl);
		
		diagnosticResultsLbl = new JLabel("Diagnostic results:");
		diagnosticResultsLbl.setForeground(SystemColor.textHighlight);
		diagnosticResultsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		diagnosticResultsLbl.setBounds(322, 224, 151, 25);
		myTasksPanel.add(diagnosticResultsLbl);
		
		myTasksDiagnosticTxtField = new JTextArea();
		myTasksDiagnosticTxtField.setForeground(Color.WHITE);
		myTasksDiagnosticTxtField.setBackground(SystemColor.textHighlight);
		myTasksDiagnosticTxtField.setFont(new Font("Monospaced", Font.PLAIN, 15));
		myTasksDiagnosticTxtField.setEditable(false);
		myTasksDiagnosticTxtField.setLineWrap(true);
		myTasksDiagnosticTxtField.setBounds(259, 256, 297, 85);
		myTasksPanel.add(myTasksDiagnosticTxtField);
		
		
		
		JButton myTasksShowBtn = new JButton(">");
		myTasksShowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myTasksChooseComboBox.removeAllItems();

				if(myTasksTechsComboBox.getSelectedItem() != null){
				String record = myTasksTechsComboBox.getSelectedItem().toString();

				try {
				databaseConnection.showTasks(record);
				
				for(String str : databaseConnection.componentsInfo()){
					myTasksChooseComboBox.addItem(str);
				}
					} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				if(myTasksChooseComboBox.getItemCount() == 0){
					MyTasksOrderIdLbl.setText("");
					MyTasksComponentTypeLbl.setText("");
					myTasksComponentModelLbl.setText("");
					MyTasksEntryDateLbl.setText("");
					myTasksReadyDateLbl.setText("");
					myTasksClientLbl.setText("");
					myTasksClientTelLbl.setText("");
					MyTasksStatusLbl.setText("");
					myTasksPriceLbl.setText("");
					myTasksDiagnosticTxtField.setText("");
				}

				}
			}
			
		});

		myTasksShowBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		myTasksShowBtn.setForeground(Color.WHITE);
		myTasksShowBtn.setBackground(SystemColor.textHighlight);
		myTasksShowBtn.setBounds(278, 94, 53, 40);
		myTasksPanel.add(myTasksShowBtn);
			//MyTasks Background
		myTasksBackgroundLabel = new JLabel("");
		myTasksBackgroundLabel.setBounds(0, 0, 614, 344);
		myTasksBackgroundLabel.setIcon(new ImageIcon(serviceBackground));
		myTasksPanel.add(myTasksBackgroundLabel);
		
		repairCompReadyTxtField = new ObservingTextField();
		repairCompReadyTxtField.setToolTipText("");
		repairCompReadyTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		repairCompReadyTxtField.setForeground(Color.WHITE);
		repairCompReadyTxtField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		repairCompReadyTxtField.setEditable(false);
		repairCompReadyTxtField.setColumns(10);
		repairCompReadyTxtField.setBackground(SystemColor.textHighlight);
		repairCompReadyTxtField.setBounds(474, 314, 104, 27);
		repairComponentPanel.add(repairCompReadyTxtField);
		
		repairComponentLbl = new JLabel("Repair Component");
		repairComponentLbl.setForeground(SystemColor.textHighlight);
		repairComponentLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		repairComponentLbl.setBounds(10, 0, 335, 50);
		repairComponentPanel.add(repairComponentLbl);
		
		technicianLbl = new JLabel("You are");
		technicianLbl.setForeground(Color.RED);
		technicianLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		technicianLbl.setBounds(10, 206, 63, 31);
		repairComponentPanel.add(technicianLbl);
		
		repairCompShowBtn = new JButton(">");
		repairCompShowBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repairCompToRepairComboBox.removeAllItems();
				repairCompSubmitBtn.setEnabled(false);
				if(repairCompTechComboBox.getSelectedItem() != null){
				String record = repairCompTechComboBox.getSelectedItem().toString();

				try {
				databaseConnection.showTasks(record);
				
				for(String str : databaseConnection.componentsInfo()){
					repairCompToRepairComboBox.addItem(str);
				}
					} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				}
				
				if(repairCompToRepairComboBox.getItemCount() == 0){
					repairCompDiagnosticTextArea.setText("");
					repairCompStatusComboBox.setSelectedItem(null);
					repairCompPriceLbl.setText("");
					repairCompReadyTxtField.setText("");
				}
				else{
					repairCompStatusComboBox.addItem("Not yet started");
					repairCompStatusComboBox.addItem("Being repaired...");
					repairCompStatusComboBox.addItem("Ready");
				}
				
				//
				try {
					ResultSetTable techsTable  = new ResultSetTable(databaseConnection.partsInfo());
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
		});
		repairCompShowBtn.setForeground(Color.WHITE);
		repairCompShowBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		repairCompShowBtn.setBackground(SystemColor.textHighlight);
		repairCompShowBtn.setBounds(287, 231, 41, 26);
		repairComponentPanel.add(repairCompShowBtn);
		
		
		JLabel toRepairLbl = new JLabel("Component to repair");
		toRepairLbl.setForeground(Color.RED);
		toRepairLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		toRepairLbl.setBounds(341, 206, 164, 31);
		repairComponentPanel.add(toRepairLbl);
			//RepairComponent To Repair Combo Box
		repairCompToRepairComboBox = new JComboBox<String>();
		repairCompToRepairComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				
                if (event.getStateChange() == ItemEvent.SELECTED) {
                	repairCompSubmitBtn.setEnabled(true);
    				try {
    					databaseConnection.componentPartsInfo(repairCompToRepairComboBox.getSelectedItem().toString());


    					if(databaseConnection.componentReadyDate() == null){
    						repairCompReadyTxtField.setText("Not yet ready");
    						
    						
    					}
    					else{
    						SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    						String date_to_string = dateformatyyyyMMdd.format(databaseConnection.componentReadyDate());
    						repairCompReadyTxtField.setText(date_to_string);
    					}
    					
    					repairCompStatusComboBox.setSelectedItem(databaseConnection.componentStatus());

    					if(databaseConnection.componentOrderPrice() == 0.0){
    						repairCompPriceLbl.setText("Not yet ready");
    					}
    					else{
    						repairCompPriceLbl.setText(Float.toString(databaseConnection.componentOrderPrice()) + " levs");
    					}


    					if(databaseConnection.componentDiagnosticResults() == null){
    						repairCompDiagnosticTextArea.setText("Not yet repaired");
    					}
    					else{
    						repairCompDiagnosticTextArea.setText(databaseConnection.componentDiagnosticResults());
    					}
    					
    					
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	
                }	

			}
		});
		repairCompToRepairComboBox.setForeground(Color.WHITE);
		repairCompToRepairComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		repairCompToRepairComboBox.setBackground(SystemColor.textHighlight);
		repairCompToRepairComboBox.setBounds(341, 231, 263, 25);
		repairComponentPanel.add(repairCompToRepairComboBox);
		
		repairCompSubmitBtn = new JButton("Submit");
		repairCompSubmitBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		repairCompSubmitBtn.setBackground(SystemColor.textHighlight);
		repairCompSubmitBtn.setForeground(Color.WHITE);
		repairCompSubmitBtn.setBounds(460, 268, 144, 42);
		repairComponentPanel.add(repairCompSubmitBtn);
		
		JLabel orderPriceLbl = new JLabel("Order Price:");
		orderPriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		orderPriceLbl.setForeground(SystemColor.textHighlight);
		orderPriceLbl.setBounds(216, 315, 86, 25);
		repairComponentPanel.add(orderPriceLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 268, 263, 42);
		repairComponentPanel.add(scrollPane);
		
		repairCompDiagnosticTextArea = new JTextArea();
		repairCompDiagnosticTextArea.setLineWrap(true);
		repairCompDiagnosticTextArea.setForeground(Color.WHITE);
		repairCompDiagnosticTextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		repairCompDiagnosticTextArea.setBackground(SystemColor.textHighlight);
		repairCompDiagnosticTextArea.setBounds(425, 139, 179, 125);
		scrollPane.setViewportView(repairCompDiagnosticTextArea);

		
		repairCompPriceLbl = new JLabel("New label");
		repairCompPriceLbl.setForeground(Color.RED);
		repairCompPriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		repairCompPriceLbl.setBounds(300, 316, 95, 23);
		repairComponentPanel.add(repairCompPriceLbl);
		
		JLabel statusOrderLbl = new JLabel("Status:");
		statusOrderLbl.setForeground(SystemColor.textHighlight);
		statusOrderLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statusOrderLbl.setBounds(45, 315, 50, 25);
		repairComponentPanel.add(statusOrderLbl);
		
			//
		
		repairCompStatusComboBox = new JComboBox<String>();
		repairCompStatusComboBox.setForeground(Color.WHITE);
		repairCompStatusComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		repairCompStatusComboBox.setBackground(SystemColor.textHighlight);
		repairCompStatusComboBox.setBounds(95, 314, 111, 25);
		repairComponentPanel.add(repairCompStatusComboBox);
		
		JLabel orderPriceCompLbl = new JLabel("Ready date:");
		orderPriceCompLbl.setForeground(SystemColor.textHighlight);
		orderPriceCompLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		orderPriceCompLbl.setBounds(386, 315, 86, 25);
		repairComponentPanel.add(orderPriceCompLbl);
		
		JLabel diagnosticResultslbl = new JLabel("Diagnostic results:");
		diagnosticResultslbl.setForeground(SystemColor.textHighlight);
		diagnosticResultslbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		diagnosticResultslbl.setBounds(60, 277, 121, 25);
		repairComponentPanel.add(diagnosticResultslbl);
		
		JButton repairCompPickDateBtn = new JButton(". . .");
		repairCompPickDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatePicker dp = new DatePicker(repairCompReadyTxtField);
				Date selectedDate = dp.parseDate(repairCompReadyTxtField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(newOrderEntryDatetxtField);
			}
		});
		repairCompPickDateBtn.setForeground(Color.WHITE);
		repairCompPickDateBtn.setBackground(SystemColor.textHighlight);
		repairCompPickDateBtn.setBounds(584, 315, 20, 23);
		repairComponentPanel.add(repairCompPickDateBtn);
			//RepairComponent Background
		repairComponentBackgroundLabel = new JLabel("");
		repairComponentBackgroundLabel.setBounds(0, 0, 614, 344);
		repairComponentBackgroundLabel.setIcon(new ImageIcon(serviceBackground));
		repairComponentPanel.add(repairComponentBackgroundLabel);
			//RepairDetails Background
		repairDetailsBackgroundLabel = new JLabel("");
		repairDetailsBackgroundLabel.setBounds(0, 0, 614, 344);
		repairDetailsBackgroundLabel.setIcon(new ImageIcon(serviceBackground));
		repairDetailsPanel.add(repairDetailsBackgroundLabel);
		

	}
	
	//Checking database connectivity - label coloring
	private void checkDatabaseConnectivity(boolean check){
		if(check == true){
			databaseConnectedLabel.setForeground(new Color(0, 205, 96));
			databaseConnectedLabel.setText("Connected to database");
		}
		else{
			//Error dialog
			JOptionPane.showMessageDialog(frame,
				    "Unable to connect to the database",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			
			databaseConnectedLabel.setForeground(new Color(255, 0, 0));
			databaseConnectedLabel.setText("Not connected to database");
		}
	}
	
	private Locale getLocale(String loc){
		if(loc != null && loc.length() > 0){
			return new Locale(loc);
		}
		else return Locale.US;
	}
	
		//Column widht resizing of tables
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 1; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width, width);
	        }
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
}
