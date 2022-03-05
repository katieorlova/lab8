package lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите математическое выражение вида a/b[+-*:]c/d: ");
        Calculation mathAction = new Calculation(in.nextLine());

        mathAction.finding();
        mathAction.Calc();
        in.close();
    }
}
