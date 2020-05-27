package wlg.javaapi.sortmethods;

public class LinkListMergeSort {
    public static void main(String[] args) {
        LinkListMergeSort t = new LinkListMergeSort();

        Node head = t.buildLink();
        System.out.println(head);

        Node newHead = t.mergeSort(head);

        System.out.println(newHead);

    }

    private Node mergeSort(Node head){
        Node newHead = null;
        if(head!=null){
            if(head.next==null){
                newHead = head;
            }else{
                Node middle = getMiddle(head);
                Node half = middle.next;
                middle.next = null;

                Node left = mergeSort(head);
                Node right = mergeSort(half);

                newHead = merge(left,right);
            }
        }
        return newHead;
    }

    private Node merge(Node left,Node right){
        Node head = new Node();
        Node tmpHead = head;
        while (left!=null && right !=null){
            if(left.val>right.val){
                tmpHead.next = new Node(right.val);
                tmpHead = tmpHead.next;
                right = right.next;
            }else{
                tmpHead.next = new Node(left.val);
                tmpHead = tmpHead.next;
                left = left.next;
            }
        }
        while (left!=null){
            tmpHead.next = new Node(left.val);
            tmpHead = tmpHead.next;
            left = left.next;
        }
        while (right!=null){
            tmpHead.next = new Node(right.val);
            tmpHead = tmpHead.next;
            right = right.next;
        }
        return head.next;
    }

    private Node getMiddle(Node head){
        Node slow = head,fast = head;
        if(head!=null){
            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }

    private Node buildLink(){
        Node head = new Node(7);
        head.next = new Node(6);
        head.next.next=new Node(5);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(3);
        head.next.next.next.next.next=new Node(2);
        head.next.next.next.next.next.next=new Node(1);
        return head;
    }



    class Node{
        private int val;
        private Node next;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            Node t = this;
            while (t != null){
                res.append(t.val).append(" ");
                t = t.next;
            }
            return res.toString();
        }
    }
}
