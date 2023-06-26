// A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
// A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
// Note: Follow 0 based indexing.
// Follow Up: Can you optimize it to O(N)
 
// Example :
// Input:
// N = 3
// M[][] = {{0 1 0},
//          {0 0 0}, 
//          {0 1 0}}
// Output: 1
// Explanation: 0th and 2nd person both
// know 1. Therefore, 1 is the celebrity. 

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            
            if(M[a][b] == 1) st.push(b);
            else st.push(a);
        }
        
        int mainAnswer = st.pop();
        for(int i = 0 ; i < n; i++){
            if(i != mainAnswer){
                if(M[i][mainAnswer] == 0 || M[mainAnswer][i] == 1){
                    return -1;
                }
            }
        }
        return mainAnswer;
    }
}
