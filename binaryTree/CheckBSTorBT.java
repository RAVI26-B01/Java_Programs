package binaryTree;

public class CheckBSTorBT {

	//approach -1
	public boolean isValidBst(Node root) {
		return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBst(Node root, int minValue, int maxValue) {
		if(root == null)
			return true;
		if(root.data >= maxValue || root.data <= minValue)
			return false;
		
		return isValidBst(root.left,minValue,root.data ) &&
				isValidBst(root.right, root.data, maxValue);
	}
	
	
	//approach - 2
	  public boolean isBST(Node root) {
        boolean[] flag = {true};  
        int[] temp = {Integer.MIN_VALUE}; 
        inorder(root, temp, flag);
        return flag[0];  
	  }
	  
	  public void inorder(Node root, int[] temp, boolean[] flag) {
        if (root == null) return;
        inorder(root.left, temp, flag);
        
        if (root.data <= temp[0]) {
            flag[0] = false;
            return;  // No need to check further, the tree is not a BST
        }
        temp[0] = root.data;
        inorder(root.right, temp, flag);
	    }
}
