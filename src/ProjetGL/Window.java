/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author guest-77MsiJ
 */
public class Window extends JPanel implements ActionListener {
    private final int DELAY = 500;
    private Timer timer; 
    TriColor t_r;
    TriColor t_l;
    BiColor bi_u;
    BiColor bi_d;
    Barrier b_r;
    Barrier b_l;
    Bridge pont;
    Car car_r;
    Car car_l;
    Boat boat_u;
    Boat boat_d;
    Sensor scar;
    Sensor sboat_1;
    Sensor sboat_2;
    Dimension windowsize;
    
    Window(){
        windowsize = getDefaultToolkit().getScreenSize();
        car_r=new Car(100,windowsize.width-200,windowsize.height/3+60);
        car_l=new Car(150,150, windowsize.height/3+180);
        boat_u=new Boat(50,windowsize.width/2-200, 50);
        boat_d=new Boat(20,windowsize.width/2+100, windowsize.height-260);
        t_r=new TriColor("EST");
        t_l=new TriColor("OUEST");
        bi_u=new BiColor("NORD");
        bi_d=new BiColor("SUD");
        b_r=new Barrier("EST");
        b_l=new Barrier("OUEST");
        pont=new Bridge();
        scar= new Sensor();
        sboat_1=new Sensor();
        sboat_2=new Sensor();
        initTimer();
    }
    
    private void initTimer(){
        timer = new Timer(DELAY,this);        
        timer.start();
    }
    
    Timer getTimer(){
        return timer;
    }        
    
