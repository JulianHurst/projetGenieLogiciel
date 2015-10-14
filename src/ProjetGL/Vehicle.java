/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author guest-77MsiJ
 */
public abstract class Vehicle {
    int speed;
    int x;
    int y;
    
    Vehicle(int speed,int x,int y){
        this.speed=speed;
        this.x=x;
        this.y=y;
    }
    
    int getSpeed(){
        return speed;
    }
    
    void setX(int x){
        this.x=x;
    }
    
    void setY(int y){
        this.y=y;
    }
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }
    
    void setSpeed(int speed){
        this.speed=speed;
    }
}
