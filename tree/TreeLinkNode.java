public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    public TreeLinkNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
        this.next = null;
    }


    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
