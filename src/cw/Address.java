package cw;
/**
* This class provides attributes for user address information.
* @author Jake
*/
public class Address {
	private int houseNumber;
	private String postcode;
	private String city;
	public Address(int houseNumber, String postcode, String city) {
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.city = city;
	}
	/**
	* This methods returns a string including all user address information.
	* @return Address in the form of a string.
	*/
	public String toString() {
		return this.houseNumber + " " + this.postcode + " " + this.city;
	}
}
