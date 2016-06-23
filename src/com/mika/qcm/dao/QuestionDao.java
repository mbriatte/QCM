package com.mika.qcm.dao;

import java.util.List;

import com.mika.qcm.model.Question;


public interface QuestionDao extends GenericDao<Question, Long>{
	
	 /**
    Obtenir les questions non li�es � un questionnaire
    @return La Liste des Questions.
	 */
	 List<Question> findQuestionWithoutQuestionnaire();
}
