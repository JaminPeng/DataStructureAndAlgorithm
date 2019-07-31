package Trie;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;

        for(int i=0; i< text.length; ++i) {
            int index = text[i] - 'a';

            if(p.children[index] == null) {
                TrieNode node = new TrieNode(text[i]);
                p.children[index] = node;
            }
            p = p.children[index];
            p.isEndChar = true;
        }
    }

    public boolean find(char[] text) {
        TrieNode p = root;

        for(int i=0; i< text.length; ++i) {
            int index = text[i] - 'a';
            if(p.children[index] == null) {
                return false;
            }
            p = p.children[index];
            if(p.isEndChar == false){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("how".toCharArray());
        trie.insert("helmo".toCharArray());
        trie.insert("hellost".toCharArray());

        boolean result = trie.find("hellostr".toCharArray());
        System.out.println(result);
    }
}
