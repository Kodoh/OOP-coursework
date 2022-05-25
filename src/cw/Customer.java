package cw;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
* This is a subclass of User which has specific methods and attributes associated with Customers.
* @author Jake
*/
public class Customer extends User {
	private ArrayList<product> basket;		// basket for the customer (in the form of an array list of products)
	public Customer(int id,String username, String name, Address addr,ArrayList<product> products,ArrayList<User> Users) {
		super(id,username,name,addr,products,Users);
		this.basket = new ArrayList<product>();
	}
	/**
	* This method will add a new item into the users basket based on a barcode given (if found).
	* @param barcode item barcode as integer.
	* @return inProducts - is the barcode given an item (which is in stock) in stock.txt
 */
	public boolean AddToBasket(int barcode) {
	boolean inProducts = false;				
	for(int j = 0; j<getProductList().size(); j++) {
		if (getProductList().get(j).getBarcode() == barcode) {
			int occurrences = Collections.frequency(this.basket, getProductList().get(j));
			//System.out.println(occurrences + " " + getProductList().get(j).getQuantity());
			if (occurrences+1 <= getProductList().get(j).getQuantity()) { 
				inProducts = true;
				this.basket.add(getProductList().get(j));
				break;
			}
		}
	}
	return inProducts;
}
	public String getProducts() {
		// returns a string of all available products and their details however without the Original cost added
		String Products = "";
		for(int i = 0; i<getProductList().size(); i++) {
			Products += getProductList().get(i).toString() + "\n";
		}
		return Products;
		
	}

	public String ViewBasket() {
		// returns a string of all products in the users basket and the product details without the Original cost included
		String Products = "";
		for(int i=0;i<this.basket.size(); i++) {
			Products += basket.get(i).toString() + "\n";
		}
		return Products;
	}
	public void EmptyBasket() {
		// clears users basket
		this.basket.clear();
	}
	/**
	* This method will search for a mouse based on brand and number of buttons.
	* @param brand item brand.
	* @param numOfButtons the number of buttons on the mouse
	* @return content - A string containing the relevant results of the query.
 */
	public String SearchProduct(String brand, int numOfButtons) {
		String content = "";
		for(int i = 0; i<getProductList().size(); i++) {
			if (getProductList().get(i) instanceof Mouse) {
				Mouse item = (Mouse)getProductList().get(i);
				if (item.getNumOfButtons() == numOfButtons && item.getBrand().equals(brand)) {
					content += getProductList().get(i).toString() + "\n";
		}		
	}
	}
	return content;
	}
	/**
	* This method will search for products based on brand alone.
	* @param brand item brand.
	* @return content - A string containing the relevant results of the query.
 */
	public String SearchProduct(String brand) {
		String content = "";
		for(int i = 0; i<getProductList().size(); i++) {
			if (getProductList().get(i).getBrand().equals(brand)) {
				content += getProductList().get(i).toString() + "\n";	
	}
	}
	return content;
	}
	/**
	* This method will search for a mouse based on the amount of buttons it has.
	* @param numOfButtons item brand.
	* @return content - A string containing the relevant results of the query.
 */
	public String SearchProduct(int numOfButtons) {
		String content = "";
		for(int i = 0; i<getProductList().size(); i++) {
			if (getProductList().get(i) instanceof Mouse) {
				Mouse item = (Mouse)getProductList().get(i);
				if (item.getNumOfButtons() == numOfButtons) {
					content += getProductList().get(i).toString() + "\n";
		}		
	}
	}
	return content;
	}
	/**
	* This method will purchase items in the users basket, by doing this it will empty the users basket and remove quantity of these items in Stock.txt.
	* @param options how the user will decide to pay.
	* @return A string containing how much the user has payed and what their address is.
 */
	public String Payment(String option) {
		ArrayList<product> temp = getProductList();
		double Amount = 0;
		for(int i = 0; i<getProductList().size(); i++) {
			product item = getProductList().get(i);
			for(int j=0;j<this.basket.size(); j++) {
				product basketItem = this.basket.get(j);
				if (item.getBarcode() == basketItem.getBarcode()) {
					if (item.getQuantity() == 1) {
						Amount += item.getRetail();
						getProductList().remove(i);
						this.basket.remove(j);
					} else {
						Amount += item.getRetail();
						item.setQuantity(item.getQuantity()-1);
						this.basket.remove(j);
					}
				}
			}
		}
	    try {
	        FileWriter myWriter = new FileWriter("Stock.txt");
			for(int i = 0; i<getProductList().size(); i++) {
				if (getProductList().get(i) instanceof Keyboard) {
					Keyboard item = (Keyboard)getProductList().get(i);
					if (i == getProductList().size() - 1) { 
						myWriter.write(item.getBarcode() + ", " + "keyboard, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getLayout());
					} else {
						myWriter.write(item.getBarcode() + ", " + "keyboard, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getLayout() + "\n");
					}
				}
				if (getProductList().get(i) instanceof Mouse) {
					Mouse item = (Mouse)getProductList().get(i);
					if (i == getProductList().size() - 1) { 
						myWriter.write(item.getBarcode() + ", " + "mouse, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getNumOfButtons());
					} else {
						myWriter.write(item.getBarcode() + ", " + "mouse, " + item.getType() + ", " + item.getBrand() + ", " + item.getColour() + ", " + item.getConnectivity() + ", " + item.getQuantity() + ", " + item.getOriginalCost() + ", " + item.getRetail() + ", " + item.getNumOfButtons() + "\n");
					}
				}		
			}
	        myWriter.close();
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		if (option.equals("Credit Card")) {
			return "£" + Amount + " paid using Credit Card, " + "and the delivery address is " + this.getAddress().toString();
	}
		else {
			return "£" + Amount + " paid using Paypal, " + "and the delivery address is " + this.getAddress().toString();
		}
}
}