package AvinashCode.Phase1_Conditionals.Level_2;

import java.util.Scanner;

public class Q12_Identify_triangle_type {
    public static void main(String[] args) {

    }

    // =========================================================================
    // QUESTION 12: Identify triangle type (equilateral/isosceles/scalene)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Equilateral: All three sides are equal (a == b == c)
     * - Isosceles: Exactly two sides are equal
     * - Scalene: All three sides are different
     *
     * ORDER MATTERS: Check equilateral first, then isosceles, then scalene
     */

    public static void question(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three sides of triangle: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
    }
}
