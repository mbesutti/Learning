package com.mbesutti.badSmell;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
public class Cart {
 
    private final Map<Product, Integer> _products;
 
    public Cart() {
    	_products = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product) throws Exception {
    	if (contains(product)) {
    		Integer quantity = _products.get(getProductById(product.id));
    		_products.put(product, quantity++);
    		return;
    	}
    	_products.put(product, 1);
    }

	private Product getProductById(int id) throws Exception {
		for (Product product : _products.keySet()) {
			if (product.id==id) {
				return product;
			}
		}
		throw new Exception("Not found");
	}

	private boolean contains(Product other) {
		for (Product product : _products.keySet()) {
			if (product.id==other.id) {
				return true;
			}
		}
		return false;
	}

	public void print(PrintStream printer) throws Exception {
		for (Product item : _products.keySet()) {
		    int unitPrice = item.unitPrice;
		    int qty = _products.get(getProductById(item.id));
		    int productId = item.id;
		    int imageID = item.imageId;
		    int lineitemtotal = unitPrice * qty;
 
		    printer.println("---- " + productId + " ----");
		    printer.println("Image = " + imageID);
		    printer.println("Quantity = " + qty);
		    printer.println("Total = " + lineitemtotal);
		}
		printer.println("=== TOTAL: " + total()+" ===");
	}

	public int total() throws Exception {
		int total = 0;
		for (Product item : _products.keySet()) {
			int unitPrice = item.unitPrice;
			int quantity = _products.get(getProductById(item.id));
			total += unitPrice * quantity;
		}
		return total;
	}
 
    public void save()  throws SQLException
    {
        new CartPersistence().insert(this);
	}
}
