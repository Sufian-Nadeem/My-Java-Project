package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewCustomer(String username){
        setBounds(450, 100, 870, 620);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW CUSTOMER DETAILS");
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
        
        JLabel lb1id = new JLabel("ID");
        lb1id.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1id.setBounds(30, 110, 150, 30);
        add(lb1id);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 30);
        add(labelid);
        
        JLabel lb1number = new JLabel("Number");
        lb1number.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1number.setBounds(30, 170, 150, 30);
        add(lb1number);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 30);
        add(labelnumber);
        
        JLabel lb1name = new JLabel("Name");
        lb1name.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1name.setBounds(30, 230, 150, 30);
        add(lb1name);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 30);
        add(labelname);
        
        JLabel lb1gender = new JLabel("Gender");
        lb1gender.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1gender.setBounds(30, 290, 150, 30);
        add(lb1gender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 30);
        add(labelgender);
        
        JLabel lb1country = new JLabel("Country");
        lb1country.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1country.setBounds(500, 50, 150, 30);
        add(lb1country);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(660, 50, 150, 30);
        add(labelcountry);
        
        JLabel lb1address = new JLabel("Address");
        lb1address.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1address.setBounds(500, 110, 150, 30);
        add(lb1address);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(660, 110, 150, 30);
        add(labeladdress);
        
        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1phone.setBounds(500, 170, 150, 30);
        add(lb1phone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(660, 170, 150, 30);
        add(labelphone);
        
        JLabel lb1email = new JLabel("Email");
        lb1email.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1email.setBounds(500, 230, 150, 30);
        add(lb1email);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(660, 230, 150, 30);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
               
            }
        } catch (Exception e) {
            
            
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewCustomer("");
    }
    
}
