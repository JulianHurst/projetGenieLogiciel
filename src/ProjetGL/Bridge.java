/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author u15018407
 */
public class Bridge {
   private boolean isOpen;
  
   public Bridge()
   {
       isOpen=false;
   }
   
   public boolean getIsOpen()
   {
       return isOpen;
   }
   
   public void openBridge()
   {
       isOpen=true;
   }
   
   public void closeBridge()
   {
       isOpen=false;
   }
   
   public void toggleBridge(){
       isOpen=!isOpen;
   }
   
   @Override
   public String toString()
   {
       String str;
       if(isOpen)
           str="On ouvre le pont";
       else
           str="On ferme le pont";
       return str;
   }
}
