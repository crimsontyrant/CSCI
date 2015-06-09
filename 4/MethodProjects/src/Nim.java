import g4p_controls.*;
import javax.swing.*;
import processing.core.*;

//change name of class:
public class Nim extends PApplet
    {
            PImage stones[]=new PImage[30];
            PImage bg;
            int sx[]=new int[30];
            int sy[]=new int[30];
            GTextField txtnum;
            GButton btnsubmit, btnreset;
            int mypick, compick=0, numstones;
            boolean gameRunning = true;

public void setup()
    {
            size(600, 600);
            G4P.setGlobalColorScheme(0);
            bg=loadImage("board.png");
            btnsubmit=new GButton(this, 450, 10, 80, 30);
            btnreset=new GButton(this, 450, 40, 80, 30);
            btnsubmit.setText("Submit");
            btnreset.setText("Reset");
            txtnum=new GTextField(this, 400, 10, 30, 30);
            numstones=(int)(random(15,30));

            for(int x=0; x<30; x++)
            {
                stones[x]=loadImage("rock.png");
                //This massive bit of math confines the stones to a grid of 8x8.
                sx[x]=(((int)((random(1,9)))*50)+50)+(int)(random(-7,7)); 
                sy[x]=(((int)((random(1,9)))*50)+50)+(int)(random(-7,7));
            }
    }

public void handleButtonEvents(GButton button, GEvent event) 
    {
            if(button==btnreset)
            {
                reset();
                btnsubmit.setEnabled(true);
            }
            mypick=Integer.parseInt(txtnum.getText().trim());
            if(pickok(mypick))
            {
                numstones-=mypick;
            }

            else
            {
                JOptionPane.showMessageDialog(this, "Invalid Choice");
                return;
            }
            checkforloser("You");
            txtnum.setText("");

            if(gameRunning==true){
            ComputerPick();

            numstones-=compick;
            checkforloser("The Computer");
            }
    }
public void draw()
    {
            background(0);
            image(bg,0,0);
            noFill();

            stroke(255);
            //rect(100,100,400,400);

            for(int x=0; x<numstones; x++)
            {
                image(stones[x], sx[x], sy[x]);
            }
            fill(255);
            text(numstones + " stones left", 200, 20);
            text("You can take 1 to 3", 200, 40);
            text("The computer took " + compick + " stones last turn.", 5, 590);
    }


public void checkforloser(String who)
    {
        if(numstones==0)
        {
            JOptionPane.showMessageDialog(this, who + " took the last stone and lost.");
            gameRunning=false;
            btnreset.setEnabled(true);
            btnsubmit.setEnabled(false);
        }
    }

public boolean pickok(int p)
    {
            if(p >=1 && p<=3 && p<=numstones)
            {
                return true;
            }
            else
            {
                return false; 
            }
    }

public void ComputerPick()
    {
            //the losing numbers are 29, 25, 21, 17, 13, 9 and 5
            //the computer will always attempt to give the player a losing number
            //once the player is given a losing number, the computer will beat the player always
            //if a losing number cannot be given to the player, the computer loses
            //this should be an adequate challenge
            if(numstones==28) compick=3;
            else if(numstones==27) compick=2;
            else if(numstones==26) compick=1;
            else if(numstones==24) compick=3;
            else if(numstones==23) compick=2;
            else if(numstones==22) compick=1;
            else if(numstones==20) compick=3;
            else if(numstones==19) compick=2;
            else if(numstones==18) compick=1;
            else if(numstones==16) compick=3;
            else if(numstones==15) compick=2;
            else if(numstones==14) compick=1;
            else if(numstones==12) compick=3;
            else if(numstones==11) compick=2;
            else if(numstones==10) compick=1;
            else if(numstones==8) compick=3;
            else if(numstones==7) compick=2;
            else if(numstones==6) compick=1;
            else if(numstones==4) compick=3;
            else if(numstones==3) compick=2;
            else if(numstones==2) compick=1;
            else if(numstones==1) compick=1;
            else{
                while(true)
                {
                    compick=(int)(random(1, 4));
                    if(pickok(compick)) break;
                }
            }
    }

public int reset()
    {
            gameRunning=true;
            compick=0;
            return numstones=(int)(random(15,30));
    }
}