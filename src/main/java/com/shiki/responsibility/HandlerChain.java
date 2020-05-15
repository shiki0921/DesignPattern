package com.shiki.responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 有了不同的Handler后，我们还要把这些Handler组合起来，变成一个链，并通过一个统一入口处理
 * @author shiki
 *
 */
public class HandlerChain {
	
	private List<Handler> chain = new ArrayList<Handler>();
	
	public void add(Handler handler){
		chain.add(handler);
	}
	
	public Boolean process(Request request){
		//依次调用每个Handler
		for (Handler handler : chain) {
			Boolean result = handler.process(request);
			if (result != null) {
                // 如果返回TRUE或FALSE，处理结束:
                System.out.println(request + " " + (result ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return result;
            }
		}
		throw new RuntimeException("Could not handle request: " + request);
	}

}
