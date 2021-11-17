/*Design a data structure that supports adding new words and finding if a string matches any previously added string.
Implement the WordDictionary class:
WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
  Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
  Constraints:
1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.*/
 
class WordDictionary {

    ArrayList<String> li =new ArrayList();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        System.out.println(">>"+word);
        li.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        System.out.println(word);
        if(!word.contains("."))
            return li.contains(word);
        else{
            boolean exists=false;
            for(int i=0;i<li.size();i++){
                String w =li.get(i);
                char[] a1=w.toCharArray();
                char[] a2=word.toCharArray();
                if(a2.length==1 && a2[0]=='.' && a1.length!=a2.length){
                    return false;
                }
                if(a1.length!=a2.length)
                    continue;
                int j=0;
                for(;j<a1.length;j++){
                    if(a2[j]!='.' && a1[j]!=a2[j]){
                        break;
                    }
                }
                if(j==a1.length){
                    exists=true;
                    break;
                }
            }
            return exists;
        }
         
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
