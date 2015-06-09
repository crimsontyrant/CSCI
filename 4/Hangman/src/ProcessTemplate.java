/*
 _______  .__        __      ____  __.                                  
 \      \ |__| ____ |  | __ |    |/ _|____   ____   ____ _____    ____  
 /   |   \|  |/ ___\|  |/ / |      <_/ __ \_/ __ \ /    \\__  \  /    \ 
/    |    \  \  \___|    <  |    |  \  ___/\  ___/|   |  \/ __ \|   |  \
\____|__  /__|\___  >__|_ \ |____|__ \___  >\___  >___|  (____  /___|  /
	\/        \/     \/         \/   \/     \/     \/     \/     \/ 
*/
import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class ProcessTemplate extends PApplet
{
    GButton btnletter[] = new GButton[26];
    String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String word="PINEAPPLE";
    boolean found[] = new boolean[word.length()];
    boolean letfound;
    int tries = 5;
    public void setup()
	{
		size(800, 480, JAVA2D);
                int xloc=15;
                for(int x=0; x<26; x++){
                    btnletter[x]=new GButton(this, xloc,50,20,20);
                    btnletter[x].setText(letters.substring(x,x+1));
                    xloc+=30;
                    
                }

	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
            String letter="";    
            for (int x=0; x<26; x++){
                if (button==btnletter[x]){
                    letter = btnletter[x].getText();
                    btnletter[x].setVisible(false);
                }
            }
            for (int x=0; x<word.length(); x++){
                if (letter.equals(word.substring(x,x+1))){
                    found[x]=true;
                    letfound=true;
                }
            }
            if (letfound==false) tries--;
            letfound=false;
	}		

	public void draw()
	{
		background(255); //white
                
                stroke(255,0,0);
                fill(0);
                textFont(createFont("Comic Sans MS",20));
                text("Tries: " + tries, 500, 400);
                textFont(createFont("Comic Sans MS",80));
                int xloc=50;
                for (int x=0; x<word.length(); x++){
                    fill(0);
                    rect(xloc,220,60,100);
                    if(found[x]) fill(255);
                    text(word.substring(x,x+1),xloc,300);
                    xloc+=80;
                }
	}



}