package binaryTree;

// leetcode 1008
public class ConstructBST_FromPreorder_1008 {
	public static void main(String[] args) {
		Node bstFromPreorder = bstFromPreorder(new int[] {100,50,25,75,150,125,175});
		TreePrinter.printNode(bstFromPreorder);
	}
	public static Node bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public static Node bstFromPreorder(int[] A, int bound, int[] i){
        if(i[0] == A.length || A[i[0]] > bound) return null;
        Node root = new Node(A[i[0]++]);
        root.left = bstFromPreorder(A, root.data, i);
        root.right = bstFromPreorder(A, bound, i);
        return root;

    }
}
