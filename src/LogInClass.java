
import javax.swing.*;        
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogInClass implements ActionListener
{
	JFrame frame;
	JTextField user = new JTextField();
	JPasswordField password = new JPasswordField();
	
	LogInClass()
	{
		//Log-In Interface
		
				frame=new JFrame("   Dreamy Travels");
				frame.setSize(1050,588);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				
				//Adding Background Image
				Icon icon1 = new ImageIcon("background.jpg");
				JLabel background=new JLabel("",icon1,JLabel.CENTER);
				background.setBounds(0,0,1050,588);
				frame.getContentPane().add(background);
				
				
				//Adding a JPanel
				JPanel rectangle = new JPanel();
				rectangle.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgba)
				rectangle.setBounds(150, 100, 350, 350);
				rectangle.setLayout(null);
				background.add(rectangle);
				
				
				//Admin login text
				JLabel admin = new JLabel ("Admin Login");
				admin.setBounds(50, 25,250 ,50);
				admin.setForeground(Color.WHITE); //for adding color to the text
				admin.setFont(new Font("New Roman Times",Font.BOLD,40));
				admin.setLayout(new FlowLayout(FlowLayout.CENTER));
				rectangle.add(admin); //adding Text/JLabel on JPanel rectangle
				
				//Adding JLabel Username
				JLabel username=new JLabel("Username");
				username.setBounds(50, 100, 200, 25);
				username.setForeground(Color.WHITE);
				username.setFont(new Font("Calibri",Font.BOLD,20));
				rectangle.add(username);
				
				//Adding Text Field Username
				user.setBounds(50,150,200, 25);
		//		user.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				user.setBackground(new Color(0.0f, 0.0f, 0.5f, 0.5f));
				user.setForeground(Color.WHITE);
				rectangle.add(user);
				
				//AddingJLabel Password
				JLabel userpassword=new JLabel("Password");
				userpassword.setBounds(50, 200, 200, 25);
				userpassword.setForeground(Color.WHITE);
				userpassword.setFont(new Font("Calibri",Font.BOLD,20));
				rectangle.add(userpassword);
				
				//Adding Password Field 
				password.setBackground(new Color(0.0f, 0.0f, 0.5f, 0.5f));
				password.setForeground(Color.WHITE);
				password.setBounds(50, 250, 200, 25);
				rectangle.add(password);
				
				//Adding J Button
				JButton login=new JButton("Log in");
				login.setBounds(200, 300, 125, 40);
				login.setFont(new Font("Arial",Font.ITALIC,20));
				login.setForeground(Color.BLUE);
				rectangle.add(login);
				
				//Action listener on login
				login.addActionListener(this); 
				
				rectangle.setOpaque(true);
				frame.setVisible(true);
				
	}
				public void actionPerformed(ActionEvent e)
				{
					String username=user.getText().trim();
					String paswrd=password.getText().trim();
					
					if(e.getActionCommand() == "Log in")
					{
						try {
				        	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	
				            
				        	Statement statement = connection.createStatement();
				        	
				        	String sql1 = "SELECT * FROM LoginTable WHERE UserName= '"+username+"'AND Password= '"+paswrd+"'";
				  
				        	ResultSet result1 = statement.executeQuery(sql1);
				        	int count=0;
				        	while (result1.next()) 
				        	{
				        		count++;
							}
				        	if(count==1)
				        	{
				        		JOptionPane.showMessageDialog(null,"User found" );
				        		new MenuOption();
								frame.dispose();
				        	}
				        	else
				        		JOptionPane.showMessageDialog(null,"User not found" );
				        	statement.close();
				            connection.close();
				        } 
				        catch (Exception ex) 
						{
				            System.out.println(ex);
				        }
						
					}
						
				}
				
	
	
	public static void main(String []args)
	{
		new LogInClass();
	}

}
