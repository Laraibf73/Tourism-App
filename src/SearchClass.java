
import javax.swing.*;                      
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

public class SearchClass implements ActionListener 
{
	JFrame frame3;
	ImageIcon icon3;
	JLabel background3;
	JLabel search;
	JLabel locationl ;
	JComboBox<String> loclist;
	JLabel ch_pkgname;
	JTextField pkgname;
	JLabel departuring_day;
	JDateChooser dateChooser ;
	JButton searchb;
	JButton cancel;
	
	JTable Search_table = new JTable();
	
	SearchClass()
	{
		        //Search Package
				frame3=new JFrame("   Dreamy Travels");
				frame3.setSize(1400,900);
		//		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame3.getContentPane().setLayout(null);
				
				//ADDING BACKGROUND
				icon3=new ImageIcon("details.jpg");
				background3=new JLabel("",icon3,JLabel.CENTER);
				background3.setBounds(0, 0, 1790, 1123);
				frame3.getContentPane().add(background3);
				
				
				JPanel rectangle3 = new JPanel();
				rectangle3.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgba)
				rectangle3.setBounds(50, 50, 450, 600);
				rectangle3.setLayout(null);
				background3.add(rectangle3);
				
				//ADDING SEARCH BY HEADING
				search=new JLabel("Search by.......");
				search.setBounds(50, 50, 400, 70);
				search.setFont(new Font("Algerian",Font.BOLD,50));
				search.setForeground(Color.WHITE);
				rectangle3.add(search);
				
				//ADDING checkbox FOR LOCATION
				locationl = new JLabel("Location");
				locationl.setBounds(75, 125, 200, 25);
				locationl.setFont(new Font("Calibri",Font.BOLD,20));
				locationl.setForeground(Color.WHITE);
				rectangle3.add(locationl);
				
				String[] locations= { "Select location","Pakistan,Ghizer Valley(GB)","Pakistan,Ayubia(Abbtoabad)",
                        "Pakistan,Hawksbay(Karachi)","Pakistan,Badshahi Mosque(Lahore)",
                        "Pakistan,Gard Port(Karachi)","Pakistan,Shah-e-Qila(Lahore)",
                        "Pakistan,Noor Mahal(Bahawalpur)","Pakistan,Pak-China Border(Karakoram)",
                        "Pakistan,Abdullah Shah Ghazi Tomb(Karachi)",
                        "Turkey,Blue Mosque(Istanbul)","Maldives,Thulhagiri Island ",
                        "UAE,Dubai","UK,Buckingham Palace(London)","USA,Los Angles",
                        "Switzerland,Lucerne","Greece,Athens","Turkey,Anatalia",
                        "USA,Waikiki Beach(Hawaii)","Switzerland,Loin Monument"
		              };

		            loclist=new JComboBox<String>(locations);
		            loclist.addItemListener(new ItemListener() {
		            	public void itemStateChanged(ItemEvent e) 
		            	{
		            		String location=loclist.getSelectedItem().toString();
								try
							    {
							    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
									Statement statement = connection.createStatement();
									String sql="SELECT* FROM TourDetails WHERE Location= '"+location+"'";
									System.out.println(sql);
									ResultSet rs = statement.executeQuery(sql);
									Search_table.setModel(DbUtils.resultSetToTableModel(rs));	
									
									statement.close();
						            connection.close();
								}
								catch(Exception ex)
								{
									JOptionPane.showMessageDialog(null,ex);
									 
								}  
		            		
			            	}
			            });
		         
	           loclist.setBounds(100,175,225, 25);
	           loclist.setBackground(Color.WHITE);
	           rectangle3.add(loclist);
				
		           
				//ADDING JLABEL FOR PACKAGE NAME
		        ch_pkgname = new JLabel("Package Name");
				ch_pkgname.setBounds(75, 225, 200, 25);
				ch_pkgname.setFont(new Font("Calibri",Font.BOLD,20));
				ch_pkgname.setForeground(Color.WHITE);
				rectangle3.add(ch_pkgname);
				
