
package quiz;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener {
    
    Score(String name , int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score2.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,210,300,250);
        add(image);
        
        JLabel heading =new JLabel("Thankyou " + name + " for playing MindMasters");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(heading);
        
        JLabel qscore =new JLabel("Your score is " +score);
        qscore.setBounds(350,200,300,30);
        qscore.setFont(new Font("Sans serif",Font.PLAIN,27));
        add(qscore);
        
        JButton submit = new JButton("Try Again");
        submit.setBounds(380, 270, 140, 30);
        submit.setFont(new Font("Sans serif" ,Font.BOLD,15));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        new Score("User",0);
    }
}
