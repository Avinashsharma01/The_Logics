package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q07_Print_largest_of_three_numbers {


    // =========================================================================
    // QUESTION 7: Print largest of three numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Compare first with second and third
     * - If first is not largest, compare second with third
     *
     * APPROACH 1: Nested if-else
     * APPROACH 2: Store max in variable and update
     * APPROACH 3: Math.max(Math.max(a, b), c)
     */

    public static void question7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // Method 1: Using if-else
        if (a >= b && a >= c) {
            System.out.println(a + " is the largest");
        } else if (b >= a && b >= c) {
            System.out.println(b + " is the largest");
        } else {
            System.out.println(c + " is the largest");
        }

        // Method 2: Using variable
        /*
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        System.out.println(max + " is the largest");
        */

        // Method 3: Using Math.max
        // int max = Math.max(Math.max(a, b), c);
    }
}
