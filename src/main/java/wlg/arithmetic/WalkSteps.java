package wlg.arithmetic;

import java.util.Stack;

/**
 * 有n阶台阶，一次可走1阶或2阶，请问有多少种走法
 */
public class WalkSteps {

  //假设10个台阶
  private final int target = 10;
  
  public static void main(String[] args) {
    WalkSteps instance = new WalkSteps();
    instance.walkRoute(instance.target);
    
    instance.walkRoute("",10);
    
    int res = instance.walkCount(10);
    System.out.println(res);
  }
  
  private int walkCount(int steps) {
	  int res = 0;
	  if(steps==0 || steps==1 || steps==2) {
		  res = steps;
	  }else {
		  res = walkCount(steps-1) + walkCount(steps-2);
	  }
	  return res;
  }
  
  private void walkRoute(String route,int steps){
    if(steps<0){
      System.out.println("steps can't less-than zero.");
      return;
    }
    if(steps == 1){
      System.out.println(route + 1);
      return;
    }
    if(steps == 0){
      System.out.println(route);
      return;
    }
    
    for(int i=1;i<=2;i++){
      walkRoute(route + i + " ",steps - i);
    }
  }
  
  class Tree{
    private int data;
    private Tree left;
    private Tree righ;
    
    public Tree(int data){
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
  
  /**
   * 用深度搜索遍历树的方式
   */
  void walkRoute(int step){
    Tree head = new Tree(0),leaf,leaf1,leaf2;
    Stack<Tree> leafs = new Stack<>();
    leafs.push(head);
    for(int i = 0;i<step;i++){
      Stack<Tree> newLeafs = new Stack<>();
      while(!leafs.isEmpty()){
        leaf = leafs.pop();
        leaf1 = new Tree(1);
        newLeafs.push(leaf1);
        leaf.left = leaf1;
        leaf2 = new Tree(2);
        newLeafs.push(leaf2);
        leaf.righ=leaf2;
      }
      leafs.clear();
      leafs = newLeafs;
    }
    printTree(0, head, new Stack<Integer>());
  }
  
  void printTree(int step,Tree head,Stack<Integer> walks){
    if(head.left!=null){
      walks.push(head.left.data);
      step = step + walks.peek();
      if(step == target){
        for(Integer i:walks){
          System.out.print("==>" + i);
        }
        System.out.println();
      }
      printTree(step,head.left,walks);
    }
    if(head.righ!=null){
      step = step - walks.pop() + head.righ.data;
      walks.push(head.righ.data);
      if(step == target){
        for(Integer i:walks){
          System.out.print("==>" + i);
        }
        System.out.println();
      }
      printTree(step,head.righ,walks);
      walks.pop();
    }
  }
  
}
