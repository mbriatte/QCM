package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.DAO.GenericDaoImpl;
import com.mika.qcm.DAO.QuestionDao;
import com.mika.qcm.DAO.QuestionnaireDao;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

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
		this.questionnaireDao.saveOrUpdate(questionnaire);
	}

	@Override
	public void removeQuestionFromQuestionnaire(Question q, Questionnaire questionnaire) {
		questionnaire.removeQuestion(q);
		this.questionnaireDao.saveOrUpdate(questionnaire);
		
	}

	@Override
	public List<Question> getQuestions(Questionnaire q) {
		return null;
	}

	@Override
	public void removeQuestionnaire(Questionnaire questionnaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Questionnaire> getQuestionnaires() {
		// TODO Auto-generated method stub
		return null;
	}

}
