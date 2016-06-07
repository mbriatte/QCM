package com.mika.qcm.service;

import com.mika.qcm.DAO.QuestionDao;
import com.mika.qcm.DAO.QuestionnaireDao;
import com.mika.qcm.model.Question;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;

	
	public void setQuestionDao(QuestionDao q)
	{
		this.questionDao=q;
	}
	
}
