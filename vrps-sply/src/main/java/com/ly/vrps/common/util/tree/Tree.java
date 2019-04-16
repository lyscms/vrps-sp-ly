package com.ly.vrps.common.util.tree;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
 
/**
 * 一棵树
 * @author abo
 * @param <N>树节点
 * @param <K>树节点id(唯一标识)(K须具有有效的hashCode与equals方法)
 */
public abstract class Tree<N, K> {
	
	/**
	 * 树上所有节点的列表
	 */
	private List<N> allNodes;
	
	/**
	 * 树根
	 */
	private List<N> root;
	
	/**
	 * 节点到其子节点的映射
	 */
	private Map<K, List<N>> childMap;
	
	/**
	 * 节点到自身的映射
	 */
	private Map<K, N> selfMap;
	
	public List<N> getAllNodes() {
		return allNodes;
	}
 
	public void setAllNodes(List<N> allNodes) {
		this.allNodes = allNodes;
	}
 
	public List<N> getRoot() {
		if (root == null) {
			// 随便找一个的最上级的祖先，就是根节点
			List<N> tempList = baseTree.getParentsNode(this.getAllNodes().get(0), this.getSelfMap(), true);

			Map<K, List<N>> childMap = this.getChildMap();
			childMap.forEach((k,v)->{
				N node = this.getSelfMap().get(k);
				List<N> subNode = this.getSubNode(node, false);
			});


			root = tempList;
		}
		return root;
	}
 
	public void setRoot(List<N> root) {
		this.root = root;
	}
 
	public Map<K, List<N>> getChildMap() {
		if (childMap == null) {
			// 初始化
			childMap = baseTree.getAllNodeAsMap(this.getAllNodes());
		}
		return childMap;
	}
 
	public void setChildMap(Map<K, List<N>> childMap) {
		this.childMap = childMap;
	}
 
	public Map<K, N> getSelfMap() {
		if (selfMap == null) {
			selfMap = baseTree.getAllNodeSelfMap(this.getAllNodes());
		}
		return selfMap;
	}
 
	public void setSelfMap(Map<K, N> selfMap) {
		this.selfMap = selfMap;
	}
	
	/**
	 * 获取节点唯一标识方法
	 * @param node
	 * @return
	 */
	protected abstract K getKey(N node);
	
	/**
	 * 获取节点父节点唯一标识方法
	 * @param node
	 * @return
	 */
	protected abstract K getParentKey(N node);
	
	/**
	 * 树形操作的工具
	 */
	private final BaseTree<N, K> baseTree = new BaseTreeImpl<N, K>() {
		@Override
		protected K getKey(N node) {
			return Tree.this.getKey(node);
		}
		@Override
		protected K getParentKey(N node) {
			return Tree.this.getParentKey(node);
		}
	};
	
	/**
	 * 构造方法，传入所有树节点来构造一棵树
	 * @param allNodes
	 */
	public Tree(Collection<N> allNodes) {
		this.setAllNodes(new ArrayList<N>(allNodes));
	}
	
	/**
	 * 从某节点开始往上级搜索
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @return		匹配条件的节点集合(按层级从大到小排列)
	 */
	public List<N> findUp(N node, BaseTreeSearcher<N> searcher, boolean needSelf) {
		return baseTree.findUp(node, searcher, needSelf, this.getSelfMap());
	}
	
	/**
	 * 从某节点开始往上级搜索，找到一个符合条件的就返回
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @return		匹配条件的第一个节点(层级大的优先)	找不到则返回null
	 */
	public N findUpFirst(N node, BaseTreeSearcher<N> searcher, boolean needSelf) {
		return baseTree.findUpFirst(node, searcher, needSelf, this.getSelfMap());
	}
	
	/**
	 * 从某节点开始往下级搜索
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @return		匹配条件的节点集合(按层级从小到大排列)
	 */
	public List<N> findDown(N node, BaseTreeSearcher<N> searcher, boolean needSelf) {
		return baseTree.findDown(node, searcher, needSelf, this.getChildMap());
	}
	
	/**
	 * 从某节点开始往下级搜索，找到一个符合条件的就返回
	 * @param node		当前节点
	 * @param searcher		自定义搜索条件
	 * @param needSelf		是否搜索自己
	 * @return		匹配条件的第一个节点(层级小的优先)	找不到则返回null
	 */
	public N findDownFirst(N node, BaseTreeSearcher<N> searcher, boolean needSelf) {
		return baseTree.findDownFirst(node, searcher, needSelf, this.getChildMap());
	}
	
	/**
	 * 获得某节点的所有祖先节点
	 * @param node		当前节点
	 * @param needSelf		是否包含自己
	 * @return		祖先节点集合(按层级从大到小排列)
	 */
	public List<N> getParentsNode(N node, boolean needSelf) {
		return baseTree.getParentsNode(node, this.getSelfMap(), needSelf);
	}
 
	/**
	 * 获取某节点的所有后代节点
	 * @param node	当前节点
	 * @param needSelf	是否包含自己
	 * @return		后代节点集合(按层级从小到大排列)
	 */
	public List<N> getSubNode(N node, boolean needSelf) {
		return baseTree.getSubNode(node, this.getChildMap(), needSelf);
	}
	
	/**
	 * 获取某节点下面的所有叶子
	 * @param node	当前节点
	 * @return		叶子节点集合(如果自己是叶子，则集合中为自己)
	 */
	public List<N> getSubLeaf(N node) {
		return baseTree.getSubLeaf(node, this.getChildMap());
	}
	
	/**
	 * 获取某节点的父节点(直接上级)
	 * @param node
	 * @return		没有则返回null
	 */
	public N getParent(N node) {
		return baseTree.getParent(node, this.getSelfMap());
	}
	
	/**
	 * 获取某节点的所有孩子(直接下级)
	 * @param node
	 * @return		没有则返回null
	 */
	public List<N> getChildren(N node) {
		return baseTree.getChildren(node, this.getChildMap());
	}
	
	/**
	 * 判断一个节点是不是叶子
	 * @param node
	 * @return
	 */
	public boolean isLeaf(N node) {
		return baseTree.isLeaf(node, this.getChildMap());
	}
 
}