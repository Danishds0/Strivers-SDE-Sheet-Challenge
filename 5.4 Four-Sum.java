// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//     0 <= a, b, c, d < n
//     a, b, c, and d are distinct.
//     nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.
      
      
// https://www.codingninjas.com/codestudio/problems/983605?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] nums, int target, int n) { 
      Arrays.sort(nums);
        for(int i =0;i<n-3;i++){
            for(int j =i+1;j<n-2;j++){
                long t = (long)target-(long)nums[i]-(long)nums[j];
                int k = j+1;
                int l = n-1;
                while(k<l){
                long val = (long)nums[k]+(long)nums[l];
                if(val<t)k++;
                else if(val>t)l--;
                else{
                    return "Yes";
                }
            }
            }
        }
        return "No";  
  }
}
