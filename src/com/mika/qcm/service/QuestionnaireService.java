package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public interface QuestionnaireService {
	void addQuestionnaire(Questionnaire q);
	void removeQuestionnaire(Questionnaire questionnaire);
	List<Questionnaire> getQuestionnaires();
	
	void addQuestionToQuestionnaire(Question q, Questionnaire questionnaire);
	void removeQuestionFromQuestionnaire(Question q, Questionnaire questionnaire);
	List<Question> getQuestions(Questionnaire q);
	//void addPropositionToQuestionnaire(Proposition p, Question q);
	
}
