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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	

	@Test
	public void TestAddQuestionnaire() {
		int sizebefore=daoquestionnaire.getAll().size();
		Questionnaire q = new Questionnaire("ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		assertEquals(sizebefore+1,daoquestionnaire.getAll().size());
	}
	
	@Test
	public void TestAddQuestionTonewQuestionnaire() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire new");
		Question quest= new  Question("ceci est une question new");		
	
		
		questionnaireService.addQuestionnaire(q);
		
		Long id=q.getId();
		System.out.println("id="+id);
		questionnaireService.addQuestionToQuestionnaire(quest, id);
	
		Questionnaire q2=daoquestionnaire.find(id);	
		System.out.println("questionnaire="+q2);
		assertEquals(1,q2.getQuestions().size());
		
	}
	
	@Test
	public void TestAddQuestionToOldQuestionnaire() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		Long id=q.getId();
		Question quest= new  Question("ceci est une question");
		Question quest2= new  Question("ceci est une question");
		
		
		questionnaireService.getQuestionnaire(id);
		
		questionnaireService.addQuestionToQuestionnaire(quest, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		
		Questionnaire q2=daoquestionnaire.find(id);
		assertEquals(2,q2.getQuestions().size());
		System.out.println("fin de test 도도도도도도도도도도도도도도도�");
	}
	
	
	@Test
	public void TestRemoveQuestionToQuestionnaire() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire remove");
		Question quest1= new  Question("ceci est une question remove");
		Question quest2= new  Question("ceci est une question2 remove");
		questionnaireService.saveQuestionnaire(q);
		Long id=q.getId();
		questionnaireService.addQuestionToQuestionnaire(quest1, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
	
		Questionnaire q2 =daoquestionnaire.find(id);
		assertEquals(2,q2.getQuestions().size());

		questionnaireService.removeQuestionFromQuestionnaire(quest2.getId(), id);
		Questionnaire q3 =daoquestionnaire.find(id);
		
		assertEquals(1,q3.getQuestions().size());
		
	}

	
	
}
