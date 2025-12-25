package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q02_Check_if_a_number_is_even_or_odd {

    // =========================================================================
    // QUESTION 2: Check if a number is even or odd
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Even numbers are divisible by 2 (remainder = 0)
     * - Odd numbers have remainder 1 when divided by 2
     *
     * KEY CONCEPT: Modulo operator (%) gives remainder
     * Example: 4 % 2 = 0 (even), 5 % 2 = 1 (odd)
     */
    static Scanner sc = new Scanner(System.in);
    public static void question2() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is EVEN");
        } else {
            System.out.println(num + " is ODD");
        }
    }

    public static void main(String[] args) {
        question2();
    }
}
