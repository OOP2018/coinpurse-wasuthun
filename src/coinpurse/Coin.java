package coinpurse;
/**
 * this class is use to build object of Coin for used
 * @author wasuthun wanaphongthipakorn
 *
 */
public class Coin implements Comparable<Coin> {
	/*
 	* value of coin
 	*/
	private double value;
	/*
	 * currency of coin
	 */
	private String currency;
	/**
	 * Constructor of coin
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * use to access value of coin
	 * @return value of coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * use to access currency of coin
	 * @return currency of coin
	 */
	public String getCurrency() {
		return this.currency;
	}

	@Override
	/**
	 * this method used to check a coin if coin is equal object return true else false
	 * @return result of checking a coin and obj
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		return (other.getCurrency() == this.getCurrency()) && (other.getValue() == this.getValue());
	}

	@Override
	/**
	 * this method is use to compare value of coin
	 * @return integer if equal return 0 if less than return -1 if more than return 1 
	 */
	public int compareTo(Coin o) {
		if (this.getValue() == o.getValue())
			return 0;
		else if (this.getValue() > o.getValue())
			return 1;
		else
			return -1;
	}

	
	@Override
	/**
	 * use to print detail of coin
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}

}
