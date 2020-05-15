package com.shiki.responsibility;

import java.math.BigDecimal;

/**
 * 抽象出请求对象，它将在责任链上传递
 * @author shiki
 *
 */

public class Request {
	
	private String name;
	
	private BigDecimal amount;

	public Request(String name, BigDecimal amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Request [name=" + name + ", amount=" + amount + "]";
	}

}
