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
public class Tricolor extends Light {
    Tricolor(String colour){
	super(colour);
    }
    
    void changecolour(){
        if(colour.equals("Red"))
            colour="Green";
        else{
            colour="Orange";
            colour="Red";
        }
    }
}