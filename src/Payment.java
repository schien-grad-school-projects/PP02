import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Payment {

    public static Validation validating;
    public static HashCode hashing;
    public static Customer[] customers;
    public static int customerPointer = 0;

    // this will check whether a card is valid
    public static Boolean isValidCard(String number) {
        return validating.aValidNumber(number);
    }// end of the isValidCard method

    // creates a hash code for the credit card number to be stored in file
    public static String createHashCode(String number) {
        return hashing.getHashCode(number);
    }// end of the createHashCode method


    // it adds a new customer to the array of customers once the payment was successful
    public static void addCustomer(Customer customer) {
        customers[customerPointer++] = customer;
    } // end of the addCustomer method


    // it displays the payments AVG, MAX payment, and MIN payment,
    // only for accepted payments with valid cards
    public static void displayStat() {

        Customer minCustomer = customers[0];
        int minIndex = 0;

        Customer maxCustomer = customers[0];
        int maxIndex = 0;

        double sumAmounts = 0.0;

        for (int i = 0; i < customers.length; i++) {

            //Find the min
            if (minCustomer.getAmount() > customers[i].getAmount()) {
                minCustomer = customers[i];
                minIndex = i;
            }

            //Find the max
            if (maxCustomer.getAmount() < customers[i].getAmount()) {
                maxCustomer = customers[i];
                maxIndex = i;
            }

            sumAmounts += customers[i].getAmount();
        }

        double averagePayments = sumAmounts / customers.length;

        //Display
        String out = "";
        for (int i = 0; i < customers.length; i++) {
            out += (i + 1) + ": " + customers[i].toString() + "\n";
        }

        out += "--------------------------------------------------------------------------------------------\n";
        out += "Minimum payment\t" + "Payment: $" + String.format("%.2f", customers[minIndex].getAmount()) +
                "\tCustomer: " + customers[minIndex].toString() + "\n";
        out += "Maximum payment\t" + "Payment: $" + String.format("%.2f", customers[maxIndex].getAmount()) +
                "\tCustomer: " + customers[maxIndex].toString() + "\n";
        out += "Average payment\t" + "Payment: $" + String.format("%.2f", averagePayments) + "\n";

        JOptionPane.showMessageDialog(null, new JTextArea(out));
    }


    // write data to file, the credit card number should be encrypted
    // using one-way hash method in the Hashing class
    public static void writeToFile() {
        try {
            FileWriter writer = new FileWriter("customer_info.txt");
            for (Customer customer : customers) {
                String customerInfo = customer.getId() + "," + customer.getfName() + "," +
                        customer.getlName() + "," + customer.getAmount() + "," +
                        createHashCode(String.valueOf(customer.getCard())) + "\n";
                writer.write(customerInfo);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    } // end of the writeToFile method


    // the main entry method of the program that will get data from user and
    // perform the business logic
    public static void main(String[] args) {

        hashing = new HashCode();
        validating = new Validation();

        // input the number of customers and store it into variable n
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog("Input number of Customers"));
                if (n <= -1)
                    throw new NumberFormatException();
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number of customers Format");
            }
        }

        customers = new Customer[n];
        String fName = "";
        String lName = "";
        int id = 0;
        double amount = 0.0;
        long number = 0l;
        String expDate = "";


        for (int i = 0; i < n; i++) {
            while (true) {
                fName = JOptionPane.showInputDialog("Input Customer First Name");
                if (fName.isEmpty() || fName.equals(" ") || !fName.matches("[a-zA-Z]+"))
                    JOptionPane.showMessageDialog(null, "Invalid Name Format");
                else break;
            }

            while (true) {
                lName = JOptionPane.showInputDialog("Input Customer Last Name");
                if (lName.isEmpty() || lName.equals(" ") || !lName.matches("[a-zA-Z]+"))
                    JOptionPane.showMessageDialog(null, "Invalid Name Format");
                else break;
            }

            while (true) {
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog("Input Customer ID"));
                    if (id <= -1)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Customer ID Format");
                }
            }

            //If id is zero we should stoop accepting the user input per rule #9
            if (id == 0)
                break;

            while (true) {
                try {
                    String ccNum = JOptionPane.showInputDialog("Input Customer Credit Card Number");

                    if (lName.isEmpty() || lName.equals(" "))
                        throw new NumberFormatException();

//                    boolean isValid = isValidCard(ccNum);
//                    if (!isValid)
//                        throw new NumberFormatException();


                    number = Long.parseLong(ccNum);
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Credit Card Number Format");
                }
            }

            while (true) {
                expDate = JOptionPane.showInputDialog("Input Customer Credit Card Expiration Date");
                if (expDate.isEmpty() || expDate.equals(" "))
                    JOptionPane.showMessageDialog(null, "Invalid Credit Card Expiration Date Format");
                else break;
            }

            while (true) {
                try {
                    amount = Double.parseDouble(JOptionPane.showInputDialog("Input Customer Payment Amount"));
                    if (amount < 1)
                        throw new NumberFormatException();
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Payment Amount");
                }
            }

            CreditCard creditCard = new CreditCard(number, expDate);
            Customer customer = new Customer(fName, lName, id, amount, creditCard);
            String out = "Successfully processed payment for:\n" + customer.toString();
            JOptionPane.showMessageDialog(null, new JTextArea(out));

            addCustomer(customer);
        }


        displayStat();
        writeToFile();
    }

}
