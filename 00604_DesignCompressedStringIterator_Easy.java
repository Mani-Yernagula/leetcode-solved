/*Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
Implement the StringIterator class:
next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.
  Example 1:
Input
["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
Output
[null, "L", "e", "e", "t", "C", "o", true, "d", true]

Explanation
StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
stringIterator.next(); // return "L"
stringIterator.next(); // return "e"
stringIterator.next(); // return "e"
stringIterator.next(); // return "t"
stringIterator.next(); // return "C"
stringIterator.next(); // return "o"
stringIterator.hasNext(); // return True
stringIterator.next(); // return "d"
stringIterator.hasNext(); // return True
  Constraints:
1 <= compressedString.length <= 1000
compressedString consists of lower-case an upper-case English letters and digits.
The number of a single character repetitions in compressedString is in the range [1, 10^9]
At most 100 calls will be made to next and hasNext.*/
 
class StringIterator {
    char[] a=null;
    List<Character> li =new ArrayList<Character>();
    int i =0;
    int z =0;
    int co =0;
    char ch = ' ';
    
    public StringIterator(String compressedString) {
        a= compressedString.toCharArray();
    }
    
    void loadMore(){
        int max =1000;
        if(z==0){
            ch = a[i];
            int j=i+1;
            int k = ((int)a[j])-48;
            int x = 10;
            co = k; 
            j++;
            while(j<a.length && ((int)a[j])-48 <10){
              k = ((int)a[j])-48;
              co = (co * x)+k;
              j++;  
            }
            i=j;
        }
        while(z<co && z<max){
            li.add(ch);
            z++;
        }
        if(z==co){
            z=0;
        }
    }
    
    public char next() {
        char r=' ';
        return hasNext()?li.remove(0):r;
    }
    
    public boolean hasNext() {
        if(li.size()==0 && (z!=0 || i<a.length)){
            loadMore();
        }
        return li.size()!=0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
