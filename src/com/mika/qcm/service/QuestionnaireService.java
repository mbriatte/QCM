package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.QuestionVO;
import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.model.QuestionnaireVO;

public interface QuestionnaireService {
	void addQuestionnaire(Questionnaire q);
	void saveQuestionnaire(Questionnaire q);
	
	void removeQuestionnaire(Long idquestionnaire);
	
	List<Questionnaire> getQuestionnaires();
	Questionnaire getQuestionnaire(Long idquestionnaire);
	Questionnaire getQuestionnaireByName(String questionnaire);
	Questionnaire getQuestionnaireWithAssociationByName(String questionnaire);
	
	
	void addQuestionToQuestionnaire(Question q, Long idquestionnaire);
	
	
	void removeQuestionFromQuestionnaire( Long idquestion , Long idquestionnaire);
	

	List<Question> getQuestions(Long idquestionnaire);
	
}