				//ADDING TEXTFIELD
				pkgname = new JTextField();
				pkgname.addKeyListener(new KeyAdapter() {
					
					public void keyReleased(KeyEvent e) 
					{
						String name=pkgname.getText();
						try
					    {
					    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
							Statement statement = connection.createStatement();
							String sql="SELECT* FROM TourDetails WHERE Package_Name LIKE '%"+ name+"%'";
							System.out.println(sql);
							ResultSet rs = statement.executeQuery(sql);
							Search_table.setModel(DbUtils.resultSetToTableModel(rs));
							
							
							statement.close();
				            connection.close();
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,ex);
							 
						}  
					}
				});
				pkgname.setBounds(100,275,200, 25);
				rectangle3.add(pkgname);
				
				
				//ADDING JLABEL FOR DEPATURE DAY
				departuring_day = new JLabel("Day of Departure");
				departuring_day.setBounds(75, 325, 200, 25);
				departuring_day.setFont(new Font("Calibri",Font.BOLD,20));
				departuring_day.setForeground(Color.WHITE);
				rectangle3.add(departuring_day);
				
				dateChooser = new JDateChooser();
				dateChooser.setBounds(100, 375, 200, 25);
				rectangle3.add(dateChooser);
				
				
				//ADDING SEARCH BUTTON
				searchb=new JButton("Search");
				searchb.setBounds(200, 425, 100, 25);
				rectangle3.add(searchb);
				
				
				//ADDING CANCEL BUTTON
				cancel=new JButton("Cancel");
				cancel.setBounds(800, 400, 100, 50);
				cancel.setFont(new Font("Calibri",Font.BOLD,20));
				background3.add(cancel);
				
				
				//ADDING ACTIONLISTENERS 
				searchb.addActionListener(this);
				cancel.addActionListener(this);
					
				SearchTable();
				frame3.setVisible(true);
				
	}
	
	public void SearchTable()
	   {	   		   
		   DefaultTableModel model1 = new DefaultTableModel(0,0);
			String headings[] =  {"Id", "Name","Type", "Location", "Departureday","Duration","Description","HName","Family Members","EmailId","HContactno","Amount"};
			model1.setColumnIdentifiers(headings);
			
		    try
		    {
		    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
				Statement statement = connection.createStatement();
				
				
				String sql1="SELECT * FROM TourDetails";
				System.out.println(sql1);
				ResultSet rs = statement.executeQuery(sql1);
				while (rs.next()) 
				{
					int Package_Id=rs.getInt("Package_Id");          
					String Package_Name=rs.getString("Package_Name");
					String Package_Type=rs.getString("Package_Type");
					String Location=rs.getString("Location");
					String Departure_Date=rs.getString("Departure_Date");
					int Duration=rs.getInt("Duration");
					String Tour_Description=rs.getString("Tour_Description");
					String Host_Name=rs.getString("Host_Name");
					int No_of_FamilyMembers=rs.getInt("No_of_FamilyMembers");
					String Email_Id=rs.getString("Email_Id");
					String Host_Contactno=rs.getString("Host_Contactno");
					String Amount=rs.getString("Amount");
					
					
				    System.out.println(Package_Id+","+Package_Name+","+Package_Type
				    		           +","+Location+","+Departure_Date+","+Duration+","
				    		           +Tour_Description+","+Host_Name+","+No_of_FamilyMembers
				    		           +","+Email_Id+","+Host_Contactno+","+Amount);
				    
					model1.addRow(new Object[] {Package_Id, Package_Name,
												Package_Type,Location,Departure_Date,Duration,
												Tour_Description,Host_Name,No_of_FamilyMembers,
												Email_Id,Host_Contactno,Amount});
	       					
	       	}	
				rs.close();
		    	statement.close();
	           connection.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		    
		    Search_table.setModel(model1);
			JScrollPane scrollPane = new JScrollPane(Search_table);
		    scrollPane.setBounds(550, 150, 750, 150);
		    background3.add(scrollPane);
	   }

		public void searchbyDate()
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date=sdf.format(dateChooser.getDate());
			try
		    {
		    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
				Statement statement = connection.createStatement();
				String sql="SELECT* FROM TourDetails WHERE Departure_Date= '"+date+"'";
				System.out.println(sql);
				ResultSet rs = statement.executeQuery(sql);
				Search_table.setModel(DbUtils.resultSetToTableModel(rs));	
				
				statement.close();
	            connection.close();
			}
			catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);
			}
				 
		}  
		
		public void actionPerformed(ActionEvent e)
		{
			 if(e.getActionCommand()=="Search") 
				searchbyDate();
			
			else if(e.getActionCommand()=="Cancel")
				frame3.dispose();
			
	    }
		public static void main(String[] args) {
			new SearchClass();
		}
	}


