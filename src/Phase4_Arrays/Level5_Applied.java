/**
 * ============================================
 * PHASE 4 - ARRAYS
 * Level 5: Applied Logic (Questions 41-50)
 * ============================================
 * 
 * CONCEPT: Advanced array problems combining multiple concepts.
 * 
 * TOPICS:
 * - Second largest/smallest
 * - Sorted array checks
 * - Pair sum problems
 * - Subarray problems
 * - Kadane's algorithm
 */

import java.util.Scanner;
import java.util.Arrays;

public class Level5_Applied {
    
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
    // QUESTION 41: Check if array is sorted
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Array is sorted (ascending) if each element >= previous element.
     * Compare adjacent elements.
     */
    public static void question41() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Check if Sorted ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        boolean sortedAsc = true;
        boolean sortedDesc = true;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sortedAsc = false;
            }
            if (arr[i] > arr[i - 1]) {
                sortedDesc = false;
            }
        }
        
        if (sortedAsc) {
            System.out.println("Array is sorted in ASCENDING order");
        } else if (sortedDesc) {
            System.out.println("Array is sorted in DESCENDING order");
        } else {
            System.out.println("Array is NOT sorted");
        }
    }
    
    // =========================================================================
    // QUESTION 42: Second largest element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Track both largest and second largest.
     * Update accordingly as we traverse.
     * 
     * Logic:
     * - If current > largest: second = largest, largest = current
     * - Else if current > second AND current != largest: second = current
     */
    public static void question42() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Second Largest Element ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        if (arr.length < 2) {
            System.out.println("Need at least 2 elements!");
            return;
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest (all elements same)");
        } else {
            System.out.println("Largest: " + largest);
            System.out.println("Second Largest: " + secondLargest);
        }
    }
    
    // =========================================================================
    // QUESTION 43: Second smallest element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Similar to second largest but for smallest.
     */
    public static void question43() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Second Smallest Element ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        if (arr.length < 2) {
            System.out.println("Need at least 2 elements!");
            return;
        }
        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }
        
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("No second smallest (all elements same)");
        } else {
            System.out.println("Smallest: " + smallest);
            System.out.println("Second Smallest: " + secondSmallest);
        }
    }
    
    // =========================================================================
    // QUESTION 44: Find pair with given sum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For each element, check if (target - element) exists.
     * 
     * Method 1: Brute force O(n²)
     * Method 2: Two pointers on sorted array O(n log n)
     */
    public static void question44() {
        int[] arr = inputArray();
        
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== Find Pair with Sum ===");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        
        // Method 1: Brute force
        System.out.println("\nPairs with sum " + target + ":");
        boolean found = false;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ") at indices (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("No pair found");
        }
    }
    
    // =========================================================================
    // QUESTION 45: Find triplet with given sum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Three nested loops to check all triplet combinations.
     * Time: O(n³)
     */
    public static void question45() {
        int[] arr = inputArray();
        
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        System.out.println("\n=== Find Triplet with Sum ===");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        
        System.out.println("\nTriplets with sum " + target + ":");
        boolean found = false;
        
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                        found = true;
                    }
                }
            }
        }
        
        if (!found) {
            System.out.println("No triplet found");
        }
    }
    
    // =========================================================================
    // QUESTION 46: Product of array except self
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For each index, calculate product of all elements except current.
     * 
     * Efficient approach (without division):
     * - Left product array: product of all elements to the left
     * - Right product array: product of all elements to the right
     * - Result[i] = left[i] * right[i]
     */
    public static void question46() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Product Except Self ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int n = arr.length;
        int[] result = new int[n];
        
        // Method 1: Simple O(n²)
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }
        
        System.out.println("Result: " + Arrays.toString(result));
        
        // Method 2: Efficient O(n) with left and right products
        int[] left = new int[n];
        int[] right = new int[n];
        int[] efficient = new int[n];
        
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }
        
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            efficient[i] = left[i] * right[i];
        }
        
        System.out.println("Efficient: " + Arrays.toString(efficient));
    }
    
    // =========================================================================
    // QUESTION 47: Maximum subarray sum (Kadane's Algorithm)
    // =========================================================================
    /*
     * LOGIC EXPLANATION (Kadane's Algorithm):
     * - Track current sum and maximum sum
     * - At each element: choose max of (current element, current sum + element)
     * - This decides whether to start fresh or continue
     * 
     * Time: O(n), Space: O(1)
     * 
     * Example: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * i=0: curr=-2, max=-2
     * i=1: curr=max(1,-2+1)=1, max=1
     * i=2: curr=max(-3,1-3)=-2, max=1
     * i=3: curr=max(4,-2+4)=4, max=4
     * i=4: curr=max(-1,4-1)=3, max=4
     * i=5: curr=max(2,3+2)=5, max=5
     * i=6: curr=max(1,5+1)=6, max=6
     * i=7: curr=max(-5,6-5)=1, max=6
     * i=8: curr=max(4,1+4)=5, max=6
     * Answer: 6 (subarray [4,-1,2,1])
     */
    public static void question47() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Maximum Subarray Sum (Kadane's Algorithm) ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < arr.length; i++) {
            // Decide: start fresh or continue
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum = currentSum + arr[i];
            }
            
            // Update maximum
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        System.out.println("Maximum subarray sum: " + maxSum);
        System.out.print("Subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + (i < end ? ", " : ""));
        }
        System.out.println("]");
    }
    
    // =========================================================================
    // QUESTION 48: Leaders in array
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * An element is leader if all elements to its right are smaller.
     * Rightmost element is always a leader.
     * 
     * Traverse from right, track maximum from right.
     */
    public static void question48() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Leaders in Array ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        System.out.print("Leaders: ");
        
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        
        // Store leaders in reverse order
        int[] leaders = new int[n];
        int count = 0;
        
        leaders[count++] = maxFromRight;  // Rightmost is always leader
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders[count++] = arr[i];
                maxFromRight = arr[i];
            }
        }
        
        // Print in left to right order
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(leaders[i] + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 49: Equilibrium index
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Equilibrium index = index where left sum equals right sum.
     * 
     * Approach:
     * 1. Calculate total sum
     * 2. Traverse array, maintain left sum
     * 3. Right sum = total - left - current
     * 4. If left == right, found equilibrium
     */
    public static void question49() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Equilibrium Index ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        boolean found = false;
        
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            
            if (leftSum == rightSum) {
                System.out.println("Equilibrium at index " + i);
                System.out.println("Element: " + arr[i]);
                System.out.println("Left sum = Right sum = " + leftSum);
                found = true;
            }
            
            leftSum += arr[i];
        }
        
        if (!found) {
            System.out.println("No equilibrium index exists");
        }
    }
    
    // =========================================================================
    // QUESTION 50: Peak element
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Peak element is greater than its neighbors.
     * First and last elements only have one neighbor.
     * 
     * For interviews: Binary search approach exists for O(log n).
     */
    public static void question50() {
        int[] arr = inputArray();
        
        System.out.println("\n=== Peak Elements ===");
        System.out.println("Array: " + Arrays.toString(arr));
        
        System.out.print("Peak elements: ");
        boolean found = false;
        
        int n = arr.length;
        
        if (n == 1) {
            System.out.println(arr[0] + " (only element)");
            return;
        }
        
        // Check first element
        if (arr[0] > arr[1]) {
            System.out.print(arr[0] + "(i=0) ");
            found = true;
        }
        
        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + "(i=" + i + ") ");
                found = true;
            }
        }
        
        // Check last element
        if (arr[n - 1] > arr[n - 2]) {
            System.out.print(arr[n - 1] + "(i=" + (n-1) + ") ");
            found = true;
        }
        
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
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
