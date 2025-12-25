package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q06_Print_larger_of_two_numbers {


    // =========================================================================
    // QUESTION 6: Print larger of two numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Compare two numbers using > operator
     * - Handle the case when both are equal
     *
     * ALTERNATIVE: Use Math.max(a, b) - built-in function
     */

    public static void question6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Method 1: Using if-else
        if (a > b) {
            System.out.println(a + " is larger");
        } else if (b > a) {
            System.out.println(b + " is larger");
        } else {
            System.out.println("Both numbers are equal");
        }

        // Method 2: Using ternary operator (one-liner)
        // int larger = (a > b) ? a : b;

//         Method 3: Using Math.max()
//         int larger = Math.max(a, b);
    }

    public static void main(String[] args) {
        question6();
    }
}
