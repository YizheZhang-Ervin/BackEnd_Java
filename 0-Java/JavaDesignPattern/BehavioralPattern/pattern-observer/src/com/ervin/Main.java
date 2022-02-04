package com.ervin;

import com.ervin.observer.Product;
import com.ervin.observer.ProductObserver;
import com.ervin.observer.Store;


public class Main {

	public static void main(String[] args) {
		// observer:
		Admin a = new Admin();
		Customer c = new Customer();
		// store:
		Store store = new Store();
		// register:
		store.addObserver(a);
		store.addObserver(c);
		// 注册匿名观察者:
		store.addObserver(new ProductObserver() {
			@Override
			public void onPublished(Product product) {
				System.out.println("[Log] on product published: " + product);
			}

			@Override
			public void onPriceChanged(Product product) {
				System.out.println("[Log] on product price changed: " + product);
			}
		});
		// operation:
		store.addNewProduct("Design Patterns", 35.6);
		store.addNewProduct("Effective Java", 50.8);
		store.setProductPrice("Design Patterns", 31.9);
	}
}

class Customer implements ProductObserver {

	@Override
	public void onPublished(Product product) {
		System.out.println("[Customer] on product published: " + product);
	}

	@Override
	public void onPriceChanged(Product product) {
		System.out.println("[Customer] on product price changed: " + product);
	}
}

class Admin implements ProductObserver {

	@Override
	public void onPublished(Product product) {
		System.out.println("[Admin] on product published: " + product);
	}

	@Override
	public void onPriceChanged(Product product) {
		System.out.println("[Admin] on product price changed: " + product);
	}
}
