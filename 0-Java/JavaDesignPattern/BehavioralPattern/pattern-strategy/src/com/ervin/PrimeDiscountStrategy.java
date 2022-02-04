package com.ervin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrimeDiscountStrategy implements DiscountStrategy {

	@Override
	public BigDecimal getDiscount(BigDecimal total) {
		// Prime会员打七折:
		return total.multiply(new BigDecimal("0.3")).setScale(2, RoundingMode.DOWN);
	}
}
