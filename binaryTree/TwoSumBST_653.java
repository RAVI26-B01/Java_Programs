package binaryTree;

import java.util.Stack;

/*
  refer BSTIterator_173 ( leetcode- 173)
 */
// leetcode - 653
public class TwoSumBST_653 {

	public boolean findTarget(Node root, int k) {
	        
	        bstIterator l = new bstIterator(root, false);
	        bstIterator r = new bstIterator(root, true);
	
	        int i = l.next();
	        int j = r.next();
	        while(i < j){
	            if(i + j == k )
	                return true;
	            else if(i + j <k)
	                i = l.next();
	            else
	                j = r.next();
	        }
	    return false;
	    }
	}
	
	class bstIterator{
	    Stack<Node> stack = new Stack<>();
	    boolean reverse = false;
	    bstIterator(Node root, boolean isReverse){
	        reverse = isReverse;
	        pushAll(root);
	    }
	
	    public void pushAll(Node root){
	        while(root != null ){
	            stack.push(root);
	            if(!reverse)
	                root = root.left;
	            else
	                root = root.right;
	        }
	    }
	
	    public int next(){
	    	Node pop = stack.pop();
	         if(!reverse)
	            pushAll(pop.right);
	         else
	            pushAll(pop.left);
	        return pop.data;
	    }

}