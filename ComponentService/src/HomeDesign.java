import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class HomeDesign {

	//Variables
	private JFrame frame;
	
	private JLabel separatorImageLabel;
	private JLabel logoLabel;
	private JLabel backgroundLabel;
	
	private Image separatorImageIcon;
	private Image backgroundIcon;
	private Image officeIcon;
	private Image appIcon;
	private Image officeRollover;
	private Image serviceIcon;
	private Image serviceRollover;
	private Image logoImageIcon;
	
	private JButton officeBtn;
	private JButton serviceButton;
	
	//Getters
	public JFrame frame(){
		return this.frame;
	}
	//Setters
	
	//Constructor
	public HomeDesign(){
		
//		frame.setVisible(true);
		
		frame = new JFrame("Chelenkoff Service");
		frame.setBounds(100, 100, 620, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		appIcon = new ImageIcon(this.getClass().getResource("/app_icon.png")).getImage();
		frame.setIconImage(appIcon);
		
		separatorImageLabel = new JLabel("");
		separatorImageLabel.setBounds(265, 64, 90, 250);
		separatorImageIcon = new ImageIcon(this.getClass().getResource("/separator.png")).getImage();
		separatorImageLabel.setIcon(new ImageIcon(separatorImageIcon));
		frame.getContentPane().add(separatorImageLabel);
		
		officeBtn = new JButton("");
		officeBtn.setBounds(20, 65, 240, 240);
		officeIcon = new ImageIcon(this.getClass().getResource("/office_blackwhite.png")).getImage();
		officeRollover = new ImageIcon(this.getClass().getResource("/office_colored.png")).getImage();
		officeBtn.setContentAreaFilled(false);
		officeBtn.setBorderPainted(false);
		officeBtn.setRolloverEnabled(true);
		officeBtn.setIcon(new ImageIcon(officeIcon));
		officeBtn.setRolloverIcon(new ImageIcon(officeRollover));
		frame.getContentPane().add(officeBtn);

		serviceButton = new JButton("");
		serviceButton.setBounds(360, 64, 240, 240);
		serviceIcon = new ImageIcon(this.getClass().getResource("/service_blackwhite.png")).getImage();
		officeRollover = new ImageIcon(this.getClass().getResource("/service_colored.png")).getImage();
		serviceButton.setContentAreaFilled(false);
		serviceButton.setBorderPainted(false);
		serviceButton.setRolloverEnabled(true);
		serviceButton.setIcon(new ImageIcon(serviceIcon));
		serviceButton.setRolloverIcon(new ImageIcon(serviceRollover));
		frame.getContentPane().add(officeBtn);
		frame.getContentPane().add(serviceButton);
		
		logoLabel = new JLabel("");
		logoLabel.setBounds(207, 11, 201, 52);
		logoImageIcon = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logoImageIcon));
		frame.getContentPane().add(logoLabel);
		
		backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 614, 344);
		backgroundIcon = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundIcon));
		frame.getContentPane().add(backgroundLabel);
	}
}
