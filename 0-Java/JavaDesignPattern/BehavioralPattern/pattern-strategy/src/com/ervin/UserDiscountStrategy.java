package com.ervin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UserDiscountStrategy implements DiscountStrategy {

	@Override
	public BigDecimal getDiscount(BigDecimal total) {
		// 普通会员打九折:
		return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
	}
}
