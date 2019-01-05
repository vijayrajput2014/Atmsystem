import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
public class Atm5 extends JFrame
{
	   String v100,U;
       int r100,n;

	   JComboBox day,month,year,religion,categary,income,ed,occupation;

	   JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16;

	   JTextField  t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;

	   JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,
	   b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34;

	   JLabel  lb0, lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,
	   lb17,lb18,lb19,lb20,lb21,lb22,lb23,lb24,lb25,lb26,lb27,lb28,lb29,lb30,lb31,lb32,lb33,
	   lb34,lb35,lb36,lb37,lb38,lb39,lb40,lb41,lb42,lb43,lb44;

       JPasswordField p1,p2,p3,p4,p5;

       JFrame frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10,
       frame11,frame12,frame13,frame14,frame15,frame16,frame17,frame18;


      Atm5()
         {
		   frame0=new JFrame();
           frame0.setTitle("AUTOMATED TELLER MACHINE");
   		   frame0.setSize(1500,750);
   		   frame0.setLayout(null);
   		   frame0.setLocation(0,0);
   		   frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


           Font f0=new Font("dialog",Font.BOLD,35);
           lb=new JLabel("WELCOME TO ATM");
           lb.setBounds(80,30,500,30);
           lb.setForeground(Color.RED);
           lb.setFont(f0);
           frame0.add(lb);

           ImageIcon icon=new ImageIcon("atm.png");
           lb0=new JLabel(icon);
           lb0.setBounds(0,350,500,350);
           frame0.add(lb0);

           ImageIcon icon1=new ImageIcon("2.jpg");
		   lb44=new JLabel(icon1);
		   lb44.setBounds(500,0,icon1.getIconWidth(),icon1.getIconHeight());
		   frame0.add(lb44);



   		   Font f1=new Font("dialog",Font.BOLD,25);
   		   lb1=new JLabel("Card No:    ");
   		   lb1.setBounds(45,100,500,25);
   		   lb1.setFont(f1);
   		   frame0.add(lb1);

   		   Font f2=new Font("dialog",Font.BOLD,20);
   		   t1=new JTextField();
   		   t1.setBounds(245,100,200,25);
   		   t1.setFont(f2);
   		   t1.setForeground(Color.RED);
   		   frame0.add(t1);


   		   Font f3=new Font("dialog",Font.BOLD,25);
   		   lb2=new JLabel("Pin NO:    ");
   		   lb2.setFont(f3);
   		   lb2.setBounds(45,150,500,25);
   		   frame0.add(lb2);

   		   Font f4=new Font("dialog",Font.BOLD,20);
   		   p1=new JPasswordField();
   		   p1.setBounds(245,150,200,25);
   		   p1.setForeground(Color.RED);
   		   p1.setFont(f4);
   		   frame0.add(p1);

           b1=new JButton("SIGN IN");
           b0=new JButton("SIGN UP");
   		   b2=new JButton("CLEAR");
   		   b0.setBounds(180,220,100,30);
   		   b1.setBounds(70,220,100,30);
   		   b2.setBounds(300,220,100,30);
   	   	   b3=new JButton("NEW ACCOUNT");
   		   b3.setBounds(100,270,300,30);
	       frame0.add(b1);
	       frame0.add(b0);
   	       frame0.add(b2);
   	       frame0.add(b3);
   	       b1.addActionListener(new Button4Inner());
         //  b3.addActionListener(new Button1Inner());
          b2.addActionListener(new Button9Inner());
           b0.addActionListener(new Button18Inner());
   	       frame0.setVisible(true);

     }
 public static void main(String[]args)
 throws SQLException,ClassNotFoundException
   {
	 new Atm5();
    }

class Button4Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		  // frame0.dispose();
		    try
              {
				int flag=1;
	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
	     		Connection con=DriverManager.getConnection
	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2
	    	     Statement stm=con.createStatement();//step3
	    	     ResultSet rs=stm.executeQuery("select * from CardLogin");
	    	     while(rs.next())
	    	     {
				  if(rs.getString(1).equals(t1.getText()) && rs.getString(2).equals(p1.getText()))

				 	  {
					  flag=0;
					  break;
				      }
			      }

			 if(flag==0)
			  {
			  JOptionPane.showMessageDialog(null,"login sucess");
               JFrame frame4=new JFrame(" TRANSACTION");
   		       frame4.setSize(600,500);
   		       frame4.setLocation(0,50);
   		        frame4.setLayout(null);
   		      frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,35);
           lb28=new JLabel("Please Select Your Transaction");
           lb28.setBounds(30,30,600,30);
           lb28.setForeground(Color.RED);
           lb28.setFont(f0);
           frame4.add(lb28);
           frame4.setVisible(true);

           Font f3=new Font("dialog",Font.BOLD,25);
           lb43=new JLabel();
           lb43.setBounds(200,70,200,30);
           lb43.setForeground(Color.RED);
           lb43.setFont(f3);
           lb43.setText(rs.getString(3));
           frame4.add(lb43);

           Font f1=new Font("dialog",Font.BOLD,15);
           b8=new JButton("DEPOSIT");
   		   b8.setBounds(20,120,200,30);
   		   b8.setFont(f1);
	       frame4.add(b8);

           b9=new JButton("CASH WITHDRAWAL");
   		   b9.setBounds(350,120,200,30);
   		   b9.setFont(f1);
	       frame4.add(b9);

           b10=new JButton("FAST CASH");
   		   b10.setBounds(20,220,200,30);
   		   b10.setFont(f1);
	       frame4.add(b10);

           b11=new JButton("MINI STATEMENT");
   		   b11.setBounds(350,220,200,30);
   		   b11.setFont(f1);
	       frame4.add(b11);

           b12=new JButton("PIN CHANGE");
   		   b12.setBounds(20,320,200,30);
   		   b12.setFont(f1);
	       frame4.add(b12);

           b13=new JButton("BALANCE ENQUIRY");
   		   b13.setBounds(350,320,200,30);
   		   b13.setFont(f1);
	       frame4.add(b13);

           Font f2=new Font("dialog",Font.BOLD,20);
           b14=new JButton("EXIT");
   		   b14.setBounds(200,370,200,35);
   		   b14.setFont(f2);
	       frame4.add(b14);
	      b8.addActionListener(new Button5Inner());
	      b9.addActionListener(new Button6Inner());
	       b10.addActionListener(new Button7Inner());
           b12.addActionListener(new Button8Inner());
           b13.addActionListener(new Button12Inner());
           b14.addActionListener(new Button10Inner());
          b11.addActionListener(new Button14Inner());
	      }
            else
			  {
				  JOptionPane.showMessageDialog(null,"invalid username password");

               }
    }
		   catch(Exception e)
		    {

           }

	  }

  }
 class Button5Inner implements ActionListener
     {
  	  public void actionPerformed(ActionEvent ae)
  	   {
		      // frame4.dispose();
               JFrame frame5=new JFrame(" DEPOSIT");
     		   frame5.setSize(500,350);
     		   frame5.setLocation(0,50);
     		   frame5.setLayout(null);
     		   frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             Font f0=new Font("dialog",Font.BOLD,35);
              lb29=new JLabel("ENTER AMOUNT YOU ");
              lb30=new JLabel("WANT TO DEPOSIT ");
             lb29.setBounds(50,30,600,30);
             lb29.setForeground(Color.RED);
             lb29.setFont(f0);
             lb30.setBounds(70,80,600,30);
			 lb30.setForeground(Color.RED);
             lb30.setFont(f0);
             frame5.add(lb30);
             frame5.add(lb29);

            Font f1=new Font("dialog",Font.BOLD,25);
   		    t10=new JTextField();
   		    t10.setBounds(130,130,200,30);
   		    t10.setFont(f1);
   		    t10.setForeground(Color.RED);
   		    frame5.add(t10);

            b15=new JButton("DEPOSIT");
   		   b15.setBounds(110,180,100,30);
   		  // b15.setFont(f1);
	       frame5.add(b15);

           b16=new JButton("BACK");
   		   b16.setBounds(270,180,100,30);
	       frame5.add(b16);

           b17=new JButton("EXIT");
   		   b17.setBounds(195,230,100,30);
	       frame5.add(b17);
           frame5.setVisible(true);
         b17.addActionListener(new Button10Inner());
          b15.addActionListener(new Button11Inner());
         b16.addActionListener(new Button13Inner());
		 }
	 }

