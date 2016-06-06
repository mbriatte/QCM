package com.mika.qcm.util;

import java.io.Console;
import java.util.Iterator;

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
      p1.setLibelle("Michaela");
      p1.setId("abcD");
      
      Iterator<Question> it=p1.getQuestions().iterator();
      while (it.hasNext()) {System.out.println(it.next().getEnonce());}
      
      Question q1=new Question("q2","test question");
      
      p1.AddQuestion(q1);
    //  daoquestion.saveOrUpdate(q1);
      daoquestionnaire.saveOrUpdate(p1);
      
      Question q2=new Question("q3","test question3");
      p1.AddQuestion(q2);
      daoquestionnaire.saveOrUpdate(p1);
     q2.setEnonce("test3");
     daoquestion.saveOrUpdate(q2);
	//close resources
	context.close();	
	 }
}