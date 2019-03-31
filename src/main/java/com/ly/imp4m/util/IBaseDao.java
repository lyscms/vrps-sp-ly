package com.ly.imp4m.util;

import java.util.List;

public interface IBaseDao<T> {
	public boolean add(T t);
	public boolean delete(String id);
	public boolean delete(T t);
	public int delete(String hql, Object[] args);
	public boolean update(T t);
	public T load(String id);
	public List<T> list(String hql, Object[] args);
	public List<T> list(String hql);
	public List<T> list(String hql, Object arg);
	public List<T> listLimit(String hql, Object[] args, int frist, int maxrs);
	public List<T> listsql(String hql, Object[] args);
	public List<T> listsql(String hql);
	public List<T> listsql(String hql, Object arg);
	public T load(String hql, Object[] args);

	public int getTotalCount();
	public int getTotalCount(String hql, Object[] args);
	public List<T> getPage(int startIndex, int count);
	public List<T> getPage(String hql, Object[] args, int startIndex, int count);
	public List<T> getAll();
	public int executeSql(String sql, Object[] args);
}
