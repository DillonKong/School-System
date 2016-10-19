package Kong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {

	static ArrayList <Student> studRecs = new ArrayList<Student> ();

	public static void main (String [] args) throws InvalidInputException, IOException
	{
		int mainMenu = 0, printStuNum = 0, removeStu = 0;
		mainScreen (mainMenu, printStuNum, removeStu);
	}

	public static void mainScreen (int menu, int print, int remove) throws InvalidInputException, IOException
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("1. Enter new student \n2. Print student \n3. Print all students \n4. Remove student  \n5. Save \n10. Quit");
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
		else if (menu == 5)
		{
			saveStudents();
		}
		else if (menu == 10)
			System.exit(0);
	}

	public static void newStudent () throws InvalidInputException, IOException
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		String input, fName, lName, address, city, province, postalCode, phoneNumber, bDay;
		
		studRecs.trimToSize();
		
		System.out.println("First Name:");		
		fName = scan.nextLine();

		System.out.println("Last Name: ");
		lName = scan.nextLine();

		System.out.println("Address: ");
		input = scan.nextLine();
		while (!Student.trySetAddress (input))
		{
			input = scan.nextLine();
		}
		address = input;

		System.out.println("City: ");
		city = scan.nextLine();

		System.out.println("Province: ");
		province = scan.nextLine();

		System.out.println("Postalcode: ");
		input = scan.nextLine();
		while (!Student.trySetPostalCode(input))
		{
			input = scan.nextLine(); 
		}
		postalCode = input;

		System.out.println("Phone Number: (641-123-4567) ");
		input = scan.nextLine();
		while (!Student.trySetNumber(input))
		{
			input = scan.nextLine();
		}
		phoneNumber = input;

		System.out.println("Birthday (DD/MM/YYYY): ");
		input = scan.nextLine();
		while (Student.trySetBirthdate(input))
		{
			input = scan.nextLine(); 
		}
		bDay = input;

		studRecs.add(new Student (fName, lName, bDay,  city, phoneNumber, postalCode, province, address));

		System.out.println("COMPLETE");
		mainScreen(0, 0, 0);
	}

	public static void printStudent (int stuNum) throws InvalidInputException, IOException
	{
		System.out.println("Student id" + studRecs.get(stuNum - 1).getStudentId());
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
	public static void printAllStudents () throws InvalidInputException, IOException
	{
		File f = new File ("student_data_base");
		BufferedReader fbr = new BufferedReader (new FileReader (f));
		
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
	public static void removeStudent (int removeStu) throws InvalidInputException, IOException
	{
		studRecs.remove(removeStu - 1);
		mainScreen(0, 0, 0);
	}

	public static void saveStudents () throws IOException
	{
		File f = new File ("student_data_base");
		FileOutputStream fileOutputStream = new FileOutputStream (f);
		@SuppressWarnings("resource")
		PrintStream fps = new PrintStream (fileOutputStream);

		if (!f.exists())
		{
			f.createNewFile();
		}
		
		for (int i = 0; i < studRecs.size() - 1; i ++)
		{
			fps.println(studRecs.get(i).getStudentId() + " / ");
			fps.print(studRecs.get(i).toString() + " / ");
		}
		fps.println(studRecs.get(studRecs.size() - 1).getStudentId());
	}
}