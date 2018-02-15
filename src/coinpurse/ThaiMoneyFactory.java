package coinpurse;

/**
 * This class use to create Thai Valuable
 * 
 * @author wasuthun wanaphongthipakorn
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/**
	 * This method is override abstract method from super class and use to create
	 * Thai Valuable
	 * 
	 * @return Thai Valuable
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value, "Baht", nextSerialNumber++);
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 0.25 || value == 0.50)
			return new Coin(value, "Baht");
		else
			throw new IllegalArgumentException();
	}

}
