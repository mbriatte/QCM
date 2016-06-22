package test.com.mika.qcm.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public class QuestionnaireDaoImplTest {
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
		
	 QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
     
	    
	    @Test
	    public void testAdd() {
	    	System.out.println("test add");
	        int oldSize = daoquestionnaire.getAll().size();
	        Questionnaire e = new Questionnaire("test");
	        daoquestionnaire.add(e);
	        System.out.println("creation de l'objet "+oldSize);
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	        daoquestionnaire.remove(e);
	    }
	    
	    @Test
	    public void testAdd2element() {
	    	System.out.println("test add");
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
	    public void testUpdate() {
	    	System.out.println("test update");
	    	Long id=daoquestionnaire.getAll().get(0).getId();
	    	 Questionnaire e = daoquestionnaire.find(id);
	    	 e.setLibelle("new libelle");
	    	 daoquestionnaire.saveOrUpdate(e);
	    	 Questionnaire f = daoquestionnaire.find(id);
	    	 assertTrue(e.getLibelle().equalsIgnoreCase(f.getLibelle()));
	    }
	    
	    
	    @Test
	    public void testRemove() {
	    	System.out.println("test remove");
	        int oldSize = daoquestionnaire.getAll().size();
	        System.out.println("remove "+ oldSize);
	        Questionnaire e = daoquestionnaire.getAll().get(0);
	        daoquestionnaire.remove(e);
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	    }
	     
	    @Test
	    public void testList() {
	    	System.out.println("test list");
	        List<Questionnaire> list = daoquestionnaire.getAll();
	        System.out.println("liste "+ list.size());
	        assertNotNull (list);
	        assertFalse (list.isEmpty());
	    }
	    
	    
	    @Test
	    public void testFind() {
	    	System.out.println("test list");
	    	  Long id =  daoquestionnaire.getAll().get(0).getId();
	    	Questionnaire q=daoquestionnaire.find(id);
	    	   assertNotNull (q);
	    	   assertTrue (q.getId()==id);
	    	
	    }
	    
	    @Test
	    public void testFindbyname() {
	    	 Questionnaire e = new Questionnaire("testrecehrche");
		        daoquestionnaire.add(e);
	    		    			  
		        Questionnaire f= daoquestionnaire.findBynamewithAssociation("testrecehrche");
				 
		    	System.out.println("questionnaire nom ="+ f.getLibelle());
		    	assertEquals (f.getLibelle(),"testrecehrche");
		    	 f= daoquestionnaire.findBynamewithAssociation("inconnu");
		    	assertTrue (f==null);
		       
	    }

	    @Test
	    public void testFindbynamegeneric() {
	    	 Questionnaire e = new Questionnaire("testrecehrche2");
		        daoquestionnaire.add(e);
	    		    			  
		        List<Questionnaire> l=  (List<Questionnaire>) daoquestionnaire.findByCriteria(Questionnaire.class, Restrictions.eq("libelle","testrecehrche2"));
		        Questionnaire f= l.get(0);
		    	System.out.println("questionnaire nom ="+ f.getLibelle());
		    	assertEquals (f.getLibelle(),"testrecehrche2");
		    			       	    	
	    }
	    
}
