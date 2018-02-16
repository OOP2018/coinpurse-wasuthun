package coinpurse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the MoneyFactory using JUnit. This is a JUnit 4 test suite.
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 * 
 * @author wasuthun wanaphongthipakorn
 * @version 2018.01.19
 */
public class MoneyFactoryTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private MoneyFactory factory;

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
	  	ResourceBundle bundle = ResourceBundle.getBundle("purse");
				String factoryclass = bundle.getString("moneyfactory");
				factory = null;
				try {
					factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
				} catch (ClassCastException cce) {
					System.out.println(factoryclass + " is not type MoneyFactory");
				} catch (Exception ex) {
					System.out.println("Error creating MoneyFactory " + ex.getMessage());
				}
				if (factory == null)
					System.exit(1);
				else 
					factory.setMoneyFactory(factory);
	}

	/** Make a Valuable with the default currency. Use MoneyFactory */
	private Valuable makeValuableUseMoneyFactory(double value) {
				factory=factory.getInstance();
				return factory.createMoney(value);
				
	}
 /**
  * Test a MoneyFactory is Singleton or not
  */
	@Test
	public void testSingleton() {
		MoneyFactory instance1 = MoneyFactory.getInstance();		
		MoneyFactory instance2 = MoneyFactory.getInstance();			
	    assertEquals(true, instance1==instance2);	

	}

	/** Insert some coins. Easy test. */
	@Test
	public void testInsert() {
		Purse purse = new Purse(3);
		Valuable coin1 = makeValuableUseMoneyFactory(5);
		Valuable coin2 = makeValuableUseMoneyFactory(10);
		Valuable coin3 = makeValuableUseMoneyFactory(1);
		assertTrue(purse.insert(coin1));
		assertTrue(purse.insert(coin3));
		assertTrue(purse.insert(coin2));
		assertEquals(3, purse.count());
		// purse is full so insert should fail
		assertFalse(purse.insert(makeValuableUseMoneyFactory(1)));
	}


	@Test(timeout = 1000)
	public void testIsFull() { // borderline case (capacity 1)
		Purse purse = new Purse(1);
		assertFalse(purse.isFull());
		purse.insert(makeValuableUseMoneyFactory(1));
		assertTrue(purse.isFull());
		// real test
		int capacity = 4;
		purse = new Purse(capacity);
		
			assertFalse(purse.isFull());
			purse.insert(makeValuableUseMoneyFactory(0.25));
			assertFalse(purse.isFull());
			purse.insert(makeValuableUseMoneyFactory(0.5));
			assertFalse(purse.isFull());
			purse.insert(makeValuableUseMoneyFactory(5));
			assertFalse(purse.isFull());
			purse.insert(makeValuableUseMoneyFactory(1000));
			
		// should be full now
		assertTrue(purse.isFull());
		assertFalse(purse.insert(makeValuableUseMoneyFactory(5)));
	}

	/**
	 * Should be able to insert same Valuable many times, since spec doesn't say
	 * anything about this.
	 */
	@Test(timeout = 1000)
	public void testInsertSameCoin() {
		int capacity = 5;
		double value = 10.0;
		Purse purse = new Purse(capacity);
		Valuable coin = makeValuableUseMoneyFactory(value);
		assertTrue(purse.insert(coin));
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertTrue(purse.insert(coin)); // should be allowed
		assertEquals(purse.getBalance(), 5 * value, TOL);
	}

	/**
	 * test a insert BankNote and Coin and test Balance
	 */
	@Test(timeout = 1000)
	public void insertBankCoinAndGetBalance() {
		Purse purse = new Purse(3);
		Valuable coin1 = makeValuableUseMoneyFactory(20);
		Valuable coin2 = makeValuableUseMoneyFactory(5);
		Valuable coin3 = makeValuableUseMoneyFactory(1);
		assertTrue(purse.insert(coin1));
		assertTrue(purse.insert(coin3));
		assertTrue(purse.insert(coin2));
		assertEquals(3, purse.count());
		// purse is full so insert should fail
		assertFalse(purse.insert(makeValuableUseMoneyFactory(1)));
		assertEquals(purse.getBalance(), 26.0, TOL);
	}

	/** Add one Valuable and remove it. */
	@Test(timeout = 1000)
	public void easyWithdrawBankCoin() {
		Purse purse = new Purse(10);
		double[] values = { 1, 20, 50, 1000 }; // values of coins we will insert

		for (double value : values) {
			Valuable coin = makeValuableUseMoneyFactory(value);
			assertTrue(purse.insert(coin));
			assertEquals(value, purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue(result != null);
			assertEquals(1, result.length);
			assertSame(coin, result[0]); // should be same object
			assertEquals(0, purse.getBalance(), TOL);
		}
	}

	/** Add one Valuable and remove it. */
	@Test(timeout = 1000)
	public void testEasyWithdraw() {
		Purse purse = new Purse(10);
		double[] values = { 1, 20, 0.5, 10 }; // values of coins we will insert

		for (double value : values) {
			Valuable coin = makeValuableUseMoneyFactory(value);
			assertTrue(purse.insert(coin));
			assertEquals(value, purse.getBalance(), TOL);
			Valuable[] result = purse.withdraw(value);
			assertTrue(result != null);
			assertEquals(1, result.length);
			assertSame(coin, result[0]); // should be same object
			assertEquals(0, purse.getBalance(), TOL);
		}
	}

	/** Add 4 Valuable and then withdraw in pairs, but not in same order. */
	@Test(timeout = 1000)
	public void testMultiWithdraw() {
		Purse purse = new Purse(10);
		Valuable[] coins = { makeValuableUseMoneyFactory(5.0), makeValuableUseMoneyFactory(10.0), makeValuableUseMoneyFactory(1.0), makeValuableUseMoneyFactory(5.0) };
		// insert them all
		for (Valuable coin : coins)
			assertTrue(purse.insert(coin));

		double amount1 = coins[1].getValue() + coins[3].getValue();
		double amount2 = coins[0].getValue() + coins[2].getValue();
		assertEquals(amount1 + amount2, purse.getBalance(), TOL);

		// System.out.println("trying to withdraw: " + amount1);
		// System.out.println(purse.getBalance());
		Valuable[] wd1 = purse.withdraw(amount1);
		assertEquals(amount1, sum(wd1), TOL);

		assertEquals(amount2, purse.getBalance(), TOL);
		Valuable[] wd2 = purse.withdraw(amount2);

		// should be empty now
		assertEquals(0, purse.getBalance(), TOL);
	}

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout = 1000)
	public void testWithdrawEverything() {
		Purse purse = new Purse(10);
		// Coins we want to insert and then withdraw.
		// Use values such that greedy will succeed, but not monotonic
		List<Valuable> coins = Arrays.asList(makeValuableUseMoneyFactory(1.0), makeValuableUseMoneyFactory(0.5), makeValuableUseMoneyFactory(10.0), makeValuableUseMoneyFactory(0.25),
				makeValuableUseMoneyFactory(5.0));
		// num = number of Valuable to insert and then withdraw
		for (int num = 1; num <= coins.size(); num++) {
			double amount = 0.0;
			List<Valuable> subList = coins.subList(0, num);
			for (Valuable c : subList) {
				purse.insert(c);
				amount += c.getValue();
			}
			// balance should be exactly what we just inserted
			assertEquals(amount, purse.getBalance(), TOL);
			// can we withdraw it all?
			Valuable[] result = purse.withdraw(amount);
			String errmsg = String.format("couldn't withdraw %.2f but purse has %s", amount,
					Arrays.toString(subList.toArray()));
			assertNotNull(errmsg, result);
			// is the amount correct?
			assertEquals("Withdraw wrong amount", amount, sum(result), TOL);
			// should not be anything left in the purse
			assertEquals(0.0, purse.getBalance(), TOL);
		}
	}

	@Test(timeout = 1000)
	public void testImpossibleWithdraw() {
		Purse purse = new Purse(10);
		assertNull(purse.withdraw(1));
		purse.insert(makeValuableUseMoneyFactory(20));
		assertNull(purse.withdraw(1));
		assertNull(purse.withdraw(19));
		assertNull(purse.withdraw(21));
		purse.insert(makeValuableUseMoneyFactory(20)); // now it has 20 + 20
		assertNull(purse.withdraw(30));
	}

	/**
	 * Sum the value of some Valuable.
	 * 
	 * @param wd1
	 *            array of Valuable
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] wd1) {
		if (wd1 == null)
			return 0.0;
		double sum = 0;
		for (Valuable c : wd1)
			if (c != null)
				sum += c.getValue();
		return sum;
	}
}
