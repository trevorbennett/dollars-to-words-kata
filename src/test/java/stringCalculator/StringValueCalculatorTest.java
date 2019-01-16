package test.java.stringCalculator;

import main.java.stringCalculator.StringValueCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringValueCalculatorTest {



    public static final String EMPTY_STRING = "";
    public static final String ONE_NUMBER = "123";
    public static final String TWO_NUMBERS = "456,789";
    public static final String TWO_NUMBERS_WITH_NEW_LINE = "456\n789";
    public static final String TWO_NUMBERS_LARGE = "456,789999";
    public static final String TWO_NUMBERS_LARGE_OUTPUT = "456";


    public static final String TWO_NUMBERS_OUTPUT = "1245";

    public static final String NON_NUMBER_INPUT = "abc123";
    public static final String THREE_NUMBERS = "456,789,123";
    public static final String SIX_NUMBERS = "1,2,3,4,5,6";
    public static final String SIX_NUMBERS_OUTPUT = "21";






    @Test
    public void shouldProduceResultGivenZeroNumbers(){

        assertEquals("0",StringValueCalculator.calculate(EMPTY_STRING));
    }

    @Test
    public void shouldProduceResultGivenOneNumber(){
        assertEquals(ONE_NUMBER,StringValueCalculator.calculate(ONE_NUMBER));

    }

    @Test
    public void shouldProduceResultGivenTwoNumbers(){
        assertEquals(TWO_NUMBERS_OUTPUT,StringValueCalculator.calculate(TWO_NUMBERS));

    }


    @Test
    public void shouldProduceResultGivenTwoNumbersWhereANumberGreaterThanThreeDigitsIsIgnored(){
        assertEquals(TWO_NUMBERS_LARGE_OUTPUT,StringValueCalculator.calculateForManyNumbers(TWO_NUMBERS_LARGE));

    }


    @Test
    public void shouldProduceResultGivenLargeAmountOfNumbers(){
        assertEquals(SIX_NUMBERS_OUTPUT,StringValueCalculator.calculateForManyNumbers(SIX_NUMBERS));

    }


    @Test
    public void shouldThrowExceptionWhenNonNumericNonCommaFieldExists(){
        try {
            StringValueCalculator.calculate(NON_NUMBER_INPUT);
            fail( "My method didn't throw when I expected it to" );
        } catch (Exception expectedException) {
        }
    }

    @Test
    public void shouldThrowExceptionIfMoreThanTwoNumbersAreProvided(){
        try {
            StringValueCalculator.calculate(THREE_NUMBERS);
            fail( "My method didn't throw when I expected it to" );
        } catch (Exception expectedException) {
        }
    }


    @Test
    public void shouldThrowExceptionIfNegativeNumbersAreProvided(){
        try {
            StringValueCalculator.calculate(THREE_NUMBERS);
            fail( "My method didn't throw when I expected it to" );
        } catch (Exception expectedException) {
        }
    }

    @Test
    public void shouldProduceResultGivenTwoNumbersThatAreDelimitedByANewLine(){
        assertEquals(TWO_NUMBERS_OUTPUT,StringValueCalculator.calculate(TWO_NUMBERS_WITH_NEW_LINE));

    }
}