class Button6Inner implements ActionListener
     {
  	  public void actionPerformed(ActionEvent ae)
  	   {
		       //frame4.dispose();
               JFrame frame6=new JFrame(" WITHDRAWAL");
     		   frame6.setSize(550,400);
     		   frame6.setLocation(0,50);
     		   frame6.setLayout(null);
     		   frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             Font f0=new Font("dialog",Font.BOLD,35);
             lb31=new JLabel("Maximum Daily Withdrawal ");
             lb32=new JLabel("is RS.10,000 ");
             lb31.setBounds(50,30,600,30);
             lb31.setForeground(Color.RED);
             lb31.setFont(f0);
             lb32.setBounds(170,70,600,30);
			 lb32.setForeground(Color.RED);
             lb32.setFont(f0);
             lb33=new JLabel("Please Enter Your Amount ");
             lb33.setBounds(50,110,600,30);
             lb33.setForeground(Color.RED);
             lb33.setFont(f0);
             frame6.add(lb31);
             frame6.add(lb32);
             frame6.add(lb33);

            Font f1=new Font("dialog",Font.BOLD,35);
   		    t11=new JTextField();
   		    t11.setBounds(150,170,200,30);
   		    t11.setFont(f1);
   		    t11.setForeground(Color.RED);
   		    frame6.add(t11);

            b18=new JButton("WITHDRAW");
   		   b18.setBounds(110,230,100,30);
   		  // b15.setFont(f1);
	       frame6.add(b18);

            b19=new JButton("BACK");
   		   b19.setBounds(270,230,100,30);
	       frame6.add(b19);

           b20=new JButton("EXIT");
   		   b20.setBounds(195,280,100,30);
	       frame6.add(b20);
            frame6.setVisible(true);
          b19.addActionListener(new Button13Inner());
          b18.addActionListener(new Button15Inner());
          b20.addActionListener(new Button10Inner());
		 }
	 }

