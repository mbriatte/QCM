package test.com.mika.qcm.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

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
     
	    
	 	@Before
	    public void setUp() {
	 		System.out.println("setup");
	        for (int i = 1; i < 5; i++) {
	            Questionnaire e = new Questionnaire("id"+ i, "test "+i);
	            daoquestionnaire.add(e);
	            
	        }
	    }
	 	
	 	
	 	@After
	    public void tearDown() {
	 		System.out.println("teardown");
	        for (int i = 1; i < 5; i++) {
	           
	           Questionnaire q= daoquestionnaire.find("id"+i);
	           if (q !=null) 
	        	   {
	        	   System.out.println("suppression de l'objet "+q.getId());
	        	   	daoquestionnaire.remove(q);
	        	   }
	           
	        }
	    }
	 	
	    @Test
	    public void testAdd() {
	    	System.out.println("test add");
	        int oldSize = daoquestionnaire.getAll().size();
	        Questionnaire e = new Questionnaire("id"+oldSize+1, "test");
	        daoquestionnaire.add(e);
	        System.out.println("creation de l'objet "+oldSize);
	        int newSize = daoquestionnaire.getAll().size();
	         
	        assertFalse (oldSize == newSize);
	        daoquestionnaire.remove(e);
	    }
	  
	     
	    @Test
	    public void testUpdate() {
	    	System.out.println("test update");
	    	 Questionnaire e = daoquestionnaire.find("id1");
	    	 e.setLibelle("new libelle");
	    	 daoquestionnaire.saveOrUpdate(e);
	    	 Questionnaire f = daoquestionnaire.find("id1");
	    	 assertTrue(e.getLibelle().equalsIgnoreCase(f.getLibelle()));
	    }
	    
	    
	    @Test
	    public void testRemove() {
	    	System.out.println("test remove");
	        int oldSize = daoquestionnaire.getAll().size();
	        System.out.println("remove "+ oldSize);
	        Questionnaire e = daoquestionnaire.find("id1");
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
	    

}
