/* WAP that accepts strings starting with 'a' & followed by 'b' | Complier Design
 * 
 */
package mycodes;

import java.util.Scanner;


public class Language_Acceptor 
{
    public static void main(String... args) 
    {
        Scanner sc= new Scanner (System.in);
        String input=sc.next();
        char a[]=input.toCharArray();
        int flag=0;
        boolean acceptor=true;
        for(char temp:a)
        {
            if (temp=='a'){}
            else if (temp=='b')
                flag=1;
                else
                {
                    //for strings like aann, aaxx, axxx etc
                    acceptor=false;
                }
            if(flag==1)
            {
                if(temp=='b'){}
                else
                {
                    acceptor=false;
                    break;
                }
            }
        }
        if(acceptor==true)
        {
            System.out.println("Valid alphabet String for this language.");
        }
        else
            System.out.println("Not a valid alphabet String for this language.");
    }
}
