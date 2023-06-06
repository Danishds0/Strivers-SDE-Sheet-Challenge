// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// https://www.codingninjas.com/codestudio/problems/842495?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

Two Approach 
// 1. using HashMap we can solve the problem and count the value then compare with n / 2, if it is greater then n/2 then it will the answer otherwise return -1.
// 2. Moore's Voting Algorithm

import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		int count = 0, element = 0;
    for(int i = 0; i < n; i++){
        if(count == 0){
            count = 1;
            element = arr[i];
        }
        else if(element == arr[i]) count++;
        else count--;
    }
    int count1 = 0;
    for(int i = 0; i < n; i++){
        if(element == arr[i]) count1++;
    }
    if(count1 > (n / 2)) return element;
    return -1;
	}
}
