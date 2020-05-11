package wlg.javaapi.searchmethods;

import java.util.Stack;

/**
 * 前序遍历（DLR）是二叉树遍历的一种，也叫做先根遍历、先序遍历、前序周游，可记做根左右。
 * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树
 */
public class DLRSearch {
  static void dlrSearch(TreeNode tree){
    System.out.print("\t"+tree.getData());
    TreeNode left = tree.getLeftTree();
    if(left!=null)
      dlrSearch(left);
    TreeNode right = tree.getRightTree();
    if(right!=null)
      dlrSearch(right);
  }

  static void dlrStachSearch(TreeNode tree){
    Stack<TreeNode> stack = new Stack<>();
    while(tree != null || !stack.isEmpty()){
      while (tree != null){
        System.out.print(tree.getData() + " ");
        stack.push(tree);
        tree = tree.getLeftTree();
      }
      if(!stack.isEmpty()){
        tree = stack.pop();
        tree = tree.getRightTree();
      }

    }

  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    TreeNode tree2 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(3);
    TreeNode tree4 = new TreeNode(4);
    TreeNode tree5 = new TreeNode(5);
    TreeNode tree6 = new TreeNode(6);
    tree.setLeftTree(tree2);
    tree.setRightTree(tree3);
    tree2.setLeftTree(tree4);
    tree2.setRightTree(tree5);
    tree3.setLeftTree(tree6);
    dlrSearch(tree);
    System.out.println();
    dlrStachSearch(tree);
  }

}
