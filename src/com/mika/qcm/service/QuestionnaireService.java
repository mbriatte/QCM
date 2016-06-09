package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Question;
import com.mika.qcm.model.Questionnaire;

public interface QuestionnaireService {
	void addQuestionnaire(Questionnaire q);
	void saveQuestionnaire(Questionnaire q);
	void removeQuestionnaire(Questionnaire questionnaire);
	void removeQuestionnaire(Long idquestionnaire);
	List<Questionnaire> getQuestionnaires();
	Questionnaire getQuestionnaire(Long idquestionnaire);
	
	void addQuestionToQuestionnaire(Question q, Questionnaire questionnaire);
	void addQuestionToQuestionnaire(Question q, Long idquestionnaire);
	void removeQuestionFromQuestionnaire(Question q, Questionnaire questionnaire);
	void removeQuestionFromQuestionnaire(Question q, Long idquestionnaire);
	List<Question> getQuestions(Questionnaire q);
	List<Question> getQuestions(Long idquestionnaire);
	//void addPropositionToQuestionnaire(Proposition p, Question q);
	
}
