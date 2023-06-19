// Problem Description
// Given two equally sized 1-D arrays A, B containing N integers each.
// A sum combination is made by adding one element from array A and another element of array B.
// Return the maximum C valid sum combinations from all the possible sum combinations.
  
// https://www.codingninjas.com/codestudio/problems/k-max-sum-combinations_975322?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
  
import java.util.* ;
import java.io.*; 
import javafx.util.*;

public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> A, ArrayList<Integer> B, int n, int k){
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(Collections.reverseOrder());
        // int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair<>(A.get(i) + B.get(n - 1), new Pair<>(i, n - 1)));
        }
        
        while (!pq.isEmpty() && k-- > 0) {
            Pair<Integer, Pair<Integer, Integer>> tp = pq.poll();
            int vl = tp.getKey();
            int x = tp.getValue().getKey();
            int y = tp.getValue().getValue();
            ans.add(vl);
            
            if (y != 0) {
                pq.offer(new Pair<>(A.get(x) + B.get(y - 1), new Pair<>(x, y - 1)));
            }
        }
        
        return ans;
    }
}
