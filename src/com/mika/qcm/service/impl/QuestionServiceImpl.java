package com.mika.qcm.service.impl;

import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.service.QuestionService;

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
	public void removeQuestion(Long idquestion) {
		Question q=questionDao.find(idquestion);
		if (q!=null)questionDao.remove(q);
		
	}
	
}
