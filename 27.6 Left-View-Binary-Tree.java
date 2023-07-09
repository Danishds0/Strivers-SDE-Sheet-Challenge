// Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

// Left view of following tree is 1 2 4 8.

//           1
//        /     \
//      2        3
//    /     \    /    \
//   4     5   6    7
//    \
//      8   

// Example 1:

// Input:
//    1
//  /  \
// 3    2
// Output: 1 3

//Using Queue
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int len = q.size();
            boolean flag = true;
            while(len > 0){
                Node temp = q.poll();
                if(flag){
                    list.add(temp.data);
                    flag = false;
                }
                
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                len--;
            }
        }
        return list;
    }
}

// Using Recursion



//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }
    void helper(Node root, ArrayList<Integer> list, int level){
        if(root == null) return;
        
        if(level == list.size()){
            list.add(root.data);
        }
        
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }
}
