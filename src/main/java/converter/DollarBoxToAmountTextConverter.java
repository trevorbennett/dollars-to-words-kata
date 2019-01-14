package main.java.converter;


public class DollarBoxToAmountTextConverter {



    public static String convert(String dollarBoxInput){
        DollarBoxValue dollarBoxValue = parseToDollarElements(dollarBoxInput);

        return dollarBoxInput;
    }

    public static DollarBoxValue parseToDollarElements(String dollarBoxInput){
        DollarBoxValue dollarBoxValue = new DollarBoxValue();

        if(dollarBoxInput.contains(".")){
            String[] dollarBoxElements = dollarBoxInput.split("\\.");
            dollarBoxValue.dollars = dollarBoxElements[0];
            dollarBoxValue.cents = dollarBoxElements[1];
        } else {
            dollarBoxValue.dollars = dollarBoxInput;
            dollarBoxValue.cents = DollarBoxValue.NO_CENTS_PROVIDED;
        }

        return dollarBoxValue;
    }

}
