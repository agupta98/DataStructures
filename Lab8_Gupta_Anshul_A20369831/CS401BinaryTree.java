import java.util.Stack;

/* 
 * A very simple binary tree class for Lab 8.  The intent is to get you
 * familiar with binary trees and their recursive properties.
 *
 * The tree is built from the left, going across a level.  Thus, at any
 * point in time, the tree is complete.
 *
 * The scaffolding below should aid you in finishing the lab.  Please
 * see the lecture (Lecture 8) associated with the lab.
 *
 * You need to provide code for the following methods:
 *
 *   add()
 *   size_p()      (Called from public method size())
 *   inorder_p()   (Called from public method inorder())
 *   postorder_p() (Called from public method postorder())
 *   preorder_p()  (Called from public method preorder())
 */

public class CS401BinaryTree<E> {
	protected static class TreeNode<E> {
		private TreeNode<E> left, right;
		private E info;

		public TreeNode(E info) {
			left = right = null;
			this.info = info;
		}

		public TreeNode<E> get_left() {
			return left;
		}

		public TreeNode<E> get_right() {
			return right;
		}
	}

	private int index; /*
						 * This is the index of the next node to insert in the
						 * tree.
						 */
	private TreeNode<E> root; /* The absolute root of the tree. */

	/*
	 * Default constructor.
	 */
	public CS401BinaryTree() {
		index = 0;
		root = null;
	}

	/*
	 * ------------------------------------------------------------------
	 * Recursively calculates the size of the tree; i.e., the number of elements
	 * in the binary tree.
	 */
	public int size() {
		return size_p(root);
	}

	/*
	 * Complete the following method to calculate size.
	 */
	private int size_p(TreeNode<E> t) {

		int num_nodes = 0;
		Stack<TreeNode<E>> st = new Stack<TreeNode<E>>();
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 */
		TreeNode<E> temp = t;
		while (true) {
			if (temp != null) {
				while (temp != null) {
					st.push(temp);
					temp = temp.get_left();

				}
			} else {
				if (st.size() == 0)
					break;
				else {
					temp = st.pop();
					num_nodes++;
					temp = temp.get_right();
				}
			}
		}
		return num_nodes;
	}

	private int size_p1(TreeNode<E> t) {
		if (t == null) {
			return 0;
		} else {
			int l = size_p1(t.get_left());
			int r = size_p1(t.get_right());
			return (1 + l + r);
		}

	}

	/*
	 * -------------------------------------------------------------------
	 * Recursively does an inorder traversal of the tree
	 */
	public void inorder() {
		inorder_p(root);
	}

	/*
	 * Complete the following method to do an inorder traversal.
	 */
	private void inorder_p(TreeNode<E> t) {
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 *
		 * Note: t.get_left() gives you the entire left subtree and
		 * t.get_right() gives you the right tree.
		 */
		Stack<TreeNode<E>> st = new Stack<TreeNode<E>>();
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 */
		TreeNode<E> temp = t;
		while (true) {
			if (temp != null) {
				while (temp != null) {
					st.push(temp);
					temp = temp.get_left();

				}
			} else {
				if (st.size() == 0)
					break;
				else {
					temp = st.pop();
					System.out.println(temp.info);
					temp = temp.get_right();
				}
			}
		}
		return;
	}

	/*
	 * --------------------------------------------------------------------
	 * Recursively does an preorder traversal of the tree
	 */
	public void preorder() {
		preorder_p(root);
	}

	/*
	 * Complete the following method to do an preorder traversal.
	 */
	private void preorder_p(TreeNode<E> t) {
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 */
		Stack<TreeNode<E>> st = new Stack<TreeNode<E>>();
		TreeNode<E> temp = t;
		st.push(temp);
		if (temp == null) {
			return;
		}
		while (!st.isEmpty()) {
			temp = st.pop();
			System.out.println(temp.info);
			if (temp.right != null) {
				st.push(temp.right);
			}
			if (temp.left != null) {
				st.push(temp.left);
			}

		}

		/*
		 * if (t != null) { System.out.println(t.info);
		 * preorder_p(t.get_left()); preorder_p(t.get_right()); } return;
		 */
	}

