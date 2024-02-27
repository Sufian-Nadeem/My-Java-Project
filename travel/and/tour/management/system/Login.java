package travel.and.tour.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel image;
    JButton login, signup, password;
    JTextField tfusername, tfpassword;
    
    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i5 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        image = new JLabel(i6);
        image.setBounds(90, 60, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(130, 190, 230));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 400);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        p2.setBackground(new Color(0, 0, 0, 0));
        add(p2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i8 = i7.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        image = new JLabel(i9);
        image.setBounds(0, 00, 900, 400);
        add(image);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(60, 20, 100, 25);
        lb1username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        lb1username.setForeground(Color.WHITE);
        p2.add(lb1username);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(60, 100, 600, 35);
        lbpassword.setFont(new Font("SAN_ SERIF", Font.PLAIN, 20));
        lbpassword.setForeground(Color.WHITE);
        p2.add(lbpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(Color.BLACK));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(Color.BLACK));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(140, 250, 130, 30);
        password.setBackground(Color.BLACK);
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(Color.BLACK));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in Login.....");
        text.setBounds(300, 255, 150, 20);
        text.setForeground(Color.WHITE);
        p2.add(text);
        
        
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login){
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                
                
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
               
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    
                    setVisible(false);
                    new Loading(username);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password ");
                }
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
           
        
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}


