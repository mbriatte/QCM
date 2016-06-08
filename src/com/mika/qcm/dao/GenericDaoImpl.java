package com.mika.qcm.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Transactional

public abstract class GenericDaoImpl<E, K extends Serializable>  implements GenericDao<E, K> {

	@Autowired
    private SessionFactory sessionFactory;
	

    protected Class<? extends E> daoType;
     
    /**
    * By defining this class as abstract, we prevent Spring from creating 
    * instance of this class If not defined as abstract, 
    * getClass().getGenericSuperClass() would return Object. There would be 
    * exception because Object class does not hava constructor with parameters.
    */
 
	@SuppressWarnings("rawtypes")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
	   
	 public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	 
	 protected SessionFactory getSessionFactory() {
	     if (sessionFactory == null)
	         throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
	     return sessionFactory;
	 }
	 
    protected Session currentSession() {
    	
    	    return sessionFactory.getCurrentSession();
    	
    }
     
    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(E entity) {
    	
        currentSession().saveOrUpdate(entity);
    
    }
     
    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }
     
    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }
     
    @Override
    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
 

}
