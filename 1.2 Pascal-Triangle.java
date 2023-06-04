// Problem - https://www.codingninjas.com/codestudio/problems/1089580?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// Sample Input 2 :
// 3
// 4
// 5
// 6
// Sample Output 2 :
// 1 
// 1 1 
// 1 2 1
// 1 3 3 1 
// 1 
// 1 1 
// 1 2 1 
// 1 3 3 1 
// 1 4 6 4 1
// 1 
// 1 1 
// 1 2 1 
// 1 3 3 1 
// 1 4 6 4 1
// 1 5 10 10 5 1


import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Long> generate(int row){
		long ans = 1;
		ArrayList<Long> generateRow = new ArrayList<>();
		generateRow.add(ans);
    // this is used to find out the nCr of a given row from 1 to N;
		for(int col = 1; col < row; col++){
			ans *= (row - col);
			ans /= col;
			generateRow.add(ans);
		}
		return generateRow;
	}
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		ArrayList<ArrayList<Long>> ans = new ArrayList<>();
		for(int i = 1; i <= n; i++){
			ans.add(generate(i));
		}
		return ans;		 
	}
}
