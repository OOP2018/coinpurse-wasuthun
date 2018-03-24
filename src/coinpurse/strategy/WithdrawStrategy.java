package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;
/**
 * This interfaces use for strategy pattern
 * @author wasuthun wanaphongthipakorn
 *
 */
public interface WithdrawStrategy {
	/**
	 * Use for withdraw a Valuable for each currency in valuables
	 * @param amount
	 * @param valuables
	 * @return result of list that can withdraw
	 */
	public List<Valuable> withdraw(Valuable amount,List<Valuable> valuables);
}
