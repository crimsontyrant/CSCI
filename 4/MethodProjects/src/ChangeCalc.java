import hsa.*;
import java.text.NumberFormat;

//change name of class here
public class ChangeCalc {

    public static Console c;
    
    public static void main(String args[])
    {
        int pen, nick, dime, quart;
        c = new Console();
        while (true) {
        c.print("Enter your pennies: ");
        pen = c.readInt();
        c.print("Enter your nickels: ");
        nick = c.readInt();
        c.print("Enter your dimes: ");
        dime = c.readInt();
        c.print("Enter your quarters: ");
        quart = c.readInt();
        double money = convertmoney(pen,nick,dime,quart);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        c.println("You have: " + formatter.format(money) + ".");
        c.println("Press any key to continue.");
        c.getChar();
        c.clear();
        }
    }
    
    public static double convertmoney(int p, int n, int d, int q)
    {
        double money = (0.01*p) + (0.05*n) + (0.10*d) + (0.25*q);
        return money;
    }
}
