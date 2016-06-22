package com.mika.qcm.dao;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public interface QuestionDao extends GenericDao<Question, Long>{
	 List<Question> findQuestionWithoutQuestionnaire();
}
