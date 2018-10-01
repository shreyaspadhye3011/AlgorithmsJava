/* Anagram strings: Strings that are each others' jumbled forms
 * eg RACE <-> CARE
 * Algorithm Used: Optimized Solution: Create Map-count of each character for both stings. If all chars' map matches -> anagram Complexity: O(n).
 * 
 * Test Cases: {race,care} ; {aaab,aab} ; {abc,aaa} ; {aaa,abc} ; {aabb,bbaa} ; {aabc,bbac}
 */
package mycodes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/* @Problem_Courtesy: Amazon Final Interview
 * @Algorithm_Courtesy: Amazon Tech. head
 */
public class Anagram_efficient2 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String input_1 = sc.next();
        String input_2 = sc.next();
        char[] input_arr_1 = input_1.toCharArray();
        char[] input_arr_2 = input_2.toCharArray();
        Integer currentCount = 0;
        HashMap map = new HashMap<>();
        
        for(char ch : input_arr_1)
        {
            if(map.get(ch) == null)
            {
                map.put(ch, 1);
            }
            else
            {
                currentCount = (Integer)map.get(ch);
                currentCount++;
                map.put(ch, currentCount);
            }
        }
//        Collection cl = map.values();
//        System.out.println(cl);
//        
//        Set keys = map.keySet();
//        System.out.println(keys);
//        
//        System.out.println("test :"+map.get('a'));
       
    }
}
