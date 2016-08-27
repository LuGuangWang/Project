package wlg.javaapi.searchmethods;
/**
 * 后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点
 */
public class LRDSearch {

  static void lrdSearch(TreeNode tree){
    if(tree.getLeftTree()!=null){
      lrdSearch(tree.getLeftTree());
    }
    if(tree.getRightTree()!=null){
      lrdSearch(tree.getRightTree());
    }
    System.out.print("\t"+tree.getData());
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
    lrdSearch(tree);
  }

}
