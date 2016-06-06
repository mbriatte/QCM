package test.com.mika.qcm.dao;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mika.qcm.DAO.QuestionDao;
import com.mika.qcm.DAO.QuestionnaireDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public class QuestionnaireDaoImplTest {
	ClassPathXmlApplicationContext context =null;
	 QuestionnaireDao daoquestionnaire =null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		  context = new ClassPathXmlApplicationContext("spring-database.xml");			
		  daoquestionnaire = context.getBean(QuestionnaireDao.class);	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrUpdate() {
		 Questionnaire p1 = new Questionnaire();
	      p1.setLibelle("Michaelaaa");
	      p1.setId("abcDasa");	      
	      daoquestionnaire.saveOrUpdate(p1);
		//close resources
		context.close();	
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
