/**
 * ============================================
 * PHASE 6 - MIXED CHALLENGES
 * Level 3: Array Logic (Questions 21-30)
 * ============================================
 * 
 * CONCEPT: Advanced array problems combining multiple techniques.
 * 
 * TOPICS:
 * - Sliding window
 * - Two pointers
 * - Sorting techniques
 * - Array transformations
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level3_ArrayLogic {
    
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
    // QUESTION 21: Rotate matrix 90 degrees clockwise
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For n×n matrix:
     * 1. Transpose the matrix (swap rows and columns)
     * 2. Reverse each row
     * 
     * Or: result[j][n-1-i] = original[i][j]
     */
    public static void question21() {
        System.out.print("Enter matrix size n: ");
        int n = sc.nextInt();
        
        int[][] matrix = new int[n][n];
        System.out.println("Enter " + n + "x" + n + " matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\n=== Rotate 90° Clockwise ===");
        System.out.println("Original:");
        printMatrix(matrix);
        
        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
        System.out.println("Rotated:");
        printMatrix(matrix);
    }
    
    // =========================================================================
    // QUESTION 22: Spiral order traversal
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Traverse matrix in spiral: right → down → left → up
     * Maintain boundaries: top, bottom, left, right
     * Shrink boundaries after each direction.
     */
    public static void question22() {
        System.out.print("Enter rows: ");
        int m = sc.nextInt();
        System.out.print("Enter columns: ");
        int n = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        System.out.println("Enter " + m + "x" + n + " matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\n=== Spiral Order ===");
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        System.out.print("Spiral: ");
        while (top <= bottom && left <= right) {
            // Right
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
            
            // Down
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }
            
            // Up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 23: Maximum sum subarray of size k (Sliding Window)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Fixed-size sliding window technique.
     * 1. Calculate sum of first k elements
     * 2. Slide: add new element, remove oldest
     * 3. Track maximum sum
     * 
     * Time: O(n)
     */
    public static void question23() {
        int[] arr = inputArray();
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();
        
        System.out.println("\n=== Max Sum Subarray of Size " + k + " ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        if (k > arr.length) {
            System.out.println("k is larger than array");
            return;
        }
        
        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        int maxStart = 0;
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];  // Add new, remove old
            if (windowSum > maxSum) {
                maxSum = windowSum;
                maxStart = i - k + 1;
            }
        }
        
        System.out.println("Maximum sum: " + maxSum);
        System.out.print("Subarray: [");
        for (int i = maxStart; i < maxStart + k; i++) {
            System.out.print(arr[i] + (i < maxStart + k - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
    
    // =========================================================================
    // QUESTION 24: Container with most water (Two Pointers)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Given heights, find max water container.
     * Two pointers: start and end.
     * Area = width × min(left_height, right_height)
     * Move pointer with smaller height inward.
     * 
     * Time: O(n)
     */
    public static void question24() {
        int[] heights = inputArray();
        
        System.out.println("\n=== Container with Most Water ===");
        System.out.println("Heights: " + Arrays.toString(heights));
        
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        int bestLeft = 0, bestRight = 0;
        
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;
            
            if (area > maxArea) {
                maxArea = area;
                bestLeft = left;
                bestRight = right;
            }
            
            // Move shorter line
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println("Maximum area: " + maxArea);
        System.out.println("Between indices " + bestLeft + " and " + bestRight);
        System.out.println("Heights: " + heights[bestLeft] + " and " + heights[bestRight]);
    }
    
    // =========================================================================
    // QUESTION 25: Three sum to zero
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find all unique triplets that sum to zero.
     * 1. Sort array
     * 2. Fix one element, use two pointers for other two
     * 3. Skip duplicates
     * 
     * Time: O(n²)
     */
    public static void question25() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Three Sum = 0 ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        
        System.out.println("\nTriplets:");
        boolean found = false;
        
        for (int i = 0; i < arr.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            int left = i + 1, right = arr.length - 1;
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == 0) {
                    System.out.println("[" + arr[i] + ", " + arr[left] + ", " + arr[right] + "]");
                    found = true;
                    
                    // Skip duplicates
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        if (!found) {
            System.out.println("No triplets found");
        }
    }
    
    // =========================================================================
    // QUESTION 26: Dutch National Flag (Sort 0s, 1s, 2s)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Three-way partitioning.
     * Maintain three pointers: low, mid, high
     * - 0s go to [0, low)
     * - 1s stay in [low, high]
     * - 2s go to (high, n-1]
     * 
     * Time: O(n), Space: O(1)
     */
    public static void question26() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Dutch National Flag ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {  // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
        
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // =========================================================================
    // QUESTION 27: Next Permutation
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find next lexicographically greater permutation.
     * 1. Find rightmost pair where arr[i] < arr[i+1]
     * 2. Find rightmost element > arr[i]
     * 3. Swap them
     * 4. Reverse suffix after position i
     * 
     * Example: [1,2,3] → [1,3,2] → [2,1,3] → [2,3,1] → [3,1,2] → [3,2,1]
     */
    public static void question27() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Next Permutation ===");
        System.out.println("Current: " + Arrays.toString(arr));
        
        int n = arr.length;
        int i = n - 2;
        
        // Find rightmost ascending pair
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            // Find rightmost element > arr[i]
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        
        // Reverse suffix
        int left = i + 1, right = n - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        
        System.out.println("Next: " + Arrays.toString(arr));
    }
    
    // =========================================================================
    // QUESTION 28: Maximum product subarray
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Similar to Kadane's but track both max and min.
     * Negative × negative = positive
     * So minimum might become maximum.
     */
    public static void question28() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Maximum Product Subarray ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int maxProduct = arr[0];
        int maxEnding = arr[0];
        int minEnding = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int temp = maxEnding;
            
            maxEnding = Math.max(arr[i], Math.max(maxEnding * arr[i], minEnding * arr[i]));
            minEnding = Math.min(arr[i], Math.min(temp * arr[i], minEnding * arr[i]));
            
            maxProduct = Math.max(maxProduct, maxEnding);
        }
        
        System.out.println("Maximum product: " + maxProduct);
    }
    
    // =========================================================================
    // QUESTION 29: Trapping Rain Water
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Water at position i = min(leftMax, rightMax) - height[i]
     * 
     * Method: Precompute leftMax and rightMax arrays.
     * Time: O(n), Space: O(n)
     */
    public static void question29() {
        int[] height = inputArray();
        
        System.out.println("\n=== Trapping Rain Water ===");
        System.out.println("Heights: " + Arrays.toString(height));
        
        int n = height.length;
        if (n < 3) {
            System.out.println("Water trapped: 0");
            return;
        }
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        System.out.println("Water trapped: " + water);
    }
    
    // =========================================================================
    // QUESTION 30: Majority Element (Boyer-Moore Voting)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Majority element appears more than n/2 times.
     * Boyer-Moore: Track candidate and count.
     * - Same as candidate: increment count
     * - Different: decrement count
     * - Count = 0: new candidate
     * 
     * Time: O(n), Space: O(1)
     */
    public static void question30() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Majority Element ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        // Find candidate
        int candidate = arr[0];
        int count = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
        
        // Verify
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        
        if (count > arr.length / 2) {
            System.out.println("Majority element: " + candidate);
            System.out.println("Appears " + count + " times (more than " + arr.length / 2 + ")");
        } else {
            System.out.println("No majority element exists");
        }
    }
    
    // =========================================================================
    // HELPER METHODS
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
    
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
