package main.java.com.mika.qcm.dao;

import java.util.List;

import main.java.com.mika.qcm.model.Question;




public interface QuestionDao extends GenericDao<Question, Long>{
	
	 /**
    Obtenir les questions non liées é un questionnaire
    @return La Liste des Questions.
	 */
	 List<Question> findQuestionWithoutQuestionnaire();
}
