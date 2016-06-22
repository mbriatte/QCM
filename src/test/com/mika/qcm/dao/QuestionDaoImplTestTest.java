package test.com.mika.qcm.dao;

import static org.junit.Assert.*;

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
import com.mika.qcm.service.QuestionService;
import com.mika.qcm.service.QuestionnaireService;

public class QuestionDaoImplTestTest {
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
		
	 
	 QuestionDao daoquestion = context.getBean(QuestionDao.class);
	 QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
	 QuestionService questionService = context.getBean(QuestionService.class);
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		Questionnaire e = new Questionnaire("test Questionnaire");
		daoquestionnaire.add(e);
        for (int i = 1; i <= 2; i++) {
            Question q = new Question( "test "+i);
            e.addQuestion(q);
            daoquestionnaire.saveOrUpdate(e);
            daoquestion.add(q);
        }
	}

	//@After
	public void tearDown() throws Exception {
		System.out.println("teardown");
 		
 		List<Question> q1= daoquestion.getAll();
        for (Question quest  : q1)
      	  daoquestion.remove(quest);
                                
         List<Questionnaire> q2= daoquestionnaire.getAll();         
          for (Questionnaire quest  : q2)
        	  daoquestionnaire.remove(quest);
	}

	@Test
	public void testremoveQuestion() {
		
		
		System.out.println("test remove");
        int oldSize = daoquestion.getAll().size();
        System.out.println("remove "+ oldSize);
        Question e = daoquestion.getAll().get(0);
        daoquestion.remove(e);
        int newSize = daoquestion.getAll().size();
         
        assertFalse (oldSize == newSize);	
        }
	
	@Test
	public void testFindwithoutQuestionnaire() {
		
		
		List<Question> l= daoquestion.findQuestionWithoutQuestionnaire();
         
        assertTrue (l.size() > 0);	
        }

}
