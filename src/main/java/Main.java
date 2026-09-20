/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author lerat
 */
import java.util.Scanner;

/**
 * Runs the QuickChat registration and login application in the console.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("Welcome to QuickChat.");
        System.out.println();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Create a username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Create a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your cell number with international code: ");
        String cellPhoneNumber = scanner.nextLine().trim();

        String registrationResult = login.registerUser(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        System.out.println();
        System.out.println(registrationResult);

        if (!login.isRegistered()) {
            System.out.println("Registration was unsuccessful. Please restart the application and correct your details.");
            return;
        }

        System.out.println();
        System.out.println("Please log in.");

        System.out.print("Username: ");
        String enteredUsername = scanner.nextLine().trim();

        System.out.print("Password: ");
        String enteredPassword = scanner.nextLine();

        boolean loginSuccessful = login.loginUser(
                enteredUsername,
                enteredPassword
        );

        System.out.println();
        System.out.println(login.returnLoginStatus(loginSuccessful));
    }
}