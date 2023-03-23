import javax.swing.*;          
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.*;

public class UpdateTourDetailsClass implements ActionListener
{
	PackageDetails Pkg_detail = new PackageDetails();
	JFrame frame6;
	JPanel rectangle6 ;
	JComboBox<String> list;
	JTextField UPkgId;
	JTextField UPkgName;
	JRadioButton Utype_international;
	JRadioButton Utype_domestic;
	JComboBox<String> Uloclist;   
    JDateChooser dateChooser;  
	JSpinner Us;   
	JTextArea Utourdesc;
	JTextField Utf_email;		 
	JSpinner Us1;
	JTextField Utf_hostN;
	JTextField Utf_contactNo;	
	JTextField Uamount;
	JLabel background7;
    
	JTable table = new JTable();
	
    JFrame frame7;
	
	UpdateTourDetailsClass()
	{
		frame7=new JFrame("   Dreamy Travels");
//		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame7.setSize(1000,600);
	     frame7.setLayout(null);
	   
	    //Background Image
		ImageIcon icon7=new ImageIcon("details.jpg");
		 background7=new JLabel("",icon7,JLabel.CENTER);
		background7.setBounds(0, 0, 1000,600);
		frame7.getContentPane().add(background7);
	   
		//Heading
		JLabel select=new JLabel("Select Package Id");
		select.setBounds(100,50,200,25);
		select.setFont(new Font("New Roman Times",Font.BOLD,20));
		background7.add(select);
		
		//Fill JComboBox with id's of DataBase
		list=new JComboBox<String>();
		list.setBounds(350,50, 150, 25);
		background7.add(list);
		try
	    {
			
	    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
			Statement statement = connection.createStatement();
			
			String sql="SELECT Package_Id FROM TourDetails";
			ResultSet rs1 = statement.executeQuery(sql);
			while (rs1.next()) 
	    	{          
				list.addItem(rs1.getString("Package_Id"));
	    	}
			rs1.close();
			statement.close();
	        connection.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		list.setSelectedIndex(-1);
		       
		   
	    JButton getdata=new JButton("Get Data");
	    getdata.setBounds(200, 400, 200, 50);
	    getdata.setFont(new Font("Calibri",Font.BOLD,20));
	    background7.add(getdata);
	    
	    JButton cancel=new JButton("Exit");
		cancel.setBounds(450, 400, 200, 50);
		cancel.setFont(new Font("Calibri",Font.BOLD,20));
		background7.add(cancel);
		
		cancel.addActionListener(this);
	    getdata.addActionListener(this); 
	    
	    Display_Table();
	    
		frame7.setVisible(true);	
	}
	
	public void Display_Table()
	{
		DefaultTableModel model = new DefaultTableModel(0,0);
		String headings[] =  {"Id", "Name","Type", "Location", "DepartureDay","Duration","Description","HName","Family Members","EmailId","HContactno","Amount"};
		model.setColumnIdentifiers(headings);
		
	    try
	    {
	    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
			Statement statement = connection.createStatement();		
			
			String sql1="SELECT* FROM TourDetails";
			System.out.println(sql1);
			ResultSet result = statement.executeQuery(sql1);
			while (result.next()) 
        	{
				int Package_Id=result.getInt("Package_Id");          
				String Package_Name=result.getString("Package_Name");
				String Package_Type=result.getString("Package_Type");
				String Location=result.getString("Location");
				String Departure_Date=result.getString("Departure_Date");
				int Duration=result.getInt("Duration");
				String Tour_Description=result.getString("Tour_Description");
				String Host_Name=result.getString("Host_Name");
				int No_of_FamilyMembers=result.getInt("No_of_FamilyMembers");
				String Email_Id=result.getString("Email_Id");
				String Host_Contactno=result.getString("Host_Contactno");
				String Amount=result.getString("Amount");
				
			    System.out.println(Package_Id+","+Package_Name+","+Package_Type
			    		           +","+Location+","+Departure_Date+","+Duration+","
			    		           +Tour_Description+","+Host_Name+","+No_of_FamilyMembers
			    		           +","+Email_Id+","+Host_Contactno+","+Amount);
			    
				model.addRow(new Object[] 
						{Package_Id, Package_Name,Package_Type,Location,Departure_Date,Duration,Tour_Description,Host_Name,No_of_FamilyMembers,Email_Id,Host_Contactno,Amount});
        					
        	}
			result.close();
	    	statement.close();
            connection.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	        table.setModel(model);
			JScrollPane scrollPane = new JScrollPane(table);
		    scrollPane.setBounds(50,150, 900, 150);
		    background7.add(scrollPane);
	}
	
	public void RefreshTable()
	{
		 try
		    {
		    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
				Statement statement = connection.createStatement();
				
				String sql1="SELECT * FROM TourDetails";
				System.out.println(sql1);
				ResultSet result = statement.executeQuery(sql1);
				table.setModel(DbUtils.resultSetToTableModel(result));
				
	    	   statement.close();
               connection.close();
		   }
		   catch(Exception ex)
		   {
				JOptionPane.showMessageDialog(null,ex);
		   }	
	}
	
	public void UpdateForm() 
	{
		//UPDATE DETAILS
		frame6=new JFrame("   Dreamy Travels");
//		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setSize(1400,750);
		frame6.setLayout(null);
		
		//Background Image
		ImageIcon icon6=new ImageIcon("details.jpg");
		JLabel background6=new JLabel("",icon6,JLabel.CENTER);
		background6.setBounds(0, 0, 1400,750);
		frame6.getContentPane().add(background6);
		
		//JPanel transparent
		rectangle6 = new JPanel();
		rectangle6.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgb-alpha)
		rectangle6.setBounds(50, 50, 1250, 650);
		rectangle6.setLayout(null);
		background6.add(rectangle6);
				
		//Centre Heading
		JLabel Udetails = new JLabel ("*Tour Details*");
		Udetails.setBounds(400, 50,600 ,50);
		Udetails.setForeground(Color.WHITE); //for adding color to the text
		Udetails.setFont(new Font("New Roman Times",Font.BOLD,59));
		Udetails.setLayout(new FlowLayout(FlowLayout.CENTER));
		rectangle6.add(Udetails);					
		 
		//ID
		JLabel UPkg_id=new JLabel("Package Id");
		UPkg_id.setBounds(100, 125, 100, 25);
		UPkg_id.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		UPkg_id.setForeground(Color.WHITE); 
		rectangle6.add(UPkg_id);
		
		UPkgId=new JTextField();
		UPkgId.setBounds(200, 125, 150, 25);
		rectangle6.add(UPkgId);
			 
		
		//NAME OF PACKAGE
		JLabel UPkg_name=new JLabel("Package Name");
		UPkg_name.setBounds(100, 175, 100, 25);
		UPkg_name.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		UPkg_name.setForeground(Color.WHITE); 
		rectangle6.add(UPkg_name);
				 
		UPkgName=new JTextField();
		UPkgName.setBounds(200,175, 150, 25);
		rectangle6.add(UPkgName);
		
		
		//TYPE OF PACKAGE
		JLabel UPkg_type=new JLabel("Package Type");
		UPkg_type.setBounds(100, 225, 100, 25);
		UPkg_type.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		UPkg_type.setForeground(Color.WHITE); 
		rectangle6.add(UPkg_type);					 
		
		Utype_international = new JRadioButton("International");
		Utype_international.setBounds(200, 225, 100, 25);
		Utype_international.setBackground(Color.WHITE);
		rectangle6.add(Utype_international);
				 
		Utype_domestic = new JRadioButton("Domestic");		
		Utype_domestic.setBounds(350, 225, 100, 25);
		Utype_domestic.setBackground(Color.WHITE);
		rectangle6.add(Utype_domestic);
					
		ButtonGroup Urb_group = new ButtonGroup();
		Urb_group.add(Utype_international);
		Urb_group.add(Utype_domestic);
				 
				 
		//LOCATION OF PACKAGE
		JLabel Utour_location=new JLabel("Tour Location");
		Utour_location.setBounds(100, 275, 100, 25);
		Utour_location.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		Utour_location.setForeground(Color.WHITE); 
		rectangle6.add(Utour_location);
				 
		 String[] Ulocations= {"Pakistan,Ghizer Valley(GB)","Pakistan,Ayubia(Abbtoabad)",
                 "Pakistan,Hawksbay(Karachi)","Pakistan,Badshahi Mosque(Lahore)",
                 "Pakistan,Gard Port(Karachi)","Pakistan,Shah-e-Qila(Lahore)",
                 "Pakistan,Noor Mahal(Bahawalpur)","Pakistan,Pak-China Border(Karakoram)",
                 "Pakistan,Abdullah Shah Ghazi Tomb(Karachi)",
                 "Turkey,Blue Mosque(Istanbul)","Maldives,Thulhagiri Island ",
                 "UAE,Dubai","UK,Buckingham Palace(London)","USA,Los Angles",
                 "Switzerland,Lucerne","Greece,Athens","Turkey,Anatalia",
                 "USA,Waikiki Beach(Hawaii)","Switzerland,Loin Monument"
               };
		 Uloclist=new JComboBox<String>(Ulocations);
		 Uloclist.setSelectedIndex(-1);
		 Uloclist.setBounds(200, 275, 225, 25);
		 rectangle6.add(Uloclist);
		         
				 
		//DATE OF DEPARTURE
		JLabel Udepart_day=new JLabel("Departure Day");
		Udepart_day.setBounds(100, 325, 100, 25);
		Udepart_day.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		Udepart_day.setForeground(Color.WHITE); 
		rectangle6.add(Udepart_day);
				 
		dateChooser = new JDateChooser(); 
		dateChooser.setBounds(200, 325, 225, 25);
		rectangle6.add(dateChooser);
		 
		
		//TIME PERIOD OF TOUR
		JLabel Uduration=new JLabel("Tour Duration");
		Uduration.setBounds(100, 375, 100, 25);
		Uduration.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		Uduration.setForeground(Color.WHITE); 
		rectangle6.add(Uduration);
		
		Us = new JSpinner(); 
		Us.setBounds(200, 375, 75, 25);
		rectangle6.add(Us);
				 
		JLabel Udays=new JLabel("days");
		Udays.setBounds(300, 375, 100, 25);
		Udays.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		Udays.setForeground(Color.WHITE); 
		rectangle6.add(Udays);
		
		
		//DESCRIPTION OF TOUR
		JLabel Utour_desc=new JLabel("Tour Description");
		Utour_desc.setBounds(150, 450, 125, 25);
		Utour_desc.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		Utour_desc.setForeground(Color.WHITE); 
		rectangle6.add(Utour_desc);
				 
		Utourdesc=new JTextArea();
		Utourdesc.setBounds(300, 425, 300, 100);
		rectangle6.add(Utourdesc);
				 
		JScrollPane Uscroller = new JScrollPane(Utourdesc);
		Uscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		Uscroller.setBounds(300, 425, 300, 100);
		rectangle6.add(Uscroller);
		
		
		//Updating Host name
		JLabel UHost_name=new JLabel("Tour HostName");
		UHost_name.setBounds(700, 125, 100, 25);
		UHost_name.setForeground(Color.WHITE); 
		UHost_name.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		rectangle6.add(UHost_name);
				
		Utf_hostN=new JTextField();
		Utf_hostN.setBounds(850, 125, 150, 25);
		rectangle6.add(Utf_hostN);
		
		
		//Count of family member
		JLabel UNoof_members=new JLabel("No of Family Members");
		UNoof_members.setBounds(700, 175, 150, 25);
		UNoof_members.setForeground(Color.WHITE); 
		rectangle6.add(UNoof_members);
		
		 Us1 = new JSpinner();
		Us1.setBounds(850, 175, 100, 25);
		rectangle6.add(Us1);

				 
		//Email		 
		JLabel Uemail=new JLabel("Email");
		Uemail.setBounds(700, 225, 100, 25); 
		Uemail.setForeground(Color.WHITE); 
		Uemail.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		rectangle6.add(Uemail);
		
		Utf_email=new JTextField();
		Utf_email.setBounds(850, 225, 150, 25);
		rectangle6.add(Utf_email);
		
		
		//Contact number
		JLabel Ucontactno=new JLabel("Host ContactNo.");
		Ucontactno.setBounds(700, 275, 100, 25);
		Ucontactno.setForeground(Color.WHITE); 
		Ucontactno.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		rectangle6.add(Ucontactno);
		
		Utf_contactNo=new JTextField();
		Utf_contactNo.setBounds(850, 275, 150, 25);
		rectangle6.add(Utf_contactNo);
			 
		
		//Total Amount
		JLabel UTotal_amount=new JLabel("Total Amount Rs.");
		UTotal_amount.setBounds(700, 325, 150, 25);
		UTotal_amount.setForeground(Color.WHITE); 
		UTotal_amount.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		rectangle6.add(UTotal_amount);
				  
		Uamount=new JTextField(); 
		Uamount.setBounds(850, 325, 150, 25);
		rectangle6.add(Uamount);
		  
        //Buttons
		JButton Usubmit=new JButton("Update Package");
		Usubmit.setBounds(750, 500, 175, 50);
		Usubmit.setFont(new Font("Calibri",Font.BOLD,20));
		rectangle6.add(Usubmit);
			
		JButton Ucancel=new JButton("Cancel");
		Ucancel.setBounds(975, 500, 175, 50);
		Ucancel.setFont(new Font("Calibri",Font.BOLD,20));
		rectangle6.add(Ucancel);
	
		//Adding Action Listeners
		Usubmit.addActionListener(this);
		Ucancel.addActionListener(this);

		rectangle6.setOpaque(true);
		frame6.setVisible(true);
	}
			
	
		public void actionPerformed(ActionEvent e)
		{	
			if(e.getActionCommand()=="Get Data")
			{	
				PackageDetails Pkg_detail = new PackageDetails();
				Pkg_detail.setId(Integer.parseInt(list.getSelectedItem().toString()));
				
							UpdateForm() ;
						try
					    {
					    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
							Statement statement = connection.createStatement();
							
							String sql = "SELECT *FROM  TourDetails   WHERE Package_Id= '"+Pkg_detail.getId()+"'";
							System.out.println(sql);
				            
				            ResultSet rs = statement.executeQuery(sql);
				            while (rs.next()) 
					        	{
				            	
				           	      UPkgId.setText(String.valueOf(rs.getInt("Package_Id")));
				           	      UPkgName.setText(rs.getString("Package_Name"));
				           	    
				           	      String type=rs.getString("Package_Type");
				           	      if(type.equals("International"))  
				           	    	{
				           	    	  Utype_international.setSelected(true);
				           	          Utype_domestic.setSelected(false);
				           	    	}
					           	   else if(type.equals("Domestic"))  
					           	   {
					           		  Utype_international.setSelected(false);
				           	          Utype_domestic.setSelected(true);
					           	   }
				           	      
					         	   String Location=rs.getString("Location");
					        	   Uloclist.setSelectedItem(Location);
						   		   SimpleDateFormat date =  new SimpleDateFormat("yyyy-MM-dd");
						   		   dateChooser.setDate(date.parse(rs.getString("Departure_Date")));						 
								   Us.setValue(rs.getInt("Duration"));
								   Utourdesc.setText(rs.getString("Tour_Description"));
								   Utf_hostN.setText(rs.getString("Host_Name"));
								   Us1.setValue(rs.getInt("No_of_FamilyMembers"));
								   Utf_email.setText(rs.getString("Email_Id"));
						           Utf_contactNo.setText(rs.getString("Host_Contactno"));
						           Uamount.setText(rs.getString("Amount"));
						    
					        	  }
				            
				            rs.close();	
				            statement.close();
				            connection.close();
				            
					    }
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,ex);
							System.out.println(ex);
						}
						
					
			}
			else if(e.getActionCommand()=="Exit")
			{
				frame7.dispose();
			}
			
