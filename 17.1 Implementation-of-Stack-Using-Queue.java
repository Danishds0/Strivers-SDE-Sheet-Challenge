// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
// Implement the MyStack class:
//     void push(int x) Pushes element x to the top of the stack.
//     int pop() Removes the element on the top of the stack and returns it.
//     int top() Returns the element on the top of the stack.
//     boolean empty() Returns true if the stack is empty, false otherwise.
// Notes:
//     You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
//     Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
// Example :

// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]

// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False


// https://leetcode.com/problems/implement-stack-using-queues/submissions/976992102/

// Time Complexity- O(n) Space Complexity- O(n)

class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();    
    }
    
    public void push(int x) {
        q2.add(x);
        while(!q1.isEmpty()){
            q2.offer(q1.peek());
            q1.poll();
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        if(q1.isEmpty()) return -1;
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

// Using Single Queue<>

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {  
        q.offer(x);
        for(int i = 0; i < q.size() - 1; i++){
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        if(q.isEmpty()) return -1;
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
