/**
 * ============================================
 * PHASE 6 - MIXED CHALLENGES
 * Level 5: Applied Logic (Questions 41-50)
 * ============================================
 * 
 * CONCEPT: Real-world problems combining all concepts.
 * 
 * TOPICS:
 * - Simulation problems
 * - Mathematical puzzles
 * - Optimization problems
 * - Interview favorites
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level5_AppliedLogic {
    
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
    // QUESTION 41: Tower of Hanoi
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Move n disks from source to destination using auxiliary.
     * 1. Move n-1 disks from source to auxiliary
     * 2. Move largest disk from source to destination
     * 3. Move n-1 disks from auxiliary to destination
     * 
     * Minimum moves required = 2^n - 1
     */
    public static void question41() {
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Tower of Hanoi ===");
        System.out.println("Disks: " + n);
        System.out.println("Minimum moves: " + ((1 << n) - 1));
        System.out.println("\nMoves:");
        
        hanoi(n, 'A', 'C', 'B');
    }
    
    static void hanoi(int n, char source, char dest, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + dest);
            return;
        }
        
        hanoi(n - 1, source, aux, dest);
        System.out.println("Move disk " + n + " from " + source + " to " + dest);
        hanoi(n - 1, aux, dest, source);
    }
    
    // =========================================================================
    // QUESTION 42: N-Queens (check if solution exists)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Place N queens on N×N board so no two attack each other.
     * Use backtracking: try placing queen row by row.
     * Check if position is safe (no conflict in column, diagonals).
     */
    public static void question42() {
        System.out.print("Enter n (board size): ");
        int n = sc.nextInt();
        
        System.out.println("\n=== N-Queens ===");
        
        int[] queens = new int[n];  // queens[i] = column of queen in row i
        Arrays.fill(queens, -1);
        
        if (solveNQueens(queens, 0, n)) {
            System.out.println("Solution found:");
            printBoard(queens, n);
        } else {
            System.out.println("No solution exists for n=" + n);
        }
    }
    
    static boolean solveNQueens(int[] queens, int row, int n) {
        if (row == n) return true;  // All queens placed
        
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                if (solveNQueens(queens, row + 1, n)) {
                    return true;
                }
                queens[row] = -1;  // Backtrack
            }
        }
        
        return false;
    }
    
    static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;  // Same column
            if (Math.abs(queens[i] - col) == row - i) return false;  // Diagonal
        }
        return true;
    }
    
    static void printBoard(int[] queens, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 43: Generate all permutations
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use backtracking to generate all arrangements.
     * Swap each element to first position, recurse for rest.
     */
    public static void question43() {
        System.out.print("Enter a string: ");
        String str = sc.next();
        
        System.out.println("\n=== All Permutations ===");
        System.out.println("String: \"" + str + "\"");
        System.out.println("Permutations:");
        
        char[] chars = str.toCharArray();
        permute(chars, 0);
    }
    
    static void permute(char[] chars, int index) {
        if (index == chars.length) {
            System.out.println(new String(chars));
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1);
            swap(chars, index, i);  // Backtrack
        }
    }
    
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // =========================================================================
    // QUESTION 44: Power set (all subsets)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For n elements, there are 2^n subsets.
     * Use bit manipulation: each number from 0 to 2^n-1 represents a subset.
     * Bit i is 1 means include element i.
     */
    public static void question44() {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("\n=== Power Set (All Subsets) ===");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Total subsets: " + (1 << n));
        System.out.println("\nSubsets:");
        
        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }
    }
    
    // =========================================================================
    // QUESTION 45: Josephus Problem
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * N people in circle, every k-th person eliminated.
     * Find position of survivor (0-indexed).
     * 
     * Recursive: J(n, k) = (J(n-1, k) + k) % n
     * Base: J(1, k) = 0
     */
    public static void question45() {
        System.out.print("Enter number of people n: ");
        int n = sc.nextInt();
        System.out.print("Enter k (every k-th eliminated): ");
        int k = sc.nextInt();
        
        System.out.println("\n=== Josephus Problem ===");
        System.out.println("n = " + n + ", k = " + k);
        
        int survivor = josephus(n, k);
        System.out.println("Survivor position (0-indexed): " + survivor);
        System.out.println("Survivor position (1-indexed): " + (survivor + 1));
    }
    
    static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }
    
    // =========================================================================
    // QUESTION 46: Coin change (minimum coins)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Dynamic Programming approach.
     * dp[i] = minimum coins to make amount i
     * dp[i] = min(dp[i], dp[i-coin] + 1) for each coin
     */
    public static void question46() {
        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        
        System.out.println("\n=== Coin Change ===");
        System.out.println("Coins: " + Arrays.toString(coins));
        System.out.println("Amount: " + amount);
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        if (dp[amount] > amount) {
            System.out.println("Cannot make amount with given coins");
        } else {
            System.out.println("Minimum coins needed: " + dp[amount]);
        }
    }
    
    // =========================================================================
    // QUESTION 47: Longest Increasing Subsequence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find length of longest subsequence where elements are increasing.
     * 
     * DP approach: dp[i] = length of LIS ending at index i
     * dp[i] = max(dp[j] + 1) for all j < i where arr[j] < arr[i]
     * 
     * Time: O(n²)
     */
    public static void question47() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Longest Increasing Subsequence ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        System.out.println("Length of LIS: " + maxLen);
    }
    
    // =========================================================================
    // QUESTION 48: Sudoku Solver (simplified - check valid placement)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Check if a number can be placed in a cell:
     * 1. Not in same row
     * 2. Not in same column
     * 3. Not in same 3x3 box
     */
    public static void question48() {
        System.out.println("=== Sudoku Validator ===");
        System.out.println("Enter 9x9 Sudoku (0 for empty):");
        
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\nBoard:");
        printSudoku(board);
        
        boolean valid = isValidSudoku(board);
        System.out.println("\nSudoku is " + (valid ? "VALID" : "INVALID"));
    }
    
    static boolean isValidSudoku(int[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    if (seen[board[i][j]]) return false;
                    seen[board[i][j]] = true;
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != 0) {
                    if (seen[board[i][j]]) return false;
                    seen[board[i][j]] = true;
                }
            }
        }
        
        // Check 3x3 boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] seen = new boolean[10];
                for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                    for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                        if (board[i][j] != 0) {
                            if (seen[board[i][j]]) return false;
                            seen[board[i][j]] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    static void printSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 49: Jump Game (can reach last index)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Each element = max jump length from that position.
     * Check if we can reach the last index.
     * 
     * Greedy: Track farthest reachable position.
     */
    public static void question49() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Jump Game ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int farthest = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i > farthest) {
                System.out.println("Cannot reach index " + i);
                System.out.println("CANNOT reach last index");
                return;
            }
            farthest = Math.max(farthest, i + arr[i]);
            
            if (farthest >= arr.length - 1) {
                System.out.println("CAN reach last index");
                return;
            }
        }
        
        System.out.println("CAN reach last index");
    }
    
    // =========================================================================
    // QUESTION 50: Climbing Stairs (ways to reach top)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Can climb 1 or 2 steps at a time.
     * Ways to reach step n = ways(n-1) + ways(n-2)
     * This is Fibonacci!
     * 
     * Base: ways(1) = 1, ways(2) = 2
     */
    public static void question50() {
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Climbing Stairs ===");
        System.out.println("Steps: " + n);
        
        if (n <= 0) {
            System.out.println("Invalid number of steps");
            return;
        }
        
        if (n == 1) {
            System.out.println("Ways to climb: 1");
            System.out.println("Path: 1");
            return;
        }
        
        if (n == 2) {
            System.out.println("Ways to climb: 2");
            System.out.println("Paths: 1+1, 2");
            return;
        }
        
        int prev2 = 1;  // ways(1)
        int prev1 = 2;  // ways(2)
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        System.out.println("Ways to climb: " + current);
        
        // Show relationship to Fibonacci
        System.out.println("\nNote: This follows Fibonacci pattern!");
        System.out.println("ways(n) = ways(n-1) + ways(n-2)");
    }
    
    // =========================================================================
    // HELPER METHOD
    // =========================================================================
    static int[] inputArray() {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        return arr;
    }
}
