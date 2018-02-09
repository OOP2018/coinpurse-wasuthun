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

	
	/**
	 * Use to print detail of coin
	 */
	@Override
	public String toString() {
		return this.getValue() + "-" + this.getCurrency();
	}

}
