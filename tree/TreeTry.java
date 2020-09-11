import java.util.Stack;

public class TreeTry {

    public static void postOrderRecursive(TreeNote biTree) {

        if(biTree == null){
            return;
        }
        int left =1;
        int right =2;

        Stack<TreeNote> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack<>();
        while(biTree != null || !stack1.empty()) {
            while (biTree != null) {
                stack1.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while(!stack1.empty() && stack2.peek() == right) {
                stack2.pop();
                System.out.print(stack1.pop().value+",");
            }

            while(!stack1.empty() && stack2.peek() == left) {
                stack2.pop();
                stack2.push(right);
                biTree = stack1.peek().right;
            }
        }
    }
}
