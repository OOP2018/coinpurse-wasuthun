package coinpurse;
/**
 * this class is a interface of Coin and BankNote
 * @author wasuthun wanaphongthipakorn
 *
 */
public interface Valuable {
	/**
	 * use to access a value of Valuable
	 * @return value of Valuable in double type
	 */
	public double getValue();
	/**
	 * use to access a currency of Valuable
	 * @return String of currency of Valuable
	 */
	public String getCurrency();
}
