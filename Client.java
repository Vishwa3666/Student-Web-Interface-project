import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
class Client implements ActionListener
{    
Socket g1=null;
ObjectOutputStream oout=null;
ObjectInputStream inn=null;
Main h=null;
Main receive=null;
File file1=new File("C:\\Users\\VISHWA\\Desktop\\vishwajava\\12415.txt");
File file2=new File("C:\\Users\\VISHWA\\Desktop\\vishwajava\\12400.txt");
File file3=new File("C:\\Users\\VISHWA\\Desktop\\vishwajava\\12401.txt");
JButton b1,b2,b3,b4,b5;
JFrame f1,f2,f3,f4,f5;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
JPasswordField pf1,pf2;
JPanel p1,p2;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;

Client()
{
    f1=new JFrame("PORTAL");
    f4=new JFrame("STAFF INTERFACE");
    f5=new JFrame("STUDENT INTERFACE");
    b1=new JButton("STUDENT LOGIN");
    b2=new JButton("STAFF LOGIN");
    pf1=new JPasswordField();
    pf2=new JPasswordField();
    b5=new JButton("Submit");
    tf1=new JTextField(20);
    tf2=new JTextField(20);
    tf3=new JTextField(20);
    tf4=new JTextField(20);
    tf5=new JTextField(20);
    tf6=new JTextField(20);
    tf7=new JTextField(20);
    tf8=new JTextField(20);
    l1=new JLabel("Name :");
    l2=new JLabel("Register Number :");
    l3=new JLabel("Attendance :");
    l4=new JLabel("Cgpa :");
    l5=new JLabel("Internal Marks :");
    l6=new JLabel("Staff Password :");
    l7=new JLabel("Register Number :");
    l8=new JLabel("Register Number :");
    l9=new JLabel("Password :");
    l10=new JLabel("");
    l11=new JLabel("");
    l12=new JLabel("");
    l13=new JLabel("");
    l14=new JLabel("");
    l15=new JLabel("");
    l16=new JLabel("");
    f1.getContentPane().setBackground(Color.WHITE);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b1.setBounds(675,400,140,30);
    b2.setBounds(675,300,140,30);
    b1.setBackground(Color.LIGHT_GRAY);
    b2.setBackground(Color.LIGHT_GRAY);
    f1.add(b1);
    f1.add(b2);
    f1.setLayout(null);
    f1.setVisible(true);
    f1.setSize(1000,1000);
    f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    
}
public void actionPerformed(ActionEvent ae)
{   
  
    if(ae.getSource()==b2)
    {
        f3=new JFrame("STAFF LOGIN");
        b4=new JButton("SUBMIT");
        b4.setBackground(Color.WHITE);
        b4.setBounds(640,300,140,30);
        l7.setFont(new Font("Arial", Font.PLAIN, 16));
        l7.setBounds(550,100,250,20);
        f3.add(l7);
        tf6.setBounds(700,100,150,20);
        f3.add(tf6);
        l6.setFont(new Font("Arial", Font.PLAIN, 16));   
        l6.setBounds(550,175,250,20);
        f3.add(l6);
        f3.add(pf1);
        pf1.setBounds(700,175,150,20);
        f3.add(b4);
        f3.getContentPane().setBackground(Color.CYAN);
        f3.setLayout(null);
        f3.setSize(1000,1000);
        f3.setVisible(true);
        f3.setDefaultCloseOperation(f3.EXIT_ON_CLOSE);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
              String regno=tf6.getText();
              String password=new String(pf1.getPassword());
              if(password.equals("bablu") && regno.equals("12415") || regno.equals("12400") || regno.equals("12401"))
              {
                f4.add(tf1);
                f4.add(tf2);
                f4.add(tf3);
                f4.add(tf4);
                f4.add(tf5);
                tf1.setBounds(800,150,100,30);
                tf2.setBounds(800,220,100,30);
                tf3.setBounds(800,290,100,30);
                tf4.setBounds(800,360,100,30);
                tf5.setBounds(800,430,100,30);
                f4.add(l1);
                f4.add(l2);
                f4.add(l3);
                f4.add(l4);
                f4.add(l5);
               
                l1.setBounds(650,150,150,30);
                l1.setFont(new Font("Arial", Font.PLAIN, 16));
                l2.setBounds(650,220,180,30);
                l2.setFont(new Font("Arial", Font.PLAIN, 16));
                l3.setBounds(650,290,180,30);
                l3.setFont(new Font("Arial", Font.PLAIN, 16));
                l4.setBounds(650,360,150,30);
                l4.setFont(new Font("Arial", Font.PLAIN, 16));
                l5.setBounds(650,430,150,30);
                l5.setFont(new Font("Arial", Font.PLAIN, 16));
              
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                b5=new JButton("SUBMIT");
                f4.add(b5);
                b5.setBackground(Color.WHITE);
                b5.setBounds(715,520,140,30); 
                b5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                try{
                String s1,s2,s3,s4,s5;
                s1=tf1.getText();
                s2=tf2.getText();
                s3=tf3.getText();
                s4=tf4.getText();
                s5=tf5.getText();
                g1=new Socket("localhost",2002);
                oout=new ObjectOutputStream(g1.getOutputStream());
                inn=new ObjectInputStream(g1.getInputStream());
                h=new Main(s1,s2,s3,s4,s5);
                oout.writeObject(h);
                receive=(Main)inn.readObject();
                oout.close();
                g1.close();
                }
                catch(Exception e)
                {
                  System.out.println(e);
                }   
 
               }
               });
           
               
        } 
         else{
              
               l10.setText("INVALID REGISTER NUMBER OR PASSWORD");
               f4.add(l10);
               l10.setBounds(650,350,300,50);
              
          
           }
              f4.getContentPane().setBackground(Color.CYAN);
              f4.setLayout(null);
              f4.setSize(1000,1000);
              f4.setDefaultCloseOperation(f4.EXIT_ON_CLOSE);  
              f4.setVisible(true);  
           
           
        }
        });



            
   }
        
              
