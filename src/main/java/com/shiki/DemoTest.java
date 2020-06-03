package com.shiki;

import java.math.BigDecimal;

import org.junit.Test;

import com.shiki.decorator.BoldDecorator;
import com.shiki.decorator.SpanNode;
import com.shiki.decorator.TextNode;
import com.shiki.observer.BinaryObserver;
import com.shiki.observer.HexaObserver;
import com.shiki.observer.OctalObserver;
import com.shiki.observer.Subject;
import com.shiki.responsibility.CEOHandler;
import com.shiki.responsibility.DirectorHandler;
import com.shiki.responsibility.HandlerChain;
import com.shiki.responsibility.ManagerHandler;
import com.shiki.responsibility.Request;
import com.shiki.strategy.DiscountContext;
import com.shiki.strategy.OverDiscountStrategy;

/**
 * 设计模式测试类
 * @author shiki
 *
 */
public class DemoTest {
	
	/*
	 * 责任链模式是一种处理请求的模式，它让多个处理器都有机会吃力该请求，
	 * 直到其中某个处理成功为止。责任链模式把多个处理器串成链，然后让请求在链上传递。
	 * 
	 * 在实际场景中，财务审批就是一个责任链模式。假设某个员工需要报销一笔费用，审核者可以分为：
	 * Manager：只能审核1000元以下的报销；
	 * Director：只能审核10000元以下的报销；
	 * CEO：可以审核任意额度。
	 * 用责任链模式设计此报销流程时，每个审核者只关心自己责任范围内的请求，并且处理它。
	 * 对于超出自己责任范围的，扔给下一个审核者处理，这样，将来继续添加审核者的时候，不用改动现有逻辑。
	 */
	@Test
	public void test01(){
		HandlerChain chain = new HandlerChain();
		chain.add(new ManagerHandler());
		chain.add(new DirectorHandler());
		chain.add(new CEOHandler());
		
		chain.process(new Request("Mike", BigDecimal.valueOf(1500)));
		chain.process(new Request("Bob", BigDecimal.valueOf(1000)));
		chain.process(new Request("Jack", BigDecimal.valueOf(9000)));
		chain.process(new Request("David", BigDecimal.valueOf(11000)));
	}
	
	/**
	 * 装饰器模式是一种在运行期动态给某个对象的实例增加功能的方法。
	 * 动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更加灵活。
	 */
	@Test
	public void test02(){
//		TextNode n1 = new SpanNode();
//		TextNode n2 = new BoldDecorator(new UnderlineDecorator(new SpanNode()));
//		TextNode n3 = new ItalicDecorator(new BoldDecorator(new SpanNode()));
//		n1.setText("Hello");
//		n2.setText("Decorated");
//		n3.setText("World");
//		System.out.println(n1.getText());
//		// 输出<span>Hello</span>
//
//		System.out.println(n2.getText());
//		// 输出<b><u><span>Decorated</span></u></b>
//
//		System.out.println(n3.getText());
//		// 输出<i><b><span>World</span></b></i>
	}

	/*
	 * 策略模式：Strategy，是指，定义一组算法，并把其封装到一个对象中。然后在运行时，可以灵活的使用其中的一个算法。
	 * 			在一个方法中，流程是确定的，但是，某些关键步骤的算法依赖调用方传入的策略，这样，传入不同的策略，即可获得不同的结果，大大增强了系统的灵活性。
	 */
	@Test
	public void test03(){
		DiscountContext ctx = new DiscountContext();

		// 默认使用普通会员折扣:
		BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
		System.out.println(pay1);

		// 使用满减折扣:
		ctx.setStrategy(new OverDiscountStrategy());
		BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
		System.out.println(pay2);

	}
	
	/**
	 * 观察者模式
	 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
	 */
	@Test
	public void test04(){
      Subject subject = new Subject();
      
      new HexaObserver(subject);
      new OctalObserver(subject);
      new BinaryObserver(subject);
 
      System.out.println("First state change: 15");   
      subject.setState(15);
      System.out.println("Second state change: 10");  
      subject.setState(10);
	}
}
