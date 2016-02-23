import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLConnect {
	
	//Establishing database connection
	  private static Connection connect;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private boolean hasConnected = false;

	  private String technicianResult;
	  private String technicianStatement;
	  private String technicianId;
	  private String[] techniciansInfo;
	  
	  private String clientResult;
	  private String clientStatement;
	  private String clientId;
	  private String[] clientInfo;
	  private String[] componentsInfo;
	  
	  private String newOrderResult;
	  
	  private String componentOrderId;
	  private String componentType;
	  private String componentModel;
	  private String componentEntryDate;
	  private Date componentReadyDate;
	  private String componentClientFirstName;
	  private String componentClientLastName;
	  private String componentClientTelNum;
	  private String componentStatus;
	  private float componentOrderPrice;
	  private String componentDiagnosticResults;
	  
	  // Database data
	  private static final String DB_NAME = "component_service";
	  private static final String DB_USERNAME = "root";
	  private static final String DB_PASS = "Veca1994"; 
  
	  //Connecting to database
	  public void connectToDatabase(){
			try
		    {
				Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found !!");
	            hasConnected = false;
	            return;
	        }
			
			try {
				String dbUrl = "jdbc:mysql://localhost/" + DB_NAME + "?user=" + DB_USERNAME + "&password=" + DB_PASS;
				connect = DriverManager
						.getConnection(dbUrl);
				System.out.println("SQL Connection to database established!");
				hasConnected = true;
			} catch (SQLException e){
	            System.out.println("Unable to connect to database");
	            hasConnected = false;
	            return;
			}
	  }
	  
	  public boolean hasConnected(){
		  return hasConnected;
	  }
	  
	  //Getters
	  public String technicianResult(){
		  return technicianResult;
	  }
	  
	  public String technicianStatement(){
		  if(technicianStatement != null){
			  return technicianStatement;
		  }
		  else{
			  return "EMPTY";
		  }
		  
	  }

	  public String componentDiagnosticResults(){
		  return componentDiagnosticResults;
	  }
	  
	  public float componentOrderPrice(){
		  return componentOrderPrice;
	  }
	  
	  public String componentStatus(){
		  switch (componentStatus){
		  	case "not_started":
		  		return "Not yet started";
		  	case "in_progress":
		  		return "Being repaired...";
		  	case "ready":
		  		return "Ready";
		  	default:
		  		return "";
		  }	  
	  }
	  
	  public String componentClientTelNum(){
		  return componentClientTelNum;
	  }
	  
	  public String componentClientLastName(){
		  return componentClientLastName;
	  }
	  
	  public String componentClientFirstName(){
		  return componentClientFirstName;
	  }
	  
	  public Date componentReadyDate(){
		  return componentReadyDate;
	  }
	  
	  public String componentEntryDate(){
		  return componentEntryDate;
	  }
	  
	  public String componentModel(){
		  return componentModel;
	  }
	  
	  public String componentType(){
		  return componentType;
	  }
	  
	  public String componentOrderId(){
		  return componentOrderId;
	  }
	  
	  public String[] componentsInfo(){
		  return componentsInfo;
	  }
	  
	  public String technicianId(){
		  if(technicianId != null){
			  return technicianId;
		  }
		  else{
			  return "EMPTY";
		  }
		  
	  }
	  
	  public String clientResult(){
		  return clientResult;
	  }
	  
	  public String clientStatement(){
		  if(clientStatement != null){
			  return clientStatement;
		  }
		  else{
			  return "EMPTY";
		  }
		  
	  }
	  
	  public String newOrderResult(){
		  return newOrderResult;
	  }
	  
	  public String clientId(){
		  if(clientId != null){
			  return clientId;
		  }
		  else{
			  return "EMPTY";
		  }
		  
	  }
	  
	  public String[] clientInfo(){
		  return clientInfo;
	  }
	  
	  public String[] techniciansInfo(){
		  return techniciansInfo;
	  }
	  
	  //Methods
	  
	  public static boolean isDbConnected() {
		    final String CHECK_SQL_QUERY = "SELECT 1";
		    boolean isConnected = false;
		    try {
		        final PreparedStatement statement = connect.prepareStatement(CHECK_SQL_QUERY);
		        isConnected = true;
		    } catch (SQLException | NullPointerException e) {
		        // handle SQL error here!
		    }
		    return isConnected;
		}
	  //Test
	  
	  public boolean checkConnectivity(){
		  return hasConnected;
	  }
	  
	  	//Add technician
	  public void addTechnician(String firstName,String middleName,String lastName,String tel,String email) throws SQLException{
	      preparedStatement = connect.prepareStatement("CALL add_technician (?, ?, ?, ?,?)");
	      //Params: ('first_name', 'middle_name', 'last_name', 'tel_num', 'email')
	      
	      if(middleName.equals(null) || middleName.equals("")){
	    	  middleName = "NULL";
	      }
	      if(email.equals(null) || email.equals("")){
	    	  email = "NULL";
	      }
	      
	      preparedStatement.setString(1,firstName);
	      preparedStatement.setString(2,middleName);
	      preparedStatement.setString(3,lastName);
	      preparedStatement.setString(4,tel);
	      preparedStatement.setString(5,email);
	      resultSet = preparedStatement.executeQuery();
	      
	      if(resultSet.next()){
		      technicianResult = resultSet.getString("result");
		      if(hasColumn(resultSet, "statement")){
		    	  technicianStatement = resultSet.getString("statement");
		    	  technicianId = resultSet.getString("id");
		    	  technicianResult += '\n'+technicianStatement + technicianId;
		      }
	      } 
	  }
	  
	  	//Add client
	  public void addClient(String firstName,String lastName,String tel) throws SQLException{
	      preparedStatement = connect.prepareStatement("CALL add_client (?, ?, ?)");
	      //Params: ('first_name', 'last_name', 'tel_num')
	      
	      preparedStatement.setString(1,firstName);
	      preparedStatement.setString(2,lastName);
	      preparedStatement.setString(3,tel);
	      resultSet = preparedStatement.executeQuery();
	      
	      if(resultSet.next()){
	    	  clientResult = resultSet.getString("result");
		      if(hasColumn(resultSet, "statement")){
		    	  clientStatement = resultSet.getString("statement");
		    	  clientId = resultSet.getString("id");
		    	  clientResult += '\n'+clientStatement + clientId;
		      }
	      } 
	  }
	  
	  	//Create order
	  public void createOrder(String compType,String compModel,String clientId,String technicianId,String date) throws SQLException{
		  preparedStatement = connect.prepareStatement("CALL create_order (?, ?, ?, ?, ?)");
	      //Params: (compType, compModel, clientId,technicId,entryDate)
	      
	      preparedStatement.setString(1,compType);
	      preparedStatement.setString(2,compModel);
	      preparedStatement.setString(3,clientId);
	      preparedStatement.setString(4,technicianId);
	      preparedStatement.setString(5,date);
	      resultSet = preparedStatement.executeQuery();
	      
	      if(resultSet.next())
	    	  newOrderResult = resultSet.getString("result"); 
	  }
	  
	  	//Check if column exists in database
	  public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columns = rsmd.getColumnCount();
		    for (int numOfCol = 1; numOfCol <= columns; numOfCol++) {
		        if (columnName.equals(rsmd.getColumnName(numOfCol))) {
		            return true;
		        }
		    }
		    return false;
		}
	  
	  	//Clients info "FirstName LastName TelNum"
	  public void allClients() throws SQLException{
		  ArrayList<String> ids = new ArrayList<String>();
		  ArrayList<String> firstNames = new ArrayList<String>(); 
		  ArrayList<String> lastNames = new ArrayList<String>(); 
		  ArrayList<String> telNums = new ArrayList<String>(); 
		  ArrayList<String> clients = new ArrayList<String>();
		  
		  preparedStatement = connect.prepareStatement("SELECT client_id,first_name,last_name,tel_num FROM clients ORDER BY first_name");
		  resultSet = preparedStatement.executeQuery();
		  
		  while (resultSet.next()) {
			  	ids.add(resultSet.getString(1));
		        firstNames.add(resultSet.getString(2));
		        lastNames.add(resultSet.getString(3));
		        telNums.add(resultSet.getString(4));
		    }
		  
		  for(int index = 0 ; index < firstNames.size(); index ++){
			  clients.add("ID:" + ids.get(index) + "     " + firstNames.get(index) + " " + lastNames.get(index) + "     Tel:" + telNums.get(index));
		  }
		  clientInfo = new String[clients.size()];
		  clientInfo = clients.toArray(clientInfo);
		  
	  }
	  
	  	//Technicians info "FirstName LastName TelNum"
	  public void allTechnicians() throws SQLException{
		  ArrayList<String> ids = new ArrayList<String>();
		  ArrayList<String> firstNames = new ArrayList<String>(); 
		  ArrayList<String> lastNames = new ArrayList<String>(); 
		  ArrayList<String> technicians = new ArrayList<String>();
		  
		  preparedStatement = connect.prepareStatement("SELECT technic_id,first_name,last_name FROM technicians ORDER BY first_name");
		  resultSet = preparedStatement.executeQuery();
		  
		  while (resultSet.next()) {
			  	ids.add(resultSet.getString(1));
		        firstNames.add(resultSet.getString(2));
		        lastNames.add(resultSet.getString(3));
		    }
		  
		  for(int index = 0 ; index < firstNames.size(); index ++){
			  technicians.add("ID:" + ids.get(index) + "     " + firstNames.get(index) + " " + lastNames.get(index));
		  }
		  techniciansInfo = new String[technicians.size()];
		  techniciansInfo = technicians.toArray(techniciansInfo);
		  
	  }
	  
	  public ResultSet techs() throws SQLException{
		  preparedStatement = connect.prepareStatement("SELECT * FROM technicians ORDER BY first_name");
		  resultSet = preparedStatement.executeQuery();
		  return resultSet;
	  }
	  
	  public ResultSet partsInfo() throws SQLException{
		  preparedStatement = connect.prepareStatement("SELECT part_id AS ID,name AS Name,quantity AS Quantity,price_per AS 'Part price' FROM parts ORDER BY part_id");
		  resultSet = preparedStatement.executeQuery();
		  return resultSet;
	  }
	  
	  public void showTasks(String id) throws SQLException{

		  String  technicId = id.substring(id.indexOf(":")+1,id.indexOf(" "));
		  ArrayList<String> ids = new ArrayList<String>();
		  ArrayList<String> types = new ArrayList<String>(); 
		  ArrayList<String> models = new ArrayList<String>(); 
		  ArrayList<String> components = new ArrayList<String>();
		  
		  preparedStatement = connect.prepareStatement("SELECT order_id,type,model FROM components " +
		  												"WHERE technic_id = " + technicId +" ORDER BY order_id");
		  resultSet = preparedStatement.executeQuery();
		  
		  while (resultSet.next()) {
			  	ids.add(resultSet.getString("order_id"));
		        types.add(resultSet.getString("type"));
		        models.add(resultSet.getString("model"));
		    }
		  for(int index = 0 ; index < ids.size(); index ++){
			  components.add("ID:" + ids.get(index) + "  " + types.get(index) + "  " + models.get(index));
		  }
		  
		  componentsInfo = new String[components.size()];
		  componentsInfo = components.toArray(componentsInfo);
		  
	  }
	  
	  public void componentInfo(String id) throws SQLException{
		  String  componentId = id.substring(id.indexOf(":")+1,id.indexOf("  "));
		  preparedStatement = connect.prepareStatement("CALL component_info (?)");
		  
	      // (id)
	      // Parameters start with 1asd
		  preparedStatement.setString(1,componentId);
		  resultSet = preparedStatement.executeQuery();
	      if(resultSet.next()){
	    	  componentOrderId = resultSet.getString("id");
	    	  componentType = resultSet.getString("type");
	    	  componentModel = resultSet.getString("model");
	    	  componentEntryDate = resultSet.getString("entry");
	    	  componentReadyDate = resultSet.getDate("ready");
	    	  
	    	  
	    	  componentClientFirstName = resultSet.getString("first_name");
	    	  componentClientLastName = resultSet.getString("last_name");
	    	  componentClientTelNum = resultSet.getString("tel");
	    	  componentStatus = resultSet.getString("status");
	    	  componentOrderPrice = resultSet.getFloat("price");
	    	  componentDiagnosticResults = resultSet.getString("result");

	      } 
	  }
	  
	  public void componentPartsInfo(String id) throws SQLException{
		  String  componentId = id.substring(id.indexOf(":")+1,id.indexOf("  "));
		  preparedStatement = connect.prepareStatement("CALL component_parts_info (?)");
		  
	      // (id)
	      // Parameters start with 1
		  preparedStatement.setString(1,componentId);
		  resultSet = preparedStatement.executeQuery();
	      if(resultSet.next()){
	    	  componentReadyDate = resultSet.getDate("ready");
	    	  componentStatus = resultSet.getString("status");
	    	  componentOrderPrice = resultSet.getFloat("price");
	    	  componentDiagnosticResults = resultSet.getString("result");

	      } 
	  }
	  
}