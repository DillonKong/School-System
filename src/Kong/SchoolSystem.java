package Kong;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
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



		System.out.println("1. Enter new student \n2. Print student \n3. Print all students \n4. Remove student \n5. Sort students \n6. Save student information \n7. Read from data base \n10. Quit");
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
			if (studRecs.size() >= 2)
			{
				for (int i = 0; i < studRecs.size() - 1; i ++)
				{
					for (int j = 0; j < studRecs.size() - 1; j ++)
					{
						if (studRecs.get(j).compareTo(studRecs.get(j + 1)) > 0)
						{
							Collections.swap(studRecs,  j,  j + 1);
						}
					}
				}

			}
			else 
			{
				System.out.println("The data base has less than 2 students inputted. 2 or more inputs are needed to sort.");
			}
		}
		else if (menu == 6)
		{
			saveStudents();
		}
		else if (menu == 7)
		{

		}
		else if (menu == 8)
		{

		}
		else if (menu == 9)
		{

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
		while (!Student.trySetBirthday(input))
		{
			input = scan.nextLine(); 
		}
		bDay = input;

		studRecs.add(new Student (fName, lName, bDay, city, phoneNumber, postalCode, province, address));

		System.out.println("COMPLETE");
		mainScreen(0, 0, 0);
	}

	public static void printStudent (int stuNum) throws InvalidInputException, IOException
	{
		System.out.println("Student id" + studRecs.get(stuNum - 1).getStudentId());
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

	public static void printAllStudents () throws InvalidInputException, IOException
	{
		//File f = new File ("student_data_base");
		//	BufferedReader fbr = new BufferedReader (new FileReader (f));

		for (int i = 0; i < studRecs.size(); i ++)
		{
			System.out.println("First Name: " + studRecs.get(i).getFirstName());
			System.out.println("Last Name: " + studRecs.get(i).getLastName());
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
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in); 
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("yes"))
		{
			studRecs.remove(removeStu - 1);
			mainScreen(0, 0, 0);
		}
		else if (response.equalsIgnoreCase("no"))
			mainScreen(0, 0, 0);
		else 
			System.out.println("Are you sure you'd like to delete this student? (yes or no)");
	}

	public static void saveStudents () throws IOException 
	{
		try 
		{
			File f = new File ("student_data_base");
			FileOutputStream fileOutputStream = null;

			fileOutputStream = new FileOutputStream (f);

			@SuppressWarnings("resource")
			PrintStream fps = new PrintStream (fileOutputStream);

			if (!f.exists())
				f.createNewFile();

			if (studRecs.size() > 0)
			{
				for (int i = 0; i < studRecs.size() - 1; i ++)
				{
					fps.println(studRecs.get(i).getStudentId() + " / ");
					fps.print(studRecs.get(i).toString() + " / ");
				}
				fps.println(studRecs.get(studRecs.size() - 1).getStudentId());
			}
			else 
			{
				System.out.println("There is no students inputted to save.");
			}
		}catch (IOException e){

		}
		try {
			mainScreen(0, 0, 0);
		} catch (InvalidInputException e) {
		}
	}
}