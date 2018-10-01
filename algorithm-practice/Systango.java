/*Beautiful String: Output all possible palindromes from a given string(Sequqntial combination NOT Permutation). 
  *Input: asadasaa
  *Output: asa, asadasa, sadas, ada, asa, aa
 */
package mycodes;


import java.util.Scanner;


public class Systango
{
    public static void main(String[] args)
    {
       
       Scanner sc=new Scanner(System.in);
       String input=sc.next();
       char a[]=input.toCharArray();
       //String a[]=input.split(input);
        //System.out.println(a[1]);
       int len=input.length();                                      //        //System.out.println(flag);
     
      for(int i=0; i<=input.length()-2; i++) 
      {          
          int tail_Index=i+1;
        while(tail_Index<=input.length()-1)
        { 
            int flag=0;                                     //to keep track of eq condition
            int count=0;                                    //to keep track of how many elements have been checked
            int len1=tail_Index-i+1;
            int temp=tail_Index;                          //so that len1 contains length of string we're operating on at all times & temp is used for iterations
            for(int j=i; count<len1/2 ;j++)
            {
                if(a[j]==a[temp])
                {
                    flag++;
                }
                count++;
                temp--;
            }
            if(flag==len1/2)
            {
//                String s=a.toString();                        //DOUBT: To convert char array back to string? 
//                System.out.println(a);
                for(int j=i; j<=tail_Index; j++)          
                {
                    System.out.print(a[j]);
                }
                System.out.println();
           }
            
          // System.out.println("Flag for i= "+i+" & tail= "+tail_Index+" is "+flag);
           tail_Index++;
        }
      }
    }
}
