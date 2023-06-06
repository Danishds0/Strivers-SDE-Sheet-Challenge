// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// Example:
// Input: x = 2, n = 10
// Output: 1024
// https://www.codingninjas.com/codestudio/problems/1082146?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Power Exponentiation TC- O(n) SC- O(n)
  
import java.io.*;
import java.util.* ;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        return (int)findExp((long) x, (long) n, (long) m);
    }
    static long findExp(long x, long n, long m){
        if(n == 0) return 1;
        long sq = findExp(x, n / 2, m);
        long res = (sq * sq) % m;
        if(n % 2 == 1) return (res * x) % m;
        return res;
    }
}
