package wlg.arithmetic;

/**
 * 两个单链表求和
 * 4->5->6
 * +  4->5
 * -------
 * 5->0->1
 * @author seven
 *
 */
public class LinkListSum {

	public static void main(String[] args) {
		LinkListSum t = new LinkListSum();

		Node a = t.buildLinkedList(4,6);
		Node b = t.buildLinkedList(4,5);
		
		//补齐
		t.addSum(a, b);
	}

	private void addSum(Node a, Node b) {
		Node last = new Node(0),res=last,tmpA=a,tmpB=b;
		while(tmpA!=null && tmpB!=null) {
			tmpA = tmpA.next;
			tmpB = tmpB.next;
		}
		int flag = 0;
		if(tmpA!=null) {
			while((tmpA=tmpA.next)!=null) {
				last.next=new Node(0);
				last = last.next;
			}
			last.next = b;
			a.print();
			res.print();
			flag = sum(a,res);
		}else if(tmpB!=null) {
			while((tmpB=tmpB.next)!=null) {
				last.next=new Node(0);
				last = last.next;
			}
			last.next = a;
			b.print();
			res.print();
			flag = sum(b,res);
		}else {
			a.print();
			b.print();
			flag = sum(a,b);
		}
		
		if(flag>0) {
			a = a.addHead(a, flag);
		}
		a.print();
	}
	
	int sum(Node a,Node b) {
		int flag = 0,val = 0;
		if(a.next!=null && b.next!=null) {
			flag = sum(a.next,b.next);
		}
		val = a.data + b.data + flag;
		flag = val>=10?1:0;
		val = val % 10;
		a.data=val;
		
		return flag;
	}

	Node buildLinkedList(int start,int end) {
		Node head = new Node(start);
		Node tmp = head;
		while(++start <= end) {
			tmp.next = new Node(start);
			tmp = tmp.next;
		}
		return head;
	}

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
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
		
		public Node addHead(Node node,int val) {
			Node newHead = new Node(val);
			newHead.next = node;
			return newHead;
		}
		
		public void print() {
			Node tmp = this;
			while (tmp != null) {
				System.out.print(tmp.data + " ");
				tmp = tmp.next;
			}
			System.out.println("");
		}

	}
}
