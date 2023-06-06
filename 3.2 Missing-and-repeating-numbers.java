// You are given a read only array of n integers from 1 to n.
// Each integer appears exactly once except A which appears twice and B which is missing.
// Return A and B.
// Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// Note that in your output A should precede B.
// Example:
// Input:[3 1 2 5 3] 
// Output:[3, 4] 

// https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

// Optimal Solution is we already did duplicate Number problem here so according to that we can find repeating number easily and then according to that we can find missing number

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int ans = repeating(arr);
        int sum = arr.stream().reduce(0, Integer::sum);
        
        sum -= ans;
        int totalSum = n * (n + 1) / 2;
        totalSum -= sum; 
        int[] res = new int[2];
        res[0] = totalSum;
        res[1] = ans;
        return res;
    }
    public static int repeating(ArrayList<Integer> arr){
    Set<Integer> seen = new HashSet<>();
        int repeatingNum = -1;

        for (int num : arr) {
            if (seen.contains(num)) {
                repeatingNum = num;
                break;
            }
            seen.add(num);
        }

        return repeatingNum;
    }
}
