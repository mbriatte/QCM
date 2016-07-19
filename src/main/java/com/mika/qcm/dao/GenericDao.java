package main.java.com.mika.qcm.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDao <E,K> {
	    public void add(E entity) ;
	    public void saveOrUpdate(E entity) ;
	    public void update(E entity) ;
	    public void remove(E entity);
	    public E find(K key);
	    public List<E> getAll() ;
	    List<?> findByCriteria(Class<?> persistentClass, Criterion... criterion);
	 
	   
}