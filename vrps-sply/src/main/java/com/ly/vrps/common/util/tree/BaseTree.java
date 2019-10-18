package com.ly.vrps.common.util.tree;
 
import java.util.List;
import java.util.Map;
 
/**
 * 基础树服务接口
 * <br>!注意:
 * <br>不建议使用dubbo远程调用该接口的方法(涉及大量数据传输(所有节点的List、Map);find方法涉及回调,需使用配置文件注册服务)
 * @author abo
 * @param <N>树节点
 * @param <K>树节点id(唯一标识)
 */
public interface BaseTree<N, K> {
	
	/**
	 * 获取所有节点key - 子节点List 映射Map
	 * @param nodeList	所有节点List
	 * @return
	 */
	Map<K, List<N>> getAllNodeAsMap(List<N> nodeList);
	
	/**
	 * 获取所有节点的key - 自己的映射Map
	 * @param nodeList	所有节点List
	 * @return
	 */
	Map<K, N> getAllNodeSelfMap(List<N> nodeList);
	
	/**
	 * 从某节点开始往上级搜索
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @param selfMap		所有节点的key - 自己的映射(可通过getAllNodeSelfMap获取)
	 * @return		匹配条件的节点集合(按层级从大到小排列)
	 */
	List<N> findUp(N node, BaseTreeSearcher<N> searcher, boolean needSelf, Map<K, N> selfMap);
	
	/**
	 * 从某节点开始往上级搜索，找到一个符合条件的就返回
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @param selfMap		所有节点的key - 自己的映射(可通过getAllNodeSelfMap获取)
	 * @return		匹配条件的第一个节点(层级大的优先)	找不到则返回null
	 */
	N findUpFirst(N node, BaseTreeSearcher<N> searcher, boolean needSelf, Map<K, N> selfMap);
	
	/**
	 * 从某节点开始往下级搜索
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @param childMap		所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @return		匹配条件的节点集合(按层级从小到大排列)
	 */
	List<N> findDown(N node, BaseTreeSearcher<N> searcher, boolean needSelf, Map<K, List<N>> childMap);
	
	/**
	 * 从某节点开始往下级搜索，找到一个符合条件的就返回
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @param childMap		所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @return		匹配条件的第一个节点(层级小的优先)	找不到则返回null
	 */
	N findDownFirst(N node, BaseTreeSearcher<N> searcher, boolean needSelf, Map<K, List<N>> childMap);
	
	/**
	 * 获得某节点的所有祖先节点
	 * @param node		当前节点
	 * @param selfMap		所有节点的key - 自己的映射(可通过getAllNodeSelfMap获取)
	 * @param needSelf		是否包含自己
	 * @return		祖先节点集合(按层级从大到小排列)
	 */
	List<N> getParentsNode(N node, Map<K, N> selfMap, boolean needSelf);
 
	/**
	 * 获取某节点的所有后代节点
	 * @param node	当前节点
	 * @param childMap	所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @param needSelf	是否包含自己
	 * @return		后代节点集合(按层级从小到大排列)
	 */
	List<N> getSubNode(N node, Map<K, List<N>> childMap, boolean needSelf);
	
	/**
	 * 获取某节点下面的所有叶子
	 * @param node	当前节点
	 * @param childMap	所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @return		叶子节点集合(如果自己是叶子，则集合中为自己)
	 */
	List<N> getSubLeaf(N node, Map<K, List<N>> childMap);
	
	/**
	 * 获取某节点的父节点(直接上级)
	 * @param node
	 * @param selfMap	所有节点的key - 自己的映射(可通过getAllNodeSelfMap获取)
	 * @return		没有则返回null
	 */
	N getParent(N node, Map<K, N> selfMap);
	
	/**
	 * 获取某节点的所有孩子(直接下级)
	 * @param node
	 * @param childMap	所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @return		没有则返回null
	 */
	List<N> getChildren(N node, Map<K, List<N>> childMap);
	
	/**
	 * 判断一个节点是不是叶子
	 * @param node
	 * @param childMap	所有节点key - 子节点List 映射(可通过getAllNodeAsMap获取)
	 * @return
	 */
	boolean isLeaf(N node, Map<K, List<N>> childMap);
}
