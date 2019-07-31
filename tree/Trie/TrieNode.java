package Trie;

public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];

    public boolean isEndChar = false;

    public TrieNode(char data) {
        this.data = data;
    }


}
