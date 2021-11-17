/*A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
  Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
  Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.*/
 
class Trie {
    
    char c;
    Map<Character,Trie> ch;
    boolean end;
    
    /** Initialize your data structure here. */
    public Trie() {
       ch= new HashMap<Character,Trie>(); 
    }
    
    public Trie(char c) {
       this.c=c;
       ch= new HashMap<Character,Trie>(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] a =word.toCharArray();
        Trie cur =this;
        for(char x:a){
            if(!cur.ch.containsKey(x)){
                cur.ch.put(x,new Trie(x));    
            }
            cur = cur.ch.get(x);
        }
        cur.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] a =word.toCharArray();
        Trie cur =this;
        for(char x:a){
            if(!cur.ch.containsKey(x)){
                return false;    
            }
            cur = cur.ch.get(x);
        }
        return cur.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] a =prefix.toCharArray();
        Trie cur =this;
        for(char x:a){
            if(!cur.ch.containsKey(x)){
                return false;    
            }
            cur = cur.ch.get(x);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
