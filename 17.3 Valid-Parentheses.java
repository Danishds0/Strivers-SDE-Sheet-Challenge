// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
//     Open brackets must be closed by the same type of brackets.
//     Open brackets must be closed in the correct order.
//     Every close bracket has a corresponding open bracket of the same type.
// Example :
// Input: s = "()"
// Output: true

// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') st.add(c);

            else{
                if(st.empty()) return false;
                if(c == ')' && st.peek() == '(') st.pop();
                else if(c == '}' && st.peek() == '{') st.pop();
                else if(c == ']' && st.peek() == '[') st.pop();
                else return false;
            }

        }
        return st.empty();
    }
}
