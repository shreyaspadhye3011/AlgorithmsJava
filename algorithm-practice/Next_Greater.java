/*  Input: A number of n digits
 *  Output: Some combination of n digits which is the next biggest number wrt the input. If it's the highest combination then output -1 eg for 999 or 987654
 *  eg Input: 12453 Output: 12534  check: 7893210 o/p: 7901238
 *  
 *  Algorithm: Starting from len-1 value check for inversion on right side & after the inversio is swapped. Sort the right sub array.
 *  Test Cases: 1) i/p: 12345   o/p: 12354
 *              2) i/p: 12354   o/p: 12534
 *              3) i/p: 12534   o/p: 12543 
 *              4) i/p: 12543   o/p: 15234 & so on..
 *              **5) i/p: 7893210 o/p: 7901238
 *  last test case not solved. Problem in the sorting loop
 */
package mycodes;

/* @Problem_Courtesy: Gyrix Weekly Learning Center
 * @Algorithm: self
 */

import java.util.Scanner;


public class Next_Greater 
{
    public static void main(String... args) 
    {
        Scanner sc=new Scanner (System.in);
       int input=sc.nextInt();
       int a[]=new int[10];
       int i=0;
       int len=0;
       int temp;
       int n=input;
       while(n>0)
       {
           n=n/10;
           len++;
       }
       i=len;           //to preserve length of input in len is imp as all tranformations will be done on this.
        //System.out.println("Entered length is "+ len);
       while(i>0)
       {
           a[i-1]=input%10;
           input=input/10;
            i--;
       }
//        char arr[]=input.toCharArray();                 //insensible! Take input as int directly. As a number!! Still for knowledge, see: conversion of string/char to int.
//        Integer a[] = new Integer[arr.length];   
//        int i=0;
//         for(char a2:arr)                             //**IMP**: for each loop used when Undefined number of Command Line arguments ie a vaiating no of arguments can be passed
//        {
//            int temp= (int) a2;
//            a[i]=temp;
//            i++;
//        }
//         for(int b:a)
//        {
//            System.out.print(b);
//        }
//        int i=0;
//        Integer a[]=new Integer[100];
//        for(String a2: args)
//        {
//             a[i]=Integer.parseInt(a2);
//        }
        int pos=0;
        int count=0;
        int flag=0;
        for( i=len-2; i>=0; i--)
        {
            if(flag==1)
                break;
            for(int j=i+1; j<=len-1; j++)
            {
                //int temp=0;
                if(a[j]>a[i])
                {
                    pos=i;
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                    count++;
                   // System.out.println("Position is: "+pos);
                    flag=1;
                    break;                                  //break; cz we just want the next biggest number, so we just want the 5 on its right position thru this (see eg). But one break just exits the inner loop so we use flag value to exit outer.
                }
            } 
        }
        if (count!=0)
        {
            for(i=pos+1; i<=len-2; i++)        //sort the right half of pos
            {
                for(int j=i; j<=len-2; j++)
                {
                    if(a[j]>a[j+1])
                    {
                        temp=a[j];
                        //System.out.println("temp is" + temp);
                        a[j]=a[j+1];
                        a[j+1]=temp;
                    }
                }
            }
            for(i=0; i<len; i++)
            {
                System.out.print(a[i]);
            }
            System.out.println("");
       }
        else
        {
            System.out.println("-1");
        }
    }
}
