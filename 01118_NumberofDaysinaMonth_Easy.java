/*Given a year year and a month month, return the number of days of that month.
  Example 1:
Input: year = 1992, month = 7
Output: 31
Example 2:
Input: year = 2000, month = 2
Output: 29
Example 3:
Input: year = 1900, month = 2
Output: 28
  Constraints:
1583 <= year <= 2100
1 <= month <= 12*/
 
class Solution {
    public int numberOfDays(int year, int month) {
        Map<Integer,Integer> m =new HashMap<>();
        m.put(1,31);
        m.put(2,28);
        m.put(3,31);
        m.put(4,30);
        m.put(5,31);
        m.put(6,30);
        m.put(7,31);
        m.put(8,31);
        m.put(9,30);
        m.put(10,31);
        m.put(11,30);
        m.put(12,31);
        
        if(month !=2){
            return m.get(month);
        }else {
            if(year%4!=0){
                return m.get(month);
            }else{
                if(year%100==0){
                    if(year%400==0)
                    return m.get(month)+1;
                    else
                    return m.get(month);    
                }else{
                    return m.get(month)+1;
                }
            }
        }
    }
}
