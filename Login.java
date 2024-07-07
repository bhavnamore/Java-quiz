/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JButton cond,back;
    JTextField tfname;
    
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/quiz_banner.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0, 0, 600, 445);
        add(image);
        
        JLabel heading = new JLabel("MindMasters");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Times New Roman" ,Font.BOLD ,46));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel name=new JLabel("Enter your name:");
        name.setBounds(760,130,250,30);
        name.setFont(new Font("Raleway", Font.BOLD , 20));
        name.setForeground(Color.red);
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(760,175,200,30);
        tfname.setFont(new Font("Sans serif",Font.BOLD,15));
        add(tfname);
        
        cond=new JButton("Conditions");
        cond.setBounds(750,245,120,30);
        cond.setFont(new Font("Sans serif",Font.BOLD,15));
        cond.setBackground(new Color(30, 144, 255));
        cond.addActionListener(this);
        add(cond);
        
        back=new JButton("Back");
        back.setBounds(970,245,120,30);
        back.setFont(new Font("Sans serif",Font.BOLD,15));
        back.setBackground(new Color(30, 144, 255));
        back.addActionListener(this);
        add(back);
        
        setSize(1200 ,500);
        setLocation(175,190);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==cond){
            String name=tfname.getText();
            setVisible(false);
            new Cond(name);
        } else if(ae.getSource()==back){
            setVisible(false);
        }
    }
            
    public static void main(String args[]){
        new Login();
    }
}
