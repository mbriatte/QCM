package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public interface QuestionnaireService {
	void addQuestionnaire(Questionnaire q);
	void saveQuestionnaire(Questionnaire q);
	void removeQuestionnaire(Questionnaire questionnaire);
	void removeQuestionnaire(String idquestionnaire);
	List<Questionnaire> getQuestionnaires();
	Questionnaire getQuestionnaire(String idquestionnaire);
	
	void addQuestionToQuestionnaire(Question q, Questionnaire questionnaire);
	void addQuestionToQuestionnaire(Question q, String idquestionnaire);
	void removeQuestionFromQuestionnaire(Question q, Questionnaire questionnaire);
	void removeQuestionFromQuestionnaire(Question q, String idquestionnaire);
	List<Question> getQuestions(Questionnaire q);
	List<Question> getQuestions(String idquestionnaire);
	//void addPropositionToQuestionnaire(Proposition p, Question q);
	
}
