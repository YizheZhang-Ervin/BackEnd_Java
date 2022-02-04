package com.ervin.bridge;

public class BigCar extends RefinedCar {

	public BigCar(Engine engine) {
		super(engine);
	}

	@Override
	public String getBrand() {
		return "Big";
	}
}
