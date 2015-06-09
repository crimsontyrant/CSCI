import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class Math extends PApplet
{
	GOption optsml,optmed,optlg;
        GToggleGroup size;
        GSlider slide;
        GButton btnsize;
        int scale=100;
        public void setup()
	{
		size(640, 480, JAVA2D);
                btnsize=new GButton(this,10,10,80,30);
                optsml=new GOption(this,10,50,80,30);
                optmed=new GOption(this,110,50,80,30);
                optlg=new GOption(this,210,50,80,30);
                btnsize.setText("Change Size");
                optsml.setText("Small");
                optmed.setText("Medium");
                optlg.setText("Large");
                size=new GToggleGroup();
                size.addControl(optsml);
                size.addControl(optmed);
                size.addControl(optlg);
                //x y width height thickness
                slide=new GSlider(this,10,200,300,40,30);
                //set limits preset number, min, max
                slide.setLimits(100,10,200);
                

	}

	public void handleButtonEvents(GButton button, GEvent event) 
	{
                if(optsml.isSelected()){
                    scale=50;
                }
                else if(optmed.isSelected()){
                    scale=100;
                }
                else if(optlg.isSelected()){
                    scale=150;
                }
                slide.setValue(scale);
	}	
        
        public void handleSliderEvents(GValueControl slider, GEvent event)
        {
                scale=slide.getValueI();
        }

	public void draw()
	{
		background(255); //white
                fill(255,0,0);
                ellipse(450,200,scale,scale);
	}



}