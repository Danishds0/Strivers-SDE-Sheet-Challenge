// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.


// 1. Check from the last that A[i] < A[i + 1] and if it is found then store in the index
// 2. Now check smallest one but greater then breaking point.
// 3. Sort from the index to n and then return the ans.

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> a) 
	{
		int n = a.size();
		int index = -1;
		for(int i = n - 2; i >= 0; i--){
			if(a.get(i) < a.get(i + 1)){
				index = i;
				break;
			}
		}
 		if (index == -1) {
            // reverse the whole array:
            Collections.sort(a);
            return a;
        }


		for(int i = n - 1; i > index; i--){
			if(a.get(i) > a.get(index)){
				int temp = a.get(i);
				a.set(i, a.get(index));
				a.set(index, temp);
				break;
			}
		}
		// List<Integer> sublist = a.subList(index + 1, n);
        // ArrayList<Integer> result = new ArrayList<>(sublist);
        // Collections.reverse(result);
		List<Integer> sublist = a.subList(index + 1, n);
        Collections.sort(sublist);
		return a;
	}
}
