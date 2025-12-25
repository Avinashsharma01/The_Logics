package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q05_Check_if_a_year_is_a_leap_year {

    // =========================================================================
    // QUESTION 5: Check if a year is a leap year
    // =========================================================================
    /*
     * LOGIC EXPLANATION (IMPORTANT - Common Interview Question!):
     * A year is a leap year if:
     * 1. Divisible by 4 AND
     * 2. Either NOT divisible by 100 OR divisible by 400
     *
     * FORMULA: (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
     *
     * Examples:
     * - 2024: 2024 % 4 = 0, 2024 % 100 = 24 (≠0) → LEAP YEAR
     * - 1900: 1900 % 4 = 0, 1900 % 100 = 0, 1900 % 400 = 300 → NOT LEAP
     * - 2000: 2000 % 400 = 0 → LEAP YEAR
     */
    public static void question5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isLeap) {
            System.out.println(year + " is a LEAP YEAR");
        } else {
            System.out.println(year + " is NOT a leap year");
        }
    }

    public static void main(String[] args) {
        question5();
    }

}
