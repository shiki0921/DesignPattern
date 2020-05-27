package com.shiki.strategy;

import java.math.BigDecimal;

/**
 * 满减策略
 * @author shiki
 *
 */
public class OverDiscountStrategy implements DiscountStrategy {

	public BigDecimal getDiscount(BigDecimal total) {
        // 满100减20优惠:
        return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO;
	}

}
