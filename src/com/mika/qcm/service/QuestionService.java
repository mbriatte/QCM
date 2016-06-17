package com.mika.qcm.service;

import com.mika.qcm.model.Proposition;
import com.mika.qcm.model.PropositionVO;
import com.mika.qcm.model.Question;
import com.mika.qcm.model.QuestionVO;


public interface QuestionService {
	
	void addQuestion(Question q);
	
	void removeQuestion(Long idquestion);
	

	void addPropositionToQuestion(Long idproposition, Long idquestion);
	
	void removePropositionFromQuestion(Long idproposition, Long idquestion);
	
	void saveProposition(Proposition p);
	void saveQuestion(Question q);
}
