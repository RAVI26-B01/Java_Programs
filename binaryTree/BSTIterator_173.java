package binaryTree;

import java.util.Stack;

//leetcode -173
public class BSTIterator_173 {

	    Stack<Node> stack = new Stack<>();

	    public BSTIterator_173(Node root) {
	        pushAll(root);
	    }
	    
	    public int next() {
	    	Node pop = stack.pop();
	        pushAll(pop.right);
	        return pop.data;
	    }
	    
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

//	    public void pushAll(Node root){
//	        while(root != null ){
//	            stack.push(root);
//	            root = root.left;
//	        }
//	    }
	    
	    public void pushAll(Node node){
	        for(; node != null ; stack.push(node), node=node.left);
	    }
	}