if(ae.getSource()==b1)
      {
        f2=new JFrame("STUDENT LOGIN");
        b3=new JButton("SUBMIT");
        b3.setBounds(640,300,140,30);
        b3.setBackground(Color.WHITE);
        f2.add(b3);
        l8.setBounds(550,100,250,20);
        l8.setFont(new Font("Arial", Font.PLAIN, 16));
        f2.add(l8);
        tf7.setBounds(700,100,150,20);
        f2.add(tf7);
        l9.setBounds(550,175,250,20);
        l9.setFont(new Font("Arial", Font.PLAIN, 16));
        f2.add(l9);
        pf2.setBounds(700,175,150,20);
        f2.add(pf2);
        f2.getContentPane().setBackground(Color.LIGHT_GRAY);
        f2.setLayout(null);
        f2.setSize(1000,1000);
        f2.setVisible(true);
        f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);       
                  
                b3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent h){
 
                   if(h.getSource()==b3)
 
                    {
                     String stpassword=new String(pf2.getPassword());
                     String regno2=tf7.getText();
                     if (file1.exists() && stpassword.equals("vishwa") && regno2.equals("12415") && g1==null)
                     { 
                      
                       try{
                       
                       Scanner scanner=new Scanner(file1);
                       while(scanner.hasNextLine())
                       {
                  	 l11.setText(scanner.nextLine());
                   	 l12.setText(scanner.nextLine());
                  	 l13.setText(scanner.nextLine());
                  	 l14.setText(scanner.nextLine());
                   	 l15.setText(scanner.nextLine());
                   	 f5.add(l11);
                   	 f5.add(l12);
                   	 f5.add(l13);
                   	 f5.add(l14);
                   	 f5.add(l15);
                   	 l11.setBounds(675,70,900,300);
                       l12.setBounds(675,140,900,300);
                       l13.setBounds(675,210,900,300);
                       l14.setBounds(675,280,900,300);
                       l15.setBounds(675,350,900,300);
                       f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                   	 f5.setLayout(null);
                   	 f5.setSize(1000,1000);
                   	 f5.setVisible(true);
                       f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                        
                       }
                       }
                     catch(Exception e)
                     {
                      System.out.println(e);
                     }
                      
                    }
                    else if (file2.exists() && stpassword.equals("venkat") && regno2.equals("12400") && g1==null)
                     {
                      try{
                       Scanner scanner=new Scanner(file2);
                       while(scanner.hasNextLine())
                       {
                       l11.setText(scanner.nextLine());
                   	 l12.setText(scanner.nextLine());
                  	 l13.setText(scanner.nextLine());
                  	 l14.setText(scanner.nextLine());
                   	 l15.setText(scanner.nextLine());
                   	 f5.add(l11);
                   	 f5.add(l12);
                   	 f5.add(l13);
                   	 f5.add(l14);
                   	 f5.add(l15);
                       l11.setBounds(675,70,900,300);
                       l12.setBounds(675,140,900,300);
                       l13.setBounds(675,210,900,300);
                       l14.setBounds(675,280,900,300);
                       l15.setBounds(675,350,900,300);
                       f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                   	 f5.setLayout(null);
                   	 f5.setSize(1000,1000);
                   	 f5.setVisible(true);
                       f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                        
                       }
                       }
                     catch(Exception e)
                     {
                      System.out.println(e);
                     }
                      
                    }
                    else if (file3.exists() && stpassword.equals("sathya") && regno2.equals("12401") && g1==null)
                     {
                       try{
                       Scanner scanner=new Scanner(file3);
                       while(scanner.hasNextLine())
                       {
                       l11.setText(scanner.nextLine());
                   	 l12.setText(scanner.nextLine());
                  	 l13.setText(scanner.nextLine());
                  	 l14.setText(scanner.nextLine());
                   	 l15.setText(scanner.nextLine());
                   	 f5.add(l11);
                   	 f5.add(l12);
                   	 f5.add(l13);
                   	 f5.add(l14);
                   	 f5.add(l15);
                   	 l11.setBounds(675,70,900,300);
                       l12.setBounds(675,140,900,300);
                       l13.setBounds(675,210,900,300);
                       l14.setBounds(675,280,900,300);
                       l15.setBounds(675,350,900,300);
                       f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                   	 f5.setLayout(null);
                   	 f5.setSize(1000,1000);
                   	 f5.setVisible(true);
                       f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                       }
                       }
                     catch(Exception e)
                     {
                      System.out.println(e);
                     }
                      
                    }
                   else if (!((regno2.equals("12415") || regno2.equals("12400") || regno2.equals("12401"))) && g1==null)
                    {
                      l16.setText("DETAILS NOT UPDATED");
                      f5.add(l16);
                      l16.setBounds(650,350,300,50);
                      f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                   	f5.setLayout(null);
                   	f5.setSize(1000,1000);
                   	f5.setVisible(true);
                      f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                     }
                       
                    else
                     {   
                   
                     if(!(g1==null))
                     {                    
                     String str=receive.ss2;
                     switch(str){
                     case "12415":
                       if(stpassword.equals("vishwa") && regno2.equals("12415"))
                       {
                        l11.setText("NAME : "+receive.ss1); 
                        l12.setText("REGISTER NUMBER : "+receive.ss2);
                        l13.setText("ATTENDANCE : "+receive.ss3);
                        l14.setText("CGPA : "+receive.ss4);
                        l15.setText("INTERNAL MARKS : "+receive.ss5); 
                        try {
      				FileWriter myWriter = new FileWriter("12415.txt");
      				myWriter.write("NAME : "+ receive.ss1);
                           myWriter.write("\nREGISTER NUMBER : "+receive.ss2);
                           myWriter.write("\nATTENDANCE : "+receive.ss3);
                           myWriter.write("\nCGPA : "+receive.ss4);
                           myWriter.write("\nINTERNAL MARKS : "+receive.ss5);
      				myWriter.close();
    					} 
                           catch (IOException e)
                           {
      				System.out.println(e);
      			     }
                        
                       }
                       else
                       {
                        l16.setText("INVALID REGISTER NUMBER OR PASSWORD");
                        f5.add(l16);
                        l16.setBounds(650,350,300,50);
                       }
                       break;
                     case "12400":
                       if(stpassword.equals("venkat") && regno2.equals("12400"))
                       {
                        l11.setText("NAME : "+receive.ss1); 
                        l12.setText("REGISTER NUMBER : "+receive.ss2);
                        l13.setText("ATTENDANCE : "+receive.ss3);
                        l14.setText("CGPA : "+receive.ss4);
                        l15.setText("INTERNAL MARKS : "+receive.ss5); 
                        try {
      				FileWriter myWriter = new FileWriter("12400.txt");
      				myWriter.write("NAME : "+ receive.ss1);
                           myWriter.write("\nREGISTER NUMBER : "+receive.ss2);
                           myWriter.write("\nATTENDANCE : "+receive.ss3);
                           myWriter.write("\nCGPA : "+receive.ss4);
                           myWriter.write("\nINTERNAL MARKS : "+receive.ss5);
      				myWriter.close();
    					} 
                           catch (IOException e)
                           {
      				System.out.println(e);
      				}
                        
                       }
                       else
                       {
                       l16.setText("INVALID REGISTER NUMBER OR PASSWORD");
                       f5.add(l16);
                       l16.setBounds(650,350,300,50);
                       }
                       break;
                     case "12401":
                       if(stpassword.equals("sathya") && regno2.equals("12401"))
                       {
                        l11.setText("NAME : "+receive.ss1); 
                        l12.setText("REGISTER NUMBER : "+receive.ss2);
                        l13.setText("ATTENDANCE : "+receive.ss3);
                        l14.setText("CGPA : "+receive.ss4);
                        l15.setText("INTERNAL MARKS : "+receive.ss5); 
                        try {
      				FileWriter myWriter = new FileWriter("12401.txt");
      				myWriter.write("NAME : "+ receive.ss1);
                           myWriter.write("\nREGISTER NUMBER : "+receive.ss2);
                           myWriter.write("\nATTENDANCE : "+receive.ss3);
                           myWriter.write("\nCGPA : "+receive.ss4);
                           myWriter.write("\nINTERNAL MARKS : "+receive.ss5);
      				myWriter.close();
    					} 
                           catch (IOException e) 
                           {
      				System.out.println(e);
      			     }
              
                       }
                       else
                       {
                        l16.setText("INVALID REGISTER NUMBER OR PASSWORD");
                        f5.add(l16);
                        l16.setBounds(650,350,300,50); 
                       }
                       break;
                  
                     default:
               
                       l16.setText("DETAILS NOT UPDATED");
                       f5.add(l16);
                       l16.setBounds(650,350,300,50);
                
              
                    }
                   l11.setBounds(675,70,900,300);
                   l12.setBounds(675,140,900,300);
                   l13.setBounds(675,210,900,300);
                   l14.setBounds(675,280,900,300);
                   l15.setBounds(675,350,900,300);
                   f5.add(l11);
                   f5.add(l12);
                   f5.add(l13);
                   f5.add(l14);
                   f5.add(l15);
                   f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                   f5.setLayout(null);
                   f5.setSize(1000,1000);
                   f5.setVisible(true);
                   f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                   
              
                       
                   }
                    else{

                        l16.setText("INVALID REGISTER NUMBER OR PASSWORD");
                        f5.add(l16);
                        l16.setBounds(650,350,300,50); 
                        f5.getContentPane().setBackground(Color.LIGHT_GRAY);
                        f5.setLayout(null);
                        f5.setSize(1000,1000);
                        f5.setVisible(true);
                        f5.setDefaultCloseOperation(f5.EXIT_ON_CLOSE);
                   
                    }

                    }

                    }
                   

                    }
			   
                   
                    });
                    
                
          }
				 
          } 
				 
public static void main(String[] args){

    Client c = new Client();
}

}


              