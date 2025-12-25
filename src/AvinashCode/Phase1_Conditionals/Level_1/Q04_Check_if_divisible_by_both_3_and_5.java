package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q04_Check_if_divisible_by_both_3_and_5 {

    // =========================================================================
    // QUESTION 4: Check if divisible by both 3 and 5
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Must satisfy BOTH conditions: num % 3 == 0 AND num % 5 == 0
     * - Use logical AND operator (&&)
     *
     * KEY CONCEPT: Logical operators
     * - && (AND): Both conditions must be true
     * - || (OR): At least one condition must be true
     *
     * Examples: 15 (yes), 30 (yes), 10 (no - only by 5), 9 (no - only by 3)
     */

    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + " is divisible by BOTH 3 and 5");
        } else if (num % 3 == 0) {
            System.out.println(num + " is divisible by 3 only");
        } else if (num % 5 == 0) {
            System.out.println(num + " is divisible by 5 only");
        } else {
            System.out.println(num + " is NOT divisible by 3 or 5");
        }
    }

    public static void main(String[] args) {
        question4();
    }
}
