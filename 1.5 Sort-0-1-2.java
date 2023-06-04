// If we talk about the brute force solution so Just simply solve using any sorting algorithm and the time complexity will be O(nlogn)
// Better : Using variable for counting 0, 1, 2 and the replace with the array.
// Optimal : The best solution is to keep track the 0, 1, and 2 by using pointer apprach and then just swap with the function.

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int low = 0, mid = 0, high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }
}

// TIme complexity - O(n)
// Space complexity - O(1)
