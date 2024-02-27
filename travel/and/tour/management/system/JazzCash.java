package travel.and.tour.management.system;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class JazzCash extends JFrame implements ActionListener {
    
    JazzCash(){
        
        setBounds(500, 100, 800, 600);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
            
            pane.setPage("https://www.jazzcash.com.pk/");
            
        }catch (Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Cloud not load, Error 404<html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back = new JButton("Back");
        back.setBounds(610, 500, 80, 35);
        back.setBackground(new Color(98,190,18));
        back.addActionListener(this);
        pane.add(back);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }
    
    public static void main(String[] args) {
        new JazzCash();
    }
    
}
