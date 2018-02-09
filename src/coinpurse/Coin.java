package coinpurse;
/**
 * This class is use to build object of Coin for used
 * @author wasuthun wanaphongthipakorn
 *
 */
public class Coin extends Money{
	/**
	 * Constructor of coin
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	@Override
	/**
	 * Use to print detail of coin
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}

}
