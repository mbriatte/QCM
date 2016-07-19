package main.java.com.mika.qcm.service.impl;

import java.util.List;

import main.java.com.mika.qcm.dao.PropositionDao;
import main.java.com.mika.qcm.dao.QuestionDao;

import main.java.com.mika.qcm.model.Proposition;
import main.java.com.mika.qcm.model.Question;

import main.java.com.mika.qcm.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao;

	private PropositionDao propositionDao;

	
	public void setQuestionDao(QuestionDao q)
	{
		this.questionDao=q;
	}

	public void setPropositionDao(PropositionDao q)
	{
		this.propositionDao=q;
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
		Question q = this.questionDao.find(idquestion);
		if (p!=null && q!=null) 
			{
			q.removeProposition(p);
			this.questionDao.saveOrUpdate(q);
			this.propositionDao.remove(p);
			}
		
	}



	@Override
	public void saveQuestion(Question q) {
		if (q!=null) this.questionDao.saveOrUpdate(q);
		
	}


	@Override
	public void addPropositionToQuestion(Proposition p, Long idquestion) {
		Question quest= this.questionDao.find(idquestion);

		if (quest!=null) 
			{
			quest.addProposition(p);
			this.questionDao.saveOrUpdate(quest);          
			}	
		
	}


	@Override
	public List<Question> getQuestionWithoutQuestionnaire() {
	
		return questionDao.findQuestionWithoutQuestionnaire();
	}


	@Override
	public Question getQuestion(Long id) {
		return questionDao.find(id);
	}


	@Override
	public List<Question> getQuestions() {
		return questionDao.getAll();
	}
	
}
