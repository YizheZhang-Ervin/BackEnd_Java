package com.ervin.bridge;

public class BossCar extends RefinedCar {

	public BossCar(Engine engine) {
		super(engine);
	}

	@Override
	public String getBrand() {
		return "Boss";
	}
}
