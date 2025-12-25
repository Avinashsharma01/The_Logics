/**
 * ============================================
 * PHASE 4 - ARRAYS
 * Level 4: Aggregate Logic (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: Operations involving multiple arrays or aggregate analysis.
 * 
 * KEY OPERATIONS:
 * - Merge arrays
 * - Compare arrays
 * - Find common/uncommon elements
 * - Union and intersection
 * 
 * PATTERNS:
 * - Two-pointer for sorted arrays
 * - Nested loops for unsorted
 * - HashSet for efficient lookup
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Level4_AggregateLogic {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question31();
        // question32();
        // question33();
        // question34();
        // question35();
        // question36();
        // question37();
        // question38();
        // question39();
        // question40();
    }
    
    // =========================================================================
    // QUESTION 31: Merge two arrays
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Create new array of combined size.
     * Copy all elements from both arrays.
     */
    public static void question31() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Merge Two Arrays ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        int[] merged = new int[arr1.length + arr2.length];
        int index = 0;
        
        // Copy first array
        for (int num : arr1) {
            merged[index++] = num;
        }
        
        // Copy second array
        for (int num : arr2) {
            merged[index++] = num;
        }
        
        System.out.println("Merged: " + Arrays.toString(merged));
    }
    
    // =========================================================================
    // QUESTION 32: Merge two sorted arrays (maintaining sorted order)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two-pointer technique:
     * - Compare elements from both arrays
     * - Add smaller one to result
     * - Move that pointer forward
     * - Handle remaining elements
     * 
     * Time: O(n+m), Space: O(n+m)
     */
    public static void question32() {
        System.out.println("=== Sorted Array 1 ===");
        int[] arr1 = inputArray();
        Arrays.sort(arr1);
        System.out.println("=== Sorted Array 2 ===");
        int[] arr2 = inputArray();
        Arrays.sort(arr2);
        
        System.out.println("\n=== Merge Sorted Arrays ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        // Compare and merge
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        
        // Copy remaining from arr1
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        
        // Copy remaining from arr2
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        
        System.out.println("Merged (sorted): " + Arrays.toString(merged));
    }
    
    // =========================================================================
    // QUESTION 33: Check if two arrays are equal
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two arrays are equal if:
     * 1. Same length
     * 2. Same elements at same positions
     */
    public static void question33() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Check Arrays Equal ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        boolean equal = true;
        
        if (arr1.length != arr2.length) {
            equal = false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    equal = false;
                    break;
                }
            }
        }
        
        System.out.println("Arrays are " + (equal ? "EQUAL" : "NOT EQUAL"));
        
        // Using Arrays.equals
        System.out.println("Using Arrays.equals: " + Arrays.equals(arr1, arr2));
    }
    
    // =========================================================================
    // QUESTION 34: Find common elements (Intersection)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For each element in arr1, check if it exists in arr2.
     * Avoid duplicates in result.
     */
    public static void question34() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Common Elements (Intersection) ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        ArrayList<Integer> common = new ArrayList<>();
        
        for (int i = 0; i < arr1.length; i++) {
            // Check if already added
            boolean alreadyAdded = false;
            for (int j = 0; j < i; j++) {
                if (arr1[j] == arr1[i]) {
                    alreadyAdded = true;
                    break;
                }
            }
            
            if (!alreadyAdded) {
                // Check if exists in arr2
                for (int num : arr2) {
                    if (arr1[i] == num) {
                        common.add(arr1[i]);
                        break;
                    }
                }
            }
        }
        
        System.out.println("Common elements: " + common);
    }
    
    // =========================================================================
    // QUESTION 35: Find union of two arrays
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Union = All unique elements from both arrays.
     */
    public static void question35() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Union of Arrays ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        ArrayList<Integer> union = new ArrayList<>();
        
        // Add unique elements from arr1
        for (int num : arr1) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }
        
        // Add unique elements from arr2
        for (int num : arr2) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }
        
        System.out.println("Union: " + union);
    }
    
    // =========================================================================
    // QUESTION 36: Find elements only in first array (Difference)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Elements in arr1 but not in arr2.
     */
    public static void question36() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Difference (arr1 - arr2) ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        ArrayList<Integer> difference = new ArrayList<>();
        
        for (int i = 0; i < arr1.length; i++) {
            // Check if already added
            boolean alreadyAdded = false;
            for (int j = 0; j < i; j++) {
                if (arr1[j] == arr1[i]) {
                    alreadyAdded = true;
                    break;
                }
            }
            
            if (!alreadyAdded) {
                // Check if NOT in arr2
                boolean found = false;
                for (int num : arr2) {
                    if (arr1[i] == num) {
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    difference.add(arr1[i]);
                }
            }
        }
        
        System.out.println("Elements only in Array 1: " + difference);
    }
    
    // =========================================================================
    // QUESTION 37: Check if array is subset of another
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * arr1 is subset of arr2 if every element of arr1 exists in arr2.
     */
    public static void question37() {
        System.out.println("=== Array 1 (check if subset) ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 (main array) ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Subset Check ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        boolean isSubset = true;
        
        for (int num1 : arr1) {
            boolean found = false;
            for (int num2 : arr2) {
                if (num1 == num2) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                isSubset = false;
                break;
            }
        }
        
        System.out.println("Array 1 is " + (isSubset ? "" : "NOT ") + "a subset of Array 2");
    }
    
    // =========================================================================
    // QUESTION 38: Sum of two arrays element-wise
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Add corresponding elements.
     * Handle different lengths.
     */
    public static void question38() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Element-wise Sum ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        int maxLen = Math.max(arr1.length, arr2.length);
        int[] sum = new int[maxLen];
        
        for (int i = 0; i < maxLen; i++) {
            int val1 = (i < arr1.length) ? arr1[i] : 0;
            int val2 = (i < arr2.length) ? arr2[i] : 0;
            sum[i] = val1 + val2;
        }
        
        System.out.println("Element-wise sum: " + Arrays.toString(sum));
    }
    
    // =========================================================================
    // QUESTION 39: Find symmetric difference
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Symmetric difference = (A - B) ∪ (B - A)
     * Elements in either array but not in both.
     */
    public static void question39() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Symmetric Difference ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Add elements in arr1 but not in arr2
        for (int num : arr1) {
            boolean inArr2 = false;
            for (int n : arr2) {
                if (num == n) {
                    inArr2 = true;
                    break;
                }
            }
            if (!inArr2 && !result.contains(num)) {
                result.add(num);
            }
        }
        
        // Add elements in arr2 but not in arr1
        for (int num : arr2) {
            boolean inArr1 = false;
            for (int n : arr1) {
                if (num == n) {
                    inArr1 = true;
                    break;
                }
            }
            if (!inArr1 && !result.contains(num)) {
                result.add(num);
            }
        }
        
        System.out.println("Symmetric difference: " + result);
    }
    
    // =========================================================================
    // QUESTION 40: Dot product of two arrays
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Dot product = sum of products of corresponding elements.
     * Dot(A, B) = A[0]*B[0] + A[1]*B[1] + ... + A[n]*B[n]
     * 
     * Arrays must be same length.
     */
    public static void question40() {
        System.out.println("=== Array 1 ===");
        int[] arr1 = inputArray();
        System.out.println("=== Array 2 ===");
        int[] arr2 = inputArray();
        
        System.out.println("\n=== Dot Product ===");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        
        if (arr1.length != arr2.length) {
            System.out.println("Arrays must be of same length for dot product!");
            return;
        }
        
        int dotProduct = 0;
        StringBuilder calculation = new StringBuilder();
        
        for (int i = 0; i < arr1.length; i++) {
            dotProduct += arr1[i] * arr2[i];
            calculation.append(arr1[i]).append("*").append(arr2[i]);
            if (i < arr1.length - 1) {
                calculation.append(" + ");
            }
        }
        
        System.out.println("Calculation: " + calculation);
        System.out.println("Dot Product: " + dotProduct);
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
