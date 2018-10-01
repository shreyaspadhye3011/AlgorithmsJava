package mycodes;

import java.util.Arrays;
import java.util.Scanner;


public class Palindrome 
{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       String input=sc.next();
       char a[]=input.toCharArray();
       //String a[]=input.split(input);
        //System.out.println(a[1]);
       int len=input.length();
       int flag=0;
       if(len%2==0)
       {
        for(int j=0;j<=len/2;j++)
        {
           if(a[j]==a[len-1])
           {
               flag++;
           }
                          
             len--;
        }
       }
       else
       {
         for(int j=0;j<len/2;j++)
         {
           if(a[j]==a[len-1])
           {
               flag++;
           }
                          
             len--;
         }
       }
       if(flag==input.length()/2)
        {
            System.out.println(input);
        }
        System.out.println(flag);
     }
}