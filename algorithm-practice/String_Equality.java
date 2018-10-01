/*  delid="byid";
 *  // Objects.equals(delid, new String("byid")) **VIMP: REMEMBER this for checking string equaltity!! NOT by '==' 
 *     Source: http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
 */
package mycodes;


public class String_Equality 
{
    public static void main(String... args) 
    {
        String test="check_string";
        String test2="check_string";
        String test3= "test";
        
        if(test == test2)
        {
            System.out.println("Equals!");
        }
        if("test"=="test")
        {
            System.out.println("Also equal");
        }
        if(test3=="test")
        {
            System.out.println("Again Equals");
        }
        
        //All these work but Objects.equals("byid", new String("byid")) is preferred
    }
}
