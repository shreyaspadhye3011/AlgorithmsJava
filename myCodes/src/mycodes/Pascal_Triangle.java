/* Pascal Triangle: 1
 *                1 2 1
 *               1 3 3 1
 *              1 4 6 4 1
 *            1 5 10 10 5 1
 * 
 */
package mycodes;

import java.util.Scanner;

/* @problem_courtesy: Gyrix weekly learning Centre
 * @Algoritm: self
 */
public class Pascal_Triangle 
{
    public static void main(String... args) 
    {
        System.out.println("Enter number of levels of pyramid: ");
        Scanner sc=new Scanner(System.in);
        int level=sc.nextInt();
        int a[]=new int[100];
        int b[]=new int[50];
        a[0]=1;
        b[0]=1;
        b[1]=2;
        b[2]=1;
        int b_length=3;
        int a_length=1;
        int depth=2;
       // a[1]=-1;    //-1 used as '\o' to represent end of array. We can't use 'size' here as we have predefined size  to be 50.
        int i=0;
        while(depth<level)
        {
            i=0;
            
            if(depth%2==0)
            {
                a_length=b_length+1;
                while(i<=b_length/2)
                {
                    if(i==0)
                    {
                        a[0]=1;
                        a[a_length-1]=1;
                        i++;
                    }
                    else
                    {
                        a[i]=b[i-1]+b[i];
                        a[a_length-i-1]=b[i-1]+b[i];
                        i++;
                    }
                }
             }
            else
            {
                b_length=a_length+1;
                while(i<=a_length/2)
                {
                    if(i==0)
                    {
                        b[0]=1;
                        b[b_length-1]=1;
                        i++;
                    }
                    else
                    {
                        b[i]=a[i-1]+a[i];
                        b[b_length-i-1]=a[i-1]+a[i];
                        i++;
                    }
                }
                
            }
            depth++;
        }
        if(level%2==0)
        {
            for(i=0; i<b_length; i++)
            {
                System.out.println(b[i]+" ");
            }
        }
        else
        {
            for(i=0; i<a_length; i++)
            {
                System.out.println(a[i]+" ");
            }
        }
    }
    
}
