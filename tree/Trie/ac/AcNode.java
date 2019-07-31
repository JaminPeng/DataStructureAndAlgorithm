package Trie.ac;

import java.util.Vector;

public class AcNode {

    public char data;
    public AcNode[] acNode = new AcNode[26];

    public boolean isFail;

    public AcNode(char data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        v1.add("a");
        v1.add("b");

        Vector<String> v2 = new Vector<>();
        v2.add("c");
        v2.add("d");
        Vector<String> v3 = new Vector<>();
//        v3.add("a");
        System.out.println("v1:"+v1);
        v1.retainAll(v3);
        System.out.println("v1:"+v1);
        if(v1.isEmpty()){
            System.out.println("v1 is empty: "+v1);
        } else {
            System.out.println("v1 is not empty: "+v1.get(0));
        }

    }
}
