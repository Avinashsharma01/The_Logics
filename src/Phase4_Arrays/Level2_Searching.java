/**
 * ============================================
 * PHASE 4 - ARRAYS
 * Level 2: Searching (Questions 11-20)
 * ============================================
 * 
 * CONCEPT: Finding elements and their properties in arrays.
 * 
 * KEY TECHNIQUES:
 * - Linear Search: O(n) - works on any array
 * - Binary Search: O(log n) - requires sorted array
 * - Frequency counting: Using loops or HashMap
 * 
 * COMMON PATTERNS:
 * - Search and return index
 * - Count occurrences
 * - Find all positions
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Level2_Searching {
    
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
    // QUESTION 11: Linear Search - find element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Scan array from left to right.
     * Return index if found, -1 if not found.
     * Time: O(n), Space: O(1)
     */
    public static void question11() {
        int[] arr = inputArray();
        
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== Linear Search ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int index = linearSearch(arr, target);
        
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found in array");
        }
    }
    
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Found at index i
            }
        }
        return -1;  // Not found
    }
    
    // =========================================================================
    // QUESTION 12: Count frequency of element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Traverse array and count matches.
     */
    public static void question12() {
        int[] arr = inputArray();
        
        System.out.print("Enter element to count: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== Frequency Count ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int count = 0;
        for (int element : arr) {
            if (element == target) {
                count++;
            }
        }
        
        System.out.println(target + " appears " + count + " times");
    }
    
    // =========================================================================
    // QUESTION 13: Find all occurrences (indices)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Store all matching indices in a list.
     */
    public static void question13() {
        int[] arr = inputArray();
        
        System.out.print("Enter element to find: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== All Occurrences ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        ArrayList<Integer> indices = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indices.add(i);
            }
        }
        
        if (indices.isEmpty()) {
            System.out.println(target + " not found");
        } else {
            System.out.println(target + " found at indices: " + indices);
        }
    }
    
    // =========================================================================
    // QUESTION 14: Binary Search (for sorted array)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 1. Set left = 0, right = n-1
     * 2. Find mid = (left + right) / 2
     * 3. If arr[mid] == target, return mid
     * 4. If target < arr[mid], search left half
     * 5. If target > arr[mid], search right half
     * 
     * Time: O(log n), Space: O(1)
     * 
     * VISUALIZATION for arr = [1, 3, 5, 7, 9], target = 7:
     * 
     * Step 1: left=0, right=4, mid=2
     *         [1, 3, 5, 7, 9]
     *          L     M     R
     *         arr[2]=5 < 7, search right
     * 
     * Step 2: left=3, right=4, mid=3
     *         [1, 3, 5, 7, 9]
     *                 L  R
     *                 M
     *         arr[3]=7 == 7, found at index 3!
     */
    public static void question14() {
        int[] arr = inputArray();
        Arrays.sort(arr);  // Binary search requires sorted array
        
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== Binary Search ===");
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }
    }
    
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow
            
            if (arr[mid] == target) {
                return mid;  // Found
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }
        
        return -1;  // Not found
    }
    
    // =========================================================================
    // QUESTION 15: First and last occurrence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Traverse to find first and last index of target.
     */
    public static void question15() {
        int[] arr = inputArray();
        
        System.out.print("Enter element to find: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== First and Last Occurrence ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int first = -1, last = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;  // Set first only once
                }
                last = i;  // Update last every time
            }
        }
        
        if (first == -1) {
            System.out.println(target + " not found");
        } else {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        }
    }
    
    // =========================================================================
    // QUESTION 16: Search and return all unique elements
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For each element, check if it appeared before.
     * If not, it's unique at this position.
     */
    public static void question16() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Unique Elements ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        System.out.print("Unique elements: ");
        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            
            // Check if this element appeared before
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 17: Find duplicates
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For each element, check if it appears later.
     * Print only first occurrence of duplicates.
     */
    public static void question17() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Duplicate Elements ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        System.out.print("Duplicates: ");
        boolean found = false;
        
        for (int i = 0; i < arr.length; i++) {
            // Check if already printed
            boolean alreadyPrinted = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            
            if (!alreadyPrinted) {
                // Check if appears later
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == arr[i]) {
                        System.out.print(arr[i] + " ");
                        found = true;
                        break;
                    }
                }
            }
        }
        
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 18: Frequency of all elements
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print each unique element with its count.
     */
    public static void question18() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Frequency of All Elements ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        boolean[] visited = new boolean[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                int count = 1;
                
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                        visited[j] = true;
                    }
                }
                
                System.out.println(arr[i] + " appears " + count + " time(s)");
            }
        }
    }
    
    // =========================================================================
    // QUESTION 19: Find missing number (1 to n)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Array of size n-1 contains numbers from 1 to n with one missing.
     * Sum of 1 to n = n*(n+1)/2
     * Missing = Expected Sum - Actual Sum
     * 
     * Example: [1, 2, 4, 5] n=5
     * Expected = 5*6/2 = 15
     * Actual = 1+2+4+5 = 12
     * Missing = 15 - 12 = 3
     */
    public static void question19() {
        System.out.print("Enter n (range 1 to n): ");
        int n = sc.nextInt();
        
        int[] arr = new int[n - 1];
        System.out.println("Enter " + (n-1) + " numbers (one from 1 to " + n + " is missing):");
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("\n=== Find Missing Number ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        
        int missing = expectedSum - actualSum;
        
        System.out.println("Expected sum (1 to " + n + "): " + expectedSum);
        System.out.println("Actual sum: " + actualSum);
        System.out.println("Missing number: " + missing);
    }
    
    // =========================================================================
    // QUESTION 20: Find element that appears once
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * If all others appear twice, use XOR.
     * a ^ a = 0, a ^ 0 = a
     * XOR of all elements gives the unique one.
     * 
     * Alternative: Count frequency method.
     */
    public static void question20() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Element Appearing Once ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        // Method 1: XOR (if others appear twice)
        int xorResult = 0;
        for (int num : arr) {
            xorResult ^= num;
        }
        System.out.println("Using XOR (if others appear twice): " + xorResult);
        
        // Method 2: Count frequency
        System.out.println("\nElements appearing exactly once:");
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(arr[i]);
            }
        }
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
