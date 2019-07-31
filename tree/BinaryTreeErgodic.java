import java.util.Stack;

public class BinaryTreeErgodic {

    /**
     * 先序递归
     * @param biTree
     */
    public static void preOrderRecursive(TreeNote biTree) {
        System.out.print(biTree.value+",");

        TreeNote leftTree = biTree.left;
        if(leftTree != null) {
            preOrderRecursive(leftTree);
        }
        TreeNote rightTree = biTree.right;
        if(rightTree != null) {
            preOrderRecursive(rightTree);
        }
    }

    /**
     * 先序非递归
     * @param biTree
     */
    public static void preOrderUnRecursive(TreeNote biTree) {

        Stack<TreeNote> stack = new Stack<>();
        while (biTree != null || !stack.empty()) {
            while (biTree != null) {
                System.out.print(biTree.value+",");
                stack.push(biTree);
                biTree = biTree.left;
            }
            if(!stack.isEmpty()){
                biTree = stack.pop();
                biTree = biTree.right;
            }

        }
    }
    /**
     * 中序递归
     */
    public static void midOrderRecursive(TreeNote biTree) {
        if(biTree == null) {
            return;
        }
        midOrderRecursive(biTree.left);
        System.out.print(biTree.value+",");
        midOrderRecursive(biTree.right);
    }

    /**
     * 中序非递归
     * @param biTree
     */
    public static void midOrderUnRecursive(TreeNote biTree) {
        Stack<TreeNote> stack = new Stack<>();
        while(biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.left;
            }
            if(!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.print(biTree.value+",");
                biTree = biTree.right;
            }
        }
    }

    /**
     * 后序递归
     * @param biTree
     */
    public static void postOrderRecursive(TreeNote biTree){

        if(biTree == null) {
            return;
        }
        postOrderRecursive(biTree.left);
        postOrderRecursive(biTree.right);
        System.out.print(biTree.value+",");
    }

    /**
     * 后序非递归
     * @param biTree
     */
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
