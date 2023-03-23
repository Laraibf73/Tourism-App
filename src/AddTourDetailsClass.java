import javax.swing.*;                
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
 
public class AddTourDetailsClass implements ActionListener
{

	 JFrame frame5;
     JTextField PkgId;
	 JTextField PkgName;
	 JRadioButton type_international;
	 JRadioButton type_domestic;
	 JComboBox<String> loclist;
	 JDateChooser dateChooser;
	 JSpinner s;
	 JTextArea TourDesc;
	 JTextField tf_hostN;
	 JSpinner s1 ;
	 JTextField tf_email;
	 JTextField tf_contactNo;;
	 JComboBox<String> Alist;
	 JSpinner s2;
	 
	AddTourDetailsClass()
	{
		//Add Tour Details
	    frame5=new JFrame("   Dreamy Travels");
		frame5.setSize(1400,750);
//		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		//Background Image
		ImageIcon icon5=new ImageIcon("details.jpg");
		JLabel background5=new JLabel("",icon5,JLabel.CENTER);
		background5.setBounds(0, 0, 1400,750);
		frame5.getContentPane().add(background5);
		
		//JPanel transparent
		JPanel rectangle5 = new JPanel();
		rectangle5.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgba)
		rectangle5.setBounds(50, 50, 1250, 650);
		rectangle5.setLayout(null);
		background5.add(rectangle5);
		
		
		//Centre Heading
		JLabel details = new JLabel ("*Add Tour Details*");
		details.setBounds(325, 50,600 ,50);
		details.setForeground(Color.WHITE); //for adding color to the text
		details.setFont(new Font("New Roman Times",Font.BOLD,50));
		details.setLayout(new FlowLayout(FlowLayout.CENTER));
		rectangle5.add(details);
	
		
		//ID OF PACKAGE
		 JLabel Pkg_id=new JLabel("Package Id");
		 Pkg_id.setBounds(100, 125, 100, 25);
		 Pkg_id.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 Pkg_id.setForeground(Color.WHITE); 
		 rectangle5.add(Pkg_id);
		 
		 PkgId=new JTextField();
		 PkgId.setBounds(200, 125, 150, 25);
		 rectangle5.add(PkgId);
		 
		 
		 //NAME OF PACKAGE
		 JLabel Pkg_name=new JLabel("Package Name");
		 Pkg_name.setBounds(100, 175, 100, 25);
		 Pkg_name.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 Pkg_name.setForeground(Color.WHITE); 
		 rectangle5.add(Pkg_name);
		 
		 PkgName=new JTextField();
		 PkgName.setBounds(200, 175, 150, 25);
		 rectangle5.add(PkgName);
		 
		 //TYPE OF PACKAGE
		 JLabel Pkg_type=new JLabel("Package Type");
		 Pkg_type.setBounds(100, 225, 100, 25);
		 Pkg_type.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 Pkg_type.setForeground(Color.WHITE); 
		 rectangle5.add(Pkg_type); 
		 
		 type_international = new JRadioButton("International");
		 type_international.setBounds(200, 225, 100, 25);
		 rectangle5.add(type_international);
		 
		 type_domestic = new JRadioButton("Domestic");	
		 type_domestic.setBounds(350, 225, 100, 25);
		 rectangle5.add(type_domestic);

			ButtonGroup rb_group = new ButtonGroup();
			rb_group.add(type_international);
			rb_group.add(type_domestic);
		 
		 
		 //LOCATION OF PACKAGE
		 JLabel tour_location=new JLabel("Tour Location");
		 tour_location.setBounds(100, 275, 100, 25);
		 tour_location.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 tour_location.setForeground(Color.WHITE); 
		 rectangle5.add(tour_location);
		 
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
         loclist.setBounds(200, 275, 225, 25);
         rectangle5.add(loclist);
		 
		 
		 //DATE OF DEPARTURE
         JLabel depart_day=new JLabel("Departure Day");
		 depart_day.setBounds(100, 325, 100, 25);
		 depart_day.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 depart_day.setForeground(Color.WHITE); 
		 rectangle5.add(depart_day);
		 
		 dateChooser = new JDateChooser();
		 dateChooser.setBounds(200, 325, 225, 25);
		 rectangle5.add(dateChooser);
		 
		  
		 
		 //TIME PERIOD OF TOUR
		 JLabel duration=new JLabel("Tour Duration");
		 duration.setBounds(100, 375, 100, 25);
		 duration.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 duration.setForeground(Color.WHITE); 
		 rectangle5.add(duration);
		 
		 s = new JSpinner();
		 s.setBounds(200, 375, 75, 25);
		 rectangle5.add(s);
		 
		 JLabel days=new JLabel("days");
		 days.setBounds(300, 375, 100, 25);
		 days.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 days.setForeground(Color.WHITE); 
		 rectangle5.add(days);
		 
		 
		 //DESCRIPTION OF TOUR
		 JLabel tour_desc=new JLabel("Tour Description");
		 tour_desc.setBounds(150, 450, 125, 25);
		 tour_desc.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 tour_desc.setForeground(Color.WHITE); 
		 rectangle5.add(tour_desc);

		 TourDesc=new JTextArea();
		 TourDesc.setBounds(300, 425, 300, 100);
		 
		 JScrollPane scroller = new JScrollPane(TourDesc);
		 scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		 scroller.setBounds(300, 425, 300, 100);
		 rectangle5.add(scroller);
		 
		 
		 //Adding Host name
		 JLabel Host_name=new JLabel("Tour HostName");
		 Host_name.setBounds(700, 125, 100, 25);//700, 125, 100, 25
		 Host_name.setForeground(Color.WHITE); 
		 Host_name.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 rectangle5.add(Host_name);
		
