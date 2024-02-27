package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener {
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    
    
    AddCustomer(String username){
        setBounds(400, 150, 830, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("ADD CUSTOMER DETAILS");
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
        
        comboid = new JComboBox(new String[] {"Passport", "CNIC"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
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
        
        add = new JButton("Add");
        add.setBounds(70, 430, 90, 30);
        add.setBackground(new Color(98, 190, 18));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(220, 430, 100, 30);
        back.setBackground(new Color(98, 190, 18));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'" ); 
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()){
                gender = "Male";
                
            }else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Add Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddCustomer("");
    }
    
}
