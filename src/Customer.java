//*********************************************************************
//*                                                                   *
//* CIS611                   Spring 2023               Trenton Schien *
//*                                                    Jose Escobar   *
//*                      Program Project PP02                         *
//*                                                                   *
//*                 This is a Customer card object                    *
//*                                                                   *
//*                                                                   *
//*                           3-9-2023                                *
//*                                                                   *
//*                   Saved in: Customer.java                         *
//*                                                                   *
//*********************************************************************
public class Customer {

    private int id;

    private String fName, lName;
    private double amount;
    private CreditCard card;

    public Customer(String fName, String lName, int id, double amount, CreditCard card) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.amount = amount;
        this.card = card;

    }
//TODO add setters
    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    public double getAmount() {
        return amount;
    }

    public CreditCard getCard() {
        return card;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "name=" + fName +
                " " + lName +
                ", payment= $" + String.format("%.2f", amount) +
                ", " + card.toString();
    }
}
