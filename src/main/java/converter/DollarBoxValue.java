package main.java.converter;

public class DollarBoxValue {

    public static final String NO_CENTS_PROVIDED = "00";
    public static final String NO_DOLLARS_PROVIDED = "0";

    String dollars = NO_DOLLARS_PROVIDED;
    String cents = NO_CENTS_PROVIDED;


    public String getDollars() {
        return dollars;
    }

    public void setDollars(String dollars) {
        this.dollars = dollars;
    }

    public String getCents() {
        return cents;
    }

    public void setCents(String cents) {
        this.cents = cents;
    }
}
