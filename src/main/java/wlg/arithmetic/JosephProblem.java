package wlg.arithmetic;



/**
 * 约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
 *  例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3，1。
 */
public class JosephProblem {
  
  public static void main(String[] args) {
    int n = 7,m = 3;
    JosephProblem instance = new JosephProblem();
    instance.printJoseph(n, m);
    instance.printJoseph1(n, m);
    
    int index = instance.printJoseph2(n, m);
    System.out.println("the remained val:"+(index+1));
  }
  
  int printJoseph2(int n,int m){
    int index = 0;
    if(n == 0){
      return 0;
    }else if(n>0){
      index = (printJoseph2(n-1,m)+m)%n;
    }
    return index;
  }
  
  
  /**
   * 推导出公式
   * 顺序是从零开始的
   * f(0) = 0;
   * f(n) = (f(n-1)+m)%n;
   */
  void printJoseph1(int n,int m){
    int index = 0;
    for(int i=1;i<=n;i++){
      index = (index+m)%i;
    }
    //下标从0开始的
    System.out.println("the remained:"+(index+1));
  }
  

  void printJoseph(int n,int gap) {
    for(int i = 1;i<=n;i++){
      add(i);
    }
    Node next = null,tmp = null;  
    
    for(int j = 1;j<=gap;j++){
      if(j==gap){
        tmp = removeNext(next);
        System.out.print(tmp.data + " ");
        if(next.equals(next.next)){
          System.out.print(next.data + " ");
          break;
        }else{
          j = 1;
        }
      }
      next = next==null?head:next.next;
    }
  }
  
  private class Node{
    private int data;
    private Node next;
    private Node(int data){
      this.data = data;
    }
  }
  
  private Node head,last;
  
  public void add(int e){
    Node l = last;
    Node ele = new Node(e);
    last = ele;
    if(l==null){
      head = ele;
    }else{
      l.next = ele;
    }
    last.next = head;
  }
  
  public Node removeNext(Node e){
    Node next = e.next;
    e.next = next.next;
    return next;
  }
}
