/* Domain: Compiler Design
 * Description: A combination of '()' '{}' & '[]' is given. You have to output  Balanced if the paranthesis occurrence is legitimate.
 * IMP Test Cases: (){}[], ([)], [{()}], ({[, )}], (()), []{()}, [{(})]
 * Improvement: Unbalanced msg printing twice in '([)]' case. Make sure that u avoid that by special_flag type implementation. Or much better, use a common boolean flag for this purpose which'll flip as per case eg see Language_Acceptor program.
 */ 
package mycodes;



/**
 *
 * @author HP
 */
public class Balanced_Parenthesis 
{
    public static void main(String... args) 
    {    
        String s="([)]";   
        char a[]=s.toCharArray();
        int i=-1;                           //i here is same as top in stack. bcz i++ has been put before assigning last_opened[i] so that i always keeps track of last entered index nd not the next which would happen otherwise nd wouldnn't solve our purpose of stack implementation. Recollect: In stack also we initialise top with -1 for the same reason.
        int last_opened[]=new int[100];     //created to keep track of last opened bracket type. And implemented like a stack whic is popped(i--) whenever a closed bracket of type 'top' is encountered.
        int flag1=0;
        int flag2=0;
        int flag3=0;
        int special_flag=0;                //Needed so that in ')}]' case, both Unbalanced & Balanced does not print. coz in this case although flags(1/2/3) remain zero, it is not a balanced string.
        for(char b: a)
        {
            if(i==-1 && (b==')' || b=='}' || b==']'))       //First element is a closing bracket. Mentioned separately coz -1 is an invalid index and we'll get ArrayIndexOutOfBounds if we try to access. Obviou.sly
            {
                System.out.println("Unbalanced String");
                special_flag=1;
                break;
            }
            if(b=='(')
            {
                flag1++;
                i++;
                last_opened[i]=1;
            }
            if(b=='{')
            {
                flag2++;
                i++;
                last_opened[i]=2;
            }
            if(b=='[')
            {
                flag3++;
                i++;
                last_opened[i]=3;
            }
             
            if(b==')')
            {
                if(last_opened[i]==1)
                {
                    flag1--;
                    i--;
                }    
                else
                {
                    System.out.println("Unbalanced String");
                    break;
                }
            }
            if(b=='}')
            {
                if(last_opened[i]==2)
                {
                    flag2--;
                    i--;
                }    
                else
                {
                    System.out.println("Unbalanced String");
                    break;
                }
            }
            if(b==']')
            {
                if(last_opened[i]==3)
                {
                    flag3--;
                    i--;
                }    
                else
                {
                    System.out.println("Unbalanced String");
                    break;
                }
            }
        }
        // System.out.println("Flag Values are: "+flag1+" "+flag2+" "+flag3);       //For testing needs
            if(flag1==0 && flag2==0 && flag3==0 && special_flag==0)
            {
                System.out.println("Balanced String");
            }
            else if(special_flag!=1)                        //bcz message corresponding to this case has already been displayed.                              
                System.out.println("Unbalanced String");        //for strings like ((({{[[ which won't get negated in upper statements.
    }
}
