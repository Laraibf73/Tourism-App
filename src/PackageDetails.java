
public class PackageDetails {

	private int Package_id;
	private String Package_name;
	private String Package_type;
	private String Email;
	private String Location;
	private int No_of_FamilyMembers;
	private String Host_name;
	private String Host_Contactno;
	private String Departure_Day;
	private String Amount;
	private int Duration;
	private String Tour_Description;
	
	
	public void setId(int id)
	{
		Package_id=id;
	}
	public int getId()
	{
		return Package_id;
	}
	public void setPkgname(String name)
	{
		Package_name=name;
	}
	public String getPkgname()
	{
		return Package_name;
	}
	public void setPkgType(String type)
	{
		Package_type=type;
	}
	public String getPkgType()
	{
		return Package_type;
	}
	public void setLocation(String location)
	{
		Location=location;
	}
	public String getLocation()
	{
		return Location;
	}
	public void setEmail(String email)
	{
		Email=email;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setMembers(int familymembers)
	{
		No_of_FamilyMembers=familymembers;
	}
	public int getFamilyMembers()
	{
		return No_of_FamilyMembers;
	}
	public void setHostname(String H_name)
	{
		Host_name=H_name;
	}
	public String getHname()
	{
		return Host_name;
	}
	public void setHcontact(String contactNo)
	{
		Host_Contactno=contactNo;
	}
	public String getcontactNo()
	{
		return Host_Contactno;
	}
	public void setDay(String departday)
	{
		Departure_Day=departday;
	}
	public String getDepartDay()
	{
		return Departure_Day;
	}
	public void setAmount(String amount)
	{
		Amount=amount;
	}
	public String getAmount()
	{
		return Amount;
	}
	public void setDuration(int timeperiod)
	{
		Duration=timeperiod;
	}
	public int getDuration()
	{
		return Duration;
	}
	public void setDescription(String desc)
	{
		Tour_Description=desc;
	}
	public String getDescription()
	{
		return Tour_Description;
	}
	public String toString()
	{
		String str ="Pkg Id: "+Package_id+"\n"+ 
				    "Name: " + Package_name + "\n" + 
					"Pkg type: " +Package_type+"\n"+
					"Location: " + Location + "\n" + 
					"No_of_FamilyMembers: " + No_of_FamilyMembers  + "\n" + 
					"Email: "+Email+"\n"+ 
				    "Host_name: " + Host_name + "\n" + 
					"Host_Contactno: " +Host_Contactno+"\n"+
					"Departure_Day: " + Departure_Day + "\n" + 
					"Amount: " + Amount  + "\n" + 
					"Duration: "+Duration+"\n"+ 
					"Tour_Description: " + Tour_Description + "\n" ;

	
		return str;
	}
	
}
