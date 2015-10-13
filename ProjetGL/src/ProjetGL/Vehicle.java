/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetGL;

/**
 *
 * @author guest-77MsiJ
 */
public abstract class Vehicle {
    int speed;
    int x;
    int y;
    
    Vehicle(){
        speed=100;        
    }
    
    int getSpeed(){
        return 0;
    }
    
    void setSpeed(int speed){
        this.speed=speed;
    }
}
