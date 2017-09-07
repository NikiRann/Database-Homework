import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class database {
	public static String url = "jdbc:postgresql://localhost/university";
	
	public static Properties props = new Properties();

	public static void init() throws SQLException
	{
		props.setProperty("user", "postgres");
		props.setProperty("password", "123456");
	}
	public static void createTable() throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			conn.prepareStatement("DROP TABLE STUDENTS").executeUpdate();
			PreparedStatement prepareStatement = conn.prepareStatement("CREATE TABLE STUDENTS(FacultyNumber INT PRIMARY KEY, FirstName VARCHAR(50) NOT NULL, LastName VARCHAR(50) NOT NULL);");
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}		
	}
	public static void addPerson(int facultyNumber, String firstName, String lastName) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO STUDENTS(FacultyNumber, FirstName, LastName) VALUES(" + Integer.toString(facultyNumber) + ",'" + firstName + "','" + lastName + "');");
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}
	public static void deletePerson(int facultyNumber) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM STUDENTS WHERE FacultyNumber=" + facultyNumber);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}
	public static void showPeople(String condition) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM STUDENTS WHERE " + condition);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()){
				System.out.println(executeQuery.getInt(1) + "|" + executeQuery.getString(2) + "|" + executeQuery.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}	
}
