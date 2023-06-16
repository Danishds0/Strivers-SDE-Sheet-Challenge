// Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1 ... xN (0 <= xi <= 1,000,000,000).
// His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
// Input
// * Line 1: Two space-separated integers: N and C
// * Lines 2..N+1: Line i+1 contains an integer stall location, xi
// Output
// For each test case output one integer: the largest minimum distance.
// Example
// Input: 5 3
//        1 2 8 4 9
// Output:
// 3

// Output details:
// FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
// resulting in a minimum distance of 3.

// https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTab=0

import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int start = 1, end = stalls[stalls.length - 1] - stalls[0];

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isPossible(stalls, stalls.length, mid, k)){
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return end;
    }
    private static boolean isPossible(int[] stalls, int n, int minDistance, int cows){
        int countCows = 1;
        int lastPlaceCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if(stalls[i] - lastPlaceCow >= minDistance){
                countCows++;
                lastPlaceCow = stalls[i];
            }
        }
        if(countCows >= cows) return true;
        return false;
    }
}
