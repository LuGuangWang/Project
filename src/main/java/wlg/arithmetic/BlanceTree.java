package wlg.arithmetic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [平衡二叉树] 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 平衡二叉树,它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 * @author seven
 */
public class BlanceTree {
	
	
	public static void main(String[] args) {
		BlanceTree b = new BlanceTree();
		Tree root = b.buildTree();
//		int d = b.deep(root);
//		System.out.println("\ndeep:" + d );
		AtomicInteger deep = new AtomicInteger(0);
		boolean res = b.isBalance(root, deep);
		System.out.println("is balence tree: " + res);
	}
	
	boolean isBalance(Tree root,AtomicInteger deep) {
		boolean res = true;
		if(root != null) {
			AtomicInteger ld = new AtomicInteger(deep.get());
			AtomicInteger rd = new AtomicInteger(deep.get());
			boolean lb = isBalance(root.left, ld);
			if(lb==false) {
				return false;
			}
			boolean rb = isBalance(root.righ, rd);
			if(rb==false) {
				return false;
			}
			deep.set(Math.max(ld.get(), rd.get())+1);
			int dis = Math.abs(ld.get() - rd.get());
			res = dis>1?false:true;
		}else {
			deep.set(0);
		}
		
		return res;
	}
	
	int deep(Tree root) {
		int deep = 0;
		if(root!=null) {
			int ldeep = deep(root.left);
			int rdeep = deep(root.righ);
			int dis = ldeep - rdeep;
			System.out.println("dis:" + dis);
			deep = Math.max(ldeep,rdeep) + 1;
		}else{
			deep = 0;
		}
		return deep;
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
