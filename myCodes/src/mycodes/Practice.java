
package mycodes;

import java.util.Scanner;


public class Practice 
{
    static public void main(String...ar)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string of values");
        String input=sc.next();
        String input1[]=input.split(",");
        System.out.println(input1[2]);
    }

}
