package wlg.javaapi.searchmethods;

public class TreeNode{
  private int data;
  private TreeNode leftTree;
  private TreeNode rightTree;
  
  public TreeNode(int data){
    this.data = data;
  }
  
  public int getData() {
    return data;
  }
  public void setData(int data) {
    this.data = data;
  }
  public TreeNode getLeftTree() {
    return leftTree;
  }
  public void setLeftTree(TreeNode leftTree) {
    this.leftTree = leftTree;
  }
  public TreeNode getRightTree() {
    return rightTree;
  }
  public void setRightTree(TreeNode rightTree) {
    this.rightTree = rightTree;
  }
}
