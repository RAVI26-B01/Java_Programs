package binaryTree;

public class DeepestLeavesSum {

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
	}

