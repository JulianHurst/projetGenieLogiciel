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
public abstract class Light {    
    protected String colour;
	
    Light(String colour){
	this.colour=colour;
    }

    String getcolour(){
    	return colour;
    }
	
    void setcolour(String colour){
	this.colour=colour;
    }
	
    abstract void changecolour();
}