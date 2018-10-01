/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycodes;

/**
 *
 * @author HP
 */
public class Input_Split 
{
    public static void main(String... args) 
    {
        String input="10,4,5,2,34";
        String b[]=input.split(",");
        int a[]=new int[10];
        int i=0;
        try
        {
        for(String c:b)
        {
            a[i]=(Integer.parseInt(c)+1);       //just to display that the string has to be converted into separate numbers.
            System.out.println(a[i]);
            i++;
           // System.out.println(c);
        }
        }catch(Exception e){e.printStackTrace();}
    }
}
