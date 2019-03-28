

public class SingleNode {

    private Node head;
    private int size;

    public SingleNode(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public static void main(String[] args) {
        SingleNode s = new SingleNode(new Node(0, null), 5);

        s.add(s.head, new Node(1, null));
        s.add(s.head, new Node(2, null));
        s.add(s.head, new Node(3, null));
        s.add(s.head, new Node(4, null));
        s.add(s.head, new Node(5, null));
        s.add(s.head, new Node(6, null));

        s.print(s.head);
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


}
