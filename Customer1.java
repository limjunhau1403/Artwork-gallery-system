import java.util.Scanner;
public class Customer1 extends Person{

	private String artistPreference;
	

	
	static Scanner sc = new Scanner(System.in);
	
	public Customer1(String customerId, String name, String hpnumber)
	{
		super(customerId,name,hpnumber);
	}
	
	public String getArtistPreference()
	{
		return artistPreference;
	}
	
	public void setArtistPreference(String artistPreference)
	{
		this.artistPreference = artistPreference;
	}

}