			 if(e.getActionCommand()=="Update Package")
			{
				int ID=Integer.parseInt(list.getSelectedItem().toString());
				
			int id=(Integer.parseInt(UPkgId.getText()));
			String name=UPkgName.getText();
			
			String type = "";
			if(Utype_international.isSelected())
				type=Utype_international.getText();
			else if(Utype_domestic.isSelected())
				type=Utype_domestic.getText();
			
			String location=Uloclist.getSelectedItem().toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String depature_date=(sdf.format(dateChooser.getDate()));
			int duration=(Integer.parseInt(Us.getValue().toString()));
			String description=Utourdesc.getText();
			String host_name=Utf_hostN.getText();
			int members=(Integer.parseInt(Us1.getValue().toString()));
			String email=Utf_email.getText();
			String contactno=Utf_contactNo.getText();
			String amount=Uamount.getText();

			try
		    {
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
				Statement statement = connection.createStatement();
				
				String sql = "UPDATE  TourDetails  SET Package_Id= "+id+",Package_Name= '"+name+"',Package_Type= '"
								+type+"',Location= '"+location+"',Departure_Date= '"+depature_date
								+"',Duration= "+duration+",Tour_Description= '"+description
								+"',Host_Name= '"+host_name+"',No_of_FamilyMembers= "+members+",Email_Id= '"
								+email+"',Host_Contactno= '"+contactno+"',Amount='"+amount+"' WHERE Package_Id= '"+ID+"'";		
				
				 System.out.println(sql);
	             statement.executeUpdate(sql);   
				
				JOptionPane.showMessageDialog(null,"A Package has been updated successfully." );
				
				statement.close();
				connection.close();		
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex);
				System.out.println(ex);
			}
			
			RefreshTable();		
		}
		else if(e.getActionCommand()=="Cancel")
		{
			frame6.dispose();
		}
	}
		
	public static void main(String[] args) 
	{
		new UpdateTourDetailsClass();
	}
}

					