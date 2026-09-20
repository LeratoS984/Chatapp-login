/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lerat
 */
import java.util.regex.Pattern;

/**
 * Handles registration validation and user login for QuickChat.
 */
public class Login {

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^(?=.{1,5}$).*_.*$");

    private static final Pattern PASSWORD_CAPITAL =
            Pattern.compile(".*[A-Z].*");

    private static final Pattern PASSWORD_DIGIT =
            Pattern.compile(".*\\d.*");

    private static final Pattern PASSWORD_SPECIAL =
            Pattern.compile(".*[^a-zA-Z0-9].*");

    /*
     * International-number regex reference:
     * ITU-T Recommendation E.164:
     * https://www.itu.int/rec/T-REC-E.164
     */
    private static final Pattern CELL_PHONE_PATTERN =
            Pattern.compile("^\\+\\d{1,3}\\d{9}$");

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    private boolean registered;
    /**
     * Checks that a username has an underscore and is no more than five characters.
     *
     * @param username the username entered by the user
     * @return true if the username is valid
     */
    public boolean checkUserName(String username) {
        return username != null
                && USERNAME_PATTERN.matcher(username).matches();
    }
/**
     * Checks that a password has the required complexity.
     *
     * @param password the password entered by the user
     * @return true if the password is valid
     */
    public boolean checkPasswordComplexity(String password) {
        return password != null
                && password.length() >= 8
                && PASSWORD_CAPITAL.matcher(password).matches()
                && PASSWORD_DIGIT.matcher(password).matches()
                && PASSWORD_SPECIAL.matcher(password).matches();
    }
    /**
     * Checks that a cell number has an international code.
     *
     * @param cellPhoneNumber the cell number entered by the user
     * @return true if the cell number is valid
     */
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber != null
                && CELL_PHONE_PATTERN.matcher(cellPhoneNumber).matches();
    }
 /**
     * Registers a user when all entered details are valid.
     *
     * @param username the new username
     * @param password the new password
     * @param cellPhoneNumber the user's international cell number
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @return the required registration message
     */
    public String registerUser(String username, String password,
            String cellPhoneNumber, String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains "
                    + "at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; "
                    + "please correct the number and try again.";
        }

        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        registered = true;

        return "Username successfully captured." + System.lineSeparator()
                + "Password successfully captured." + System.lineSeparator()
                + "Cell number successfully captured." + System.lineSeparator()
                + "Registration successful.";
    }
    