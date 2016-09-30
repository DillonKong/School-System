package Kong;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {
	
	static ArrayList <Student> studRecs = new ArrayList<Student> ();
	static Scanner scan = new Scanner (System.in);
	
	
	public static void main (String [] args)
	{
		int mainMenu = 0, printStuNum = 0, choices = 0;
		mainScreen (mainMenu, printStuNum, choices);
	}

	public static void mainScreen (int menu, int get, int remove)
	{
		System.out.println("1. Enter new student \n2. Print student \n3. Print all students \n10. Quit");
		menu = scan.nextInt();

		if (menu == 1)
		{
			studRecs.add(new Student ());
			newStudent();
		}
		else if (menu == 2)
		{
			System.out.println("Which student would you like to print? (#)");
			get = scan.nextInt();
			printStudent(get);
		}
		else if (menu == 3)
		{
			System.out.println("Which student would you like to remove from the system?");
			remove = scan.nextInt();
			studRecs.remove(remove + 1);
		}
			
	}
	public static void newStudent ()
	{
		Student stnt = new Student();
		System.out.println("First Name:");
		stnt.setFirstName(scan.nextLine());
		System.out.println("Last Name: ");
		stnt.setLastName(scan.nextLine());
		System.out.println("Address: ");
		stnt.setAddress(scan.nextLine());
		System.out.println("City: ");
		stnt.setCity(scan.nextLine());
		System.out.println("Province: ");
		stnt.setProvince(scan.nextLine());
		System.out.println("Postalcode: ");
		stnt.setPostalCode(scan.nextLine());
		System.out.println("Phone Number: ");
		stnt.setNumber(scan.nextLine());
		System.out.println("Birthday (DD/MM/YYYY): ");
		stnt.setBirthday(scan.nextLine());
		System.out.println("COMPLETE");
		mainScreen(0, 0, 0);

	}
	
	public static void printStudent (int stuNum)
	{
		System.out.println("First Name: " + studRecs.get(stuNum-1).getFirstName());
		System.out.println("Last Name: " + studRecs.get(stuNum-1).getLastName());
		System.out.println("Street Adress: " + studRecs.get(stuNum-1).getAddress());
		System.out.println("City: " + studRecs.get(stuNum-1).getCity());
		System.out.println("Province: " + studRecs.get(stuNum-1).getProvince());
		System.out.println("Postal Code: " + studRecs.get(stuNum-1).getPostalCode());
		System.out.println("Phone Number: " + studRecs.get(stuNum-1).getNumber());
		System.out.println("Birth Date: " + studRecs.get(stuNum-1).getBirthday());
		mainScreen(0, 0, 0);
	}

}
