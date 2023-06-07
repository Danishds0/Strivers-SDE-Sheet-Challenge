// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You can return the answer in any order.
// Example
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> res = new ArrayList<>();
        
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(s - arr[i])){
                int value = map.get(s - arr[i]);
                int[] ans = new int[2];
                ans[0] = arr[i];
                ans[1] = s - arr[i];
                for(int j = 0; j < value; j++){
                    res.add(ans);
                }
                map.remove(arr[i]);
            }
        }
        return res;
    }
}
