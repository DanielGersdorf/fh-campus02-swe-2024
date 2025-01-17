package at.campus02.swe.e2e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;
import org.junit.Test;

import java.io.File;


public class EndToEndTest {

    @Test
    public void testParserTest06Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(3, parser.parse(new File("src/test/resources/test06.xml")), 0);

    }


    @Test
    public void testParserTest07Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(6, parser.parse(new File("src/test/resources/test07.xml")), 0);

    }


    @Test
    public void testParserTest08Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(1, parser.parse(new File("src/test/resources/test08.xml")), 0.1);

    }

    @Test
    public void testParserTest09Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(0, parser.parse(new File("src/test/resources/test09.xml")), 0.1);

    }


    @Test
    public void testParserTest11Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(14, parser.parse(new File("src/test/resources/test11.xml")), 0.1);

    }
}
