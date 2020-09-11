

public class SingleNode {

    private Node head;
    private int size;

    public SingleNode(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public static void main(String[] args) {
        SingleNode s = new SingleNode(new Node(0, null), 7);

        Node node3 = new Node(30,null);
        s.add(s.head, new Node(1, null));
        s.add(s.head, new Node(2, null));
        s.add(s.head, node3);
        s.add(s.head, new Node(4, null));
        s.add(s.head, new Node(5, null));
        s.add(s.head, new Node(6, null));
//        s.add(s.head, new Node(7, node3));

        s.print(s.head);

        s.reverse(s.head);

//        s.reverseList(s.head);
//        System.out.println(s.checkCircle(s.head).val);
    }
    public boolean add(Node head, Node node) {

        Node start = head;
        int currentSize = 0;
        while (start != null && start.next != null) {
            start = start.next;
            currentSize++;
        }
        if(currentSize >= size){
            return false;
        }
        start.next = node;

        return true;
    }

    public void print(Node head) {
        while(head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reverse(Node head) {
        if(head == null) {
            return;
        }
        Node cur = head.next;
        Node next = cur;
        Node pre = head;
        pre.next =null;
        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }

        print(pre);
    }

    public void reverseList(Node head) {
        Node reverseSelfHead = null;
        Node node = head;
        Node preNode = null;

        while (node != null) {
            Node next = node.next;
            if(next == null) {
                reverseSelfHead = node;
            }
            node.next = preNode;
            preNode = node;
            node = next;
        }
        print(reverseSelfHead);
    }

    public Node checkCircle(Node head) {

        if(head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                break;
            }
        }

        if(fast.next == null) {
            return null;
        }
        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;

        }
        fast =fast.next;
        int count = 1;
        while (fast != slow) {
            fast = fast.next;
            count++;
        }
        System.out.println("count: "+count);
        return fast;

    }
}
