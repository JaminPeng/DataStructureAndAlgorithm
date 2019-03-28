import javax.swing.tree.TreeNode;
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

        postOrderErgodic(node[0]);

    }
    //unrecursive way 后序遍历非递归实现
    public static void postOrderErgodic(TreeNote biTree) {

        if(biTree == null) {
            return;
        }
        int left = 1; //在辅助栈里表示左节点
        int right = 2; //在辅助栈里表示右节点

        Stack<TreeNote> stack = new Stack<>();
        //辅助栈，用来判断子节点返回父节点时处于左节点还是右节点
        Stack<Integer> stack2 = new Stack<>();

        while (biTree != null || !stack.empty()) {
            while (biTree != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }
            while (!stack.empty() && stack2.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.print(stack.pop().value+",");
            }

            while (!stack.empty() && stack2.peek() == left) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }
        }
    }
}
