// Given a string s, find the length of the longest
// substring
// without repeating characters.
// Example:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// https://www.codingninjas.com/codestudio/problems/630418?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
// Time Complexity - O(n) Using TreeMap /Unordered Map
// Space Complexity - O(n)

import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		Map<Character, Integer> map = new TreeMap<>();
		int left = 0, right = 0, count = 0;
		while(right < input.length()){
			if(map.containsKey(input.charAt(right))){
				left = Math.max(map.get(input.charAt(right)) + 1, left);
			}
			map.put(input.charAt(right), right);
			count = Math.max(count, right - left + 1);
			right++;
		}
		return count;
	}
}
