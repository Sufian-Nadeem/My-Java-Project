package travel.and.tour.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Loading extends JFrame implements Runnable{
    
    JLabel image;
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run() {
        try{
            for (int i = 1; i <=101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                
                if (value < max){ //101 < 100
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(80);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
}
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
     setBounds(450, 200, 650, 400);
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
       
     
     JLabel text = new JLabel("Travel and Tourism Application");
     text.setBounds(50, 20, 600, 40);
     text.setForeground(Color.BLACK);
     text.setFont(new Font("Raleway", Font.BOLD, 35));
     add(text);
     
     bar = new JProgressBar();
     bar.setBounds(150, 100, 300, 35);
     bar.setBackground(Color.WHITE);
     bar.setForeground(Color.BLUE);
     bar.setBorder(new LineBorder(Color.BLUE));
     bar.setStringPainted(true);
     add(bar);
     
     JLabel loding = new JLabel("Loading, Please wait...");
     loding.setBounds(150, 130, 170, 30);
     loding.setForeground(Color.BLACK);
     loding.setFont(new Font("Raleway", Font.BOLD, 14));
     add(loding);
     
     JLabel lb1username = new JLabel("Welcome " + username);
     lb1username.setBounds(20, 270, 400, 40);
     lb1username.setForeground(Color.BLACK);
     lb1username.setFont(new Font("Raleway", Font.BOLD, 20));
     add(lb1username);
     
     ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Loading.jpg"));
        Image i5 = i4.getImage().getScaledInstance(650, 370, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        image = new JLabel(i6);
        image.setBounds(0, 0, 650, 370);
        add(image);
     
     t.start();
     
     setVisible(true);
}
    
    public static void main(String[] args){
        new Loading("");
    }
    
}
