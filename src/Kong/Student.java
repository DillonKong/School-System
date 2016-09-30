package Kong;

public class Student {

	private String firstName; private String lastName;private String streetAddress;private String city;private String province;private String postalCode;private String phoneNumber;	private String birthDate;

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

	public void setAddress (String address){
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

	public void setPostalCode (String pCode){
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

	public void setBirthday (String bDay){
		this.birthDate = bDay;
	}
	public String getBirthday (){
		return this.birthDate;
	}

	
	
}