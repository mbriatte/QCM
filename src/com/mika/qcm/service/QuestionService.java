package com.mika.qcm.service;

import java.util.List;

import com.mika.qcm.model.Proposition;
import com.mika.qcm.model.PropositionVO;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.QuestionVO;


public interface QuestionService {
	
	void addQuestion(Question q);
	
	void removeQuestion(Long idquestion);
	
	List<Question> getQuestionWithoutQuestionnaire();
	
	void addPropositionToQuestion(Proposition p, Long idquestion);
	
	void removePropositionFromQuestion(Long idproposition, Long idquestion);
	
	void saveQuestion(Question q);
	
	Question getQuestion(Long id);
	
	List<Question> getQuestions();
}