class Button7Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		 //  frame9.dispose();
           JFrame frame7=new JFrame("FAST CASH");
   		   frame7.setSize(600,500);
   		   frame7.setLocation(0,50);
   		   frame7.setLayout(null);
   		   frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,35);
           lb34=new JLabel("Select Withdrawal Amount");
           lb34.setBounds(70,30,600,30);
           lb34.setForeground(Color.RED);
           lb34.setFont(f0);
           frame7.add(lb34);
           frame7.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,15);
           b21=new JButton("RS.100");
   		   b21.setBounds(20,120,200,30);
   		   b21.setFont(f1);
	       frame7.add(b21);

           b22=new JButton("RS.1500");
   		   b22.setBounds(350,120,200,30);
   		   b22.setFont(f1);
	       frame7.add(b22);

           b23=new JButton("RS.500");
   		   b23.setBounds(20,220,200,30);
   		   b23.setFont(f1);
	       frame7.add(b23);

           b24=new JButton("RS.5000");
   		   b24.setBounds(350,220,200,30);
   		   b24.setFont(f1);
	       frame7.add(b24);

           b25=new JButton("RS.1000");
   		   b25.setBounds(20,320,200,30);
   		   b25.setFont(f1);
	       frame7.add(b25);

           b26=new JButton("RS.10000");
   		   b26.setBounds(350,320,200,30);
   		   b26.setFont(f1);
	       frame7.add(b26);

           Font f2=new Font("dialog",Font.BOLD,20);
           b27=new JButton("BACK");
   		   b27.setBounds(50,390,100,35);
   		   b27.setFont(f2);
	       frame7.add(b27);

           Font f3=new Font("dialog",Font.BOLD,20);
           b28=new JButton("EXIT");
   		   b28.setBounds(430,390,100,35);
   		   b28.setFont(f3);
	       frame7.add(b28);
	       b28.addActionListener(new Button10Inner());
	       b27.addActionListener(new Button13Inner());
	       b21.addActionListener(new Button17Inner());
           b23.addActionListener(new Button17Inner());
           b22.addActionListener(new Button17Inner());
           b24.addActionListener(new Button17Inner());
           b25.addActionListener(new Button17Inner());
           b26.addActionListener(new Button17Inner());

	   }
   }

