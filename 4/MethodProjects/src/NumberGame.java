import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class NumberGame extends PApplet
{
GButton btnbet, btnreset;
GSlider slider;
int point=1000,bid=500;
int number;
String choice="", result="";
PFont f;
GOption opth, optl;
GToggleGroup group;

public void setup()
{
  size(700,150);
  G4P.setGlobalColorScheme(0);
  slider= new GSlider(this, 130,10,400,30,25);
  slider.setLimits(bid,0,point);
  optl= new GOption(this,10,50,50,30);
  opth= new GOption(this,60,50,50,30);
  optl.setText("Low");
  opth.setText("High");
  group= new GToggleGroup();
  group.addControl(optl);
  group.addControl(opth);
  btnbet= new GButton(this,10,10,100,30);
  btnbet.setText("Bet");
  btnreset= new GButton(this,10,80,100,30);
  btnreset.setText("Reset");
  btnbet.setEnabled(false);
}  


public void handleToggleControlEvents(GToggleControl option, GEvent event) 
{
  if(optl.isSelected()) btnbet.setEnabled(true);
  if(opth.isSelected()) btnbet.setEnabled(true);
}


public void handleButtonEvents(GButton button, GEvent event) 
{
  if(button==btnbet)
  {
    if(optl.isSelected()) choice=optl.getText();
    else choice=opth.getText();
    number=(int)(random(1,13));
    result="Number chosen: "+number;
    //call did win
    if (didwin(number, choice))
    {
      point+=bid;
      result+="\nYou win - you have " +point + " points.";  
    }
    else
    {
      point-=bid;
      result+="\nYou lose - you have " + point + " points.";
    }
    bid=point/2;
    slider.setLimits(bid,0,point);

  }
  if(button==btnreset)
  {
    point=1000;
    bid=point/2;
    slider.setLimits(bid,0,point);
    optl.setSelected(false);
    opth.setSelected(false);
    btnbet.setEnabled(false);
    result="";    
  }  
}

public void handleSliderEvents(GValueControl slider, GEvent event) 
{
  bid=slider.getValueI();  
}

public boolean didwin(int num, String choice)
{
  if(num==7) return false;
  if(num <7 && choice.equals("Low")) return true;
  else if (num >7 && choice.equals("High")) return true;
  else return false;  
}  
public void draw()
{
    if (point==0) 
    {
      btnbet.setEnabled(false);
    }
  background(255,200,200);
  fill(0);
  text(bid,550,30);
  text(""+result,250,100);
  text("7 ALWAYS LOSES, 1-6 = LOW, 8-13 = HIGH",200,60);  
  strokeWeight(3);
  noFill();
  stroke(200,0,0);
  rect(230, 85, 260, 40);
  rect(535, 10, 60, 30);
}  

}