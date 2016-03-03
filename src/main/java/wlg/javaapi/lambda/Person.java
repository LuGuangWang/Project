package wlg.javaapi.lambda;

import java.time.LocalDate;

public class Person {

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void printPerson(){
		System.out.println("Person's name is:"+ name +"\nbirthday is:" + birthday
				+"\ngender is:" + gender + "\nemailAddress is:"+emailAddress);
	}
}
