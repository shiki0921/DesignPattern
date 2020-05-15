package com.shiki.responsibility;

public class CEOHandler implements Handler{

	public Boolean process(Request request) {
		//CEO可以审核任何额度
		return Boolean.TRUE;
	}

}
