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
		questionnaireService.addQuestionToQuestionnaire(quest, id);
	
		Questionnaire q2=daoquestionnaire.find(id);	
		
		assertEquals(1,q2.getQuestions().size());
		
	}
	
	@Test
	public void TestAddQuestionToOldQuestionnaire() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		Long id=q.getId();
		Question quest= new  Question("ceci est une question");
		Question quest2= new  Question("ceci est une question");
		
		
		
		
		questionnaireService.addQuestionToQuestionnaire(quest, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		
		Questionnaire q2=daoquestionnaire.find(id);
		assertEquals(2,q2.getQuestions().size());
	}
	
	@Test
	public void TestAddQuestionToQuestionnaireWithQuestion() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire");
		questionnaireService.addQuestionnaire(q);
		Long id=q.getId();
		Question quest= new  Question("ceci est une question");
		Question quest2= new  Question("ceci est une question");
		
		
		questionnaireService.addQuestionToQuestionnaire(quest, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		
		Questionnaire q2=daoquestionnaire.find(id);
		assertEquals(2,q2.getQuestions().size());
		Question quest3= new  Question("ceci est une question2");
		Question quest4= new  Question("ceci est une question3");
		questionnaireService.addQuestionToQuestionnaire(quest3, id);
		questionnaireService.addQuestionToQuestionnaire(quest4, id);
		Questionnaire q3=daoquestionnaire.find(id);
		assertEquals(4,q3.getQuestions().size());
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
	
	@Test
	public void TestRemoveQuestionnaire() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire remove");
		Question quest1= new  Question("ceci est une question remove");
		Question quest2= new  Question("ceci est une question2 remove");

		questionnaireService.saveQuestionnaire(q);
		Long id=q.getId();
		questionnaireService.addQuestionToQuestionnaire(quest1, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		questionnaireService.removeQuestionnaire(id);
		Questionnaire q2 =daoquestionnaire.find(id);
				
		assertNull(q2);
		
	}
	
	@Test
	public void TestGetQuestion() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire ");
		Question quest1= new  Question("ceci est une question ");
		Question quest2= new  Question("ceci est une question2 ");

		questionnaireService.saveQuestionnaire(q);
		Long id=q.getId();
		questionnaireService.addQuestionToQuestionnaire(quest1, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		List l = questionnaireService.getQuestions(id);
		
		assertEquals(l.size(),2);
		
	}
	
	@Test
	public void TestgetQuestionnaireByNameSpecific() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire 1");
		Question quest1= new  Question("ceci est une question 1");
		Question quest2= new  Question("ceci est une question 2");
		questionnaireService.saveQuestionnaire(q);
		Long id=q.getId();
		questionnaireService.addQuestionToQuestionnaire(quest1, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		
		Questionnaire q2 = new Questionnaire("ceci est un questionnaire 2");
		Question quest11= new  Question("ceci est une question 11");
		Question quest22= new  Question("ceci est une question 22");
		Question quest23= new  Question("ceci est une question 23");
		questionnaireService.saveQuestionnaire(q2);
		 id=q2.getId();
		questionnaireService.addQuestionToQuestionnaire(quest11, id);
		questionnaireService.addQuestionToQuestionnaire(quest22, id);
		questionnaireService.addQuestionToQuestionnaire(quest23, id);
		
		
		Questionnaire q3 = new Questionnaire("ceci est un questionnaire 3");
		Question quest111= new  Question("ceci est une question 111");
		Question quest222= new  Question("ceci est une question 222");
		Question quest223= new  Question("ceci est une question 234");
		questionnaireService.saveQuestionnaire(q3);
		 id=q3.getId();
		questionnaireService.addQuestionToQuestionnaire(quest111, id);
		questionnaireService.addQuestionToQuestionnaire(quest222, id);
		questionnaireService.addQuestionToQuestionnaire(quest223, id);
		
		Questionnaire qbyid=questionnaireService.getQuestionnaire(id);
		assertEquals(3,qbyid.getQuestions().size());
		
		System.out.println("debut recherche");
		Questionnaire qs=questionnaireService.getQuestionnaireWithAssociationByName("ceci est un questionnaire 3");
		assertEquals("ceci est un questionnaire 3",qs.getLibelle());
		assertEquals(3,qs.getQuestions().size());
		
	}

	@Test
	public void TestgetQuestionnaireByNamegeneric() {
		
		Questionnaire q = new Questionnaire("ceci est un questionnaire 1");
		Question quest1= new  Question("ceci est une question 1");
		Question quest2= new  Question("ceci est une question 2");
		questionnaireService.saveQuestionnaire(q);
		Long id=q.getId();
		questionnaireService.addQuestionToQuestionnaire(quest1, id);
		questionnaireService.addQuestionToQuestionnaire(quest2, id);
		
		Questionnaire q2 = new Questionnaire("ceci est un questionnaire 2");
		Question quest11= new  Question("ceci est une question 11");
		Question quest22= new  Question("ceci est une question 22");
		Question quest23= new  Question("ceci est une question 23");
		questionnaireService.saveQuestionnaire(q2);
		 id=q2.getId();
		questionnaireService.addQuestionToQuestionnaire(quest11, id);
		questionnaireService.addQuestionToQuestionnaire(quest22, id);
		questionnaireService.addQuestionToQuestionnaire(quest23, id);
		
		
		Questionnaire q3 = new Questionnaire("ceci est un questionnaire 3");
		Question quest111= new  Question("ceci est une question 111");
		Question quest222= new  Question("ceci est une question 222");
		Question quest223= new  Question("ceci est une question 234");
		questionnaireService.saveQuestionnaire(q3);
		 id=q3.getId();
		questionnaireService.addQuestionToQuestionnaire(quest111, id);
		questionnaireService.addQuestionToQuestionnaire(quest222, id);
		questionnaireService.addQuestionToQuestionnaire(quest223, id);
		
		Questionnaire qbyid=questionnaireService.getQuestionnaire(id);
		assertEquals(3,qbyid.getQuestions().size());
		

		Questionnaire qs=questionnaireService.getQuestionnaireByName("ceci est un questionnaire 3");
		assertEquals("ceci est un questionnaire 3",qs.getLibelle());
		assertEquals(3,qs.getQuestions().size());
		
	}

	
	
	
	
	
}
