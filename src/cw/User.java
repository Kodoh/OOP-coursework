package cw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
* This is an abstract class holding information about a user .
* @author Jake
*/
public abstract class User {
	private int id;
	private String username;
	private String name;
	private Address addr;
	private ArrayList<product> products;
	private ArrayList<User> Users;
	public User(int id, String username, String name, Address addr,ArrayList<product> products,ArrayList<User> Users) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.Users = Users;
		this.addr = addr;
		this.products = products;
		Collections.sort(getProductList(),new Comparator<product>() {
		    public int compare(product p1, product p2) {
		        double delta = p1.getRetail() - p2.getRetail();
		        if(delta > 0.00001) return 1;
		        if(delta < -0.00001) return -1;
		        return 0;
		    }
		});
	}
	public String getUsername() {
		// returns users username
		return this.username;
	}
	public ArrayList<User> getUserList() {
		// returns list of known users
		return this.Users;
	}
	public ArrayList<product> getProductList() {
		// returns list of products
		return this.products;
	}
	public void setProductList(ArrayList<product> newList) {
		// sets new products
		this.products = newList;
	}
	public abstract String getProducts();		// abstract method to get products
	
	public Address getAddress() {
		// returns address
		return this.addr;
	}
}