class Button8Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		  // frame9.dispose();
           JFrame frame8=new JFrame("PIN CHANGE");
   		   frame8.setSize(550,400);
   		   frame8.setLocation(0,50);
   		   frame8.setLayout(null);
   		   frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,25);
           lb34=new JLabel("Change Your Pin No");
           lb34.setBounds(150,30,600,30);
           lb34.setForeground(Color.RED);
           lb34.setFont(f0);
           frame8.add(lb34);
           frame8.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,25);
   		   lb35=new JLabel("Current Pin:    ");
   		   lb35.setBounds(30,100,500,25);
   		   lb35.setFont(f1);
   		   frame8.add(lb35);

   		   Font f2=new Font("dialog",Font.BOLD,20);
   		   t12=new JTextField();
   		   t12.setBounds(300,100,200,25);
   		   t12.setFont(f1);
   		   t12.setForeground(Color.RED);
   		   frame8.add(t12);

           Font f3=new Font("dialog",Font.BOLD,25);
    	   lb36=new JLabel("New Pin:    ");
    	   lb36.setBounds(30,150,500,25);
    	   lb36.setFont(f3);
    	   frame8.add(lb36);

           Font f4=new Font("dialog",Font.BOLD,20);
   		   p2=new JPasswordField();
   		   p2.setBounds(300,150,200,25);
   		   p2.setForeground(Color.RED);
   		   p2.setFont(f4);
   		   frame8.add(p2);

           Font f5=new Font("dialog",Font.BOLD,25);
   		    lb37=new JLabel("RE-EnterNewPin:    ");
   		   lb37.setBounds(30,200,500,25);
   		   lb37.setFont(f5);
   		   frame8.add(lb37);

           Font f6=new Font("dialog",Font.BOLD,20);
   		   p3=new JPasswordField();
   		   p3.setBounds(300,200,200,25);
   		   p3.setForeground(Color.RED);
   		   p3.setFont(f6);
   		   frame8.add(p3);


           Font f7=new Font("dialog",Font.BOLD,15);
           b29=new JButton("SAVE");
   		   b29.setBounds(100,250,100,35);
   		   b29.setFont(f7);
	       frame8.add(b29);

           Font f8=new Font("dialog",Font.BOLD,15);
           b30=new JButton("EXIT");
   		   b30.setBounds(300,250,100,35);
   		   b30.setFont(f8);
	       frame8.add(b30);
	       b30.addActionListener(new Button10Inner());
	       b29.addActionListener(new Button16Inner());

	 }
 }

class Button9Inner implements ActionListener
    {
 	  public void actionPerformed(ActionEvent ae)
	   {
           t1.setText("");
           p1.setText("");
	   }
   }

class Button10Inner implements ActionListener
{
 public void actionPerformed(ActionEvent ae)
   {
	 if(ae.getSource()==b14 || ae.getSource()==b17 || ae.getSource()==b20 || ae.getSource()==b28
	 || ae.getSource()==b32 || ae.getSource()==b34 ||ae.getSource()==b30)
	     {
           System.exit(0);
          }
   }
 }

 class Button11Inner implements ActionListener
    {
 	  public void actionPerformed(ActionEvent ae)
 	   {
 		    try
               {

 	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
 	     		Connection con=DriverManager.getConnection
 	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2
 	    		Statement stm=con.createStatement();
 	    		int i=stm.executeUpdate("insert into Balance values('"+t10.getText()+"',0,sysdate,null,'"+t1.getText()+"')");
 	    		String OutputMessage="Balance succesfully deposite"+i;
 	    		JOptionPane.showMessageDialog(null,OutputMessage);
 	    		con.close();

		        }
			  catch(Exception e)
			   {

		       }
        }
    }

