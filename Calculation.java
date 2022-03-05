package lab;

public class Calculation extends Fraction{
    private String mathAction;
    private String firstFraction = "";
    private String secondFraction = "";
    private String line = "";
    private String action = "";
    private Fraction fFraction;
    private Fraction sFraction;

    public Calculation(String nextLine) {
        this.mathAction = nextLine;
    }

    public void finding() {

        int plusIndex = mathAction.indexOf("+");
        if (plusIndex != -1) {
            String[] spl = mathAction.split("\\+");

            this.firstFraction = spl[0];
            this.secondFraction = spl[1];

            this.action = "+";
        }
        else {
            int minusIndex = mathAction.indexOf("-", 1);
            if (minusIndex != -1) {
                if (minusIndex == 0) {
                    String[] spl1 = mathAction.split("-", 1);

                    line = spl1[0];

                    String[] spl2 = line.split("-", 1);

                    this.firstFraction = "-" + spl2[0];
                    this.secondFraction = spl2[1];

                    this.action = "-";
                } else {
                    String[] spl = mathAction.split("-", 1);

                    this.firstFraction = spl[0];
                    this.secondFraction = spl[1];

                    this.action = "-";
                }
            } else {
                int multiplicationIndex = mathAction.indexOf("*");
                if (multiplicationIndex != -1) {
                    String[] spl = mathAction.split("\\*");

                    this.firstFraction = spl[0];
                    this.secondFraction = spl[1];

                    this.action = "*";
                } else {
                    int divisorIndex = mathAction.indexOf(":");
                    if (divisorIndex != -1) {
                        String[] spl = mathAction.split(":");

                        this.firstFraction = spl[0];
                        this.secondFraction = spl[1];

                        this.action = ":";
                    }
                }
            }
        }
    }

    public void Calc() {
        String vid = "^\\d+/\\d+|^-\\d+/\\d+";
        if (firstFraction.matches(vid)) {
            this.fFraction = new Fraction(firstFraction);
        }
        else {
            System.out.println("Ошибка! Введите математическое выражение в формате a/b[+-*:]c/d : ");
            System.exit(1);
        }

        if (secondFraction.matches(vid)) {
            this.sFraction = new Fraction(secondFraction);
        }
        else {
            System.out.println("Ошибка! Введите математическое выражение в формате a/b[+-*:]c/d : ");
            System.exit(1);
        }

        if (action == "+") {
            Fraction result = plus(fFraction, sFraction);
            System.out.println(result.numerator + "/" + result.denominator);
        }
        if (action == "-") {
            Fraction result = minus(fFraction, sFraction);
            System.out.println(result.numerator + "/" + result.denominator);
        }
        if (action == "*") {
            Fraction result = multiplication(fFraction, sFraction);
            System.out.println(result.numerator + "/" + result.denominator);
        }
        if (action == ":") {
            Fraction result = division(fFraction, sFraction);
            System.out.println(result.numerator + "/" + result.denominator);
        }
    }
}