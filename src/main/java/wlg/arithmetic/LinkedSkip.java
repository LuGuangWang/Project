package wlg.arithmetic;


/**
 * 一个链表,1,2,3,4,5,6
 * 转换为1,3,5,2,4,6
 */
public class LinkedSkip {
  
  public static void main(String[] args) {
    LinkedSkip instance = new LinkedSkip();
    Node head = instance.buildLinkedList();
    
    Node tmp = head,h=head;
    System.out.println("操作前的顺序：");
    while(tmp!=null){
      System.out.print("===>" + tmp.data);
      tmp = tmp.next;
    }
    
    instance.skipLinked(head, h.next);
    
    System.out.println("\n操作后的顺序：");
    while(head!=null){
      System.out.print("===>" + head.data);
      head = head.next;
    }
    
  }

  void skipLinked1(Node sorted, Node disordered){
    Node data = searchElement(disordered);
    if(data!=null){
      sorted.next = data;
      sorted = sorted.next;
      disordered = sorted.next;
      skipLinked1(sorted,disordered);
    }else{
      sorted.next = disordered;
    }
  }
  
  void skipLinked(Node sorted, Node disordered) {
    Node data;
    while(disordered!=null){
      data = searchElement(disordered);
      if(data==null){
        break;
      }else{
        sorted.next = data;
        sorted = sorted.next;
        disordered = sorted.next;
      }
    }
  }
  
  class Node{
    private int data;
    private Node next;
    
    public Node(int data){
      this.data = data;
    }
    
    public int getData() {
      return data;
    }
    public void setData(int data) {
      this.data = data;
    }
    public Node getNext() {
      return next;
    }
    public void setNext(Node next) {
      this.next = next;
    }
    
  }
  
  Node buildLinkedList() {
    Node node1 = new Node(2);
    Node node2 = new Node(3);
    Node node3 = new Node(4);
    Node node4 = new Node(5);
    Node node5 = new Node(6);
    Node node6 = new Node(7);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    return node1;
  }
  
  Node searchElement(Node tmp){
    Node prev = tmp,head = tmp;
    while(tmp!=null){
      if(tmp.data % 2!=0){
        if(!tmp.equals(prev)){
          prev.next = tmp.next;
          tmp.next = head;
        }
        return tmp;
      }else{
        prev = tmp;
        tmp = tmp.next;
      }
    }
    return null;
  }

  

}
