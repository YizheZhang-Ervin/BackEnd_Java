package com.ervin;

import com.ervin.bridge.BossCar;
import com.ervin.bridge.ElectricEngine;
import com.ervin.bridge.HybridEngine;
import com.ervin.bridge.RefinedCar;
import com.ervin.bridge.TinyCar;


public class Main {

	public static void main(String[] args) {
		RefinedCar car1 = new BossCar(new HybridEngine());
		car1.drive();
		RefinedCar car2 = new TinyCar(new ElectricEngine());
		car2.drive();
	}
}
