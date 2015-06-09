import hsa.*;
import java.text.NumberFormat;

//change name of class here
public class Investment {

    public static Console c;
    
    public static void main(String args[])
    {
        Console c = new Console();
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        float inv, rate, money=0;
        int years=0;
        while(true)
        {
            c.print("How much do you want to invest each year?(min $2000): ");
            inv=c.readFloat();
            if(inv>=2000)break;
            c.println("Invalid. Try again.");
        }
        while(true)
        {
            c.print("How much do you expect to earn in interest? (.05 to .15): ");
            rate=c.readFloat();
            if(rate>=0.05 && rate<=0.15)break;
            c.println("Invalid. Try again.");
        }

        while(true)
        {
            money+=inv;
            money+=(money)*rate;
            years++;
            if(money>=1000000)break;
        }
        c.print("You will make over a million after " + years + " years with " + defaultFormat.format(money) + " dollars.");
        
    }
    
}
