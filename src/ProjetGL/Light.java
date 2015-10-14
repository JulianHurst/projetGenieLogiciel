/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UTRERA Ludovic
 */
public abstract class Light {
    private String color;
    private final String position;
    
    protected Light(String position){
        this.position=position;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setColor(String color)
    {
        this.color=color;
    }
    
    public String getPosition()
    {
        return position;
    }
    
	public abstract void switchColor();
}
