/**
 * ============================================
 * PHASE 4 - ARRAYS
 * Level 3: Manipulation (Questions 21-30)
 * ============================================
 * 
 * CONCEPT: Transforming and modifying arrays.
 * 
 * KEY OPERATIONS:
 * - Swap elements
 * - Reverse array
 * - Rotate array
 * - Copy/Clone array
 * - Shift elements
 * 
 * PATTERNS:
 * - Two-pointer technique
 * - In-place vs extra space
 * - Cyclic rotation
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level3_Manipulation {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question21();
        // question22();
        // question23();
        // question24();
        // question25();
        // question26();
        // question27();
        // question28();
        // question29();
        // question30();
    }
    
    // =========================================================================
    // QUESTION 21: Reverse an array
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two-pointer technique:
     * - Start pointer at beginning
     * - End pointer at end
     * - Swap elements and move pointers toward center
     * 
     * VISUALIZATION:
     * [1, 2, 3, 4, 5]
     *  ^           ^
     *  s           e
     * 
     * After swap: [5, 2, 3, 4, 1]
     * [5, 2, 3, 4, 1]
     *     ^     ^
     *     s     e
     * 
     * After swap: [5, 4, 3, 2, 1]
     */
    public static void question21() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Reverse Array ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        // Two-pointer approach
        int start = 0, end = arr.length - 1;
        
        while (start < end) {
            // Swap
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
        
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
    
    // =========================================================================
    // QUESTION 22: Swap two elements at given indices
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Simple swap using temporary variable.
     */
    public static void question22() {
        int[] arr = inputArray();
        
        System.out.print("Enter first index: ");
        int i = sc.nextInt();
        System.out.print("Enter second index: ");
        int j = sc.nextInt();
        
        System.out.println("\n=== Swap Elements ===");
        System.out.println("Before swap: " + Arrays.toString(arr));
        
        if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            System.out.println("After swapping index " + i + " and " + j + ": " + Arrays.toString(arr));
        } else {
            System.out.println("Invalid indices!");
        }
    }
    
    // =========================================================================
    // QUESTION 23: Rotate array left by k positions
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Left rotation: First k elements move to end.
     * 
     * Method 1: Using extra array
     * Method 2: Reversal algorithm (in-place)
     *   - Reverse first k elements
     *   - Reverse remaining elements
     *   - Reverse entire array
     * 
     * Example: [1,2,3,4,5], k=2
     * Step 1: Reverse [1,2] -> [2,1,3,4,5]
     * Step 2: Reverse [3,4,5] -> [2,1,5,4,3]
     * Step 3: Reverse all -> [3,4,5,1,2] ✓
     */
    public static void question23() {
        int[] arr = inputArray();
        
        System.out.print("Enter positions to rotate left: ");
        int k = sc.nextInt();
        
        System.out.println("\n=== Left Rotation ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        int n = arr.length;
        k = k % n;  // Handle k > n
        
        // Reversal algorithm
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
        
        System.out.println("After " + k + " left rotations: " + Arrays.toString(arr));
    }
    
    // =========================================================================
    // QUESTION 24: Rotate array right by k positions
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Right rotation: Last k elements move to front.
     * 
     * Reversal algorithm:
     *   - Reverse last k elements
     *   - Reverse first (n-k) elements
     *   - Reverse entire array
     */
    public static void question24() {
        int[] arr = inputArray();
        
        System.out.print("Enter positions to rotate right: ");
        int k = sc.nextInt();
        
        System.out.println("\n=== Right Rotation ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        int n = arr.length;
        k = k % n;  // Handle k > n
        
        // Reversal algorithm
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
        
        System.out.println("After " + k + " right rotations: " + Arrays.toString(arr));
    }
    
    // Helper to reverse portion of array
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    // =========================================================================
    // QUESTION 25: Copy array
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Multiple ways to copy an array:
     * 1. Manual loop
     * 2. Arrays.copyOf()
     * 3. clone()
     * 4. System.arraycopy()
     */
    public static void question25() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Copy Array ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        // Method 1: Manual copy
        int[] copy1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy1[i] = arr[i];
        }
        System.out.println("Manual copy: " + Arrays.toString(copy1));
        
        // Method 2: Arrays.copyOf
        int[] copy2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.copyOf: " + Arrays.toString(copy2));
        
        // Method 3: clone
        int[] copy3 = arr.clone();
        System.out.println("clone(): " + Arrays.toString(copy3));
        
        // Method 4: System.arraycopy
        int[] copy4 = new int[arr.length];
        System.arraycopy(arr, 0, copy4, 0, arr.length);
        System.out.println("System.arraycopy: " + Arrays.toString(copy4));
    }
    
    // =========================================================================
    // QUESTION 26: Move zeros to end
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two-pointer approach:
     * - One pointer for current position
     * - One for next non-zero position
     * 
     * Example: [0, 1, 0, 3, 12]
     * - Move all non-zeros to front
     * - Fill remaining with zeros
     */
    public static void question26() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Move Zeros to End ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        int index = 0;  // Position for next non-zero
        
        // Move all non-zeros to front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        
        // Fill remaining with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }
        
        System.out.println("After moving zeros: " + Arrays.toString(arr));
    }
    
    // =========================================================================
    // QUESTION 27: Separate even and odd
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Similar to move zeros - move evens first, then odds.
     */
    public static void question27() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Separate Even and Odd ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        // Using extra array
        int[] result = new int[arr.length];
        int index = 0;
        
        // First pass: copy evens
        for (int num : arr) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        
        // Second pass: copy odds
        for (int num : arr) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }
        
        System.out.println("Evens first: " + Arrays.toString(result));
    }
    
    // =========================================================================
    // QUESTION 28: Remove duplicates from sorted array
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * In sorted array, duplicates are adjacent.
     * Track unique count, copy only when different from previous.
     * 
     * Example: [1, 1, 2, 2, 3]
     * i=0: arr[0]=1, unique[0]=1, j=1
     * i=1: arr[1]=1 == arr[0], skip
     * i=2: arr[2]=2 != arr[1], unique[1]=2, j=2
     * i=3: arr[3]=2 == arr[2], skip
     * i=4: arr[4]=3 != arr[3], unique[2]=3, j=3
     * Result: [1, 2, 3]
     */
    public static void question28() {
        int[] arr = inputArray();
        Arrays.sort(arr);  // Ensure sorted
        
        System.out.println("\n=== Remove Duplicates (Sorted Array) ===");
        System.out.println("Sorted: " + Arrays.toString(arr));
        
        if (arr.length == 0) {
            System.out.println("Empty array");
            return;
        }
        
        int j = 1;  // Index for unique elements
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[j++] = arr[i];
            }
        }
        
        // Print only unique elements
        System.out.print("After removing duplicates: [");
        for (int i = 0; i < j; i++) {
            System.out.print(arr[i] + (i < j - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("New length: " + j);
    }
    
    // =========================================================================
    // QUESTION 29: Insert element at position
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 1. Create new array of size n+1
     * 2. Copy elements before position
     * 3. Insert new element
     * 4. Copy remaining elements
     */
    public static void question29() {
        int[] arr = inputArray();
        
        System.out.print("Enter element to insert: ");
        int element = sc.nextInt();
        System.out.print("Enter position (0 to " + arr.length + "): ");
        int pos = sc.nextInt();
        
        System.out.println("\n=== Insert Element ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        if (pos < 0 || pos > arr.length) {
            System.out.println("Invalid position!");
            return;
        }
        
        int[] newArr = new int[arr.length + 1];
        
        // Copy elements before position
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        
        // Insert new element
        newArr[pos] = element;
        
        // Copy remaining elements
        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        
        System.out.println("After insert at position " + pos + ": " + Arrays.toString(newArr));
    }
    
    // =========================================================================
    // QUESTION 30: Delete element at position
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 1. Create new array of size n-1
     * 2. Copy elements before position
     * 3. Skip the element to delete
     * 4. Copy remaining elements
     */
    public static void question30() {
        int[] arr = inputArray();
        
        System.out.print("Enter position to delete (0 to " + (arr.length - 1) + "): ");
        int pos = sc.nextInt();
        
        System.out.println("\n=== Delete Element ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        if (pos < 0 || pos >= arr.length) {
            System.out.println("Invalid position!");
            return;
        }
        
        System.out.println("Deleting element " + arr[pos] + " at position " + pos);
        
        int[] newArr = new int[arr.length - 1];
        
        // Copy elements before position
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        
        // Copy elements after position
        for (int i = pos + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        
        System.out.println("After deletion: " + Arrays.toString(newArr));
    }
    
    // =========================================================================
    // HELPER METHOD: Input array
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
