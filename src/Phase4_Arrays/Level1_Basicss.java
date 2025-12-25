/**
 * ============================================
 * PHASE 4 - ARRAYS
 * Level 1: Basics (Questions 1-10)
 * ============================================
 * 
 * CONCEPT: Arrays are contiguous memory locations storing same type elements.
 * 
 * KEY CONCEPTS:
 * - Declaration: int[] arr = new int[size];
 * - Access: arr[index] (0-indexed)
 * - Length: arr.length
 * - Traversal: for loop or for-each loop
 * 
 * COMMON PATTERNS:
 * - Linear traversal: O(n)
 * - Finding max/min: Track as you traverse
 * - Accumulation: Running sum/product
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level1_Basicss {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question1();
        // question2();
        // question3();
        // question4();
        // question5();
        // question6();
        // question7();
        // question8();
        // question9();
        // question10();
    }
    
    // =========================================================================
    // QUESTION 1: Input & print array
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Basic array operations:
     * 1. Create array of given size
     * 2. Input elements using loop
     * 3. Print elements using loop
     */
    public static void question1() {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        // Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Print elements - Method 1: for loop
        System.out.println("\n=== Array Elements ===");
        System.out.print("Using for loop: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        // Method 2: for-each loop
        System.out.print("\nUsing for-each: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        
        // Method 3: Arrays.toString
        System.out.println("\nUsing Arrays.toString: " + Arrays.toString(arr));
    }
    
    // =========================================================================
    // QUESTION 2: Sum of elements
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Initialize sum = 0
     * Add each element to sum
     * Time: O(n), Space: O(1)
     */
    public static void question2() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Sum of Array Elements ===");
        
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
    }
    
    // =========================================================================
    // QUESTION 3: Average of elements
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Average = Sum / Count
     * Use double for accurate division.
     */
    public static void question3() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Average of Array Elements ===");
        
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        
        double average = (double) sum / arr.length;
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Count = " + arr.length);
        System.out.printf("Average = %.2f%n", average);
    }
    
    // =========================================================================
    // QUESTION 4: Maximum element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Assume first element is maximum.
     * Compare with each element and update if larger found.
     */
    public static void question4() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Maximum Element ===");
        
        int max = arr[0];  // Assume first is max
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum = " + max);
    }
    
    // =========================================================================
    // QUESTION 5: Minimum element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Similar to max, but update when smaller found.
     */
    public static void question5() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Minimum Element ===");
        
        int min = arr[0];  // Assume first is min
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Minimum = " + min);
    }
    
    // =========================================================================
    // QUESTION 6: Count positive, negative, zero
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use three counters.
     * Check each element and increment appropriate counter.
     */
    public static void question6() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Count Positive/Negative/Zero ===");
        
        int positive = 0, negative = 0, zero = 0;
        
        for (int element : arr) {
            if (element > 0) {
                positive++;
            } else if (element < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Positive count: " + positive);
        System.out.println("Negative count: " + negative);
        System.out.println("Zero count: " + zero);
    }
    
    // =========================================================================
    // QUESTION 7: Count even and odd
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Even if element % 2 == 0, else odd.
     */
    public static void question7() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Count Even and Odd ===");
        
        int even = 0, odd = 0;
        
        for (int element : arr) {
            if (element % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }
    
    // =========================================================================
    // QUESTION 8: Index of maximum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Track both the max value and its index.
     */
    public static void question8() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Index of Maximum Element ===");
        
        int maxIndex = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum element: " + arr[maxIndex]);
        System.out.println("Index: " + maxIndex);
    }
    
    // =========================================================================
    // QUESTION 9: Index of minimum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Track both the min value and its index.
     */
    public static void question9() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Index of Minimum Element ===");
        
        int minIndex = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Minimum element: " + arr[minIndex]);
        System.out.println("Index: " + minIndex);
    }
    
    // =========================================================================
    // QUESTION 10: Elements greater than k
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Compare each element with k and print if greater.
     */
    public static void question10() {
        int[] arr = inputArray();
        
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        
        System.out.println("\n=== Elements Greater than " + k + " ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        System.out.print("Elements > " + k + ": ");
        int count = 0;
        for (int element : arr) {
            if (element > k) {
                System.out.print(element + " ");
                count++;
            }
        }
        
        if (count == 0) {
            System.out.print("None");
        }
        System.out.println("\nCount: " + count);
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
