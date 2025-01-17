package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

import java.rmi.server.ExportException;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }

    @Test
    public void testSimpleModuloOperation() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(10);
        calc.push(4);
        double result = calc.perform(Operation.modulo);

        assertEquals(2,result,0);



    }
    @Test
    public void testSimpleModuloOperation2() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(8);
        calc.push(10);
        double result = calc.perform(Operation.modulo);

        assertEquals(8,result,0);



    }
    @Test
    public void testModuloWithInsufficientOperands() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(10); // Nur ein Operand auf dem Stack

        try {
            calc.perform(Operation.modulo);
            fail("Exception expected due to insufficient operands");
        } catch (CalculatorException e) {
            assertEquals("Zu Wenig Input", e.getMessage());
        }
    }
    @Test
    public void testModuloByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.modulo);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Modulo by zero", e.getMessage());
            // e.getCause()
        }

    }

    @Test
    public void SimpleCosOperation() throws Exception {

        //Setup
        Calculator cal = new CalculatorImpl();
            cal.push(0);
            assertEquals(1 ,cal.perform(Operation.cos), 0.1);

    }

    @Test
    public void SimpleSinOperation() throws Exception {

        //Setup
        Calculator cal = new CalculatorImpl();
        cal.push(1);
        assertEquals(0.8, cal.perform(Operation.sin), 0.1);

    }



    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }
}