    void Draw(Graphics g){             
        try {
            Graphics2D g2d = (Graphics2D) g;
            
            BufferedImage car = ImageIO.read(this.getClass().getResourceAsStream("res/car.png"));
            BufferedImage car1 = ImageIO.read(this.getClass().getResourceAsStream("res/car1.png"));
            BufferedImage road = ImageIO.read(this.getClass().getResourceAsStream("res/road.jpg"));
            BufferedImage river = ImageIO.read(this.getClass().getResourceAsStream("res/river.jpg"));
            BufferedImage boat = ImageIO.read(this.getClass().getResourceAsStream("res/boat.png"));
            BufferedImage boat1 = ImageIO.read(this.getClass().getResourceAsStream("res/boat1.png"));
            BufferedImage redlight_r = ImageIO.read(this.getClass().getResourceAsStream("res/redlight_r.png"));
            BufferedImage redlight_l = ImageIO.read(this.getClass().getResourceAsStream("res/redlight_l.png"));
            BufferedImage yellowlight_r = ImageIO.read(this.getClass().getResourceAsStream("res/yellowlight_r.png"));
            BufferedImage yellowlight_l = ImageIO.read(this.getClass().getResourceAsStream("res/yellowlight_l.png"));
            BufferedImage greenlight_r = ImageIO.read(this.getClass().getResourceAsStream("res/greenlight_r.png"));
            BufferedImage greenlight_l = ImageIO.read(this.getClass().getResourceAsStream("res/greenlight_l.png"));
            BufferedImage redlight_u = ImageIO.read(this.getClass().getResourceAsStream("res/redlight_u.png"));
            BufferedImage greenlight_u = ImageIO.read(this.getClass().getResourceAsStream("res/greenlight_u.png"));
            BufferedImage redlight_d = ImageIO.read(this.getClass().getResourceAsStream("res/redlight_d.png"));
            BufferedImage greenlight_d = ImageIO.read(this.getClass().getResourceAsStream("res/greenlight_d.png"));
            
            //Rivière en 3 parties si le pont est fermé
            if(!pont.getIsOpen()){
                g.drawImage(river, windowsize.width/3, 0, windowsize.width/3, windowsize.height/3, this);
                g.drawImage(river, windowsize.width/3, windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
                g.drawImage(river, windowsize.width/3, 2*windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
            }
            
            //Route
            g.drawImage(road, 0, 40*windowsize.height/100, windowsize.width, 200, this);             
            
            //Si le pont est ouvert dessiner après la route
            if(pont.getIsOpen()){
                g.drawImage(river, windowsize.width/3, 0, windowsize.width/3, windowsize.height/3, this);
                g.drawImage(river, windowsize.width/3, windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
                g.drawImage(river, windowsize.width/3, 2*windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
            }
            
            if(car_r.getX()<0)
		car_r.setX(windowsize.width);
            if(car_l.getX()>windowsize.width)
		car_l.setX(0);
            if(boat_u.getY()>windowsize.height)
		boat_u.setY(0);
            if(boat_d.getY()<0)
		boat_d.setY(windowsize.height);
            
            //Voiture de droite
            g.drawImage(car, car_r.getX(), car_r.getY(), 106, 66, this);
            //Voiture de gauche
            g.drawImage(car1, car_l.getX(), car_l.getY(), 106, 66, this);
            
            //Bateau en haut
            g.drawImage(boat, boat_u.getX(), boat_u.getY(), 72, 128, this);
            //Bateau en bas
            g.drawImage(boat1, boat_d.getX(), boat_d.getY(), 72, 128, this);
                        
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(10));
            
            //Feu droits
            switch(t_r.getColor()){                           
                case "Red" :
                    g.drawImage(redlight_r, windowsize.width-500, windowsize.height/3,126,64, this);
                    break;
                case "Orange" :
                    g.drawImage(yellowlight_r, windowsize.width-500, windowsize.height/3,126,64, this);
                    break;
                case "Green" :
                    g.drawImage(greenlight_r, windowsize.width-500, windowsize.height/3,126,64, this);
                    break;                
            }
            //g.drawImage(redlight_r, windowsize.width-300, 40*windowsize.height/100-50,126,64, this);
             
            //Feux gauches  
            switch(t_l.getColor()){
                case "Red" :         
                    g.drawImage(redlight_l, windowsize.width/2-626, windowsize.height/3+300,126,64, this);
                    break;
                case "Orange" :
                    g.drawImage(yellowlight_l, windowsize.width/2-626, windowsize.height/3+300,126,64, this);
                    break;
                case "Green" :
                    g.drawImage(greenlight_l, windowsize.width/2-626, windowsize.height/3+300,126,64, this);
                    break;
            }
            
            switch(bi_u.getColor()){
                case "Red" :         
                    g.drawImage(redlight_u, 550, 250,64,126, this);
                    break;                
                case "Green" :
                    g.drawImage(greenlight_u, 550, 250,64,126, this);
                    break;
            }
            
            switch(bi_d.getColor()){
                case "Red" :         
                    g.drawImage(redlight_d, 2*windowsize.width/3+30, windowsize.height/2+100,64,126, this);
                    break;                
                case "Green" :
                    g.drawImage(greenlight_d, 2*windowsize.width/3+30, windowsize.height/2+100,64,126, this);
                    break;
            }
            //g.drawImage(redlight_l, windowsize.width/2-500, windowsize.height/2+120,126,64, this);
            
            //Barriere droite
            if(!b_r.getIsOpen())
                g2d.drawLine(windowsize.width-300, 40*windowsize.height/100, windowsize.width-300, windowsize.height/2);
            //Barriere gauche
            if(!b_l.getIsOpen())
                g2d.drawLine(500, windowsize.height/2+20, 500, windowsize.height/2+100);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Draw(g);
    }
    
    public void thing(){
        int riverwidth = windowsize.width/3;  
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {                
        if(t_r.getColor().equals("Green") || car_r.getX()!=windowsize.width-300)
            car_r.setX(car_r.getX()-car_r.getSpeed());                                            
        if(t_l.getColor().equals("Green") || car_l.getX()!=300)
            car_l.setX(car_l.getX()+car_l.getSpeed());                                                
        if(bi_u.getColor().equals("Green") || boat_u.getY()!=300)
            boat_u.setY(boat_u.getY()+boat_u.getSpeed());
        if(bi_d.getColor().equals("Green") || boat_d.getY()!=windowsize.height-440)
            boat_d.setY(boat_d.getY()-boat_d.getSpeed());       
        repaint();
        
    }
    
}
