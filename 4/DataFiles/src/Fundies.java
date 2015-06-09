import hsa.*;
import processing.core.*;
import java.util.StringTokenizer;

//change name of class here
public class Fundies {

    public static Console c;
    public static PApplet pa;
    public static String data[] = new String [5];
    static String names[] = new String[5];
    static int marks[][] = new int[5][4];
    
    public static void main(String args[])
    {
        c = new Console();
        pa = new PApplet();
        data = pa.loadStrings("studata2.txt");
        for (int x = 0; x < 5; x++) {
            StringTokenizer st = new StringTokenizer(data[x],",");
            names[x]=st.nextToken();
            for (int y = 0; y < 4; y++) {
                   marks[x][y] = Integer.parseInt(st.nextToken().trim());
                }
        }
        for (int x = 0; x < 5; x++) {
                c.print(names[x] + "\t");
                for (int y=0; y<4; y++){
                    c.print(marks[x][y],5);
                }
                c.println("");
            }
    }
    
}
