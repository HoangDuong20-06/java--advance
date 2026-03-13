package Bai1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    UserValidator validator = new UserValidator();

    @Test
    void testValidUsername() {

        boolean result = validator.isValidUsername("user123");

        assertTrue(result);
    }

    @Test
    void testTooShortUsername() {

        boolean result = validator.isValidUsername("abc");

        assertFalse(result);
    }

    @Test
    void testUsernameContainsSpace() {

        boolean result = validator.isValidUsername("user name");

        assertFalse(result);
    }
}
