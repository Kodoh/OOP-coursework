package cw;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
* This is a subclass of User and provides methods specific to the Admin role.
* @author Jake
*/
public class Admin extends User{
	public Admin(int id,String username, String name, Address addr,ArrayList<product> products,ArrayList<User> Users) {
		super(id,username,name,addr,products,Users);
	}
	/**
	* This method will add a new keyboard to the stock by writing a new line to Stock.txt.
	* @param barcode item barcode as integer.
	* @param name item name.
	* @param type keyboard type (gaming or standard or flexible).
	* @param brand item brand.
	* @param colour item colour.
	* @param connectivity item connectivity (if wired or wireless).
	* @param quantity item quantity left in stock.
	* @param originalCost price item was originally bought for.
	* @param retailPrice price item is being sold for.
	* @param layout the keyboard layout (US or UK).
	* @return replicate - used to see if the item being added is currently in the stock file or not. 
	*/
	public boolean AddProduct(int barcode,String name,String type,String brand,String colour, String connectivity, int quantity,double originalCost, double retailPrice,String layout) {
		boolean replicate = false;
		for(int i = 0; i<getProductList().size(); i++) {
			if (getProductList().get(i).getBarcode() == barcode) {
				replicate = true;
				break;
			}
		}
		if (replicate == false) {
		Keyboard newItem = new Keyboard(barcode,brand,colour,connectivity,quantity,originalCost,retailPrice,layout,type);
		getProductList().add(newItem);
	    try {
	        FileWriter myWriter = new FileWriter("Stock.txt");
			for(int i = 0; i<getProductList().size()-1; i++) {
				if (getProductList().get(i) instanceof Keyboard) {
					Keyboard item = (Keyboard)getProductList().get(i);
					myWriter.write(item.getBarcode() + ", " + "keyboard, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getLayout() + "\n");
				}
				if (getProductList().get(i) instanceof Mouse) {
					Mouse item = (Mouse)getProductList().get(i);
					myWriter.write(item.getBarcode() + ", " + "mouse, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getNumOfButtons() + "\n");
				}		
			}
	        myWriter.write(barcode + ", " + name + ", " + type + ", " + brand + ", " + colour + ", " + connectivity + ", " + quantity + ", " + originalCost + ", " + retailPrice + ", " + layout);
	        myWriter.close();
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		}
		return replicate;
	}
	/**
	* This method will add a new mouse to the stock by writing a new line to Stock.txt.
	* @param barcode item barcode as integer.
	* @param name item name.
	* @param type mouse type (gaming or standard or flexible).
	* @param brand item brand.
	* @param colour item colour.
	* @param connectivity item connectivity (if wired or wireless).
	* @param quantity item quantity left in stock.
	* @param originalCost price item was originally bought for.
	* @param retailPrice price item is being sold for.
	* @param buttonNo the number of buttons on the mouse.
	* @return replicate - used to see if the item being added is currently in the stock file or not. 
	*/
	public boolean AddProduct(int barcode,String name,String type, String brand,String colour, String connectivity, int quantity,double originalCost, double retailPrice, int buttonNo) {
		boolean replicate = false;
		for(int i = 0; i<getProductList().size(); i++) {
			if (getProductList().get(i).getBarcode() == barcode) {
				replicate = true;
				break;
			}
		}
		if (replicate == false) {
		Mouse newItem = new Mouse(barcode,brand,colour,connectivity,quantity,originalCost,retailPrice,type,buttonNo);
		getProductList().add(newItem);
	    try {
	        FileWriter myWriter = new FileWriter("Stock.txt");
			for(int i = 0; i<getProductList().size()-1; i++) {
				if (getProductList().get(i) instanceof Keyboard) {
					Keyboard item = (Keyboard)getProductList().get(i);
					myWriter.write(item.getBarcode() + ", " + "keyboard, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getLayout() + "\n");
				}
				if (getProductList().get(i) instanceof Mouse) {
					Mouse item = (Mouse)getProductList().get(i);
					myWriter.write(item.getBarcode() + ", " + "mouse, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getNumOfButtons() + "\n");
				}		
			}
	        myWriter.write(barcode + ", " + name + ", " + type + ", " + brand + ", " + colour + ", " + connectivity + ", " + quantity + ", " + originalCost + ", " + retailPrice + ", " + buttonNo);
	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		} 
		return replicate;
	}
	@Override
	// returns a list of all product information for the admin stock display.
	public String getProducts() {
		String products = "";
		for(int i = 0; i<getProductList().size(); i++) {
			products += getProductList().get(i).toStringAd() + "\n";
		}
		return products;
	}
	
}
