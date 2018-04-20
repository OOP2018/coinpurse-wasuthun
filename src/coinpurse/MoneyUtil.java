package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * This class is use to show a 2 method filterByCurrency,sortCoins
 * @author wasuthun wanaphongthiapkorn
 *
 */
public class MoneyUtil {
/**
 * This method is use to filter a Valuable by using currency
 * @param valuable
 * @param currency
 * @return list of coin with same currency in parameter
 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> valuable,String currency){
		List<E> listcurrency=new ArrayList<>();
		for (E coin : valuable) {
			if(coin.getCurrency().equals(currency)) {
				listcurrency.add(coin);
			}
		}
		return listcurrency;
	}
	/**
	 * This method is use to print by printSort and sort valuable
	 * @param valuable
	 */
	public static void sortMoney(List<?extends Valuable> valuable) {
		Collections.sort(valuable,new ValueComparator());
		printSort(valuable);
	}
	/**
	 * Used print a valuable
	 * @param valuable
	 */
	public static void printSort(List<?extends Valuable> valuable) {
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
		p.insert(new BankNote(20, "Bath",100000));
		p.insert(new BankNote(50, "Bath",100001));
		System.out.println(p.toString());
		System.out.println(filterByCurrency(p.getMoney(), "Bath").toString());
		sortMoney(p.getMoney());
		System.out.println("------");
		Money m1=new BankNote(100, "Bath", 100002);
		Money m2=new BankNote(500, "Bath", 100003);
		Money m3=new Coin(20,"Bath");
		Money max= MoneyUtil.max(m1,m2,m3);
		System.out.println(max);
		String max2=MoneyUtil.max("dog","zebra","cat");
		System.out.println(max2);
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10, "USD", 1000000));
		list.add(new BankNote(500, "Bath", 1000001));
		MoneyUtil.sortMoney(list);
		List<Coin> coins = Arrays.asList( new Coin(5,"Baht"), new Coin(0.1,"Ringgit"), new Coin(5,"Cent") );
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht"); 
		System.out.println(result);		
		
		
	}
	/**
	 * Use to find a max of array args
	 * @param args
	 * @return max value by use compareTo in E type in args
	 */
	public static <E extends Comparable<? super E>> E max(E ... args) throws IllegalArgumentException {
		if(args.length==0)return null;
			E max=args[0];
		for (int i = 0; i < args.length; i++) {
			if(args[i].compareTo(max)>0) {
			max=args[i];
			}
		}
		return max;
	    
	}
}
