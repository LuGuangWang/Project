package wlg.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 寻找树中的最大路径和
 * @author seven
 *
 */
public class TreeMaxPath {

	public static void main(String[] args) {
		TreeMaxPath t = new TreeMaxPath();
		Tree root = t.buildTree();
		AtomicInteger m = new AtomicInteger(Integer.MIN_VALUE);
		t.maxSum(root, m);
		System.out.println(m.get());
	}

	int maxSum(Tree root,AtomicInteger max) {
		if(root==null)
			return 0;
		int lsum = maxSum(root.left, max);
		int rsum = maxSum(root.righ, max);
		if(lsum<0) {
			lsum = 0;
		}
		if(rsum<0) {
			rsum = 0;
		}
		int m = root.data + lsum + rsum;
		max.set(Math.max(max.get(), m));
		
		return root.data + Math.max(lsum, rsum);
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
		protected int data;
		protected Tree left;
		protected Tree righ;

		public Tree(int data) {
			this.data = data;
		}
	}
}
