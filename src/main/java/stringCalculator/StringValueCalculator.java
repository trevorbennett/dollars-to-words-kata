package main.java.stringCalculator;

public class StringValueCalculator {

    public static String calculate(String input) {
        if(input=="" || input == null){
            return "0";
        }
        String[] numbers = parse(input);
        if(numbers.length == 1) {
            return numbers[0];
        } else if(numbers.length == 2) {
            Integer total =  Integer.valueOf(numbers[0]) + Integer.valueOf(numbers[1]);
            return total.toString();
        } else {
            throw new IllegalArgumentException();
        }

    }



    public static String calculateForManyNumbers(String input) {
        if(input=="" || input == null){
            return "0";
        }
        String[] numbers = parse(input);
        if(numbers.length == 1) {
            return numbers[0];
        } else {

            Integer total = 0;

            for (String number: numbers) {
                if(!(number.length()>3)){
                    total += Integer.valueOf(number);
                }
            }
            return total.toString();
        }

    }



    public static String[] parse(String stringToParse){
        if (stringToParse.matches(".*[a-zA-Z]+.*")  || stringToParse.matches(".*-+.*")){
            throw new IllegalArgumentException();
        } else if(stringToParse.matches(".*\n+.*")){
            return parseWithNewLineBreaks(stringToParse);
        }
        String[] numbers = stringToParse.split(",");
        return numbers;
    }


    public static String[] parseWithNewLineBreaks(String stringToParse){

        String[] numbers = stringToParse.split("\n");
        return numbers;
    }

}
