import java.util.Stack;

public class TreeNote {

    int value;
    TreeNote left;
    TreeNote right;

    public TreeNote(int value){
        this.value = value;
    }
    //                 0
    //              /      \
    //            1          2
    //         /    \       /   \
    //        3      4     5     6
    //      /  \    /
    //     7    8  9
    // post order: 7839415620
    public static void main(String[] args) {
        //以数组形式生成一棵完全二叉树
        TreeNote[] node = new TreeNote[10];
        for(int i = 0; i < 10; i++) {
            node[i] = new TreeNote(i);
        }
        for(int i = 0; i < 10; i++) {
            if(i*2+1 < 10)
                node[i].left = node[i*2+1];
            if(i*2+2 < 10)
                node[i].right = node[i*2+2];
        }
        // 后序遍历
        System.out.println("后序遍历:");
//        BinaryTreeErgodic.postOrderErgodic(node[0]);
//        System.out.println();
//        BinaryTreeErgodic.postOrderRecursive(node[0]);
//        System.out.println();
        BinaryTreeErgodic.postOrderTraverse(node[0]);
        System.out.println();
        BinaryTreeErgodic.postOrderTraverse2(node[0]);
        System.out.println();

        // 先序遍历
//        System.out.println("先序遍历:");
//        BinaryTreeErgodic.preOrderRecursive(node[0]);
//        System.out.println();
//        BinaryTreeErgodic.preOrderUnRecursive(node[0]);
//        System.out.println();
//        // 中序遍历
//        System.out.println("中序遍历:");
//        BinaryTreeErgodic.midOrderRecursive(node[0]);
//        System.out.println();
//        BinaryTreeErgodic.midOrderUnRecursive(node[0]);
    }

}
