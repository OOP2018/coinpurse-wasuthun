package coinpurse;
/**
 *  This class is use to build object of BankNote for used
 * @author wasuthun wanaphongthipakorn
 *
 */
public class BankNote implements Valuable {
	/**
	 * This is a next serial number of each BankNote that start from 1000000
	 */
	private static long nextSerialNumber=1000000;
	/**
	 * This is a value of BankNote
	 */
	private double value;
	/**
	 * This is a currency of BankNote
	 */
	private String currency;
	/**
	 * This is a specific serial number of each BankNote
	 */
	private long serialNumber;
	/**
	 * Constructor of BankNote class use to configure value of BankNote
	 * @param value
	 * @param currency
	 */
	public BankNote(double value,String currency) {
		this.value=value;
		this.currency=currency;
		this.serialNumber=nextSerialNumber;
		nextSerialNumber++;
	}
	/**
	 * Use to access a serial number of BankNote
	 * @return a serial number of BankNote
	 */
	
	public long getSerial() {
		return this.serialNumber;
	}
	@Override
	/**
	 * Use to check a object that equal to this BankNote or not if equal return true if not equal return false
	 * @return a checking result of this method
	 */
	public boolean equals(Object obj) {
		if(obj==null)return false;
		if(obj.getClass()!=this.getClass())return false;
		BankNote other=(BankNote)obj;
		return other.getCurrency().equalsIgnoreCase(this.getCurrency())&&other.getValue()==this.getValue();
	}
	@Override
	/**
	 * Use to print a detail of this BankNote
	 * @return a String of detail of BankNote
	 */
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" note ["+this.getSerial()+"]";
	}
	@Override
	/**
	 * Use to access a value of BankNote
	 * @return double type of value of BankNote
	 */
	public double getValue() {
		return this.value;
	}

	@Override
	/**
	 * Use to access a currency of BankNote
	 * @return String of BankNote currency
	 */
	public String getCurrency() {
		return this.currency;
	}

}
