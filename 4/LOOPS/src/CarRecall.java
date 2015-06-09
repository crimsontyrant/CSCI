import hsa.*;

//change name of class here
public class CarRecall {

    public static Console c;
    
    public static void main(String args[])
    {
        Console c = new Console();
        int model;

        while(true)
        {
            c.print("Enter the car's model number or -1 to quit: ");
            model=c.readInt();
            
            if (model== -1) break;
            else if(model>=189 && model<=195 || model==119 || model==179 || model==221)
            {
                c.println("Your car is defective. It must be repaired."); 
            }
            else
            {
                c.println("Your car is not defective.");
            }
        }    
    }
    
}
