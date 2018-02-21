package coinpurse;
/**
 * MoneyFactory use to create a Valuable
 * @author wasuthun wanaphongthipakorn
 *
 */
public abstract class MoneyFactory {
	/**
	 * This is a instance object
	 */
	private static MoneyFactory factory = null;


	/**
	 * Instance method
	 * 
	 * @return instance object
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}
	/**
	 * Constructor
	 */
	protected MoneyFactory() {
		
	}
	/**
	 * Abstract method for create Valuable by using parameter double
	 * 
	 * @param value
	 * @return Valuable of value
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Method for create Valuable by using parameter String 
	 * 
	 * @param value
	 * @return Valuable of value
	 */
	public Valuable createMoney(String value) {
		try {
			Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("Sorry, " + value + " is not a valid value.");
		}
		return createMoney(Double.parseDouble(value));
	}

	/**
	 * Use to set value of instance object
	 * 
	 * @param factorys
	 */
	public static void setMoneyFactory(MoneyFactory factorys) {
		factory = factorys;
	}
}