	/*
	 * -------------------------------------------------------------------
	 * Recursively does an postorder traversal of the tree
	 */
	public void postorder() {
		postorder_p(root);
	}

	/*
	 * Complete the following method to do an postorder traversal.
	 */
	private void postorder_p(TreeNode<E> t) {
		/*
		 * ADD YOUR CODE HERE ADD YOUR CODE HERE
		 */
		Stack<TreeNode<E>> s1 = new Stack<TreeNode<E>>();
		TreeNode<E> current = t;
		while(current !=null || !s1.isEmpty()){
			if (current !=null){
				s1.push(current);
				current=current.left;
				
			}
			else{
				TreeNode<E> temp = s1.peek().right;
				if(temp == null){
					temp = s1.pop();
					System.out.println(temp.info);
					while (!s1.isEmpty() && temp == s1.peek().right) {
                        temp = s1.pop();
                        System.out.println(temp.info);
				}
				
			}
				else{
					current = temp;
				}
		}
			
		}
		return;
	}
	/*
	 if (t == null)
	 { return; 
	 } 
	  Stack<TreeNode<E>> s1 = new Stack<TreeNode<E>>(); 
	  Stack<TreeNode<E>> s2 = new Stack<TreeNode<E>>();
	  TreeNode<E> temp = t; 
	  s1.push(temp); 
	  while(!s1.isEmpty()){ temp
	  =s1.pop(); s2.push(temp); if(temp.left !=null){ s1.push(temp.left); }
	  if(temp.right !=null){ s1.push(temp.right); }
	  
	  } while(!s2.isEmpty()){ temp= s2.pop(); System.out.println(temp.info); }
	 */
	/*
	 * if (t != null) { postorder_p(t.get_left()); postorder_p(t.get_right());
	 * System.out.println(t.info); } return; }
	 */

	/*
	 * ------------------------------------------------------------------- Adds
	 * a node to the binary tree. Nodes are added from the left. Thus, each
	 * level in the tree is fleshed out before a new level is started.
	 */
	public void add(E info) {
		/*
		 * Additions are done from the leftmost. Thus, the first node (index 0)
		 * is the root; the second node (index 1) is the left child of the root,
		 * the third node (index 2) is the right child of the root. The fourth
		 * node (index 3) will be the left child of the node at index 1. And so
		 * on.
		 *
		 * To give you some context, the node having index 0 occurs at level 0,
		 * the nodes having indexes 1 and 2 occur at level 1, the nodes having
		 * index 3,4,5 occur at level 2.
		 */

		TreeNode<E> node = new TreeNode<E>(info);

		if (index == 0) {
			root = node;
		} else if (index == 1) {
			root.left = node;
		} else if (index == 2) {
			root.right = node;
		} else if (index == 3) {
			root.left.left = node;
		} else if (index == 4) {
			/*
			 * ADD YOUR CODE HERE ADD YOUR CODE HERE
			 */
			root.left.right = node;
		} else if (index == 5) {
			/*
			 * ADD YOUR CODE HERE ADD YOUR CODE HERE
			 */
			root.right.left = node;
		}

		index++;
	}

	/*
	 * ------------------------------------------------------------------- Each
	 * node in the tree is an object of this type.
	 */

	/*
	 * -------------------------------------------------------------------- Main
	 * driver
	 */
	public static void main(String[] args) {
		CS401BinaryTree<Integer> bt = new CS401BinaryTree<Integer>();

		bt.add(32);
		bt.add(40);
		bt.add(60);
		bt.add(9);
		bt.add(8);
		bt.add(15);
		/*
		 * The above tree will look like: 32 / \ / \ 40 60 / \ / / \ / 9 8 15
		 */
		System.out.println("The tree has " + bt.size() + " nodes.");
		System.out.println();
		System.out.println("Preorder----------------------");
		bt.preorder();
		System.out.println();
		System.out.println("Inorder----------------------");
		bt.inorder();
		System.out.println();
		System.out.println("Postorder----------------------");
		bt.postorder();

		return;
	}
}