/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetGL;

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
    private final int DELAY = 150;
    private Timer timer;
    private int distance;
    private int distanceb;
    /*Tricolor t_r;
    Tricolor t_l;
    Bicolor bi_u;
    Bicolor bi_d;
    Barrier b_r;
    Barrier b_l;
    Bridge B;*/
    Dimension windowsize;
    
    Window(){
        distance=400;
        distanceb=250;
        initTimer();
    }
    
    private void initTimer(){
        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    Timer getTimer(){
        return timer;
    }
    
    int getdistance(){
        return distance;
    }
    
    void setdistance(int distance){
        this.distance=distance;
        if(this.distance>windowsize.width+213)
            this.distance=0;
    }
    
    void Draw(Graphics g){     
        windowsize = getDefaultToolkit().getScreenSize();
        try {
            Graphics2D g2d = (Graphics2D) g;
            
            BufferedImage car = ImageIO.read(this.getClass().getResourceAsStream("res/car.png"));
            BufferedImage car1 = ImageIO.read(this.getClass().getResourceAsStream("res/car1.png"));
            BufferedImage road = ImageIO.read(this.getClass().getResourceAsStream("res/road.jpg"));
            BufferedImage river = ImageIO.read(this.getClass().getResourceAsStream("res/river.jpg"));
            BufferedImage boat = ImageIO.read(this.getClass().getResourceAsStream("res/boat.png"));
            BufferedImage boat1 = ImageIO.read(this.getClass().getResourceAsStream("res/boat1.png"));
            
            g.drawImage(river, windowsize.width/3, 0, windowsize.width/3, windowsize.height/3, this);
            g.drawImage(river, windowsize.width/3, windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
            g.drawImage(river, windowsize.width/3, 2*windowsize.height/3, windowsize.width/3, windowsize.height/3, this);
            g.drawImage(road, 0, windowsize.height/3, windowsize.width, 400, this);             
            g.drawImage(car, windowsize.width-distance, windowsize.height/3+45, 213, 133, this);
            g.drawImage(car1, distance-250, windowsize.height/3+250, 213, 133, this);
            g.drawImage(boat, windowsize.width/2-distanceb, 50, 144, 256, this);
            g.drawImage(boat1, windowsize.width/2+100, windowsize.height-300, 144, 256, this);
            
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(10));
            g2d.drawLine(windowsize.width-500, windowsize.height/3, windowsize.width-500, windowsize.height/2);
            g2d.drawLine(windowsize.width/2-500, windowsize.height/3+200, windowsize.width/2-500, windowsize.height/3+400);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Draw(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    
}
