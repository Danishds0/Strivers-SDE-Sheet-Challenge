// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        subset(s, list, 0, new ArrayList<>());
        return list;
    }
    public void subset(String s, List<List<String>> list, int index, List<String> subList){
        if(index == s.length()){
            list.add(new ArrayList<>(subList));
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindromic(s, index, i)){
                subList.add(s.substring(index, i + 1));
                subset(s, list, i + 1, subList);
                subList.remove(subList.size() - 1);
            }
        }
    }
    public boolean isPalindromic(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
