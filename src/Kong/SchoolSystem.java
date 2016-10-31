package Kong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * Dillon Kong
 * 31/10/16
 * class to manipulate data base
 */
public class SchoolSystem {

	public static long lastStudentNumber = 0;
	static ArrayList <Student> studRecs = new ArrayList<Student> ();


	public static void main (String[] args)
	{
		try {
			mainScreen(0,0,0,null);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** 
	 * Method that displays main screen and calls other methods depending on user input
	 * @param menu Menu option variable
	 * @param print Which student to print variable
	 * @param remove Which student to remove variable 
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	public static void mainScreen (int menu, int print, int remove, String search) throws InvalidInputException, IOException
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);


		System.out.println("Please choose one of the numbered options.");
		System.out.println("1. Enter new student \n2. Print student \n3. Print all students \n4. Remove student \n5. Sort students \n6. Save student information \n7. Read from data base \n8. Search student \n10. Quit");
		menu = scan.nextInt();

		//If user doesn't input a number
		while (!(menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5 || menu == 6 || menu == 7 ||menu == 10))
		{
			System.out.println("Please choose one of the numbered options.");
			menu = scan.nextInt();
		}

		if (menu == 1)//Add new Student
		{
			newStudent();
		}
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
			System.out.println("Which student would you like to remove? (#)");
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
				System.out.println("The database has less than 2 students inputted. 2 or more inputs are needed to sort.");
			}
			System.out.println("...COMPLETE...");
			mainScreen(0,0,0,null);

		}
		else if (menu == 6)
		{
			saveStudents();
		}
		else if (menu == 7)
		{
			loadFile();
		}
		else if (menu == 8)
		{
			System.out.println("Last name of student:");
			String searchStu = scan.nextLine();
			searchStudent(searchStu);
		}
		else if (menu == 10)
		{
			saveStudents();
			System.exit(0);
		}
		else	
		{
			System.out.println("Invalid input.");
			mainScreen(0,0,0,null);
		}

	}

	/**
	 * Method is called when user wants to create a new student profile
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	public static void newStudent () throws InvalidInputException, IOException
	{
		studRecs.trimToSize();
		studRecs.add(new Student());
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		String input = null;

		System.out.println("First Name:");		
		while(true)
		{
			input = scan.nextLine();
			if (Student.trySetFirstName(input))
			{
				studRecs.get(studRecs.size()-1).setFirstName(input);
				break;
			}
			else 
			{
				System.out.println("Invalid first name, cannot contain numbers or symbols. Please try again.");
			}
		}

		System.out.println("Last Name: ");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetLastName(input))
			{
				studRecs.get(studRecs.size() - 1).setLastName(input);
				break;
			}
			else 
			{
				System.out.println("Invalid last name, cannot contain numbers or symbols. Please try again.");
			}
		}

		System.out.println("Address: ");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetAddress(input))
			{
				studRecs.get(studRecs.size() - 1).setAddress(input);
				break;
			}
			else 
			{
				System.out.println("Invalid street address, ie. 243 Garden Ave. Please try again.");
			}
		}

		System.out.println("City: ");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetCity(input))
			{
				studRecs.get(studRecs.size() - 1).setCity(input);
				break;
			}
			else 
			{
				System.out.println("Invaid city, ie Toronto. Please try again.");
			}
		}

		System.out.println("Province: Full caps");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetProvince(makeProvince(input)))
			{
				studRecs.get(studRecs.size() - 1).setProvince(makeProvince(input));
				break;
			}
			else
			{
				System.out.println("Invaid province, ie ONTARIO. FULL CAPS. Please try again. ");
			}
		}

		System.out.println("Postalcode: ");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetPostalCode(input))
			{
				studRecs.get(studRecs.size() - 1).setPostalCode(input);
				break;
			}
			else 
			{
				System.out.println("Invalid postal code, ie. M6R 1J2. Please try again.");
			}
		}

		System.out.println("Phone Number: (641-123-4567) ");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetNumber(input))
			{
				studRecs.get(studRecs.size() - 1).setNumber(input);
				break;
			}
			else 
			{
				System.out.println("Invalid phone number. Please try again.");
			}
		}

		System.out.println("Birthday (DD/MM/YYYY):");
		while (true)
		{
			input = scan.nextLine();
			if (Student.trySetBirthday(input))
			{
				studRecs.get(studRecs.size() - 1).setBirthday(input);
				break;
			}
			else 
			{
				System.out.println("Invalid birthday, ie. DD/MM/YYYY. Please try again.");
			} 
		}
		System.out.println("COMPLETE");
		System.out.println(" ");
		mainScreen(0, 0, 0 ,null);
	}
	/**
	 * Method is called when user want to print a certain user
	 * @param stuNum
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	public static void printStudent (int stuNum) throws InvalidInputException, IOException
	{
		System.out.println("");
		System.out.println("___________________________________");
		System.out.println("Student Number: " + studRecs.get(stuNum - 1).getStudentNumber());
		System.out.println("First Name: " + studRecs.get(stuNum-1).getFirstName());
		System.out.println("Last Name: " + studRecs.get(stuNum-1).getLastName());
		System.out.println("Street Adress: " + studRecs.get(stuNum-1).getAddress());
		System.out.println("City: " + studRecs.get(stuNum-1).getCity());
		System.out.println("Province: " + studRecs.get(stuNum-1).getProvince());
		System.out.println("Postal Code: " + studRecs.get(stuNum-1).getPostalCode());
		System.out.println("Phone Number: " + studRecs.get(stuNum-1).getNumber());
		System.out.println("Birth Date: " + studRecs.get(stuNum-1).getBirthday());
		System.out.println("___________________________________");
		System.out.println("");
		mainScreen(0, 0, 0 ,null);
	}
	/** 
	 * Method is called when user wants to print all student profiles
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	public static void printAllStudents () throws InvalidInputException, IOException
	{
		for (int i = 0; i < studRecs.size(); i ++)
		{
			System.out.println("");
			System.out.println("___________________________________");
			System.out.println("Student Number: " + studRecs.get(i).getStudentNumber());
			System.out.println("First Name: " + studRecs.get(i).getFirstName());
			System.out.println("Last Name: " + studRecs.get(i).getLastName());
			System.out.println("Street Adress: " + studRecs.get(i).getAddress());
			System.out.println("City: " + studRecs.get(i).getCity());
			System.out.println("Province: " + studRecs.get(i).getProvince());
			System.out.println("Postal Code: " + studRecs.get(i).getPostalCode());
			System.out.println("Phone Number: " + studRecs.get(i).getNumber());
			System.out.println("Birth Date: " + studRecs.get(i).getBirthday());
			System.out.println("___________________________________");
			System.out.println("");
		}
		mainScreen(0, 0, 0,null);
	}
	/**
	 * Method is called when user wants to remove certain student profile
	 * @param removeStu The student the user wants to remove
	 * @throws InvalidInputException
	 * @throws IOException
	 */
	public static void removeStudent (int removeStu) throws InvalidInputException, IOException
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in); 
		System.out.println("Are you sure you'd like to remove?");
		String response = scan.nextLine();
		if (response.equalsIgnoreCase("yes"))
		{
			studRecs.remove(removeStu - 1);
			mainScreen(0, 0, 0,null);
		}
		else if (response.equalsIgnoreCase("no"))
			mainScreen(0, 0, 0,null);
		else 
			System.out.println("Are you sure you'd like to delete this student? (yes or no)");
	}
	/**
	 * Method is called when user wants to save all current student profiles to the java doc
	 * Separate java doc for the last used student number
	 * @throws IOException
	 */
	public static void saveStudents () throws IOException 
	{
		String fileName = "student_data_base.txt";
		String studentNumber = "student_number.txt";
		File file = new File(fileName);
		File stuFile = new File(studentNumber);

		if (!file.exists())
			file.createNewFile();
		if (!stuFile.exists())
			stuFile.createNewFile();

		FileOutputStream wfn = new FileOutputStream(fileName);
		PrintStream writeFile = new PrintStream(wfn);
		FileOutputStream wsn = new FileOutputStream(studentNumber);
		PrintStream writeStuNum = new PrintStream(wsn);

		writeStuNum.println(studRecs.get(studRecs.size() - 1).getStudentNumber());

		if (studRecs.size() > 0)
		{
			for (int i = 0; i < studRecs.size(); i++)
				writeFile.println(studRecs.get(i).toString());
		}
		try {
			System.out.println("...Succesfully saved...");
			mainScreen(0,0,0,null);
		} catch (InvalidInputException e) {
		}
		wfn.close();
		wsn.close();
	}
	/**
	 * Method is called when user wants to retrieve all the other student profiles and the last used student number
	 */
	@SuppressWarnings("null")
	public static void loadFile ()
	{
		ArrayList<Student> tempStudentList = null;
		try{
			String fileName = "student_data_base.txt";
			String studentNumber = "studentNumber.txt";
			File file = new File(fileName);
			File stuFile = new File(studentNumber);
			@SuppressWarnings("resource")
			BufferedReader readFile = new BufferedReader (new FileReader(fileName));// Student Information
			@SuppressWarnings("resource")
			BufferedReader readStuNum= new BufferedReader (new FileReader(stuFile));// Student Number

			if (!file.exists())
				file.createNewFile();
			if (!stuFile.exists())
				stuFile.createNewFile();

			//Read the last student number used
			String lastStuNum = readStuNum.readLine();
			lastStudentNumber = Long.parseLong(lastStuNum);
			//Read the student information corresponding to the student number 
			String studentInfo = readFile.readLine();
			String[] splitFile = studentInfo.split(" || ");


			for (int i = 0; i < studRecs.size() - 1; i++) 
			{
				studRecs.remove(i);
			}

			for (int i = 0; i < (lastStudentNumber - 324000000); i ++)
			{
				tempStudentList.add(new Student(splitFile[0], splitFile[1], splitFile[6], splitFile[3], splitFile[7], splitFile[5], makeProvince(splitFile[4]), splitFile[2]));
			}	
			studRecs = tempStudentList;
		}catch(IOException | InvalidInputException e){
		}
		try {
			System.out.println("...Succesfully loaded...");
			mainScreen(0,0,0, null);
		} catch (InvalidInputException e) {
		} catch (IOException e) {
		}
	}
	/**
	 * Method is called to make sure the inputed String is a province from the enum file with all the preset Canadian provinces.
	 * @param province
	 * @return
	 */
	public static enumProvince makeProvince (String province) 
	{
		switch (province.toLowerCase())
		//http://www.comeexplorecanada.com/abbreviations.php
		{//AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
		case "ab":
		case "alberta":
			return enumProvince.ALBERTA;
		case "bc":
		case "british columbia":
			return enumProvince.BRITISHCOMUMBIA;
		case "mb":
		case "manitoba":
			return enumProvince.MANITOBA;
		case "nb":
		case "new brunswick":
			return enumProvince.NEWBRUNSWICK;
		case "nl":
		case "newfoundland and labrador":
		case "newfoundland":
			return enumProvince.NEWFOUNDLANDANDLABRADOR;
		case "ns":
		case "nova socia":
			return enumProvince.NOVASCOTIA;
		case "nt":
		case "northwest territorries":
			return enumProvince.NEWFOUNDLANDANDLABRADOR;
		case "nu":
		case "nunavut":
			return enumProvince.NUNAVUT;
		case "on":
		case "ontario":
			return enumProvince.ONTARIO;
		case "pe":
		case "pei":	
		case "prince edward island":
			return enumProvince.PRINCEEDWARDISLAND;
		case "qu":
		case "quebec":
			return enumProvince.QUEBEC;
		case "sk":
		case "saskatchewan":
			return enumProvince.SASKATCHEWAN;
		case "yt":
		case "yukon":
			return enumProvince.YUKON;
		default:
			try {

				throw new InvalidInputException("Invalid province");
			} catch (InvalidInputException e) {
			}
			return null;
		}
	}
	/**
	 *Method is called in Student.setStudentNumber to return the last used student number from the file
	 * @return
	 */
	public static long getLastStudentNumber ()
	{
		return lastStudentNumber;
	}
	public static void searchStudent(String findStudent)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);

		for (int i = 0; i < studRecs.size(); i ++)
		{
			if (studRecs.get(i).getLastName().equalsIgnoreCase(findStudent))
			{
				System.out.println("...FOUND...");
				System.out.println("Would you like to \n1. Print this student \n2. Delete this student \n3. Return to home screen");
				int choice = scan.nextInt();
				if (choice == 1)
				{
					try {
						printStudent(i);
					} catch (InvalidInputException e) {
					} catch (IOException e) {
					}
				}
				else if (choice == 2)
				{
					try {
						removeStudent(i);
					} catch (InvalidInputException e) {
					} catch (IOException e) {
					}
				}
				else if (choice == 3)
				{
					try {
						mainScreen(0,0,0,null);
					} catch (InvalidInputException e) {
					} catch (IOException e) {
					}
				}
			}
		}
	}
}