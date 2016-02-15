import java.awt.EventQueue;

public class ComponentServiceMain {

	private static ComponentService window;
	protected static MySQLConnect databaseConnection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					databaseConnection = new MySQLConnect();
					databaseConnection.connectToDatabase();
				} catch (Exception e) {
					System.out.println("Not connected");
					//					e.printStackTrace();
				}
				window = new ComponentService();
				window.frame.setVisible(true);
				window.checkDatabaseConnectivity(databaseConnection.hasConnected());

			}
		});

	}

	static MySQLConnect getDatabaseConnection(){
		return databaseConnection;
	}



}
