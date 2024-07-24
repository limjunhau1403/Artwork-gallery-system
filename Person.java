import java.util.ArrayList;
public class Person {
	private String name;
	private String hpnumber;
	private String id;
	private ArrayList <Artwork> artworkList;
	
	public Person( String id, String name, String hpnumber)
	{
		this.name = name;
		this.hpnumber = hpnumber;
		this.id = id;
		artworkList = new ArrayList<Artwork>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getHpnumber()
	{
		return hpnumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setHpnumber(String hpnumber)
	{
		this.hpnumber = hpnumber;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	
	public void recordArtwork(Artwork artwork)
	{
		artworkList.add(artwork);
	}
	
	public void updateArtwork(int num, Artwork artwork)
	{
		artworkList.set(num, artwork);
	}
	
	public int getNumberOfArtwork()
	{
		return artworkList.size();
	}
	
	public Artwork findArtwork(String artName)
	{
		Artwork artwork = null;
		
		boolean found = false;
		
		int i =0;
		 int count = getNumberOfArtwork();
		
		 while( i < count && ! found )
		 {
			 artwork = artworkList.get(i);
			 if (artwork.getArtName().equals(artName))
				 	found =true;
			  else 
				  i++;
		  }
		  
		  if(found)
			  return artwork;
		  else
			  return null;
	}
	
	public Artwork[] getArrList()
	{
	 int count = artworkList.size();
	 
	 Artwork[] list = new Artwork[count];
	 
	 list = artworkList.toArray(list);
	 
	 return list;
	 }
	
	public void deleteArtwork( Artwork art)
	{
		artworkList.remove(art);
	}
}
