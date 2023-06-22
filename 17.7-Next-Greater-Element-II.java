// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example :
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

// https://leetcode.com/problems/next-greater-element-ii/description/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_II {
    public static int[] nextGreater(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            if(i < n){
                nge[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }
        int[] ans = nextGreater(nums);
        System.out.println(Arrays.toString(ans));
        scan.close();
    }
}

