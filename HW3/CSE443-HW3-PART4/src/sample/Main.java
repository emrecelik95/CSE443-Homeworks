package sample;

import java.util.Scanner;

/**
 *  Main class of application
 */
public class Main {


    public static void main(String[] args) {

        System.out.println("|DCT METHOD|");
        TransformNumbers tr = new DCT("input2.txt", "output2.txt", 4);
        tr.Transform();

        System.out.println("|DFT METHOD|");
        System.out.println("Print Elapsed Time? (yes) or (no) - (no by default  )");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        boolean userChoice = (input.equals("yes"));
        tr = new DFT("input.txt", "output.txt", 4, userChoice);

        tr.Transform();


    }
}
