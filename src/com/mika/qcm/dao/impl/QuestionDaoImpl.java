package com.mika.qcm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;


import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.model.Question;


public class QuestionDaoImpl extends GenericDaoImpl<Question, Long> implements QuestionDao {

	@Override
	
	public List<Question> findQuestionWithoutQuestionnaire() {
		SessionFactory session = this.getSessionFactory();
		
		String query = "from Question a where a not in  (select b.id from Questionnaire q join q.questions as b)";
		
		return session.getCurrentSession().createQuery(query).list();

	}

	
	
}
