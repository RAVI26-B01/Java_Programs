package binaryTree;

// sum of all the leaves
public class DeepestLeavesSum {
/*
 * approach 1
 */
	 int sum = 0;
	    public int deepestLeavesSum(Node root) {
	        int dep = depth(root);
	        LeaveSum(root, dep, 1);
	        return sum;
	    }
	    public int depth(Node root)
	    {
	        if(root == null)
	        	return 0;
	        return Math.max(depth(root.left), depth(root.right))+1;
	    }
	    public void LeaveSum(Node root, int depth, int curr)
	    {
	        if(root != null)
	        {
	            if(curr == depth)
	            {
	                sum += root.data;  
	            }
	            LeaveSum(root.left, depth, curr+1);
	            LeaveSum(root.right, depth, curr+1);
	        }
	    }
	    
	    
	    /*
	     * approach 2
	     */
	    public int deepestLeavesSum2(Node root) {
	        harsh(root,0);
	        return s;
	    }
	    int l=0,s=0;
	    public void harsh(Node root,int len){
	        if(root.left==null && root.right==null){
	            if(len > l){
	                s=0;
	                l=len;
	            }
	            if(len == l)
	            	s+=root.data;
	        }
	        if(root.left!=null)
	        	harsh(root.left,len+1);
	        if(root.right!=null)
	        	harsh(root.right,len+1);
	    }
	    
	}

