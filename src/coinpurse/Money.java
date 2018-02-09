package coinpurse;

public class Money implements Valuable {
	/**
	 * Value of money
	 */
	private double value;
	/**
	 * Currency of money
	 */
	private String currency;

	/**
	 * Constructor
	 * 
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	/**
	 * Use to access a value of Money
	 * @return value of Money in double type
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	/**
	 * Use to access a currency of Money
	 * @return String of currency of Money
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	/**
	 * This method used to check a Money if Money is equal object return true else false
	 * @return result of checking a coin and obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Money other = (Money) obj;
		return other.getCurrency().equalsIgnoreCase(this.getCurrency()) && other.getValue() == this.getValue();
	}
	/**
	 * This method is use to compare value of Money
	 * @return integer if equal return 0 if less than return -1 if more than return 1 
	 */
	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().compareTo(o.getCurrency()) == 0) {
			if (this.getValue() > o.getValue())
				return 1;
			else if (this.getValue() < o.getValue())
				return -1;
			else
				return 0;
		}
		return this.getCurrency().compareTo(o.getCurrency());
	}

}
