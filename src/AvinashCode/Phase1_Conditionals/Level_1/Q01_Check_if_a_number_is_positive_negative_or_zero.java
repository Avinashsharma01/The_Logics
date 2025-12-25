package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q01_Check_if_a_number_is_positive_negative_or_zero {
    // =========================================================================
    // QUESTION 1: Check if a number is positive, negative, or zero
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - If number > 0, it's positive
     * - If number < 0, it's negative
     * - If number == 0, it's zero
     *
     * KEY CONCEPT: Comparison operators (>, <, ==)
     */
    static Scanner sc = new Scanner(System.in);

    public static void question1() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println(num + " is POSITIVE");
        } else if (num < 0) {
            System.out.println(num + " is NEGATIVE");
        } else {
            System.out.println("The number is ZERO");
        }
    }
    public static void main(String[] args) {
        question1();
    }

}
