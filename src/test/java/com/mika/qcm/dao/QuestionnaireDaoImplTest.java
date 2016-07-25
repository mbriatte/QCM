package com.mika.qcm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public class QuestionnaireDaoImplTest {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
	 QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
     
	 @Before
		public void setUp() throws Exception 
		{
			Questionnaire q= new Questionnaire("Questionnaire init1");
			daoquestionnaire.add(q);
		}
	    
	    @Test
	    public void testAdd() {
	    
	        int oldSize = daoquestionnaire.getAll().size();
	        Questionnaire e = new Questionnaire("test");
	        daoquestionnaire.add(e);
	     
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	        daoquestionnaire.remove(e);
	     
	    }
	    
	    @Test
	    public void testAdd2element() {
	    
	        int oldSize = daoquestionnaire.getAll().size();
	        Questionnaire e = new Questionnaire("test");
	        daoquestionnaire.add(e);
	        Questionnaire e2 = new Questionnaire("test2");
	        daoquestionnaire.add(e2);
	        
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	        assertEquals (oldSize+ 2 , newSize);
	        daoquestionnaire.remove(e);
	    }
	  
	    @Test
	    public void testAddwithAssociation() {
	    	
	        int oldSize = daoquestionnaire.getAll().size();
	        Questionnaire e = new Questionnaire("questionnaire france");
	        Question q= new Question("Annee de la revolution francaise");
	        e.addQuestion(q);
	        daoquestionnaire.add(e);
	        Long id=e.getId();
	        int newSize = daoquestionnaire.getAll().size();

	        assertEquals (oldSize+ 1 , newSize);
	        Questionnaire f=daoquestionnaire.find(id);
	        assert(f!=null);
	        assertEquals(f.getQuestions().size(),1);
	    }
	  
	    
	    @Test
	    public void testUpdate() {
	    
	    	Long id=daoquestionnaire.getAll().get(0).getId();
	    	 Questionnaire e = daoquestionnaire.find(id);
	    	 e.setLibelle("new libelle");
	    	 daoquestionnaire.saveOrUpdate(e);
	    	 Questionnaire f = daoquestionnaire.find(id);
	    	 assertTrue(e.getLibelle().equalsIgnoreCase(f.getLibelle()));
	    }
	    
	    
	    @Test
	    public void testRemove() {
	    	
	        int oldSize = daoquestionnaire.getAll().size();
	        
	        Questionnaire e = daoquestionnaire.getAll().get(0);
	        daoquestionnaire.remove(e);
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	    }
	     
	    @Test
	    public void testList() {
	    	
	        List<Questionnaire> list = daoquestionnaire.getAll();
	      
	        assertNotNull (list);
	        assertFalse (list.isEmpty());
	    }
	    
	    
	    @Test
	    public void testFind() {
	    	
	    	  Long id =  daoquestionnaire.getAll().get(0).getId();
	    	Questionnaire q=daoquestionnaire.find(id);
	    	   assertNotNull (q);
	    	   assertTrue (q.getId()==id);
	    	
	    }
	    
	    @Test
	    public void testFindbyname() {
	    	 Questionnaire e = new Questionnaire("testrecehrche");
		        daoquestionnaire.add(e);
	    		    			  
		        Questionnaire f= daoquestionnaire.findByNameWithAssociations("testrecehrche");
				 
		    	
		    	assertEquals (f.getLibelle(),"testrecehrche");
		    	 f= daoquestionnaire.findByNameWithAssociations("inconnu");
		    	assertTrue (f==null);
		       
	    }

	    @Test
	    public void testFindbynamegeneric() {
	    	 Questionnaire e = new Questionnaire("testrecehrche2");
		        daoquestionnaire.add(e);
	    		    			  
		        List<Questionnaire> l=  (List<Questionnaire>) daoquestionnaire.findByCriteria(Questionnaire.class, Restrictions.eq("libelle","testrecehrche2"));
		        Questionnaire f= l.get(0);
		    
		    	assertEquals (f.getLibelle(),"testrecehrche2");
		    			       	    	
	    }
	    
}
