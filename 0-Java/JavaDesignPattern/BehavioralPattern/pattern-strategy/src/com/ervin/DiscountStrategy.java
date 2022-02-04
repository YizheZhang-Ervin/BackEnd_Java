package com.ervin;

import java.math.BigDecimal;

public interface DiscountStrategy {

	BigDecimal getDiscount(BigDecimal total);

}
