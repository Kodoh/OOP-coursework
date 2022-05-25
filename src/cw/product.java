package cw;

import java.util.ArrayList;
/**
* This is an abstract class holding information about products .
* @author Jake
*/
public abstract class product {
	private int barcode;
	private String brand;
	private String colour;
	private String connectivity;
	private int quantity;
	private double originalCost;
	private double retailCost;
	public product(int barcode,String brand,String colour,String connectivity,int quantity,double originalCost,double retailCost) {
		this.barcode = barcode;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.quantity = quantity;
		this.originalCost = originalCost;
		this.retailCost = retailCost;
	}
	public int getBarcode() {
		// returns barcode of item
		return this.barcode;
	}
	public String getBrand() {
		// returns brand of item 
		return this.brand;
}
	public String getColour() {
		// returns colour of item 
		return this.colour;
}
	public String getConnectivity() {
		// returns connectivity of item 
		return this.connectivity;
	
}
	public int getQuantity() {
		// returns quantity of item 
		return this.quantity;
}
	public void setQuantity(int num) {
		// sets quantity of item
		this.quantity = num;
	}

public double getRetail() {
	// returns retail cost
	return this.retailCost;
}

public double getOriginalCost() {
	// returns items original cost
	return this.originalCost;
}

//abstract methods used by subclasses to get string of products
public abstract String toString();

public abstract String toStringAd();
}