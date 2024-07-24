
public class Inventory {
	private double sellingPrice;
	private double purchasePrice;
	
	public Inventory(double sellingPrice, double purchasePrice)
	{
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		
	}
	
	public double getSellingPrice()
	{
		return sellingPrice;
	}
	
	public double getPurchasePrice()
	{
		return purchasePrice;
	}
	
	public void setSellingPrice(double sellingPrice)
	{
		this.sellingPrice = sellingPrice;
	}
	
	public void setPurchasePrice(double purchasePrice)
	{
		this.purchasePrice = purchasePrice;
	}
}
