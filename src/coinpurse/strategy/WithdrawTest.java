package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.MalayMoneyFactory;
import coinpurse.MoneyFactory;
import coinpurse.ThaiMoneyFactory;
import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * This class is junit testing for test WithdrawStrategy
 * @author wasuthun wanaphongthipakorn
 *
 */
public class WithdrawTest {
	private WithdrawStrategy strategy, strategy2;
	private ArrayList<Valuable> amount;
	private ArrayList<Valuable> withdraw;
	private MoneyFactory thaimoney, malaymoney;
	private Comparator<Valuable> comp=new ValueComparator();
	/**
	 * Initialize
	 */
	@Before
	public void setUp() {
		strategy = new GreedyWithdraw();
		strategy2 = new RecursiveWithdraw();
		thaimoney = new ThaiMoneyFactory();
		malaymoney = new MalayMoneyFactory();
		amount = new ArrayList<>();
		amount.add(thaimoney.createMoney(500));
		amount.add(thaimoney.createMoney(100));
		amount.add(thaimoney.createMoney(5));
		amount.add(thaimoney.createMoney(1));
		amount.add(thaimoney.createMoney(500));
		amount.add(thaimoney.createMoney(20));
		amount.add(thaimoney.createMoney(5));
		amount.add(thaimoney.createMoney(500));
		amount.add(thaimoney.createMoney(100));
		amount.add(thaimoney.createMoney(5));
	}
	/**
	 * Test withdraw all value in list
	 */
	@Test
	public void testWithdrawAllValue() {
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(1736, "Baht"), amount);
		Collections.sort(withdraw);
		Collections.sort(amount);
		assertEquals(withdraw, amount);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(1736, "Baht"), amount);
		Collections.sort(withdraw);
		Collections.sort(amount);
		assertEquals(withdraw, amount);
	}
	/**
	 * Test withdraw value and left 1 baht value
	 */
	@Test
	public void testWithdrawLeftOne() {
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(1735, "Baht"), amount);
		assertFalse(withdraw.equals(amount));
		Collections.sort(amount,comp);
		Collections.reverse(amount);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(1735, "Baht"), amount);
		assertFalse(withdraw.equals(amount));
	}
	/**
	 * Test impossible case that can't withdraw
	 */
	@Test
	public void testImpossibleWithdraw() {
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(12, "Baht"), amount);
		assertNull(withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(12, "Baht"), amount);
		assertNull(withdraw);
	}
	/**
	 * Test that can't withdraw with different currency
	 */
	@Test
	public void testDifferentCurrency() {
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(12, "Ringgit"), amount);
		assertNull(withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(12, "Ringgit"), amount);
		assertNull(withdraw);
	}
	/**
	 * Test some case that GreedyWithdraw can't withdraw but RecursiveWithdraw can do
	 */
	@Test
	public void testImpossibleGreedy() {
		amount.clear();
		amount.add(thaimoney.createMoney(5));
		amount.add(thaimoney.createMoney(2));
		amount.add(thaimoney.createMoney(2));
		amount.add(thaimoney.createMoney(2));
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(6, "Baht"), amount);
		assertNotNull(withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(6, "Baht"), amount);
		assertNull(withdraw);
	}
	/**
	 * Test withdraw in malay currency
	 */
	@Test
	public void testMultiCurrencyWithdrawMalay() {
		amount.add(malaymoney.createMoney(5));
		amount.add(malaymoney.createMoney(1));
		amount.add(malaymoney.createMoney(1));
		amount.add(malaymoney.createMoney(5));
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(6, "Ringgit"), amount);
		assertNotSame(amount, withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(6, "Ringgit"), amount);
		assertNotSame(amount, withdraw);
	}
	/**
	 * Test withdraw that have more than 1 currency in list
	 */
	@Test
	public void testMultiCurrencyWithdrawThai() {
		amount.add(malaymoney.createMoney(5));
		amount.add(malaymoney.createMoney(1));
		amount.add(malaymoney.createMoney(1));
		amount.add(malaymoney.createMoney(5));
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(6, "Baht"), amount);
		assertNotSame(amount, withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(6, "Ringgit"), amount);
		assertNotSame(amount, withdraw);
	}
	/**
	 * Test that can't withdraw minus money
	 */
	@Test
	public void testMinusWithdraw() {
		withdraw = (ArrayList<Valuable>) strategy2.withdraw(new Coin(-1, "Baht"), amount);
		assertNull(withdraw);
		withdraw = (ArrayList<Valuable>) strategy.withdraw(new Coin(-1, "Baht"), amount);
		assertNull(withdraw);
	}

}
