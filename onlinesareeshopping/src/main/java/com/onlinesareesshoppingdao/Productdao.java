package com.onlinesareesshoppingdao;

import java.util.List;

import com.onlinesareesshopping.entities.Products;


public interface Productdao {
	static void insert(Products product) {
		// TODO Auto-generated method stub
		
	}
	void updateProduct(int productid,String productname);
    void deleteProduct(int productId);
    List<Products> select();
	void search(int productid);
}
