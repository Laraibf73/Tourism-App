	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.sql.*;
	
	public class Login2 implements ActionListener
	{
	JFrame frame= new JFrame();
	JCheckBox cb_show = new JCheckBox();
	JPasswordField t1_usern = new JPasswordField();
	JTextField t_usern = new JTextField();
	JButton B1=new JButton ("LOGIN");
	 
	JButton B2=new JButton ("CANCEL");
	
	Login2 ()
	{
	frame.setTitle (" Welcome to Beauty1 Salon ");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	
	JLabel lab = new JLabel("**Your Beauty is our Concern!**");
	lab.setBounds(190,25,300,25);
	lab.setFont(new Font("Algerian" ,Font.PLAIN,18));
	frame.getContentPane().add(lab);
	JLabel lab1 = new JLabel("Write Beautician Type:");
	lab1.setFont(new Font("ARIAL BLACK" ,Font.BOLD,13));
	lab1.setBounds(50,50,200,50);
	frame.getContentPane().add(lab1);
	
	/*JRadioButton jRadioButton1;
	   JRadioButton jRadioButton2;
	   JRadioButton jRadioButton3;
	   JRadioButton jRadioButton4;
	   jRadioButton1 = new JRadioButton("Makeup Artist");
	    jRadioButton2 = new JRadioButton("Hair Stylist");
	    jRadioButton3 = new JRadioButton("Esthetician");
	    jRadioButton4 = new JRadioButton("Manicurist");
	   jRadioButton1.setBounds(30,90,160,30);
	        jRadioButton2.setBounds(30,120,160,30);
	        jRadioButton3.setBounds(30,150,160,30);
	        jRadioButton4.setBounds(30,180,160,30);
	        frame.getContentPane().add(jRadioButton1);
	        frame.getContentPane().add(jRadioButton2);
	        frame.getContentPane().add(jRadioButton3);
	        frame.getContentPane().add(jRadioButton4);
	        ButtonGroup G = new ButtonGroup();
	        G.add(jRadioButton1);
	G.add(jRadioButton2);
	G.add(jRadioButton3);
	G.add(jRadioButton4);*/
	JLabel lab3 = new JLabel("USERNAME");
	lab3.setBounds(50, 220, 100, 60);
	lab3.setFont(new Font("Berlin Sans FB Demi" ,Font.BOLD,16));
	frame.getContentPane().add(lab3);
	
	JTextField t_usern = new JTextField();
	t_usern.setBounds(210, 235, 200, 30);
	t_usern.setFont(new Font("CALIBRI" ,Font.ITALIC,14));
	frame.getContentPane().add(t_usern);
	
	JLabel lab4 = new JLabel("PASSWORD");
	lab4.setBounds(50, 270, 100, 60);
	lab4.setFont(new Font("Berlin Sans FB Demi" ,Font.BOLD,16));
	frame.getContentPane().add(lab4);
	
	t1_usern.setBounds(210, 283, 200, 30);
	t1_usern.setFont(new Font("CALIBRI" ,Font.ITALIC,13));
	frame.getContentPane().add(t1_usern);
	
	JLabel lab5 = new JLabel("Show Password");
	lab5.setBounds(305, 320, 100, 30);
	lab5.setFont(new Font("CALIBRI" ,Font.BOLD,15));
	frame.getContentPane().add(lab5);
	
	cb_show.setBounds(280, 323, 20, 20);
	frame.getContentPane().add(cb_show);
	cb_show.addActionListener(this);
	 
	 
	   
	   B1.setBounds(205,450,80,40);
	   frame.getContentPane().add(B1);
	B1.addActionListener(this);
	 
	B2.setBounds(350,450,80,40);
	frame.getContentPane().add(B2);
	B2.addActionListener(this);
	
	frame.setSize(new Dimension(700,600));
	frame.setResizable(true);
	frame.setVisible(true);
	
	}
	public void actionPerformed(ActionEvent e)
	{
	
	if(e.getActionCommand() == "LOGIN")
	{
	
	String UName = t_usern.getText();
	String Pass =  t1_usern.getText();
		try
		{
		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");
		
		Statement stmt = conn.createStatement();
		String sql1 = "SELECT * FROM LoginTable WHERE UserName= '"+UName+"'AND Password= '"+Pass+"'";
	//	JOptionPane.showMessageDialog(null,"User found" );
		System.out.println(sql1);
		ResultSet result1 = stmt.executeQuery(sql1);
		int count=0;
		while (result1.next()) 
		{
			count++;
			
		}
		if(count==1)
		{
			JOptionPane.showMessageDialog(null,"User found" );
			new MenuOption();
			
		}
		
		stmt.close();
	    conn.close();
	} 
	catch(Exception ex)
	{
	System.out.println(ex);
	
	}
	
	
	}
	if(e.getActionCommand()== "CANCEL")
	{
	frame.dispose();
	}
	
	if (e.getActionCommand() == "Show Password")
	  {
	     if (cb_show.isSelected())
	     {
	           t1_usern.setEchoChar((char) 0);
	     }
	     else
	     {
	           t1_usern.setEchoChar('*');
	     }
	
	
	       }
	}
	
		public static void main(String []args)
		{
			new Login2();
		}
	
	}/*stmt=conn.prepareStatement(sql);
	if (rs.next())
	{
	MenuDisplay2 m = new MenuDisplay2();
	m.framef.setVisible(true);
	}*/
	/*else
	{
	JOptionPane.showMessageDialog(null, "Invalid input ,Plz Try again !");
	}*/
	
