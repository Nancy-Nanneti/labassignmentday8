package labassignment8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Mainmethod {
	public static void main(String args[]) {
		List<Transaction> transactionList = getAllTransactions();

//	1. Find all transactions in the year 2011 and sort them by value (small to high)
    System.out.println(" Find all transactions in the year 2011 and sort them by value (small to high)");
	List<Transaction> listalltransactionyear2011=
    		             transactionList.stream().
	                     filter(year->year.getYear()==2011).                                   
    		             sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).
	                     collect(Collectors.toList());
	   listalltransactionyear2011.forEach(list->System.out.println(list));
		
		//2. What are all the unique cities where the traders work?
	System.out.println("\n2. What are all the unique cities where the traders work?");
    List<Trader> getAllTraders=
    		               transactionList.stream().
    		               map(transaction->transaction.getTrader()).
    		               distinct().
    		               collect(Collectors.toList());
    List<String> getAllTrasersCity=getAllTraders.stream().
    		                map(trader->trader.getCity()).
    		                collect(Collectors.toList());
    		      System.out.println(getAllTrasersCity);  
    		      
           // 3. Find all traders from Delhi and sort them by name.
        System.out.println("\n3.Find all traders from Delhi and sort them by name.   ");
        List<Trader> getAllTradersDelhi=getAllTraders.stream().
        		            filter(city->city.getCity().equals("delhi")).
        		            sorted((o1, o2)->o1.getName().compareTo(o2.getName())).
        		            collect(Collectors.toList());
	getAllTradersDelhi.forEach(trader->System.out.println(trader));
	
  //4. Return a string of all traders names sorted alphabetically. 
    System.out.println("\n4. Return a string of all traders names sorted alphabetically. ");
    List<Trader> getAllTraderSortedAlpha=getAllTraders.stream().
    		                 sorted((o1,o2)->o1.getName().compareTo(o2.getName())).
    		                 collect(Collectors.toList());
    System.out.println(getAllTraderSortedAlpha);
	
//	5. Are any traders based in Jaipur?
		System.out.println("\n5. Are any traders based in Jaipur?");
       boolean getAnyTradersJaipur=getAllTraders.stream().
    		                      anyMatch(trader->trader.getCity().equals("jaipur"));
    	 if (getAnyTradersJaipur)
       			System.out.println("Yes! some traders are from jaipur");
    	 else 
    		  	System.out.println("No traiders are from jaipur");

          //6. Print all transactions values from the traders living in delhi
         System.out.println("\n6. Print all transactions values from the traders living in delhi");
                  List<Integer> printValuesInDelhi = transactionList.stream().
    					         filter(city -> city.getTrader().getCity().equals("delhi")).
    					         map(value -> value.getValue()).
    					         collect(Collectors.toList());
    			printValuesInDelhi.forEach(getValue -> System.out.println(getValue));

           //7. Whats the highest value of all the transactions?
    		System.out.println("\n7. Whats the highest value of all the transactions?");
    				OptionalInt highestValueFromTransactions = transactionList.stream().
    						                 mapToInt(value -> value.getValue()).
    						                 max();
    				System.out.println(highestValueFromTransactions); 
             // 8. Find the transaction with the smallest value
    		System.out.println("\n8. Find the transaction with the smallest value");
        	List<Transaction> transactionWithSmallerValue = transactionList.stream().
        			           limit(1).
    						   sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).
    						   collect(Collectors.toList());
    				System.out.println(transactionWithSmallerValue);

    }
	private static List<Transaction> getAllTransactions() {

		Trader ram = new Trader("ram", "delhi");
		Trader kapil = new Trader("kapil", "noida");
		Trader raj = new Trader("raj", "banglore");
		Trader ekta = new Trader("ekta", "banglore");
		
		List<Transaction> transactions = Arrays.asList(new Transaction(ram, 2011, 300),
				new Transaction(ram, 2012, 1000),
				new Transaction(kapil, 2011, 400), 
				new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700), 
				new Transaction(ekta, 2012, 950));

		return transactions;
	}

}


    		                      
    		   
    		           
