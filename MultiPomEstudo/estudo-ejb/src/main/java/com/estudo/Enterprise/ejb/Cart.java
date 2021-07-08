package com.estudo.Enterprise.ejb;

import javax.ejb.Local;

import com.estudo.Enterprise.product.Product;

@Local
public interface Cart {
	
	  void addProductToCart(Product product);
	  
	  void checkOut();

}
