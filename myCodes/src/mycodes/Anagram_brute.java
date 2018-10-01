/* Anagram strings: Strings that are each others' jumbled forms
 * eg RACE <-> CARE
 * Optimized Solution: Sort both arrays. Check index by index. Complexity: O(n). Courtesy: Amazon. See Program: Anagram_efficient.
 * 
 * Algorithm Used: Here, Solved by a brute force progressive approach. Solving case by case. Not an ideal algo
 * Test Cases: {race,care} ; {aaab,aab} ; {abc,aaa} ; {aaa,abc} ; {aabb,bbaa} ; {aabc,bbac}
 * Remaining Test Case: **{aabc, bbac}** Output: Not anagram. Current o/p: Anagram. This test case breaks the logic proposed by me during Amazon interview.
 *
 * Alternate Solutions: See programs: 
 *                      1) Anagram_efficient 
 *                      2) Anagram_brute2
 *                      3) Anagram_brute3
 */
package mycodes;

/* @Problem_Courtesy: Amazon Final Interview
 * @Algorithm: self  
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Anagram_brute 
{
    public static void main(String... args) 
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String input2=sc.next();
        char a[]=input.toCharArray();
        char b[]=input2.toCharArray();
        ArrayList list=new ArrayList();
        int i=0;
        int count=0;
        int flag=-1;
        int flag3=0;
        for(i=0; i<a.length; i++)
        {
            flag=-1;                    //needed for cases like a="abc" & b="aaa". Count gets 3 due to repeated 'a' but its not an anagram.
            if(!(list.contains(a[i])))
            {                           
                for(int j=0; j<b.length; j++)
                {
                    System.out.println("a[i]: "+a[i]+" b{j]: "+b[j]);
                    if(a[i]==b[j])
                    {
                        count++;
                        flag++;
                        if(!(list.contains(a[i])))      //May be this if not needed. Check.
                        {
                            list.add(a[i]);
                        }
                    }
                }
            }
             System.out.println("For iteration: "+i+" Flag: "+flag+" Count: "+count);
            if(flag==-1 && !(list.contains(a[i])))  // for cases like: a="abc" & b="aaa" ie 'b' from list a is neither equal to any of the characters from list b. The condition !(list.contains(a[i])) is used bcoz flag will be -1 even in cases like a="aabb" & b="bbaa" for 2nd 'a' in list a (bcoz of condition on line 29) So we have to ensure that loop doesn't break for such conditions. List will have a charcter only when both list a & list b have it. (See Line 34 & 40) 
            {   
                flag3=-1;               //flag3 introduced bcoz for cases like a="aabb" b="bbaa". flag will end at -1 value coz it'll never enter loop of line 29. Although it'll never break due to && condition of 46 as list.contains('b')=TRUE. But flag value will be -1 nevertheless. So we introduce another flag that checks this state.
                break;
            }
           
        }
        for(i=0; i<list.size(); i++)
        {
            System.out.print(list.get(i));
        }
        System.out.println();
        int flag2=0;
        for (char d: b)
        {
            if(list.contains(d))            //for strings like a="aaa" b="abc"
            {
                flag2++;
            }
        }
        System.out.println("Count: "+count+" flag2: "+flag2);
        if(count==a.length && flag2==a.length && flag3!=-1)
            System.out.println("Anagram Strings detected");
        else
            System.out.println("Not Anagram strings");
    }
}
