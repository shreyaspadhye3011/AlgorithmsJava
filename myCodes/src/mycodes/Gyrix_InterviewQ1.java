/* Problem Statement: Given a long list of input, your output should be the first element from the string that does not repeat in the entire string.
 * Input: AJJUIGUIALXMFFGL... Ouput: X
 * 
 * Algorithm Used: Store the string in an ArrayList. Keep removing ALL elements from the list when a repition encountered (NOTE: The traditional remove() function won't work here coz it just removes the first iteration). The element at the first index of the ArrayList will be the answer. 
 *NOT SLVED: ConcurrentModificationException? in Line 26(Read & keep a note about this) 
 */
package mycodes;

import java.util.ArrayList;
import java.util.Scanner;

/* @Problem_Courtesy: Mr. Rashmirathi Tiwari CEO, Gyrix Technolabs
 * @Algorithm: self 
 */
public class Gyrix_InterviewQ1 
{
    public static void main(String... args) 
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        char a[]=input.toCharArray();
        ArrayList <Character>list=new <Character>ArrayList(); //list: original list
        ArrayList list2=new ArrayList();    //list2: list that checks occurrences
        for(char b:a)
            list.add(b);
        for(Character b:list)
        {
            if(list2.contains((Character)b))
            {
                for(int i=0; i<list.size();i++)
                {
                    if(list.get(i)==(Character)b)
                    {
                        System.out.println(list.get(i)+" removed");
                        list.remove((Character)b);
                    }
                }
            }
            else
            {
                //System.out.println(b+" added");
                list2.add((Character)b);
            }
        }
        for(int i=0; i<list2.size();i++)
        {
            System.out.println(list2.get(i));
        }
        System.out.println("");
        System.out.println("Answer: "+list2.get(0));
    }
}
