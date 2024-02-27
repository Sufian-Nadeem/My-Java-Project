package travel.and.tour.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, lb1package, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    
    BookPackage(String username){
        
        this.username = username;
        setBounds(300, 170, 1050, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(400, 10,400, 70);
        text.setForeground(new Color(98,190,18));
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1username.setBounds(40, 70, 100, 25);
        add(lb1username);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 180, 25);
        add(labelusername);
        
        lb1package = new JLabel("Select Package");
        lb1package.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1package.setBounds(40, 110, 150, 25);
        add(lb1package);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 180, 25);
        add(cpackage);
        
        JLabel lb1person = new JLabel("Total Persons");
        lb1person.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1person.setBounds(40, 150, 150, 25);
        add(lb1person);
        
        tfpersons = new JTextField();
        tfpersons.setBounds(250, 150, 180, 25);
        add(tfpersons);
        
        JLabel lb1id = new JLabel("ID");
        lb1id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1id.setBounds(40, 190, 150, 25);
        add(lb1id);
        
        labelid = new JLabel();
        labelid.setBounds(250, 190, 150, 25);
        add(labelid);
        
        JLabel lb1number = new JLabel("Number");
        lb1number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1number.setBounds(40, 230, 150, 25);
        add(lb1number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);
        
        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1phone.setBounds(40, 270, 150, 25);
        add(lb1phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 150, 25);
        add(labelphone);
        
        JLabel lb1total = new JLabel("Total Price");
        lb1total.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1total.setBounds(40, 310, 150, 25);
        add(lb1total);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);
        
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(new Color(98, 190, 18));
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(new Color(98, 190, 18));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(new Color(98, 190, 18));
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 70, 500, 300);
        add(l12);
        
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            
            if (pack.equals("Gold Package")) {
                cost += 12000;
            }else if (pack.equals("Silver Package")) {
                cost += 24000;
            }else {
                cost += 36000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;    
            labelprice.setText("Rs " + cost);
            
        }else if (ae.getSource() == bookpackage){
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false); 
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == back){
            
        }
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new BookPackage("");
    }
    
}




