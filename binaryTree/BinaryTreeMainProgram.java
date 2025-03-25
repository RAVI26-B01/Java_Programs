package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import binarySearch.SearchInTree;
import leetcode.BSTtoGST_1038;
import leetcode.PathSum_112;
import practice.Practice;

@SuppressWarnings({"unused", "resource"})
public class BinaryTreeMainProgram {
	static int max_level=0;
	static Node root ;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to Insert");
			System.out.println("press 2 to Pre-Order");
			System.out.println("press 3 to In-Order");
			System.out.println("press 4 to Post-Order");
			System.out.println("press 5 to Level-Order");
			System.out.println("press 6 to Zig_Zag-Order");
			System.out.println("press 7 to Maximun-Depth");
			System.out.println("press 8 to Top-View");
			System.out.println("press 9 to left view Elements");
			System.out.println("press 10 to right view Elements");
			System.out.println("press 11 to Bottom-View");
			System.out.println("press 12 to Boundary traversal");
			System.out.println("press 13 to Reverse odd levels");
			System.out.println("press 14 to Covert BST to GST");
			System.out.println("press 15 to Check Path-Sum");
			System.out.println("press 16 to Deepest Leaves sum");
			System.out.println("press 17 to Longest Diameter of Tree");
			System.out.println("press 18 to Vertical Order Traversal");
			System.out.println("press 19 to Check Balanced Binary Tree");
			System.out.println("press 20 to check Symetric");
			System.out.println("press 21 to Root to Node Path");
			System.out.println("press 22 to Root to Node All Path");
			System.out.println("press 23 to find lowest common ancestors");
			System.out.println("press 24 to Find Width of Tree");
			System.out.println("press 25 to Print Nodes at K distance");
			System.out.println("press 26 to Find Time Required to Burn Tree");
			System.out.println("press 27 to Count Nodes");
			System.out.println("press 28 to Serialize & De-Serialize");
			System.out.println("press 29 to Morris Travel");
			System.out.println("press 30 to Search in Binary Tree");
			System.out.println("press 31 to find Ceil");
			System.out.println("press 32 to find Floor");
			System.out.println("press 33 to delete Node");
			System.out.println("press 34 to check BST or BT");
			System.out.println("press 100 to Print-Tree");
			System.out.println();
			
