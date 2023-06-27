// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.


// https://leetcode.com/problems/longest-common-prefix/description/


class Solution {
    public String longestCommonPrefix(String[] str) {
        
        for(int i = 0; i < str[0].length(); i++){
            char c = str[0].charAt(i);
            for(int j = 1; j < str.length; j++){
                if(i == str[j].length() || str[j].charAt(i) != c)
                    return str[0].substring(0, i);
            }
        }
        return str[0];
    }
}
