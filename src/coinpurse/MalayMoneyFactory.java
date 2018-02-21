package coinpurse;

/**
 * This class use to create Malay Valuable
 * 
 * @author wasuthun wanaphongthipakorn
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	/**
	 * This is a next serial number of each BankNote that start from 1000000
	 */
	protected static long nextSerialNumber = 1000000;
	/**
	 * This method is override abstract method from super class and use to create
	 * Malay Valuable
	 * 
	 * @return Malay Valuable
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5)
			return new Coin(value, "Ringgit");

		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100)
			return new BankNote(value, "Ringgit", nextSerialNumber++);
		else
			throw new IllegalArgumentException("Malaysia doesn't have "+value+" note");
	}

}
