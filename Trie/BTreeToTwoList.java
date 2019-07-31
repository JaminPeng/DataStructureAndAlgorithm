package Trie;

public class BTreeToTwoList {

    private BinaryTreeNode cur;
    private BinaryTreeNode head;
    public BinaryTreeNode convert(BinaryTreeNode root) {

        if(root == null) {
            return null;
        }

        convert(root.left);
        if(cur == null) {
            cur = root;
            head = root;
        } else {
            cur.right = root;//cur 右指向当前元素
            root.left = cur;// 当前元素的左指向 cur
            cur = root; // cur 指向当前元素
        }
        convert(root.right);

        return head;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode left = new BinaryTreeNode(4);
        BinaryTreeNode right = new BinaryTreeNode(6);
        root.setLeft(left);
        root.setRight(right);

        BTreeToTwoList twoList = new BTreeToTwoList();
        BinaryTreeNode head = twoList.convert(root);

        while(head!=null) {
            System.out.println(head.getData());
            head = head.getRight();
        }
    }
}
