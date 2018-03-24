package com.dao;

import java.util.HashMap;
import com.dto.Product;

public class CartBean {
	HashMap<Integer, Product> cartItems = new HashMap<>();
	private double orderTotal;

	public HashMap<Integer, Product> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Integer, Product> cartItems) {
		this.cartItems = cartItems;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getItemCount() {
		return cartItems.size();
	}

	protected void calculateTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < cartItems.size(); counter++) {
			Product p = cartItems.get(counter);
			dblTotal += p.getTotalCost();
		}
		setOrderTotal(dblTotal);
	}

	public void addtoCart(int id, String name, Double unitCost, int quantity) {
		double itotalcost = 0.0;
		double iunitcost = 0.0;
		int iquantity = 0;
		Product p = new Product();
		
		try {
			iunitcost = unitCost;             
			iquantity = quantity;
			if (iquantity > 0) {
				itotalcost = iunitcost * iquantity;
				p.setId(id);
				p.setName(name);         
				p.setQuantity(iquantity);
				p.setTotalCost(itotalcost);
			/*	Product p = new Product(name, "", "", id, unitCost, itotalcost, iquantity);    */
				try {
					cartItems.put(id, p);
				 
				} catch (Exception e) {
					System.out.println("1 Exception E: " + e);
				}
				//calculateTotal();                                    
                      
			}
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}

	}

}
