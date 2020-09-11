/**
 *
 */
public class MySingleList {
    class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return this.data;
        }
    }

    private Node head;
    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {

        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {

        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印链表
    public void display() {

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //创建一个有环的链表
    public void createLoop() {

        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    //寻找环的入口点
    public Node detectCycle() {

        Node fast = this.head;
        Node slow = this.head;

        //循环退出两种情况:
        //1.fast.next == null(找到单链表结尾也没有找到环); 2.fast == slow(有环)
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        //链表没有环的情况
        if (fast.next == null) {
            return null;
        }

        //链表有环
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        MySingleList list = new MySingleList();

        list.addFirst(134);
        list.addFirst(20);
        list.addFirst(35);
        list.addLast(10);
        list.addLast(999);
        list.addLast(7);
        System.out.print("原链表：");
        list.display();

        list.createLoop();
        MySingleList.Node cur = list.detectCycle();
        System.out.println("链表入环点是:" + cur.getData());
    }

}
