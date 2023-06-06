// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.
// Example:
// Input: nums = [1,3,4,2,2]
// Output: 2
// https://leetcode.com/problems/find-the-duplicate-number/description/
// solve in Tc - O(n) and sc - (1)

// Using tortise Hare method or we can say slow and fast pointer method we can detect the cycle and the point where cycle found is our duplicate.
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int slow = arr.get(0), fast = arr.get(0);
        do{
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        }while(slow != fast);

        slow = arr.get(0);

        while(slow != fast){
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return fast;
    }
}
