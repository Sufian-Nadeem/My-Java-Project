package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice security;
    
    Signup(){
        setBounds(350, 200, 900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(130, 190, 230));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        
       JLabel lb1username = new JLabel("Username");
       lb1username.setFont(new Font("Tahoma", Font.BOLD, 15));
       lb1username.setBounds(50, 20, 125, 25);
       p1.add(lb1username);
       
       tfusername = new JTextField();
       tfusername.setBounds(190, 20, 180, 25);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfusername);
       
        
       JLabel lb1name = new JLabel("Name");
       lb1name.setFont(new Font("Tahoma", Font.BOLD, 15));
       lb1name.setBounds(50, 60, 125, 25);
       p1.add(lb1name);
       
       tfname = new JTextField();
       tfname.setBounds(190, 60, 180, 25);
       tfname.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfname);
       
       JLabel lb1password = new JLabel("Password");
       lb1password.setFont(new Font("Tahoma", Font.BOLD, 15));
       lb1password.setBounds(50, 100, 125, 25);
       p1.add(lb1password);
       
       tfpassword = new JTextField();
       tfpassword.setBounds(190, 100, 180, 25);
       tfpassword.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfpassword);
       
       JLabel lb1security = new JLabel("Security");
       lb1security.setFont(new Font("Tahoma", Font.BOLD, 15));
       lb1security.setBounds(50, 140, 125, 25);
       p1.add(lb1security);
       
       
       
       security = new Choice();
       security.add("Your Fav Country");
       security.add("I Proud of You");
       security.add("Your Lucky Number");
       security.add("Heart of Punjab is");
       security.setBounds(190, 140, 180, 25);
       p1.add(security);
       
       JLabel lb1answer = new JLabel("Answer");
       lb1answer.setFont(new Font("Tahoma", Font.BOLD, 15));
       lb1answer.setBounds(50, 180, 125, 25);
       p1.add(lb1answer);
       
       tfanswer = new JTextField();
       tfanswer.setBounds(190, 180, 180, 25);
       tfanswer.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfanswer);
       
       create = new JButton("Create");
       create.setBounds(120, 250, 100, 25);
       create.setBackground(Color.WHITE);
       create.setForeground(new Color(130, 190, 230));
       create.setFont(new Font("Tahoma", Font.BOLD, 15));
       create.addActionListener(this);
       p1.add(create);
       
       back = new JButton("Back");
       back.setBounds(300, 250, 100, 25);
       back.setBackground(Color.WHITE);
       back.setForeground(new Color(130, 190, 230));
       back.setFont(new Font("Tahoma", Font.BOLD, 15));
       back.addActionListener(this);
       p1.add(back);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
       Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(570, 50, 250, 250);
       add(image);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfuly");
                
                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }else if (ae.getSource() == back){
            setVisible(false);
            new Login();
            
        }
        
    }
    
     public static void main(String[] args){
        new Signup();
}
}    
  