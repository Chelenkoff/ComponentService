import java.awt.EventQueue;

import javax.swing.JFrame;

public class ComponentServiceMain {
	
	private static ComponentService window;
	protected static MySQLConnect databaseConnection;
	JFrame frame;

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
	
	static MySQLConnect getDatabaseConnection(){
		return databaseConnection;
	}
	
	

}
