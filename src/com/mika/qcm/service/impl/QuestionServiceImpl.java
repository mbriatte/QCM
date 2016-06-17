package com.mika.qcm.service.impl;

import com.mika.qcm.dao.PropositionDao;
import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.model.Proposition;
import com.mika.qcm.model.Question;
import com.mika.qcm.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;

	private PropositionDao propositionDao;

	
	public void setQuestionDao(QuestionDao q)
	{
		this.questionDao=q;
	}


	@Override
	public void addQuestion(Question q) {
		questionDao.add(q);
	}


	@Override
	public void removeQuestion(Long idquestion) {
		Question q=questionDao.find(idquestion);
		if (q!=null)questionDao.remove(q);
		
	}




	@Override
	public void removePropositionFromQuestion(Long idproposition, Long idquestion) {
		Proposition p = this.propositionDao.find(idproposition);
		if (p!=null) this.propositionDao.remove(p);
		
	}


	@Override
	public void saveProposition(Proposition p) {
		if (p!=null) this.propositionDao.saveOrUpdate(p);
		
	}


	@Override
	public void saveQuestion(Question q) {
		if (q!=null) this.questionDao.saveOrUpdate(q);
		
	}


	@Override
	public void addPropositionToQuestion(Long idproposition, Long idquestion) {
		Proposition p = this.propositionDao.find(idproposition);
		Question q = this.questionDao.find(idquestion);
		q.addProposition(p);
		this.questionDao.saveOrUpdate(q);
		this.propositionDao.saveOrUpdate(p);
		
		
		
	}
	
}
