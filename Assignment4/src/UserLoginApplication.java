import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserLoginApplication {

	public static final int USER_COUNT = 20;
	public static final int MAX_LOGIN_ATTEMPTS = 5;

	public static void main(String[] args) throws IOException {

		BufferedReader fileReader = null;
		Scanner scanner = new Scanner(System.in);
		String[] usersParsed = null;
		UserService userService = new UserService();
		SuperUserService superUserService = new SuperUserService();
		User[] users = new User[USER_COUNT];
		Boolean loggedIn = false;

		// Read in the text file
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line;

			// Separate words with ","s and create a new user for each line with each
			// word being inputed as the variables for email, password and name respectively
			for (int i = 0; i < users.length; i++) {
				line = fileReader.readLine();
				usersParsed = line.split(", ");
				users[i] = new User(usersParsed[0], usersParsed[1], usersParsed[2], usersParsed[3]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5 attempts at logging in

		int loginAttemptCounter = 0;

		try {
			while (loggedIn == false && loginAttemptCounter < MAX_LOGIN_ATTEMPTS) {

				loginAttemptCounter++;
				System.out.println("Enter your email:");
				String email = scanner.nextLine();
				System.out.println("Enter your password:");
				String password = scanner.nextLine();

				Arrays.sort(users);

				// Iterate through all the users in the data.txt file and check if email(not
				// case sensitive)
				// and password(case sensitive) match the users input for these fields
				for (int i = 0; i < users.length; i++) {
					if (email.equalsIgnoreCase(users[i].getUsername()) && password.equals(users[i].getPassword())) {
						System.out.println("Welcome: " + users[i].getName());
						System.out.println("----------------------------------");
						loggedIn = true;
						if (users[i].getRole().equals("normal_user")) {
							users[i] = userService.userOptions(users[i]);
							Arrays.sort(users);
						} else {
							users[i] = superUserService.userOptions(users[i], users);
							Arrays.sort(users);
							for (int w = 0; w < users.length; w++) {
								System.out.println(users[w].getName());
							}
						}
					}
				}

				if (loginAttemptCounter < MAX_LOGIN_ATTEMPTS && loggedIn == false) {
					System.out.println("Invalid login, please try again!");
					System.out.println("----------------------------------");
				}
			}

		} finally {
			scanner.close();
			fileReader.close();
		}
		if (loggedIn == false) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
	}
}
