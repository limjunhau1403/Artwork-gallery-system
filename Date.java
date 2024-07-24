import java.util.Scanner; 

public class Date {
	public static void main(String [] args)
	{
		int day=0;
		int month=0;
		int year =0;
		try {
		System.out.print("Date Purchased (YYYY/MM/DD): ");
		Scanner sc1 = new Scanner(System.in);
		String datePurchased;
        datePurchased = sc1.nextLine();
        	int a = Integer.parseInt(datePurchased);
        	
        	boolean vdate = false;
        	do {
        		boolean vyear = false;
        		boolean vmonth = false;
        		boolean vday = false;
        	
        	year = Integer.parseInt(datePurchased)  / 10000;
    		if(year >= 1 && year <= 9999)
    		{
    			vyear = true;
    		
    		}
    		
    		
    		month = (Integer.parseInt(datePurchased) % 10000) / 100;
    		if(month >= 1 && month <= 12)
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
    			if(month == 2)
    			{
    				vday = true;
    			}
    		}
        	int b = year % 4;
        	
        	
        	if(day >=1 && day <=29)
        	{
    			if(month ==2 && b ==0)
    			{
    				vday = true;
    			}
    		}
        	if(vyear == false || vmonth == false || vday == false)
        	{
        		System.out.print("Unavailable Date! Please try again\n");
        		System.out.print("Date Purchased (YYYY/MM/DD): ");
        		datePurchased = sc1.nextLine();
        	}
        	else
        	{
        		vdate = true;
        	}
        	
        	
        	}while(vdate !=true);
        	
     
        	System.out.println("\nDate Format using getInstance():"+ day+" " + month+" "+ year);
        }
        	
        catch(NumberFormatException exception)
		{
				System.out.print("\nOnly Number! Please try again\n");
		}
		
	
	}
}