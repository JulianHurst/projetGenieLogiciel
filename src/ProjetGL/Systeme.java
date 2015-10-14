/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author guest-77MsiJ
 */
public class Systeme extends JFrame {
    final Window w = new Window();
    
    Systeme(){         
        init();
    }
    
    private void init(){
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        
        add(w);
        JPanel pan = new JPanel();
        JButton button = new JButton("drive");
        JButton button1 = new JButton("change");
        pan.add(button);
        pan.add(button1);
        add(pan,BorderLayout.SOUTH);        
        button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(w.t_r.getColor().equals("Green"))
                   w.car_r.setX(w.car_r.getX()-w.car_r.getSpeed());                                            
               if(w.t_l.getColor().equals("Green"))
                   w.car_l.setX(w.car_l.getX()+w.car_l.getSpeed());                                                
               if(w.bi_u.getColor().equals("Green"))
                   w.boat_u.setY(w.boat_u.getY()+w.boat_u.getSpeed());
               if(w.bi_d.getColor().equals("Green"))
                   w.boat_d.setY(w.boat_d.getY()-w.boat_d.getSpeed());               
           } 
        });
        
        button1.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent e){
                try {                
                    gestion();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Systeme.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = w.getTimer();
                timer.stop();                
            }
        });
        
        setTitle("ProjetGL");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class MyThread extends Thread {

    @Override
    public void run(){
        int riverwidth = w.windowsize.width/3;                        
        if(!w.pont.getIsOpen()){
            w.t_l.switchColor();
            w.t_r.switchColor();     
            if((w.car_r.getX()>=riverwidth-106 && w.car_r.getX()<=(2*riverwidth)) || (w.car_l.getX()<=2*riverwidth && w.car_l.getX()>=riverwidth))
                w.scar.toggleDetect(); 
        while(w.scar.getDetect()){
            w.car_r.setX(w.car_r.getX()-w.car_r.getSpeed());                                                                    
            w.car_l.setX(w.car_l.getX()+w.car_l.getSpeed());            
            if((w.car_r.getX()<riverwidth-106 || w.car_r.getX()>(2*riverwidth)) && (w.car_l.getX()>2*riverwidth || w.car_l.getX()<riverwidth))
                w.scar.toggleDetect();  
            try {
                MyThread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Systeme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        w.b_l.toggleBarrier();
                w.b_r.toggleBarrier();
                w.t_l.switchColor();
                w.t_r.switchColor();
                w.pont.toggleBridge();
                w.bi_u.switchColor();
                w.bi_d.switchColor();                
            }
            else{
                w.bi_u.switchColor();
                w.bi_d.switchColor();                                                                                                                
                w.pont.toggleBridge();
                w.b_l.toggleBarrier();
                w.b_r.toggleBarrier();
                w.t_l.switchColor();
                w.t_r.switchColor();   
             }
        }                                
    }
           
    
    public void gestion() throws InterruptedException{
                MyThread t = new MyThread();            
                t.start();                          
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Systeme ex = new Systeme();                
                ex.setVisible(true);                                               
            }
        });
        
    }
}
