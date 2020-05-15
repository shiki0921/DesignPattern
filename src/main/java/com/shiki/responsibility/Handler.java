package com.shiki.responsibility;

/**
 * 抽象出处理器
 * @author shiki
 *
 */
public interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
	Boolean process(Request request);
}
