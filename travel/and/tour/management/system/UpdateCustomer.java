package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid, tfgender;
    JRadioButton rmale, rfemale;
    JButton add, back;
    
    
    UpdateCustomer(String username){
        setBounds(400, 150, 830, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(250, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setForeground(Color.RED);
        add(text);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(30, 50, 150, 25);
        add(lb1username);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lb1id = new JLabel("ID");
        lb1id.setBounds(30, 90, 150, 25);
        add(lb1id);
        
        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);
        
        JLabel lb1number = new JLabel("Number");
        lb1number.setBounds(30, 130, 150, 25);
        add(lb1number);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);
        
        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(30, 170, 150, 25);
        add(lb1name);
        
        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);
        
        JLabel lb1gender = new JLabel("Gender");
        lb1gender.setBounds(30, 210, 150, 25);
        add(lb1gender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lb1country = new JLabel("Country");
        lb1country.setBounds(30, 250, 150, 25);
        add(lb1country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);
        
        JLabel lb1address = new JLabel("Address");
        lb1address.setBounds(30, 290, 150, 25);
        add(lb1address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);
        
        JLabel lb1phone = new JLabel("Phone");
        lb1phone.setBounds(30, 330, 150, 25);
        add(lb1phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JLabel lb1email = new JLabel("Email");
        lb1email.setBounds(30, 370, 150, 25);
        add(lb1email);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);
        
        add = new JButton("Update");
        add.setBounds(70, 430, 90, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(220, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 300, 300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'" ); 
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number =  '"+number+"', name =  '"+name+"', gender =  '"+gender+"', country =  '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("");
    }
    
}
