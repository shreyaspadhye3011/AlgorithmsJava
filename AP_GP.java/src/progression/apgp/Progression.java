/* Input: Sequence of numbers
 * Output: "AP" if its an aritmetic Prog, "GP" if its a geo prog & -1 if its none
 * 
 * Learning 1: Setting command line args in Netbeans (http://stackoverflow.com/questions/27405378/command-line-arguments-using-netbeans)
 * Learning 2: Accepting variable cmd line args for each test case (for each loop) (see code)
 */
package progression.apgp;

//import java.math.BigDecimal;
//import java.math.MathContext;

public class Progression {

    
    public static void main(String[] args) {
        int i=0;
       // System.out.println(args.length);              //to check whether arguments are successfuly passed
         Integer a[] = new Integer[args.length];        //**IMP**: Dynamic array implementation
         try
         {
        for(String a1:args)                             //**IMP**: Undefined number of Command Line arguments
        {
            int temp= Integer.parseInt(a1);
            a[i]=temp;
            i++;
        }
        int k=a[1]-a[0];
       int l=a[1]/a[0];
        int ap=0;
        int gp=0;
        for(int j=2; j<args.length; j++)
        {
           if(a[j]-a[j-1]==k)
           {
               ap++;
           }
           if(a[j]/a[j-1]==l)
           {
               gp++;
           }
        }
        if(ap==args.length-2)
                System.out.println("AP");
        else if(gp==args.length-2)
                System.out.println("GP");
                
                else System.out.println("AP Flag: "+ap+" GP Flag: "+gp+" Thus result is :-1");
         } catch (NullPointerException e) {e.printStackTrace();}
    }
}
