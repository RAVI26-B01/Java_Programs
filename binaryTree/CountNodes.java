package binaryTree;

public class CountNodes {

	/*
	🍇 Formula is (2^TreeLevel - 1). Only works for perfect tree.
	🍇 To determine if its a perfect tree, 
	   go all the way down and count the nodes on left and right side,
	   If they match, its a perfect tree and our formula applies.
	🍇 If its not a perfect tree, 
	   we go on left and right subtree and again determine if they are perfect tree.
	🍇 When we have our left and right heights, we do (1 + left + right)
	🍇 If we reach null, return 0
		TC: (LogN)^2
	 */
	public int countNodes(Node root) {
        if(root == null)
            return 0;
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if(lh == rh){
            // return ((2<<(lh))-1);
            return (int) (Math.pow(2, lh+1)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int findLeftHeight(Node root){
        int lh=0;
        while(root.left!=null){
            root=root.left;
            lh++;
        }
        return lh;
    }
    public int findRightHeight(Node root){
        int rh=0;
        while(root.right!=null){
            root=root.right;
            rh++;
        }
        return rh;
    }
    
    
    
    int depth = 0;
    public int countNodes2(Node root) {
        helper(root);
        return depth;
    }
    private void helper(Node root) {
        if(root == null)
            return;
        depth++;
        helper(root.left);
        helper(root.right);
    }
    
}
