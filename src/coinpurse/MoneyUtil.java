package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * this closs is use to show a 2 method filterByCurrency,sortCoins
 * @author wasuthun wanaphongthiapkorn
 *
 */
public class MoneyUtil {
/**
 * this method is use to filter a coin by using currency
 * @param coins
 * @param currency
 * @return list of coin with same currency in parameter
 */
	public static List<Coin> filterByCurrency(List<Coin> coins,String currency){
		List<Coin> listcurrency=new ArrayList<>();
		for (Coin coin : coins) {
			if(coin.getCurrency().equals(currency)) {
				listcurrency.add(coin);
			}
		}
		return listcurrency;
	}
	/**
	 * this method is use to print by printSort and sort coin
	 * @param coins
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
		printSort(coins);
	}
	/**
	 * Used print a coin
	 * @param coins
	 */
	public static void printSort(List<Coin> coins) {
		for (Coin coin : coins) {
			System.out.println(coin.toString());
		}
	}
	/**
	 * Main method to show method of this class
	 * @param args
	 */
	public static void main(String[] args) {
		Purse p=new Purse(4);
		p.insert(new Coin(3, "Bath"));
		p.insert(new Coin(4, "rupee"));
		p.insert(new Coin(2, "Bath"));
		p.insert(new Coin(7,"Bath"));
		System.out.println(filterByCurrency(p.getMoney(), "Bath").toString());
		sortCoins(p.getMoney());
		
	}
}
