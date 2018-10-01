/* Anagram strings: Strings that are each others' jumbled forms
 * eg RACE <-> CARE
 * Algorithm Used: Optimized Solution: Sort both arrays. Check index by index. Complexity: O(nlogn).
 * 
 * Test Cases: {race,care} ; {aaab,aab} ; {abc,aaa} ; {aaa,abc} ; {aabb,bbaa} ; {aabc,bbac}
 */
package mycodes;

import java.util.Arrays;
import java.util.Scanner;

/* @Problem_Courtesy: Amazon Final Interview
 * @Algorithm_Courtesy: Amazon Tech. head
 */
public class Anagram_efficient 
{
    public static void main(String... args) 
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String input2=sc.next();
        char a[]=input.toCharArray();
        char b[]=input2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int flag=0;
        if(a.length!=b.length)
            flag=-1;
        int count=0;
        for(int i=0;i<a.length;i++)
            if(a[i]==b[i])
                count++;
        System.out.println(count);
        if(count==a.length && flag!=-1)
            System.out.println("Anagram Strings detected");
        else
            System.out.println("Not Anagram Strings");
    }
}