		 tf_hostN=new JTextField();
		 tf_hostN.setBounds(850, 125, 150, 25);
		 rectangle5.add(tf_hostN);
		 
		 
		 //Adding count of family member

		 JLabel noof_members=new JLabel("No of Family Members");
		 noof_members.setBounds(700, 175, 150, 25);
		 noof_members.setForeground(Color.WHITE); 
		 rectangle5.add(noof_members);
		 
		 s1 = new JSpinner();
		 s1.setBounds(850, 175, 100, 25);
		 rectangle5.add(s1);
		 
		 
		//Entering E-mail
		 JLabel email=new JLabel("Email");
		 email.setBounds(700, 225, 100, 25);
	     email.setForeground(Color.WHITE); 
	     email.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 rectangle5.add(email);
		 
		  tf_email=new JTextField();
		 tf_email.setBounds(850, 225, 150, 25);
		 rectangle5.add(tf_email);

         
		 //Adding host Contact no
		 JLabel contactno=new JLabel("Host ContactNo.");
		 contactno.setBounds(700, 275, 100, 25);
		 contactno.setForeground(Color.WHITE); 
		 contactno.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 rectangle5.add(contactno);

		  tf_contactNo=new JTextField();
		 tf_contactNo.setBounds(850, 275, 150, 25);
		 rectangle5.add(tf_contactNo);
		 
		 
		 //Adding total amount
		 JLabel Total_amount=new JLabel("Total Amount Rs.");
		 Total_amount.setBounds(700, 325, 150, 25);
		 Total_amount.setForeground(Color.WHITE); 
		 Total_amount.setFont(new Font("Calibri",Font.CENTER_BASELINE,15));
		 rectangle5.add(Total_amount);
		 
		 s2 = new JSpinner();
		 s2.setBounds(850, 325, 50, 25);
		 rectangle5.add(s2);
		 
		  
		 Alist=new JComboBox<String>();
		 Alist.addItem("Thousands");
		 Alist.addItem("Lacs");
	     Alist.setBounds(925, 325, 95, 25);
	     rectangle5.add(Alist);
		 

	     //Adding buttons
	     JButton submit=new JButton("Add Package");
	     submit.setBounds(800, 500, 150, 50);
	     submit.setFont(new Font("Calibri",Font.BOLD,20));
	 	 rectangle5.add(submit);
	
	 	JButton cancel=new JButton("Cancel");
	 	cancel.setBounds(975, 500, 150, 50);
	 	cancel.setFont(new Font("Calibri",Font.BOLD,20));
	 	rectangle5.add(cancel);
	 	
	 	//Adding action listeners
	 	submit.addActionListener(this);
	 	cancel.addActionListener(this);
	 	
	 	
	 frame5.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="Add Package")
		{
			PackageDetails Pkg_detail = new PackageDetails();
	
			Pkg_detail.setId(Integer.parseInt(PkgId.getText()));
			Pkg_detail.setPkgname(PkgName.getText());
			
			String T = "";
			if(type_international.isSelected())
				T="International";
			else if(type_domestic.isSelected())
				T="Domestic";
				
			Pkg_detail.setPkgType(T);
			Pkg_detail.setLocation(loclist.getSelectedItem().toString());
			Pkg_detail.setMembers(Integer.parseInt(s1.getValue().toString()));
			Pkg_detail.setEmail(tf_email.getText());
			Pkg_detail.setHostname(tf_hostN.getText());
			Pkg_detail.setHcontact(tf_contactNo.getText());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Pkg_detail.setDay(sdf.format(dateChooser.getDate()));
			Pkg_detail.setDuration(Integer.parseInt(s.getValue().toString()));
			Pkg_detail.setDescription(TourDesc.getText());
			Pkg_detail.setAmount(Integer.parseInt(s2.getValue().toString())+Alist.getSelectedItem().toString());
			
			try
			{
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
				Statement statement = connection.createStatement();
	        	
				String sql = "INSERT INTO TourDetails (Package_Id,Package_Name,Package_Type,Location,Departure_Date,Duration,Tour_Description,Host_Name,No_of_FamilyMembers,Email_Id,Host_Contactno,Amount) VALUES (" +Pkg_detail.getId() +", '"+ Pkg_detail.getPkgname()+"', '" 
						      + Pkg_detail.getPkgType()+"', '" + Pkg_detail.getLocation()+"', '"
						      +Pkg_detail.getDepartDay()+"', "+Pkg_detail.getDuration()+", '"
						      +Pkg_detail.getDescription()+"', '"+Pkg_detail.getHname()+"', "
						      +Pkg_detail.getFamilyMembers()+", '"+Pkg_detail.getEmail()+"', '"
						      +Pkg_detail.getcontactNo()+"', '"+Pkg_detail.getAmount()+"')";
						
				System.out.println(sql);
				
	            int row = statement.executeUpdate(sql);
	            
	            
	            if (row > 0) 
	            {
	            	JOptionPane.showMessageDialog(null,"A Package has been inserted successfully." );
	                
	            }
	           
				statement.close();
	            connection.close();
			}
			
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex);
			}


		}
		else if(e.getActionCommand()=="Cancel")
		{
			frame5.dispose();
		}
		
	}
	public static void main(String[] args) 
	{
		new AddTourDetailsClass();
	}
}
