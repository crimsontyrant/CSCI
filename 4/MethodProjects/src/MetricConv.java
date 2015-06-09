import hsa.*;
import java.text.NumberFormat;

//change name of class here
public class MetricConv {

    public static Console c;
    public static double num, finalnum;
    public static int choice;
    
    public static void main(String args[])
    {
        int pen, nick, dime, quart;
        c = new Console();
        while (true) {               
        c.print("Enter a number: ");
        num = c.readDouble();
        c.println("Convert:");
        c.println("1. Inches to centimeters.");
        c.println("2. Feet to centimeters.");
        c.println("3. Yards to meters.");
        c.println("4. Miles to kilometers.");
        c.println("\n");
        c.print("Enter your choice: ");
        choice = c.readInt();
        c.println("\n");
        if (choice==1) finalnum=inches(num);
        else if (choice==2) finalnum=feet(num);
        else if (choice==3) finalnum=yards(num);
        else if (choice==4) finalnum=miles(num);
        else c.println("Invalid.");
        c.println("Your converted unit is: " + finalnum);
        c.println("Press any key to continue.");
        c.getChar();
        c.clear();
        }
    }
    
    public static double inches (double x)
    {
        return x*2.54;
    }
    public static double feet (double x)
    {
        return x*30;
    }
    public static double yards (double x)
    {
        return x*0.91;
    }
    public static double miles (double x)
    {
        return x*1.6;
    }
}
