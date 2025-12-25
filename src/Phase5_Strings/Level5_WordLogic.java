/**
 * ============================================
 * PHASE 5 - STRINGS
 * Level 5: Word Logic (Questions 41-50)
 * ============================================
 * 
 * CONCEPT: Word-level operations on strings.
 * 
 * KEY TECHNIQUES:
 * - Splitting strings
 * - Word analysis
 * - Anagram checking
 * - Pattern matching
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level5_WordLogic {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question41();
        // question42();
        // question43();
        // question44();
        // question45();
        // question46();
        // question47();
        // question48();
        // question49();
        // question50();
    }
    
    // =========================================================================
    // QUESTION 41: Find longest word
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Split by spaces, track longest.
     */
    public static void question41() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Longest Word ===");
        System.out.println("Sentence: \"" + str + "\"");
        
        String[] words = str.split("\\s+");
        String longest = "";
        
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        
        System.out.println("Longest word: \"" + longest + "\"");
        System.out.println("Length: " + longest.length());
    }
    
    // =========================================================================
    // QUESTION 42: Find shortest word
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Split by spaces, track shortest.
     */
    public static void question42() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Shortest Word ===");
        System.out.println("Sentence: \"" + str + "\"");
        
        String[] words = str.split("\\s+");
        String shortest = words[0];
        
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        
        System.out.println("Shortest word: \"" + shortest + "\"");
        System.out.println("Length: " + shortest.length());
    }
    
    // =========================================================================
    // QUESTION 43: Check if two strings are anagrams
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Anagrams have same characters in different order.
     * "listen" and "silent" are anagrams.
     * 
     * Method 1: Sort and compare
     * Method 2: Character frequency comparison
     */
    public static void question43() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().toLowerCase().replaceAll("\\s", "");
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().toLowerCase().replaceAll("\\s", "");
        
        System.out.println("\n=== Anagram Check ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        // Method 1: Sort and compare
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean isAnagram1 = Arrays.equals(arr1, arr2);
        System.out.println("Sort method: " + isAnagram1);
        
        // Method 2: Frequency count
        int[] freq = new int[26];
        
        if (str1.length() != str2.length()) {
            System.out.println("Frequency method: false (different lengths)");
            return;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
                freq[str1.charAt(i) - 'a']++;
            }
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
                freq[str2.charAt(i) - 'a']--;
            }
        }
        
        boolean isAnagram2 = true;
        for (int count : freq) {
            if (count != 0) {
                isAnagram2 = false;
                break;
            }
        }
        System.out.println("Frequency method: " + isAnagram2);
    }
    
    // =========================================================================
    // QUESTION 44: Check if string is rotation of another
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * If A is rotation of B, then A is substring of B+B.
     * "waterbottle" is rotation of "erbottlewat"
     * Check: "erbottlewaterbottlewat" contains "waterbottle"
     */
    public static void question44() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n=== Rotation Check ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        if (str1.length() != str2.length()) {
            System.out.println("Not rotations (different lengths)");
            return;
        }
        
        String doubled = str2 + str2;
        boolean isRotation = doubled.contains(str1);
        
        System.out.println(str1 + " is " + (isRotation ? "" : "NOT ") + "a rotation of " + str2);
    }
    
    // =========================================================================
    // QUESTION 45: Check if string has all unique characters
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use boolean array to track seen characters.
     */
    public static void question45() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Unique Characters Check ===");
        System.out.println("String: \"" + str + "\"");
        
        boolean[] seen = new boolean[256];
        boolean allUnique = true;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (seen[ch]) {
                allUnique = false;
                System.out.println("Duplicate found: '" + ch + "' at index " + i);
                break;
            }
            seen[ch] = true;
        }
        
        System.out.println("All characters unique: " + allUnique);
    }
    
    // =========================================================================
    // QUESTION 46: Find common characters in two strings
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Characters present in both strings.
     */
    public static void question46() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().toLowerCase();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== Common Characters ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        boolean[] inStr1 = new boolean[26];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                inStr1[ch - 'a'] = true;
            }
        }
        
        boolean[] common = new boolean[26];
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (ch >= 'a' && ch <= 'z' && inStr1[ch - 'a']) {
                common[ch - 'a'] = true;
            }
        }
        
        System.out.print("Common characters: ");
        boolean found = false;
        for (int i = 0; i < 26; i++) {
            if (common[i]) {
                System.out.print((char)('a' + i) + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 47: Remove words containing specific character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Split into words, keep only those without target character.
     */
    public static void question47() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        System.out.print("Enter character: ");
        char target = sc.next().charAt(0);
        
        System.out.println("\n=== Remove Words with Character ===");
        System.out.println("Sentence: \"" + str + "\"");
        System.out.println("Remove words containing: '" + target + "'");
        
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            boolean hasTarget = false;
            for (int i = 0; i < word.length(); i++) {
                if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(target)) {
                    hasTarget = true;
                    break;
                }
            }
            
            if (!hasTarget) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(word);
            }
        }
        
        System.out.println("Result: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 48: Sort words alphabetically
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Split into words, sort, join back.
     */
    public static void question48() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Sort Words Alphabetically ===");
        System.out.println("Original: \"" + str + "\"");
        
        String[] words = str.split("\\s+");
        
        // Bubble sort (for understanding)
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                if (words[j].compareToIgnoreCase(words[j + 1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        System.out.println("Sorted: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 49: Check if string is subsequence of another
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Subsequence: characters appear in same order but not necessarily consecutive.
     * "ace" is subsequence of "abcde"
     */
    public static void question49() {
        System.out.print("Enter main string: ");
        String main = sc.nextLine();
        System.out.print("Enter potential subsequence: ");
        String sub = sc.nextLine();
        
        System.out.println("\n=== Subsequence Check ===");
        System.out.println("Main: \"" + main + "\"");
        System.out.println("Sub: \"" + sub + "\"");
        
        int i = 0, j = 0;
        
        while (i < main.length() && j < sub.length()) {
            if (main.charAt(i) == sub.charAt(j)) {
                j++;  // Match found, move sub pointer
            }
            i++;  // Always move main pointer
        }
        
        boolean isSubsequence = (j == sub.length());
        System.out.println("\"" + sub + "\" is " + (isSubsequence ? "" : "NOT ") + "a subsequence of \"" + main + "\"");
    }
    
    // =========================================================================
    // QUESTION 50: Permutation check (one string is permutation of another)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Same as anagram check - same characters, different order.
     * "dog" and "god" are permutations.
     */
    public static void question50() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n=== Permutation Check ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        if (str1.length() != str2.length()) {
            System.out.println("Not permutations (different lengths)");
            return;
        }
        
        // Frequency count
        int[] freq = new int[256];
        
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }
        
        boolean isPermutation = true;
        for (int count : freq) {
            if (count != 0) {
                isPermutation = false;
                break;
            }
        }
        
        System.out.println("Is permutation: " + isPermutation);
        
        // Visual demonstration
        System.out.println("\nSorted comparison:");
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Sorted str1: " + new String(arr1));
        System.out.println("Sorted str2: " + new String(arr2));
    }
}
