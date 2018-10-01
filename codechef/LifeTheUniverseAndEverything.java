//Accept numbers till the number 42 is entered

package codechef;

import java.util.Scanner;

public class LifeTheUniverseAndEverything 
{
    static public void main(String...ar)
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int num=sc.nextInt();
            if(num!=42)
            {
                System.out.println(num);
            }
            else
                break;    
        }
    }
}
