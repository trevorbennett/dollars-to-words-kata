package test.java.converter;

import main.java.converter.DollarBoxToAmountTextConverter;
import main.java.converter.DollarBoxValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DollarBoxToAmountTextConverterTest {

    private String onlyCentsDollarValue = "0.45";
    private String onlyCentsDollarValueMissingLeadingZero = ".45";

    private String dollarsAndCentsDollarValue = "10.20";
    private String onlyDollarsDollarValue = "1005";
    private String largeDollarValue = "9876543210";

    private String parsedDollarValue = "10";
    private String parsedCentValue = "20";

    private String parsedDollarValueLeadZero = "0";
    private String parsedCentValueLeadZero = "45";

    private String onlyCentsAmountText = "forty-five cents";
    private String dollarsAndCentsAmountText = "ten dollars and twenty cents";
    private String onlyDollarsAmountText = "one thousand five dollars";
    private String largeAmountText = "nine billion eight hundred seventy-six million five hundred forty-three thousand two hundred ten dollars";

    private String nineNineNineNumeric = "999";
    private String thirtyOughtSixNumeric = "3006";
    private String teenNumeric = "316";
    private String entireSubcaseOfZeroesNumeric = "1000555";
    private String largeNumberNumeric = "999888777666";





    private String nineNineNineWords = "nine hundred ninety-nine";
    private String thirtyOughtSixWords = "three thousand six";
    private String teenWords = "three hundred sixteen";
    private String entireSubcaseOfZeroesWords = "one million five hundred fifty-five";
    private String largeNumberWords = "nine hundred ninety-nine billion eight hundred eighty-eight million seven hundred seventy-seven thousand six hundred sixty-six";

    //converter should avoid holding any state, so we test using class references rather than initializing an object for the test suite

    @Test
    public void shouldOutputTextualAmountForCentsOnly(){
        final String convertedDollarAmount = DollarBoxToAmountTextConverter.convert(onlyCentsDollarValue);
        assertEquals(onlyCentsAmountText, convertedDollarAmount);

        final String convertedDollarAmountNoLeadingZero = DollarBoxToAmountTextConverter.convert(onlyCentsDollarValueMissingLeadingZero);
        assertEquals(onlyCentsAmountText, convertedDollarAmountNoLeadingZero);
    }

    @Test
    public void shouldOutputTextualAmountForDollarsAndCents(){
        final String convertedDollarAmount = DollarBoxToAmountTextConverter.convert(dollarsAndCentsDollarValue);
        assertEquals(dollarsAndCentsAmountText, convertedDollarAmount);
    }

    @Test
    public void shouldOutputTextualAmountForDollarsOnly(){
        final String convertedDollarAmount = DollarBoxToAmountTextConverter.convert(onlyDollarsDollarValue);
        assertEquals(onlyDollarsAmountText, convertedDollarAmount);
    }

    @Test
    public void shouldOutputTextualAmountForLargeDollarValue(){
        final String convertedDollarAmount = DollarBoxToAmountTextConverter.convert(largeDollarValue);
        assertEquals(largeAmountText, convertedDollarAmount);
    }


    @Test
    public void shouldParseDollarBoxValueIntoSubelements(){
        DollarBoxValue dollarBoxValue = DollarBoxToAmountTextConverter.parseToDollarElements(dollarsAndCentsDollarValue);
        assertEquals(parsedDollarValue, dollarBoxValue.getDollars());
        assertEquals(parsedCentValue, dollarBoxValue.getCents());

        dollarBoxValue = DollarBoxToAmountTextConverter.parseToDollarElements(onlyCentsDollarValue);
        assertEquals(parsedDollarValueLeadZero, dollarBoxValue.getDollars());
        assertEquals(parsedCentValueLeadZero, dollarBoxValue.getCents());

        dollarBoxValue = DollarBoxToAmountTextConverter.parseToDollarElements(onlyCentsDollarValueMissingLeadingZero);
        assertEquals(parsedDollarValueLeadZero, dollarBoxValue.getDollars());
        assertEquals(parsedCentValueLeadZero, dollarBoxValue.getCents());
    }

    @Test
    public void shouldInterpretGivenNumbersCorrectly(){
        String interpretedOutput = DollarBoxToAmountTextConverter.interpret(nineNineNineNumeric);
        String interpretedOutput2 = DollarBoxToAmountTextConverter.interpret(thirtyOughtSixNumeric);
        String interpretedOutput3 = DollarBoxToAmountTextConverter.interpret(teenNumeric);
        String interpretedOutput4 = DollarBoxToAmountTextConverter.interpret(entireSubcaseOfZeroesNumeric);
        String interpretedOutput5 = DollarBoxToAmountTextConverter.interpret(largeNumberNumeric);

        assertEquals(nineNineNineWords,interpretedOutput);
        assertEquals(thirtyOughtSixWords,interpretedOutput2);
        assertEquals(teenWords,interpretedOutput3);
        assertEquals(entireSubcaseOfZeroesWords,interpretedOutput4);
        assertEquals(largeNumberWords,interpretedOutput5);
    }
}
