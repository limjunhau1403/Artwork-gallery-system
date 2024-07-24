
public class Artwork {
	private String artId;
	private String artName;
	private String datePurchased;
	private String dateSold;
	private String availability;
	private String artistName;
	private String customerName;
	
	private Inventory price;
	
	public Inventory getPrice()
	{
		return price;
	}
	
	public void setSellingPrice(double sellingPrice)
	{
		price.setSellingPrice(sellingPrice);
		
	}
	
	public void setPurchasePrice(double purchasePrice)
	{	
		price.setPurchasePrice(purchasePrice);
	}
	
	public String getArtID()
	{
		return artId;
	}
	
	public String getArtName()
	{
		return artName;
	}
	
	
	public String getArtistName()
	{
		return artistName;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	public String getDateSold()
	{
		return dateSold;
	}
	
	public String getDatePurchased()
	{
		return datePurchased;
	}
	
	public String getAvailability()
	{
		return availability;
	}
	
	public void setArtID(String artId)
	{
		this.artId = artId;
	}
	
	public void setArtName(String artName)
	{
		this.artName = artName;
	}
	public void setDatePurchased(String datePurchased)
	{
		this.datePurchased = datePurchased;
	}
	
	public void setAvailability(String availability)
	{
		this.availability = availability;
	}
	public void setDateSold(String dateSold)
	{
		this.dateSold = dateSold;
	}
	public void setArtistName(String artistName)
	{
		this.artistName = artistName;
	}
	
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public Artwork (String artId, String artName,String datePurchased,String availability,String dateSold
			, String artistName,String customerName, Inventory price)
	{
		this.artId = artId;
		this.artName = artName;
		this.datePurchased = datePurchased;
		this.dateSold =dateSold;
		this.availability = availability;
		this.artistName = artistName;
		this.customerName = customerName;
		this.price = price;
	}
}
