package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q09_Check_if_a_character_is_vowel_or_consonant {


    // =========================================================================
    // QUESTION 9: Check if a character is vowel or consonant
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Vowels: a, e, i, o, u (both lowercase and uppercase)
     * - Everything else (if letter) is consonant
     *
     * KEY CONCEPT: Character comparison
     * - Characters can be compared using == or using String methods
     * - Consider both uppercase and lowercase
     */


    public static void question9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char ch = sc.next().charAt(0);

        // Convert to lowercase for easier comparison
        char lowerCh = Character.toLowerCase(ch);

        // Check if it's a letter first
        if (!Character.isLetter(ch)){
            System.out.println(ch + " is not a letter");
            return;
        }

        // Method 1: Using if with OR conditions
        if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' ||
                lowerCh == 'o' || lowerCh == 'u') {
            System.out.println(ch + " is a VOWEL");
        } else {
            System.out.println(ch + " is a CONSONANT");
        }

        // Method 2: Using String.indexOf

        /*
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(ch) != -1) {
            System.out.println(ch + " is a VOWEL");
        } else {
            System.out.println(ch + " is a CONSONANT");
        }
        */

    }

    public static void main(String[] args) {
        question9();
    }
}
