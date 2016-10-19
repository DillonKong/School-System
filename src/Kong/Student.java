package Kong;

public class Student {

	static long stuId = 324000000;
	private String firstName, lastName, streetAddress, city, province, postalCode, birthDate, stuNum, phoneNumber;

	public Student() 
	{
		
	}
	public Student(String firstName, String lastName, String birthDate, String city, String phoneNumber, String postalCode, String province, String streetAddress) throws InvalidInputException 
	{
		setStudentId (stuId);
		setBirthday(birthDate);
		setFirstName("");
		setLastName("");
		setCity("");
		setNumber(phoneNumber);
		setPostalCode(postalCode);
		setAddress(streetAddress);
	}

	public void setStudentId (long stuId)
	{
		Student.stuId = stuId ++;
		
	}
	public String getStudentId ()
	{
		return this.getStudentId();
	}
	
	public void setFirstName (String fName){
		this.firstName = fName;
	}
	public String getFirstName (){
		return this.firstName;
	}

	public void setLastName (String lName){
		this.lastName = lName;
	}
	public String getLastName (){
		return this.lastName;
	}

	public void setAddress (String address)
	{
		if (trySetAddress (address))
		{
			System.out.println("Input another address");
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
		this.province = pName;
	}
	public String getProvince (){
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
		if (!trySetBirthdate(bDay))
		{
			throw new InvalidInputException("Invalid Birth Date.");
		}
		this.birthDate = bDay;
	}
	public String getBirthday (){
		return this.birthDate;
	}

	public void setStuNum (String sNum)
	{
		this.stuNum = sNum;
	}
	public String getStuNum()
	{
		return this.stuNum;
	}

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
	public static Boolean trySetBirthdate (String bDay)
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
	public String toString()
	{
		return firstName + " / " +  lastName + " / " + streetAddress + " / " + city + " / " + province + " / " + postalCode + " / " + birthDate + " / " + stuNum + " / " + phoneNumber;
	}
}