
package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cond extends JFrame implements ActionListener{
    
    String name;
    JButton back,start;
    
    Cond(String name) {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Hello "+name+" , welcome to MindMasters");
        heading.setBounds(50, 20, 700,35);
        heading.setFont(new Font("Times New Roman" ,Font.BOLD ,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel cond = new JLabel();
        cond.setBounds(50, 20, 700,450);
        cond.setFont(new Font("Tahoma" ,Font.PLAIN ,15));
        cond.setText(
        "<html>"+
               "1.)The quiz consists of 10 questions." + "<br><br>" +
               "2.)Each question has four multiple-choice answers, and you must select the correct one." + "<br><br>" +
               "3.)Each correct answer is worth 10 point." + "<br><br>" +
               "4.)There are no negative points for incorrect answers." + "<br><br>" +
               "5.)Make sure to review your answers before submitting." + "<br><br>" +
               "6.)Your score will be displayed after you submit the quiz." + "<br><br>" +
        "<html>"
        );
        add(cond);

        back=new JButton("Back");
        back.setBounds(50,450,140,30);
        back.setFont(new Font("Sans serif",Font.BOLD,15));
        back.setBackground(new Color(30, 144, 255));
        back.addActionListener(this);
        add(back);
        
        start=new JButton("Start");
        start.setBounds(350,450,140,30);
        start.setFont(new Font("Sans serif",Font.BOLD,15));
        start.setBackground(new Color(30, 144, 255));
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if  (ae.getSource()== start) {
            setVisible(false);
            new Main(name);
        } else {
             setVisible(false);  
             new Login();
        }
    }
    public static void main(String args[]){
        new Cond("User");
    }
}
