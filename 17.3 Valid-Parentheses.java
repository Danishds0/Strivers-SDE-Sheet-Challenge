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

//One more approach using stringBuilder 

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        int top = -1;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            if(top < 0 || !isMatch(sb.charAt(top), sb.charAt(i))){
                top++;
                sb.setCharAt(top, sb.charAt(i));
            }
            else top--;
        }
        return top == -1;
    }
    private boolean isMatch(char a, char b){
        if(a == '(' && b == ')') return true;
        if(a == '{' && b == '}') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
}
