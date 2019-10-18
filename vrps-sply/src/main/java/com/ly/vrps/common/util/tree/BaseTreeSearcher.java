package com.ly.vrps.common.util.tree;
 
/**
 * 自定义树搜索器
 * @author abo
 * @param <N> 树节点
 */
public interface BaseTreeSearcher<N> {
	
	/**
	 * 当该方法返回true时,表示匹配到该节点
	 * @param node	当前树节点
	 * @return
	 */
	boolean search(N node);
}