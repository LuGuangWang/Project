package wlg.arithmetic;
/**
 * 反转链表
 * @author seven
 *
 */
public class LinkedList {

	public static void main(String[] args) {
		LinkedList t = new LinkedList();
		
		Node head = t.buildLinkedList();
		
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
		System.out.println("\n===================");
		
		head = t.reverse(t.buildLinkedList());
		
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	
	public Node reverse(Node head) {
		Node tmp = head,newHead = head;
		
		while(head.next!=null) {
			tmp = head.next;
			head.next = tmp.next;
			tmp.next = newHead;
			newHead = tmp;
		}
		return newHead;
	}
	
	
	Node buildLinkedList() {
	    Node node1 = new Node(1);
	    Node node2 = new Node(2);
	    Node node3 = new Node(3);
	    Node node4 = new Node(4);
	    Node node5 = new Node(5);
	    Node node6 = new Node(6);
	    node1.next = node2;
	    node2.next = node3;
	    node3.next = node4;
	    node4.next = node5;
	    node5.next = node6;
	    return node1;
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
}
