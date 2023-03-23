import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class MenuOption implements ActionListener
{
	JFrame frame2;
	MenuOption()
	{
		frame2=new JFrame("   Dreamy Travels");
		frame2.setSize(600,340);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(null);
		
		//Adding Background
		ImageIcon icon2=new ImageIcon("Menu.jpg");
		JLabel background2=new JLabel("",icon2,JLabel.CENTER);
		background2.setBounds(0, 0, 600, 340);
		frame2.getContentPane().add(background2);
		
		//Adding main label
		JLabel menu = new JLabel ("Select Option");
		menu.setBounds(250, 5,300 ,75);
		menu.setFont(new Font("Algerian",Font.ITALIC,40));
		background2.add(menu);
		
		//Adding buttons
		JButton add_details=new JButton("Add Tour Details");
		add_details.setBounds(300, 75, 150, 40);
		background2.add(add_details);
		
		JButton update_details=new JButton("Update Tour Details");
		update_details.setBounds(300, 120, 150, 40);
		background2.add(update_details);
		
		JButton delete_package=new JButton("Delete Package");
		delete_package.setBounds(300, 165, 150, 40);
		background2.add(delete_package);

		JButton search_package=new JButton("Search Package");
		search_package.setBounds(300, 210, 150, 40);
		background2.add(search_package);
		
		//Adding Action Listeners
		add_details.addActionListener(this);
		update_details.addActionListener(this);
		delete_package.addActionListener(this);
		search_package.addActionListener(this);
		
		
	frame2.setVisible(true);
	
   }
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == "Add Tour Details")
		{
			new AddTourDetailsClass();
		}
		else if(e.getActionCommand() == "Update Tour Details")
		{
			new UpdateTourDetailsClass();
			
		}
		else if(e.getActionCommand() == "Delete Package")
		{
			new DeleteClass();
		}
		else if(e.getActionCommand() == "Search Package")
		{
			new SearchClass();
		}	
	}
	
	
	public static void main(String[] args) {
		new MenuOption();
	}

}
