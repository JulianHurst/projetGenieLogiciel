/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author UTRERA Ludovic
 */
public class Sensor {
    private boolean detect;
    
    public Sensor()
    {
        detect=false;
    }
    
    public boolean getDetect()
    {
        return detect;
    }
    
    public void toggleDetect()
    {
    	detect=!detect;
    }
}
