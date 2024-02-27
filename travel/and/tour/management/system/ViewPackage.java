package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewPackage(String username){
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(250, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setForeground(Color.RED);
        add(text);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1username.setBounds(30, 50, 150, 30);
        add(lb1username);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 30);
        add(labelusername);
        
        JLabel lb1id = new JLabel("Package");
        lb1id.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1id.setBounds(30, 90, 150, 30);
        add(lb1id);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 30);
        add(labelpackage);
        
        JLabel lb1number = new JLabel("Total Persons");
        lb1number.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1number.setBounds(30, 130, 150, 30);
        add(lb1number);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 30);
        add(labelpersons);
        
        JLabel lb1name = new JLabel("ID");
        lb1name.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1name.setBounds(30, 170, 150, 30);
        add(lb1name);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 30);
        add(labelid);
        
        JLabel lb1gender = new JLabel("Number");
        lb1gender.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1gender.setBounds(30, 210, 150, 30);
        add(lb1gender);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 30);
        add(labelnumber);
        
        JLabel lb1country = new JLabel("Phone");
        lb1country.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1country.setBounds(30, 250, 150, 30);
        add(lb1country);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 30);
        add(labelphone);
        
        JLabel lb1address = new JLabel("Price");
        lb1address.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1address.setBounds(30, 290, 150, 30);
        add(lb1address);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 30);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 350);
        add(image);
        
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                
               
            }
        } catch (Exception e) {
            
            
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewPackage("");
    }
}