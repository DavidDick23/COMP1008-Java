package practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest
{

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();

        // Test normal division
        assertEquals(2.0, calculator.divide(4, 2), "4 divided by 2 should be 2.0");
        assertEquals(1.5, calculator.divide(3, 2), "3 divided by 2 should be 1.5");
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();

        // Test division by zero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });

        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
