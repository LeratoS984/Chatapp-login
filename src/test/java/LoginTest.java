/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Part 1 registration and login features.
 */
public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testCorrectUsername() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testIncorrectUsername() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCorrectPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testIncorrectPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCorrectCellPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testIncorrectCellPhoneNumber() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testValidRegistration() {
        String expectedMessage = "Username successfully captured." + System.lineSeparator()
                + "Password successfully captured." + System.lineSeparator()
                + "Cell number successfully captured." + System.lineSeparator()
                + "Registration successful.";

        String actualMessage = login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Peters"
        );

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testSuccessfulLogin() {
        login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Peters"
        );

        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testFailedLogin() {
        login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Peters"
        );

        assertFalse(login.loginUser("kyl_1", "wrongPassword"));
    }

    @Test
    public void testSuccessfulLoginMessage() {
        login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Peters"
        );

        boolean loginResult = login.loginUser("kyl_1", "Ch&&sec@ke99!");

        assertEquals(
                "Welcome Kyle, Peters it is great to see you again.",
                login.returnLoginStatus(loginResult)
        );
    }

    @Test
    public void testFailedLoginMessage() {
        assertEquals(
                "Username or password incorrect, please try again.",
                login.returnLoginStatus(false)
        );
    }
}