package dto;

public class Passenger extends User{
	private  String gender;
	private int age;
	private String country;

	public Passenger(String firstName, String lastName, String gender, int age, String country,long phoneNumber, String emailId
	) {
		super(firstName, lastName, emailId, phoneNumber);
		this.gender = gender;
		this.age = age;
		this.country = country;
}


	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age
				+ ", country=" +country + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}



}
