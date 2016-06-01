package com.mika.qcm.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

public interface GenericDao <E,K> {
	    public void add(E entity) ;
	    public void saveOrUpdate(E entity) ;
	    public void update(E entity) ;
	    public void remove(E entity);
	    public E find(K key);
	    public List<E> getAll() ;
	  

	   
}