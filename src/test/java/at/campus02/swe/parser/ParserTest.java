package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);


        verifyNoMoreInteractions(cal);
    }


    @Test
    public void testParserTest02Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.modulo);


        verifyNoMoreInteractions(cal);

    }


    // Division by Zero Test (vgl Calc Klasse)


    // Test auf unerlaubte Zeichen, anstelle von erforderlichem Modulo Operator

    @Test()
    public void testParserInvalidOperator() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        try {
            parser.parse(new File("src/test/resources/test05.xml"));

            fail("We want an exception");
        } catch (CalculatorException e) {
            assertEquals("Unsupported Operation!", e.getMessage());
        }

    }

    // keine negativen (sin & cos) spezifischen Tests möglich

    /*
    @Test
    public void testSinOperation() throws Exception {

        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        try {
            parser.parse(new File("src/test/resources/test08.xml"));

            fail("Exception with Sinus Calculation expected.");
        }
        catch (CalculatorException e){

     */


    // Endlich funktionierende Tests:

    @Test
    public void testParserTest03Xml() throws Exception {

        CalculatorImpl cal = new CalculatorImpl();
        Parser parser = new Parser(cal);

        assertEquals(0.0, parser.parse(new File("src/test/resources/test09.xml")), 0.1);

        // verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserTest04Xml() throws Exception {

        CalculatorImpl cal = new CalculatorImpl();
        Parser parser = new Parser(cal);

        assertEquals(1, parser.parse(new File("src/test/resources/test08.xml")), 0.1);

    }

    // 2 Stunden lang nicht funktionierende Tests viable nach Wiedereinfügen von verify() Methoden


    @Test
    public void testParserTest05Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test09.xml"));

        verify(cal).push(0);
        verify(cal).perform(Operation.sin);

        verifyNoMoreInteractions(cal);
    }


    @Test
    public void testParserTest06Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test08.xml"));

        verify(cal).push(0);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);

    }

    @Test
    public void testParserTest10Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test10.xml"));

        verify(cal).push(1);
        verify(cal).push(3);
        verify(cal).perform(Operation.dotproduct);

        verifyNoMoreInteractions(cal);

    }


}
