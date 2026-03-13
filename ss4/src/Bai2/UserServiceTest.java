package Bai2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService service = new UserService();

    @Test
    void testAge18() {

        boolean result = service.checkRegistrationAge(18);

        assertEquals(true, result);
    }

    @Test
    void testAge17() {

        boolean result = service.checkRegistrationAge(17);

        assertEquals(false, result);
    }

    @Test
    void testNegativeAge() {

        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(-1);
        });
    }
}
