package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseOddLevels {
public Node reverseOddLevels(Node root) {
        
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
                   q.add(temp.right) ; 
                   stack.push(temp.left.data) ; 
                   stack.push(temp.right.data) ; 
               }
           }
           else
           {
              temp.data = stack.pop() ;

              if( temp.left != null )
              {
                  q.add(temp.left);
                  q.add(temp.right) ;
              }
           }
       } 
       
       return root ; 
    }

}
