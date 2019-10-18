package com.ly.vrps.common.util.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础树服务实现类
 *
 * @param <N>树节点
 * @param <K>树节点id(唯一标识)(K须具有有效的hashCode与equals方法)
 * @author abo
 */
public abstract class BaseTreeImpl<N, K> implements BaseTree<N, K> {

    /**
     * 获取节点唯一标识方法
     *
     * @param node
     * @return
     */
    protected abstract K getKey(N node);

    /**
     * 获取节点父节点唯一标识方法
     *
     * @param node
     * @return
     */
    protected abstract K getParentKey(N node);

    @Override
    public Map<K, List<N>> getAllNodeAsMap(List<N> nodeList) {
        //map初始化容量(假设为满二叉树)
        int initialCapacity = Math.max((int) ((nodeList.size() - 1) / 2.0f / .75f) + 1, 16);
        //建一个map来存放 父节点no到子节点列表 的映射
        Map<K, List<N>> childMap = new HashMap<>(initialCapacity);
        //遍历一遍
        for (N node : nodeList) {
            //取出它父节点的子节点列表
            List<N> childList = childMap.get(getParentKey(node));
            //如果还没有子节点列表，就新建一个
            if (childList == null) {
                childList = new ArrayList<>();
                childMap.put(getParentKey(node), childList);
            }
            //把自己放进去
            childList.add(node);
        }
        return childMap;
    }

    @Override
    public Map<K, N> getAllNodeSelfMap(List<N> nodeList) {
        //map初始化容量
        int initialCapacity = Math.max((int) (nodeList.size() / .75f) + 1, 16);
        //新建一个map
        Map<K, N> selfMap = new HashMap<>(initialCapacity);
        //遍历所有
        for (N node : nodeList) {
            //放进去map
            selfMap.put(getKey(node), node);
        }
        return selfMap;
    }

    @Override
    public List<N> findUp(N node, BaseTreeSearcher<N> searcher,
                          boolean needSelf, Map<K, N> selfMap) {
        //新建一个结果集
        List<N> results = new ArrayList<>();
        //这个变量去存储每个节点
        N currentNode;
        //先得到第一个
        currentNode = node;
        //需不需要搜索第一个
        if (needSelf && searcher.search(currentNode)) {
            results.add(currentNode);
        }
        //逐级往上搜索
        do {
            //取到父节点
            currentNode = getParent(currentNode, selfMap);
            if (currentNode == null) {
                //结束了
                break;
            }
            //搜索
            if (searcher.search(currentNode)) {
                results.add(currentNode);
            }
        } while (true);
        return results;
    }

    @Override
    public N findUpFirst(N node, BaseTreeSearcher<N> searcher,
                         boolean needSelf, Map<K, N> selfMap) {
        // 这个变量去存储每个节点
        N currentNode;
        // 先得到第一个
        currentNode = node;
        // 需不需要搜索第一个
        if (needSelf && searcher.search(currentNode)) {
            //返回
            return currentNode;
        }
        // 逐级往上搜索
        do {
            // 取到父节点
            currentNode = getParent(currentNode, selfMap);
            if (currentNode == null) {
                // 结束了
                break;
            }
            // 搜索
            if (searcher.search(currentNode)) {
                //返回
                return currentNode;
            }
        } while (true);
        //这里一定是null了
        return currentNode;
    }

    @Override
    public List<N> findDown(N node, BaseTreeSearcher<N> searcher,
                            boolean needSelf, Map<K, List<N>> childMap) {
        //先获得所有后代
        List<N> childList = getSubNode(node, childMap, needSelf);
        //新建一个结果集
        List<N> resultsList = new ArrayList<>();
        //逐个去搜索
        for (N childNode : childList) {
            if (searcher.search(childNode)) {
                resultsList.add(childNode);
            }
        }
        return resultsList;
    }

    @Override
    public N findDownFirst(N node, BaseTreeSearcher<N> searcher,
                           boolean needSelf, Map<K, List<N>> childMap) {
        // 如果需要找自己
        if (needSelf && searcher.search(node)) {
            // 返回
            return node;
        }
        // 建一个集合用来做广度遍历
        List<N> nodeList = new ArrayList<>();
        // 先把自己放进去
        nodeList.add(node);
        // 进行广度遍历
        int i = nodeList.size() - 1; // 遍历下标
        List<N> childList; // 存放直接下级
        while (true) {
            // 获取孩子
            childList = getChildren(node, childMap);
            if (childList != null) {
                // 存在就加进去
                nodeList.addAll(childList);
            }
            i++;
            if (i >= nodeList.size()) {
                // 如果越界了，就跳出
                break;
            } else {
                // 否则node指向下一个
                node = nodeList.get(i);
                // 找下一个
                if (searcher.search(node)) {
                    // 匹配就直接返回
                    return node;
                }
            }
        }
        // 到这里说明没找到，返回null
        return null;
    }

    @Override
    public List<N> getParentsNode(N node, Map<K, N> selfMap, boolean needSelf) {
        //无条件往上搜索
        return findUp(node, node1 -> {
            //直接返回true
            return true;
        }, needSelf, selfMap);
    }

    @Override
    public List<N> getSubNode(N node, Map<K, List<N>> childMap, boolean needSelf) {
        //建一个空的结果
        List<N> nodeList = new ArrayList<>();
        //如果需要自己
        if (needSelf) {
            //先把自己放进去
            nodeList.add(node);
        }
        //进行广度遍历找到所有后代
        int i = nodeList.size() - 1;        //遍历下标
        List<N> childList;                    //存放直接下级
        while (true) {
            //获取孩子
            childList = getChildren(node, childMap);
            if (childList != null) {
                //存在就加进去
                nodeList.addAll(childList);
            }
            i++;
            if (i >= nodeList.size()) {
                //如果越界了，就跳出
                break;
            } else {
                //否则node指向下一个
                node = nodeList.get(i);
            }
        }
        return nodeList;
    }

    @Override
    public List<N> getSubLeaf(N node, final Map<K, List<N>> childMap) {
        // 搜索它的后代
        return findDown(node, node1 -> {
            // 是不是叶子
            return isLeaf(node1, childMap);
        }, true, childMap);
    }

    @Override
    public N getParent(N node, Map<K, N> selfMap) {
        return selfMap.get(getParentKey(node));
    }

    @Override
    public List<N> getChildren(N node, Map<K, List<N>> childMap) {
        return childMap.get(getKey(node));
    }

    @Override
    public boolean isLeaf(N node, Map<K, List<N>> childMap) {
        if (getChildren(node, childMap) == null) {
            // 没有下级，说明是叶子
            return true;
        }
        return false;
    }

}
