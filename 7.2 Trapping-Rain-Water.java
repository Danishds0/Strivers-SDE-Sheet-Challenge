// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
// Example :
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


// https://leetcode.com/problems/trapping-rain-water/description/


  import java.util.Scanner;

/**
 * Trapping_Rainwater
 */
public class Trapping_Rainwater {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        int ans = bruteForce_rainwater(arr);
        int ans2 = betterSol_rainwater(arr);
        int ans3 = optimalSol_rainwater(arr);

        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
        scan.close();   
    }
    private static int bruteForce_rainwater(int[] arr) {
        int rainWater = 0, n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int j = i, leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(arr[j], rightMax);
                j++;
            }
            rainWater += (Math.min(leftMax, rightMax) - arr[i]);
        }
        return rainWater;
    }
// Time Complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a nested loop.
// Space Complexity: O(1).
    
    private static int betterSol_rainwater(int[] arr) {
        int rainWater = 0, n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            rainWater += Math.min(suffix[i], prefix[i]) - arr[i];
        }
        return rainWater;
    }
// Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
// Space Complexity: O(N)+O(N) for prefix and suffix arrays.
  
    private static int optimalSol_rainwater(int[] arr) {
        int rainWater = 0;
        int leftMax = 0, rightMax = 0, n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            if(arr[left] <= arr[right]){
                if(leftMax < arr[left]) leftMax = arr[left];
                else rainWater += (leftMax - arr[left]);
                left++;
            }
            else{
                if(rightMax < arr[right]) rightMax = arr[right];
                else rainWater += (rightMax - arr[right]);
                right--;
            }
        }
        return rainWater;
     }
// Time Complexity: O(N) because we are using 2 pointer approach.
// Space Complexity: O(1) because we are not using anything extra.
}
