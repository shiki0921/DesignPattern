package com.shiki.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 普通用户策略
 * @author shiki
 *
 */
public class UserDiscountStrategy implements DiscountStrategy {

	public BigDecimal getDiscount(BigDecimal total) {
        // 普通会员打九折:
        return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
	}

}