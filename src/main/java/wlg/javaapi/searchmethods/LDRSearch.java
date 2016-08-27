package wlg.javaapi.searchmethods;
/**
 * 中序遍历(LDR)首先遍历左子树，然后访问根结点，最后遍历右子树。在遍历左、右子树时，仍然先遍历左子树，再访问根结点，最后遍历右子树
 *
 */
public class LDRSearch {

  static void ldrSearch(TreeNode tree){
    if(tree==null){
      return;
    }else{
      ldrSearch(tree.getLeftTree());
      System.out.print("\t"+tree.getData());
      ldrSearch(tree.getRightTree());
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
    ldrSearch(tree);
  }

}
