package test.com.mika.qcm.service;

import static org.junit.Assert.*;

import java.util.Collection;
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
import com.mika.qcm.service.QuestionnaireService;

public class QuestionnaireServiceImplTest {
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
		
	 QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
	 QuestionDao daoquestion = context.getBean(QuestionDao.class);
	 QuestionnaireService questionnaireService = context.getBean(QuestionnaireService.class);
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
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
	public void TestAddQuestionnaire() {
		int sizebefore=daoquestionnaire.getAll().size();
		Questionnaire q = new Questionnaire("Questionnaire1","ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		assertFalse(sizebefore==daoquestionnaire.getAll().size());
		
	}
	
	@Test
	public void TestAddQuestionTonewQuestionnaire() {
		
		Questionnaire q = new Questionnaire("Questionnaire2","ceci est un questionnaire");
		Question quest= new  Question("Question1","ceci est une question");
		System.out.println("addQuestion");
		q.addQuestion(quest);
		System.out.println("addQuestionnaire");
		questionnaireService.addQuestionnaire(q);
		Questionnaire q2=daoquestionnaire.find("Questionnaire2");
	
		
		assertFalse(0==q2.getQuestions().size());
		
	}
	
	@Test
	public void TestAddQuestionToOldQuestionnaire() {
		
		Questionnaire q = new Questionnaire("Questionnaire2","ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		Question quest= new  Question("Question1","ceci est une question");
		System.out.println("addQuestion");
		q.addQuestion(quest);
		System.out.println("addQuestionnaire");
		questionnaireService.saveQuestionnaire(q);
		Questionnaire q2=daoquestionnaire.find("Questionnaire2");
	
		
		assertFalse(0==q2.getQuestions().size());
		
	}
	
	@Test
	public void TestRemoveQuestionToQuestionnaire() {
		
		Questionnaire q = new Questionnaire("Questionnaire2","ceci est un questionnaire");
		Question quest1= new  Question("Question1","ceci est une question");
		Question quest2= new  Question("Question2","ceci est une question2");
		q.addQuestion(quest1);
		q.addQuestion(quest2);
		
		assertTrue(2==q.getQuestions().size());

		q.removeQuestion(quest2);
		questionnaireService.removeQuestionFromQuestionnaire(quest2, q);
		assertTrue(1==q.getQuestions().size());
	}
	
}
