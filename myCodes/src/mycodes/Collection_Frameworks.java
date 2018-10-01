/* Collection Frameworks
 * IMP: Use Iterators to navigate lists. NOT the typical for loops cz in Collection Frameworks the keys are not regularly indexed like 1-2-3-4... they are random!
 * 
 * Check whether add & remove functions in Collections (ArrayLists or any other) are self balancing in terms of their index values.
 */

package mycodes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author HP
 */
public class Collection_Frameworks 
{
    public static void main(String... args) 
    {
        HashMap dictionary = new HashMap();
        dictionary.put(4,'a');
        dictionary.put(4,'b');
        dictionary.put('k',1);
        dictionary.put("key","value");
         dictionary.put("1","34");
          dictionary.put(2,65);
          dictionary.put(3,81);
        //System.out.println(dictionary.get('a'));
       dictionary.remove(2);
        
//      //   for(int i=1; i<=dictionary.size(); i++)    //NAIVE!! Use Iterators!! as used below
//      //   {
//      //       System.out.println(dictionary.get(i));
//      //   }
//      //   System.out.println("Size is: "+dictionary.size());
//      //   System.out.println(dictionary.get(4));
//      //   System.out.println(dictionary.get("key"));
//        
         Set setOfKeys=dictionary.keySet();
         Iterator it=setOfKeys.iterator();
         while(it.hasNext())
        {
           Object key=it.next();
            System.out.println("Value for key: "+key+" is: "+dictionary.get(key));
        }
         
         
         //*****  Lists   *******       They can't be instatntiated. like List list=new List() They are used as data members
//        List<Integer> list = null;
//        list.add(1);
//       Iterator it=list.iterator();
//       
//        while(it.hasNext())
//        {
//           Integer a=(Integer)it.next();
//            System.out.println(a);
//        }
    }
}
