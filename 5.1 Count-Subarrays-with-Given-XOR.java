// Problem Description
// Given an array of integers A and an integer B.
// Find the total number of subarrays having bitwise XOR of all elements equals to B
// Sample Input 1 :
// 2
// 5 8
// 5 3 8 3 10
// 3 7
// 5 2 9
// Sample Output 1 :
// 2
// 1

// https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// Time Complexity- O(n) and Space Complexity- O(n)

import java.io.*;
import java.util.* ;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		int count = 0, xor = 0;
		map.put(0, 1);
		for(int i = 0; i < arr.size(); i++){
			xor ^= arr.get(i);

			int x = xor ^ k;
			if(map.containsKey(x)){
				count += map.getOrDefault(x, 0);
			}
			map.put(xor, map.getOrDefault(xor, 0) + 1);
		}
		return count;
		// Write your code here.
	}
}
