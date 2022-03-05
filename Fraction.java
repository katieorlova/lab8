package lab;

public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduction();
        simplify();
    }

    public Fraction(String fractionInString) {
        int findSlash = fractionInString.indexOf("/");
        this.numerator = Integer.parseInt(fractionInString.substring(0, findSlash));
        this.denominator = Integer.parseInt(fractionInString.substring(findSlash + 1));
    }

    public Fraction() {}

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    void reduction() {
        if (numerator < 0 && denominator < 0) {
            numerator = numerator * (-1);
            denominator = denominator * (-1);
        }
        if (denominator < 0) {
            denominator = denominator * (-1);
            numerator = numerator * (-1);
        }
    }

    void simplify() {
        int divElement = 1;
        for (int i = denominator; i >= 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                divElement = i;
                break;
            }
        }
        numerator = numerator / divElement;
        denominator = denominator / divElement;
    }

    public void parse (String firstFraction){
        int slashIndex = firstFraction.indexOf("/");
        if (slashIndex != -1) {
            numerator = Integer.parseInt(firstFraction.substring(0, slashIndex));
            denominator = Integer.parseInt(firstFraction.substring(slashIndex + 1));
        }
        simplify();
        reduction();
    }

    public Fraction plus (Fraction SecFraction) {
        int newNum = (numerator * SecFraction.getDenominator()) +
                (SecFraction.getNumerator() * denominator);
        int newDen = denominator * SecFraction.getDenominator();

        return new Fraction(newNum, newDen);
    }

    public Fraction minus (Fraction SecFraction) {
        int newNum = (numerator * SecFraction.denominator) -
                (SecFraction.numerator * denominator);
        int newDen = denominator * SecFraction.denominator;

        return new Fraction (newNum, newDen);
    }

    public Fraction multiplication (Fraction SecFraction) {
        int newNum = numerator * SecFraction.numerator;
        int newDen = denominator * SecFraction.denominator;

        return new Fraction(newNum, newDen);
    }

    public Fraction division (Fraction SecFraction) {
        int newNum = numerator * SecFraction.getDenominator();
        int newDen = denominator * SecFraction.numerator;

        return new Fraction(newNum, newDen);
    }

    public static Fraction plus (Fraction FirFraction, Fraction SecFraction){
        int newNum = FirFraction.getNumerator() * SecFraction.getDenominator() + SecFraction.getNumerator() * FirFraction.getDenominator();
        int newDen = FirFraction.getDenominator() * SecFraction.getDenominator();

        return new Fraction(newNum, newDen);

    }

    public static Fraction minus (Fraction FirFraction, Fraction SecFraction){
        int numerator = FirFraction.getNumerator() * SecFraction.getDenominator() - SecFraction.getNumerator() * FirFraction.getDenominator();
        int denominator = FirFraction.getDenominator() * SecFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction multiplication (Fraction FirFraction, Fraction SecFraction){
        int numerator = FirFraction.getNumerator() * SecFraction.getNumerator();
        int denominator = FirFraction.getDenominator() * SecFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction division (Fraction FirFraction, Fraction SecFraction){
        int numerator = FirFraction.getNumerator() * SecFraction.getDenominator();
        int denominator = FirFraction.getDenominator() * SecFraction.getNumerator();

        return new Fraction(numerator, denominator);
    }

    public static String ConvertingToString (Fraction ResultFraction){
        int numerator = ResultFraction.getNumerator();
        int denominator = ResultFraction.getDenominator();
        String result;
        result = numerator+"/"+denominator;
        return result;
    }
}