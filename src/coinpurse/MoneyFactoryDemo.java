package coinpurse;

import java.util.ResourceBundle;

/**
 * This class use to test MoneyFactory class
 * 
 * @author wasuthun wanaphongthipakorn
 *
 */
public class MoneyFactoryDemo {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		MoneyFactory factory2 =null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		else {
			factory.setMoneyFactory(factory);
			factory = factory.getInstance();
			factory2=factory2.getInstance();
			System.out.print("Test MoneyFactory is Singleton ");
			System.out.println(factory2==factory);
			Purse p = new Purse(5);
			p.insert(factory.createMoney("5"));
			p.insert(factory.createMoney(0.25));
			p.insert(factory.createMoney(0.5));
			p.insert(factory.createMoney(20));
			p.insert(factory.createMoney(1000));
			for (Valuable v : p.getMoney()) {
				System.out.println(v.toString());
			}
			System.out.println(p.toString());
		}
	}
}
