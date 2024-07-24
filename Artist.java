
public class Artist extends Person {

	private String specialty;
	private String status;
	private double priceRangeMax;
	private double priceRangeMin;

	
	public Artist(String artistID, String name, String specialty, String hpnumber, String status)
	{
		super(artistID,name,hpnumber);
		
		this.specialty = specialty;
		
		this.status = status;
	
	}
	
	
	public String getSpecialty()
	{
		return specialty;
	}
	
	
	public String getStatus()
	{
		return status;
	}
	
	public double getPriceRangeMax()
	{
		return priceRangeMax;
	}
	
	public double getPriceRangeMin()
	{
		return priceRangeMin;
	}
	
	
	public void setSpecialty(String specialty)
	{
		this.specialty = specialty;
	}
	
	public void setPriceRangeMax(Double priceRangeMax)
	{
		this.priceRangeMax = priceRangeMax;
	}
	
	public void setPriceRangeMin(Double priceRangeMin)
	{
		this.priceRangeMin = priceRangeMin;
	}
	
	public void setStatus (String status)
	{
		this.status = status;
	}
}
