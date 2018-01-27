package coinpurse;

import java.util.Comparator;
/**
 *  this class have a method to compare 2 Valuable
 * @author wasuthun wanaphongthipakorn
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 *  Compare two objects that implement Valuable.
	 * First compare them by currency.
	 * If both objects have the same currency, order them by value.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		if(o1.getCurrency().compareTo(o2.getCurrency())==0) {
		if(o1.getValue()>o2.getValue()) return 1;
		else if(o2.getValue()==o1.getValue()) return 0;
		else return -1;
		}
		return o1.getCurrency().compareTo(o2.getCurrency());
	}

	
}
