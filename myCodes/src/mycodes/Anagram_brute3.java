/* Anagram strings: Strings that are each others' jumbled forms
 * eg RACE <-> CARE
 * 
 * Algorithm Used: Store each of the strings in 2 separate lists. On encountering a character from the first list, remove this character from the both the lists. If at the end, both lists are empty, they are anagram strings.
 * Test Cases: {race,care} ; {aaab,aab} ; {abc,aaa} ; {aaa,abc} ; {aabb,bbaa} ; {aabc,bbac}
 * YES! Solves all test cases.
 * 
 * NOTE: Double commented code is using containsAll method direct. Straight forward. 4 line code. for learning purposes, here, also implemented with remove() method.
 * Problem (Basic): SOLVED. Polymorphic remove() funcion causing problems. See comment on line 58.
 */
package mycodes;


import java.util.ArrayList;
import java.util.Scanner;

/* @Problem_Courtesy: Amazon Final Interview
 * @Algorithm_Courtesy: Siddharth Yadav
 */
public class Anagram_brute3 
{
    public static void main(String... args) 
    {
        //**ArrayList Basics:
//        ArrayList temp_list= new ArrayList();
//        temp_list.add(0,"rdj");         //temp_list.add(4,rdj) NOT POSSIBLE. Gives ArrayIndexOutOfBounds Exception. ie indexing maintained on each added element.
//        temp_list.add(1,"bennedict");
//        temp_list.add(2,"sherlock");
//        temp_list.add(3,"cumberbach");
//        temp_list.remove(2);                 //o/p: 0:rdj,1:bennedict,2:cumberbach ie the ArrarList balances the indexing on a remove operation itself.
//        temp_list.add(2,"INSERTED VALUE");  //o/p: 0:rdj,1:bennedict,2:INSERTED VALUE,3:cumberabch ie cumberbach shifts a place below to facilitate new value at colliding index.
//        temp_list.add("rdj");
//        temp_list.add("last");
//        temp_list.remove("rdj");        //**IMP: remove() method of ArrayList removes only the first index occurence of the specified element. So you'll have to make your own implementation of the method if you want to remove all occurences at single discovery anytime.
//        for(int i=0; i<temp_list.size(); i++)
//        {
//            System.out.println(i+": "+temp_list.get(i));
//        }
        
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String input2=sc.next();
        char a[]=input.toCharArray();
        char b[]=input2.toCharArray();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
   
        for(char c:a)
           list1.add(c);
        for(char d:b)
            list2.add(d);
        int flag=0;
        if(list1.size()!=list2.size())
            flag=-1;        //BAsic doubt: How to use goto in Java. Coz here as you see once flag=-1, no use on doing rest of the algorithm. So directly skip to the last part & display result.
       
//        //boolean val=list1.containsAll(list2);
        for(char c:a)
        {
            if(!(list3.contains(c)))
            {
                for(char d: b)
                {
                    if(c==d)
                    {
                        list1.remove((Character)c);        //remove() treating c (vlaue found on iteration) as int. eg 'r' from race treated as int & remove(int index) method called. Thus giving ArrayIndexOutOfBoundsException: Index: 114 (r's ASCII). //SOLVED Cast 
                        list2.remove((Character)d);         //"Primitive data types are not treated as objects." This is why Wrapper Classes were created. To use themm along with Collection Frameworks & distinguish methods. See Anagram_brute2.java Line 62,63.
                        list3.add(c);

                    }
                }
            }
        }

        
        for(int i=0; i<list1.size(); i++)
        {
            System.out.println(i+": "+list1.get(i));
        }
        System.out.println("");
        for(int i=0; i<list2.size(); i++)
        {
            System.out.println(i+": "+list2.get(i));
        }
        
        if(list1.isEmpty() && list2.isEmpty() && flag!=-1)
            System.out.println("Anagram Strings Detected");
        else
            System.out.println("Not Anagram Strngs");
        
//        //if(val==true)
//        //    System.out.println("Anagram");
//        //else
//        //    System.out.println("Not Anagram");
        
    }
}
