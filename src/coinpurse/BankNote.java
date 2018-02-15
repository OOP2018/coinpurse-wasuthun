package coinpurse;
/**
 *  This class is use to build object of BankNote for used
 * @author wasuthun wanaphongthipakorn
 *
 */
public class BankNote extends Money {
	
	/**
	 * This is a specific serial number of each BankNote
	 */
	private long serialNumber;
	/**
	 * Constructor of BankNote class use to configure value of BankNote
	 * @param value
	 * @param currency
	 */
	public BankNote(double value,String currency,long nextSerialNumber) {
		super(value, currency);
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
	
	
	/**
	 * Use to print a detail of this BankNote
	 * @return a String of detail of BankNote
	 */
	@Override
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" note ["+this.getSerial()+"]";
	}
	
}
