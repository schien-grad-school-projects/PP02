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

    @Override
    public String toString() {
        return "Name= " + fName + " " + lName + " ,Id=" + id
                + " ,Payment= $" + String.format("%.2f", amount);
    }
}
