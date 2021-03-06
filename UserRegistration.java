import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserRegistration {
	List<User> usersList;

	public UserRegistration() {
		super();
		usersList = new ArrayList<User>();
	}

	public static boolean validateName(String name) {
		if (Pattern.matches("^[A-Z]([a-z]{2,}|[A-Z]{2,})$", name)) {
			return true;
		} else {
			System.out.println("Invalid entry for a first_name or a last_name");
			return false;
		}
	}

	public static boolean validateEmail(String email) {
		if (Pattern.matches("^[a-zA-Z0-9]+([_+-.]{1}[a-zA-Z0-9]+)?@[a-zA-Z0-9]+[.]{1}[a-zA-Z]{2,4}([.]{1}[a-zA-Z]{2,3})?$",email)) {
			return true;
		} else {
			System.out.println("Invalid entry for an email");
			return false;
		}
	}
	
	public static boolean validatePhoneNo(String phoneNo) {
		if (Pattern.matches("^[1-9]{1,3}[ ]{1}[1-9]{1}[0-9]{9}$", phoneNo)) {
			return true;
		} else {
			System.out.println("Invalid entry for a phone number");
			return false;
		}
	}
	
	public static boolean validatePassword(String password) {
		if (Pattern.matches("^(?=.{8,}$)(?=.*[A-Z].*$)(?=.*[0-9].*$)(?=[a-zA-Z0-9]*[^a-z^A-Z^0-9^ ][a-zA-Z0-9]*$).*$", password)) {
			return true;
		} else {
			System.out.println("Invalid entry for a password");
			return false;
		}
	}

	public void addUsers(){
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Add a User\n2.Exit\nEnter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.println("Enter the first name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter the last name: ");
				String lastName = sc.nextLine();
				System.out.println("Enter the email: ");
				String email = sc.nextLine();
				System.out.println("Enter the phone number: ");
				String phoneNo = sc.nextLine();
				System.out.println("Enter the password: ");
				String password = sc.nextLine();
				if (validateName(firstName) && validateName(lastName) && validateEmail(email)&&validatePhoneNo(phoneNo)&&validatePassword(password)){
					this.usersList.add(new User(firstName, lastName, email, phoneNo, password));
				}
			} else if (choice == 2) {
				break;
			} else {
				System.out.println("Invalid Choice. Try again.");
			}
		}
		sc.close();
	}
	public static void main(String[] args) {
		UserRegistration userReg = new UserRegistration();
		userReg.addUsers();
		for (User user : userReg.usersList) {
			System.out.println(user);
		}
		String[] sampleEmailList=new String[]{"abc@yahoo.com","abc-100@yahoo.com","abc.100@yahoo.com","abc111@abc.com","abc-100@abc.net","abc.100@abc.com.au","abc@1.com","abc@gmail.com.com","abc+100@gmail.com","abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com",".abc@abc.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com","abc@gmail.com.1a","abc@gmail.com.aa.au"};
		for(String i:sampleEmailList){
			System.out.println(i+": "+validateEmail(i));
		}

	}
}

class User {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private String password;

	public User(String firstName, String lastName, String email, String phoneNo, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + "]";
	}

}
