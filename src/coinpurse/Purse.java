package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


// You will use Collections.sort() to sort the valuable

/**
 * A valuable purse contains valuable. You can insert valuable, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author wasuthun wanaphongthipakorn
 */
public class Purse {
	/** Collection of objects in the purse. */
	private ArrayList<Valuable> money = new ArrayList<>();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of valuable in the purse. This is the number of
	 * valuable, not their value.
	 * 
	 * @return the number of valuable in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (Valuable coin : money) {
			sum += coin.getValue();
		}
		return sum;
	}
	/**
	 * access ArrayList of purse  
	 * @return ArrayList of money
	 */
	public ArrayList<Valuable> getMoney(){
		return this.money;
	}

	/**
	 * Return the capacity of the valuable purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size()==this.capacity;
	}

	/**
	 * Insert a valuable into the purse. The coin is only inserted if the purse has
	 * space for it and the valuable has positive value. No worthless valuable!
	 * 
	 * @param valuable
	 *            is a Valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		// if the purse is already full then can't insert anything.
		if (isFull() || valuable.getValue() <= 0)
			return false;
		else {
			money.add(valuable);
			return true;
		}
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.this method will call withdraw(Valuable amount)
	 * 
	 * @param amount
	 *           type double is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Money money=new Money(amount,"Baht");
		return withdraw(money);
		/*
		 * See lab sheet for outline of a solution, or devise your own solution. The
		 * idea is to be greedy. Try to withdraw the largest coins possible. Each time
		 * you choose a valuable as a candidate for withdraw, add it to a temporary list and
		 * decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found a
		 * solution! Now, use the temporary list to remove coins from the money list,
		 * and return the temporary list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a valuable.
		// Your code might use some other variable for the remaining amount to withdraw.

		// Success.
		// Remove the valuable you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.

	}
	/**
	 * Withdraw the requested amount of money. Return an array of Valuable withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount
	 *          type Valuable is the amount to withdraw 
	 * @return array of Valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		ArrayList<Valuable> templist = new ArrayList<>();
		Comparator<Valuable> comp=new ValueComparator();
		double amounts=amount.getValue();
		Collections.sort(money,comp);
		Collections.reverse(money);
 
		for (Valuable coin : money) {
			if (amounts >= 0) {
		
				if (coin.getValue() <= amounts && coin.getCurrency().equalsIgnoreCase(amount.getCurrency())) {
					amounts -= coin.getValue();
					templist.add(coin);
				}
			} else {
				return null;
			}
		}

		if (amounts == 0) {
			for (Valuable coin : templist) {
				money.remove(coin);
			}
			Valuable[] array = new Valuable[templist.size()];
			templist.toArray(array);
			System.out.println(money);
			return array;
		}
		return null;
		/*
		 * See lab sheet for outline of a solution, or devise your own solution. The
		 * idea is to be greedy. Try to withdraw the largest coins possible. Each time
		 * you choose a valuable as a candidate for withdraw, add it to a temporary list and
		 * decrease the amount (remainder) to withdraw.
		 * 
		 * If you reach a point where amountNeededToWithdraw == 0 then you found a
		 * solution! Now, use the temporary list to remove coins from the money list,
		 * and return the temporary list (as an array).
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a valuable.
		// Your code might use some other variable for the remaining amount to withdraw.

		// Success.
		// Remove the valuable you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.

	}
	

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 */
	public String toString() {
		return this.count() + " Valuable with value " + this.getBalance();
	}
}
