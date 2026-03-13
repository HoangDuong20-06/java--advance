package Bai3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {

    UserProcessor processor;

    @BeforeEach
    void setup() {
        processor = new UserProcessor();
    }

    @Test
    void testValidEmail() {

        String result = processor.processEmail("user@gmail.com");

        assertEquals("user@gmail.com", result);
    }

    @Test
    void testMissingAtSymbol() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("usergmail.com");
        });
    }

    @Test
    void testMissingDomain() {

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail("user@");
        });
    }

    @Test
    void testLowercaseConversion() {

        String result = processor.processEmail("Example@Gmail.com");

        assertEquals("example@gmail.com", result);
    }
}
