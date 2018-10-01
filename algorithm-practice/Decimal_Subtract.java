/*
 * Aim: To subtract decimal numbers effectively, you need to use BigDecimal because float subtraction faces accuracy errors due to rounding errors.
 */
package mycodes;

import java.math.BigDecimal;
import java.math.MathContext;

public class Decimal_Subtract 
{ 
    public static void main(String... args) 
    {
        
         BigDecimal bg1;
         BigDecimal bg2;
         BigDecimal bg3;

	MathContext mc = new MathContext(2);        //Round UP/Precision of n. Here n=2.

        bg1 = new BigDecimal(0.8);                     //BigDecimal has a variety of objects (for int, double, string etc)
        bg2 = new BigDecimal(0.6);

        // subtract bg2 from bg1 using mc and assign result to bg3
        bg3 = bg1.subtract(bg2, mc);
        
        System.out.println(bg3);
         
    }
}
