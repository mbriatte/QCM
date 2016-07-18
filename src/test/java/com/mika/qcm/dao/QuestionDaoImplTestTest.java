package test.java.com.mika.qcm.dao;

import static org.junit.Assert.*;

import java.util.List;


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
	public void setUp() throws Exception 
	{
	 
		Questionnaire q= new Questionnaire("Questionnaire init");
		daoquestionnaire.add(q);
		
		Question quest=new Question("Question init");
		daoquestion.add(quest);
	}
	
	@Test
	public void testremoveQuestion() {
		
		Questionnaire e = new Questionnaire("test Questionnaire ");
		daoquestionnaire.add(e);
		Long cpt=0L;
        for (int i = 1; i <= 2; i++) {
            Question q = new Question( "test "+i);
            e.addQuestion(q);
            daoquestionnaire.saveOrUpdate(e);
            daoquestion.add(q);
            cpt=q.getId();
        }
        
		
        int oldSize = daoquestion.getAll().size();
        System.out.println("remove "+ oldSize);
      
        Question q=daoquestion.find(cpt);
        daoquestion.remove(q);
        int newSize = daoquestion.getAll().size();
         
        assertFalse (oldSize == newSize);	
        }
	
	@Test
	public void testFindwithoutQuestionnaire() {
		
		
		List<Question> l= daoquestion.findQuestionWithoutQuestionnaire();
         
        assertTrue (l.size() > 0);	
        }
	
	@Test
	public void testAddQuestion(){
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		daoquestion.add(q);
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
	}
	
	@Test
	public void testRemoveQuestion(){
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		daoquestion.add(q);
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		sizebefore=sizeafter;
		daoquestion.remove(q);
		 sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore,sizeafter+1);
	}
	
	@Test
	public void testSaveQuestion(){
		int sizebefore = daoquestion.getAll().size();
		Question q = new Question();
		q.setEnonce("ceci est un enoncé");
		daoquestion.add(q);
		int sizeafter = daoquestion.getAll().size();
		assertEquals(sizebefore+1,sizeafter);
		q.setEnonce("ceci est un ennoncé modifié");
		daoquestion.update(q);
	}

}
