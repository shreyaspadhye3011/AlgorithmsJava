/*
 * Quick Sort: when median is pivot
 * EXTRA: Learn a better implementation of finding Median. What if nos redundant like 1 4 4. What do we treat as median?
 */
package quicksort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        int a[]=new int[10000];
        int i=0;
        FileReader fr= new FileReader("src/quicksort/QuickSort.txt");
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
        int l=0;
        int r=len-1;
        
        try{
        a=quickSort(a,l,r);
        }catch(StackOverflowError e){e.printStackTrace();}
        System.out.println("After Sorting");
        for(i=0; i<len; i++)
        {
            System.out.print(a[i]);
            System.out.println();
        }
        System.out.println("Comparisons made: "+count);
     }
   static long count=0;
    private static int[] quickSort(int[] a, int l, int r) 
    {   
       
        if((r-l+1)<=1)
            return a;
        
        count=count+r-l;
        int i=l+1;
       /***   Finding Median  ***/ 
       int temp=0;
       int mid;
       if((r-l+1)%2!=0)
       {
           mid=l+(r-l+1)/2;         //VIMP: mid!=(r-l+1)/2 directly (ie length/2 in case of odd) bcoz remember the recurseive call will be made for seperate parts of original array. So for a saub array {4,5,6,7,8} in {1,2,3,4,5,6,7,8} mid*Index* will be 5(l(first element index)+(sub_array_len/2) and not 2!)
       }
        else
       {
           mid=l+((r-l+1)/2)-1;
       }
       
           if(a[mid]<a[l] && a[mid]>a[r] || a[mid]>a[l] && a[mid]<a[r] )
           {
               temp=a[mid];
               a[mid]=a[l];
               a[l]=temp;
           }
           else if(a[r]<a[mid] && a[r]>a[l] || a[r]>a[mid] && a[r]<a[l])
           {
               temp=a[r];
               a[r]=a[l];
               a[l]=temp;
           }
       
      
//        temp=a[r];
//        a[r]=a[l];
//        a[l]=temp;
    System.out.println("Length of sub array:"+(r-l+1)+" & Median index is: "+mid);
    
    /***************************************************/
    /***   Quick Sort:-   ***/
        for(int j=l+1; j<=r; j++)
        {
            if(a[j]<a[l])
            {
                 temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
            }         
        }
       
        temp=a[l];
        a[l]=a[i-1];
        a[i-1]=temp;
        System.out.println("Pindex: "+(i-1));
        a=quickSort(a,l,i-2);
        a=quickSort(a,i,r);
        return a;
    }
       
 }
