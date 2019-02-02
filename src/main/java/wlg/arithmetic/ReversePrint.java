package wlg.arithmetic;

/**
 * [从尾到头打印链表] 输入一个链表，从尾到头打印链表每个节点的值。
 * @author seven
 *
 */
public class ReversePrint {

	public static void main(String[] args) {
		ReversePrint t = new ReversePrint();
		Node d = t.buildLinkedList();
		d.print();
		
		t.reversePrint(d);
	}
	
	void reversePrint(Node d) {
		if(d.next!=null)
			reversePrint(d.next);
		System.out.print(d.data + " ");
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
	    
	    void print() {
	    	Node tmp = this;
	    	while(tmp!=null) {
	    		System.out.print(tmp.data+" ");
	    		tmp = tmp.next;
	    	}
	    	System.out.println();
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
	  
}
