// The KMP algorithm takes pattern ܲ, string ܶ and prefix function ܨ as input, and finds a match of ܲ in ܶ.
// KMP performs the comparisons from left to right
//  KMP algorithm needs a preprocessing (prefix function) which takes O(݉) space and time complexity
//  Searching takes O(݊ + ݉) time complexity (does not depend on alphabet size)

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean findPattern(String p, String s) {
        // Write your code here.
        int m = p.length(), n = s.length();
        int[] table = prefixTable(p.toCharArray(), m);

        int i = 0, j = 0;
        while(i < n){
            if(p.charAt(j) == s.charAt(i)){
                i++;
                j++;
                if(j == m) return true;

            }
            else if(j > 0) j = table[j - 1];
            else i++;
        }
        return false;
    }
    public static int[] prefixTable(char[] p, int n){
        int[] table = new int[n];
        table[0] = 0;
        int j = 0, i = 1;
        while(i < n){
            if(p[i] == p[j]){
                table[i] = j + 1;
                i++;
                j++;
            }
            else if(j > 0) j = table[j - 1];
            else{
                table[i] = 0;
                i++;
            }
        }
        return table;
    }
}

// Second Approach

return text.indexOf(pattern);
