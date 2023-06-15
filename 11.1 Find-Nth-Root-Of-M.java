Sample Input :- 3 27
Sample Output :- 3

//   https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//Time Complexity- O(logn) Space Complexity- O(1) 
public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int start = 1, end = m;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(Math.pow(mid, n) == m) return mid;
            else if(Math.pow(mid, n) > m) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
