package medium;

public class Q211WordDictionary {
    private Q211WordDictionary[] children;
    boolean isEndOfWord;
    // Initialize your data structure here. 
    public Q211WordDictionary() {
        children = new Q211WordDictionary[26];
        isEndOfWord = false;
    }

    // Adds a word into the data structure. 
    public void addWord(String word) {
        Q211WordDictionary curr = this;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Q211WordDictionary();
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
    public boolean search(String word) {
        Q211WordDictionary curr = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(Q211WordDictionary ch: curr.children)
                    if(ch != null && ch.search(word.substring(i+1))) return true;
                return false;
            }
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}
