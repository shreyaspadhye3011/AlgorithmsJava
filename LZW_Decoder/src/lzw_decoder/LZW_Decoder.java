/*  Lempel Ziv Welch Encoding. (Lossless Compression)
 *  Part 2: Decoder
 */
package lzw_decoder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LZW_Decoder 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
         int bit_length = Integer.parseInt(args[1]);
         String var_name=args[0];
        FileReader fr = new FileReader("src/lzw_decoder/"+var_name);
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        //String str="";
        int i=0;
        int[] output = new int[10000];
        
        /*Get encoded Output from file*/
        while ((s = br.readLine()) != null)         
        {
            output[i]=Integer.parseInt(s);
            i++;
        }
        int length=i;
        /* Make Dictionary for character-set */
        HashMap <Integer,String> dictionary = new HashMap<Integer, String>();
        FileReader fr1= new FileReader("src/lzw_decoder/Dictionary.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        String s1 = "";
        i = 0;
        while ((s1 = br1.readLine()) != null)         
        {
            dictionary.put(i,s1);
            i++;
        }
        System.out.println("Size is: "+dictionary.size());
        String string="";
        String new_str="";
        String decoded[]= new String [10000];
        i=0;
        int code=255;
        int table_size=code;
        char a[];
        char b[];
        string = dictionary.get(output[0]);
        decoded[0] = dictionary.get(output[0]);
        //int j=1;
        
        for(i=1; i<length; i++)
        {
            table_size=code;
            if(output[i] > code)
            {
                a = string.toCharArray();
                new_str = string+a[0];
            }
            else
            {
                new_str = dictionary.get(output[i]);
               // System.out.println(new_str);
            }
            decoded[i] = new_str;
            if(table_size<=Math.pow(2,bit_length))
            {
                 code=code+1;
                 b = new_str.toCharArray();
                 //System.out.println("String is: "+string+" New str: "+new_str);
                 //System.out.println("Table Update: "+code+" : "+string+b[0]);
                 //System.out.println("");
                 dictionary.put(code,(string+b[0]));
            }
            string = new_str;
        }
        for(i=0; i<length; i++)
        {
            System.out.println(decoded[i]);
            String var=var_name.substring(0, var_name.length()-4);
            FileWriter fw=new FileWriter("src/lzw_decoder/"+var+"_decoded.txt");
            fw.write(output[i]);
            fw.close();
        }
    }
}
