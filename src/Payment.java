import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number){
		return validating.aValidNumber(number);
	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number){

		return null;

	}// end of the createHashCode method


     // it adds a new customer to the array of customers once the payment was successful
 	 public static void addCustomer(Customer customer){
		 List<Customer> c = Arrays.asList(customers);
		 c.add(customer);
		 customers = c.stream().toArray(Customer[]::new);
 	 } // end of the addCustomer method


	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){

	}// end of the displayStat method


	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile(){

    } // end of the writeToFile method


	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) {

		hashing = new HashCode();
		validating = new  Validation();

	   // input the number of customers and store it into variable n
	    int n = DataEntries.intInput("Input number of Customers");

		customers = new Customer[n];
		String fName = "";
		String lName = "";
		int id = 0;
		double amount = 0.0;
		long number = 0l;
		String expDate = "";


		for (int i = 0; i < n; i++) {
			fName = DataEntries.strInput("Input Customer First Name");
			lName = DataEntries.strInput("Input Customer Last Name");
			id = DataEntries.intInput("Input Customer ID");
			number = DataEntries.longInput("Input Customer Credit Card Number");
			expDate = DataEntries.strInput("Input Customer Credit Card Expiration Date");
			amount = DataEntries.doubleInput("Input Customer Payment Amount");

			CreditCard creditCard = new CreditCard(number, expDate);
			Customer customer = new Customer(fName, lName, id, amount, creditCard);
			addCustomer(customer);
		}


	}

}
