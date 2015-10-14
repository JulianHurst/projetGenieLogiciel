/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UTRERA Ludovic
 */
public class Barrier {
    private boolean isOpen;
    private final String position;
    public Barrier(String position)
    {
        isOpen=true;
        this.position=position;
    }
    
    public void toggleBarrier(){
        isOpen=!isOpen;
    }
    
    public void openBarrier()
    {
        isOpen=true;
    }
    
    public void closeBarrier()
    {
        isOpen=false;
    }
    
    public boolean getIsOpen()
    {
      return isOpen;  
    }
 
    @Override 
    public String toString()
    {
        String str;
        if(this.isOpen==false)
            str="Fermeture barriere "+position;
        else
            str="Ouverture barriere "+position;
        return str;
    }
    
}
