/**
 * ============================================
 * PHASE 6 - MIXED CHALLENGES
 * Level 2: String + Logic (Questions 11-20)
 * ============================================
 * 
 * CONCEPT: Complex string problems combining multiple techniques.
 * 
 * TOPICS:
 * - Pattern matching
 * - String parsing
 * - Text analysis
 * - Advanced manipulations
 */

import java.util.Scanner;

public class Level2_StringLogic {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question11();
        // question12();
        // question13();
        // question14();
        // question15();
        // question16();
        // question17();
        // question18();
        // question19();
        // question20();
    }
    
    // =========================================================================
    // QUESTION 11: Valid parentheses check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For simple parentheses (only one type):
     * Track count of open parentheses.
     * Increment for '(', decrement for ')'.
     * Invalid if count goes negative or doesn't end at 0.
     * 
     * For multiple types: use stack approach.
     */
    public static void question11() {
        System.out.print("Enter string with parentheses: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Valid Parentheses ===");
        System.out.println("String: \"" + str + "\"");
        
        int count = 0;
        boolean valid = true;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    valid = false;
                    System.out.println("Invalid: Extra ')' at position " + i);
                    break;
                }
            }
        }
        
        if (valid && count > 0) {
            valid = false;
            System.out.println("Invalid: " + count + " unclosed '('");
        }
        
        System.out.println("Parentheses are " + (valid ? "VALID" : "INVALID"));
    }
    
    // =========================================================================
    // QUESTION 12: Check if string is numeric
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Valid numeric: optional sign, digits, optional decimal point.
     * Handle edge cases like "+123", "-45.67", ".5", "5."
     */
    public static void question12() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().trim();
        
        System.out.println("\n=== Numeric Check ===");
        System.out.println("String: \"" + str + "\"");
        
        if (str.isEmpty()) {
            System.out.println("Empty string is NOT numeric");
            return;
        }
        
        boolean isNumeric = true;
        int start = 0;
        boolean hasDecimal = false;
        boolean hasDigit = false;
        
        // Check for sign
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            start = 1;
        }
        
        for (int i = start; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '.') {
                if (hasDecimal) {
                    isNumeric = false;  // Multiple decimals
                    break;
                }
                hasDecimal = true;
            } else if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else {
                isNumeric = false;  // Invalid character
                break;
            }
        }
        
        isNumeric = isNumeric && hasDigit;
        
        System.out.println("\"" + str + "\" is " + (isNumeric ? "" : "NOT ") + "numeric");
        
        // Verify with parsing
        try {
            Double.parseDouble(str);
            System.out.println("Verified: Can be parsed as number");
        } catch (NumberFormatException e) {
            System.out.println("Verified: Cannot be parsed");
        }
    }
    
    // =========================================================================
    // QUESTION 13: Extract numbers from string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Scan for digit sequences and extract them.
     */
    public static void question13() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Extract Numbers ===");
        System.out.println("String: \"" + str + "\"");
        
        System.out.print("Numbers found: ");
        StringBuilder current = new StringBuilder();
        int sum = 0;
        
        for (int i = 0; i <= str.length(); i++) {
            if (i < str.length() && Character.isDigit(str.charAt(i))) {
                current.append(str.charAt(i));
            } else {
                if (current.length() > 0) {
                    int num = Integer.parseInt(current.toString());
                    System.out.print(num + " ");
                    sum += num;
                    current = new StringBuilder();
                }
            }
        }
        
        System.out.println("\nSum of all numbers: " + sum);
    }
    
    // =========================================================================
    // QUESTION 14: Roman to Integer conversion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * I=1, V=5, X=10, L=50, C=100, D=500, M=1000
     * 
     * Rule: If smaller value before larger, subtract.
     * IV = 4 (5-1), IX = 9 (10-1)
     * VI = 6 (5+1), XI = 11 (10+1)
     */
    public static void question14() {
        System.out.print("Enter Roman numeral: ");
        String roman = sc.nextLine().toUpperCase();
        
        System.out.println("\n=== Roman to Integer ===");
        System.out.println("Roman: " + roman);
        
        int result = 0;
        
        for (int i = 0; i < roman.length(); i++) {
            int current = romanValue(roman.charAt(i));
            int next = (i + 1 < roman.length()) ? romanValue(roman.charAt(i + 1)) : 0;
            
            if (current < next) {
                result -= current;  // Subtraction case
            } else {
                result += current;
            }
        }
        
        System.out.println("Integer: " + result);
    }
    
    static int romanValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    
    // =========================================================================
    // QUESTION 15: Integer to Roman conversion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Greedy approach: subtract largest possible Roman value repeatedly.
     */
    public static void question15() {
        System.out.print("Enter an integer (1-3999): ");
        int num = sc.nextInt();
        
        System.out.println("\n=== Integer to Roman ===");
        System.out.println("Integer: " + num);
        
        if (num < 1 || num > 3999) {
            System.out.println("Out of range (1-3999)");
            return;
        }
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        System.out.println("Roman: " + roman);
    }
    
    // =========================================================================
    // QUESTION 16: Decode encoded string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Input: "3[a]2[bc]" → "aaabcbc"
     * Parse number, then string in brackets, repeat.
     */
    public static void question16() {
        System.out.print("Enter encoded string (e.g., 3[ab]2[c]): ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Decode String ===");
        System.out.println("Encoded: \"" + str + "\"");
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < str.length()) {
            // Read number
            StringBuilder numStr = new StringBuilder();
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                numStr.append(str.charAt(i));
                i++;
            }
            
            int repeat = numStr.length() > 0 ? Integer.parseInt(numStr.toString()) : 1;
            
            // Read content in brackets
            if (i < str.length() && str.charAt(i) == '[') {
                i++;  // Skip '['
                StringBuilder content = new StringBuilder();
                while (i < str.length() && str.charAt(i) != ']') {
                    content.append(str.charAt(i));
                    i++;
                }
                i++;  // Skip ']'
                
                // Append repeated content
                for (int j = 0; j < repeat; j++) {
                    result.append(content);
                }
            } else if (i < str.length()) {
                result.append(str.charAt(i));
                i++;
            }
        }
        
        System.out.println("Decoded: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 17: Zigzag string conversion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "PAYPALISHIRING" with 3 rows:
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * Read row by row: "PAHNAPLSIIGYIR"
     */
    public static void question17() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();
        
        System.out.println("\n=== Zigzag Conversion ===");
        System.out.println("String: \"" + str + "\"");
        System.out.println("Rows: " + numRows);
        
        if (numRows == 1 || numRows >= str.length()) {
            System.out.println("Result: \"" + str + "\"");
            return;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int row = 0;
        boolean goingDown = false;
        
        for (int i = 0; i < str.length(); i++) {
            rows[row].append(str.charAt(i));
            
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            
            row += goingDown ? 1 : -1;
        }
        
        // Print zigzag pattern
        System.out.println("\nZigzag pattern:");
        for (int i = 0; i < numRows; i++) {
            System.out.println("Row " + i + ": " + rows[i]);
        }
        
        // Concatenate
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        
        System.out.println("\nResult: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 18: Look-and-say sequence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Start with "1"
     * 1 → "one 1" → 11
     * 11 → "two 1s" → 21
     * 21 → "one 2, one 1" → 1211
     * 1211 → "one 1, one 2, two 1s" → 111221
     */
    public static void question18() {
        System.out.print("Enter n (term number): ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Look-and-Say Sequence ===");
        
        String current = "1";
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Term " + i + ": " + current);
            
            if (i < n) {
                current = generateNext(current);
            }
        }
    }
    
    static String generateNext(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            int count = 0;
            
            while (i < s.length() && s.charAt(i) == ch) {
                count++;
                i++;
            }
            
            result.append(count).append(ch);
        }
        
        return result.toString();
    }
    
    // =========================================================================
    // QUESTION 19: Check balanced brackets
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Handle multiple bracket types: (), [], {}
     * Use array as stack.
     */
    public static void question19() {
        System.out.print("Enter string with brackets: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Balanced Brackets ===");
        System.out.println("String: \"" + str + "\"");
        
        char[] stack = new char[str.length()];
        int top = -1;
        boolean balanced = true;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (top == -1) {
                    balanced = false;
                    break;
                }
                
                char open = stack[top--];
                if (!isMatchingPair(open, ch)) {
                    balanced = false;
                    break;
                }
            }
        }
        
        if (top != -1) balanced = false;
        
        System.out.println("Brackets are " + (balanced ? "BALANCED" : "NOT BALANCED"));
    }
    
    static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
    
    // =========================================================================
    // QUESTION 20: Count and Say pattern
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Given a string, describe what you see.
     * "aabbbcc" → "2a3b2c" (two a's, three b's, two c's)
     */
    public static void question20() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count and Say ===");
        System.out.println("String: \"" + str + "\"");
        
        if (str.isEmpty()) {
            System.out.println("Result: \"\"");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < str.length()) {
            char ch = str.charAt(i);
            int count = 0;
            
            while (i < str.length() && str.charAt(i) == ch) {
                count++;
                i++;
            }
            
            result.append(count).append(ch);
        }
        
        System.out.println("Result: \"" + result + "\"");
    }
}
