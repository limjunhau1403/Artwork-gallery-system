import java.io.*;
import java.util.*;

public class Test2 {
	public static void main (String [] args)throws IOException, FileNotFoundException
	{
		
		ArrayList <Artist> artist = new ArrayList <Artist>();
		ArrayList <Customer1> customer = new ArrayList<Customer1>();
		ArrayList <Artwork> artwork= new ArrayList<Artwork>();
		
		Customer1 customer1 = null;
		Artist artist1 = null;
		Artwork artwork1 = null;

		
		int choice=0;
		int customerChoice=0;
		int artistChoice=0;
		int artworkChoice=0;
	
	
		Scanner sc = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
		
		
		
		String mainMenu = ("\nWelcome to UX Gallery System: \n"
				+ "Which data you want to access\n"
				+ "1. Customer\n"
				+ "2. Artist\n"
				+ "3. Art\n"
				+ "4. Exit");
		
		String customerMenu = ("What you want to do with customer data: \n"
				+"1. List\n"
				+"2. Add\n"
				+"3. Delete\n"
				+"4. Search\n"
				+"5. Modify\n"
				+"6. Exit");
		
		String artistMenu = ("What you want to do with artist data: \n"
				+"1. List\n"
				+"2. Add\n"
				+"3. Delete\n"
				+"4. Search\n"
				+"5. Modify\n"
				+"6. Exit");
		
		String artworkMenu = ("What you want to do with artwork data: \n"
				+"1. List\n"
				+"2. Add\n"
				+"3. Delete\n"
				+"4. Search\n"
				+"5. Modify\n"
				+"6. Exit");
		
		File cusFile = new File("customers.txt");
		Scanner inputFile = new Scanner(cusFile);
		
		while(inputFile.hasNext())
		{
			String cusId = inputFile.nextLine();

			String cusName = inputFile.nextLine();
			
			String hpNumber = inputFile.nextLine();
		
			customer.add(new Customer1(cusId,cusName,hpNumber));
			String artPreference= inputFile.nextLine();	
			for(int i =0; i < customer.size(); i ++)
			{
				if (customer.get(i).getName().equals(cusName))
						customer.get(i).setArtistPreference(artPreference);
			}
		} inputFile.close();
	
		
		File artFile = new File("artists.txt");
		Scanner inputFile2 = new Scanner(artFile);
		
		while(inputFile2.hasNext())
		{
			String artistId = inputFile2.nextLine();
		
			String artistName = inputFile2.nextLine();
			
			String hpNumber = inputFile2.nextLine();
			
			String specialty = inputFile2.nextLine();
			
			String status = inputFile2.nextLine();
			
			artist.add(new Artist(artistId,artistName,specialty, hpNumber, status));
			
			String min = inputFile2.nextLine();
			
			String max = inputFile2.nextLine();
			
			for(int i =0; i < artist.size(); i ++)
			{
				if (artist.get(i).getName().equals(artistName))
				{	
					double minPrice = Double.parseDouble(min);
					double maxPrice = Double.parseDouble(max);
					artist.get(i).setPriceRangeMax(maxPrice);
					artist.get(i).setPriceRangeMin(minPrice);
				}
			}
					
			}inputFile2.close();
			
				
							
					File artworkFile = new File("artworks.txt");
					Scanner inputFile3 = new Scanner(artworkFile);
					
					while(inputFile3.hasNext())
					{
						String artId = inputFile3.nextLine();
					
						String artName = inputFile3.nextLine();
						
						String datePurchased = inputFile3.nextLine();
					
						String dateSold = inputFile3.nextLine();
						
						String availability = inputFile3.nextLine();
						
						String artistName = inputFile3.nextLine();
						
						String customerName = inputFile3.nextLine();
						
						double sellingPrice = Double.parseDouble(inputFile3.nextLine());
						
						double purchasePrice = Double.parseDouble(inputFile3.nextLine());
						
						
						Inventory price1=new Inventory (sellingPrice,purchasePrice);
						Artwork artwork2 = new Artwork(artId,artName,datePurchased,availability, dateSold, artistName,customerName,price1);
						artwork.add(artwork2);
						
						if (availability.equals("No"))
						for(int i =0; i < customer.size(); i ++)
						{
							if (customer.get(i).getName().equals(customerName))
									customer.get(i).recordArtwork(artwork2);
						}
					
							for(int i =0; i < artist.size(); i ++)
							{
								if (artist.get(i).getName().equals(artistName))
										artist.get(i).recordArtwork(artwork2);
							}
						
						
					} inputFile3.close();
		
		
		
		boolean done = false;
		do {
			System.out.println(mainMenu);
			  System.out.print("Option: ");
			try
			{
			choice = Integer.parseInt(sc.nextLine());
			
			while(choice < 1 || choice >4) {
				System.out.print("\nError! Incorrect choice.\n");
		        System.out.println(mainMenu);
		        System.out.print("Option: ");
		        choice = Integer.parseInt(sc.nextLine());
		       
			}

			 done= true;
			}
			
			catch(NumberFormatException exception)
		     {
		    	 System.out.print("\nOnly Numbers ! Please try again");
		     }
			 System.out.println();
	
			 boolean cdone = false;
			 
			 
			switch(choice) {
			case 1: {
				
					
					
				
				do {
					int count = customer.size();
					 
					 Customer1[] list = new Customer1[count];
				 
					 list = customer.toArray(list);
					 
					 for (int i =0; i< customer.size(); i++)
						{
								int count1 = customer.get(i).getNumberOfArtwork();
								
								int [] fr = new int [count1];
								int visited = -1;
								int max =0;
								int num =0;
								
							if (count1 != 0)
							{
								for(int z = 0; z < count1; z++)
								{
									int count2 = 1;
									for(int j = z+1; j < count1; j++)
									{	
										if( customer.get(i).getArrList()[z].getArtID().equals( 
												customer.get(i).getArrList()[j].getArtID()))
										{
											count2 ++;
											fr[j]= visited;
										}
										
									}
									if(fr[z]!=visited)
										fr[z] =count2;
									
									if (fr[z] > max)
									{
										max = fr[z];
										num =z;
									}
									else if(max == fr[z])
									{
										max=0;
									}
								}
									
									if (max != 0)
									customer.get(i).setArtistPreference(customer.get(i).getArrList()[num].getArtistName());
									else
										customer.get(i).setArtistPreference("None");
							}
									if (count1 == 0)
									{
										customer.get(i).setArtistPreference("None");
									}
						}
					do {
						try 
					{
						
					System.out.println(customerMenu);
					  System.out.print("Option: ");
					  customerChoice = Integer.parseInt(sc.nextLine());
				
				while(customerChoice < 1 || customerChoice >6) {
					System.out.print("\nError! Incorrect choice.\n\n");
			        System.out.println(customerMenu);
			        System.out.print("Option: ");
			        customerChoice = Integer.parseInt(sc.nextLine());
			    }
				
						cdone=true;
					}
					
				catch(NumberFormatException exception)
				{
					 System.out.print("\nOnly Numbers ! Please try again\n\n");
				}
					}while(!cdone);
					
				switch(customerChoice) {
				
				case 1:{
					if (customer.size()== 0)
					{
						System.out.println("\nNo data exist\n");
						break;
						
					}
					else
					{
						
						 
						for (int i =0; i< customer.size(); i++)
						{
								System.out.println ("\nCustomer ID: " + list[i].getId()); 
								System.out.println ("Name: " + list[i].getName());
								int count1 = customer.get(i).getNumberOfArtwork();
								
								System.out.println ("Artist Preference: " + list[i].getArtistPreference());
								System.out.println ("Phone Number: " + list[i].getHpnumber());
								if(count1 != 0)
								{
								System.out.println ("Artwork Purchase List" );
									for (int n = 0; n < count1 ; n++)
										System.out.println( n+1 + ". " + customer.get(i).getArrList()[n].getArtName());
								}
								else		
										System.out.println("No Artwork Purchased");
								
								if(i == count -1)
									System.out.println();
						}
						customerChoice =0;
						break;
					}
				}
				case 2:
					{
						boolean e = false;
						System.out.println("\nPlease enter the details: ");
						System.out.print("Customer ID: ");
						
						String customerId = sc.nextLine();
						boolean check;
						do {
						check = true;
						for(int i =0; i < customer.size(); i ++)
						{
							if (customer.get(i).getId().equals(customerId))
							{
								check = false;
								if(check == false){
									System.out.print("Customer ID already exist!!!");
									System.out.print("\n Customer ID: ");
									customerId = sc.nextLine();
								}
							}
						}
						
						for(int i =0; i < artist.size(); i ++)
						{
							if (artist.get(i).getId().equals(customerId))
							{
								check = false;
								if(check == false) {
									System.out.print("ID already exist!!!");
									System.out.print("\n Customer ID: ");
									customerId = sc.nextLine();
								}
							}
							}
						}while( check == false);
					
						
						System.out.print("Customer Name: ");
						String cusname = sc.nextLine();
						
						String hpnumber;
						int numrr;
						
						try
						{
						System.out.print("Customer Phone number: ");
						hpnumber= sc.nextLine();
						numrr = Integer.parseInt(hpnumber);
						
						boolean check2;
		                do {
		                check2 = true;
		                for(int i =0; i < customer.size(); i ++)
		                {
		                    if (customer.get(i).getHpnumber().equals(hpnumber))
		                        check2 = false;

		                }
		                    if(check2 == false)
		                    {
		                    	System.out.print("Number already been used!!!");
								System.out.print("\nCustomer Phone number: ");
								hpnumber= sc.nextLine();
								numrr = Integer.parseInt(hpnumber);
		                    }

		                }while(check2 == false);
						}
						catch(NumberFormatException exception)
						{
							System.out.print("Only Numbers ! Please try again\n\n");
							break;
						}
					
						
						
						customer1 = new Customer1(customerId,cusname,hpnumber);
						customer.add(customer1);
						
						System.out.println("Customer Info recorded \n");
						
						break;
					}
				case 3:
					{
						if (customer.size()== 0)
						{
							System.out.println("\nNo data exist\n");
							break;
						}
						else
						{
							System.out.println("\nPlease enter the ID of the customer you want to delete: ");
							String customerDelete= sc2.nextLine();
							 
							boolean check = false;
							
							 for (int i = 0; i < count; i++) {
								
								if( list[i].getId().equals(customerDelete))
								{
									customer.remove(list[i]);
								
								 	check = true;
								
									
								}
								
							}
							 if (check == false )
									System.out.println("The customer ID does not exist !!\n");
							 else
								 System.out.println("The customer has been deleted !!\n");
									
							 customerChoice=0;
							 break;
					}
						
				}
				case 4:
					{
						if (customer.size()== 0)
						{
							System.out.println("\nNo data exist\n");
						break;
						}
						else
						{
							boolean ava = false;
							System.out.println("\nPlease enter the ID of the customer you want to search:");
							String searchCusID=sc2.nextLine();
						 
							for (int i = 0; i < count; i++) {
								
								if( list[i].getId().equals(searchCusID))
								{
									
									System.out.print("Customer ID: " + list[i].getId() +"\nName: " + list[i].getName()+"\nPhone Number: "+list[i].getHpnumber() + "\nArtist Preference: "
											+list[i].getArtistPreference()+ "\n");
									

									int count1 = customer.get(i).getNumberOfArtwork();
									
									if(count1 != 0)
									{
										System.out.println ("Purchased Artwork List" );
									for (int n = 0; n < count1 ; n++)	
										System.out.println( n+1 + ". " + customer.get(i).getArrList()[n].getArtName());
										System.out.println();
									}
									else
									{
										System.out.println("No Artwork Purchased\n");
									}
							
									ava = true;
								}
							}
							if(ava != true) {
								System.out.println("Customer Id not available\n");
							}
						
							
							customerChoice = 0;
							break;
						}
					
					}
				
					case 5:{
						boolean mdone=false;
						if (customer.size()== 0)
						{
							System.out.println("\nNo data exist\n");
						break;
						}
						else
						{
						int customerModifyChoice = 0; 
						do
						{
							while(!mdone)
								try {
						System.out.println("\nPlease enter the details of the customer that you want to edit \n" 
								+ "1. Customer ID\n"+ "2. Customer Name\n"+ "3. Phone Number\n"  
								);
						System.out.print("Option: ");
						customerModifyChoice =Integer.parseInt(sc.nextLine());
							
						 	while(customerModifyChoice < 1 || customerModifyChoice >3)
						 	{
								System.out.print("\nError! Incorrect choice.\n");
								System.out.println("\nPlease enter the details of the customer that you want to edit \n" 
										+ "1. Customer ID\n"+ "2. Customer Name\n"+ "3. Phone Number\n"  
										);
								System.out.print("Option: ");
								customerModifyChoice =Integer.parseInt(sc.nextLine());
						 	}
						 	mdone=true;
							}
							catch(NumberFormatException exception)
							{
								System.out.print("\nOnly Numbers ! Please try again\n");
							}
					       
				 
						
					
						System.out.print("Please enter the customer ID for the artist information you want modify: ");
						 String customerID = sc.nextLine();
						boolean check = false;
						int num = 0;
						 for (int i = 0; i < count; i++)
							{
								if(list[i].getId().equals(customerID))
									check = true;
								num = i;
							}
						 if (check ==false)
						 {
							 System.out.println("Customer ID does not exist !!\n");
							 break;
						 }
						 else
						 {
						 
						 switch (customerModifyChoice)
						 { 
						 case 1:{
								
							 System.out.print("Please enter the new customer ID: ");
							 	String changedCustomerID = sc.nextLine();
							 	
							 	boolean check2 = false;
								boolean valid ;
							 	
								
								do {
								valid = true;
								for(int i =0; i < customer.size(); i ++)
								{
									if (customer.get(i).getId().equals(changedCustomerID))
									{
										valid = false;
										if(valid == false){
											System.out.print("Customer ID already exist!!!");
											System.out.print("\n Customer ID: ");
											changedCustomerID = sc.nextLine();
										}
									}
								}
								
								for(int i =0; i < artist.size(); i ++)
								{
									if (artist.get(i).getId().equals(changedCustomerID))
									{
										valid = false;
										if(valid == false) {
											System.out.print("ID already exist!!!");
											System.out.print("\n Customer ID: ");
											changedCustomerID = sc.nextLine();
										}
									}
									}
								}while( valid == false);
							 	
							 	
								 for (int i = 0; i < count; i++)
									{
										if(list[i].getId().equals(customerID))
										{
											list[i].setId(changedCustomerID);
											num = i;
											check2 = true;
										}
									}
								 if (check2 = true)
								 {
									 System.out.println("Modify successfully\n");
									 customer.set(num, list[num]);
								 }
								 else
									 System.out.println("Modify unsuccessful\n");
								 
							break;
								 
						 }
						 
						 case 2:{
							 
							 	System.out.print("Please enter the new customer name: ");
							 	String changedCustomerName = sc.nextLine();
									
								boolean check2 = false;
								
								 for (int i = 0; i < count; i++)
									{
										if(list[i].getId().equals(customerID))
										{
											list[i].setName(changedCustomerName);
											num = i;
											check2 = true;
											
										}
									}
								if (check2 == true)
									 {
										 System.out.println("Modify successfully\n");
										 customer.set(num, list[num]);
									 }
									 else
										 System.out.println("Modify unsuccessful !!\n");
						
								break;
								
						 }
						 case 3:{
							 try {
								System.out.print("Please enter the new phone number: ");
							 	String changedPhoneNumber = sc.nextLine();
								int a = Integer.parseInt(changedPhoneNumber);
								 boolean check2 = false;
								
								 boolean valid ;
								
					                do {
					                	valid = true;
					                for(int i =0; i < customer.size(); i ++)
					                {
					                    if (customer.get(i).getHpnumber().equals(changedPhoneNumber))
					                    	valid = false;

					                }
					                    if(valid == false)
					                    {
					                    	System.out.print("Number already been used!!!");
											System.out.print("\nCustomer Phone number: ");
											changedPhoneNumber= sc.nextLine();
											a = Integer.parseInt(changedPhoneNumber);
					                    }

					                }while(valid == false);
								 
								 for (int i = 0; i < count; i++)
									{
										if(list[i].getId().equals(customerID))
										{
											list[i].setHpnumber(changedPhoneNumber);
											num = i;
											
											check2 = true;
										}
									}
								 
								 if (check2 == true)
								 {
									 System.out.println("Modify successfully\n");
									 customer.set(num, list[num]);
								 }
								 else
									 System.out.println("Modify unsuccessful !!\n");
								 
						 }
							 catch(NumberFormatException exception)
							 {
								 System.out.println("\nOnly Numbers ! Please try again\n");
								
							 }
						 
						 break;
						 }
						 
						 
						 }
						
						 
						 		
						 	}
						}while(!mdone);
						}
						customerChoice=0;
					}
				}
				
			}while(customerChoice !=6);
				
				System.out.println("\nReturning to Main Menu...");
				break;
		}
				
				
			case 2:{
				boolean adone = false;
				
				int count = artist.size();
				 
				 Artist[] list2 = new Artist[count];
			 
				 list2 = artist.toArray(list2);
				 
				 for (int i =0; i< artist.size(); i ++)
					{
						
						int count1 = artist.get(i).getNumberOfArtwork();
						double max;
						double min;
						if (count1 != 0)
						{
							max = 0;
							min = artist.get(i).getArrList()[0].getPrice().getPurchasePrice();
							for(int n=0; n< count1; n++)
							{
							if (max < artist.get(i).getArrList()[n].getPrice().getPurchasePrice())
								max = artist.get(i).getArrList()[n].getPrice().getPurchasePrice();
							
							if(min >artist.get(i).getArrList()[n].getPrice().getPurchasePrice())
								min = artist.get(i).getArrList()[n].getPrice().getPurchasePrice();
							}
							artist.get(i).setPriceRangeMin(min);
							artist.get(i).setPriceRangeMax(max);
						}
						else
						{
							artist.get(i).setPriceRangeMin(0.00);
							artist.get(i).setPriceRangeMax(0.00);
						}
					}
				 
					do {
						Artist[] list3 = new Artist[count];
						 
						 list2 = artist.toArray(list3);
						 
						 for (int i =0; i< artist.size(); i ++)
							{
								
								int count1 = artist.get(i).getNumberOfArtwork();
								double max;
								double min;
								if (count1 != 0)
								{
									max = 0;
									min = artist.get(i).getArrList()[0].getPrice().getPurchasePrice();
									for(int n=0; n< count1; n++)
									{
									if (max < artist.get(i).getArrList()[n].getPrice().getPurchasePrice())
										max = artist.get(i).getArrList()[n].getPrice().getPurchasePrice();
									
									if(min >artist.get(i).getArrList()[n].getPrice().getPurchasePrice())
										min = artist.get(i).getArrList()[n].getPrice().getPurchasePrice();
									}
									artist.get(i).setPriceRangeMin(min);
									artist.get(i).setPriceRangeMax(max);
								}
								else
								{
									artist.get(i).setPriceRangeMin(0.00);
									artist.get(i).setPriceRangeMax(0.00);
								}
							}
						try {
					System.out.println(artistMenu);
					  System.out.print("Option: ");
				artistChoice = Integer.parseInt(sc.nextLine());
					
				
				while(artistChoice < 1 || artistChoice >6) {
					System.out.print("\nError! Incorrect choice.\n\n");
			        System.out.print(artistMenu);
			        System.out.print("\nOption: ");
			        artistChoice = Integer.parseInt(sc.nextLine());
			    }
				adone=true;
				}
				catch(NumberFormatException exception)
						{
					System.out.print("\nOnly Number! Please try again\n\n");
						}
				
				
				switch (artistChoice) {
				
				case 1:{
					if (artist.size() == 0)
					{
						System.out.println("\nNo data exist\n");
						break;
					}
					else
					{
					
					
					for (int i =0; i< artist.size(); i ++)
					{
						
						int count1 = artist.get(i).getNumberOfArtwork();
						
							System.out.println ("\nArtist ID: " + list2[i].getId()); 
							System.out.println ("Artist Name: " + list2[i].getName());
					
							if (count1 != 0)
							{
								System.out.println ("Artwork Price Range: " + list2[i].getPriceRangeMin() + " - " + list2[i].getPriceRangeMax());
								
							}
							else if(list2[i].getPriceRangeMin() == 0.00
							&& list2[i].getPriceRangeMax()==0.00)
								System.out.println ("Artwork Price Range: Unknown" );
							
							System.out.println ("Specialty: " + list2[i].getSpecialty());
							System.out.println ("Phone Number: " + list2[i].getHpnumber());
							System.out.println ("Status: " + list2[i].getStatus());
							
							if (count1 !=0)
							{
								System.out.println ("Artwork List" );
								for (int n = 0; n < count1 ; n++)
								{
									
									System.out.println( n+1 + ". " + artist.get(i).getArrList()[n].getArtName());
									
								}
							}
							else
								System.out.println("No Artwork ");
							
							if(i == count -1)
								System.out.println();
					}
					artistChoice =0;
					break;
						}
					
				}
				case 2:{
					artistChoice =0;
					
						System.out.println("\nPlease enter the details: ");
				        System.out.print("Artist ID: ");
				        	Scanner sc1 = new Scanner (System.in);
				        	String artistID = sc1.nextLine();
				        	
				        	boolean check;
							do {
							check = true;
							for(int i =0; i < customer.size(); i ++)
							{
								if (customer.get(i).getId().equals(artistID))
								{
									check = false;
									if(check == false){
										System.out.print("Customer ID already exist!!!");
										System.out.print("\n Customer ID: ");
										artistID = sc.nextLine();
									}
								}
							}
							
							for(int i =0; i < artist.size(); i ++)
							{
								if (artist.get(i).getId().equals(artistID))
								{
									check = false;
									if(check == false) {
										System.out.print("ID already exist!!!");
										System.out.print("\n Customer ID: ");
										artistID = sc.nextLine();
									}
								}
								}
							}while( check == false);
							
				        	
				        	
				        System.out.print("Artist Name: ");
				    		String artistName = sc1.nextLine();
				        System.out.print("Specialty: ");
				        	String specialty = sc1.nextLine();
				        	
				        	String phoneNumber;
				        	int numrr;
				        	try
				        	{
				        System.out.print("ArtistPhone Number: ");
				        	 phoneNumber = sc1.nextLine();
				        	 numrr=Integer.parseInt(phoneNumber);
				        	 
				        	 boolean check2;
				                do {
				                check2 = true;
				                for(int i =0; i < artist.size(); i ++)
				                {
				                    if (customer.get(i).getHpnumber().equals(phoneNumber))
				                        check2 = false;

				                }
				                    if(check2 == false)
				                    {
				                    	System.out.print("Number already been used!!!");
										System.out.print("\nCustomer Phone number: ");
										phoneNumber= sc.nextLine();
										numrr = Integer.parseInt(phoneNumber);
				                    }

				                }while(check2 == false);
					        		
				        	}
				        	catch(NumberFormatException exception)
				        	{
				        		System.out.print("\nOnly Number ! Please try again\n");
				        		break;
				        	}
				        	
				        	
					        	
				 
				        System.out.print("Status (Alive or Deceased): ");
							String status = sc1.nextLine();
						
						boolean	check2 = false;
						
						do {
						if (status.equals("Alive") || status.equals("Deceased"))
								check2 = true;
						
						else
						{	System.out.println("Input of status is not (Alive or Deceased)");
							System.out.print("Status (Alive or Deceased): ");
								status = sc1.nextLine();
						}
						}while (check2 == false);
						artist1 = new Artist (artistID, artistName, specialty, phoneNumber, status);
						
						artist.add(artist1);
						System.out.println("Artist Info recorded \n");
						artistChoice=0;
						
						
						break;
					
				}
				case 3:{
					artistChoice =0;
					if (artist.size()== 0)
					{
						System.out.println("\nNo data exist\n");
					break;
					}
					else
					{
					System.out.println("\nPlease enter the ID of the artist you want to delete: ");
					String artistDelete = sc.nextLine();
						 
						 boolean check = false;
						
						 
						 for (int i = 0; i < count; i++)
							{
								if(list2[i].getId().equals(artistDelete))
								{ 
									artist.remove(list2[i]);
									check = true;
								}
								
							}
						 if ( check == false)
							 System.out.println("The artist ID does not exist !!\n");
						 else
							 System.out.println("The artist has been deleted !!\n");
						 break;
						}
				}
				case 4:{
				
				
					if (customer.size()== 0)
					{
						System.out.println("\nNo data exist\n");
					break;
					}
					else
					{
					System.out.println("\nPlease enter the ID of the artist you want to search");
					Scanner sc3 = new Scanner (System.in);
					String artistID = sc3.nextLine(); 
			
					 
					 boolean check = false;
					
					 for (int i = 0; i < count; i++)
						{
							if(list2[i].getId().equals(artistID))
							{
								
								int count1 = artist.get(i).getNumberOfArtwork();
								System.out.println ("Artist Name: " + list2[i].getName());
								
									
									if (count1 != 0)
										System.out.println ("Artwork Price Range: " + list2[i].getPriceRangeMin() + " - " + list2[i].getPriceRangeMax());
									else
										System.out.println ("Artwork Price Range: Unknown" );
									System.out.println ("Specialty: " + list2[i].getSpecialty());
									System.out.println ("Phone Number: " + list2[i].getHpnumber());
									System.out.println ("Status: " + list2[i].getStatus());
									
								if(count1 !=0)
								{
									for (int n = 0; n < count1 ; n++)
									{
										System.out.println ("Artwork List" );
										System.out.println( n+1 + ". " + artist.get(i).getArrList()[n].getArtName());
									}
									System.out.println();
								}
								else
									System.out.println("No Artwork\n");
								
								check = true;
							}
						}
						
					 if ( check == false)
						 System.out.println("The artist ID does not exist !!\n");
					artistChoice = 0;
					break;
						}
				}
				case 5:{
					artistChoice =0;
					Scanner sc4 = new Scanner (System.in);
					boolean mdone = false;
					if(artist.size() == 0)
					{
						System.out.print("\nNo data exist\n");
						break;
					}
					else
					{
					int artistModifyChoice = 0; 
						do {
							while(!mdone)
							try {
					
					System.out.println("\nPlease enter the details of the artist that you want to edit \n" 
							+ "1. Artist ID\n"+ "2. Artist Name\n"+ "3. Specialty\n" + "4. Phone Number\n"+"5. Status" 
							);
					System.out.print("Option: ");
					
					artistModifyChoice =Integer.parseInt(sc4.nextLine());
						
					 	while(artistModifyChoice < 1 || artistModifyChoice >5)
					 	{
							System.out.print("\nError! Incorrect choice.\n");
							System.out.println("\nPlease enter the details of the artist that you want to edit \n" 
									+ "1. Artist ID\n"+ "2. Artist Name\n"+ "3. Specialty\n" + "4. Phone Number\n"+"5. Status" 
									);
							System.out.print("Option: ");
							
							artistModifyChoice =Integer.parseInt(sc4.nextLine());
					 	}
					 	mdone=true;
							}
						
						catch(NumberFormatException exception)
						{
							System.out.print("\nOnly Numbers ! Please try again\n");
						}
				       
 
					
					
					System.out.print("\nPlease enter the artist ID for the artist information you want modify: ");
					 String artistID = sc4.nextLine();
						boolean check = false;
						int num = 0;
						 for (int i = 0; i < count; i++)
							{
								if(list2[i].getId().equals(artistID))
									check = true;
								num = i;
							}
						 if (check==false)
						 {
							 System.out.println("Artist ID does not exist !!\n");
							 break;
						 }
						 else
						 {
					 
					 switch (artistModifyChoice)
					 { 
					 case 1:{
						 boolean valid;
						 boolean check2 = false;
						 System.out.print("Please enter the new artist ID: ");
						 String changedArtistID = sc4.nextLine();
						
						 do {
								valid = true;
								for(int i =0; i < customer.size(); i ++)
								{
									if (customer.get(i).getId().equals(changedArtistID))
									{
										valid = false;
										if(valid == false){
											System.out.print("ID already exist!!!");
											System.out.print("\n Artist ID: ");
											changedArtistID = sc.nextLine();
										}
									}
								}
								
								for(int i =0; i < artist.size(); i ++)
								{
									if (artist.get(i).getId().equals(changedArtistID))
									{
										valid = false;
										if(valid == false) {
											System.out.print("ID already exist!!!");
											System.out.print("\n Artist ID: ");
											changedArtistID = sc.nextLine();
										}
									}
									}
								}while( valid == false);
						 
							 for (int i = 0; i < count; i++)
								{
									if(list2[i].getId().equals(artistID))
									{
										list2[i].setId(changedArtistID);
										num = i;
										check2 = true;
									}
								}
							 if (check2 = true)
							 {
								 System.out.println("Modify successfully\n");
								 artist.set(num, list2[num]);
							 }
							 else
								 System.out.println("Modify unsuccessful\n");
							 
						 break;
					 }
					 
					 case 2:{
						 
						 	System.out.print("Please enter the new artist name: ");
						 	String changedArtistName = sc4.nextLine();
								
							boolean check2 =false;
							 
							 for (int i = 0; i < count; i++)
								{
									if(list2[i].getId().equals(artistID))
									{
										list2[i].setName(changedArtistName);
										num = i;
										check2 = true;
										
									}
									
								}
							if (check2 ==true)
								 {
									 System.out.println("Modify successfully\n");
									 artist.set(num, list2[num]);
								 }
								 else
									 System.out.println("Modify unsuccessful\n");
							
							break;
					 }
					 
					 case 3:{
						 	System.out.print("Please enter the new specialty: ");
						 	String changedSpecialty = sc4.nextLine();
				
							 boolean check2 = false;
							
							  
							 
							 for (int i = 0; i < count; i++)
								{
									if(list2[i].getId().equals(artistID))
									{
										list2[i].setSpecialty(changedSpecialty);
										num = i;
										check2 = true;
									}
								}
							 
							 if (check2 == true)
							 {
								 System.out.println("Modify successfully\n");
								 artist.set(num, list2[num]);
							 }
							 else
								 System.out.println("Modify unsuccessful\n");
						 break;
					 }
					 case 4:{
						 boolean check2 = false;
						 try {
						 	System.out.print("Please enter the new phone number: ");
						 	String changedPhoneNumber = sc4.nextLine();
						 	int a = Integer.parseInt(changedPhoneNumber);
				
						 	boolean valid;
			                do {
			                valid = true;
			                for(int i =0; i < artist.size(); i ++)
			                {
			                    if (customer.get(i).getHpnumber().equals(changedPhoneNumber))
			                        valid = false;

			                }
			                    if(valid == false)
			                    {
			                    	System.out.print("Number already been used!!!");
									System.out.print("\nPhone number: ");
									changedPhoneNumber= sc.nextLine();
									a = Integer.parseInt(changedPhoneNumber);
			                    }

			                }while(valid == false);
							 
							
							 for (int i = 0; i < count; i++)
									if(list2[i].getId().equals(artistID))
									{
										list2[i].setHpnumber(changedPhoneNumber);
										num = i;
										
										check2 = true;
									}
								
						
							 
							 if (check2 == true)
							 {
								 System.out.println("Modify successfully\n");
								 artist.set(num, list2[num]);
							 }
							 else
								 System.out.println("Modify unsuccessful\n");
							 
							 
						 }
						 catch(NumberFormatException exception)
						 {
								System.out.print("\nOnly Number! Please try again\n");
						}
						 break;
					 }
							
					 case 5:{ 
						 	System.out.print("Please enter the new status (Alive or Deceased): ");
						 	String changedStatus = sc4.nextLine();
						 	boolean check2 =false;
						 	if (changedStatus.equals("Alive") || changedStatus.equals("Deceased"))
								check2 =true;
							 
						 	boolean check3 = false;
							 
							 if(check2 == true)
							 {
								 for (int i = 0; i < count; i++)
								 {
									if(list2[i].getId().equals(artistID))
									{
										list2[i].setStatus(changedStatus);
										num = i;
										
										check3 = true;
									}
								 }
							 }
							 
							 if (check2 ==true && check3 == true)
							 {
								 System.out.println("Modify successfully\n");
								 artist.set(num, list2[num]);
							 }
							 else if (check2 == false)
								 System.out.println("Input of status is not (Alive or Deceased)\n");
							
				break;
					 }
					 }
						 }
						}while(!mdone);
					}
				}
				}
				}while(artistChoice != 6);
					System.out.println("\nReturning to Main Menu...");
					break;
					
			}
					
				
				
		
			case 3:{
				
				do {
					boolean awdone = false;
					int count = artwork.size();
					 
					 Artwork[] list3 = new Artwork[count];
				 
					 list3 = artwork.toArray(list3);
				try {
					System.out.println(artworkMenu);
					  System.out.print("Option: ");
					artworkChoice = Integer.parseInt(sc.nextLine());
	
		
		while(artworkChoice < 1 || artworkChoice >6) {
			System.out.print("\nError! Incorrect choice.\n\n");
	        System.out.println(artworkMenu);
	        System.out.print("Option: ");
	        artworkChoice = Integer.parseInt(sc.nextLine());
	    }
		awdone = true;
				}
				catch(NumberFormatException exception)
				 {
						System.out.print("\nOnly Number! Please try again\n\n");
				}
				
		
		switch (artworkChoice) {
		case 1:{
			if (artwork.size()== 0)
			{
			System.out.println("\nNo data exist\n");
				break;
			}else
			{
				 
				for (int i =0; i< artwork.size(); i++)
				{
					if(artwork.get(i).getAvailability().equals("No"))
					{	
						System.out.println ("\nArt ID: " + list3[i].getArtID());
						System.out.println ("Art Name: " + list3[i].getArtName());
						System.out.println ("Date Purchased: " + list3[i].getDatePurchased());
						System.out.println ("Availability: " + list3[i].getAvailability());
						System.out.println ("Purchase Price: " + list3[i].getPrice().getPurchasePrice());
						System.out.println ("Selling Price: " + list3[i].getPrice().getSellingPrice());
						System.out.println ("Date Sold: " + list3[i].getDateSold());
						System.out.println ("Customer Name: " + list3[i].getCustomerName());
						System.out.println ("Artist Name: " + list3[i].getArtistName());
						if(i == count -1)
							System.out.println();
						
					}
					else
					{
						System.out.println ("\nArt ID: " + list3[i].getArtID());
						System.out.println ("Art Name: " + list3[i].getArtName());
						System.out.println ("Date Purchased: " + list3[i].getDatePurchased());
						System.out.println ("Availability: " + list3[i].getAvailability());
						System.out.println ("Purchase Price: " + list3[i].getPrice().getPurchasePrice());
						System.out.println ("Artist Name: " + list3[i].getArtistName());
						if(i == count -1)
							System.out.println();
						
					}
					artworkChoice = 0;
				}
				break;
				
			}
			
			
		}
		case 2:{
			artworkChoice=0;
			System.out.println("\nPlease enter the details: ");
	        System.out.print("Art ID: ");
	    		Scanner sc1 = new Scanner (System.in);
	    		String artID = sc1.nextLine();
	    		boolean check;
                do {
                check = true;
                for(int i =0; i < artwork.size(); i ++)
                {
                    if (artwork.get(i).getArtID().equals(artID))
                        check = false;

                }
                    if(check == false)
                    {
                        System.out.print("Art ID already exist!!!");
                        System.out.print("\n Art ID: ");
                        artID = sc.nextLine();
                    }

                }while(check == false);
	        System.out.print("Art Name: ");
	        	String artName = sc1.nextLine();
	        	
	        	String datePurchased = null;
	        	int a;
	        	int year =0;
	        	int month=0;
	        	int day =0;
	        try {	
	        System.out.print("Date Purchased (YYYYMMDD): ");
	        datePurchased = sc1.nextLine();
	        	a = Integer.parseInt(datePurchased);
	        	
	        	boolean vdate = false;
	        	
	        		boolean vyear = false;
	        		boolean vmonth = false;
	        		boolean vday = false;
	        	do
	        	{
	        	year = Integer.parseInt(datePurchased)  / 10000;
	    		if(year >= 1 && year <= 9999)
	    		{
	    			vyear = true;
	    		
	    		}
	    		
	    		
	    		month = (Integer.parseInt(datePurchased) % 10000) / 100;
	    		if(month >=1 && month <=12)
	    		{
	    			vmonth = true;
	    			
	    		}
	    		
	    		day = Integer.parseInt(datePurchased)% 100;
	    		if(day >=1 && day <=31)
	    		{
	    			if(month == 1 || month ==3 || month ==5  || month ==7 || month == 8 || month == 10 || month == 12)
	    			{
	    				vday = true;
	    			}
	    		}
	    		if(day >=1 && day <=30) 
	    		{
	    			if(month == 4 || month == 6 || month ==9  || month == 11 )
	    			{
	    				vday = true;
	    			}
	        	}
	        	if(day >=1 && day <=28)
	        	{
	    			if(month ==2)
	    			{
	    				vday = true;
	    			}
	    		}
	        	
	        	if(day >=1 && day <=29)
	        	{
	    			if(month ==2 && year % 4 == 0)
	    			{
	    				vday = true;
	    			}
	    		}
	        	if(vyear == false || vmonth == false || vday == false)
	        	{
	        		System.out.print("Unavailable Date! Please try again\n");
	        		System.out.print("Date Purchased (YYYYMMDD): ");
		        	datePurchased = sc1.nextLine();
		        	a = Integer.parseInt(datePurchased);
	        	}
	        	else
	        		vdate = true;
	        	}while(vdate !=true);
	        	
	    		
	        
	        }
	        	
	        catch(NumberFormatException exception)
			{
					System.out.print("\nOnly Number! Please try again\n\n");
					break;
			}
	    
	      
	        	boolean pp = false;
	        	double purchasePrice = 0;
	        	
	        	
	    			try
	    			{
	    				System.out.print ("Purchase Price: " );
	    				  purchasePrice = Double.parseDouble(sc1.nextLine());
	    				
	    			}
	    			
	    			catch(NumberFormatException exception)
	    			{
	    					System.out.print("\nOnly Number! Please try again\n");
	    					break;
	    			}
	    	
	        	

	    			 
	    			
	    			
	    			
	        System.out.print("Availability (Please choose between 'Yes' or 'No'): ");
	        	String availability = sc1.nextLine();
	        	
				boolean check5 =false;
				
	        	do
				{
				
				if ( availability.equals("No") || availability.equals("Yes"))
				{
						check5 = true;
				}
				else
				{
					System.out.println("Please enter ('Yes' or 'No')");
					
					  System.out.print("Availability (Please choose between 'Yes' or 'No'): ");
					  availability = sc1.nextLine();
				}
				}while(check5 == false);
	        	
	        String dateSold,customerName,artistName;
	        double sellingPrice;
	        
	        
	        if(availability.equals("No" ))
	        {
	        	try {	
	    	        System.out.print("Date Sold (YYYYMMDD): ");
	    	        dateSold= sc1.nextLine();
	    	        	a = Integer.parseInt(dateSold);
	    	        	
	    	        	boolean vdate = false;
	    	        	
	    	        		boolean vyear = false;
	    	        		boolean vmonth = false;
	    	        		boolean vday = false;
	    	        	do
	    	        	{
	    	        	year = Integer.parseInt(dateSold)  / 10000;
	    	    		if(year >= 1 && year <= 9999)
	    	    		{
	    	    			vyear = true;
	    	    		
	    	    		}
	    	    		
	    	    		
	    	    		month = (Integer.parseInt(dateSold) % 10000) / 100;
	    	    		if(month >=1 && month <=12)
	    	    		{
	    	    			vmonth = true;
	    	    			
	    	    		}
	    	    		
	    	    		day = Integer.parseInt(dateSold)% 100;
	    	    		if(day >=1 && day <=31)
	    	    		{
	    	    			if(month == 1 || month ==3 || month ==5  || month ==7 || month == 8 || month == 10 || month == 12)
	    	    			{
	    	    				vday = true;
	    	    			}
	    	    		}
	    	    		if(day >=1 && day <=30) 
	    	    		{
	    	    			if(month == 4 || month == 6 || month ==9  || month == 11 )
	    	    			{
	    	    				vday = true;
	    	    			}
	    	        	}
	    	        	if(day >=1 && day <=28)
	    	        	{
	    	    			if(month ==2)
	    	    			{
	    	    				vday = true;
	    	    			}
	    	    		}
	    	        	
	    	        	if(day >=1 && day <=29)
	    	        	{
	    	    			if(month ==2 && year % 4 == 0)
	    	    			{
	    	    				vday = true;
	    	    			}
	    	    		}
	    	        	if(vyear == false || vmonth == false || vday == false)
	    	        	{
	    	        		System.out.print("Unavailable Date! Please try again");
	    	        		System.out.print("\nDate sold (YYYYMMDD): ");
	    	        		dateSold = sc1.nextLine();
	    		        	a = Integer.parseInt(dateSold);
	    	        	}
	    	        	else
	    	        		vdate = true;
	    	        	}while(vdate !=true);
	    	        	
	    	    		
	    	        
	    	        }
	    	        	
	    	        catch(NumberFormatException exception)
	    			{
	    					System.out.print("\nOnly Number! Please try again\n");
	    					break;
	    			}
		        
	        
	        	
	        	do
	        	{
	        		System.out.print("Customer Name: ");
	     	        customerName = sc1.nextLine();
	        	
	        		 for (Customer1 customers: customer)
	        		 {
	        			 if (customers.getName().equals(customerName))
	        				 check = true;
	        		 }
	        		 if(check == false)
	        			 System.out.println("No customer exist !!");
	        	
	        		
	        	}while(check == false);
	        	
	        	try
    			{
    				System.out.print ("Selling Price: " );
    				  sellingPrice = Double.parseDouble(sc1.nextLine());
    				
    			}
    			
    			catch(NumberFormatException exception)
    			{
    					System.out.print("\nOnly Number! Please try again\n");
    					break;
    			}
	        	
	        }
	        else 
	        {	
	        	dateSold = null;
	        	sellingPrice = 0;
	        	customerName = null;
	        }
	        boolean check1 = false ;
        	do
        	{    
        		System.out.print("Artist Name: ");
        		Scanner sc3 = new Scanner (System.in);
      	        artistName = sc3.nextLine();
        	
        		 for (Artist artists: artist)
        		 {
        			 if (artists.getName().equals(artistName))
        				 check1 = true;
        		 }
        		 if(check1 == false)
        		 {
        			 System.out.println("No artist exist !!");
        		 }
        			 
        	}while(check1 == false);
	      
			Inventory price = new Inventory(sellingPrice,purchasePrice); 
	
        	artwork1= new Artwork (artID, artName,datePurchased, availability,dateSold, 
					  artistName,customerName,price);
        	
			
			
			for(int i =0; i < artist.size(); i ++)
			{
				if (artist.get(i).getName().equals(artwork1.getArtistName()))
					artist.get(i).recordArtwork(artwork1);
				
			}
			artwork.add(artwork1);
			
			
			if (availability.equals("No"))
			{	
				for(int i =0; i < customer.size(); i ++)
				{
					if (customer.get(i).getName().equals(artwork1.getCustomerName()))
						customer.get(i).recordArtwork(artwork1);
					
				}
			}
	
			System.out.println("Artwork Info recorded \n");
			artworkChoice =0;
			break;
				
		}
		case 3:{
			
			if (artwork.size()== 0)
			{
				System.out.println("\nNo data exist\n");
			break;
			}
			else
			{
			System.out.println("\nPlease enter the ID of the artwork you want to delete");
			Scanner sc2_5 = new Scanner (System.in);
			String artworkDelete = sc2_5.nextLine();
			
			
			int y;
			int z;
			
			boolean check2= false;
			boolean check3= true;
			
			 int count3 = customer.size();
			 for(y=0 ; y <count3; y++)
				{
				 	int count2 = customer.get(y).getNumberOfArtwork();
					for (z=0; z < count2; z++) 
					{
						if (customer.get(y).getArrList()[z].getArtID().equals(artworkDelete))
						{
							customer.get(y).deleteArtwork(list3[z]);
							check2 = true;
						}
					}
				
			
				}
			 
			 int g;
			 int n;
			 int count4 = artist.size();
			 for(g=0; g<count4; g++)
			 {
				
				int count2 = artist.get(g).getNumberOfArtwork();
				for (n=0; n < count2; n++) 
				{
					if (check2 = true)
					if (artist.get(g).getArrList()[n].getArtID().equals(artworkDelete))
					{	
						artist.get(g).deleteArtwork(list3[n]);
						check2 = true;
					}
				}
				 
			 }	 
				 boolean check = false;
				
				 
				 for (int i = 0; i < count; i++)
					{
					 	if(list3[i].getArtID().equals(artworkDelete))
					 	{	
					 		artwork.remove(list3[i]);
					 		check = true;
					 	}
						
					}
				 if ( check == false)
					 System.out.println("The artwork ID does not exist !!\n");
				 if (check == true && check2 ==true && check3 ==true)
					 System.out.println("The artwork has been deleted !!\n");
					 
			break;
				}
		}
		case 4:{
			artworkChoice =0;
			if (artwork.size()== 0)
			{
				System.out.println("\nNo data exist\n");
			break;
			}
			else
			{
			System.out.println("\nPlease enter the ID of the artwork you want to search:");
			Scanner sc3 = new Scanner (System.in);
			String artworkID = sc3.nextLine(); 
		
			 
			 boolean check = false;
			
			 for (int i = 0; i < count; i++)
				{
					if(list3[i].getArtID().equals(artworkID))
					{
						
						if(list3[i].getAvailability().equals("No") )
						{	
						System.out.println ("Art ID: " + list3[i].getArtID());
						System.out.println ("Art Name: " + list3[i].getArtName());
						System.out.println ("Date Purchased: " + list3[i].getDatePurchased());
						System.out.println ("Availability: " + list3[i].getAvailability());
						System.out.println ("Purchase Price: " + list3[i].getPrice().getPurchasePrice());
						System.out.println ("Selling Price: " + list3[i].getPrice().getSellingPrice());
						System.out.println ("Date Sold: " + list3[i].getDateSold());
						System.out.println ("Customer Name: " + list3[i].getCustomerName());
						System.out.println ("Artist Name: " + list3[i].getArtistName());
						}
						else
						{
							System.out.println ("Art ID: " + list3[i].getArtID());
							System.out.println ("Art Name: " + list3[i].getArtName());
							System.out.println ("Date Purchased: " + list3[i].getDatePurchased());
							System.out.println ("Availability: " + list3[i].getAvailability());
							System.out.println ("Purchase Price: " + list3[i].getPrice().getPurchasePrice());
							System.out.println ("Artist Name: " + list3[i].getArtistName());
						
						}
					
						check = true;
					}
				}
			 if ( check != true)
				 System.out.println("The artwork ID does not exist !!\n");
	
			
			break;
				}
		}
		case 5:{
			artworkChoice =0;
			boolean amdone = false;
			if (artwork.size()== 0)
			{
				System.out.println("\nNo data exist\n");
			break;
			}
			else
			{ 
			int artworkModifyChoice =0;
			do
			{
		
				boolean check = false;
				while(!amdone)
					try {
			System.out.println("\nPlease enter the details of the artwork that you want to edit \n" 
					+ "1. Artwork ID\n"+ "2. Artwork Name\n"+ "3. Date Purchased\n" + "4. Availability\n"+"5. Date Sold\n" 
					+"6. Customer Name\n"+ "7. Artist Name");
					System.out.print("Option: ");
					Scanner sc4 = new Scanner (System.in);
					artworkModifyChoice = Integer.parseInt(sc4.nextLine());
			
				while(artworkModifyChoice < 1 || artworkModifyChoice >7)
				{
					System.out.print("\nError! Incorrect choice.\n");
				System.out.println("\nPlease enter the details of the artwork that you want to edit \n" 
						+ "1. Artwork ID\n"+ "2. Artwork Name\n"+ "3. Date Purchased\n" + "4. Availability\n"+"5. Date Sold\n" 
						+"6. Customer Name\n"+ "7. Artist Name");
						System.out.print("Option: ");
						artworkModifyChoice = Integer.parseInt(sc4.nextLine());
				
			}
				amdone = true;
					}
				catch(NumberFormatException exception)
				{
					System.out.print("\nOnly Numbers ! Please try again\n");
				}
			
			
			System.out.print("\nPlease enter the artwork ID for the arwork information you want edit: ");
			Scanner sc4 = new Scanner (System.in);
			String artworkID = sc4.nextLine();
			check = false;		 
			int num =0;
			for (int i = 0; i < count; i++)
				{
					if(list3[i].getArtID().equals(artworkID))
					{	
						check = true;
						num = i;
					}
				}
			 if (check ==false)
			 {
				 System.out.println("Artwork ID does not exist !!\n");
				
			 }
			 else
			 {
			 switch (artworkModifyChoice)
			 { 
			 case 1:{
				 	boolean check2 = false;
				 	System.out.print("Please enter the new Artwork ID: ");
				 	String changedArtworkID = sc4.nextLine();
			
				 	do
				 	{
				 		for(int i =0;i<count;i++)
				 		{
				 			if(list3[i].getArtID().contentEquals(changedArtworkID))
				 			{
				 				do
				 				{System.out.print("ID already exist !!!");
				 				System.out.print("\nPlease enter the new Artwork ID: ");
							 	changedArtworkID = sc4.nextLine();
				 				}while(list3[i].getArtID().contentEquals(changedArtworkID));
				 			}
				 		}
				 		check = true;
				 	}while(!check);
							
				 				
				 	if (check == true)
				 	{
								list3[num].setArtID(changedArtworkID);
								check2 = true;
				 	}		
						
					 if (check2 ==true)
					 {
						 System.out.println("Modify successfully\n");
						 artwork.set(num, list3[num]);
					 }
					 else
						 System.out.println("Modify unsuccessful");
					 break;
			 }
			 
			 case 2:{
				 	System.out.print("Please enter the new Artwork name: ");
				 	String changedArtworkName = sc4.nextLine();
						
				 	list3[num].setArtName(changedArtworkName);
					
				
						 boolean check2 = false;
						 boolean check3 = false;
						 
						 int i;
						 int n;
						 int count5 = artist.size();
						 for(i =0; i<count5; i++)
							{
							 	int count2 = artist.get(i).getNumberOfArtwork();
								for (n=0; n < count2; n++) 
								{
									if (artist.get(i).getArrList()[n].getArtID().equals(artworkID))
									{	
										/*artist.get(i).getArrList()[n].setArtName(changedArtworkName);*/
										
										artist.get(i).updateArtwork(n,list3[num]);
										check2 = true;
										
									}
								}
							
								
							}
						 
						 if (artwork.get(num).getAvailability().equals("No"))
						 {
							 int y ;
							 int z;
							 int count3 = customer.size();
							 for(y=0 ; y <count3; y++)
								{
								 	int count4 = customer.get(y).getNumberOfArtwork();
									for (z=0; z < count4; z++) 
									{
										if (customer.get(y).getArrList()[z].getArtID().equals(artworkID))
										{	
											/*customer.get(y).getArrList()[z].setArtName(changedArtworkName);
											*/customer.get(y).updateArtwork(z,list3[num]);
											
											check3 = true;
										}
									}
											
								}
								
									
						}
						else 
							 check3 = true;
					
						 if ( check == true && check2 == true && check3 == true)
						 {	
							 System.out.println("Modify successfully\n");
						 	artwork.set(num, list3[num]);
							
						 }
						 else 
							 System.out.println("Modify unsuccessful\n");
						
				
					
				 break;
			 }
			 
			 case 3:{
				 boolean check2 = false;	
				
				 	String changedPurchaseDate = null;
		        	int a;
		        	int year =0;
		        	int month=0;
		        	int day =0;
		        try {	
		        	 System.out.print("Please enter the new purchase date (YYYYMMDD) : ");
					 	changedPurchaseDate = sc4.nextLine();
		        	a = Integer.parseInt(changedPurchaseDate);
		        	
		        	boolean vdate = false;
		        	
		        		boolean vyear = false;
		        		boolean vmonth = false;
		        		boolean vday = false;
		        	do
		        	{
		        	year = Integer.parseInt(changedPurchaseDate)  / 10000;
		    		if(year >= 1 && year <= 9999)
		    		{
		    			vyear = true;
		    		
		    		}
		    		
		    		
		    		month = (Integer.parseInt(changedPurchaseDate) % 10000) / 100;
		    		if(month >=1 && month <=12)
		    		{
		    			vmonth = true;
		    			
		    		}
		    		
		    		day = Integer.parseInt(changedPurchaseDate)% 100;
		    		if(day >=1 && day <=31)
		    		{
		    			if(month == 1 || month ==3 || month ==5  || month ==7 || month == 8 || month == 10 || month == 12)
		    			{
		    				vday = true;
		    			}
		    		}
		    		if(day >=1 && day <=30) 
		    		{
		    			if(month == 4 || month == 6 || month ==9  || month == 11 )
		    			{
		    				vday = true;
		    			}
		        	}
		        	if(day >=1 && day <=28)
		        	{
		    			if(month ==2)
		    			{
		    				vday = true;
		    			}
		    		}
		        	
		        	if(day >=1 && day <=29)
		        	{
		    			if(month ==2 && year % 4 == 0)
		    			{
		    				vday = true;
		    			}
		    		}
		        	if(vyear == false || vmonth == false || vday == false)
		        	{
		        		System.out.print("Unavailable Date! Please try again\n");
		        		System.out.print("Date Purchased (YYYYMMDD): ");
		        		changedPurchaseDate = sc4.nextLine();
			        	a = Integer.parseInt(changedPurchaseDate);
		        	}
		        	else
		        		vdate = true;
		        	}while(vdate !=true);
		        	
		    		
		        
		        }
		        	
		        catch(NumberFormatException exception)
				{
						System.out.print("\nOnly Number! Please try again\n");
						break;
				}
						
					
					  
					 
					 for (int i = 0; i < count; i++)
						{
							if(list3[i].getArtID().equals(artworkID))
							{
								list3[i].setDatePurchased(changedPurchaseDate);
								num = i;
								check2 = true;
							}
						}
					 if (check2 == true)
					 {
						 artwork.set(num, list3[num]);
						 System.out.println("Modify successfully\n");
					 }
					 else
						 System.out.println("Modify unsuccessful");
					 
				 break;
			 }
			 case 4:{
				

				 		System.out.print("Please enter the new availability (Please choose between 'Yes' or 'No'): ");
				 		String changedAvailability = sc4.nextLine();
				 		boolean check5 = false;
				 		
				 		
				 		
				 		do
				 		{
					
				 			if (changedAvailability.equals("No") || changedAvailability.equals("Yes"))
				 				check5 = true;
				 			else
				 			{
				 				System.out.println("Please enter ('Yes' or 'No')");
						
				 				System.out.print("Please enter the new availability (Please choose between 'Yes' or 'No'): ");
				 				changedAvailability = sc4.nextLine();
				 			}
				 		}while(check5 == false);
				 	
						boolean check2 = false;
						boolean check3 = false;
						
						if (list3[num].getAvailability().equals(changedAvailability))
						{
							System.out.println("The current availability is already " + changedAvailability);
							System.out.println();
							break;
						}
						 if (changedAvailability.equals("Yes") && artwork.get(num).getAvailability().equals("No"))
					 	 {
							 	 int y ;
								 int z;
								 int count2 = customer.size();
								 for(y =0; y<count2; y++)
									{
									 	int count3 = customer.get(y).getNumberOfArtwork();
										for (z=0; z < count3; z++) 
										{
											if (customer.get(y).getArrList()[z].getArtID().equals(artworkID))
											{	
												customer.get(y).deleteArtwork(list3[z]);
												list3[num].setCustomerName(null);
												list3[num].setDateSold(null);
												list3[num].getPrice().setSellingPrice(0) ;
												list3[num].setAvailability("Yes");
												check2 = true;
												check3 = true;
											}
												
										}
									}
					 	}
						 
					
					
								 
						if (changedAvailability.equals( "No") && artwork.get(num).getAvailability().equals("Yes"))
						{
							int i;
							int num2;
							System.out.print("Please enter the customer ID: ");
							String customerId = sc4.nextLine();
							int count2 = customer.size();
							do {
								
								for(i= 0 ; i<count2; i++)
								{	
									if (customer.get(i).getId().equals(customerId))
										num2 = i;
										check3 = true;
								}
								if(check3 == false)
								{	
									System.out.println("Customer name not found !!");
									System.out.print("Please enter the customer ID: ");
									customerId = sc4.nextLine();
								}
								
							}while(check3 == false);
							
							
							for(i= 0 ; i<count2; i++)
							{
								if (customer.get(i).getId().equals(customerId))
								{
								
										
										customer.get(i).recordArtwork(list3[num]);
										
										String soldDate;
							        	int a;
							        	int year =0;
							        	int month=0;
							        	int day =0;
							        try {	
							        	System.out.print("Please enter the sold date: ");
							        	 soldDate = sc4.nextLine();
							        	a = Integer.parseInt(soldDate);
							        	
							        	boolean vdate = false;
							        	
							        		boolean vyear = false;
							        		boolean vmonth = false;
							        		boolean vday = false;
							        	do
							        	{
							        	year = Integer.parseInt(soldDate)  / 10000;
							    		if(year >= 1 && year <= 9999)
							    		{
							    			vyear = true;
							    		
							    		}
							    		
							    		
							    		month = (Integer.parseInt(soldDate) % 10000) / 100;
							    		if(month >=1 && month <=12)
							    		{
							    			vmonth = true;
							    			
							    		}
							    		
							    		day = Integer.parseInt(soldDate)% 100;
							    		if(day >=1 && day <=31)
							    		{
							    			if(month == 1 || month ==3 || month ==5  || month ==7 || month == 8 || month == 10 || month == 12)
							    			{
							    				vday = true;
							    			}
							    		}
							    		if(day >=1 && day <=30) 
							    		{
							    			if(month == 4 || month == 6 || month ==9  || month == 11 )
							    			{
							    				vday = true;
							    			}
							        	}
							        	if(day >=1 && day <=28)
							        	{
							    			if(month ==2)
							    			{
							    				vday = true;
							    			}
							    		}
							        	
							        	if(day >=1 && day <=29)
							        	{
							    			if(month ==2 && year % 4 == 0)
							    			{
							    				vday = true;
							    			}
							    		}
							        	if(vyear == false || vmonth == false || vday == false)
							        	{
							        		System.out.print("Unavailable Date! Please try again");
							        		System.out.print("Date Purchased (YYYYMMDD): ");
							        		soldDate = sc4.nextLine();
								        	a = Integer.parseInt(soldDate);
							        	}
							        	else
							        		vdate = true;
							        	}while(vdate !=true);
							        	
							    		
							        	list3[num].setDateSold(soldDate);
							        }
							        	
							        catch(NumberFormatException exception)
									{
											System.out.print("\nOnly Number! Please try again\n");
											break;
									}
										
										
										list3[num].setCustomerName(customer.get(i).getName());
										double sellingPrice;
										
										try
						    			{
											System.out.print("Pleaes enter the selling price: ");
						    				  sellingPrice = Double.parseDouble(sc4.nextLine());
						    				
						    			}
						    			
						    			catch(NumberFormatException exception)
						    			{
						    					System.out.print("\nOnly Number! Please try again\n");
						    					break;
						    			}
										list3[num].getPrice().setSellingPrice(sellingPrice);
										list3[num].setAvailability("No");
								
										check2 = true;
									}	
								}
								
						}
					
							
						 if (check == true && check2 == true && check3 == true)
						 {	
							 System.out.println("Modify successfully\n");
							artwork.set(num, list3[num]);
						 }
						 else
							 System.out.println("Modify unsuccessful\n");
				
				 break;
			 }
			 case 5:{
				 for (int i = 0; i < count; i++)
					{
						if(list3[i].getArtID().equals(artworkID))
							check = true;
					}
				 
				 
				 	String changedSoldDate;
				 	String datePurchased = null;
		        	int a;
		        	int year =0;
		        	int month=0;
		        	int day =0;
		        try {	
		        	System.out.print("Please enter the new sold date(YYYYMMDD): ");
		        	changedSoldDate = sc4.nextLine();
		        	a = Integer.parseInt(changedSoldDate);
		        	
		        	boolean vdate = false;
		        	
		        		boolean vyear = false;
		        		boolean vmonth = false;
		        		boolean vday = false;
		        	do
		        	{
		        	year = Integer.parseInt(changedSoldDate)  / 10000;
		    		if(year >= 1 && year <= 9999)
		    		{
		    			vyear = true;
		    		
		    		}
		    		
		    		
		    		month = (Integer.parseInt(changedSoldDate) % 10000) / 100;
		    		if(month >=1 && month <=12)
		    		{
		    			vmonth = true;
		    			
		    		}
		    		
		    		day = Integer.parseInt(changedSoldDate)% 100;
		    		if(day >=1 && day <=31)
		    		{
		    			if(month == 1 || month ==3 || month ==5  || month ==7 || month == 8 || month == 10 || month == 12)
		    			{
		    				vday = true;
		    			}
		    		}
		    		if(day >=1 && day <=30) 
		    		{
		    			if(month == 4 || month == 6 || month ==9  || month == 11 )
		    			{
		    				vday = true;
		    			}
		        	}
		        	if(day >=1 && day <=28)
		        	{
		    			if(month ==2)
		    			{
		    				vday = true;
		    			}
		    		}
		        	
		        	if(day >=1 && day <=29)
		        	{
		    			if(month ==2 && year % 4 == 0)
		    			{
		    				vday = true;
		    			}
		    		}
		        	if(vyear == false || vmonth == false || vday == false)
		        	{
		        		System.out.print("Unavailable Date! Please try again");
		        		System.out.print("Date Purchased (YYYYMMDD): ");
		        		changedSoldDate = sc4.nextLine();
			        	a = Integer.parseInt(datePurchased);
		        	}
		        	else
		        		vdate = true;
		        	}while(vdate !=true);
		        	
		    		
		        
		        }
		        	
		        catch(NumberFormatException exception)
				{
						System.out.print("\nOnly Number! Please try again\n");
						break;
				}
					
					 
					 
					 for (int i = 0; i < count; i++)
						{
							if(list3[i].getArtID().equals(artworkID))
							{
								list3[i].setDateSold(changedSoldDate);
								num = i;
								check = true;
							}
						}
					 if (check == true)
					 {
						 artwork.set(num, list3[num]);
						 System.out.println("Modify successfully\n");
					 }	 
					 else
					 {
						 System.out.println("Artwork ID does not exist !!\n");
					 }
				 break;
			 }
			 case 6:{
				 	System.out.print("Please enter the new Customer ID: ");
				 	String changedCustomerID  = sc4.nextLine();
					
					 boolean check2 = false;
					 boolean check3 =false;
					 boolean check4 = false;
					 int num2 =0;
					 
					 String availability = list3[num].getAvailability();
					 
					 int count3 = customer.size();
					 do
					 {
						for (int i =0; i < count3; i++)
						{
							if (customer.get(i).getId().equals(changedCustomerID))
								check4 = true;
								 num2 = i;
						}
						if (check4 == false)
						{
							System.out.println("Customer ID does not exist !!");
							System.out.print("Please enter the new Customer ID: ");
						 	changedCustomerID  = sc4.nextLine();
						}
					 }while(check4 == false);
					 
					 list3[num].setCustomerName(customer.get(num2).getName());
					 
					 if (availability.equals("No"))
					 {	 
						 int y;
						 int z;
						 
						
						 for(y = 0; y<count3; y++)
						 {
							
						
								
								int count2 = customer.get(y).getNumberOfArtwork();
								for (z=0; z < count2; z++) 
								{
									if (customer.get(y).getArrList()[z].getArtID().equals(artworkID))
										check2 = true;
									
									if(customer.get(y).getArrList()[z].getArtID().equals(artworkID) && check2 ==true)
										customer.get(y).deleteArtwork(list3[z]);
								}
								if(check2 == true)
								{	
									if (customer.get(y).getId().equals(changedCustomerID))
									{		
										check3 = true;
										customer.get(y).recordArtwork(list3[num]);
										
									} 
								
								}
							
						}
						 
						 if (check == true && check2 == true && check3 == true)
						 {	
							 System.out.println("Modify successfully\n");
						 	artwork.set(num, list3[num]);
						 }
						 else 
							 System.out.println("Modify unsuccessful\n");
						
					 }
					 else
						 System.out.println("The artwork is not yet been purchased by the customer !!\n");
				 break;
			 }
			 case 7:{
				 	System.out.print("Please enter the new Artist ID: ");
				 	String changedArtistID  = sc4.nextLine();
						
					
					 boolean check2 = false;
					 boolean check3 =false;
					 boolean check4 = false;
					 int num2 =0;
					 
					 int count3 = artist.size();
					 do
					 {
						for (int i =0; i < count3; i++)
						{
							if (artist.get(i).getId().equals(changedArtistID))
								check4 = true;
								 num2 =i;
						}
						if (check4 == false)
						{
							System.out.println("Artist ID does not exist !!");
							System.out.print("Please enter the new Customer ID: ");
						 	changedArtistID  = sc4.nextLine();
						}
					 }while(check4 == false);
					 
					list3[num].setArtistName(artist.get(num2).getName());
								
							
					
					 if (check =true)
					 {	 
						 int y ;
						 int z;
						 
						 for(y =0; y< count3 ; y++)
						 {
						 	int count2 = artist.get(y).getNumberOfArtwork();
							for (z=0; z < count2; z++) 
							{
								if (artist.get(y).getArrList()[z].getArtID().equals(artworkID))
									check2 = true;
								
								if(artist.get(y).getArrList()[z].getArtID().equals(artworkID) && check2 ==true)
									artist.get(y).deleteArtwork(list3[z]);
								
							}	
							if (check2 == true)
							{
								if (artist.get(y).getId().equals(changedArtistID))
								{
									check3 = true;
									artist.get(y).recordArtwork(list3[num]);
								}
									
							}
						
							
						}
						 
						 
						 if (check == true && check2 == true && check3 == true)
						 {	
							 System.out.println("Modify successfully");
						 	artwork.set(num, list3[num]);
						 }
						 else 
							 System.out.println("Modify unsuccessful");
						
					 }
					 else
						 System.out.println("Artwork name does not exist !!");
				
			 }
			 
			 }
			 
			 }
				
		}while(!amdone);
			}
		}
			}
		
	}while(artworkChoice !=6);
				System.out.println("\nReturning to Main Menu...");
			}
			case 4:{
				
				PrintWriter cusOutputFile = new PrintWriter ("customers.txt");
				{
					for (int i=0; i < customer.size(); i++)
					{
						
						String cusId = customer.get(i).getId() ;
						
						String cusName = customer.get(i).getName() ;
						
						String hpNumber = customer.get(i).getHpnumber();
						
						String artistPreference = customer.get(i).getArtistPreference();
						
						cusOutputFile.println(cusId);
						cusOutputFile.println(cusName);
						cusOutputFile.println(hpNumber);
						cusOutputFile.println(artistPreference);
						
					}cusOutputFile.close();
				}
				
				PrintWriter artistOutputFile = new PrintWriter ("artists.txt");
				{
					for (int i=0; i < artist.size(); i++)
					{
						
						String artistId = artist.get(i).getId() ;
						
						String artistName = artist.get(i).getName() ;
						
						String hpNumber = artist.get(i).getHpnumber();
						
						String specialty = artist.get(i).getSpecialty();
						
						String status = artist.get(i).getStatus();
						
						String priceRangeMin = Double.toString(artist.get(i).getPriceRangeMin());
						String priceRangeMax = Double.toString(artist.get(i).getPriceRangeMax());
						
						
						artistOutputFile.println(artistId);
						artistOutputFile.println(artistName);
						artistOutputFile.println(hpNumber);
						artistOutputFile.println(specialty);
						artistOutputFile.println(status);
						artistOutputFile.println(priceRangeMin);
						artistOutputFile.println(priceRangeMax);
						
						
					}artistOutputFile.close();
					
					
				}
				
				PrintWriter artworkOutputFile = new PrintWriter ("artworks.txt");
				{
					
						for (int i=0; i < artwork.size(); i++)
						{
							
							String artId = artwork.get(i).getArtID() ;
							
							String artName = artwork.get(i).getArtName() ;
							
							String datePurchased = artwork.get(i).getDatePurchased();
							
							String dateSold = artwork.get(i).getDateSold();
							
							String availability = artwork.get(i).getAvailability();
							
							String artistName = artwork.get(i).getArtistName();
							
							String customerName = artwork.get(i).getCustomerName();
							
							String sellingPrice = Double.toString(artwork.get(i).getPrice().getSellingPrice());
							String purchasePrice = Double.toString(artwork.get(i).getPrice().getPurchasePrice());
							
							
							artworkOutputFile.println(artId);
							artworkOutputFile.println(artName);
							artworkOutputFile.println(datePurchased);
							artworkOutputFile.println(dateSold);
							artworkOutputFile.println(availability);
							artworkOutputFile.println(artistName);
							artworkOutputFile.println(customerName);
							artworkOutputFile.println(sellingPrice);
							artworkOutputFile.println(purchasePrice);
							
						}artworkOutputFile.close();
						
					
				}
			}
			}
		}while(choice !=4);
	}
}

			