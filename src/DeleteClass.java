
import javax.swing.*;                 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class DeleteClass implements ActionListener
{
	JFrame frame4;
	JLabel background4;
	JPanel rectangle4 = new JPanel();
	JPanel rectangle4a=new JPanel();
	JTable table = new JTable();
	JTable tableUpdate = new JTable();
	
	DeleteClass()
	{
		//Delete package 
		 frame4=new JFrame("   Dreamy Travels");
		frame4.setSize(1500,800);
	//	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setLayout(null);
		
		
		//Background Image
		ImageIcon icon4=new ImageIcon("details.jpg");
		background4=new JLabel("",icon4,JLabel.CENTER);
		background4.setBounds(0, 0, 1500, 800);
		frame4.getContentPane().add(background4);
		
		//Panel 1
		rectangle4.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgba)
		rectangle4.setBounds(50, 50, 400, 500);
		rectangle4.setLayout(null);
		background4.add(rectangle4);
		
		//Panel 2
		rectangle4a.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f)); //alpha values of color.(rgba)
		rectangle4a.setBounds(500, 50, 800, 500);
		rectangle4a.setLayout(null);
		background4.add(rectangle4a);
		
		JLabel Tour_table=new JLabel("Tour Packages");
		Tour_table.setBounds(75, 75, 250, 50);
		Tour_table.setFont(new Font("Calibri",Font.BOLD,35));
		Tour_table.setForeground(Color.white);
		rectangle4a.add(Tour_table);
		
		
	    JButton delete=new JButton("Delete");
	    delete.setBounds(100, 150, 200, 50);
	    delete.setFont(new Font("Calibri",Font.BOLD,20));
	    rectangle4.add(delete);
		
		JButton cancel4=new JButton("Cancel");
		cancel4.setBounds(100, 250, 200, 50);
		cancel4.setFont(new Font("Calibri",Font.BOLD,20));
		rectangle4.add(cancel4);
		
		
		delete.addActionListener(this);
		cancel4.addActionListener(this);
		
		JLabel note=new JLabel("*Note: Select the row to be deleted.");
		note.setBounds(100, 225, 250, 100);
		note.setForeground(Color.WHITE);
		rectangle4a.add(note);
		
		Display_Table();
			
		frame4.setVisible(true);
			
	}
	public void Display_Table()
	{
		DefaultTableModel model = new DefaultTableModel(0,0);
		String headings[] =  {"Id", "Name","Type", "Location", "Departureday","Duration","Description","HName","Family Members","EmailId","HContactno","Amount"};
		model.setColumnIdentifiers(headings);
		
	    try
	    {
	    	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
			Statement statement = connection.createStatement();	
			
			String sql1="SELECT* FROM TourDetails";
			System.out.println(sql1);
			ResultSet rs1 = statement.executeQuery(sql1);
			while (rs1.next()) 
        	{
				int Package_Id=rs1.getInt("Package_Id");          
				String Package_Name=rs1.getString("Package_Name");
				String Package_Type=rs1.getString("Package_Type");
				String Location=rs1.getString("Location");
				String Departure_Date=rs1.getString("Departure_Date");
				int Duration=rs1.getInt("Duration");
				String Tour_Description=rs1.getString("Tour_Description");
				String Host_Name=rs1.getString("Host_Name");
				int No_of_FamilyMembers=rs1.getInt("No_of_FamilyMembers");
				String Email_Id=rs1.getString("Email_Id");
				String Host_Contactno=rs1.getString("Host_Contactno");
				String Amount=rs1.getString("Amount");
				
			   /* System.out.println(Package_Id+","+Package_Name+","+Package_Type
			    		           +","+Location+","+Departure_Date+","+Duration+","
			    		           +Tour_Description+","+Host_Name+","+No_of_FamilyMembers
			    		           +","+Email_Id+","+Host_Contactno+","+Amount);*/
			    
				model.addRow(new Object[] {Package_Id, Package_Name,
											 Package_Type,Location,Departure_Date,
											 Duration,Tour_Description,Host_Name,
											 No_of_FamilyMembers,Email_Id,Host_Contactno,Amount});
        					
        	}
			
			rs1.close();
	    	statement.close();
            connection.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	    
	    table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(25, 150, 750, 100);
	    rectangle4a.add(scrollPane);
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
	
	public void actionPerformed(ActionEvent e)
	{
	    if(e.getActionCommand()=="Delete")
		{
	    	if(table.getSelectionModel().isSelectionEmpty())
	    		JOptionPane.showMessageDialog(null,"No row Selected");
	    	else
	    	{
				int row=table.getSelectedRow();
				System.out.println(row);
				String cell=table.getModel().getValueAt(row, 0).toString();
				String sql="Delete from TourDetails where Package_Id= "+ cell;
				try
				{
					Connection connection = DriverManager.getConnection("jdbc:ucanaccess://TourismDB.accdb");	  
					Statement statement = connection.createStatement();
				    System.out.println(sql);
					statement.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"A row has been deleted successfully." );
					
					RefreshTable();
	
					statement.close();
		            connection.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);
				}
	    	} 
		}
		else if(e.getActionCommand()=="Cancel")
			frame4.dispose();
	}
	public static void main(String[] args) {
		new DeleteClass();

	}

}

