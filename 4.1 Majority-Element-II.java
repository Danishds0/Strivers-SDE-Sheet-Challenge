// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// Example:
// Input: nums = [3,2,3]
// Output: [3]
// Example:
// Input: nums = [1]
// Output: [1]
// Example 3:
// Input: nums = [1,2]
// Output: [1,2]

// Same as previous question so the basic approach is use moore's Voting Algorithm

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        int element1 = -1, element2 = -1, count1 = 0, count2 = 0;
        for(int i = 0; i < arr.size(); i++){
            if(element1 == arr.get(i)){
                count1++;
            }
            else if(element2 == arr.get(i)){
                count2++;
            }
            else if(count1 == 0){
                count1 = 1;
                element1 = arr.get(i);
            }
            else if (count2 == 0){
                count2 = 1;
                element2 = arr.get(i);
            }
            
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            if(element1 == arr.get(i)) count1++;
            else if(element2 == arr.get(i)) count2++;
        }
        if(count1 > arr.size() / 3) ans.add(element1);
        if(count2 > arr.size() / 3) ans.add(element2);
        return ans;
    }
}
