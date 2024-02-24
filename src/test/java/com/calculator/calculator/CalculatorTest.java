package com.calculator.calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testSquareRoot(){
        assertEquals(2,Calculator.squareRoot(4));
        assertEquals(1.7320508075688772,Calculator.squareRoot(3));
        assertNotEquals(2,Calculator.squareRoot(5));
    }
    @Test
    public void testFactorial(){
        assertEquals(6,Calculator.factorial(3));
        assertEquals(1,Calculator.factorial(0));
        assertNotEquals(25,Calculator.factorial(5));
    }
    @Test
    public void testNaturalLogarithm() {
        assertEquals(1.0986122886681096, Calculator.naturalLogarithm(3));
        assertEquals(7, Calculator.naturalLogarithm(76));
        assertNotEquals(0, Calculator.naturalLogarithm(0));
    }
    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2, 3));
        assertEquals(16.0, Calculator.power(4, 2));
        assertNotEquals(2, Calculator.power(10, 0));
    }
}