class Button12Inner implements ActionListener
    {
 	  public void actionPerformed(ActionEvent ae)
 	   {
 		    try
               {

 	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
 	     		Connection con=DriverManager.getConnection
 	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");
 	    		Statement stm=con.createStatement();//step3
		        ResultSet rs=stm.executeQuery("select sum(deposit-withdrawal) from balance where cardno='"+t1.getText()+"'");
	    	    while(rs.next())
	    	    {
				 v100=rs.getString(1);
				 r100=Integer.parseInt(v100);
 	    		String OutputMessage="CURRENT BALANCE=     "+r100;
 	    		JOptionPane.showMessageDialog(null,OutputMessage);
			    }
 	    		con.close();

		        }
			  catch(Exception e)
			   {

		       }
        }
    }
 class Button13Inner implements ActionListener
    {
 	  public void actionPerformed(ActionEvent ae)
 	   {
		  //frame5.dispose();
		 //  frame6.dispose();
		 //  frame7.dispose();
		 //  frame8.dispose();
           JFrame frame4=new JFrame(" TRANSACTION");
   		   frame4.setSize(600,500);
   		   frame4.setLocation(0,50);
   		   frame4.setLayout(null);
   		   frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,35);
           lb28=new JLabel("Please Select Your Transaction");
           lb28.setBounds(30,30,600,30);
           lb28.setForeground(Color.RED);
           lb28.setFont(f0);
           frame4.add(lb28);
           frame4.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,15);
           b8=new JButton("DEPOSIT");
   		   b8.setBounds(20,120,200,30);
   		   b8.setFont(f1);
	       frame4.add(b8);

           b9=new JButton("CASH WITHDRAWAL");
   		   b9.setBounds(350,120,200,30);
   		   b9.setFont(f1);
	       frame4.add(b9);

           b10=new JButton("FAST CASH");
   		   b10.setBounds(20,220,200,30);
   		   b10.setFont(f1);
	       frame4.add(b10);

           b11=new JButton("MINI STATEMENT");
   		   b11.setBounds(350,220,200,30);
   		   b11.setFont(f1);
	       frame4.add(b11);

           b12=new JButton("PIN CHANGE");
   		   b12.setBounds(20,320,200,30);
   		   b12.setFont(f1);
	       frame4.add(b12);

           b13=new JButton("BALANCE ENQUIRY");
   		   b13.setBounds(350,320,200,30);
   		   b13.setFont(f1);
	       frame4.add(b13);

           Font f2=new Font("dialog",Font.BOLD,20);
           b14=new JButton("EXIT");
   		   b14.setBounds(200,370,200,35);
   		   b14.setFont(f2);
	       frame4.add(b14);
	       b8.addActionListener(new Button5Inner());
	       b9.addActionListener(new Button6Inner());
	       b10.addActionListener(new Button7Inner());
           b12.addActionListener(new Button8Inner());
           b13.addActionListener(new Button12Inner());
           b14.addActionListener(new Button10Inner());
           b11.addActionListener(new Button14Inner());
	 }
   }

 class Button14Inner implements ActionListener
    {
 	  public void actionPerformed(ActionEvent ae)
 	   {
 		    try
               {

 	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
 	     		Connection con=DriverManager.getConnection
 	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");
 	    		//Statement stm=con.createStatement();//step3
 	    		Statement stm1=con.createStatement();
 	    		ResultSet ps=stm1.executeQuery("select count(*) from balance where cardno='"+t1.getText()+"'");
 	    		while(ps.next())
 	    		{
 	    		String OutputMessage1="TOTAL NO OF TRANSECTION="+ps.getInt(1);
 	    		JOptionPane.showMessageDialog(null,OutputMessage1);
			    }
			    Statement stm=con.createStatement();//step3
		        ResultSet rs=stm.executeQuery("select * from balance where cardno='"+t1.getText()+"'");
	    	    while(rs.next())
	    	    {
				String OutputMessage="DEPOSIT=   "+rs.getString(1)+"   withdrawal=  "+rs.getString(2)+
 	    		"   DAPDATETIME=   "+rs.getString(3)+ "  WITHDATETIME=    "+rs.getString(4)+  " CARDNO=   "+rs.getString(5);
                JOptionPane.showMessageDialog(null,OutputMessage);

			    }
 	    		con.close();

		        }
			  catch(Exception e)
			   {

		       }
        }
   }

 class Button15Inner implements ActionListener
       {
    	  public void actionPerformed(ActionEvent ae)
    	   {
			 U=t11.getText();
    	     n=Integer.parseInt(U);
			 if(r100!=0&&r100>=n)
			 {
    		    try
                  {

    	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
    	     		Connection con=DriverManager.getConnection
    	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2
    	    		Statement stm=con.createStatement();
    	    		if(n<=10000&&n>=0&&n%100==0&&r100>=n)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,'"+t11.getText()+"',null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }
				    else
				    {
                       String OutputMessage="INVALID TRANSECTION AMOUNT";
                       JOptionPane.showMessageDialog(null,OutputMessage);
				     }
           JFrame frame10=new JFrame(" TRANSACTION");
   		   frame10.setSize(600,400);
   		   frame10.setLocation(0,50);
   		   frame10.setLayout(null);
   		   frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,35);
           lb38=new JLabel("THANK YOU FOR USING ATM");
           lb38.setBounds(30,90,600,30);
           lb38.setForeground(Color.RED);
           lb38.setFont(f0);
           frame10.add(lb38);
           frame10.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,15);
           b31=new JButton("BACK");
   		   b31.setBounds(20,180,150,30);
   		   b31.setFont(f1);
	       frame10.add(b31);

           b32=new JButton("EXIT");
   		   b32.setBounds(400,180,150,30);
   		   b32.setFont(f1);
	       frame10.add(b32);
	       b31.addActionListener(new Button13Inner());
           b32.addActionListener(new Button10Inner());
	       }
   			  catch(Exception e)
   			   {

   		       }
	   }
	   else
	   {
	      String OutputMessage="INSUFFICENT AMOUNT";
          JOptionPane.showMessageDialog(null,OutputMessage);
        }
     }
   }

  class Button16Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		    try
              {
				int flag=1;
	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
	     		Connection con=DriverManager.getConnection
	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2

	    	     Statement stm=con.createStatement();//step3
	    	     ResultSet rs=stm.executeQuery("select pinno from CardLogin");
	    	     while(rs.next())
	    	     {
                 if(rs.getString(1).equals(t12.getText())&& p1.getText().equals(t12.getText()) )

				 	  {
					  flag=0;
					  break;
				      }
			      }

			 if(flag==0&& p2.getText().equals(p3.getText()))
			  {
				  Statement stm1=con.createStatement();
				  int i=stm1.executeUpdate("update CardLogin set pinno='"+p3.getText()+"'where cardno='"+t1.getText()+"'");
				  String OutputMessage="PINNO CHANGE"+i;
				  JOptionPane.showMessageDialog(null,OutputMessage);
    	          con.close();
			  }
			  else
			   {
				   JOptionPane.showMessageDialog(null,"PINNO WRONG");
			   }
			}
		 	  catch(Exception e)
		    			   {

		    		       }
	 }
 }

 class Button17Inner implements ActionListener
       {
    	  public void actionPerformed(ActionEvent ae)
    	   {
			 if(r100!=0&&(r100>=100||r100>=500||r100>=1000||r100>=1500||r100>=5000||r100>=10000))
			 {
    		    try
                  {

    	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
    	     		Connection con=DriverManager.getConnection
    	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2
    	    		Statement stm=con.createStatement();
    	    		if( ae.getSource()==b21&&r100>=100)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,100,null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }

                   else if( ae.getSource()==b23&&r100>=500)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,500,null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }

				  else if( ae.getSource()==b22&&r100>=1500)
				   {
					   int i=stm.executeUpdate("insert into Balance values(0,1500,null,sysdate,'"+t1.getText()+"')");
	                   String OutputMessage="PLEASE COLLECT THE MONEY"+i;
	                   JOptionPane.showMessageDialog(null,OutputMessage);
	    	    		con.close();
				    }

                 else if( ae.getSource()==b24&&r100>=5000)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,5000,null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }

               else if( ae.getSource()==b25&&r100>=1000)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,1000,null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }
               else if( ae.getSource()==b26&&r100>=10000)
    	    		{
    	    		int i=stm.executeUpdate("insert into Balance values(0,10000,null,sysdate,'"+t1.getText()+"')");
    	    		String OutputMessage="PLEASE COLLECT THE MONEY"+i;
    	    		JOptionPane.showMessageDialog(null,OutputMessage);
    	    		con.close();
				    }
				    else
				    {
                       String OutputMessage="INVALID TRANSECTION AMOUNT";
                       JOptionPane.showMessageDialog(null,OutputMessage);
				     }
           JFrame frame10=new JFrame(" TRANSACTION");
   		   frame10.setSize(600,400);
   		   frame10.setLocation(0,50);
   		   frame10.setLayout(null);
   		   frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,35);
           lb38=new JLabel("THANK YOU FOR USING ATM");
           lb38.setBounds(30,90,600,30);
           lb38.setForeground(Color.RED);
           lb38.setFont(f0);
           frame10.add(lb38);
           frame10.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,15);
           b31=new JButton("BACK");
   		   b31.setBounds(20,180,150,30);
   		   b31.setFont(f1);
	       frame10.add(b31);

           b32=new JButton("EXIT");
   		   b32.setBounds(400,180,150,30);
   		   b32.setFont(f1);
	       frame10.add(b32);
	       b31.addActionListener(new Button13Inner());
           b32.addActionListener(new Button10Inner());
	       }
   			  catch(Exception e)
   			   {

   		       }
	   }
	   else
	   {
	      String OutputMessage="INSUFFICENT AMOUNT";
          JOptionPane.showMessageDialog(null,OutputMessage);
        }
     }
   }
