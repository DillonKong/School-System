package Kong;

public class Student {

	static long stuId = 324000000;
	private String firstName, lastName, streetAddress, city, postalCode, birthDate, stuNum, phoneNumber;
	enumProvince province;

	public Student() 
	{

	}
	public Student(String firstName, String lastName, String birthDate, String city, String phoneNumber, String postalCode, String province, String streetAddress) throws InvalidInputException 
	{
		setStudentId (stuId);
		trySetBirthday(birthDate);
		trySetFirstName(firstName);
		trySetLastName(lastName);
		setCity("");
		trySetProvince(province);
		trySetNumber(phoneNumber);
		trySetPostalCode(postalCode);
		trySetAddress(streetAddress);
	}
	public void setStudentId (long stuId)
	{
		Student.stuId = stuId ++;
	}
	public long getStudentId ()
	{
		return Student.stuId;
	}

	public void setFirstName (String fName){
		if (!trySetFirstName (fName))
		{
			try {
				throw new InvalidInputException("Invalid First Name. Cannot contain numbers or symbols");
			} catch (InvalidInputException e) {
			}
		}
		this.firstName = fName;
	}
	public String getFirstName (){
		return this.firstName;
	}

	public void setLastName (String lName){
		if (!trySetLastName (lName))
		{
			try{
				throw new InvalidInputException("INvalid last name. Cannot contain numbers or symbols");
			}catch (InvalidInputException e){	
			}
		}
		this.lastName = lName;
	}
	public String getLastName (){
		return this.lastName;
	}

	public void setAddress (String address)
	{
		if (!trySetAddress (address))
		{
			try{
				throw new InvalidInputException ("Invalid street Address.");
			}catch (InvalidInputException e){
			}
		}

		this.streetAddress = address;
	}
	public String getAddress (){
		return this.streetAddress;
	}

	public void setCity (String cName){
		this.city = cName;
	}
	public String getCity (){
		return this.city;
	}

	public void setProvince (String pName){
		
		this.province = trySetProvince(pName);
	}
	public enumProvince getProvince (){
		return this.province;
	}

	public void setPostalCode (String pCode)throws InvalidInputException
	{
		if (trySetPostalCode (pCode))
		{
			throw new InvalidInputException("Invalid Postal Code.");
		}
		this.postalCode = pCode;
	}
	public String getPostalCode (){
		return this.postalCode;
	}

	public void setNumber (String phoneNum){
		this.phoneNumber = phoneNum;
	}
	public String getNumber () {
		return this.phoneNumber;
	}

	public void setBirthday (String bDay) throws InvalidInputException
	{
		if (!trySetBirthday(bDay))
		{
			throw new InvalidInputException("Invalid Birth Date.");
		}
		this.birthDate = bDay;
	}
	public String getBirthday (){
		return this.birthDate;
	}
	////////////////////////////////////////////////////trySet////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	public static Boolean trySetNumber (String phoneNum)
	{
		char [] charPhoneNumber = phoneNum.split("-") [0].toCharArray();
		if (! Character.isDigit(charPhoneNumber[0]) && Character.isDigit(charPhoneNumber[1]) && Character.isDigit(charPhoneNumber[2]) && charPhoneNumber.length > 12)
		{
			return false;
		}
		return true;
	}
	public static Boolean trySetBirthday (String bDay)
	{
		char [] charBDay= bDay.split("/")[0].toCharArray();

		if (! Character.isDigit(charBDay [0]) &&  Character.isDigit(charBDay [1]) &&  Character.isDigit(charBDay[2]))
		{
			return false;
		}

		return true;
	}
	public Boolean trySetStuNum (String sNum)
	{
		char [] charSNum = sNum.toCharArray();
		if (! Character.isDigit(charSNum [0]) || sNum.length() > 9)
		{
			return false;
		}
		return true;
	}

	public enumProvince trySetProvince (String province) 
	{
		province = province.toLowerCase();

		switch (province)
		//http://www.comeexplorecanada.com/abbreviations.php
		{//AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
		case "ab":
		case "alberta":
			return enumProvince.AB;
		case "bc":
		case "british columbia":
			return enumProvince.BC;
		case "mb":
		case "manitoba":
			return enumProvince.MB;
		case "nb":
		case "new brunswick":
			return enumProvince.NB;
		case "nl":
		case "newfoundland and labrador":
		case "newfoundland":
			return enumProvince.NL;
		case "ns":
		case "nova socia":
			return enumProvince.NS;
		case "nt":
		case "northwest territorries":
			return enumProvince.NT;
		case "nu":
		case "nunavut":
			return enumProvince.NU;
		case "on":
		case "ontario":
			return enumProvince.ON;
		case "pe":
		case "pei":	
		case "prince edward island":
			return enumProvince.PE;
		case "qu":
		case "quebec":
			return enumProvince.QC;
		case "sk":
		case "saskatchewan":
			return enumProvince.SK;
		case "yt":
		case "yukon":
			return enumProvince.YT;
		default:
			try {

				throw new InvalidInputException("Invalid province.");
			} catch (InvalidInputException e) {
				return null;
			}
		}
	}
	public Boolean trySetFirstName (String fName)
	{
		char [] charFName = fName.toCharArray();
		if (! Character.isLetter(charFName [0]))
		{
			return false;
		}
		return true;
	}

	public Boolean trySetLastName (String lName)
	{
		char [] charLName = lName.toCharArray();
		if (! Character.isLetter(charLName[0]))
		{
			return false;
		}
		return true;
	}

	/////////////////////////////////////////////////////trySet//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public String toString()
	{
		return firstName + " / " +  lastName + " / " + streetAddress + " / " + city + " / " + province + " / " + postalCode + " / " + birthDate + " / " + stuNum + " / " + phoneNumber;
	}
	public boolean equals(Student tempStudent)
	{
		return (this.getStudentId() == tempStudent.getStudentId());
	}

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