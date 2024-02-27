package travel.and.tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkpackages, bookpackages, viewpackages, viewhotels, bookhotel;
    JButton destinations, viewbookedhotel, payments, calculator, notepad, about, deletePersonalDetails;
    
    Dashboard(String username){
        this.username = username;
        //setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(98, 190, 18));
        p1.setBounds(0, 0, 1920, 65);
        add(p1);
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(98, 190, 18));
        p2.setBounds(0, 65, 300, 1100);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 42, 300, 50);
        updatePersonalDetails.setBackground(new Color(98, 190, 18));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 84, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 126, 300, 50);
        deletePersonalDetails.setBackground(new Color(98, 190, 18));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 35));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0, 168, 300, 50);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 100));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages = new JButton("Book Packages");
        bookpackages.setBounds(0, 210, 300, 50);
        bookpackages.setBackground(new Color(98, 190, 18));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackages.setMargin(new Insets(0, 0, 0, 110));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        viewpackages = new JButton("View Packages");
        viewpackages.setBounds(0, 252, 300, 50);
        viewpackages.setBackground(new Color(0, 0, 102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackages.setMargin(new Insets(0, 0, 0, 110));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 294, 300, 50);
        viewhotels.setBackground(new Color(98, 190, 18));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 336, 300, 50);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 378, 300, 50);
        viewbookedhotel.setBackground(new Color(98, 190, 18));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotel.setMargin(new Insets(0, 0, 0, 70));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 420, 300, 50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 125));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0, 462, 300, 50);
        payments.setBackground(new Color(98, 190, 18));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 150));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(0, 504, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 150));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 546, 300, 50);
        notepad.setBackground(new Color(98, 190, 18));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 160));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0, 588, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 180));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds( 0, 0, 1920, 1080);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(450, 70, 1600, 70);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 40));
        image.add(text);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        }else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        }else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        }else if (ae.getSource() == checkpackages) {
            new CheckPackage();
        }else if (ae.getSource() == bookpackages) {
            new BookPackage(username);
        }else if (ae.getSource() == viewpackages) {
            new ViewPackage(username);
        }else if (ae.getSource() == viewhotels) {
            new CheckHotels();
        }else if (ae.getSource() == destinations) {
            new Destinations();
        }else if (ae.getSource() == bookhotel) {
            new BookHotel(username);
        }else if (ae.getSource() == viewbookedhotel){
            new ViewBookedHotel(username);
        }else if (ae.getSource() == payments) {
            new Payment();
        }else if (ae.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == about) {
            new About();
        }else if (ae.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);
        }
        
    }
    
    public static void main(String[] args){
        new Dashboard("");
    }
    
}
