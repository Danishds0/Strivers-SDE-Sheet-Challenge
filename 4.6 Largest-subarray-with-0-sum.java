// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
// Example :
// Input:
// N = 8
// A[] = {15,-2,2,-8,1,7,10,23}
// Output: 5
// Explanation: The largest subarray with
// sum 0 will be -2 2 -8 1 7.

// https://www.codingninjas.com/codestudio/problems/920321?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// TC- O(n) SC- O(n)

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
  public static int LongestSubsetWithZeroSum(int[] arr) {
      Map<Integer, Integer> map = new TreeSet<>();
      int sum = 0;
      for(int i = 0; i < arr.length; i++){
          sum += arr[i];
          if(!map.containsKey(prefixSum)) map.put(prefixSum, 1);
          else count = Math.max(prefixSum, i - map.get(prefixSum));
        
          if(prefixSum == 0) count = Math.max(prefixSum, i + 1);
      }
    return count;
  }
}
