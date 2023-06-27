// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. 
// Do not include any extra spaces.

// Example :
// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Example :
// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.

// https://leetcode.com/problems/reverse-words-in-a-string/description/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        reverse(words, 0, words.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    private void reverse(String[] words, int start, int end){
        while(start <= end){
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;

            start++;
            end--;
        }
    }
}
