/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 *@author UTRERA Ludovic
 */
public class TriColor extends Light {
    //private final String position;
    public TriColor(String position)
    {
       super(position);
       setColor("Green");
       
    }
    
    
    
    public void switchColor()
    {
        if(this.getColor().equals("Red"))
            this.setColor("Green");
        else if(this.getColor().equals("Green"))
            this.setColor("Orange");
        else
            this.setColor("Red");
    }
    
    
   
    @Override
    public String toString()
    {
    	return "Le feu tricolor: "+this.getPosition()+" est passe au: "+this.getColor();
    }
    
}

