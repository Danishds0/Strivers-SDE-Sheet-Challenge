// Its easy to find the maximum sum of subarray of an array through kadan;s algo
// Time Complexity - O(n) Space Complexity- O(1)

// But eventually when we talk about the brute force apprach may be we can solve the problem in O(n^3) because its having three loop to iterate.
// Better Solution is to enhance the brute force and exclude the last loop. the complexity will be O(n^2).


import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		long sum = 0, max = 0;
		for(int i = 0; i < n; i++){
			sum += arr[i];
			if(sum < 0) sum = 0;
			max = Math.max(max, sum);
		}
		return max;
	}

}
