package cw;
/**
* This is sub class of Product and has methods and attributes related to keyboards.
* @author Jake
*/
public class Keyboard extends product {
	private String layout;
	private String type;
	public Keyboard(int barcode,String brand,String colour,String connectivity,int quantity,double originalCost,double retailCost, String layout, String type) {
		super(barcode,brand,colour,connectivity,quantity,originalCost,retailCost);
		this.layout = layout;
		this.type = type;
	}
	public String toString() {
		// returns product information (for customers)
		return "Barcode: " + getBarcode() + ",Brand: " + getBrand() + ",Colour: " + getColour() + ",Connectivity: " + getConnectivity() + ",Quantity: " + getQuantity() + ",Cost: £" + getRetail() + ",Layout: " + this.layout + ",Type: " + this.type;
	}
	public String toStringAd() {
		// returns product information (for admins)
		return "Barcode: " + getBarcode() + ",Brand: " + getBrand() + ",Colour: " + getColour() + ",Connectivity: " + getConnectivity() + ",Quantity: " + getQuantity() + ",Retail Cost: £" + getRetail() + ",Original Cost: £" + getOriginalCost() + ",Layout: " + this.layout + ",Type: " + this.type;
	}
	public String getType() {
		// returns type of keyboard
		return this.type;
	}
	public String getLayout() {
		// returns layout of keyboard
		return this.layout;
	}
}
