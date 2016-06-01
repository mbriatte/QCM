package com.mika.qcm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mika.qcm.DAO.GenericDao;
import com.mika.qcm.DAO.QuestionDao;
import com.mika.qcm.DAO.QuestionnaireDao;
import com.mika.qcm.DAO.QuestionnaireDaoImpl;
import com.mika.qcm.model.Questionnaire;





public class App {
	/*
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Questionnaire p1 = new Questionnaire();
        p1.setLibelle("Michael");
        p1.setId("abc");
        QuestionnaireDao dao= new QuestionnaireDaoImpl();
        dao.setSessionFactory(sessionFactory);
        sessionFactory.getCurrentSession().beginTransaction();
        dao.saveOrUpdate(p1);
        sessionFactory.getCurrentSession().getTransaction().commit();
    
        session.close();
        
    }
    */
	
	 public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
	
	QuestionnaireDao dao = context.getBean(QuestionnaireDao.class);
	
	  Questionnaire p1 = new Questionnaire();
      p1.setLibelle("Michael");
      p1.setId("abc");
	
      dao.saveOrUpdate(p1);
    
   
	
	
	//close resources
	context.close();	
	 }
}