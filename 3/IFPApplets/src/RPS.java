import processing.core.*;
import g4p_controls.*;
import javax.swing.*;
import java.util.Random;

//change name of class:
public class RPS extends PApplet
{
        int cpick, wins = 0, lose = 0, draw = 0;
        String winner;
        PImage img1, img2;
        PFont font;
        GButton btnr, btnp, btns;
        GTextArea txtans;
        Random r = new Random();
	public void setup()
	{
		size(640, 480, JAVA2D);
                cpick=r.nextInt(3) + 1;
                font=createFont("Arial Bold", 24);
                fill(255);
                img1=loadImage("pr.png");
                img2=loadImage("cr.png");
                btnr=new GButton(this,80,50,80,30);
                btnr.setText("Rock");
                btnp=new GButton(this,280,50,80,30);
                btnp.setText("Paper");
                btns=new GButton(this,480,50,80,30);
                btns.setText("Scissors");
        }

	public void handleButtonEvents(GButton button, GEvent event) 
	{
                if(button==btnr){
                    cpick=r.nextInt(3) + 1;
                    fill(0);
                    if (cpick==1){
                        winner=("Computer chose rock. Draw.");
                        img1=loadImage("pr.png");
                        img2=loadImage("cr.png");
                        draw++;
                    }
                    else if (cpick==2){
                        winner=("Computer chose paper. You lose.");
                        img1=loadImage("pr.png");
                        img2=loadImage("cp.png");
                        lose++;
                    }
                    else if (cpick==3){
                        winner=("Computer chose scissors. You win.");
                        img1=loadImage("pr.png");
                        img2=loadImage("cs.png");
                        wins++;
                    }
                }
                if(button==btnp){
                    cpick=r.nextInt(3) + 1;
                    fill(0);
                    if (cpick==1){
                        winner=("Computer chose rock. You win.");
                        img1=loadImage("pp.png");
                        img2=loadImage("cr.png");
                        wins++;
                    }
                    else if (cpick==2){
                        winner=("Computer chose paper. Draw.");
                        img1=loadImage("pp.png");
                        img2=loadImage("cp.png");
                        draw++;
                    }
                    else if (cpick==3){
                        winner=("Computer chose scissors. You lose.");
                        img1=loadImage("pp.png");
                        img2=loadImage("cs.png");
                        lose++;
                    }
                }
                if(button==btns){
                    cpick=r.nextInt(3) + 1;
                    fill(0);
                    if (cpick==1){
                	winner=("Computer chose rock. You lose.");
                        img1=loadImage("ps.png");
                        img2=loadImage("cr.png");
                        lose++;
                    }
                    else if (cpick==2){
                        winner=("Computer chose paper. You win.");
                        img1=loadImage("ps.png");
                        img2=loadImage("cp.png");
                        wins++;
                    }
                    else if (cpick==3){
                        winner=("Computer chose scissors. Draw.");
                        img1=loadImage("ps.png");
                        img2=loadImage("cs.png");
                        draw++;
                    }
                }
	}		

	public void draw()
	{
		background(255);
                textFont(font);
                text("" + winner,100,400);
                text("Wins: " + wins,100,450);
                text("Losses: " + lose,220,450);
                text("Draws: " + draw,380,450);
                img1.resize(300,180);
                image(img1,0,120);
                img2.resize(300,180);
                image(img2,350,120);
	}



}