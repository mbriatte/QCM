package test.java.com.mika.qcm.service;

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
import com.mika.qcm.model.Proposition;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.service.QuestionService;


public class QuestionServiceImplTest {
	
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/test/java/com/mika/qcm/spring-database.xml");
		
	 QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
	 QuestionDao daoquestion = context.getBean(QuestionDao.class);
	 QuestionService questionService =  context.getBean(QuestionService.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Question q=new Question("ceci est une question sans questionnaire");
		daoquestion.add(q);
		
		Questionnaire quest = new Questionnaire("ceci est un questionnaire");
		quest.addQuestion(new Question("ceci est une question d'un questionnaire"));
		daoquestionnaire.add(quest);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddQuestion() {
		
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		this.questionService.addQuestion(q);
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		
		
	}
	
	@Test
	public void testaddQuestionWithProposition() {
		
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		Proposition p = new Proposition("ceci est une proposition");
		q.addProposition(p);
		this.questionService.addQuestion(q);
		Long id = q.getId();
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		Question q2=daoquestion.find(id);
		
		assertEquals(q2.getPropositions().size(),1);
		
	}
	
	@Test
	public void testremoveQuestion() {
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		this.questionService.addQuestion(q);
		Long idquestion=q.getId();
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		sizebefore=sizeafter;
		questionService.removeQuestion(idquestion);
		 sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore,sizeafter+1);
	}
	
	@Test
	public void testremoveQuestionwithproposition() {
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		this.questionService.addQuestion(q);
		Long idquestion=q.getId();
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		sizebefore=sizeafter;
		
		Proposition p = new Proposition("ceci est une proposition 1");
		q.addProposition(p);
		questionService.addPropositionToQuestion(p, idquestion);
		questionService.removeQuestion(idquestion);
		 sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore,sizeafter+1);
	}
	
	@Test
	public void testgetQuestionWithoutQuestionnaire() {
		List<Question> l= questionService.getQuestionWithoutQuestionnaire();
        
        assertTrue (l.size() > 0);	
	}

	@Test
	public void testaddPropositionToQuestion() {
		
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		questionService.addQuestion(q);
		Proposition p = new Proposition("ceci est une proposition 1");
		q.addProposition(p);
		this.questionService.addPropositionToQuestion(p, q.getId());
		Question r=questionService.getQuestion(q.getId());
		assertEquals(r.getPropositions().size(),1);
	}
	
	@Test
	public void testemovePropositionFromQuestion() {
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		questionService.addQuestion(q);
		Proposition p = new Proposition("ceci est une proposition 1");
		q.addProposition(p);
		this.questionService.addPropositionToQuestion(p, q.getId());
		Proposition p2 = new Proposition("ceci est une proposition 2");
		q.addProposition(p2);
	
		this.questionService.addPropositionToQuestion(p2, q.getId());
		Long idproposition=p2.getId();
		
		Question r=questionService.getQuestion(q.getId());
		assertEquals(r.getPropositions().size(),2);
		questionService.removePropositionFromQuestion(idproposition, q.getId());
		Question s=questionService.getQuestion(q.getId());
		assertEquals(s.getPropositions().size(),1);
	}
	
	@Test
	public void testsaveQuestion() {
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		questionService.saveQuestion(q);
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		
	}
	
	@Test
	public void testsaveQuestionwithassociation() {
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		Proposition p = new Proposition("ceci est une proposition");
		q.addProposition(p);
		questionService.saveQuestion(q);
		Long id = q.getId();
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		
		Question s=questionService.getQuestion(id);
		assertEquals(s.getPropositions().size(),1);
		
	}

}
