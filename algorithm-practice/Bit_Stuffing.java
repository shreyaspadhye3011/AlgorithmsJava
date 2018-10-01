//bit stuffing

package mycodes;

import java.util.ArrayList;
import java.util.Scanner;

public class Bit_Stuffing 
{
    public static void main(String... args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter bit stream");
        char[] myStr=sc.next().toCharArray();
        ArrayList list=new ArrayList();         //to avoid ArrayIndexOutOfBounds problem in char array
        for(int i=0; i<myStr.length; i++)
        {
           list.add(myStr[i]); 
        }    
        int i=0;                            //for current slot
       int loc = 0;
        System.out.println("Array List size is "+list.size());
        while(i+5<=list.size()-1)             //we check a series of 6
        {
             loc=i;
            //int j=0;
            int count=0;
            while(loc<=i+5)
            {
               
                Object temp=list.get(loc);
                if(temp.equals('1'))
                {
                    count++;
                    loc++;
                }
              //  j++;
                else 
                    break;  
            }
           // System.out.println("Count for iteration "+i+" is "+count);
            try
            {
            if(count==6)
            {
                int pos=list.size()-1;
                list.add(null);             //*IMP*: To avoid IndexOutOfBounds Exception
                while(pos!=loc-1)
                {
                    list.set(pos+1,list.get(pos));
                    list.set(pos,list.get(pos-1));
                    //myStr[pos+1]=myStr[pos];
                    pos--;
                }
                //myStr[pos]='0';
                list.set(pos, '0');
            }
            i++;
            }catch(IndexOutOfBoundsException e){e.printStackTrace();}
        }
        System.out.println("Stuffed bit stream is: ");
        for(int j=0; j<list.size(); j++)
        {
            System.out.print(list.get(j));
        }
    }
}