class Button18Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		  // frame9.dispose();
           frame11=new JFrame("SIGN UP");
   		   frame11.setSize(550,400);
   		   frame11.setLocation(0,50);
   		   frame11.setLayout(null);
   		   frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           Font f0=new Font("dialog",Font.BOLD,25);
           lb39=new JLabel("Verify Your Card No");
           lb39.setBounds(150,30,600,30);
           lb39.setForeground(Color.RED);
           lb39.setFont(f0);
           frame11.add(lb39);
           frame11.setVisible(true);

           Font f1=new Font("dialog",Font.BOLD,25);
   		   lb40=new JLabel("Card No:    ");
   		   lb40.setBounds(30,100,500,25);
   		   lb40.setFont(f1);
   		   frame11.add(lb40);

   		   Font f2=new Font("dialog",Font.BOLD,20);
   		   t21=new JTextField();
   		   t21.setBounds(300,100,200,25);
   		   t21.setFont(f1);
   		   t21.setForeground(Color.RED);
   		   frame11.add(t21);

           Font f3=new Font("dialog",Font.BOLD,25);
    	   lb41=new JLabel("New Pin:    ");
    	   lb41.setBounds(30,150,500,25);
    	   lb41.setFont(f3);
    	   frame11.add(lb41);

           Font f4=new Font("dialog",Font.BOLD,20);
   		   p4=new JPasswordField();
   		   p4.setBounds(300,150,200,25);
   		   p4.setForeground(Color.RED);
   		   p4.setFont(f4);
   		   frame11.add(p4);

           Font f5=new Font("dialog",Font.BOLD,25);
   		    lb42=new JLabel("RE-EnterNewPin:    ");
   		   lb42.setBounds(30,200,500,25);
   		   lb42.setFont(f5);
   		   frame11.add(lb42);

           Font f6=new Font("dialog",Font.BOLD,20);
   		   p5=new JPasswordField();
   		   p5.setBounds(300,200,200,25);
   		   p5.setForeground(Color.RED);
   		   p5.setFont(f6);
   		   frame11.add(p5);


           Font f7=new Font("dialog",Font.BOLD,15);
           b33=new JButton("SUBMIT");
   		   b33.setBounds(100,250,100,35);
   		   b33.setFont(f7);
	       frame11.add(b33);

           Font f8=new Font("dialog",Font.BOLD,15);
           b34=new JButton("EXIT");
   		   b34.setBounds(300,250,100,35);
   		   b34.setFont(f8);
	       frame11.add(b34);
	       b33.addActionListener(new Button19Inner());
	       b34.addActionListener(new Button10Inner());

	 }
 }

 class Button19Inner implements ActionListener
   {
	  public void actionPerformed(ActionEvent ae)
	   {
		    try
              {
                int flag=1;
	     		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
	     		Connection con=DriverManager.getConnection
	    		("jdbc:oracle:thin:@localhost:1521:xe","Atm5","Atm5");//step2
	    		  Statement stm=con.createStatement();
	         ResultSet rs=stm.executeQuery("select cardno,pinno from CardLogin");
	    		  while(rs.next())
  	    	     {
                   if(rs.getString(1).equals(t21.getText()))

  				 	  {
  					  flag=0;
  					  break;
  				      }
			      }

                 if(flag==0&& p4.getText().equals(p5.getText()))
				   {
				    Statement stm1=con.createStatement();
				    int i=stm1.executeUpdate("update cardLogin set pinno='"+p5.getText()+"' where cardno='"+t21.getText()+"'");
				    String OutputMessage="CARD NO REGISTERED"+i;
				    JOptionPane.showMessageDialog(null,OutputMessage);
    	            con.close();
			       }
			     else
			     {
					 JOptionPane.showMessageDialog(null,"CARD NOT REGISTERED");
		         }
		       }
		 	   catch(Exception e)
		    			   {  }

	  }
    }
}





