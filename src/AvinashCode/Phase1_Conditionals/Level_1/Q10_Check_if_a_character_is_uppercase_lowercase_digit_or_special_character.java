package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q10_Check_if_a_character_is_uppercase_lowercase_digit_or_special_character {


    // =========================================================================
    // QUESTION 10: Check if a character is uppercase, lowercase, digit, or special
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use ASCII values or Character class methods:
     * - Uppercase: 'A' to 'Z' (ASCII 65-90)
     * - Lowercase: 'a' to 'z' (ASCII 97-122)
     * - Digit: '0' to '9' (ASCII 48-57)
     * - Special: Everything else
     *
     * KEY CONCEPT: Character class methods
     * - Character.isUpperCase(ch)
     * - Character.isLowerCase(ch)
     * - Character.isDigit(ch)
     */

    public static void question10(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (Character.isLowerCase(ch)){
            System.out.println(ch + " is an LOWERCASE letter");
        } else if (Character.isUpperCase(ch)) {
            System.out.println(ch + " is a UPPERCASE letter");
        } else if (Character.isDigit(ch)) {
            System.out.println(ch + " is a DIGIT");
        }else {
            System.out.println(ch + " is a SPECIAL CHARACTER");
        }

        // Method 2: Using ASCII ranges
        /*
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println("UPPERCASE");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println("LOWERCASE");
        } else if (ch >= '0' && ch <= '9') {
            System.out.println("DIGIT");
        } else {
            System.out.println("SPECIAL");
        }
        */

    }

    public static void main(String[] args) {
        question10();
    }
}
