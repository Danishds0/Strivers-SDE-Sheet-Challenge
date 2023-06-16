// https://www.codingninjas.com/codestudio/problems/758958?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(char[] arr, int index, List<String> permutations) {
        if (index == arr.length - 1) {
            permutations.add(String.valueOf(arr));
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generatePermutationsHelper(arr, index + 1, permutations);
            swap(arr, index, i); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
