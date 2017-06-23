package wlg.leetcode;

public class MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode head = l1;
    for(int i=2;i<=5;i++){
      head.next = new ListNode(i);
      head = head.next;
    }
    
    ListNode l2 = new ListNode(1);
    head = l2;
    for(int i=3;i<=7;i++){
      head.next = new ListNode(i);
      head = head.next;
    }
    
    
    MergeTwoSortedLists p = new MergeTwoSortedLists();
    head = p.mergeTwoLists(l1, l2);
    while(head!=null){
      System.out.print("==>" + head.val);
      head = head.next;
    }
    
  }
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            node.next = l1;
            l1 = l1.next;
        } else {
            node.next = l2;
            l2 = l2.next;
        }
        node = node.next;
    }
    if (l1 != null) node.next = l1;
    if (l2 != null) node.next = l2;
    return dummy.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}