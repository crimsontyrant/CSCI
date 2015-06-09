import g4p_controls.*;
import java.util.Random;
import javax.swing.*;
import processing.core.*;

//change name of class:
public class FiveToFour extends PApplet
{
	GButton btnnew, btnroll;
        GCheckbox chkeep[] = new GCheckbox[4];
        PImage imgdice[] = new PImage[4];
        PFont font;
        int num[]=new int[4], tries=5;
        Boolean winstate = false, gameactive = false;
        Random r = new Random();
        public void setup()
	{
		size(640, 300, JAVA2D);
                font=createFont("Arial Bold", 24);
                int xloc = 50;
                for(int x=0;x<4;x++){
                    imgdice[x]=loadImage("q.jpg");
                    chkeep[x]=new GCheckbox(this,xloc,200,80,30);
                    chkeep[x].setText("Keep");
                    xloc+=100;
                }
                btnnew=new GButton(this,500,100,80,30);
                btnnew.setText("New Game");
                btnroll=new GButton(this,500,160,80,30);
                btnroll.setText("Roll");
                btnroll.setEnabled(false);
	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
            if(button==btnnew){
                gameactive = true;
                tries = 5;
                winstate = false;
                btnnew.setEnabled(false);
                btnroll.setEnabled(true);
                for(int x=0;x<4;x++){
                    num[x]=r.nextInt(6) + 1;
                    imgdice[x]=loadImage("d" + num[x] + ".jpg");
                    chkeep[x].setSelected(false);
                }
                for(int x=1;x<4;x++){
                    if(num[x]!=num[x-1])break;
                    if(x==3)winstate=true;
                }
            }
            else{
                //go to each check box, if unselected, pick new number.
                tries-=1;
                for(int x=0;x<4;x++){
                    if(chkeep[x].isSelected()==false){
                        num[x]=r.nextInt(6) + 1;
                        imgdice[x]=loadImage("d" + num[x] + ".jpg");
                    }
                }
                for(int x=1;x<4;x++){
                    if(num[x]!=num[x-1])break;
                    if(x==3)winstate=true;
                }
                System.out.println(winstate);
                if(tries==0 || winstate==true){
                    gameactive=false;
                    btnnew.setEnabled(true);
                    btnroll.setEnabled(false);
                }
            }
	}		

	public void draw()
	{
		background(255); //white
                int xloc=50;
                for (int x=0;x<4;x++){
                    image(imgdice[x],xloc,100);
                    xloc+=100;
                }
                fill(0);
                textFont(font);
                text("FIVE CHANCES TO GET FOUR",50,50);
                text("Tries: " + tries,50,280);
                if(winstate==true){
                    text("You win",200,280);
                }
                else if(winstate==false && tries==0){
                    text("You lose",200,280);
                }
                else{
                    text("",200,280);
                }
	}



}