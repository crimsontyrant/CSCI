import processing.core.*;
import g4p_controls.*;
import javax.swing.*;
import java.util.Random;

//change name of class:
public class Math_Tutor extends PApplet
{
        int num1, num2, ans, uans, typegen, numright = 0, cnum;
        String type, mesg;
        PFont font, fontsm;
        GButton btnnew, btnans;
        GTextArea txtans;
        Random r = new Random();
	public void setup()
	{
		size(640, 480, JAVA2D);
                //Generates a default question
                font=createFont("Arial Bold", 48);
                fontsm=createFont("Arial Bold", 18);
                num1 = r.nextInt(12) + 1;
                num2 = r.nextInt(12) + 1;
                typegen = r.nextInt(3) + 1;
                if (typegen == 1){
                    type = "+";
                    ans = (num1 + num2);
                }
                else if (typegen == 2){
                    type = "-";
                    ans = (num1 - num2);
                }
                else{
                    type = "X";
                    ans = (num1 * num2);
                }
                
                btnnew=new GButton(this,450,70,100,30);
                btnnew.setText("New Question");
                btnans=new GButton(this,450,150,60,30);
                btnans.setText("Submit");
                txtans=new GTextArea(this,300,150,100,40);
	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
                if (button==btnnew){
                    btnans.setEnabled(true);
                    cnum=0;
                    num1 = r.nextInt(12) + 1;
                    num2 = r.nextInt(12) + 1;
                    typegen = r.nextInt(3) + 1;
                    if (typegen == 1){
                        type = "+";
                        ans = (num1 + num2);
                    }
                    else if (typegen == 2){
                        type = "-";
                        ans = (num1 - num2);
                    }
                    else{
                        type = "X";
                        ans = (num1 * num2);
                    }
                }
                if (button==btnans){
                    btnans.setEnabled(false);
                    cnum=255;
                    uans = parseInt(txtans.getText());
                    if(ans==uans){
                        mesg=("Yes! ");
                        numright++;
                    }
                    else{
                        mesg=("No. ");
                    }
                }
	}		

	public void draw()
	{
		background(0);
                fill(255);
                textFont(font);
                text("What is " + num1 + type + num2 + "?",20,100);
                textFont(fontsm);
                text("Answer:",100,170);
                text("Correct answers: " + numright,400,400);
                fill(cnum);
                text(mesg + "The correct answer is " + ans + "!",150,300);
	}



}