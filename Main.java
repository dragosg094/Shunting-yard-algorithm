package ShuntingYard_Pseudocode;

import java.util.Scanner;

import static ShuntingYard_Pseudocode.MyStackAlgorithm.infix;
import static ShuntingYard_Pseudocode.MyStackAlgorithm.postfix;

public class Main {

    public static void main(String[] args) {

        String formula = "3+(2+1)*2^3^2-8/(5-1*2/2)";

        String postFix = postfix(formula);
        System.out.println( postFix);
        System.out.println( infix(postFix));

    }
}
