package Kong;

public class Student {
	/*Dillon Kong
	 * 31/10/16
	 * Class that holds getters and setters
	 */
	public static long studentNumberConstant = 324000000;// Base starting student number
	private String firstName, lastName, streetAddress, city, postalCode, birthDate, phoneNumber;
	enumProvince province;
	private long studentNumber = studentNumberConstant;

	/**
	 * Construct for if no information is inputed. Sets all variables to blank
	 * @throws InvalidInputException
	 */
	public Student() throws InvalidInputException 
	{
		try {
			setBirthday("");
		} catch (InvalidInputException e) {
		}
		setCity("");
		setFirstName("");
		setLastName("");
		setNumber("");
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {
		}
		setProvince(enumProvince.NONE);
		setAddress("");
		setStudentNumber (++studentNumber);
	}
	/**
	 * Construct for if all the variables are filled
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param city
	 * @param phoneNumber
	 * @param postalCode
	 * @param province
	 * @param streetAddress
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birthDate, String city, String phoneNumber, String postalCode, enumProvince province, String streetAddress) throws InvalidInputException 
	{
		try{
			setBirthday(birthDate);
			setFirstName(firstName);
			setLastName(lastName);
			setCity(city);
			setProvince(province);
			setNumber(phoneNumber);
			setPostalCode(postalCode);
			setAddress(streetAddress);
		} catch (InvalidInputException e) {
		}
		setStudentNumber (++studentNumber);
	}
	//////////////////////////////////////////////////////////Setters and Getters////////////////////////////////////
	/**

	 * Method is called to set the student number 
	 * @param studentNmbr
	 */
	public void setStudentNumber (long studentNmbr)
	{
		if (SchoolSystem.getLastStudentNumber() > studentNumberConstant)
		{
			studentNmbr = SchoolSystem.getLastStudentNumber() + 1;
		}
		else 
		{
			studentNumber = studentNumberConstant ++;
		}
		this.studentNumber = studentNmbr;

	}
	/**
	 * Method is called to return student number is needed
	 * @return
	 */
	public long getStudentNumber ()
	{
		return studentNumber;
	}
	/**
	 * Method is called to set first name if its correct
	 * @param fName
	 */
	public void setFirstName (String fName){

		this.firstName = fName;
	}
	/**
	 * Method is called to return first name is needed
	 * @return
	 */
	public String getFirstName (){
		return this.firstName;
	}
	/**
	 * Method is called to set last name if its correct
	 * @param lName
	 */
	public void setLastName (String lName){
		this.lastName = lName;
	}
	/**
	 * Method is called to return last name is needed
	 * @return
	 */
	public String getLastName (){
		return this.lastName;
	}
	/**
	 * Method is called to set street address if its correct
	 * @param address
	 */
	public void setAddress (String address)
	{
		this.streetAddress = address;
	}
	/**
	 * Method is called to return street address is needed
	 * @return
	 */
	public String getAddress (){
		return this.streetAddress;
	}
	/**
	 * Method is called to set city if its correct
	 * @param cName
	 */
	public void setCity (String cName){
		this.city = cName;
	}
	/**
	 * Method is called to return city is needed
	 * @return
	 */
	public String getCity (){
		return this.city;
	}
	/**
	 * Method is called to set province if its correct
	 * @param pName
	 */
	public void setProvince (enumProvince pName){
		this.province = pName;
	}
	/**
	 * Method is called to return province is needed
	 * @return
	 */
	public enumProvince getProvince (){
		return this.province;
	}
	/**
	 * Method is called to set postal code if its correct
	 * @param pCode
	 * @throws InvalidInputException
	 */
	public void setPostalCode (String pCode)throws InvalidInputException
	{
		this.postalCode = pCode;

	}
	/**
	 * Method is called to return postal code if needed
	 * @return
	 */
	public String getPostalCode (){
		return this.postalCode;
	}
	/**
	 * Method is called to set phone number if its correct
	 * @param phoneNum
	 */
	public void setNumber (String phoneNum){
		this.phoneNumber = phoneNum;
	}
	/**
	 * Method is called to return phone number if needed
	 * @return
	 */
	public String getNumber () {
		return this.phoneNumber;
	}
	/**
	 * Method is called to set birthday if its correct
	 * @param bDay
	 * @throws InvalidInputException
	 */
	public void setBirthday (String bDay) throws InvalidInputException
	{
		this.birthDate = bDay;
	}
	/**
	 * Method is called to return birthday if needed
	 * @return
	 */
	public String getBirthday (){
		return this.birthDate;
	}
	////////////////////////////////////////////////////trySet methods////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Method is called to make sure Street Address is correct
	 * @param address
	 * @return
	 */
	public static Boolean trySetAddress(String address) 
	{
		char [] charStrNum = address.split(" ") [0].toCharArray();

		for (int i = 0; i < charStrNum.length; i ++)
		{
			if (!Character.isDigit(charStrNum[i]))
			{
				return false;
			}
		}


		return true;
	}
	/**
	 * Method is called to make sure postal code is correct
	 * @param pCode
	 * @return
	 */
	public static Boolean trySetPostalCode (String pCode)
	{
		if (pCode.length() == 6)
		{
			if (!Character.isLetter(pCode.charAt(0)))
			{
				if (!Character.isLetter(pCode.charAt(2)))
				{
					if (!Character.isLetter(pCode.charAt(4)))
					{
						return false;
					}
				}//M6R1J2
			}

			if (!Character.isDigit(pCode.charAt(1)))
			{
				if (!Character.isDigit(pCode.charAt(3)))
				{
					if (!Character.isDigit(pCode.charAt(5)))
					{
						return false;
					}
				}//M6R 1J2
			}
		}

		else if (pCode.length() == 7)
		{
			if (!Character.isLetter(pCode.charAt(0)))
			{
				if (!Character.isLetter(pCode.charAt(2)))
				{
					if (!Character.isLetter(pCode.charAt(5)))
					{
						return false;
					}
				}//M6R1J2
			}

			if (!Character.isDigit(pCode.charAt(1)))
			{
				if (!Character.isDigit(pCode.charAt(4)))
				{
					if (!Character.isDigit(pCode.charAt(6)))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	/**
	 * Method is called to make sure phone number is correct
	 * @param phoneNum
	 * @return
	 */
	public static Boolean trySetNumber (String phoneNum)
	{
		char [] charPhoneNumber = phoneNum.split("-") [0].toCharArray();
		if (! Character.isDigit(charPhoneNumber[0]) && Character.isDigit(charPhoneNumber[1]) && Character.isDigit(charPhoneNumber[2]) && charPhoneNumber.length > 12)
		{
			return false;
		}
		return true;
	}
	/**
	 * Method is called to make sure birthday is correct
	 * @param bDay
	 * @return
	 */
	public static Boolean trySetBirthday (String bDay)
	{
		char [] charBDay= bDay.split("/")[0].toCharArray();

		if (! Character.isDigit(charBDay [0]) &&  Character.isDigit(charBDay [1]) &&  Character.isDigit(charBDay[2]))
		{
			return false;
		}

		return true;
	}
	/**
	 * Method is called to make sure province is correct
	 * @param province
	 * @return
	 * @throws InvalidInputException
	 */
	public static Boolean trySetProvince (enumProvince province) throws InvalidInputException 
	{
		//http://www.comeexplorecanada.com/abbreviations.php
		try{
			if (province.equals(enumProvince.ALBERTA) || province.equals(enumProvince.BRITISHCOMUMBIA) || province.equals(enumProvince.MANITOBA) || province.equals(enumProvince.NEWBRUNSWICK) || province.equals(enumProvince.NEWFOUNDLANDANDLABRADOR) || province.equals(enumProvince.NORTHWESTTERRITORIES) || province.equals(enumProvince.NOVASCOTIA) || province.equals(enumProvince.NUNAVUT) || province.equals(enumProvince.ONTARIO) || province.equals(enumProvince.PRINCEEDWARDISLAND) || province.equals(enumProvince.QUEBEC) || province.equals(enumProvince.SASKATCHEWAN) || province.equals(enumProvince.YUKON)) {
				return true;
			}
		}catch (NullPointerException e) {
		}
		return false;
	}
	/**
	 * Method is called to make sure first name is correct
	 * @param fName
	 * @return
	 */
	public static Boolean trySetFirstName (String fName)
	{
		char[]  charFName = fName.toCharArray();
		if (!Character.isLetter(charFName [0] ))
		{
			return false;
		}

		return true;
	}
	/**
	 * Method is called to make sure last name is correct
	 * @param lName
	 * @return
	 */
	public static Boolean trySetLastName (String lName)
	{
		char [] charLName = lName.toCharArray();
		if (! Character.isLetter(charLName[0]))
		{
			return false;
		}

		return true;
	}
	/**
	 * Method is called to make sure city is correct
	 */
	public static Boolean trySetCity (String cName)
	{
		char [] charCName = cName.toCharArray();
		if (! Character.isLetter(charCName[0]))
		{
			return false;
		}
		return true;
	}
	/////////////////////////////////////////////////////Other//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Puts all student information into a single line
	 */
	public String toString()
	{
		return  firstName + " || " +  lastName + " || " + streetAddress + " || " + city + " || " + province + " || " + postalCode + " || " + birthDate + " || " + phoneNumber;
	}
	/**
	 * Makes sure the temp student equals the actual student
	 * @param tempStudent
	 * @return
	 */
	public boolean equals(Student tempStudent)
	{
		return (this.getStudentNumber() == tempStudent.getStudentNumber());
	}
	/**
	 * Compares first and last name for the student and the temp student
	 * @param student
	 * @return
	 */
	public int compareTo(Student student) {
		Student tempStudent = (Student) student;

		if (this.getLastName().compareToIgnoreCase(tempStudent.getLastName()) == 0)
		{
			if (this.getFirstName().compareToIgnoreCase(tempStudent.getFirstName()) == 0)
			{
				return 0;
			}
			else if (this.getFirstName().compareToIgnoreCase(tempStudent.getFirstName()) > 0)
			{
				return 1;
			}
			else 
			{
				return -1;
			}
		}
		else if (this.getLastName().compareToIgnoreCase(tempStudent.getLastName()) > 0)
		{
			return 1;
		}
		else {
			return -1;
		}
	}
}