package com.mika.qcm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mika.qcm.DAO.GenericDao;
import com.mika.qcm.DAO.QuestionDao;
import com.mika.qcm.DAO.QuestionnaireDao;
import com.mika.qcm.DAO.QuestionnaireDaoImpl;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;





public class App {
	
	
	 public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
	
	QuestionnaireDao daoquestionnaire = context.getBean(QuestionnaireDao.class);
	QuestionDao daoquestion = context.getBean(QuestionDao.class);
	
	  Questionnaire p1 = new Questionnaire();
      p1.setLibelle("Michael");
      p1.setId("abc");
      
      Question q1=new Question("q1","test question");
      
      p1.AddQuestion(q1);
      daoquestion.saveOrUpdate(q1);
	
      daoquestionnaire.saveOrUpdate(p1);
      
     
	
	//close resources
	context.close();	
	 }
}