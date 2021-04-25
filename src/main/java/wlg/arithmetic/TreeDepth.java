package wlg.arithmetic;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author seven
 *
 */
public class TreeDepth {
	
	
	public static void main(String[] args) {
		TreeDepth b = new TreeDepth();
		Tree root = b.buildTree();
		int depth = b.depth(root);
		System.out.println("depth:" + depth);
	}
	
	int depth(Tree root) {
		int depth = 0;
		if(root!=null) {
			int ld = depth(root.left);
			int rd = depth(root.righ);
			depth = Math.max(ld, rd) + 1;
		}else {
			depth = 0;
		}
		
		return depth;
	}

	Tree buildTree() {
		Tree root = new Tree(1);
		root.righ = new Tree(5);
		Tree left = new Tree(2);
		root.left=left;
		left.righ = new Tree(4);
		left.left = new Tree(3);
		return root;
	}
	
	class Tree {
		private int data;
		private Tree left;
		private Tree righ;

		public Tree(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Tree getLeft() {
			return left;
		}

		public void setLeft(Tree left) {
			this.left = left;
		}

		public Tree getRigh() {
			return righ;
		}

		public void setRigh(Tree righ) {
			this.righ = righ;
		}

	}
}
