// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
// Example :
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/


import java.util.Scanner;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    //Better Approach
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = scan.nextInt();
        }
        int ans = largestRectangle(heights);
        System.out.println(ans);

        int ans2 = Solution.largest_Rectangle(heights);
        System.out.println(ans2);
        scan.close();
    }
    public static int largestRectangle(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.empty()) left[i] = 0;
            else left[i] = stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            while(!stack.empty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(stack.empty()) right[i] = n - 1;
            else right[i] = stack.peek() - 1;
            stack.push(i);
        }
        return maxArea(heights, left, right);
    }
    private static int maxArea(int[] heights, int[] left, int[] right) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
        }
        return maxArea;
    }
}
//optimal Approach
class Solution {
    public static int largest_Rectangle(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            while(!stack.empty() && (i == n || heights[stack.peek()] >= heights[i])){
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
