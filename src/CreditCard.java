//*********************************************************************
//*                                                                   *
//* CIS611                   Spring 2023               Trenton Schien *
//*                                                    Jose Escobar   *
//*                      Program Project PP02                         *
//*                                                                   *
//*                  This is a Credit card object                     *
//*                                                                   *
//*                                                                   *
//*                           3-9-2023                                *
//*                                                                   *
//*                  Saved in: CreditCard.java                        *
//*                                                                   *
//*********************************************************************
public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "credit card=" + number +
				", exp date='" + expDate + '\'';
	}
}
