class Trie {
    
    class Node {
        boolean end;
        Node[] next = new Node[26];
    }
    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = this.root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(temp.next[c-'a'] == null){
                temp.next[c-'a'] = new Node();
            }
            temp = temp.next[c-'a'];
        }
        temp.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node l = findNode(word);
        if(l!=null && l.end) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findNode(prefix)!=null;
    }
    
    public Node findNode(String s) {
        Node temp = this.root;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(temp.next[c-'a'] == null){
                return null;
            }
            temp = temp.next[c-'a'];
        }
        return temp;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */