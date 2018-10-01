/* Anagram strings: Strings that are each others' jumbled forms
 * eg RACE <-> CARE
 * 
 * Algorithm Used: Using Map, store iteration of each alphabet in 2 lists. In the end all <key,value> pairs must match. 
 * Test Cases: {race,care} ; {aaab,aab} ; {abc,aaa} ; {aaa,abc} ; {aabb,bbaa} ; {aabc,bbac}
 * YES! Solves all test cases.
 * 
 * Doubt(basic): Why static context in main() was used? Reason behind it? Why non static variables can't be refrenced inside it.
 */
package mycodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* @Problem_Courtesy: Amazon Final Interview
 * @Algorithm: self  
 */
public class Anagram_brute2 
{
    static HashMap map1=new HashMap();          //**Check: Why this implementation made in Java? If you remove "static": Error: "Non static variable can't be refrrenced from a static context"
    static HashMap map2=new HashMap();          //**Check: Interface-Abstract Class-Normal class significance? (Amazon Interview)
    
    public static void main(String... args) 
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String input2=sc.next();
        char a[]=input.toCharArray();
        char b[]=input2.toCharArray();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        int tcount=0;
        int flag=0;
        
        for( char current: a)
        {
            if(list1.contains(current)!=true)
            {
                mapCount(current,a,1);
                list1.add(current);     //**Check: See working of list.add(index,value): whether it replaces the element at i or translates all values at index>i by one position?: CHECKED. Latter happens. See Anangram_brute3.java
            }
        }
        System.out.println("***********");
        for( char current: b)
        {
            if(!(list2.contains(current)))
            {
                mapCount(current,b,2);
                list2.add(current);
            }
        }
        if(list1.size()!=list2.size())
            System.out.println("Not Anagram Strings");
        else
        {
            for(int i=0; i<map1.size(); i++)
            {
                Integer count1=(Integer)map1.get(list1.get(i));       //bcoz get() returns object so wrapper class has to be used & the return type has to be casted into Integer
                Integer count2=(Integer)map2.get(list1.get(i));       //Checking both map1 & map2 for the same character
                if(count1==count2)
                    tcount++;
                else
                {
                    flag=-1;
                    break;
                }
                //System.out.println(list1.get(i)+": "+count1);
            }
            
    //        for(int i=0; i<list1.size(); i++)
    //        {
    //            System.out.print(list1.get(i));
    //        }
        }
        if(tcount==list1.size())
            System.out.println("Anagram Strings");
        else if (flag==-1) 
            System.out.println("Not Anagram Strings");
    }

    private static void mapCount(char current, char temp[], int context) 
    {
        if(context==1)
        {
            int count=0;
            for(char d:temp)
            {
                if(current==d)
                    count++;
            }
            map1.put(current, count);
            System.out.println("Char: "+current+" Count: "+count);
        }
        if(context==2)
        {
            int count=0;
            for(char d:temp)
            {
                if(current==d)
                    count++;
            }
            map2.put(current, count);
            System.out.println("Char: "+current+" Count: "+count);
        }
    }
    
}
