// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Implement the MinStack class:
//     MinStack() initializes the stack object.
//     void push(int val) pushes the element val onto the stack.
//     void pop() removes the element on the top of the stack.
//     int top() gets the top element of the stack.
//     int getMin() retrieves the minimum element in the stack.

// You must implement a solution with O(1) time complexity for each function.

// Example :
// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2

// https://leetcode.com/problems/min-stack/description/

import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {
        Stack<Integer> s;
	    int mini;
		
		// Constructor
		public MinStack() 
		{ 
			// Write your code here.
            s = new Stack<>();
            mini = Integer.MAX_VALUE;
		}
		
		// Function to add another element equal to num at the top of stack.
		void push(int num)
		{
			if(s.empty()){
				mini = num;
				s.push(num);
			}
			else{
				if(mini <= num){
					s.push(num);
				}
				else{
					int prev = num;
					num = 2*num - mini;
					mini = prev;
					s.push(num);
				}
			}
		}
		
		// Function to remove the top element of the stack.
		int pop()
		{
			if(!s.empty()){
				int data = s.peek();
				if(data >= mini){
					s.pop();
					return data;
				}
				else{
					int prev = mini;
					mini = 2*mini - data;
					s.pop();
					return prev;
				}
			}
			return -1;
		}
		
		// Function to return the top element of stack if it is present. Otherwise return -1.
		int top()
		{
			if(!s.empty()){
				int data = s.peek();
				if(data >= mini) return data;
				else return mini;
			}
			return -1;
		}
		
		// Function to return minimum element of stack if it is present. Otherwise return -1.
		int getMin()
		{
			if(!s.empty()){
				return mini;
			}
			return -1;
		}
}
}
