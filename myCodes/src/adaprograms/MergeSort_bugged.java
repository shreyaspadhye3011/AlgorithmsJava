/* For Solutions: see MergeSort(Application)
 * Bugs: 1) isr & br reading till eof from cmd line. Not Implemented. Enetering infinte loop. Solved: No inf loop, large array printing due to output loop iteration! Same as 2. Check.
 *       2) File Not found when FileInputStream used. Solved! 
 *       3) Difference b/w FileInputStream & FileWriter? 
 */
package adaprograms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MergeSort_bugged 
{
    public static void main(String... args) throws FileNotFoundException, IOException 
    {
//        //FileInputStream in=new FileInputStream("MergeInput.txt");           //check!!
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        Integer a[]=new Integer[1000000];
        int i=0;
        String str="";
        while((str=br.readLine())!=null)        //solve this loop problem as solved in file handling (MegeSort)
        {
             a[i]=br.read();
             i++;
        }
        for(int b:a)
            System.out.println(b);
//        Scanner sc=new Scanner(System.in);
//        Integer a[]=new Integer[1000000];
//        //int i=0;
//        

//       a[0]=sc.nextInt();
//       a[1]=sc.nextInt();
//       a[2]=sc.nextInt();
//       a[3]=sc.nextInt();
//       a[4]=sc.nextInt();
//       a[5]=sc.nextInt();
//       a[6]=sc.nextInt();
//       a[7]=sc.nextInt();
//       
//        System.out.println();
//        
//        int len=a.length;
//        int split_index=len/2;
//        String[] left;
//        String[] right;
//        left=MergeDiv(split_index);
//        right=MergeDiv(split_index);
//        Merge(left,right);
    }

    private static String[] MergeDiv(int len) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    private static void Merge(String[] left, String[] right) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
