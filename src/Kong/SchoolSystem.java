package Kong;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {

	static ArrayList <Student> studRecs = new ArrayList<Student> ();
	static Scanner scan = new Scanner (System.in);

	public static void main (String [] args)
	{
		int mainMenu = 0, printStuNum = 0, removeStu = 0;
		mainScreen (mainMenu, printStuNum, removeStu);
	}

	public static void mainScreen (int menu, int print, int remove)
	{
		System.out.println("1. Enter new student \n2. Print student \n3. Print all students \n4. Remove student \n10. Quit");
		menu = scan.nextInt();
		scan.nextLine();

		if (menu == 1)//Add new student
			newStudent();

		else if (menu == 2)// Print individual student
		{
			System.out.println("Which student would you like to print? (#)");
			print= scan.nextInt();
			printStudent(print); 
		}
		else if (menu == 3)// Print all students	
			printAllStudents();		

		else if (menu == 4) // Remove student
		{
			System.out.println("WHich student would you like to remove? (#)");
			remove = scan.nextInt();
			removeStudent(remove);
		}
		else if (menu == 10)
			System.exit(0);
	}

	public static void newStudent ()
	{
		String input;
		studRecs.add(new Student ());
		System.out.println("First Name:");
		studRecs.get(studRecs.size() - 1).setFirstName(scan.nextLine());

		System.out.println("Last Name: ");
		studRecs.get(studRecs.size() - 1).setLastName(scan.nextLine());

		System.out.println("Student Number: (12345679)");
		input = scan.nextLine();
		while (!studRecs.get(studRecs.size()-1).trySetStuNum(input))
		{
			System.out.println("Please input a valid student number");
			input = scan.nextLine();
		}
		studRecs.get(studRecs.size() - 1).setStuNum(input);

		System.out.println("Address: ");
		input = scan.nextLine();
		while (!studRecs.get(studRecs.size()-1).trySetAddress(input))
		{
			System.out.println("Please print an address");
			input = scan.nextLine();
		}
		studRecs.get(studRecs.size() - 1).setAddress(input);

		System.out.println("City: ");
		studRecs.get(studRecs.size() - 1).setCity(scan.nextLine());

		System.out.println("Province: ");
		studRecs.get(studRecs.size() - 1).setProvince(scan.nextLine());

		System.out.println("Postalcode: ");
		input = scan.nextLine();
		while (!studRecs.get(studRecs.size()-1).trySetPostalCode(input))
		{
			System.out.println("Please print a postal code");
			input = scan.nextLine(); 
		}
		studRecs.get(studRecs.size() - 1).setPostalCode(input);

		System.out.println("Phone Number: (641-123-4567) ");
		input = scan.nextLine();
		while (!studRecs.get(studRecs.size()-1).trySetNumber(input))
		{
			System.out.println("Please print a postal code");
			input = scan.nextLine(); 
		}
		studRecs.get(studRecs.size() - 1).setNumber(input);

		System.out.println("Birthday (DD/MM/YYYY): ");
		input = scan.nextLine();
		while (!studRecs.get(studRecs.size()-1).trySetBirthdate(input))
		{
			System.out.println("Please print a Birthday");
			input = scan.nextLine(); 
		}
		studRecs.get(studRecs.size() - 1).setBirthday(input);

		System.out.println("COMPLETE");
		mainScreen(0, 0, 0);
	}

	public static void printStudent (int stuNum)
	{
		System.out.println("Student #" + stuNum);
		System.out.println("First Name: " + studRecs.get(stuNum-1).getFirstName());
		System.out.println("Last Name: " + studRecs.get(stuNum-1).getLastName());
		System.out.println("Student Number: " + studRecs.get(stuNum-1).getStuNum());
		System.out.println("Street Adress: " + studRecs.get(stuNum-1).getAddress());
		System.out.println("City: " + studRecs.get(stuNum-1).getCity());
		System.out.println("Province: " + studRecs.get(stuNum-1).getProvince());
		System.out.println("Postal Code: " + studRecs.get(stuNum-1).getPostalCode());
		System.out.println("Phone Number: " + studRecs.get(stuNum-1).getNumber());
		System.out.println("Birth Date: " + studRecs.get(stuNum-1).getBirthday());
		mainScreen(0, 0, 0);
	}
	public static void printAllStudents ()
	{
		for (int i = 0; i < studRecs.size(); i ++)
		{
			System.out.println("Student #" + i + 1);
			System.out.println("First Name: " + studRecs.get(i).getFirstName());
			System.out.println("Last Name: " + studRecs.get(i).getLastName());
			System.out.println("Student Number: " + studRecs.get(i).getStuNum());
			System.out.println("Street Adress: " + studRecs.get(i).getAddress());
			System.out.println("City: " + studRecs.get(i).getCity());
			System.out.println("Province: " + studRecs.get(i).getProvince());
			System.out.println("Postal Code: " + studRecs.get(i).getPostalCode());
			System.out.println("Phone Number: " + studRecs.get(i).getNumber());
			System.out.println("Birth Date: " + studRecs.get(i).getBirthday());
			System.out.println(" ");
		}
		mainScreen(0, 0, 0);
	}
	public static void removeStudent (int removeStu)
	{
		studRecs.remove(removeStu - 1);
		mainScreen(0, 0, 0);
	}
}