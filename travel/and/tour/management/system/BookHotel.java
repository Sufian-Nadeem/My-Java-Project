package travel.and.tour.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, lb1package, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    
    BookHotel(String username){
        
        this.username = username;
        setBounds(300, 120, 1050, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(200, 10, 200, 50);
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
        
        lb1package = new JLabel("Select Hotel");
        lb1package.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1package.setBounds(40, 110, 150, 25);
        add(lb1package);
        
        chotel = new Choice();
        chotel.setBounds(250, 110, 180, 25);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                chotel.add(rs.getString("name"));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lb1person = new JLabel("Total Persons");
        lb1person.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1person.setBounds(40, 150, 150, 25);
        add(lb1person);
        
        tfpersons = new JTextField();
        tfpersons.setBounds(250, 150, 180, 25);
        add(tfpersons);
        
        JLabel lb1days = new JLabel("No. of Days");
        lb1days.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1days.setBounds(40, 190, 150, 25);
        add(lb1days);
        
        tfdays = new JTextField();
        tfdays.setBounds(250, 190, 180, 25);
        add(tfdays);
        
        JLabel lb1ac = new JLabel("AC/ Non-AC");
        lb1ac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1ac.setBounds(40, 230, 150, 25);
        add(lb1ac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 180, 25);
        add(cac);
        
        
        JLabel lb1food = new JLabel("Food Included");
        lb1food.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1food.setBounds(40, 270, 150, 25);
        add(lb1food);
        
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 270, 180, 25);
        add(cfood);
        
        JLabel lb1id = new JLabel("ID");
        lb1id.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1id.setBounds(40, 310, 150, 25);
        add(lb1id);
        
        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);
        
        JLabel lb1number = new JLabel("Number");
        lb1number.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1number.setBounds(40, 350, 150, 25);
        add(lb1number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);
        
        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1phone.setBounds(40, 390, 150, 25);
        add(lb1phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 150, 25);
        add(labelphone);
        
        JLabel lb1total = new JLabel("Total Price");
        lb1total.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lb1total.setBounds(40, 430, 150, 25);
        add(lb1total);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(new Color(98, 190, 18));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(new Color(98, 190, 18));
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 70, 500, 400);
        add(l12);
        
        
        setVisible(true);
        
        
    }

    BookHotel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try{
            
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name'"+chotel.getSelectedItem()+"'");
                while(rs.next()) {
                    
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("YES") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText(" Rs " +total);
                                             
                    }else {
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                    }
                    
                    
                }                          
        }catch (Exception e) {
                e.printStackTrace();
                }
        }else if (ae.getSource() == bookpackage){
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false); 
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == back){
            
        }
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new BookHotel("");
    }
    
}

