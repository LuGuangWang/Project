package wlg.arithmetic;

import java.util.Stack;


/**
 * 反转tree的左右子树
 */
public class ReverseTree {
  class Tree{
    private String data;
    private Tree left;
    private Tree right;
    
    public Tree(){}
    
    public Tree(String data){
      this.data = data;
    }
    
    public String getData() {
      return data;
    }
    public void setData(String data) {
      this.data = data;
    }
    public Tree getLeft() {
      return left;
    }
    public void setLeft(Tree left) {
      this.left = left;
    }
    public Tree getRight() {
      return right;
    }
    public void setRight(Tree right) {
      this.right = right;
    }
  }
  
  
  public void DLR(Tree root){
    if(root != null){
      System.out.print("==>" + root.getData());
      
      DLR(root.left);
      DLR(root.right);
    }
  }
  
  /**
   * 非递归实现
   */
  public void reverse2(Tree root){
    Tree tmp;
    Stack<Tree> stack = new Stack<>();
    if(root != null){
      swap(root);
      stack.push(root);
      //遍历左子树
      while(!stack.isEmpty()){
        tmp = stack.peek();
        if(tmp.left != null){
          swap(tmp.left);
          stack.push(tmp.left);
        }else{
          while(!stack.isEmpty()){
            tmp = stack.pop();
            if(tmp.right!=null){
              swap(tmp.right);
              stack.push(tmp.right);
              break;
            }
          }
        }
      }
      
      
      
    }
  }
  
  /**
   * 递归实现
   */
  public void reverse(Tree root){
    if(root != null){
      swap(root);
      
      reverse(root.left);
      reverse(root.right);
    }
  }

  void swap(Tree root) {
    Tree tmp;
    tmp = root.left;
    root.left = root.right;
    root.right = tmp;
  }
  
  
  
  public static void main(String[] args) {
    ReverseTree reverse = new ReverseTree();
    
    Tree a = reverse.new Tree("A");
    Tree b = reverse.new Tree("B");
    Tree c = reverse.new Tree("C");
    Tree d = reverse.new Tree("D");
    Tree e = reverse.new Tree("E");
    Tree f = reverse.new Tree("F");
    
    Tree root = a;
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;
    System.out.println("---------原先树的顺序-----------");
    reverse.DLR(root);
    
    reverse.reverse(root);
    System.out.println("\n---------递归反转-----------");
    reverse.DLR(root);
    
    reverse.reverse2(root);
    System.out.println("\n---------正常反转-----------");
    reverse.DLR(root);
    
  }

}
