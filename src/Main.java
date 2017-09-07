import java.sql.SQLException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws SQLException
	{
		Scanner s = new Scanner(System.in);
		database.init();
		
		//database.createTable(); Works
		
		System.out.println("Use 'Add' for adding a person. Example: Add [FacultyNumber] [FirstName] [LastName]");
		System.out.println("Use 'Delete' for deleting a person. Example: Delete [FacultyNumber]");
		System.out.println("Use 'Show' for showing a person(or people). Example: Show FacultyNumber=37");
		System.out.println("Use 'Exit' to exit the program");
		
		while (true)
		{
			String input = s.nextLine();
			
			String[] splited = input.split(" ");
			
			if (splited[0].equals("Add"))
			{
				database.addPerson(Integer.parseInt(splited[1]), splited[2], splited[3]);
			}
			if (splited[0].equals("Delete"))
			{
				database.deletePerson(Integer.parseInt(splited[1]));
			}
			if (splited[0].equals("Show"))
			{
				database.showPeople(splited[1]);
			}
			if (splited[0].equals("Exit"))
			{
				break;
			}
			
		}
	}
}
