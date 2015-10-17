/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UTRERA Ludovic
 */
public class BiColor extends Light {
   // private final String position;
    public BiColor(String position)
    {
    	super(position);
        setColor("Red");
    }
    
    public void switchColor()
    {
        if(this.getColor().equals("Red"))
            this.setColor("Green");
        else
            this.setColor("Red");
    }
    
    public String toString()
    {
    	return "Le feu bicolor : "+this.getPosition()+" est passe au : "+this.getColor();
    }
    
    
}
