import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class database {
	public static String url = "jdbc:postgresql://localhost/university";
	
	public static Properties props = new Properties();

	public static void main(String[] args) throws SQLException
	{
		props.setProperty("user", "postgres");
		props.setProperty("password", "232038");
	}
	public void addPerson(int facultyNumber, String firstName, String lastName) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO STUDENTS(ID, FirstName, LastName) VALUES(" + facultyNumber + "," + firstName + "," + lastName);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}
	public void deltePerson(int facultyNumber) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM STUDENTS WHERE ID=" + facultyNumber);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}
	public void showPeople(String condition) throws SQLException
	{
		Connection conn = DriverManager.getConnection(url, props);
		try {
			
			PreparedStatement prepareStatement = conn.prepareStatement("SHOW * FROM STUDENTS WHERE " + condition);
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
