package wlg.test;

public class ListNode {
  
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
  
  public String toString(){
    String str = "";
    ListNode head = this;
    while(head!=null){
      str += head.val + " ";
      head = head.next;
    }
    return str;
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sumNode = new ListNode(0), head = sumNode;
    int sum;
    while (l1 != null && l2 != null) {
      sum = head.val + l1.val + l2.val;
      if (sum - 10 >= 0) {
        head.val = sum - 10;
        head.next = new ListNode(1);
      } else {
        head.val = sum;
        head.next = new ListNode(0);
      }
      l1 = l1.next;
      l2 = l2.next;
      if(l1!=null || l2!=null) head = head.next;
    }
    l1 = l1==null?l2:l1;
    while(l1 != null){
      sum = head.val + l1.val;
      if (sum - 10 >= 0) {
        head.val = sum - 10;
        head.next = new ListNode(1);
      }else{
        head.val = sum;
        head.next = new ListNode(0);
      }
      l1 = l1.next;
      if(l1!=null) head = head.next;
    }
    if(head.next!=null && head.next.val==0) head.next = null;
    return sumNode;
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next=new ListNode(4);
    l1.next.next=new ListNode(3);
    
    ListNode l2 = new ListNode(9);
    l2.next=new ListNode(9);
    l2.next.next=new ListNode(2);
    
    
    ListNode sumNode = addTwoNumbers(null, null);
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(sumNode);
  }

}
