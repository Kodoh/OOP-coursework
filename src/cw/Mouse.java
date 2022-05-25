package cw;
/**
* This is sub class of Product and has methods and attributes related to mice.
* @author Jake
*/
public class Mouse extends product{
	private String type;
	private int numOfButtons;
	public Mouse(int barcode,String brand,String colour,String connectivity,int quantity,double originalCost,double retailCost,String type,int numOfButtons) {
		super(barcode,brand,colour,connectivity,quantity,originalCost,retailCost);
		this.type = type;
		this.numOfButtons = numOfButtons;
	}
	public String toString() {
		// returns string of product information (for Customer)
		return "Barcode: " + getBarcode() + ",Brand: " + getBrand() + ",Colour: " + getColour() + ",Connectivity: " + getConnectivity() + ",Quantity: " + getQuantity() + ",Cost: £" + getRetail() + ",Number Of Buttons: " + this.numOfButtons + ",Type: " + this.type;
	}
	public String toStringAd() {
		// returns string of product information (for Admin)
		return "Barcode: " + getBarcode() + ",Brand: " + getBrand() + ",Colour: " + getColour() + ",Connectivity: " + getConnectivity() + ",Quantity: " + getQuantity() + ",Retail Cost: £" + getRetail() + ",Original Cost: £" + getOriginalCost() + ",Number Of Buttons: " + this.numOfButtons + ",Type: " + this.type;
	}
	public int getNumOfButtons() {
		// returns the number of buttons on the mouse
		return this.numOfButtons;
	}
	public String getType() {
		// returns the type of mouse 
		return this.type;
	}
}
