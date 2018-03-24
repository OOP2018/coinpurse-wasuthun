package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;
/**
 * This class is implement a WithdrawStrategy for use Strategy pattern and use recursive
 * @author wasuthun wanaphongthipakorn
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	/**
	 * This method use to withdraw a Valuable by using recursive
	 * @param amount
	 * @param valuables
	 * @return List of Valuable that can withdraw
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
		double amounts = amount.getValue();
		if (amounts == 0)
			return new ArrayList<>();
		if (amounts != 0 && valuables.isEmpty())
			return null;
		List<Valuable> templist = withdraw(new Money(amounts - valuables.get(0).getValue(), amount.getCurrency()),
				valuables.subList(1, valuables.size()));
		List<Valuable> templist2 = withdraw(new Money(amounts, amount.getCurrency()),
				valuables.subList(1, valuables.size()));
		if (templist != null) {
			templist.add(valuables.get(0));
			return templist;
		}
		if (templist2 != null) {
			return templist2;
		}
		return null;

	}

}
