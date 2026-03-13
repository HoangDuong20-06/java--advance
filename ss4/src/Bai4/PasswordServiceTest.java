package Bai4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    PasswordService service = new PasswordService();

    @Test
    void testStrongPassword() {
        assertEquals("Mạnh", service.evaluatePasswordStrength("Abc123!@"));
    }

    @Test
    void testMediumPassword1() {
        assertEquals("Trung bình", service.evaluatePasswordStrength("abc123"));
    }

    @Test
    void testMediumPassword2() {
        assertEquals("Trung bình", service.evaluatePasswordStrength("ABC123@"));
    }

    @Test
    void testMediumPassword3() {
        assertEquals("Trung bình", service.evaluatePasswordStrength("Abcdef@"));
    }

    @Test
    void testMediumPassword4() {
        assertEquals("Trung bình", service.evaluatePasswordStrength("Abc12345"));
    }

    @Test
    void testWeakShortPassword() {
        assertEquals("Yếu", service.evaluatePasswordStrength("Ab1"));
    }

    @Test
    void testWeakLowercase() {
        assertEquals("Yếu", service.evaluatePasswordStrength("password"));
    }

    @Test
    void testWeakUpperAndNumber() {
        assertEquals("Yếu", service.evaluatePasswordStrength("ABC12345"));
    }
}
