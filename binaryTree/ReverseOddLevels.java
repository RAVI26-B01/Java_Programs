package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class ReverseOddLevels {
	
	
	public Node reverseOddLevels(Node root) {
	    if(root == null){
	        return root; 
	    }
	
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root); 
	    int level = 0; 
	
	    while(!queue.isEmpty()){
	        int size = queue.size(); 
	        List<Node> current = new ArrayList<>();
	
	        for(int i = 0; i < size; i++){
	        	Node node = queue.poll();
	            current.add(node); 
	
	            if(node.left != null){
	                queue.offer(node.left); 
	            }
	            if(node.right != null){
	                queue.offer(node.right); 
	            }
	        }
	        if(level % 2 == 1){
	            reverseValues(current); 
	        }
	        level++; 
	    }
	
	    return root; 
	}
	private void reverseValues(List<Node> nodes){
	    int i = 0, j = nodes.size()-1; 
	    while(i < j){
	        int tmp = nodes.get(i).data; 
	        nodes.get(i).data = nodes.get(j).data; 
	        nodes.get(j).data = tmp; 
	        i++; 
	        j--; 
	    }
	}
		
	
	public Node reverseOddLevels1(Node root) {
        if( root == null )
        return root ; 

       int level = 0 ;
       Queue<Node> q = new LinkedList<>() ; 
       q.add(root) ; 
       Node temp1 = null ;
       q.add(temp1) ; 
       Stack<Integer> stack = new Stack<>() ; 

       while( q.size() != 1 )
       {
             Node temp = q.remove() ; 

             if( temp == null)
             {
                 level++ ; 
                 q.add(temp) ; 
                 continue ; 
             }
             
           if( level % 2 == 0 )
           {
               if( temp.left != null)
               {
                   q.add(temp.left); 
                   stack.push(temp.left.data) ; 
               }
               if( temp.right != null)
               {
            	   q.add(temp.right) ; 
            	   stack.push(temp.right.data) ; 
            	   
               }
           }
           else
           {
              temp.data = stack.pop() ;
              if( temp.left != null )
              {
                  q.add(temp.left);
              }
              if( temp.right != null )
              {
            	  q.add(temp.right) ;
              }
           }
       } 
       return root ; 
    }

}
