package mergesort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MergeSort 
{
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        try
       {
        int a[]=new int[100000];
        int i=0;
        FileReader fr= new FileReader("src/mergesort/MergeInput.txt");
        BufferedReader br = new BufferedReader(fr);
        String s="";
        while ((s=br.readLine()) != null)
        {
            a[i]=Integer.parseInt(s);
            i++;
            //System.out.println(s);   
        }
        int len=i;
        //br.close();
        System.out.println("Before Sorting");
        for(i=0; i<len; i++)
        {
            System.out.print(a[i]);
            System.out.println();
        }
        a=mergeSort(a,len);
        System.out.println("After Sorting");
        for(i=0; i<len; i++)
        {
            System.out.print(a[i]);
            System.out.println();
        }
        } catch (NullPointerException e){e.printStackTrace();}
    }

    private static int[] mergeSort(int[] a, int len) 
    {
        if(len<=1)
            return a;
 
        int[] left=new int[len/2];
        int[] right=new int[len-(len/2)];
        
        for(int i=0; i<len/2; i++)
        {
            left[i]=a[i];
        }
        int x=0;
        for(int i=len/2; i<len; i++)
        {
            right[x]=a[i];
            x++;
        }
        
        left=mergeSort(left,len/2);
        right=mergeSort(right,len-(len/2));
        
        int[] result=new int[len];
        result=merge(left,right);
        
        return result; 
    }

    private static int[] merge(int[] left, int[] right) 
    {
        int result[]=new int[left.length+right.length];
        int lIndex=0;
        int rIndex=0;
        int resIndex=0;
        
        while(lIndex<left.length || rIndex<right.length)
        {
            if(lIndex<left.length && rIndex<right.length)
            {
                if(left[lIndex]<right[rIndex])
                {
                    result[resIndex]=left[lIndex];
                    lIndex++;
                    resIndex++;
                }
                else
                {
                    result[resIndex]=right[rIndex];
                    rIndex++;
                    resIndex++;
                }
            }
            else if(lIndex<left.length)
            {
                while(lIndex<left.length)
                {
                    result[resIndex]=left[lIndex];
                    lIndex++;
                    resIndex++;
                }
            }
                else
                {
                 while(rIndex<right.length)
                 {
                    result[resIndex]=right[rIndex];
                    rIndex++;
                    resIndex++;
                 }
                }
        }
        return result;
    }
}
