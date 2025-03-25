package binaryTree;

public class LowestCommonAncestor {

	/*
	  Brute force approach is
	  find p & q using Root to node path method  
	  save the answers values in different list
	  once the different value find return previous value of list
	  eg: if p=25 & q=75
	      p_ans -> [100, 50, 25]
	  	  q_ans -> [100, 50, 75]
	  output : 50
	  
	 */
	public Node lowestCommonAncestor(Node root, int p, int q) {
        if(root == null || root.data == p || root.data == q )
        {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null ){
            return right;
        }
        else if(right ==null){
            return left;
        }else{
            return root;
        }
	}
	
	 public Node lowestCommonAncestorBST(Node root, Node p, Node q) {
	        if(root == null)
	            return root;
	        if(root.data > p.data && root.data > q.data){
	            return lowestCommonAncestorBST(root.left, p ,q);
	        }
	        if(root.data < p.data && root.data < q.data){
	            return lowestCommonAncestorBST(root.right, p ,q);
	        }
	        return root;
	    }
	 
	 public Node LCAinaBST(Node root, Node p, Node q) {
	        while (root != null) {
	            if (root.data > p.data && root.data > q.data) {
	                root = root.left; 
	            } else if (root.data < p.data && root.data < q.data) {
	                root = root.right;
	            } else {
	                return root; // The current node is the LCA
	            }
	        }
	        return null; // This line will not be reached if the input is valid (p and q are in the BST)
	    }
}
