/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetGL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author guest-77MsiJ
 */
public class System extends JFrame {
    System(){
        init();
    }
    
    private void init(){
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        final Window w = new Window();
        add(w);
        JButton button = new JButton("drive");
        add(button,BorderLayout.SOUTH);
        button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               w.setdistance(w.getdistance()+100);          //mettre coord et speed du véhicule
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
    
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                System ex = new System();
                ex.setVisible(true);
            }
        });
    }
}
