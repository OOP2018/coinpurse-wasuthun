package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;
/**
 * This class is implement a WithdrawStrategy for use Strategy pattern and use greedy algorithm method
 * @author wasuthun wanaphongthipakorn
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{
/**
 * This method use to withdraw a Valuable by using greedy algorithm method
 * @param amount
 * @param valuables
 * @return List of Valuable that can withdraw
 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
		ArrayList<Valuable> templist = new ArrayList<>();
		double amounts=amount.getValue();

 
		for (Valuable coin : valuables) {
			if (amounts >= 0) {
		
				if (coin.getValue() <= amounts && coin.getCurrency().equalsIgnoreCase(amount.getCurrency())) {
					amounts -= coin.getValue();
					templist.add(coin);
				}
			} else {
				return null;
			}
		}
		if(amounts==0) return templist;
			 return null;
	}

}
