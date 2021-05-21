import java.io.InputStream;
import java.util.Scanner;

public class UserService{
	public User userOptions(User updatedUser) {
		boolean makingChanges = true;
		Scanner scanner = new Scanner(System.in);


		while (makingChanges == true) {
			System.out.println("Please choose from the following options:");
			System.out.println("(1) Update username");
			System.out.println("(2) Update password");
			System.out.println("(3) Update name");
			System.out.println("(4) Exit");

			String option = scanner.nextLine();

			if (option.equals("1")) {
				System.out.println("Please enter your new username");
				String newUsername = scanner.nextLine();
				System.out.println("Your username has been updated");
				updatedUser.setUsername(newUsername);
			}

			else if (option.equals("2")) {
				System.out.println("Please enter your new password");
				String newPassword = scanner.nextLine();
				System.out.println("Your password has been updated");
				updatedUser.setPassword(newPassword);
			}

			else if (option.equals("3")) {
				System.out.println("Please enter your new name");
				String newName = scanner.nextLine();
				updatedUser.setName(newName);
				System.out.println("Welcome: "+ updatedUser.getName());
			} else if (option.equals("4")) {
				makingChanges = false;
				break;
			}

			else {
				System.out.println("Invalid input, please try again.");
			}
		}return updatedUser;
	}
}
