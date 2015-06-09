import hsa.*;
import processing.core.*;

//change name of class here
public class DataFiles1 {

    public static Console c;
    public static PApplet pa;
    public static String data[] = new String [10];
    static String names[] = new String[5];
    static int marks[] = new int[5];
    
    public static void main(String args[])
    {
        c = new Console();
        pa = new PApplet();
        data = pa.loadStrings("studata.txt");
        int count = 0, avg = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) names[count] = data[i];
            else{
                marks[count] = Integer.parseInt(data[i]);
                avg+=marks[count];
                count++;
            }
        }
        for (int i = 0; i < 5; i++) {
            c.print(names[i] + "\t\t\t");
            c.println(marks[i]);
        }
        c.println("\nClass average: " + avg/5);
    }
    
}
