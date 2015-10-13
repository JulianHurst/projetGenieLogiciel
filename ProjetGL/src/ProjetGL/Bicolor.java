/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetGL;

/**
 *
 * @author juju
 */
public class Bicolor extends Light{
    Bicolor(String colour){
	super(colour);
    }
	
    /*void changecolourbool(){
	colour=!colour;
    }*/
	
    @Override
    void changecolour(){
	if(colour.equals("Red"))
		colour="Green";
	else
		colour="Red";
    }
}