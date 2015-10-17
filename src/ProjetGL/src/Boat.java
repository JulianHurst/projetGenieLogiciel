/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UTRERA Ludovic
 */
public class Boat extends Vehicle{
    public static final int VITESSE_MIN=5;
   public Boat(int speed,int x,int y)
   {
       super(speed,x,y);
   }
   
   public void setMinimumVitesse()
   {
	   setSpeed(VITESSE_MIN);
   }
}
