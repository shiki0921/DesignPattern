package com.shiki.strategy;

import java.math.BigDecimal;

/**
 * 打折策略接口
 * @author shiki
 *
 */
public interface DiscountStrategy {
    // 计算折扣额度:
    BigDecimal getDiscount(BigDecimal total);
}
