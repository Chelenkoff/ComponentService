import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ComponentService {

	JFrame frame;

	private  JPanel officePanel;
	private  JPanel servicePanel;
	private  JPanel menuPanel;

	private JPanel checkOrderStatusPanel;
	private JPanel myTasksPanel;
	private JPanel repairDetailsPanel;


	private JLabel separatorImageLabel;
	private JLabel logoLabel;
	private JLabel backgroundLabel;
	private JLabel officeBackgroundLabel;
	private JLabel serviceBackgroundLabel;

	private JLabel repairDetailsBackgroundLabel;
	private JLabel checkStatusBackgroundLabel;
	private JLabel databaseConnectedLabel;

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
	private JButton checkStatusBackBtn;



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


//		repairComponentPanel = new JPanel();
//		repairComponentPanel.setBounds(0, 0, 614, 344);
//		frame.getContentPane().add(repairComponentPanel);
//		repairComponentPanel.setLayout(null);
//		repairComponentPanel.setVisible(false);

		myTasksPanel = new JPanel();
		myTasksPanel.setBounds(0, 0, 614, 344);
		frame.getContentPane().add(myTasksPanel);
		myTasksPanel.setLayout(null);
		myTasksPanel.setVisible(false);

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

				NewOrderTab newOrderTab = new NewOrderTab(officePanel, ComponentServiceMain.getDatabaseConnection());
				frame.getContentPane().add(newOrderTab.getNewOrderPanel());

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

				NewClientTab newCLientTab = new NewClientTab(officePanel, ComponentServiceMain.getDatabaseConnection());

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

				NewTechnicianTab newTechTab = new NewTechnicianTab(officePanel,ComponentServiceMain.getDatabaseConnection());
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

				MyTasksTab myTaskTab = new MyTasksTab(servicePanel,ComponentServiceMain.getDatabaseConnection());
				frame.getContentPane().add(myTaskTab.getMyTasksPanel());

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
				
				RepairComponentTab repairCompTab = new RepairComponentTab(servicePanel, ComponentServiceMain.getDatabaseConnection());
				frame.getContentPane().add(repairCompTab.getRepairComponentPanel());

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


		//RepairDetails Background
		repairDetailsBackgroundLabel = new JLabel("");
		repairDetailsBackgroundLabel.setBounds(0, 0, 614, 344);
		repairDetailsBackgroundLabel.setIcon(new ImageIcon(serviceBackground));
		repairDetailsPanel.add(repairDetailsBackgroundLabel);


	}

	//Checking database connectivity - label coloring
	void checkDatabaseConnectivity(boolean check){
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
