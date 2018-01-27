package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * this class is use to show a 2 method filterByCurrency,sortCoins
 * @author wasuthun wanaphongthiapkorn
 *
 */
public class MoneyUtil {
/**
 * this method is use to filter a Valuable by using currency
 * @param valuable
 * @param currency
 * @return list of coin with same currency in parameter
 */
	public static List<Valuable> filterByCurrency(List<Valuable> valuable,String currency){
		List<Valuable> listcurrency=new ArrayList<>();
		for (Valuable coin : valuable) {
			if(coin.getCurrency().equals(currency)) {
				listcurrency.add(coin);
			}
		}
		return listcurrency;
	}
	/**
	 * this method is use to print by printSort and sort valuable
	 * @param valuable
	 */
	public static void sortCoins(List<Valuable> valuable) {
		Collections.sort(valuable,new ValueComparator());
		printSort(valuable);
	}
	/**
	 * Used print a valuable
	 * @param valuable
	 */
	public static void printSort(List<Valuable> valuable) {
		for (Valuable coin : valuable) {
			System.out.println(coin.toString());
		}
	}
	/**
	 * Main method to show method of this class
	 * @param args
	 */
	public static void main(String[] args) {
		Purse p=new Purse(6);
		p.insert(new Coin(3, "Bath"));
		p.insert(new Coin(4, "Dollar"));
		p.insert(new Coin(2, "Bath"));
		p.insert(new Coin(7,"Bath"));
		p.insert(new BankNote(20, "Bath"));
		p.insert(new BankNote(50, "Bath"));
		System.out.println(p.toString());
		System.out.println(filterByCurrency(p.getMoney(), "Bath").toString());
		sortCoins(p.getMoney());
		
	}
}
