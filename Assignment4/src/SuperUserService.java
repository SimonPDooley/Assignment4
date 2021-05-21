import java.util.Scanner;

public class SuperUserService extends UserService {

	boolean keepGuessing = true;

	public User userOptions(User updatedUser, User[] users) {
		boolean makingChanges = true;
		Scanner scanner = new Scanner(System.in);

		while (makingChanges == true) {
			System.out.println("Please choose from the following options:");
			System.out.println("(0) Log in as another user");
			System.out.println("(1) Update username");
			System.out.println("(2) Update password");
			System.out.println("(3) Update name");
			System.out.println("(4) Exit");

			String option = scanner.nextLine();

			if (option.equals("0")) {
				while (keepGuessing == true) {
					System.out.println("Which user would you like to login as?(type in a valid username)");
					System.out.println("----------------------------------");
					String anotherUser = scanner.nextLine();
					// Iterate through all the users in the data.txt file and check if email(not
					// case sensitive)
					// and password(case sensitive) match the users input for these fields
					for (int i = 0; i < users.length; i++) {
						if (anotherUser.equalsIgnoreCase(users[i].getUsername())) {
							keepGuessing = false;
							System.out.println("Welcome: " + users[i].getName());
							System.out.println("----------------------------------");
							System.out.println(users[i].getRole());
							if (users[i].getRole().equals("normal_user")) {
								UserService userService = new UserService();
								users[i] = userService.userOptions(users[i]);
								System.out.println(users[i].getName());
								makingChanges = false;
							} else {
								users[i] = userOptions(users[i]);
								System.out.println(users[i].getName());
								makingChanges = false;
							}
						}
					}
					System.out.println("Invalid username, please try again");
				}
			} else if (option.equals("1")) {
				System.out.println("Please enter your new username");
				String newUsername = scanner.nextLine();
				System.out.println("Your username has been updated");
				System.out.println("----------------------------------");
				updatedUser.setUsername(newUsername);
			}

			else if (option.equals("2")) {
				System.out.println("Please enter your new password");
				String newPassword = scanner.nextLine();
				System.out.println("Your password has been updated");
				System.out.println("----------------------------------");
				updatedUser.setPassword(newPassword);
			}

			else if (option.equals("3")) {
				System.out.println("Please enter your new name");
				String newName = scanner.nextLine();
				updatedUser.setName(newName);
				System.out.println("Welcome: " + updatedUser.getName());
				System.out.println("----------------------------------");
			} else if (option.equals("4")) {
				makingChanges = false;
				break;
			}

			else {
				System.out.println("Invalid input, please try again.");
				System.out.println("----------------------------------");
			}
		}
		return updatedUser;
	}

}