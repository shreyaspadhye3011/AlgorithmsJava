/* Lempel Ziv Welch Encoding. (Lossless Compression)
 * Part 1: Encoder
 */
package lzw_encoder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class LZW_Encoder 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        int bit_length = Integer.parseInt(args[1]);
        String var_name=args[0];
        System.out.println(bit_length);
        /* Get Input from file */
        FileReader fr = new FileReader("src/lzw_encoder/"+var_name);
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        String str="";
        while ((s = br.readLine()) != null)         //if the string is large enough to occupy multiple lines of the file, concatenate all lines as single input string.
        {
            str = str.concat(s);
        }
        //System.out.println("String is: "+str);
        
        /* Make Dictionary for character-set */
        HashMap <String,Integer> dictionary = new HashMap<String, Integer>();
        FileReader fr1= new FileReader("src/lzw_encoder/Dictionary.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        String s1 = "";
        int i = 0;
        while ((s1 = br1.readLine()) != null)         
        {
            dictionary.put(s1,i);
            i++;
        }
        System.out.println("Size is: "+dictionary.size());
        //System.out.println(dictionary.get("NULL"));
        //System.out.println(dictionary.get("a"));
        
        /* Encoding Process */
        //int table_size=dictionary.size();
        i=0;
        char sym[] = str.toCharArray();
        String string="";
        int output[]= new int[10000];
        int code=255;
        int table_size=code;
        int length = 0;
        int j=0;
        while(i<str.length())
        {
            table_size=code;
            if(dictionary.containsKey(string+sym[i]))
            {
                string=string+sym[i];
               // System.out.println("String "+i+": "+string+". Exits: TRUE");
                if(i == str.length()-1)
                {
                    output[j]=dictionary.get(string);
                    length++;
                }
            }
            
            else if(table_size<=Math.pow(2,bit_length))
            {
                //System.out.println(string);
               // System.out.println(dictionary.get(string));
                output[j]=dictionary.get(string);
                j++;
                length++;
                code=code+1;
                dictionary.put(string+sym[i],code);
                string=""+sym[i];
            }
            i++;
        }
        for(i=0; i<length; i++)
        {
            System.out.println(output[i]);
            
            String var=var_name.substring(0, var_name.length()-4);
            FileWriter fw=new FileWriter("src/lzw_encoder/"+var+".lzw");
            fw.write(output[i]);
            fw.write("\n");
            fw.close();
        }
        
    }
}

