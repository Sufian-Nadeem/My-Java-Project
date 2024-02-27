package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    
    About(){
         
        setBounds(600, 100, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(195, 20, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);
        
        
        String s = "About Projects\n" +
" \n"+                
"The objective of this project is to develop a system that automates the processes and activities of a travel agency.\n" +
"The purpose is to design a system using which one can perform all operation related to traveling.\n" +
"In the present system a customer has to approach various agencies to find of place and to book tickets. This often requires a lot of times and effort.\n" +
"The user register their details and they were chosen package which they need.\n" +
"Advantages of Project:\n" +
"Gives accurate information\n" +
"Simplifies the manual work\n" +
"It minimized the documentation related work\n" +
"Provide up to date information\n" +
"Friendly environment by providing warning message\n" +
"Travelers details provided\n" +
"Booking confirmation notification\n";
        
        
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 120, 450, 250);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(190, 440, 100, 25);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args){
        new About();
    }
    
}
