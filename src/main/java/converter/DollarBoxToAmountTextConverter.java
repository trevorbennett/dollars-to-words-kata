package main.java.converter;


public class DollarBoxToAmountTextConverter {



    public static String convert(String dollarBoxInput){
        DollarBoxValue dollarBoxValue = parseToDollarElements(dollarBoxInput);

        String valueText = "";

        //if dollars exist, we must use "and" to be grammatically correct
        Boolean DOLLARS_EXIST = false;

        if(!dollarBoxValue.getDollars().equals("0")){
            valueText += interpret(dollarBoxValue.getDollars());
            DOLLARS_EXIST = true;
        }

        if(!dollarBoxValue.getCents().equals("00")){
            if(DOLLARS_EXIST){
                valueText += " and ";
            }
            valueText += interpret(dollarBoxValue.getCents()) + " cents";
        }

        return valueText;
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


    public static String interpret(String b){

        String valueTextEquivalentOfAmount = "";
        String subcase = "";

        if(b.length() < 4) {
            subcase = b;
            valueTextEquivalentOfAmount += interpretSubcase(subcase);
        }

        return valueTextEquivalentOfAmount;
    }

    public static String interpretSubcase(String subcase) {
        String subcaseText = "";

        if(subcase.length() == 3) {
            if(!subcase.startsWith("0")) {
                subcaseText = NumericUtils.INDEX_WORDS[Character.getNumericValue(subcase.charAt(0))] + NumericUtils.SCALAR_WORDS[0];
            }
            subcase = subcase.substring(1);
        }

        if(subcase.length() == 2) {
            if(subcase.startsWith("1")){
                subcaseText += NumericUtils.TEENS_WORDS[Character.getNumericValue(subcase.charAt(1))];
                subcase = "";
            } else if(!subcase.startsWith("0")) {
                subcaseText += NumericUtils.TENS_WORDS[Character.getNumericValue(subcase.charAt(0))] + "-";
            }
            subcase = subcase.substring(1);
        }

        if(subcase.length() == 1) {
            if(!subcase.startsWith("0")) {
                subcaseText += NumericUtils.INDEX_WORDS[Character.getNumericValue(subcase.charAt(0))];
            }
        }

        return subcaseText;
    }

}
