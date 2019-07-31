package tree;

import java.util.HashMap;
import java.util.Map;

public class Tree {

    int data;

    Tree left;
    Tree right;

    public Tree(int data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    // 从0开始计算
    public int height(Tree tree) {
        int height = 0;
        if( tree == null) {
            return 0;
        }
//        if(tree.left != null || tree.right != null) {
//            height = height +1;
//        }
        int left = height(tree.left);
        int right = height(tree.right) ;
        return Math.max(left, right) + 1;
    }
    // 从1开始计算
    public int getHeight(Tree root){
        if(root==null){
            return 0;
        }
        int leftheight=getHeight(root.left);
        int rightheight=getHeight(root.right);
        return Math.max(leftheight, rightheight)+1;
    }


    public int count(Tree tree) {
        int nodes=0;
        if( tree == null) {
            return  0;
        }
        else {
            nodes = count(tree.left) +count(tree.right) +1;
            System.out.println("tree:"+tree +",left:"+tree.left+",right:"+tree.right+", nodes count:"+nodes);
        }

        return nodes;
    }

    public int leafCount(Tree tree) {
        int count = 0;
        if(tree == null) {
            return 0;
        }
        if(tree.left == null || tree.right == null) {
            count = leafCount(tree) +1;
        }
        return count;
    }

    public int degree(Tree tree) {
        int count = 0;
        if(tree == null) {
            return 0;
        }
        if(tree.left != null && tree.right != null) {
            count = count +1;
        }
        return count + degree(tree.left) + degree(tree.right);
    }
    // 度为2的结点个数等于度为0的结点个数减去1。 即：n(2)=n(0)-1
    //计算树中度为2的节点的个数--满节点的个数
    private int numberOfFulls(Tree tree){
        int nodes = 0;
        if(tree == null)
            return 0;
        else if(tree.left == null && tree.right == null)
            return 0;
        else if(tree.left == null && tree.right != null)
            nodes = numberOfFulls(tree.right);
        else if(tree.left != null && tree.right == null)
            nodes = numberOfFulls(tree.left);
        else
            nodes = 1 + numberOfFulls(tree.left) + numberOfFulls(tree.right);
        return nodes;
    }
/*
**                 1
*                /   \
*               2     3
*              / \   / \
*             4   5 6   7
*                / \
*               8   9
*                  /
*                 10
*                   \
*                    11
 */
    public static void main(String[] args) {
//        Tree tree1 = new Tree(4, null, null);
//
//        Tree tree3_1_1 = new Tree(11, null, null);
//        Tree tree3_1 = new Tree(10, null, tree3_1_1);
//
//        Tree tree2_1 = new Tree(8, null, null);
//        Tree tree2_2 = new Tree(9, tree3_1, null);
//
//
//
//        Tree tree2 = new Tree(5, tree2_1, tree2_2);
//
//        Tree tree3 = new Tree(2, tree1, tree2);
//
//        Tree tree4 = new Tree(6, null, null);
//
//        Tree tree5 = new Tree(7, null, null);
//        Tree tree6 = new Tree(3, tree4, tree5);
//
//        Tree tree = new Tree(1, tree3, tree6);
//
//        System.out.println(tree.height(tree));
//        System.out.println(tree.getHeight(tree));
//
//        System.out.println(tree.count(tree));
//
//        System.out.println(tree.count(tree));

//        System.out.println(tree.degree(tree));
//
//        System.out.println(tree.numberOfFulls(tree));
        System.out.println("map ssss");
        Map map = new HashMap<>(10);
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        int val = 16;
        System.out.println(Integer.toBinaryString(val));
        int n = val>>>2;

        System.out.println(Integer.toBinaryString(n)+ ", n: "+n);
        val = val | val >>> 2;
        System.out.println(Integer.toBinaryString(val)+ ", val: "+val);

        int m = val >>> 2;
        System.out.println(Integer.toBinaryString(m)+ ", m: "+m);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data=" + data +
                '}';
    }
}