			System.out.println("enter your choice");
			int choice=scan.nextInt();
				switch(choice) {
					case 1:insert();break;
					case 2:preorderTraversal1(root);break;
					case 3:inorderTraversal1(root);break;
					case 4:postorderTraversal1(root);break;
					case 5:leverOrderTraversal(root);break;
					case 6:zigZagOrderTraversal(root);break;
					case 7:maximunDepth(root);break;
					case 8:topView(root);break;
					case 9:leftView(root);break;
					case 10:rightView(root);break;
					case 11:bottomView(root);break;
					case 12:boundaryTraversal(root);break;
					case 13:reverseOddLevels(root);break;
					case 14:BSTTOGST(root);break;
					case 15:checkPathSum(root);break;
					case 16:deepestLeavesSum(root);break;
					case 17:diameterOfTree(root);break;
					case 18:verticalOrderTraversal(root);break;
					case 19:checkBalanceBinaryTree(root);break;
					case 20:checkSymetric(root);break;
					case 21:rootToNodepath(root);break;
					case 22:rootToNodeAllPath(root);break;
					case 23:findLowestCommonAncestors(root);break;
					case 24:findWidthOfTree(root);break;
					case 25:printKDistanceNodes(root);break;
					case 26:timeToBurnTree(root);break;
					case 27:countNodes(root);break;
					case 28:serializeDeserialize(root);break;
					case 29:morrisTravel(root);break;
					case 30:searchNode(root);break;
					case 31:findCeil(root);break;
					case 32:findFloor(root);break;
					case 33:deleteNode(root);break;
					case 34:checkBstOrBt(root);break;
					case 35:flattenBTtoLL(root);break;
					case 100:printTree(root);break;
					default :System.out.println("program terminated :-((");System.exit(0);
					
				}
			}
		}
	

	//approach - 1
	private static void insert() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		
		Node node=new Node();
		node.left=null;
		node.data=item;
		node.right=null;
		
		Node current,previous;
		if(root == null){
			root=node;
		}else{
			previous=null;
			current=root;
			while(current!=null){
				if(node.data<current.data){
					previous=current;
					current=current.left;
				}
				else{
					previous=current;
					current=current.right;
				}
			}
			if(node.data<previous.data){
				previous.left=node;
			}
			else{
				previous.right=node;
			}
		}
	}
	
	//approach - 2
	private static void insert1() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		
		Node node=new Node();
		node.left=null;
		node.data=item;
		node.right=null;
		
		Node current,previous;
		if(root == null){
			root=node;
		}else{
			current = root;
			while(true) {
				if(node.data >= current.data) {
					if(current.right !=null) {
						current=current.right;
					}else {
						current.right = node;
						break;
					}
				}else {
					if(current.left != null) {
						current = current.left;
					}else {
						current.left = node;
						break;
					}
				}
			}
		}
	}
	
	
	public static  void preorderTraversal(Node current) {
		if(current!=null){
			System.out.print(current.data+" ");
			preorderTraversal(current.left);
			preorderTraversal(current.right);
		}
	}
	
	public static  void preorderTraversal1(Node current) {
		TreeTraversal_iterative traversal_iterative = new TreeTraversal_iterative();
		List<Integer> preOrderTraversal = traversal_iterative.preOrderTraversal(current);
		System.out.println(preOrderTraversal);
	}
	
	private static void inorderTraversal(Node current) {
		if(current!=null){
			inorderTraversal(current.left);
			System.out.print(current.data+" ");
			inorderTraversal(current.right);
		}
	}
	
	private static void inorderTraversal1(Node current) {
		TreeTraversal_iterative traversal_iterative = new TreeTraversal_iterative();
		List<Integer> inOrderTraversal = traversal_iterative.inOrderTraversal(current);
		System.out.println(inOrderTraversal);
	}
	
	private static void postorderTraversal(Node current) {
		if(current!=null){
			postorderTraversal(current.left);
			postorderTraversal(current.right);
			System.out.print(current.data+" ");
		}
	}
	
	private static void postorderTraversal1(Node current) {
		TreeTraversal_iterative traversal_iterative = new TreeTraversal_iterative();
		List<Integer> postOrderTraversal = traversal_iterative.postOrderTraversal(current);
		System.out.println(postOrderTraversal);
	}
	
	private static void leverOrderTraversal(Node current) {
		List<List<Integer>> levelOrderTraversal = TreeTraversal.levelOrderTraversal(current);
		System.out.println(levelOrderTraversal);
	}
	
	private static void zigZagOrderTraversal(Node current) {
		List<List<Integer>> zigZagOrderTraversal = TreeTraversal.zigZagOrderTraversal(current);
		System.out.println(zigZagOrderTraversal);
	}
	
	private static void verticalOrderTraversal(Node current) {
		List<List<Integer>>  verticalOrderTraversal = TreeTraversal.verticalOrderTraversal(current);
		System.out.println(verticalOrderTraversal);
		
	}

	private static void maximunDepth(Node current) {
		int max_depth = max_depth(current);
		System.out.println(max_depth);
	}


	private static int max_depth(Node current) {
		if(current==null)
			return 0;
		int l = max_depth(current.left);
		int r = max_depth(current.right);
		return 1+Math.max(l, r);
	}
	

	private static void topView(Node current) {
		TreeViews view = new TreeViews();
		List<Integer> topView = view.topView(current);
		System.out.println(topView);
	}

	private static  void leftView(Node current) {
		TreeViews view = new TreeViews();
		List<Integer> leftView = view.leftView(current);
		System.out.println(leftView);
	}
	
	private static void rightView(Node current) {
		TreeViews view = new TreeViews();
		List<Integer> rightView = view.rightView(current);
		System.out.println(rightView);
	}
	
	private static void bottomView(Node current) {
		TreeViews view = new TreeViews();
		List<Integer> bottomView = view.bottomView(current);
		System.out.println(bottomView);
		
	}
	
	private static void boundaryTraversal(Node root2) {
		BoundaryTraversal bt = new BoundaryTraversal();
		ArrayList<Integer> printBoundary = bt.PrintBoundary(root2);
		System.out.println(printBoundary);
	}
	
	private static void deepestLeavesSum(Node root) {
		DeepestLeavesSum sum = new DeepestLeavesSum(); 
		int deepestLeavesSum = sum.deepestLeavesSum(root);
		System.out.println(deepestLeavesSum);
	}
	
	private static void reverseOddLevels(Node root2) {
		ReverseOddLevels oddLevels = new ReverseOddLevels();
		oddLevels.reverseOddLevels(root2);
	}
	
	private static void checkPathSum(Node root2) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter Sum Value :");
		int sum=scan.nextInt();
		PathSum_112 pathSum = new PathSum_112();
		boolean hasPathSum = pathSum.hasPathSum(root2, sum);
		System.out.println(hasPathSum);
	}
	
	private static void printTree(Node root2) {
		TreePrinter.printNode(root2);
	}
	
	/*
	 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
	  This path may or may not pass through the root.
	 */
	private static void diameterOfTree(Node root) {
		int[] diameter = new int[1];
        diameter[0] = 0;
        findDiameter(root, diameter);
        System.out.println(diameter[0]);
	}
	 public static int findDiameter(Node root, int[] diameter){
        if(root == null)
            return 0;
        int l = findDiameter(root.left, diameter);
        int r = findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], l+r);
        return 1+Math.max(l,r);
    }

	private static void BSTTOGST(Node root) {
		BSTtoGST_1038 bsTtoGST = new BSTtoGST_1038();
		Node node = bsTtoGST.convertBSTtoGST(root);
		leverOrderTraversal(node);
	}
	
	
	/*
	 * A Binary Tree is balanced if, for all nodes in the tree,
	 *  the difference between left and right subtree height is not more than 1.
	 */
	private static void checkBalanceBinaryTree(Node root) {
		System.out.println(dfsHeight(root) != -1);
	}
	private static int dfsHeight(Node root) {
		if(root ==null)
			return 0;
		int left = dfsHeight(root.left);
		int right = dfsHeight(root.right);
		if(left == -1 ||right == -1|| Math.abs(right - left)>1)
			return -1;
		return Math.max(left,right)+1;
	}
	
	
	/*
	 * Given the root of a binary tree, check whether it is a mirror of itself
	 * leetcode 101
	 */
	private static void checkSymetric(Node root2) {
		System.out.println(checkSymetric(root.left, root.right));
    }

	static boolean checkSymetric(Node left, Node right){
        if(left == null || right ==null)
            return left == right;
        if(left.data != right.data)
            return false;
        
        return checkSymetric(left.left, right.right) && checkSymetric(right.left, left.right);
    }
	
	
	private static void rootToNodepath(Node root) {
		RootToNodePath nodePath = new RootToNodePath();
		System.out.println(nodePath.rootToNodePath(root));
	}

	private static void rootToNodeAllPath(Node root2) {
		RootToNodePath nodePath = new RootToNodePath();
		System.out.println(nodePath.rootToNodeAllPath(root));
	}
	

	private static void findLowestCommonAncestors(Node current) {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		Node lowestCommonAncestor = ancestor.lowestCommonAncestor(current, 25, 125);
		System.out.println(lowestCommonAncestor.data);
	}

	private static void findWidthOfTree(Node root2) {
		TreeTraversal traversal = new TreeTraversal();
		int widthOfBinaryTree = traversal.widthOfBinaryTree(root2);
		System.out.println(widthOfBinaryTree);
	}

	private static void printKDistanceNodes(Node root2) {
		PrintKDistanceNodes distanceNodes = new PrintKDistanceNodes();
		distanceNodes.findDistanceK(root2);
	}
	
	private static void timeToBurnTree(Node root2) {
		MaxTimeToBurnTree burnTree = new MaxTimeToBurnTree();
		burnTree.timeReqToBurnTree(root2);
	}
	
	private static void countNodes(Node root2) {
		CountNodes countNodes = new CountNodes();
		int count = countNodes.countNodes(root2);
		System.out.println(count);
	}
	
	private static void serializeDeserialize(Node root2) {
		SerializeDeserializeTree sd = new SerializeDeserializeTree();
		String serialize = sd.serialize(root2);
		System.out.println(serialize);
		
		Node deSerialize = sd.deSerialize(serialize);
		TreePrinter.printNode(deSerialize);
	}
	
	private static void morrisTravel(Node root2) {
		MorrisTravel morrisTravel = new MorrisTravel();
		List<Integer> inOrder = morrisTravel.inOrder(root2);
		System.out.println("In-Order : "+ inOrder);
		
		Practice name = new Practice();
		List<Integer> inOrder2 = name.inOrder(root2);
		System.out.println("In-Order2 : "+ inOrder2);
		
		List<Integer> preOrder = morrisTravel.preOrder(root2);
		System.out.println("Pre-Order : "+ preOrder);
	}
	
	private static void searchNode(Node root2) {
		SearchInTree searchInTree = new SearchInTree();
		Node search = searchInTree.search(root2);
		if(search != null) {
			System.out.println("Node found :" + search.data);
		}else {
			System.err.println("Node not found");
		}
	}
	

	private static void findCeil(Node root2) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter key : ");
		int key = scan.nextInt();
		System.out.println(SearchInTree.findCeil(root2, key));
	}
	

	private static void findFloor(Node root2) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter key : ");
		int key = scan.nextInt();
		System.out.println(SearchInTree.findFloor(root2, key));
		
	}
	
	private static void deleteNode(Node root2) {
		DeleteNode delete = new DeleteNode();
		Node delete1 = delete.delete1(root2);
	}
	
	private static void checkBstOrBt(Node root2) {
		
	}
	
	
	private static void flattenBTtoLL(Node root2) {
		FlattenBTtoLinkedList bTtoLinkedList = new FlattenBTtoLinkedList();
		bTtoLinkedList.flatternTree1(root2);
		printTree(root2);
	}

}



