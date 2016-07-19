package main.java.com.mika.qcm.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;


import main.java.com.mika.qcm.dao.QuestionDao;
import main.java.com.mika.qcm.dao.QuestionnaireDao;

import main.java.com.mika.qcm.model.Question;
import main.java.com.mika.qcm.model.Questionnaire;
import main.java.com.mika.qcm.service.QuestionnaireService;

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
		Questionnaire quest= this.getQuestionnaire(idquestionnaire);

		if (quest!=null) 
			{
			quest.addQuestion(q);
			questionnaireDao.saveOrUpdate(quest);          
			}	
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
		Questionnaire q=questionnaireDao.find(idquestionnaire);
		return q;
		
		
	}

	@Override
	public Questionnaire getQuestionnaireByName(String questionnaire) {
		 Questionnaire q= (Questionnaire) questionnaireDao.findByCriteria(Questionnaire.class, Restrictions.eq("libelle", questionnaire)).get(0);
		
		 return q;
	}

	@Override
	public Questionnaire getQuestionnaireWithAssociationByName(String questionnaire){
		 Questionnaire q= questionnaireDao.findByNameWithAssociations(questionnaire);
		 return q;
	}
	
	

	@Override
	public void removeQuestionFromQuestionnaire(Long idquestion, Long idquestionnaire) {
		Question q=questionDao.find(idquestion);
		Questionnaire quest= questionnaireDao.find(idquestionnaire);
		if (q!=null &&  quest !=null){			
			quest.removeQuestion(q);
			questionnaireDao.saveOrUpdate(quest);
			questionDao.remove(q);
		}			
	}

}
