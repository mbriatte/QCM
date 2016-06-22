package com.mika.qcm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public class QuestionDaoImpl extends GenericDaoImpl<Question, Long> implements QuestionDao {

	@Override
	public List<Question> findQuestionWithoutQuestionnaire() {
		SessionFactory sessionf = this.getSessionFactory();
		
		String query = "from Question a where a not in  (select b.id from Questionnaire q  join  q.questions as b)";
		
		return sessionf.getCurrentSession().createQuery(query).list();

	}

	
	
}
