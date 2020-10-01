import java.util.*;
import java.util.regex.*;

public class UserRegistration {
	List<User> usersList;

	public UserRegistration() {
		super();
		usersList = new ArrayList<User>();
	}

	public static boolean validateName(String name) {
		if (Pattern.matches("^[A-Z]([a-z]{2,}|[A-Z]{2,})", name)) {
			return true;
		} else {
			System.out.println("Invalid entry for a first_name or a last_name");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserRegistration userReg = new UserRegistration();
		while (true) {
			System.out.println("1.Add a User\n2.Exit\nEnter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				System.out.println("Enter the first name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter the last name: ");
				String lastName = sc.nextLine();
				if (validateName(firstName) && validateName(lastName)) {
					userReg.usersList.add(new User(firstName, lastName));
				}
			} else if (choice == 2) {
				break;
			} else {
				System.out.println("Invalid Choice. Try again.");
			}
		}
		for (User user : userReg.usersList) {
			System.out.println(user);
		}
		sc.close();
	}
}

class User {
	private String firstName;
	private String lastName;

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}