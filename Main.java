
package quiz;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    
    
    String questions[][]=new String[10][5];     //10 ques,4 options
    String answers[][]=new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno,question;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup groupoptions;
    JButton submit,next;
    
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count =0;
    public static int score =0;
    
    String name;
    
    Main(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 822);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1440,392);
        add(image);
        
        qno =new JLabel("1).");
        qno.setBounds(80,450,50,30);
        qno.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(qno);
        
        question =new JLabel("");
        question.setBounds(120,450,1000,30);
        question.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(question);
        
        questions[0][0] = "Which of the following is not a Java feature?";
        questions[0][1] = "Object-oriented";
        questions[0][2] = "Use of pointers";
        questions[0][3] = "Portable";
        questions[0][4] = "Dynamic";

        questions[1][0] = "Which of the following is not a valid access modifier in Java?";
        questions[1][1] = "public";
        questions[1][2] = "private";
        questions[1][3] = "protected";
        questions[1][4] = "package";

        questions[2][0] = "Which method can be used to find the length of a string in Java?";
        questions[2][1] = "length()";
        questions[2][2] = "getSize()";
        questions[2][3] = "size()";
        questions[2][4] = "getLength()";

        questions[3][0] = "Which keyword is used to prevent a method from being overridden in Java?";
        questions[3][1] = "static";
        questions[3][2] = "final";
        questions[3][3] = "abstract";
        questions[3][4] = "synchronized";

        questions[4][0] = "Which exception is thrown when an array is accessed with an illegal index?";
        questions[4][1] = "NullPointerException";
        questions[4][2] = "ArrayIndexOutOfBoundsException";
        questions[4][3] = "NumberFormatException";
        questions[4][4] = "ArithmeticException";

        questions[5][0] = "Which keyword is used to inherit a class in Java?";
        questions[5][1] = "implements";
        questions[5][2] = "extends";
        questions[5][3] = "inherit";
        questions[5][4] = "this";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "What does the keyword 'super' refer to in Java?";
        questions[8][1] = "A superclass object";
        questions[8][2] = "A method in a class";
        questions[8][3] = "An instance variable";
        questions[8][4] = "A class variable";

        questions[9][0] = "Which of the following statements is true about constructor overloading?";
        questions[9][1] = "Constructors cannot be overloaded";
        questions[9][2] = "Constructors can be overloaded by changing the number of parameters";
        questions[9][3] = "Constructors can be overloaded by changing the type of parameters";
        questions[9][4] = "Both B and C";
        
        answers[0][1] = "Use of pointers";
        answers[1][1] = "package";
        answers[2][1] = "length()";
        answers[3][1] = "final";
        answers[4][1] = "ArrayIndexOutOfBoundsException";
        answers[5][1] = "extends";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "A superclass object";
        answers[9][1] = "Both B and C";
        
        op1 = new JRadioButton("");
        op1.setBounds(170,520,500,30);
        op1.setBackground(Color.white);
        op1.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(op1);
        
        op2 = new JRadioButton("");
        op2.setBounds(170,560,500,30);
        op2.setBackground(Color.white);
        op2.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(op2);
        
        op3 = new JRadioButton("");
        op3.setBounds(170,600,500,30);
        op3.setBackground(Color.white);
        op3.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(op3);
        
        op4 = new JRadioButton("");
        op4.setBounds(170,640,500,30);
        op4.setBackground(Color.white);
        op4.setFont(new Font("Sans serif",Font.PLAIN,20));
        add(op4);
        
        
        groupoptions = new ButtonGroup();
        groupoptions.add(op1);
        groupoptions.add(op2);
        groupoptions.add(op3);
        groupoptions.add(op4);
        
        next=new JButton("Next");
        next.setBounds(1100,640,120,40);
        next.setFont(new Font("Sans serif" ,Font.PLAIN,22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(800, 640, 160, 40);
        submit.setFont(new Font("Sans serif", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == next) {
            repaint();
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                 useranswers[count][0] = "";
           } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
           }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
                
                
            count++;
            start(count);
        } else if(ae.getSource() == submit) {
            ans_given =1;
            if (groupoptions.getSelection() == null) {
                      useranswers[count][0] = "";
                } else {
                         useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
                }
               
                for(int i=0; i < useranswers.length;i++) {
                    if (useranswers[i] [0].equals(answers[i][1])) {
                        score +=10;
                    } else {
                        score +=0;
                    }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        String time = "Time left - " + timer +  "seconds"; //30s
        g.setColor(Color.red);
        g.setFont(new Font("San serif",Font.BOLD,25));
        
        if(timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        }  catch(Exception e) {
            e.printStackTrace();
        }
        
        if(ans_given == 1) {
            ans_given = 0;
            timer = 20;
        }else if (timer < 0) {
           timer = 20;
           
           if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
           if(count == 9) {
               if (groupoptions.getSelection() == null) {
                      useranswers[count][0] = "";
                } else {
                         useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
                }
               
                for(int i=0; i < useranswers.length;i++) {
                    if (useranswers[i] [0].equals(answers[i][1])) {
                        score +=10;
                    } else {
                        score +=0;
                    }
                }
                setVisible(false);
                new Score(name ,score);
                        
           }else {
               
                if (groupoptions.getSelection() == null) {
                      useranswers[count][0] = "";
                } else {
                         useranswers[count][0] = groupoptions.getSelection().getActionCommand(); 
                }
                count++;
                start(count);
           }
        }
    }
    public void start(int count)
    {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);
        
        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);
        
        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);
        
        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    public static void main(String args[]) {
          new Main("User");
    }
}
