package AvinashCode.Phase1_Conditionals.Level_2;

import java.util.Scanner;

public class Q11_Check_if_three_sides_form_a_valid_triangle {
    public static void main(String[] args) {
        question1();

    }

    // =========================================================================
    // QUESTION 11: Check if three sides form a valid triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Triangle Inequality Theorem: The sum of any two sides must be greater
     * than the third side.
     *
     * Conditions to check:
     * - a + b > c
     * - b + c > a
     * - a + c > b
     *
     * All three conditions must be true for a valid triangle.
     */
    public static void question1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three sides of triangle: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // First check if all sides are positive
        if (a<=0 && b<=0 && c<=0){
            System.out.println("Sides must be positive numbers!");
            return;
        }

        // Triangle inequality theorem
        if(a+b> c && b+c> a && c+a>b){
            System.out.println("YES! These sides form a valid triangle ✓");
        } else {
            System.out.println("NO! These sides cannot form a triangle ✗");
        }

    }
}
