package com.mika.qcm.service;

import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Question;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;

	
	public void setQuestionDao(QuestionDao q)
	{
		this.questionDao=q;
	}


	@Override
	public void addQuestion(Question q) {
		questionDao.add(q);
	}


	@Override
	public void removeQuestion(Question q) {
		questionDao.remove(q);
		
	}


	@Override
	public void removeQuestion(String idquestion) {
		Question q=questionDao.find(idquestion);
		if (q!=null)questionDao.remove(q);
		
	}
	
}
