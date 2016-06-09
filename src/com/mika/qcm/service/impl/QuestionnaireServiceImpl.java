package com.mika.qcm.service.impl;

import java.util.List;

import com.mika.qcm.dao.QuestionDao;
import com.mika.qcm.dao.QuestionnaireDao;
import com.mika.qcm.dao.impl.GenericDaoImpl;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.service.QuestionnaireService;

public class QuestionnaireServiceImpl  implements QuestionnaireService {
	
	private QuestionnaireDao questionnaireDao;
	
	private QuestionDao questionDao;

	
	public void setQuestionnaireDao(QuestionnaireDao q)
	{
		this.questionnaireDao=q;
	}
	
	public void setQuestionDao(QuestionDao q)
	{
		this.questionDao=q;
	}
	
	@Override
	public void addQuestionnaire(Questionnaire q) {
		this.questionnaireDao.add(q);
		
	}
	

	@Override
	public void addQuestionToQuestionnaire(Question q, Questionnaire questionnaire) {
		questionnaire.addQuestion(q);
		this.questionDao.add(q);
		this.questionnaireDao.saveOrUpdate(questionnaire);

	}

	@Override
	public void removeQuestionFromQuestionnaire(Question q, Questionnaire questionnaire) {
		questionnaire.removeQuestion(q);
		this.questionDao.remove(q);
		this.questionnaireDao.saveOrUpdate(questionnaire);
		
	}

	@Override
	public List<Question> getQuestions(Questionnaire q) {
		return q.getQuestions();
	}

	@Override
	public void removeQuestionnaire(Questionnaire questionnaire) {
		this.questionnaireDao.remove(questionnaire);
		
	}

	@Override
	public List<Questionnaire> getQuestionnaires() {
		return this.questionnaireDao.getAll();
	}

	@Override
	public void removeQuestionnaire(Long idquestionnaire) {
		Questionnaire q=questionnaireDao.find(idquestionnaire);
		if (q!=null)questionnaireDao.remove(q);
		
	}

	@Override
	public void addQuestionToQuestionnaire(Question q, Long idquestionnaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeQuestionFromQuestionnaire(Question q, Long idquestionnaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> getQuestions(Long idquestionnaire) {
		Questionnaire q=questionnaireDao.find(idquestionnaire);
		return q.getQuestions();
	}

	@Override
	public void saveQuestionnaire(Questionnaire q) {
		questionnaireDao.saveOrUpdate(q);
		
	}

	@Override
	public Questionnaire getQuestionnaire(Long idquestionnaire) {
		return questionnaireDao.find(idquestionnaire);
	}

}
