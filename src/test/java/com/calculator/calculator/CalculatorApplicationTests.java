package com.calculator.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class CalculatorApplicationTests {

    @Test
    public void testSquareRoot(){
        assertEquals(2,CalculatorApplication.squareRoot(4));
        assertEquals(1.7320508075688772,CalculatorApplication.squareRoot(3));
        assertNotEquals(2,CalculatorApplication.squareRoot(5));
    }
    @Test
    public void testFactorial(){
        assertEquals(6,CalculatorApplication.factorial(3));
        assertEquals(1,CalculatorApplication.factorial(0));
        assertNotEquals(25,CalculatorApplication.factorial(5));
    }
    @Test
    public void testNaturalLogarithm() {
        assertEquals(1.0986122886681096, CalculatorApplication.naturalLogarithm(3));
        assertEquals(4.330733340286331, CalculatorApplication.naturalLogarithm(76));
        assertNotEquals(0, CalculatorApplication.naturalLogarithm(0));
    }
    @Test
    public void testPower() {
        assertEquals(8.0, CalculatorApplication.power(2, 3));
        assertEquals(16.0, CalculatorApplication.power(4, 2));
        assertNotEquals(2, CalculatorApplication.power(10, 0));
    }

}
