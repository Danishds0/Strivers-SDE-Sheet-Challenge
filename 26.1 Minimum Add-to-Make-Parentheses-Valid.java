// A parentheses string is valid if and only if:

//     It is the empty string,
//     It can be written as AB (A concatenated with B), where A and B are valid strings, or
//     It can be written as (A), where A is a valid string.

// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

//     For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".

// Return the minimum number of moves required to make s valid.

 

// Example 1:

// Input: s = "())"
// Output: 1

// Example 2:

// Input: s = "((("
// Output: 3


// Time Complexity- O(n)
// Space Complexity- O(n)

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count =
        for(char i : s.toCharArray()){
            if(i == '(') st.push(i);
            if(i == ')'){
                if(st.isEmpty()){
                    count++;
                }
                else{
                    st.pop();
                }
            }
        }
        if(!st.empty()) return count + st.size();
        return count;
    }
}


// Time Complexity- O(n)
// Space Complexity- O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, bal = 0;
        for(int i = 0; i < s.length(); i++){
            bal += s.charAt(i) == '(' ? 1 : -1;
            if(bal == -1){
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}
