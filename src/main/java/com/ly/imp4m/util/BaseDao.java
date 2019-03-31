package com.ly.imp4m.util;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {

    @Resource(name = "sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 创建一个Class的对象来获取泛型的class
     */
    private Class<T> clz;


    public Class<T> getClz() {
        if (clz == null) {
            //获取泛型的Class对象
            clz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }

    public boolean add(T t) {
        try {
            this.getSessionFactory().getCurrentSession().save(t);
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            this.getSessionFactory().getCurrentSession().delete(this.load(id));
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean delete(T t) {
        try {
            this.getSessionFactory().getCurrentSession().delete(t);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public int delete(String hql, Object[] args) {

        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        return u.executeUpdate();
    }

    public boolean update(T t) {
        try {
            this.getSessionFactory().getCurrentSession().update(t);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public T load(String id) {
        return (T) this.getSessionFactory().getCurrentSession().get(getClz(), id);
    }

    public List<T> list(String hql, Object[] args) {
        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        List<T> list = u.list();
        return list;
    }


    public List<T> listLimit(String hql, Object[] args, int frist, int maxrs) {
        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        List<T> list = u.setFirstResult(frist).setMaxResults(maxrs).list();
        return list;
    }

    public List<T> listsql(String hql, Object[] args) {
        Query u = this.getSessionFactory().getCurrentSession().createSQLQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        List<T> list = u.list();
        return list;
    }

    public List<T> list(String hql) {
        return this.list(hql, null);
    }

    public List<T> list(String hql, Object arg) {
        return this.list(hql, new Object[]{arg});
    }

    public List<T> listsql(String hql) {
        return this.listsql(hql, null);
    }

    public List<T> listsql(String hql, Object arg) {
        return this.listsql(hql, new Object[]{arg});
    }

    public T load(String hql, Object[] args) {
        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        return (T) u.uniqueResult();
    }


    public int getTotalCount() {
        String hql = "select count (*) from " + this.getClz().getName();
        return (int) ((Long) this.getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult()).longValue();
    }

    public int getTotalCount(String hql, Object[] args) {
        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        return (u.uniqueResult())!=null?(int) ((Long)(u.uniqueResult())).longValue():0;
    }

    public List<T> getPage(int startIndex, int count) {
        return this.getSessionFactory().getCurrentSession().createQuery(
                "from " + this.getClz().getName() + " as c order by c.id asc").setFirstResult(startIndex).setMaxResults(count).list();
    }

    public List<T> getPage(String hql, Object[] args, int startIndex, int count) {
        Query u = this.getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        List<T> list = u.setFirstResult(startIndex).setMaxResults(count).list();
        return list;
    }

    public List<T> getAll() {
        return  this.getSessionFactory().getCurrentSession().createQuery("from " + this.getClz().getName() + " as c order by c.id asc").list();
    }

    @Override
    public int executeSql(String sql, Object[] args) {
        Query u = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                u.setParameter(i, args[i]);
            }
        }
        return u.executeUpdate();
    }
}
