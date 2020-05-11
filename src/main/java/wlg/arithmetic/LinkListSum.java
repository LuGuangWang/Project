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

	public static Node res = null;

	public static void main(String[] args) {
		LinkListSum t = new LinkListSum();

		Node a = t.buildLinkedList(4,6);
		Node b = t.buildLinkedList(4,6);
		
		//补齐
		t.addSum(a, b);


		System.out.println("==============");
		a = t.buildLinkedList(5,6);
		b = t.buildLinkedList(5,6);
		t.addSum1(a,b);
		res.print();

		System.out.println("==============");

		a = t.buildLinkedList(7,8);
		b = t.buildLinkedList(5,6);

		a.print();
		b.print();

		Node result = t.addSum3(a,b);

		result.print();
	}

	private Node addSum3(Node a,Node b){
		Result res = new Result();

		int flag = addSum2(a,b,res);

		if(flag>0){
			Node v = new Node(flag);
			v.next = res.getHead();
			res.setHead(v);
		}
		return res.getHead();
	}

	private int addSum2(Node a,Node b,Result res){
		int flag = 0,val = 0;
		if(a != null && b != null){
			flag = addSum2(a.next,b.next,res);
		}else{
			return flag;
		}

		val = a.data + b.data + flag;

		flag = val>=10?1:0;
		val = val % 10;



		Node v = new Node(val);
		v.next = res.getHead();
		res.setHead(v);

		return flag;
	}

	class Result{
		Node head;

		public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}
	}

	private int addSum1(Node a,Node b){
		int flag = 0,val = 0;

		if(a.next!=null && b.next!=null){
			flag = addSum1(a.next,b.next);
		}

		val = a.data + b.data + flag;
		flag = val>=10?1:0;
		val = val % 10;

		Node v = new Node(val);
		v.next=res;
		res = v;

		return flag;
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
		private Node head;

		public Node(int data) {
			this.data = data;
		}

		public void setHead(Node head){
			this.head = head;
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
