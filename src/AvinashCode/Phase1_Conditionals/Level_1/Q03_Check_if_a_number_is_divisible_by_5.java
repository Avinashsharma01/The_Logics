package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q03_Check_if_a_number_is_divisible_by_5 {

    // =========================================================================
    // QUESTION 3: Check if a number is divisible by 5
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - A number is divisible by 5 if num % 5 == 0
     *
     * Examples: 10 % 5 = 0 ✓, 15 % 5 = 0 ✓, 7 % 5 = 2 ✗
     */



    public static void question3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 5 == 0) {
            System.out.println(num + " is divisible by 5");
        } else {
            System.out.println(num + " is NOT divisible by 5");
        }
    }

    public static void main(String[] args) {
        question3();
    }
}
