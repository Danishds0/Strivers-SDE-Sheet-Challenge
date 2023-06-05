// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
// Example :
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Merge_Interval
 */
public class Merge_Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = interval(arr);
        System.out.println(ans);
        scan.close();
    }
    public static List<List<Integer>> interval(int[][] arr) {
        int n = arr.length;
        //Sort 2D array using comparator with lambda expressions.
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }else{
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }
    
}
