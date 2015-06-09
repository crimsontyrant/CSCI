import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class Necklace extends PApplet
{
	GButton btnmake, btnclear;
        GLabel lblnum1, lblnum2;
        GTextField txtnum1, txtnum2;
        GTextArea txtlist;
        int num1, num2, nextnum;
        int orig1, orig2;
        public void setup()
	{
                size(180, 300);
                txtnum1=new GTextField(this, 50, 10, 40, 30);
                txtnum2=new GTextField(this, 50, 50, 40, 30);
                txtlist=new GTextArea(this, 100, 50, 80, 250, 1);
                btnmake=new GButton(this, 100, 10, 80, 30);
                btnmake.setText("Make Necklace");
                btnclear=new GButton(this, 10, 100, 90, 30);
                btnclear.setText("Clear");
                lblnum1=new GLabel(this, 5, 10, 40, 30);
                lblnum1.setText("Num 1");
                lblnum2=new GLabel(this, 5, 50,40, 30);
                lblnum2.setText("Num 2");
	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
                if(button==btnmake)
                {
                    txtlist.setText("");
                    num1= Integer.parseInt(txtnum1.getText().trim());
                    num2= Integer.parseInt(txtnum2.getText().trim());
                    if(num1<1 || num1>9 ||num2<1|| num2>9)
                    {
                        JOptionPane.showMessageDialog(null,"Error - Must be between 1 and 9.");
                        txtnum1.setText("");
                        txtnum2.setText("");
                        return;
                    }
                    orig1=num1;
                    orig2=num2;
                    txtlist.appendText("\n"+orig1);
                    txtlist.appendText("\n"+orig2);
                    while(true)
                    {
                        nextnum= num1+ num2;
                        if(nextnum>9) nextnum-=10;
                        txtlist.appendText("\n"+nextnum);
                        num1=num2;
                        num2=nextnum;
                        if(num1==orig1 && num2==orig2)break;
                    }
                }
                else if (button==btnclear)
                {
                    txtlist.setText("");
                    txtnum2.setText("");
                    txtnum1.setText("");
                }
	}		

	public void draw()
	{
		background(255); //white
	}



}